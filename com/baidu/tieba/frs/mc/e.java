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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private cb jFH;
    private l jiR;
    private CustomMessageListener jFI = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener iPl = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iPm = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.Ld(e.this.h(customResponsedMessage));
            e.this.jiR.cCB().cEb().notifyDataSetChanged();
        }
    };
    private CustomMessageListener jpA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jiR != null && e.this.jiR.cCw() != null && e.this.jiR.cCw().cJi() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.jiR.cCw().cJi().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.jiR.cCB().getListView().getData());
                e.this.i(str, e.this.jiR.cCx().cJz().getDataList());
                e.this.jiR.cCw().Lc(str);
                if (e.this.jiR.cCB() != null && e.this.jiR.cCB().cEb() != null) {
                    e.this.jiR.cCB().cEb().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.jiR = lVar;
        this.iPl.setTag(bdUniqueId);
        this.jpA.setTag(bdUniqueId);
        this.jFI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jFI);
        MessageManager.getInstance().registerListener(this.iPl);
        MessageManager.getInstance().registerListener(this.jpA);
        this.iPm.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iPm);
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
        if (this.jiR != null && this.jiR.cCw() != null && this.jiR.cCw().cJi() != null) {
            final String h = h(customResponsedMessage);
            if (!StringUtils.isNull(h) && this.jiR.cCB() != null && this.jiR.cCB().cEb() != null) {
                final View childAt = this.jiR.cCB().getListView().getChildAt(a(h, this.jiR.cCB().getListView()));
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
                            if (e.this.jiR != null && e.this.jiR.cCB() != null && e.this.jiR.cCB().getListView() != null && e.this.jiR.cCB().cEb() != null) {
                                e.this.jiR.cCB().getListView().removeView(childAt);
                                e.this.Ld(h);
                                e.this.jiR.cCB().cEb().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    Ld(h);
                    this.jiR.cCB().cEb().notifyDataSetChanged();
                }
                cJT();
            }
        }
    }

    private void cJT() {
        if (this.jFH != null && this.jFH.eTA) {
            TbPageTag tbPageTag = null;
            if (this.jiR != null && this.jiR.cCB() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.fs(this.jiR.cCB().getContext());
            }
            com.baidu.tieba.frs.b.a.a(this.jFH, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jiR != null && this.jiR.cCw() != null && this.jiR.cCw().cJi() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.jiR.cCB() != null && this.jiR.cCB().cEb() != null) {
                    final View childAt = this.jiR.cCB().getListView().getChildAt(a(optString, optString2, this.jiR.cCB().getListView()));
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
                                if (e.this.jiR.cCB() != null && e.this.jiR.cCB().cEb() != null) {
                                    e.this.jiR.cCB().cEb().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    fb(optString, optString2);
                    this.jiR.cCB().cEb().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jiR.cCw().cJi().getThreadList();
        c(str, str2, threadList);
        c(str, str2, this.jiR.cCB().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.jiR.cCw().La(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.jiR.cCw().Lb(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.jiR.bRj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ld(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jiR.cCw().cJi().getThreadList();
            g(str, threadList);
            g(str, this.jiR.cCB().getListView().getData());
            g(str, this.jiR.cCx().getDataList());
            this.jiR.cCw().Lb(str);
            if (threadList != null && threadList.size() < 5) {
                this.jiR.bRj();
            }
        }
    }

    private void c(String str, String str2, List<com.baidu.adp.widget.ListView.n> list) {
        if (y.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.n nVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (nVar instanceof com.baidu.tieba.tbadkCore.h) {
                        arrayList.add((com.baidu.tieba.tbadkCore.h) nVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (nVar instanceof ca)) {
                    cb cbVar = ((ca) nVar).eJQ;
                    if (cbVar.getTid() != null && cbVar.getTid().equals(str2)) {
                        arrayList.add(cbVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) y.getItem(list, 0);
            if (nVar2 instanceof u) {
                list.remove(nVar2);
            }
        }
    }

    private void g(String str, List<com.baidu.adp.widget.ListView.n> list) {
        if (y.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.n nVar : list) {
                if (nVar instanceof ca) {
                    cb cbVar = ((ca) nVar).eJQ;
                    if (cbVar.getTid() != null && cbVar.getTid().equals(str)) {
                        arrayList.add(nVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) y.getItem(list, 0);
            if (nVar2 instanceof u) {
                list.remove(nVar2);
            }
        }
    }

    private int a(String str, String str2, BdTypeRecyclerView bdTypeRecyclerView) {
        int i;
        int i2;
        int i3 = 0;
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            int i4 = 0;
            while (true) {
                i = i3;
                if (i4 >= bdTypeRecyclerView.getAdapter().getItemCount()) {
                    break;
                }
                i3 = bdTypeRecyclerView.getItem(i4) instanceof com.baidu.tieba.tbadkCore.h ? i4 : i;
                i4++;
            }
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            int i5 = 0;
            int i6 = 0;
            while (i5 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                com.baidu.adp.widget.ListView.n item = bdTypeRecyclerView.getItem(i5);
                if (item instanceof ca) {
                    cb cbVar = ((ca) item).eJQ;
                    if (cbVar.getTid() != null && cbVar.getTid().equals(str2)) {
                        i2 = i5;
                        i5++;
                        i6 = i2;
                    }
                }
                i2 = i6;
                i5++;
                i6 = i2;
            }
            i = i6;
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
            com.baidu.adp.widget.ListView.n item = bdTypeRecyclerView.getItem(i2);
            if (item instanceof ca) {
                cb cbVar = ((ca) item).eJQ;
                if (cbVar.getTid() != null && cbVar.getTid().equals(str)) {
                    this.jFH = cbVar;
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
                if (next != null && str.equals(next.eLt)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, List<com.baidu.adp.widget.ListView.n> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.n> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object bJv = ((com.baidu.tieba.InjectPlugin.a) next).bJv();
                    if ((bJv instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) bJv).eLt)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
