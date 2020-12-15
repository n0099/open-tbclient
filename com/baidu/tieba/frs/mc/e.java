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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class e {
    private l iVr;
    private by jsa;
    private CustomMessageListener jsb = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener iBK = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iBL = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.LC(e.this.h(customResponsedMessage));
            e.this.iVr.cCf().cDF().notifyDataSetChanged();
        }
    };
    private CustomMessageListener jqi = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.iVr != null && e.this.iVr.cCa() != null && e.this.iVr.cCa().cIF() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.iVr.cCa().cIF().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.iVr.cCf().getListView().getData());
                e.this.i(str, e.this.iVr.cCb().cIW().getDataList());
                e.this.iVr.cCa().LB(str);
                if (e.this.iVr.cCf() != null && e.this.iVr.cCf().cDF() != null) {
                    e.this.iVr.cCf().cDF().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.iVr = lVar;
        this.iBK.setTag(bdUniqueId);
        this.jqi.setTag(bdUniqueId);
        this.jsb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jsb);
        MessageManager.getInstance().registerListener(this.iBK);
        MessageManager.getInstance().registerListener(this.jqi);
        this.iBL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iBL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
            return null;
        }
        return ((JSONObject) customResponsedMessage.getData()).optString("tid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (this.iVr != null && this.iVr.cCa() != null && this.iVr.cCa().cIF() != null) {
            final String h = h(customResponsedMessage);
            if (!StringUtils.isNull(h) && this.iVr.cCf() != null && this.iVr.cCf().cDF() != null) {
                final View childAt = this.iVr.cCf().getListView().getChildAt(a(h, this.iVr.cCf().getListView()));
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
                            if (e.this.iVr != null && e.this.iVr.cCf() != null && e.this.iVr.cCf().getListView() != null && e.this.iVr.cCf().cDF() != null) {
                                e.this.iVr.cCf().getListView().removeView(childAt);
                                e.this.LC(h);
                                e.this.iVr.cCf().cDF().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    LC(h);
                    this.iVr.cCf().cDF().notifyDataSetChanged();
                }
                cJq();
            }
        }
    }

    private void cJq() {
        if (this.jsa != null && this.jsa.eMe) {
            TbPageTag tbPageTag = null;
            if (this.iVr != null && this.iVr.cCf() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.eZ(this.iVr.cCf().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.jsa, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iVr != null && this.iVr.cCa() != null && this.iVr.cCa().cIF() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.iVr.cCf() != null && this.iVr.cCf().cDF() != null) {
                    final View childAt = this.iVr.cCf().getListView().getChildAt(a(optString, optString2, this.iVr.cCf().getListView()));
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
                                e.this.fb(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.iVr.cCf() != null && e.this.iVr.cCf().cDF() != null) {
                                    e.this.iVr.cCf().cDF().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    fb(optString, optString2);
                    this.iVr.cCf().cDF().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(String str, String str2) {
        ArrayList<q> threadList = this.iVr.cCa().cIF().getThreadList();
        c(str, str2, threadList);
        c(str, str2, this.iVr.cCf().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.iVr.cCa().Lz(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.iVr.cCa().LA(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.iVr.bRN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LC(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<q> threadList = this.iVr.cCa().cIF().getThreadList();
            g(str, threadList);
            g(str, this.iVr.cCf().getListView().getData());
            g(str, this.iVr.cCb().getDataList());
            this.iVr.cCa().LA(str);
            if (threadList != null && threadList.size() < 5) {
                this.iVr.bRN();
            }
        }
    }

    private void c(String str, String str2, List<q> list) {
        if (y.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (q qVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (qVar instanceof com.baidu.tieba.tbadkCore.h) {
                        arrayList.add((com.baidu.tieba.tbadkCore.h) qVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (qVar instanceof bx)) {
                    by byVar = ((bx) qVar).eCR;
                    if (byVar.getTid() != null && byVar.getTid().equals(str2)) {
                        arrayList.add(byVar);
                    }
                }
            }
            list.removeAll(arrayList);
            q qVar2 = (q) y.getItem(list, 0);
            if (qVar2 instanceof v) {
                list.remove(qVar2);
            }
        }
    }

    private void g(String str, List<q> list) {
        if (y.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (q qVar : list) {
                if (qVar instanceof bx) {
                    by byVar = ((bx) qVar).eCR;
                    if (byVar.getTid() != null && byVar.getTid().equals(str)) {
                        arrayList.add(qVar);
                    }
                }
            }
            list.removeAll(arrayList);
            q qVar2 = (q) y.getItem(list, 0);
            if (qVar2 instanceof v) {
                list.remove(qVar2);
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
                if (bdTypeRecyclerView.getItem(i2) instanceof com.baidu.tieba.tbadkCore.h) {
                    i = i2;
                }
            }
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            int i3 = 0;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getAdapter().getItemCount(); i4++) {
                q item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof bx) {
                    by byVar = ((bx) item).eCR;
                    if (byVar.getTid() != null && byVar.getTid().equals(str2)) {
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
            q item = bdTypeRecyclerView.getItem(i2);
            if (item instanceof bx) {
                by byVar = ((bx) item).eCR;
                if (byVar.getTid() != null && byVar.getTid().equals(str)) {
                    this.jsa = byVar;
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
                if (next != null && str.equals(next.eEd)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, List<q> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<q> it = list.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object bKv = ((com.baidu.tieba.InjectPlugin.a) next).bKv();
                    if ((bKv instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) bKv).eEd)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
