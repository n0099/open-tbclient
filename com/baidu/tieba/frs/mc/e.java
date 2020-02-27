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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    private bj gHv;
    private l gpV;
    private CustomMessageListener gHw = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener gHx = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gHy = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.BG(e.this.g(customResponsedMessage));
            e.this.gpV.bDN().bFd().notifyDataSetChanged();
        }
    };
    private CustomMessageListener gFz = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gpV != null && e.this.gpV.bDI() != null && e.this.gpV.bDI().bIK() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.gpV.bDI().bIK().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.gpV.bDN().getListView().getData());
                e.this.i(str, e.this.gpV.bDJ().bJb().getDataList());
                e.this.gpV.bDI().BF(str);
                if (e.this.gpV.bDN() != null && e.this.gpV.bDN().bFd() != null) {
                    e.this.gpV.bDN().bFd().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.gpV = lVar;
        this.gHx.setTag(bdUniqueId);
        this.gFz.setTag(bdUniqueId);
        this.gHw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gHw);
        MessageManager.getInstance().registerListener(this.gHx);
        MessageManager.getInstance().registerListener(this.gFz);
        this.gHy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gHy);
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
        if (this.gpV != null && this.gpV.bDI() != null && this.gpV.bDI().bIK() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.gpV.bDN() != null && this.gpV.bDN().bFd() != null) {
                final View childAt = this.gpV.bDN().getListView().getChildAt(a(g, this.gpV.bDN().getListView()));
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
                            if (e.this.gpV != null && e.this.gpV.bDN() != null && e.this.gpV.bDN().getListView() != null && e.this.gpV.bDN().bFd() != null) {
                                e.this.gpV.bDN().getListView().removeView(childAt);
                                e.this.BG(g);
                                e.this.gpV.bDN().bFd().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    BG(g);
                    this.gpV.bDN().bFd().notifyDataSetChanged();
                }
                bJt();
            }
        }
    }

    private void bJt() {
        if (this.gHv != null && this.gHv.cUl) {
            TbPageTag tbPageTag = null;
            if (this.gpV != null && this.gpV.bDN() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.ed(this.gpV.bDN().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.gHv, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gpV != null && this.gpV.bDI() != null && this.gpV.bDI().bIK() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.gpV.bDN() != null && this.gpV.bDN().bFd() != null) {
                    final View childAt = this.gpV.bDN().getListView().getChildAt(a(optString, optString2, this.gpV.bDN().getListView()));
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
                                e.this.dr(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.gpV.bDN() != null && e.this.gpV.bDN().bFd() != null) {
                                    e.this.gpV.bDN().bFd().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    dr(optString, optString2);
                    this.gpV.bDN().bFd().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(String str, String str2) {
        ArrayList<m> threadList = this.gpV.bDI().bIK().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.gpV.bDN().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.gpV.bDI().BD(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.gpV.bDI().BE(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.gpV.bcd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BG(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<m> threadList = this.gpV.bDI().bIK().getThreadList();
            g(str, threadList);
            g(str, this.gpV.bDN().getListView().getData());
            g(str, this.gpV.bDJ().getDataList());
            this.gpV.bDI().BE(str);
            if (threadList != null && threadList.size() < 5) {
                this.gpV.bcd();
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
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (mVar instanceof bi)) {
                    bj bjVar = ((bi) mVar).cRe;
                    if (bjVar.getTid() != null && bjVar.getTid().equals(str2)) {
                        arrayList.add(bjVar);
                    }
                }
            }
            list.removeAll(arrayList);
            m mVar2 = (m) v.getItem(list, 0);
            if (mVar2 instanceof q) {
                list.remove(mVar2);
            }
        }
    }

    private void g(String str, List<m> list) {
        if (v.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (mVar instanceof bi) {
                    bj bjVar = ((bi) mVar).cRe;
                    if (bjVar.getTid() != null && bjVar.getTid().equals(str)) {
                        arrayList.add(mVar);
                    }
                }
            }
            list.removeAll(arrayList);
            m mVar2 = (m) v.getItem(list, 0);
            if (mVar2 instanceof q) {
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
                if (item instanceof bi) {
                    bj bjVar = ((bi) item).cRe;
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
            m item = bdTypeRecyclerView.getItem(i2);
            if (item instanceof bi) {
                bj bjVar = ((bi) item).cRe;
                if (bjVar.getTid() != null && bjVar.getTid().equals(str)) {
                    this.gHv = bjVar;
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
                if (next != null && str.equals(next.cMV)) {
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
                    Object aVu = ((com.baidu.tieba.InjectPlugin.a) next).aVu();
                    if ((aVu instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVu).cMV)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
