package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private bh fNU;
    private l fwo;
    private CustomMessageListener fNV = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener fNW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fNX = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.wr(e.this.g(customResponsedMessage));
            e.this.fwo.bjN().blc().notifyDataSetChanged();
        }
    };
    private CustomMessageListener fMd = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.fwo != null && e.this.fwo.bjI() != null && e.this.fwo.bjI().boK() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.fwo.bjI().boK().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.fwo.bjN().getListView().getData());
                e.this.i(str, e.this.fwo.bjJ().bpb().getDataList());
                e.this.fwo.bjI().wq(str);
                if (e.this.fwo.bjN() != null && e.this.fwo.bjN().blc() != null) {
                    e.this.fwo.bjN().blc().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.fwo = lVar;
        this.fNW.setTag(bdUniqueId);
        this.fMd.setTag(bdUniqueId);
        this.fNV.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fNV);
        MessageManager.getInstance().registerListener(this.fNW);
        MessageManager.getInstance().registerListener(this.fMd);
        this.fNX.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fNX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
            return null;
        }
        return ((JSONObject) customResponsedMessage.getData()).optString("tid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (this.fwo != null && this.fwo.bjI() != null && this.fwo.bjI().boK() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.fwo.bjN() != null && this.fwo.bjN().blc() != null) {
                final View childAt = this.fwo.bjN().getListView().getChildAt(a(g, this.fwo.bjN().getListView()));
                if (childAt != null) {
                    a(childAt, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.mc.e.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            if (e.this.fwo != null && e.this.fwo.bjN() != null && e.this.fwo.bjN().getListView() != null && e.this.fwo.bjN().blc() != null) {
                                e.this.fwo.bjN().getListView().removeView(childAt);
                                e.this.wr(g);
                                e.this.fwo.bjN().blc().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    wr(g);
                    this.fwo.bjN().blc().notifyDataSetChanged();
                }
                bpt();
            }
        }
    }

    private void bpt() {
        if (this.fNU != null && this.fNU.cdL) {
            com.baidu.tieba.frs.d.a.cO(this.fNU.tid, String.valueOf(this.fNU.getFid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.fwo != null && this.fwo.bjI() != null && this.fwo.bjI().boK() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.fwo.bjN() != null && this.fwo.bjN().blc() != null) {
                    final View childAt = this.fwo.bjN().getListView().getChildAt(a(optString, optString2, this.fwo.bjN().getListView()));
                    if (childAt != null) {
                        a(childAt, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.mc.e.2
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                                e.this.cM(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.fwo.bjN() != null && e.this.fwo.bjN().blc() != null) {
                                    e.this.fwo.bjN().blc().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    cM(optString, optString2);
                    this.fwo.bjN().blc().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(String str, String str2) {
        ArrayList<m> threadList = this.fwo.bjI().boK().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.fwo.bjN().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.fwo.bjI().wo(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.fwo.bjI().wp(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.fwo.aIU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wr(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<m> threadList = this.fwo.bjI().boK().getThreadList();
            g(str, threadList);
            g(str, this.fwo.bjN().getListView().getData());
            g(str, this.fwo.bjJ().getDataList());
            this.fwo.bjI().wp(str);
            if (threadList != null && threadList.size() < 5) {
                this.fwo.aIU();
            }
        }
    }

    private void b(String str, String str2, List<m> list) {
        if (v.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (mVar instanceof com.baidu.tieba.tbadkCore.g) {
                        arrayList.add((com.baidu.tieba.tbadkCore.g) mVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (mVar instanceof bg)) {
                    bh bhVar = ((bg) mVar).caz;
                    if (bhVar.getTid() != null && bhVar.getTid().equals(str2)) {
                        arrayList.add(bhVar);
                    }
                }
            }
            list.removeAll(arrayList);
            m mVar2 = (m) v.getItem(list, 0);
            if (mVar2 instanceof p) {
                list.remove(mVar2);
            }
        }
    }

    private void g(String str, List<m> list) {
        if (v.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (mVar instanceof bg) {
                    bh bhVar = ((bg) mVar).caz;
                    if (bhVar.getTid() != null && bhVar.getTid().equals(str)) {
                        arrayList.add(mVar);
                    }
                }
            }
            list.removeAll(arrayList);
            m mVar2 = (m) v.getItem(list, 0);
            if (mVar2 instanceof p) {
                list.remove(mVar2);
            }
        }
    }

    private int a(String str, String str2, BdTypeRecyclerView bdTypeRecyclerView) {
        int i;
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            i = 0;
            for (int i2 = 0; i2 < bdTypeRecyclerView.getAdapter().getItemCount(); i2++) {
                if (bdTypeRecyclerView.getItem(i2) instanceof com.baidu.tieba.tbadkCore.g) {
                    i = i2;
                }
            }
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            int i3 = 0;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getAdapter().getItemCount(); i4++) {
                m item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof bg) {
                    bh bhVar = ((bg) item).caz;
                    if (bhVar.getTid() != null && bhVar.getTid().equals(str2)) {
                        i3 = i4;
                    }
                }
            }
            i = i3;
        } else {
            i = 0;
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    private int a(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        int i = 0;
        for (int i2 = 0; i2 < bdTypeRecyclerView.getAdapter().getItemCount(); i2++) {
            m item = bdTypeRecyclerView.getItem(i2);
            if (item instanceof bg) {
                bh bhVar = ((bg) item).caz;
                if (bhVar.getTid() != null && bhVar.getTid().equals(str)) {
                    this.fNU = bhVar;
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    private void a(final View view, Animation.AnimationListener animationListener) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.frs.mc.e.6
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                view.getLayoutParams().height = measuredHeight - ((int) (measuredHeight * f));
                view.requestLayout();
            }

            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setAnimationListener(animationListener);
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.bWt)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, List<m> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<m> it = list.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object aAV = ((com.baidu.tieba.InjectPlugin.a) next).aAV();
                    if ((aAV instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aAV).bWt)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
