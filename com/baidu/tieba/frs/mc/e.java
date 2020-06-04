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
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    private bk hHG;
    private l hpl;
    private CustomMessageListener hHH = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener gWm = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener gWn = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.Fd(e.this.h(customResponsedMessage));
            e.this.hpl.bUT().bWo().notifyDataSetChanged();
        }
    };
    private CustomMessageListener hFL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.hpl != null && e.this.hpl.bUO() != null && e.this.hpl.bUO().bZZ() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.hpl.bUO().bZZ().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.hpl.bUT().getListView().getData());
                e.this.i(str, e.this.hpl.bUP().caq().getDataList());
                e.this.hpl.bUO().Fc(str);
                if (e.this.hpl.bUT() != null && e.this.hpl.bUT().bWo() != null) {
                    e.this.hpl.bUT().bWo().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.hpl = lVar;
        this.gWm.setTag(bdUniqueId);
        this.hFL.setTag(bdUniqueId);
        this.hHH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hHH);
        MessageManager.getInstance().registerListener(this.gWm);
        MessageManager.getInstance().registerListener(this.hFL);
        this.gWn.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gWn);
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
        if (this.hpl != null && this.hpl.bUO() != null && this.hpl.bUO().bZZ() != null) {
            final String h = h(customResponsedMessage);
            if (!StringUtils.isNull(h) && this.hpl.bUT() != null && this.hpl.bUT().bWo() != null) {
                final View childAt = this.hpl.bUT().getListView().getChildAt(a(h, this.hpl.bUT().getListView()));
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
                            if (e.this.hpl != null && e.this.hpl.bUT() != null && e.this.hpl.bUT().getListView() != null && e.this.hpl.bUT().bWo() != null) {
                                e.this.hpl.bUT().getListView().removeView(childAt);
                                e.this.Fd(h);
                                e.this.hpl.bUT().bWo().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    Fd(h);
                    this.hpl.bUT().bWo().notifyDataSetChanged();
                }
                caK();
            }
        }
    }

    private void caK() {
        if (this.hHG != null && this.hHG.dHI) {
            TbPageTag tbPageTag = null;
            if (this.hpl != null && this.hpl.bUT() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.dV(this.hpl.bUT().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.hHG, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hpl != null && this.hpl.bUO() != null && this.hpl.bUO().bZZ() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.hpl.bUT() != null && this.hpl.bUT().bWo() != null) {
                    final View childAt = this.hpl.bUT().getListView().getChildAt(a(optString, optString2, this.hpl.bUT().getListView()));
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
                                e.this.ef(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.hpl.bUT() != null && e.this.hpl.bUT().bWo() != null) {
                                    e.this.hpl.bUT().bWo().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    ef(optString, optString2);
                    this.hpl.bUT().bWo().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ef(String str, String str2) {
        ArrayList<o> threadList = this.hpl.bUO().bZZ().getThreadList();
        c(str, str2, threadList);
        c(str, str2, this.hpl.bUT().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.hpl.bUO().Fa(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.hpl.bUO().Fb(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.hpl.bqx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<o> threadList = this.hpl.bUO().bZZ().getThreadList();
            g(str, threadList);
            g(str, this.hpl.bUT().getListView().getData());
            g(str, this.hpl.bUP().getDataList());
            this.hpl.bUO().Fb(str);
            if (threadList != null && threadList.size() < 5) {
                this.hpl.bqx();
            }
        }
    }

    private void c(String str, String str2, List<o> list) {
        if (v.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (o oVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (oVar instanceof com.baidu.tieba.tbadkCore.h) {
                        arrayList.add((com.baidu.tieba.tbadkCore.h) oVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (oVar instanceof bj)) {
                    bk bkVar = ((bj) oVar).dEA;
                    if (bkVar.getTid() != null && bkVar.getTid().equals(str2)) {
                        arrayList.add(bkVar);
                    }
                }
            }
            list.removeAll(arrayList);
            o oVar2 = (o) v.getItem(list, 0);
            if (oVar2 instanceof t) {
                list.remove(oVar2);
            }
        }
    }

    private void g(String str, List<o> list) {
        if (v.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (o oVar : list) {
                if (oVar instanceof bj) {
                    bk bkVar = ((bj) oVar).dEA;
                    if (bkVar.getTid() != null && bkVar.getTid().equals(str)) {
                        arrayList.add(oVar);
                    }
                }
            }
            list.removeAll(arrayList);
            o oVar2 = (o) v.getItem(list, 0);
            if (oVar2 instanceof t) {
                list.remove(oVar2);
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
                o item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof bj) {
                    bk bkVar = ((bj) item).dEA;
                    if (bkVar.getTid() != null && bkVar.getTid().equals(str2)) {
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
            o item = bdTypeRecyclerView.getItem(i2);
            if (item instanceof bj) {
                bk bkVar = ((bj) item).dEA;
                if (bkVar.getTid() != null && bkVar.getTid().equals(str)) {
                    this.hHG = bkVar;
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
                if (next != null && str.equals(next.dAu)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, List<o> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<o> it = list.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object bjW = ((com.baidu.tieba.InjectPlugin.a) next).bjW();
                    if ((bjW instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) bjW).dAu)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
