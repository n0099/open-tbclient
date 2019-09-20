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
    private bh fPr;
    private l fxR;
    private CustomMessageListener fPs = new CustomMessageListener(2921324) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener fPt = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fPu = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.xZ(e.this.g(customResponsedMessage));
            e.this.fxR.bmJ().bnZ().notifyDataSetChanged();
        }
    };
    private CustomMessageListener fNB = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.fxR != null && e.this.fxR.bmE() != null && e.this.fxR.bmE().brI() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.fxR.bmE().brI().getForum().getBannerListData().getAllAdvertList());
                e.this.h(str, e.this.fxR.bmJ().getListView().getData());
                e.this.h(str, e.this.fxR.bmF().brZ().getDataList());
                e.this.fxR.bmE().xY(str);
                if (e.this.fxR.bmJ() != null && e.this.fxR.bmJ().bnZ() != null) {
                    e.this.fxR.bmJ().bnZ().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.fxR = lVar;
        this.fPt.setTag(bdUniqueId);
        this.fNB.setTag(bdUniqueId);
        this.fPs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fPs);
        MessageManager.getInstance().registerListener(this.fPt);
        MessageManager.getInstance().registerListener(this.fNB);
        this.fPu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fPu);
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
        if (this.fxR != null && this.fxR.bmE() != null && this.fxR.bmE().brI() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.fxR.bmJ() != null && this.fxR.bmJ().bnZ() != null) {
                final View childAt = this.fxR.bmJ().getListView().getChildAt(a(g, this.fxR.bmJ().getListView()));
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
                            if (e.this.fxR != null && e.this.fxR.bmJ() != null && e.this.fxR.bmJ().getListView() != null && e.this.fxR.bmJ().bnZ() != null) {
                                e.this.fxR.bmJ().getListView().removeView(childAt);
                                e.this.xZ(g);
                                e.this.fxR.bmJ().bnZ().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    xZ(g);
                    this.fxR.bmJ().bnZ().notifyDataSetChanged();
                }
                bsr();
            }
        }
    }

    private void bsr() {
        if (this.fPr != null && this.fPr.bMT) {
            com.baidu.tieba.frs.d.a.dd(this.fPr.tid, String.valueOf(this.fPr.getFid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.fxR != null && this.fxR.bmE() != null && this.fxR.bmE().brI() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.fxR.bmJ() != null && this.fxR.bmJ().bnZ() != null) {
                    final View childAt = this.fxR.bmJ().getListView().getChildAt(a(optString, optString2, this.fxR.bmJ().getListView()));
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
                                e.this.db(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.fxR.bmJ() != null && e.this.fxR.bmJ().bnZ() != null) {
                                    e.this.fxR.bmJ().bnZ().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    db(optString, optString2);
                    this.fxR.bmJ().bnZ().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(String str, String str2) {
        ArrayList<m> threadList = this.fxR.bmE().brI().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.fxR.bmJ().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.fxR.bmE().xW(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.fxR.bmE().xX(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.fxR.aJw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xZ(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<m> threadList = this.fxR.bmE().brI().getThreadList();
            f(str, threadList);
            f(str, this.fxR.bmJ().getListView().getData());
            f(str, this.fxR.bmF().getDataList());
            this.fxR.bmE().xX(str);
            if (threadList != null && threadList.size() < 5) {
                this.fxR.aJw();
            }
        }
    }

    private void b(String str, String str2, List<m> list) {
        if (v.Z(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (mVar instanceof com.baidu.tieba.tbadkCore.g) {
                        arrayList.add((com.baidu.tieba.tbadkCore.g) mVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (mVar instanceof bg)) {
                    bh bhVar = ((bg) mVar).threadData;
                    if (bhVar.getTid() != null && bhVar.getTid().equals(str2)) {
                        arrayList.add(bhVar);
                    }
                }
            }
            list.removeAll(arrayList);
            m mVar2 = (m) v.c(list, 0);
            if (mVar2 instanceof p) {
                list.remove(mVar2);
            }
        }
    }

    private void f(String str, List<m> list) {
        if (v.Z(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (mVar instanceof bg) {
                    bh bhVar = ((bg) mVar).threadData;
                    if (bhVar.getTid() != null && bhVar.getTid().equals(str)) {
                        arrayList.add(mVar);
                    }
                }
            }
            list.removeAll(arrayList);
            m mVar2 = (m) v.c(list, 0);
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
                    bh bhVar = ((bg) item).threadData;
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
                bh bhVar = ((bg) item).threadData;
                if (bhVar.getTid() != null && bhVar.getTid().equals(str)) {
                    this.fPr = bhVar;
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
    public void g(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.bFs)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, List<m> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<m> it = list.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object aAN = ((com.baidu.tieba.InjectPlugin.a) next).aAN();
                    if ((aAN instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aAN).bFs)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
