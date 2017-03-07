package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.voice.VoiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends PagerAdapter implements com.baidu.tbadk.pageStayDuration.a {
    private BdUniqueId baP;
    private com.baidu.tieba.homepage.personalize.a cvX;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String aFb = null;
    private String cvY = "recommendFrsLastReadTabPositionNamespace";
    private String cvZ = "recommendFrsLastReadTabPositionKey";
    private boolean cwa = false;
    private com.baidu.tieba.homepage.framework.d cwb = new b(this);
    private CustomMessageListener cwc = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener cvB = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private int cwd = 0;
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.data.a> cvW = new ArrayList<>();
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.b> bqe = new ArrayList<>();

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cvX != null) {
            this.cvX.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
        if (this.bqe != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bqe.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setRecommendFrsNavigationAnimDispatcher(eVar);
                }
            }
        }
    }

    public void onPause() {
        jH(this.cwd);
        this.cvX.onPause();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bqe.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onPause();
            }
        }
    }

    public void onResume() {
        if (this.cvX != null) {
            this.cvX.onResume();
        }
    }

    public void completePullRefresh() {
        if (this.cvX != null) {
            this.cvX.completePullRefresh();
        }
        if (this.bqe != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bqe.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.completePullRefresh();
                }
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cvX != null) {
            this.cvX.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.bqe != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bqe.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.b(view, i, i2, i3, i4);
                }
            }
        }
        if (this.cvX != null) {
            this.cvX.b(view, i, i2, i3, i4);
        }
    }

    public a(Context context, com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.baP = bdUniqueId;
        this.bqe.add(a(bVar));
        this.bqe.add(a(bVar));
        this.bqe.add(a(bVar));
        this.cvX = new com.baidu.tieba.homepage.personalize.a(context);
        this.cvX.setPageUniqueId(bdUniqueId);
        this.cvX.setCallback(cVar);
        this.cwc.setTag(bdUniqueId);
        this.cvB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cwc);
        MessageManager.getInstance().registerListener(this.cvB);
    }

    private com.baidu.tieba.homepage.recommendfrs.b a(com.baidu.tieba.homepage.framework.b bVar) {
        com.baidu.tieba.homepage.recommendfrs.b bVar2 = new com.baidu.tieba.homepage.recommendfrs.b(this.mContext);
        bVar2.j(this.baP);
        bVar2.setCallback(bVar);
        bVar2.setScrollCallback(this.cwb);
        return bVar2;
    }

    public void aW(List<com.baidu.tieba.homepage.recommendfrs.data.a> list) {
        if (this.cvW == null) {
            this.cvW = new ArrayList<>();
        }
        this.cvW.clear();
        if (list != null && list.size() > 0) {
            this.cvW.addAll(list);
        }
        notifyDataSetChanged();
        aiH();
    }

    private void aiH() {
        int size = this.bqe.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.homepage.recommendfrs.b bVar = this.bqe.get(i % size);
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cvW, i);
            if (bVar != null && aVar != null) {
                bVar.a(aVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cvW != null && !this.cvW.isEmpty()) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cvW.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.ajT() != null && j == next.ajT().tag_code.longValue()) {
                    next.a(z, cVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void a(long j, String str, int i) {
        if (j == this.cvX.getTagCode()) {
            this.cvX.M(str, i);
        } else if (this.bqe != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bqe.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.br(j)) {
                    next.M(str, i);
                    return;
                }
            }
        }
    }

    public void aiI() {
        if (this.cvX != null) {
            this.cvX.aiI();
            aiJ();
        }
    }

    private void a(long j, com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z) {
        if (this.bqe != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bqe.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.br(j)) {
                    next.a(aVar, false, z);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.cvW == null) {
            return 0;
        }
        return this.cvW.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.homepage.framework.a.a.aja().cxn != i) {
            eN(true);
            com.baidu.tieba.homepage.framework.a.a.aja().cxn = i;
            aiJ();
            aiN();
            VoiceManager bU = com.baidu.tieba.tbadkCore.voice.b.bU(this.mContext);
            if (bU != null) {
                bU.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.homepage.recommendfrs.b) {
                com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) obj;
                bVar.ajm();
                bVar.WL();
                if (i == com.baidu.tieba.homepage.framework.a.a.aja().cxl) {
                    TiebaStatic.log(new as("c10952"));
                    if (com.baidu.tieba.homepage.framework.a.a.aja().cxm != 0 || com.baidu.tieba.homepage.framework.a.a.aja().cxp) {
                        com.baidu.tieba.homepage.framework.a.a.aja().cxp = false;
                        eO(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.homepage.personalize.a) {
                com.baidu.tieba.homepage.personalize.a aVar = (com.baidu.tieba.homepage.personalize.a) obj;
                aVar.ajm();
                aVar.WL();
            }
        }
        this.cwd = i;
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (com.baidu.tbadk.core.util.x.p(this.cvW) <= 0) {
            if (this.cvX != null) {
                this.cvX.a(dataRes, z);
            }
        } else if (j == 0 && (aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cvW, 0)) != null) {
            aVar.c(dataRes);
            this.cvX.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cvW.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.ajT() != null && j == next.ajT().tag_code.longValue()) {
                    next.c(dataRes);
                    next.fa(z);
                    this.cvX.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bj(long j) {
        if (this.cvW == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cvW.get(i);
            if (aVar != null && aVar.ajT() != null && aVar.ajT().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.cvX.getParent() != null) {
                viewGroup.removeView(this.cvX);
            }
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cvW, i);
            if (aVar != null) {
                this.cvX.setTagInfo(aVar.ajT());
            }
            viewGroup.addView(this.cvX);
            return this.cvX;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = this.bqe.get(i % 3);
        if (bVar.getParent() != null) {
            viewGroup.removeView(bVar);
        }
        bVar.a(this.cvW.get(i), true, false);
        viewGroup.addView(bVar);
        if (i - 1 == com.baidu.tieba.homepage.framework.a.a.aja().cxl) {
            bVar.setEnableLastReadPosition(true);
            return bVar;
        }
        bVar.setEnableLastReadPosition(false);
        return bVar;
    }

    private void aiJ() {
        this.lastResumeTime = System.currentTimeMillis();
        if (!aiL() && !aiK() && com.baidu.tieba.homepage.framework.a.a.aja().cxn >= 0) {
            if (com.baidu.tieba.homepage.framework.a.a.aja().cxn == 0) {
                this.aFb = "a002";
            } else if (com.baidu.tieba.homepage.framework.a.a.aja().cxn == com.baidu.tieba.homepage.framework.a.a.aja().cxl) {
                this.aFb = "a003";
            } else {
                this.aFb = "a004";
            }
        }
    }

    private boolean aiK() {
        int i = com.baidu.tieba.homepage.framework.a.a.aja().cxn;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cvW.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo ajT = aVar.ajT();
        if (ajT == null || ajT.tag_type.intValue() != 7) {
            return false;
        }
        this.aFb = "c11825";
        return true;
    }

    private boolean aiL() {
        int i = com.baidu.tieba.homepage.framework.a.a.aja().cxn;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cvW.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo ajT = aVar.ajT();
        if (ajT == null || ajT.tag_type.intValue() != 5) {
            return false;
        }
        this.aFb = com.baidu.tieba.tbadkCore.t.pD(ajT.lego_qs);
        return true;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        int count = getCount();
        if (i < 0 || i >= count) {
            return null;
        }
        if (this.cvW == null || this.cvW.get(i) == null || this.cvW.get(i).ajT() == null) {
            return null;
        }
        return this.cvW.get(i).ajT().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dl(int i) {
        if (this.bqe != null) {
            if (this.cvX != null) {
                this.cvX.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bqe.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        aiJ();
        if (i == 0) {
            this.cvX.ajm();
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.bqe, i % 3);
        if (bVar != null) {
            if (i == com.baidu.tieba.homepage.framework.a.a.aja().cxl) {
                TiebaStatic.log(new as("c10952"));
            }
            if (i == com.baidu.tieba.homepage.framework.a.a.aja().cxl && com.baidu.tieba.homepage.framework.a.a.aja().cxp) {
                com.baidu.tieba.homepage.framework.a.a.aja().cxp = false;
                eO(false);
                return;
            }
            bVar.ajm();
        }
    }

    public void eO(boolean z) {
        int i = com.baidu.tieba.homepage.framework.a.a.aja().cxn;
        if (i == 0) {
            if (this.cvX != null) {
                this.cvX.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.bqe, i % 3);
        if (bVar != null) {
            bVar.eZ(z);
        }
    }

    private View aiM() {
        int i = com.baidu.tieba.homepage.framework.a.a.aja().cxn;
        if (i == 0) {
            return this.cvX;
        }
        return (View) com.baidu.tbadk.core.util.x.c(this.bqe, i % 3);
    }

    public void onDestroy() {
        this.cvX.onDestroy();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bqe.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void aiN() {
        View aiM = aiM();
        if (this.cvX != null) {
            this.cvX.setTabInForeBackgroundState(this.cvX != aiM);
        }
        if (this.bqe != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bqe.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setTabInForeBackgroundState(next != aiM);
                }
            }
        }
    }

    public void eN(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.O(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.FD().a(this.mContext, pageStayDurationItem);
        }
        View aiM = aiM();
        if (aiM instanceof com.baidu.tieba.homepage.recommendfrs.b) {
            ((com.baidu.tieba.homepage.recommendfrs.b) aiM).ajn();
        } else if (aiM instanceof com.baidu.tieba.homepage.personalize.a) {
            ((com.baidu.tieba.homepage.personalize.a) aiM).ajn();
        }
    }

    public void aiO() {
        int i = com.baidu.tieba.homepage.framework.a.a.aja().cxn;
        if (i == 0) {
            if (this.cvX != null) {
                this.cvX.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.bqe, i % 3);
        if (bVar != null) {
            bVar.ajm();
        }
    }

    public void jG(int i) {
        if (i == 0 && this.cvX != null) {
            this.cvX.ajo();
        } else if (i == com.baidu.tieba.homepage.framework.a.a.aja().cxl && (aiM() instanceof com.baidu.tieba.homepage.recommendfrs.b)) {
            ((com.baidu.tieba.homepage.recommendfrs.b) aiM()).ajD();
        }
    }

    public void jH(int i) {
        com.baidu.tbadk.util.t.a(new e(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.framework.x xVar) {
        if (!this.cwa) {
            this.cwa = true;
            com.baidu.tbadk.util.t.a(new f(this), new g(this, xVar));
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.aFb;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        if (this.mContext instanceof com.baidu.tbadk.pageStayDuration.a) {
            arrayList2 = (ArrayList) ((com.baidu.tbadk.pageStayDuration.a) this.mContext).getCurrentPageSourceKeyList();
        }
        if (!com.baidu.tbadk.core.util.x.q(arrayList2)) {
            arrayList.addAll(arrayList2);
        }
        arrayList.add("a001");
        return arrayList;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (com.baidu.tbadk.core.util.x.q(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Fx()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.pageStayDuration.d();
        }
        this.pageStayDurationItem.z(getCurrentPageSourceKeyList());
        this.pageStayDurationItem.fR(getCurrentPageKey());
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
