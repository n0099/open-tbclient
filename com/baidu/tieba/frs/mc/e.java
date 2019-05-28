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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private CustomMessageListener fHN = new CustomMessageListener(2921324) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener fHO = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fHP = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.wS(e.this.g(customResponsedMessage));
            e.this.fqH.bjP().blc().notifyDataSetChanged();
        }
    };
    private CustomMessageListener fHQ = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.fqH != null && e.this.fqH.bjK() != null && e.this.fqH.bjK().boI() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.fqH.bjK().boI().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.fqH.bjP().getListView().getData());
                e.this.i(str, e.this.fqH.bjL().boY().getDataList());
                e.this.fqH.bjK().wR(str);
                if (e.this.fqH.bjP() != null && e.this.fqH.bjP().blc() != null) {
                    e.this.fqH.bjP().blc().notifyDataSetChanged();
                }
            }
        }
    };
    private l fqH;

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.fqH = lVar;
        this.fHO.setTag(bdUniqueId);
        this.fHQ.setTag(bdUniqueId);
        this.fHN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fHN);
        MessageManager.getInstance().registerListener(this.fHO);
        MessageManager.getInstance().registerListener(this.fHQ);
        this.fHP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fHP);
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
        if (this.fqH != null && this.fqH.bjK() != null && this.fqH.bjK().boI() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.fqH.bjP() != null && this.fqH.bjP().blc() != null) {
                final View childAt = this.fqH.bjP().getListView().getChildAt(a(g, this.fqH.bjP().getListView()));
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
                            if (e.this.fqH != null && e.this.fqH.bjP() != null && e.this.fqH.bjP().getListView() != null && e.this.fqH.bjP().blc() != null) {
                                e.this.fqH.bjP().getListView().removeView(childAt);
                                e.this.wS(g);
                                e.this.fqH.bjP().blc().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                wS(g);
                this.fqH.bjP().blc().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.fqH != null && this.fqH.bjK() != null && this.fqH.bjK().boI() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.fqH.bjP() != null && this.fqH.bjP().blc() != null) {
                    final View childAt = this.fqH.bjP().getListView().getChildAt(a(optString, optString2, this.fqH.bjP().getListView()));
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
                                e.this.cZ(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.fqH.bjP() != null && e.this.fqH.bjP().blc() != null) {
                                    e.this.fqH.bjP().blc().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    cZ(optString, optString2);
                    this.fqH.bjP().blc().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(String str, String str2) {
        ArrayList<m> threadList = this.fqH.bjK().boI().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.fqH.bjP().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.fqH.bjK().wP(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.fqH.bjK().wQ(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.fqH.aHt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wS(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<m> threadList = this.fqH.bjK().boI().getThreadList();
            g(str, threadList);
            g(str, this.fqH.bjP().getListView().getData());
            g(str, this.fqH.bjL().getDataList());
            this.fqH.bjK().wQ(str);
            if (threadList != null && threadList.size() < 5) {
                this.fqH.aHt();
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
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (mVar instanceof bf)) {
                    bg bgVar = ((bf) mVar).threadData;
                    if (bgVar.getTid() != null && bgVar.getTid().equals(str2)) {
                        arrayList.add(bgVar);
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

    private void g(String str, List<m> list) {
        if (v.Z(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (mVar instanceof bf) {
                    bg bgVar = ((bf) mVar).threadData;
                    if (bgVar.getTid() != null && bgVar.getTid().equals(str)) {
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
                if (item instanceof bf) {
                    bg bgVar = ((bf) item).threadData;
                    if (bgVar.getTid() != null && bgVar.getTid().equals(str2)) {
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
            if (item instanceof bf) {
                bg bgVar = ((bf) item).threadData;
                if (bgVar.getTid() != null && bgVar.getTid().equals(str)) {
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
                if (next != null && str.equals(next.bDS)) {
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
                    Object azj = ((com.baidu.tieba.InjectPlugin.a) next).azj();
                    if ((azj instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) azj).bDS)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
