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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class e {
    private l icp;
    private bw iww;
    private CustomMessageListener iwx = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener hII = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener hIJ = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.Jr(e.this.h(customResponsedMessage));
            e.this.icp.cpf().cqE().notifyDataSetChanged();
        }
    };
    private CustomMessageListener iuE = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.icp != null && e.this.icp.cpa() != null && e.this.icp.cpa().cuI() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.icp.cpa().cuI().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.icp.cpf().getListView().getData());
                e.this.i(str, e.this.icp.cpb().cuZ().getDataList());
                e.this.icp.cpa().Jq(str);
                if (e.this.icp.cpf() != null && e.this.icp.cpf().cqE() != null) {
                    e.this.icp.cpf().cqE().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.icp = lVar;
        this.hII.setTag(bdUniqueId);
        this.iuE.setTag(bdUniqueId);
        this.iwx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iwx);
        MessageManager.getInstance().registerListener(this.hII);
        MessageManager.getInstance().registerListener(this.iuE);
        this.hIJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hIJ);
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
        if (this.icp != null && this.icp.cpa() != null && this.icp.cpa().cuI() != null) {
            final String h = h(customResponsedMessage);
            if (!StringUtils.isNull(h) && this.icp.cpf() != null && this.icp.cpf().cqE() != null) {
                final View childAt = this.icp.cpf().getListView().getChildAt(a(h, this.icp.cpf().getListView()));
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
                            if (e.this.icp != null && e.this.icp.cpf() != null && e.this.icp.cpf().getListView() != null && e.this.icp.cpf().cqE() != null) {
                                e.this.icp.cpf().getListView().removeView(childAt);
                                e.this.Jr(h);
                                e.this.icp.cpf().cqE().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    Jr(h);
                    this.icp.cpf().cqE().notifyDataSetChanged();
                }
                cvt();
            }
        }
    }

    private void cvt() {
        if (this.iww != null && this.iww.egp) {
            TbPageTag tbPageTag = null;
            if (this.icp != null && this.icp.cpf() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.em(this.icp.cpf().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.iww, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.icp != null && this.icp.cpa() != null && this.icp.cpa().cuI() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.icp.cpf() != null && this.icp.cpf().cqE() != null) {
                    final View childAt = this.icp.cpf().getListView().getChildAt(a(optString, optString2, this.icp.cpf().getListView()));
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
                                e.this.eJ(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.icp.cpf() != null && e.this.icp.cpf().cqE() != null) {
                                    e.this.icp.cpf().cqE().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    eJ(optString, optString2);
                    this.icp.cpf().cqE().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(String str, String str2) {
        ArrayList<q> threadList = this.icp.cpa().cuI().getThreadList();
        c(str, str2, threadList);
        c(str, str2, this.icp.cpf().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.icp.cpa().Jo(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.icp.cpa().Jp(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.icp.bGU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jr(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<q> threadList = this.icp.cpa().cuI().getThreadList();
            g(str, threadList);
            g(str, this.icp.cpf().getListView().getData());
            g(str, this.icp.cpb().getDataList());
            this.icp.cpa().Jp(str);
            if (threadList != null && threadList.size() < 5) {
                this.icp.bGU();
            }
        }
    }

    private void c(String str, String str2, List<q> list) {
        if (y.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (q qVar : list) {
                if (str.equals("ala_frs_stage_live_feed_back_type")) {
                    if (qVar instanceof com.baidu.tieba.tbadkCore.h) {
                        arrayList.add((com.baidu.tieba.tbadkCore.h) qVar);
                    }
                } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (qVar instanceof bv)) {
                    bw bwVar = ((bv) qVar).dXg;
                    if (bwVar.getTid() != null && bwVar.getTid().equals(str2)) {
                        arrayList.add(bwVar);
                    }
                }
            }
            list.removeAll(arrayList);
            q qVar2 = (q) y.getItem(list, 0);
            if (qVar2 instanceof w) {
                list.remove(qVar2);
            }
        }
    }

    private void g(String str, List<q> list) {
        if (y.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (q qVar : list) {
                if (qVar instanceof bv) {
                    bw bwVar = ((bv) qVar).dXg;
                    if (bwVar.getTid() != null && bwVar.getTid().equals(str)) {
                        arrayList.add(qVar);
                    }
                }
            }
            list.removeAll(arrayList);
            q qVar2 = (q) y.getItem(list, 0);
            if (qVar2 instanceof w) {
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
                if (item instanceof bv) {
                    bw bwVar = ((bv) item).dXg;
                    if (bwVar.getTid() != null && bwVar.getTid().equals(str2)) {
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
            if (item instanceof bv) {
                bw bwVar = ((bv) item).dXg;
                if (bwVar.getTid() != null && bwVar.getTid().equals(str)) {
                    this.iww = bwVar;
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
                if (next != null && str.equals(next.dYt)) {
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
                    Object bAy = ((com.baidu.tieba.InjectPlugin.a) next).bAy();
                    if ((bAy instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) bAy).dYt)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
