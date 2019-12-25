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
/* loaded from: classes6.dex */
public class e {
    private bj gCh;
    private l gkL;
    private CustomMessageListener gCi = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener gCj = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gCk = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.Bg(e.this.g(customResponsedMessage));
            e.this.gkL.bBi().bCy().notifyDataSetChanged();
        }
    };
    private CustomMessageListener gAq = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gkL != null && e.this.gkL.bBd() != null && e.this.gkL.bBd().bGh() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.gkL.bBd().bGh().getForum().getBannerListData().getAllAdvertList());
                e.this.h(str, e.this.gkL.bBi().getListView().getData());
                e.this.h(str, e.this.gkL.bBe().bGx().getDataList());
                e.this.gkL.bBd().Bf(str);
                if (e.this.gkL.bBi() != null && e.this.gkL.bBi().bCy() != null) {
                    e.this.gkL.bBi().bCy().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.gkL = lVar;
        this.gCj.setTag(bdUniqueId);
        this.gAq.setTag(bdUniqueId);
        this.gCi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gCi);
        MessageManager.getInstance().registerListener(this.gCj);
        MessageManager.getInstance().registerListener(this.gAq);
        this.gCk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gCk);
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
        if (this.gkL != null && this.gkL.bBd() != null && this.gkL.bBd().bGh() != null) {
            final String g = g(customResponsedMessage);
            if (!StringUtils.isNull(g) && this.gkL.bBi() != null && this.gkL.bBi().bCy() != null) {
                final View childAt = this.gkL.bBi().getListView().getChildAt(a(g, this.gkL.bBi().getListView()));
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
                            if (e.this.gkL != null && e.this.gkL.bBi() != null && e.this.gkL.bBi().getListView() != null && e.this.gkL.bBi().bCy() != null) {
                                e.this.gkL.bBi().getListView().removeView(childAt);
                                e.this.Bg(g);
                                e.this.gkL.bBi().bCy().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    Bg(g);
                    this.gkL.bBi().bCy().notifyDataSetChanged();
                }
                bGP();
            }
        }
    }

    private void bGP() {
        if (this.gCh != null && this.gCh.cPZ) {
            TbPageTag tbPageTag = null;
            if (this.gkL != null && this.gkL.bBi() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.ea(this.gkL.bBi().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.gCh, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gkL != null && this.gkL.bBd() != null && this.gkL.bBd().bGh() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.gkL.bBi() != null && this.gkL.bBi().bCy() != null) {
                    final View childAt = this.gkL.bBi().getListView().getChildAt(a(optString, optString2, this.gkL.bBi().getListView()));
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
                                e.this.dg(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.gkL.bBi() != null && e.this.gkL.bBi().bCy() != null) {
                                    e.this.gkL.bBi().bCy().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    dg(optString, optString2);
                    this.gkL.bBi().bCy().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dg(String str, String str2) {
        ArrayList<m> threadList = this.gkL.bBd().bGh().getThreadList();
        b(str, str2, threadList);
        b(str, str2, this.gkL.bBi().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.gkL.bBd().Bd(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.gkL.bBd().Be(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.gkL.aZs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bg(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<m> threadList = this.gkL.bBd().bGh().getThreadList();
            f(str, threadList);
            f(str, this.gkL.bBi().getListView().getData());
            f(str, this.gkL.bBe().getDataList());
            this.gkL.bBd().Be(str);
            if (threadList != null && threadList.size() < 5) {
                this.gkL.aZs();
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
                    bj bjVar = ((bi) mVar).cMR;
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

    private void f(String str, List<m> list) {
        if (v.getCount(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (mVar instanceof bi) {
                    bj bjVar = ((bi) mVar).cMR;
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
                    bj bjVar = ((bi) item).cMR;
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
                bj bjVar = ((bi) item).cMR;
                if (bjVar.getTid() != null && bjVar.getTid().equals(str)) {
                    this.gCh = bjVar;
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
    public void g(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.cIG)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, List<m> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<m> it = list.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object aSJ = ((com.baidu.tieba.InjectPlugin.a) next).aSJ();
                    if ((aSJ instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aSJ).cIG)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
