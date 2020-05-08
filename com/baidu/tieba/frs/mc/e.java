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
    private l ham;
    private bj hsf;
    private CustomMessageListener hsg = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener gHs = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener gHt = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.Du(e.this.h(customResponsedMessage));
            e.this.ham.bOv().bPP().notifyDataSetChanged();
        }
    };
    private CustomMessageListener hqk = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.ham != null && e.this.ham.bOq() != null && e.this.ham.bOq().bTu() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.ham.bOq().bTu().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.ham.bOv().getListView().getData());
                e.this.i(str, e.this.ham.bOr().bTL().getDataList());
                e.this.ham.bOq().Dt(str);
                if (e.this.ham.bOv() != null && e.this.ham.bOv().bPP() != null) {
                    e.this.ham.bOv().bPP().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.ham = lVar;
        this.gHs.setTag(bdUniqueId);
        this.hqk.setTag(bdUniqueId);
        this.hsg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hsg);
        MessageManager.getInstance().registerListener(this.gHs);
        MessageManager.getInstance().registerListener(this.hqk);
        this.gHt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gHt);
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
        if (this.ham != null && this.ham.bOq() != null && this.ham.bOq().bTu() != null) {
            final String h = h(customResponsedMessage);
            if (!StringUtils.isNull(h) && this.ham.bOv() != null && this.ham.bOv().bPP() != null) {
                final View childAt = this.ham.bOv().getListView().getChildAt(a(h, this.ham.bOv().getListView()));
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
                            if (e.this.ham != null && e.this.ham.bOv() != null && e.this.ham.bOv().getListView() != null && e.this.ham.bOv().bPP() != null) {
                                e.this.ham.bOv().getListView().removeView(childAt);
                                e.this.Du(h);
                                e.this.ham.bOv().bPP().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    Du(h);
                    this.ham.bOv().bPP().notifyDataSetChanged();
                }
                bUe();
            }
        }
    }

    private void bUe() {
        if (this.hsf != null && this.hsf.dtP) {
            TbPageTag tbPageTag = null;
            if (this.ham != null && this.ham.bOv() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.dE(this.ham.bOv().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.hsf, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ham != null && this.ham.bOq() != null && this.ham.bOq().bTu() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.ham.bOv() != null && this.ham.bOv().bPP() != null) {
                    final View childAt = this.ham.bOv().getListView().getChildAt(a(optString, optString2, this.ham.bOv().getListView()));
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
                                if (e.this.ham.bOv() != null && e.this.ham.bOv().bPP() != null) {
                                    e.this.ham.bOv().bPP().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    dE(optString, optString2);
                    this.ham.bOv().bPP().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.ham.bOq().bTu().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.ham.bOv().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.ham.bOq().Dr(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.ham.bOq().Ds(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.ham.bkZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Du(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.ham.bOq().bTu().getThreadList();
            g(str, threadList);
            g(str, this.ham.bOv().getListView().getData());
            g(str, this.ham.bOr().getDataList());
            this.ham.bOq().Ds(str);
            if (threadList != null && threadList.size() < 5) {
                this.ham.bkZ();
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
                    bj bjVar = ((bi) mVar).dqE;
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
                    bj bjVar = ((bi) mVar).dqE;
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
                    bj bjVar = ((bi) item).dqE;
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
                bj bjVar = ((bi) item).dqE;
                if (bjVar.getTid() != null && bjVar.getTid().equals(str)) {
                    this.hsf = bjVar;
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
                if (next != null && str.equals(next.dms)) {
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
                    Object bdJ = ((com.baidu.tieba.InjectPlugin.a) next).bdJ();
                    if ((bdJ instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) bdJ).dms)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
