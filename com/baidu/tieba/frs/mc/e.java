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
    private cb jFt;
    private l jiD;
    private CustomMessageListener jFu = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener iOX = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener iOY = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.Lc(e.this.h(customResponsedMessage));
            e.this.jiD.cCu().cDU().notifyDataSetChanged();
        }
    };
    private CustomMessageListener jpm = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.jiD != null && e.this.jiD.cCp() != null && e.this.jiD.cCp().cJb() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.jiD.cCp().cJb().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.jiD.cCu().getListView().getData());
                e.this.i(str, e.this.jiD.cCq().cJs().getDataList());
                e.this.jiD.cCp().Lb(str);
                if (e.this.jiD.cCu() != null && e.this.jiD.cCu().cDU() != null) {
                    e.this.jiD.cCu().cDU().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.jiD = lVar;
        this.iOX.setTag(bdUniqueId);
        this.jpm.setTag(bdUniqueId);
        this.jFu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jFu);
        MessageManager.getInstance().registerListener(this.iOX);
        MessageManager.getInstance().registerListener(this.jpm);
        this.iOY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iOY);
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
        if (this.jiD != null && this.jiD.cCp() != null && this.jiD.cCp().cJb() != null) {
            final String h = h(customResponsedMessage);
            if (!StringUtils.isNull(h) && this.jiD.cCu() != null && this.jiD.cCu().cDU() != null) {
                final View childAt = this.jiD.cCu().getListView().getChildAt(a(h, this.jiD.cCu().getListView()));
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
                            if (e.this.jiD != null && e.this.jiD.cCu() != null && e.this.jiD.cCu().getListView() != null && e.this.jiD.cCu().cDU() != null) {
                                e.this.jiD.cCu().getListView().removeView(childAt);
                                e.this.Lc(h);
                                e.this.jiD.cCu().cDU().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    Lc(h);
                    this.jiD.cCu().cDU().notifyDataSetChanged();
                }
                cJM();
            }
        }
    }

    private void cJM() {
        if (this.jFt != null && this.jFt.eTA) {
            TbPageTag tbPageTag = null;
            if (this.jiD != null && this.jiD.cCu() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.fs(this.jiD.cCu().getContext());
            }
            com.baidu.tieba.frs.b.a.a(this.jFt, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jiD != null && this.jiD.cCp() != null && this.jiD.cCp().cJb() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.jiD.cCu() != null && this.jiD.cCu().cDU() != null) {
                    final View childAt = this.jiD.cCu().getListView().getChildAt(a(optString, optString2, this.jiD.cCu().getListView()));
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
                                if (e.this.jiD.cCu() != null && e.this.jiD.cCu().cDU() != null) {
                                    e.this.jiD.cCu().cDU().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    fb(optString, optString2);
                    this.jiD.cCu().cDU().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(String str, String str2) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jiD.cCp().cJb().getThreadList();
        c(str, str2, threadList);
        c(str, str2, this.jiD.cCu().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.jiD.cCp().KZ(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.jiD.cCp().La(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.jiD.bRc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lc(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jiD.cCp().cJb().getThreadList();
            g(str, threadList);
            g(str, this.jiD.cCu().getListView().getData());
            g(str, this.jiD.cCq().getDataList());
            this.jiD.cCp().La(str);
            if (threadList != null && threadList.size() < 5) {
                this.jiD.bRc();
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
                    this.jFt = cbVar;
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
                if (next != null && str.equals(next.eLu)) {
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
                    Object bJq = ((com.baidu.tieba.InjectPlugin.a) next).bJq();
                    if ((bJq instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) bJq).eLu)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
