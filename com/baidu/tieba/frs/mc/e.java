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
/* loaded from: classes22.dex */
public class e {
    private l iDM;
    private bw iXL;
    private CustomMessageListener iXM = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.i(customResponsedMessage);
        }
    };
    private CustomMessageListener ikd = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.g(customResponsedMessage);
        }
    };
    private CustomMessageListener ike = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.KD(e.this.h(customResponsedMessage));
            e.this.iDM.cvK().cxj().notifyDataSetChanged();
        }
    };
    private CustomMessageListener iVT = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.iDM != null && e.this.iDM.cvF() != null && e.this.iDM.cvF().cBm() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.iDM.cvF().cBm().getForum().getBannerListData().getAllAdvertList());
                e.this.i(str, e.this.iDM.cvK().getListView().getData());
                e.this.i(str, e.this.iDM.cvG().cBD().getDataList());
                e.this.iDM.cvF().KC(str);
                if (e.this.iDM.cvK() != null && e.this.iDM.cvK().cxj() != null) {
                    e.this.iDM.cvK().cxj().notifyDataSetChanged();
                }
            }
        }
    };

    public e(l lVar, BdUniqueId bdUniqueId) {
        this.iDM = lVar;
        this.ikd.setTag(bdUniqueId);
        this.iVT.setTag(bdUniqueId);
        this.iXM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iXM);
        MessageManager.getInstance().registerListener(this.ikd);
        MessageManager.getInstance().registerListener(this.iVT);
        this.ike.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ike);
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
        if (this.iDM != null && this.iDM.cvF() != null && this.iDM.cvF().cBm() != null) {
            final String h = h(customResponsedMessage);
            if (!StringUtils.isNull(h) && this.iDM.cvK() != null && this.iDM.cvK().cxj() != null) {
                final View childAt = this.iDM.cvK().getListView().getChildAt(a(h, this.iDM.cvK().getListView()));
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
                            if (e.this.iDM != null && e.this.iDM.cvK() != null && e.this.iDM.cvK().getListView() != null && e.this.iDM.cvK().cxj() != null) {
                                e.this.iDM.cvK().getListView().removeView(childAt);
                                e.this.KD(h);
                                e.this.iDM.cvK().cxj().notifyDataSetChanged();
                            }
                        }
                    });
                } else {
                    KD(h);
                    this.iDM.cvK().cxj().notifyDataSetChanged();
                }
                cBX();
            }
        }
    }

    private void cBX() {
        if (this.iXL != null && this.iXL.eAV) {
            TbPageTag tbPageTag = null;
            if (this.iDM != null && this.iDM.cvK() != null) {
                tbPageTag = com.baidu.tbadk.pageInfo.c.et(this.iDM.cvK().getContext());
            }
            com.baidu.tieba.frs.d.a.a(this.iXL, tbPageTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iDM != null && this.iDM.cvF() != null && this.iDM.cvF().cBm() != null) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            final String optString = jSONObject.optString("type");
            if (!StringUtils.isNull(optString)) {
                final String optString2 = jSONObject.optString("tid");
                if (this.iDM.cvK() != null && this.iDM.cvK().cxj() != null) {
                    final View childAt = this.iDM.cvK().getListView().getChildAt(a(optString, optString2, this.iDM.cvK().getListView()));
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
                                e.this.eV(optString, optString2);
                                childAt.setVisibility(8);
                                if (e.this.iDM.cvK() != null && e.this.iDM.cvK().cxj() != null) {
                                    e.this.iDM.cvK().cxj().notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    eV(optString, optString2);
                    this.iDM.cvK().cxj().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eV(String str, String str2) {
        ArrayList<q> threadList = this.iDM.cvF().cBm().getThreadList();
        c(str, str2, threadList);
        c(str, str2, this.iDM.cvK().getListView().getData());
        if (str.equals("ala_frs_stage_live_feed_back_type")) {
            this.iDM.cvF().KA(str2);
        } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
            this.iDM.cvF().KB(str2);
        }
        if (threadList != null && threadList.size() < 5) {
            this.iDM.bMi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<q> threadList = this.iDM.cvF().cBm().getThreadList();
            g(str, threadList);
            g(str, this.iDM.cvK().getListView().getData());
            g(str, this.iDM.cvG().getDataList());
            this.iDM.cvF().KB(str);
            if (threadList != null && threadList.size() < 5) {
                this.iDM.bMi();
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
                    bw bwVar = ((bv) qVar).erH;
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
                    bw bwVar = ((bv) qVar).erH;
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
                    bw bwVar = ((bv) item).erH;
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
                bw bwVar = ((bv) item).erH;
                if (bwVar.getTid() != null && bwVar.getTid().equals(str)) {
                    this.iXL = bwVar;
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
                if (next != null && str.equals(next.esU)) {
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
                    Object bFd = ((com.baidu.tieba.InjectPlugin.a) next).bFd();
                    if ((bFd instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) bFd).esU)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
