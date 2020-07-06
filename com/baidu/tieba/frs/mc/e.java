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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    private l hBV;
    private bu hUR;
    private CustomMessageListener hUS = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener hjb = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hjc = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.FE(e.this.h(customResponsedMessage));
            e.this.hBV.bYa().bZx().notifyDataSetChanged();
        }
    };
    private CustomMessageListener hSY = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hBV != null && e.this.hBV.bXV() != null && e.this.hBV.bXV().cdo() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.hBV.bXV().cdo().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.hBV.bYa().getListView().getData());
                e.this.i(str, e.this.hBV.bXW().cdF().getDataList());
                e.this.hBV.bXV().FD(str);
                if (e.this.hBV.bYa() != null && e.this.hBV.bYa().bZx() != null) {
                    e.this.hBV.bYa().bZx().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.hBV = lVar;
        this.hjb.setTag(bdUniqueId);
        this.hSY.setTag(bdUniqueId);
        this.hUS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hUS);
        MessageManager.getInstance().registerListener(this.hjb);
        MessageManager.getInstance().registerListener(this.hSY);
        this.hjc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hjc);
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
        if (this.hBV != null && this.hBV.bXV() != null && this.hBV.bXV().cdo() != null) {
            final String h = h(customResponsedMessage);
            if (!StringUtils.isNull(h) && this.hBV.bYa() != null && this.hBV.bYa().bZx() != null) {
                final View childAt = this.hBV.bYa().getListView().getChildAt(a(h, this.hBV.bYa().getListView()));
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
                            if (e.this.hBV != null && e.this.hBV.bYa() != null && e.this.hBV.bYa().getListView() != null && e.this.hBV.bYa().bZx() != null) {
                                e.this.hBV.bYa().getListView().removeView(childAt);
                                e.this.FE(h);
                                e.this.hBV.bYa().bZx().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    FE(h);
                    this.hBV.bYa().bZx().notifyDataSetChanged();
                }
                cdZ();
            }
        }
    }

    private void cdZ() {
        if (this.hUR != null && this.hUR.dOu) {
            TbPageTag tbPageTag = null;
            if (this.hBV != null && this.hBV.bYa() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.dW(this.hBV.bYa().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.hUR, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hBV != null && this.hBV.bXV() != null && this.hBV.bXV().cdo() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.hBV.bYa() != null && this.hBV.bYa().bZx() != null) {
                    final View childAt = this.hBV.bYa().getListView().getChildAt(a(optString, optString2, this.hBV.bYa().getListView()));
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
                                e.this.el(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.hBV.bYa() != null && e.this.hBV.bYa().bZx() != null) {
                                    e.this.hBV.bYa().bZx().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    el(optString, optString2);
                    this.hBV.bYa().bZx().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void el(String str, String str2) {
        ArrayList<q> threadList = this.hBV.bXV().cdo().getThreadList();
        c(str, str2, threadList);
        c(str, str2, this.hBV.bYa().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.hBV.bXV().FB(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.hBV.bXV().FC(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.hBV.btv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FE(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<q> threadList = this.hBV.bXV().cdo().getThreadList();
            g(str, threadList);
            g(str, this.hBV.bYa().getListView().getData());
            g(str, this.hBV.bXW().getDataList());
            this.hBV.bXV().FC(str);
            if (threadList != null && threadList.size() < 5) {
                this.hBV.btv();
            }
        }
    }

    private void c(String str, String str2, List<q> list) {
        if (w.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (q qVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (qVar instanceof com.baidu.tieba.tbadkCore.h) {
                        arrayList.add((com.baidu.tieba.tbadkCore.h) qVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (qVar instanceof bt)) {
                    bu buVar = ((bt) qVar).dLi;
                    if (buVar.getTid() != null && buVar.getTid().equals(str2)) {
                        arrayList.add(buVar);
                    }
                }
            }
            list.removeAll(arrayList);
            q qVar2 = (q) w.getItem(list, 0);
            if (qVar2 instanceof v) {
                list.remove(qVar2);
            }
        }
    }

    private void g(String str, List<q> list) {
        if (w.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (q qVar : list) {
                if (qVar instanceof bt) {
                    bu buVar = ((bt) qVar).dLi;
                    if (buVar.getTid() != null && buVar.getTid().equals(str)) {
                        arrayList.add(qVar);
                    }
                }
            }
            list.removeAll(arrayList);
            q qVar2 = (q) w.getItem(list, 0);
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
                if (item instanceof bt) {
                    bu buVar = ((bt) item).dLi;
                    if (buVar.getTid() != null && buVar.getTid().equals(str2)) {
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
            if (item instanceof bt) {
                bu buVar = ((bt) item).dLi;
                if (buVar.getTid() != null && buVar.getTid().equals(str)) {
                    this.hUR = buVar;
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
                if (next != null && str.equals(next.dGL)) {
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
                    Object bmw = ((com.baidu.tieba.InjectPlugin.a) next).bmw();
                    if ((bmw instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) bmw).dGL)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
