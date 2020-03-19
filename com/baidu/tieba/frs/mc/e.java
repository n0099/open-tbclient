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
import com.baidu.tieba.frs.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    private bj gIH;
    private l gqU;
    private CustomMessageListener gII = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener gIJ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gIK = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.BH(e.this.g(customResponsedMessage));
            e.this.gqU.bDY().bFq().notifyDataSetChanged();
        }
    };
    private CustomMessageListener gGL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gqU != null && e.this.gqU.bDT() != null && e.this.gqU.bDT().bIZ() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.gqU.bDT().bIZ().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.gqU.bDY().getListView().getData());
                e.this.i(str, e.this.gqU.bDU().bJq().getDataList());
                e.this.gqU.bDT().BG(str);
                if (e.this.gqU.bDY() != null && e.this.gqU.bDY().bFq() != null) {
                    e.this.gqU.bDY().bFq().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.gqU = lVar;
        this.gIJ.setTag(bdUniqueId);
        this.gGL.setTag(bdUniqueId);
        this.gII.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gII);
        MessageManager.getInstance().registerListener(this.gIJ);
        MessageManager.getInstance().registerListener(this.gGL);
        this.gIK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gIK);
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
        if (this.gqU != null && this.gqU.bDT() != null && this.gqU.bDT().bIZ() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.gqU.bDY() != null && this.gqU.bDY().bFq() != null) {
                final View childAt = this.gqU.bDY().getListView().getChildAt(a(g, this.gqU.bDY().getListView()));
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
                            if (e.this.gqU != null && e.this.gqU.bDY() != null && e.this.gqU.bDY().getListView() != null && e.this.gqU.bDY().bFq() != null) {
                                e.this.gqU.bDY().getListView().removeView(childAt);
                                e.this.BH(g);
                                e.this.gqU.bDY().bFq().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    BH(g);
                    this.gqU.bDY().bFq().notifyDataSetChanged();
                }
                bJJ();
            }
        }
    }

    private void bJJ() {
        if (this.gIH != null && this.gIH.cUA) {
            TbPageTag tbPageTag = null;
            if (this.gqU != null && this.gqU.bDY() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.ec(this.gqU.bDY().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.gIH, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gqU != null && this.gqU.bDT() != null && this.gqU.bDT().bIZ() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.gqU.bDY() != null && this.gqU.bDY().bFq() != null) {
                    final View childAt = this.gqU.bDY().getListView().getChildAt(a(optString, optString2, this.gqU.bDY().getListView()));
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
                                e.this.dp(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.gqU.bDY() != null && e.this.gqU.bDY().bFq() != null) {
                                    e.this.gqU.bDY().bFq().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    dp(optString, optString2);
                    this.gqU.bDY().bFq().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gqU.bDT().bIZ().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.gqU.bDY().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.gqU.bDT().BE(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.gqU.bDT().BF(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.gqU.bck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BH(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gqU.bDT().bIZ().getThreadList();
            g(str, threadList);
            g(str, this.gqU.bDY().getListView().getData());
            g(str, this.gqU.bDU().getDataList());
            this.gqU.bDT().BF(str);
            if (threadList != null && threadList.size() < 5) {
                this.gqU.bck();
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
                    bj bjVar = ((bi) mVar).cRt;
                    if (bjVar.getTid() != null && bjVar.getTid().equals(str2)) {
                        arrayList.add(bjVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) v.getItem(list, 0);
            if (mVar2 instanceof r) {
                list.remove(mVar2);
            }
        }
    }

    private void g(String str, List<com.baidu.adp.widget.ListView.m> list) {
        if (v.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar instanceof bi) {
                    bj bjVar = ((bi) mVar).cRt;
                    if (bjVar.getTid() != null && bjVar.getTid().equals(str)) {
                        arrayList.add(mVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) v.getItem(list, 0);
            if (mVar2 instanceof r) {
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
                    bj bjVar = ((bi) item).cRt;
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
                bj bjVar = ((bi) item).cRt;
                if (bjVar.getTid() != null && bjVar.getTid().equals(str)) {
                    this.gIH = bjVar;
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
                if (next != null && str.equals(next.cNk)) {
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
                    Object aVB = ((com.baidu.tieba.InjectPlugin.a) next).aVB();
                    if ((aVB instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVB).cNk)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
