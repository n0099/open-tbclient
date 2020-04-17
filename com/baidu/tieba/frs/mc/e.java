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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    private l hag;
    private bj hrZ;
    private CustomMessageListener hsa = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener gHm = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener gHn = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.Dr(e.this.h(customResponsedMessage));
            e.this.hag.bOx().bPR().notifyDataSetChanged();
        }
    };
    private CustomMessageListener hqe = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hag != null && e.this.hag.bOs() != null && e.this.hag.bOs().bTw() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.hag.bOs().bTw().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.hag.bOx().getListView().getData());
                e.this.i(str, e.this.hag.bOt().bTN().getDataList());
                e.this.hag.bOs().Dq(str);
                if (e.this.hag.bOx() != null && e.this.hag.bOx().bPR() != null) {
                    e.this.hag.bOx().bPR().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.hag = lVar;
        this.gHm.setTag(bdUniqueId);
        this.hqe.setTag(bdUniqueId);
        this.hsa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hsa);
        MessageManager.getInstance().registerListener(this.gHm);
        MessageManager.getInstance().registerListener(this.hqe);
        this.gHn.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gHn);
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
        if (this.hag != null && this.hag.bOs() != null && this.hag.bOs().bTw() != null) {
            final String h = h(customResponsedMessage);
            if (!StringUtils.isNull(h) && this.hag.bOx() != null && this.hag.bOx().bPR() != null) {
                final View childAt = this.hag.bOx().getListView().getChildAt(a(h, this.hag.bOx().getListView()));
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
                            if (e.this.hag != null && e.this.hag.bOx() != null && e.this.hag.bOx().getListView() != null && e.this.hag.bOx().bPR() != null) {
                                e.this.hag.bOx().getListView().removeView(childAt);
                                e.this.Dr(h);
                                e.this.hag.bOx().bPR().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    Dr(h);
                    this.hag.bOx().bPR().notifyDataSetChanged();
                }
                bUg();
            }
        }
    }

    private void bUg() {
        if (this.hrZ != null && this.hrZ.dtL) {
            TbPageTag tbPageTag = null;
            if (this.hag != null && this.hag.bOx() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.dQ(this.hag.bOx().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.hrZ, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hag != null && this.hag.bOs() != null && this.hag.bOs().bTw() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.hag.bOx() != null && this.hag.bOx().bPR() != null) {
                    final View childAt = this.hag.bOx().getListView().getChildAt(a(optString, optString2, this.hag.bOx().getListView()));
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
                                e.this.dE(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.hag.bOx() != null && e.this.hag.bOx().bPR() != null) {
                                    e.this.hag.bOx().bPR().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    dE(optString, optString2);
                    this.hag.bOx().bPR().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.hag.bOs().bTw().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.hag.bOx().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.hag.bOs().Do(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.hag.bOs().Dp(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.hag.blb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dr(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.hag.bOs().bTw().getThreadList();
            g(str, threadList);
            g(str, this.hag.bOx().getListView().getData());
            g(str, this.hag.bOt().getDataList());
            this.hag.bOs().Dp(str);
            if (threadList != null && threadList.size() < 5) {
                this.hag.blb();
            }
        }
    }

    private void b(String str, String str2, List<com.baidu.adp.widget.ListView.m> list) {
        if (v.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (mVar instanceof com.baidu.tieba.tbadkCore.h) {
                        arrayList.add((com.baidu.tieba.tbadkCore.h) mVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (mVar instanceof bi)) {
                    bj bjVar = ((bi) mVar).dqA;
                    if (bjVar.getTid() != null && bjVar.getTid().equals(str2)) {
                        arrayList.add(bjVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) v.getItem(list, 0);
            if (mVar2 instanceof t) {
                list.remove(mVar2);
            }
        }
    }

    private void g(String str, List<com.baidu.adp.widget.ListView.m> list) {
        if (v.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar instanceof bi) {
                    bj bjVar = ((bi) mVar).dqA;
                    if (bjVar.getTid() != null && bjVar.getTid().equals(str)) {
                        arrayList.add(mVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) v.getItem(list, 0);
            if (mVar2 instanceof t) {
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
                if (bdTypeRecyclerView.getItem(i2) instanceof com.baidu.tieba.tbadkCore.h) {
                    i = i2;
                }
            }
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            int i3 = 0;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getAdapter().getItemCount(); i4++) {
                com.baidu.adp.widget.ListView.m item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof bi) {
                    bj bjVar = ((bi) item).dqA;
                    if (bjVar.getTid() != null && bjVar.getTid().equals(str2)) {
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
            com.baidu.adp.widget.ListView.m item = bdTypeRecyclerView.getItem(i2);
            if (item instanceof bi) {
                bj bjVar = ((bi) item).dqA;
                if (bjVar.getTid() != null && bjVar.getTid().equals(str)) {
                    this.hrZ = bjVar;
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
                if (next != null && str.equals(next.dmo)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, List<com.baidu.adp.widget.ListView.m> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object bdL = ((com.baidu.tieba.InjectPlugin.a) next).bdL();
                    if ((bdL instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) bdL).dmo)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
