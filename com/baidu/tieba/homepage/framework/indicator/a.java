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
    private BdUniqueId bbE;
    private com.baidu.tieba.homepage.personalize.a cwO;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String aFt = null;
    private String cwP = "recommendFrsLastReadTabPositionNamespace";
    private String cwQ = "recommendFrsLastReadTabPositionKey";
    private boolean cwR = false;
    private com.baidu.tieba.homepage.framework.d cwS = new b(this);
    private CustomMessageListener cwT = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener cws = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private int cwU = 0;
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.data.a> cwN = new ArrayList<>();
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.b> bso = new ArrayList<>();

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cwO != null) {
            this.cwO.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
        if (this.bso != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bso.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setRecommendFrsNavigationAnimDispatcher(eVar);
                }
            }
        }
    }

    public void onPause() {
        jO(this.cwU);
        this.cwO.onPause();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bso.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onPause();
            }
        }
    }

    public void onResume() {
        if (this.cwO != null) {
            this.cwO.onResume();
        }
    }

    public void completePullRefresh() {
        if (this.cwO != null) {
            this.cwO.completePullRefresh();
        }
        if (this.bso != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bso.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.completePullRefresh();
                }
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cwO != null) {
            this.cwO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.bso != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bso.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.b(view, i, i2, i3, i4);
                }
            }
        }
        if (this.cwO != null) {
            this.cwO.b(view, i, i2, i3, i4);
        }
    }

    public a(Context context, com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.bbE = bdUniqueId;
        this.bso.add(a(bVar));
        this.bso.add(a(bVar));
        this.bso.add(a(bVar));
        this.cwO = new com.baidu.tieba.homepage.personalize.a(context);
        this.cwO.setPageUniqueId(bdUniqueId);
        this.cwO.setCallback(cVar);
        this.cwT.setTag(bdUniqueId);
        this.cws.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cwT);
        MessageManager.getInstance().registerListener(this.cws);
    }

    private com.baidu.tieba.homepage.recommendfrs.b a(com.baidu.tieba.homepage.framework.b bVar) {
        com.baidu.tieba.homepage.recommendfrs.b bVar2 = new com.baidu.tieba.homepage.recommendfrs.b(this.mContext);
        bVar2.j(this.bbE);
        bVar2.setCallback(bVar);
        bVar2.setScrollCallback(this.cwS);
        return bVar2;
    }

    public void aW(List<com.baidu.tieba.homepage.recommendfrs.data.a> list) {
        if (this.cwN == null) {
            this.cwN = new ArrayList<>();
        }
        this.cwN.clear();
        if (list != null && list.size() > 0) {
            this.cwN.addAll(list);
        }
        notifyDataSetChanged();
        ajC();
    }

    private void ajC() {
        int size = this.bso.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.homepage.recommendfrs.b bVar = this.bso.get(i % size);
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cwN, i);
            if (bVar != null && aVar != null) {
                bVar.a(aVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cwN != null && !this.cwN.isEmpty()) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cwN.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.akO() != null && j == next.akO().tag_code.longValue()) {
                    next.a(z, cVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void a(long j, String str, int i) {
        if (j == this.cwO.getTagCode()) {
            this.cwO.M(str, i);
        } else if (this.bso != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bso.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.br(j)) {
                    next.M(str, i);
                    return;
                }
            }
        }
    }

    public void ajD() {
        if (this.cwO != null) {
            this.cwO.ajD();
            ajE();
        }
    }

    private void a(long j, com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z) {
        if (this.bso != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bso.iterator();
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
        if (this.cwN == null) {
            return 0;
        }
        return this.cwN.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.homepage.framework.a.a.ajV().cye != i) {
            eX(true);
            com.baidu.tieba.homepage.framework.a.a.ajV().cye = i;
            ajE();
            ajI();
            VoiceManager bO = com.baidu.tieba.tbadkCore.voice.b.bO(this.mContext);
            if (bO != null) {
                bO.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.homepage.recommendfrs.b) {
                com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) obj;
                bVar.akh();
                bVar.Yk();
                if (i == com.baidu.tieba.homepage.framework.a.a.ajV().cyc) {
                    TiebaStatic.log(new as("c10952"));
                    if (com.baidu.tieba.homepage.framework.a.a.ajV().cyd != 0 || com.baidu.tieba.homepage.framework.a.a.ajV().cyg) {
                        com.baidu.tieba.homepage.framework.a.a.ajV().cyg = false;
                        eY(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.homepage.personalize.a) {
                com.baidu.tieba.homepage.personalize.a aVar = (com.baidu.tieba.homepage.personalize.a) obj;
                aVar.akh();
                aVar.Yk();
            }
        }
        this.cwU = i;
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (com.baidu.tbadk.core.util.x.p(this.cwN) <= 0) {
            if (this.cwO != null) {
                this.cwO.a(dataRes, z);
            }
        } else if (j == 0 && (aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cwN, 0)) != null) {
            aVar.c(dataRes);
            this.cwO.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cwN.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.akO() != null && j == next.akO().tag_code.longValue()) {
                    next.c(dataRes);
                    next.fk(z);
                    this.cwO.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bj(long j) {
        if (this.cwN == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cwN.get(i);
            if (aVar != null && aVar.akO() != null && aVar.akO().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.cwO.getParent() != null) {
                viewGroup.removeView(this.cwO);
            }
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cwN, i);
            if (aVar != null) {
                this.cwO.setTagInfo(aVar.akO());
            }
            viewGroup.addView(this.cwO);
            return this.cwO;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = this.bso.get(i % 3);
        if (bVar.getParent() != null) {
            viewGroup.removeView(bVar);
        }
        bVar.a(this.cwN.get(i), true, false);
        viewGroup.addView(bVar);
        if (i - 1 == com.baidu.tieba.homepage.framework.a.a.ajV().cyc) {
            bVar.setEnableLastReadPosition(true);
            return bVar;
        }
        bVar.setEnableLastReadPosition(false);
        return bVar;
    }

    private void ajE() {
        this.lastResumeTime = System.currentTimeMillis();
        if (!ajG() && !ajF() && com.baidu.tieba.homepage.framework.a.a.ajV().cye >= 0) {
            if (com.baidu.tieba.homepage.framework.a.a.ajV().cye == 0) {
                this.aFt = "a002";
            } else if (com.baidu.tieba.homepage.framework.a.a.ajV().cye == com.baidu.tieba.homepage.framework.a.a.ajV().cyc) {
                this.aFt = "a003";
            } else {
                this.aFt = "a004";
            }
        }
    }

    private boolean ajF() {
        int i = com.baidu.tieba.homepage.framework.a.a.ajV().cye;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cwN.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo akO = aVar.akO();
        if (akO == null || akO.tag_type.intValue() != 7) {
            return false;
        }
        this.aFt = "c11825";
        return true;
    }

    private boolean ajG() {
        int i = com.baidu.tieba.homepage.framework.a.a.ajV().cye;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cwN.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo akO = aVar.akO();
        if (akO == null || akO.tag_type.intValue() != 5) {
            return false;
        }
        this.aFt = com.baidu.tieba.tbadkCore.t.pV(akO.lego_qs);
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
        if (this.cwN == null || this.cwN.get(i) == null || this.cwN.get(i).akO() == null) {
            return null;
        }
        return this.cwN.get(i).akO().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* renamed from: do  reason: not valid java name */
    public void m20do(int i) {
        if (this.bso != null) {
            if (this.cwO != null) {
                this.cwO.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bso.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        ajE();
        if (i == 0) {
            this.cwO.akh();
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.bso, i % 3);
        if (bVar != null) {
            if (i == com.baidu.tieba.homepage.framework.a.a.ajV().cyc) {
                TiebaStatic.log(new as("c10952"));
            }
            if (i == com.baidu.tieba.homepage.framework.a.a.ajV().cyc && com.baidu.tieba.homepage.framework.a.a.ajV().cyg) {
                com.baidu.tieba.homepage.framework.a.a.ajV().cyg = false;
                eY(false);
                return;
            }
            bVar.akh();
        }
    }

    public void eY(boolean z) {
        int i = com.baidu.tieba.homepage.framework.a.a.ajV().cye;
        if (i == 0) {
            if (this.cwO != null) {
                this.cwO.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.bso, i % 3);
        if (bVar != null) {
            bVar.fj(z);
        }
    }

    private View ajH() {
        int i = com.baidu.tieba.homepage.framework.a.a.ajV().cye;
        if (i == 0) {
            return this.cwO;
        }
        return (View) com.baidu.tbadk.core.util.x.c(this.bso, i % 3);
    }

    public void onDestroy() {
        this.cwO.onDestroy();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bso.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void ajI() {
        View ajH = ajH();
        if (this.cwO != null) {
            this.cwO.setTabInForeBackgroundState(this.cwO != ajH);
        }
        if (this.bso != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bso.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setTabInForeBackgroundState(next != ajH);
                }
            }
        }
    }

    public void eX(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.O(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.Gb().a(this.mContext, pageStayDurationItem);
        }
        View ajH = ajH();
        if (ajH instanceof com.baidu.tieba.homepage.recommendfrs.b) {
            ((com.baidu.tieba.homepage.recommendfrs.b) ajH).aki();
        } else if (ajH instanceof com.baidu.tieba.homepage.personalize.a) {
            ((com.baidu.tieba.homepage.personalize.a) ajH).aki();
        }
    }

    public void ajJ() {
        int i = com.baidu.tieba.homepage.framework.a.a.ajV().cye;
        if (i == 0) {
            if (this.cwO != null) {
                this.cwO.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.bso, i % 3);
        if (bVar != null) {
            bVar.akh();
        }
    }

    public void jN(int i) {
        if (i == 0 && this.cwO != null) {
            this.cwO.akj();
        } else if (i == com.baidu.tieba.homepage.framework.a.a.ajV().cyc && (ajH() instanceof com.baidu.tieba.homepage.recommendfrs.b)) {
            ((com.baidu.tieba.homepage.recommendfrs.b) ajH()).aky();
        }
    }

    public void jO(int i) {
        com.baidu.tbadk.util.t.a(new e(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.framework.x xVar) {
        if (!this.cwR) {
            this.cwR = true;
            com.baidu.tbadk.util.t.a(new f(this), new g(this, xVar));
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.aFt;
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
        if ((getPageStayFilter() == null || getPageStayFilter().FV()) && !StringUtils.isNull(currentPageKey)) {
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
        this.pageStayDurationItem.fX(getCurrentPageKey());
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
