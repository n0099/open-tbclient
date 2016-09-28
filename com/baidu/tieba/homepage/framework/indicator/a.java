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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.voice.VoiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends PagerAdapter implements com.baidu.tbadk.pageStayDuration.a {
    private BdUniqueId aYW;
    private com.baidu.tieba.homepage.personalize.a cCO;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String aAG = null;
    private String cCP = "recommendFrsLastReadTabPositionNamespace";
    private String cCQ = "recommendFrsLastReadTabPositionKey";
    private boolean cCR = false;
    private com.baidu.tieba.homepage.framework.d cCS = new b(this);
    private CustomMessageListener cCT = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener cCv = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private int cCU = 0;
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.data.a> cCN = new ArrayList<>();
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.b> aXL = new ArrayList<>();

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cCO != null) {
            this.cCO.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
        if (this.aXL != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXL.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setRecommendFrsNavigationAnimDispatcher(eVar);
                }
            }
        }
    }

    public void onPause() {
        jX(this.cCU);
        this.cCO.onPause();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXL.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onPause();
            }
        }
    }

    public void onResume() {
        if (this.cCO != null) {
            this.cCO.onResume();
        }
    }

    public void ku() {
        if (this.cCO != null) {
            this.cCO.ku();
        }
        if (this.aXL != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXL.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.ku();
                }
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cCO != null) {
            this.cCO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.aXL != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXL.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.b(view, i, i2, i3, i4);
                }
            }
        }
        if (this.cCO != null) {
            this.cCO.b(view, i, i2, i3, i4);
        }
    }

    public a(Context context, com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aYW = bdUniqueId;
        this.aXL.add(a(bVar));
        this.aXL.add(a(bVar));
        this.aXL.add(a(bVar));
        this.cCO = new com.baidu.tieba.homepage.personalize.a(context);
        this.cCO.setPageUniqueId(bdUniqueId);
        this.cCO.setCallback(cVar);
        this.cCT.setTag(bdUniqueId);
        this.cCv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cCT);
        MessageManager.getInstance().registerListener(this.cCv);
    }

    private com.baidu.tieba.homepage.recommendfrs.b a(com.baidu.tieba.homepage.framework.b bVar) {
        com.baidu.tieba.homepage.recommendfrs.b bVar2 = new com.baidu.tieba.homepage.recommendfrs.b(this.mContext);
        bVar2.j(this.aYW);
        bVar2.setCallback(bVar);
        bVar2.setScrollCallback(this.cCS);
        return bVar2;
    }

    public void aF(List<com.baidu.tieba.homepage.recommendfrs.data.a> list) {
        if (this.cCN == null) {
            this.cCN = new ArrayList<>();
        }
        this.cCN.clear();
        if (list != null && list.size() > 0) {
            this.cCN.addAll(list);
        }
        notifyDataSetChanged();
        alS();
    }

    private void alS() {
        int size = this.aXL.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.homepage.recommendfrs.b bVar = this.aXL.get(i % size);
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.y.c(this.cCN, i);
            if (bVar != null && aVar != null) {
                bVar.a(aVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cCN != null && !this.cCN.isEmpty()) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cCN.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.anf() != null && j == next.anf().tag_code.longValue()) {
                    next.a(z, cVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void a(long j, String str, int i) {
        if (j == this.cCO.getTagCode()) {
            this.cCO.V(str, i);
        } else if (this.aXL != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXL.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.bJ(j)) {
                    next.V(str, i);
                    return;
                }
            }
        }
    }

    public void alT() {
        if (this.cCO != null) {
            this.cCO.alT();
            alU();
        }
    }

    private void a(long j, com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z) {
        if (this.aXL != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXL.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.bJ(j)) {
                    next.a(aVar, false, z);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.cCN == null) {
            return 0;
        }
        return this.cCN.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.homepage.framework.a.a.aml().cEd != i) {
            eS(true);
            com.baidu.tieba.homepage.framework.a.a.aml().cEd = i;
            alU();
            alX();
            VoiceManager bh = com.baidu.tieba.tbadkCore.voice.b.bh(this.mContext);
            if (bh != null) {
                bh.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.homepage.recommendfrs.b) {
                com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) obj;
                bVar.amy();
                bVar.Zd();
                if (i == com.baidu.tieba.homepage.framework.a.a.aml().cEb) {
                    TiebaStatic.log(new ax("c10952"));
                    if (com.baidu.tieba.homepage.framework.a.a.aml().cEc != 0 || com.baidu.tieba.homepage.framework.a.a.aml().cEf) {
                        com.baidu.tieba.homepage.framework.a.a.aml().cEf = false;
                        eT(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.homepage.personalize.a) {
                com.baidu.tieba.homepage.personalize.a aVar = (com.baidu.tieba.homepage.personalize.a) obj;
                aVar.amy();
                aVar.Zd();
            }
        }
        this.cCU = i;
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (com.baidu.tbadk.core.util.y.s(this.cCN) <= 0) {
            if (this.cCO != null) {
                this.cCO.a(dataRes, z);
            }
        } else if (j == 0 && (aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.y.c(this.cCN, 0)) != null) {
            aVar.c(dataRes);
            this.cCO.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cCN.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.anf() != null && j == next.anf().tag_code.longValue()) {
                    next.c(dataRes);
                    next.ff(z);
                    this.cCO.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bB(long j) {
        if (this.cCN == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cCN.get(i);
            if (aVar != null && aVar.anf() != null && aVar.anf().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.cCO.getParent() != null) {
                viewGroup.removeView(this.cCO);
            }
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.y.c(this.cCN, i);
            if (aVar != null) {
                this.cCO.setTagInfo(aVar.anf());
            }
            viewGroup.addView(this.cCO);
            return this.cCO;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = this.aXL.get(i % 3);
        if (bVar.getParent() != null) {
            viewGroup.removeView(bVar);
        }
        bVar.a(this.cCN.get(i), true, false);
        viewGroup.addView(bVar);
        if (i == 1) {
            bVar.setEnableLastReadPosition(true);
            return bVar;
        }
        bVar.setEnableLastReadPosition(false);
        return bVar;
    }

    private void alU() {
        this.lastResumeTime = System.currentTimeMillis();
        if (!alV() && com.baidu.tieba.homepage.framework.a.a.aml().cEd >= 0) {
            if (com.baidu.tieba.homepage.framework.a.a.aml().cEd == 0) {
                this.aAG = "a002";
            } else if (com.baidu.tieba.homepage.framework.a.a.aml().cEd == com.baidu.tieba.homepage.framework.a.a.aml().cEb) {
                this.aAG = "a003";
            } else {
                this.aAG = "a004";
            }
        }
    }

    private boolean alV() {
        int i = com.baidu.tieba.homepage.framework.a.a.aml().cEd;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cCN.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo anf = aVar.anf();
        if (anf == null || anf.tag_type.intValue() != 5) {
            return false;
        }
        this.aAG = com.baidu.tieba.tbadkCore.v.rc(anf.lego_qs);
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
        if (this.cCN == null || this.cCN.get(i) == null || this.cCN.get(i).anf() == null) {
            return null;
        }
        return this.cCN.get(i).anf().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dl(int i) {
        if (this.aXL != null) {
            if (this.cCO != null) {
                this.cCO.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXL.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        alU();
        if (i == 0) {
            this.cCO.amy();
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.y.c(this.aXL, i % 3);
        if (bVar != null) {
            if (i == com.baidu.tieba.homepage.framework.a.a.aml().cEb) {
                TiebaStatic.log(new ax("c10952"));
            }
            if (i == com.baidu.tieba.homepage.framework.a.a.aml().cEb && com.baidu.tieba.homepage.framework.a.a.aml().cEf) {
                com.baidu.tieba.homepage.framework.a.a.aml().cEf = false;
                eT(false);
                return;
            }
            bVar.amy();
        }
    }

    public void eT(boolean z) {
        int i = com.baidu.tieba.homepage.framework.a.a.aml().cEd;
        if (i == 0) {
            if (this.cCO != null) {
                this.cCO.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.y.c(this.aXL, i % 3);
        if (bVar != null) {
            bVar.fe(z);
        }
    }

    private View alW() {
        int i = com.baidu.tieba.homepage.framework.a.a.aml().cEd;
        if (i == 0) {
            return this.cCO;
        }
        return (View) com.baidu.tbadk.core.util.y.c(this.aXL, i % 3);
    }

    public void onDestroy() {
        this.cCO.onDestroy();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXL.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void alX() {
        View alW = alW();
        if (this.cCO != null) {
            this.cCO.setTabInForeBackgroundState(this.cCO != alW);
        }
        if (this.aXL != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXL.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setTabInForeBackgroundState(next != alW);
                }
            }
        }
    }

    public void eS(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.S(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.FL().a(this.mContext, pageStayDurationItem);
        }
        View alW = alW();
        if (alW instanceof com.baidu.tieba.homepage.recommendfrs.b) {
            ((com.baidu.tieba.homepage.recommendfrs.b) alW).amz();
        } else if (alW instanceof com.baidu.tieba.homepage.personalize.a) {
            ((com.baidu.tieba.homepage.personalize.a) alW).amz();
        }
    }

    public void alY() {
        int i = com.baidu.tieba.homepage.framework.a.a.aml().cEd;
        if (i == 0) {
            if (this.cCO != null) {
                this.cCO.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.y.c(this.aXL, i % 3);
        if (bVar != null) {
            bVar.amy();
        }
    }

    public void jW(int i) {
        if (i == 0 && this.cCO != null) {
            this.cCO.amA();
        } else if (i == 1 && (alW() instanceof com.baidu.tieba.homepage.recommendfrs.b)) {
            ((com.baidu.tieba.homepage.recommendfrs.b) alW()).amQ();
        }
    }

    public void jX(int i) {
        com.baidu.tbadk.util.u.a(new e(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.framework.x xVar) {
        if (!this.cCR) {
            this.cCR = true;
            com.baidu.tbadk.util.u.a(new f(this), new g(this, xVar));
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.aAG;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        if (this.mContext instanceof com.baidu.tbadk.pageStayDuration.a) {
            arrayList2 = (ArrayList) ((com.baidu.tbadk.pageStayDuration.a) this.mContext).getCurrentPageSourceKeyList();
        }
        if (!com.baidu.tbadk.core.util.y.t(arrayList2)) {
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
        if (com.baidu.tbadk.core.util.y.t(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().FF()) && !StringUtils.isNull(currentPageKey)) {
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
        this.pageStayDurationItem.D(getCurrentPageSourceKeyList());
        this.pageStayDurationItem.gh(getCurrentPageKey());
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
