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
    private BdUniqueId baI;
    private com.baidu.tieba.homepage.personalize.a cux;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String aFr = null;
    private String cuy = "recommendFrsLastReadTabPositionNamespace";
    private String cuz = "recommendFrsLastReadTabPositionKey";
    private boolean cuA = false;
    private com.baidu.tieba.homepage.framework.d cuB = new b(this);
    private CustomMessageListener cuC = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener cub = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private int cuD = 0;
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.data.a> cuw = new ArrayList<>();
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.b> bpX = new ArrayList<>();

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cux != null) {
            this.cux.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
        if (this.bpX != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bpX.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setRecommendFrsNavigationAnimDispatcher(eVar);
                }
            }
        }
    }

    public void onPause() {
        jI(this.cuD);
        this.cux.onPause();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bpX.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onPause();
            }
        }
    }

    public void onResume() {
        if (this.cux != null) {
            this.cux.onResume();
        }
    }

    public void completePullRefresh() {
        if (this.cux != null) {
            this.cux.completePullRefresh();
        }
        if (this.bpX != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bpX.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.completePullRefresh();
                }
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cux != null) {
            this.cux.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.bpX != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bpX.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.b(view, i, i2, i3, i4);
                }
            }
        }
        if (this.cux != null) {
            this.cux.b(view, i, i2, i3, i4);
        }
    }

    public a(Context context, com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.baI = bdUniqueId;
        this.bpX.add(a(bVar));
        this.bpX.add(a(bVar));
        this.bpX.add(a(bVar));
        this.cux = new com.baidu.tieba.homepage.personalize.a(context);
        this.cux.setPageUniqueId(bdUniqueId);
        this.cux.setCallback(cVar);
        this.cuC.setTag(bdUniqueId);
        this.cub.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cuC);
        MessageManager.getInstance().registerListener(this.cub);
    }

    private com.baidu.tieba.homepage.recommendfrs.b a(com.baidu.tieba.homepage.framework.b bVar) {
        com.baidu.tieba.homepage.recommendfrs.b bVar2 = new com.baidu.tieba.homepage.recommendfrs.b(this.mContext);
        bVar2.j(this.baI);
        bVar2.setCallback(bVar);
        bVar2.setScrollCallback(this.cuB);
        return bVar2;
    }

    public void aV(List<com.baidu.tieba.homepage.recommendfrs.data.a> list) {
        if (this.cuw == null) {
            this.cuw = new ArrayList<>();
        }
        this.cuw.clear();
        if (list != null && list.size() > 0) {
            this.cuw.addAll(list);
        }
        notifyDataSetChanged();
        aiB();
    }

    private void aiB() {
        int size = this.bpX.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.homepage.recommendfrs.b bVar = this.bpX.get(i % size);
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cuw, i);
            if (bVar != null && aVar != null) {
                bVar.a(aVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cuw != null && !this.cuw.isEmpty()) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cuw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.ajN() != null && j == next.ajN().tag_code.longValue()) {
                    next.a(z, cVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void a(long j, String str, int i) {
        if (j == this.cux.getTagCode()) {
            this.cux.M(str, i);
        } else if (this.bpX != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bpX.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.br(j)) {
                    next.M(str, i);
                    return;
                }
            }
        }
    }

    public void aiC() {
        if (this.cux != null) {
            this.cux.aiC();
            aiD();
        }
    }

    private void a(long j, com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z) {
        if (this.bpX != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bpX.iterator();
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
        if (this.cuw == null) {
            return 0;
        }
        return this.cuw.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.homepage.framework.a.a.aiU().cvN != i) {
            eN(true);
            com.baidu.tieba.homepage.framework.a.a.aiU().cvN = i;
            aiD();
            aiH();
            VoiceManager bO = com.baidu.tieba.tbadkCore.voice.b.bO(this.mContext);
            if (bO != null) {
                bO.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.homepage.recommendfrs.b) {
                com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) obj;
                bVar.ajg();
                bVar.Xj();
                if (i == com.baidu.tieba.homepage.framework.a.a.aiU().cvL) {
                    TiebaStatic.log(new as("c10952"));
                    if (com.baidu.tieba.homepage.framework.a.a.aiU().cvM != 0 || com.baidu.tieba.homepage.framework.a.a.aiU().cvP) {
                        com.baidu.tieba.homepage.framework.a.a.aiU().cvP = false;
                        eO(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.homepage.personalize.a) {
                com.baidu.tieba.homepage.personalize.a aVar = (com.baidu.tieba.homepage.personalize.a) obj;
                aVar.ajg();
                aVar.Xj();
            }
        }
        this.cuD = i;
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (com.baidu.tbadk.core.util.x.p(this.cuw) <= 0) {
            if (this.cux != null) {
                this.cux.a(dataRes, z);
            }
        } else if (j == 0 && (aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cuw, 0)) != null) {
            aVar.c(dataRes);
            this.cux.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cuw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.ajN() != null && j == next.ajN().tag_code.longValue()) {
                    next.c(dataRes);
                    next.fa(z);
                    this.cux.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bj(long j) {
        if (this.cuw == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cuw.get(i);
            if (aVar != null && aVar.ajN() != null && aVar.ajN().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.cux.getParent() != null) {
                viewGroup.removeView(this.cux);
            }
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cuw, i);
            if (aVar != null) {
                this.cux.setTagInfo(aVar.ajN());
            }
            viewGroup.addView(this.cux);
            return this.cux;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = this.bpX.get(i % 3);
        if (bVar.getParent() != null) {
            viewGroup.removeView(bVar);
        }
        bVar.a(this.cuw.get(i), true, false);
        viewGroup.addView(bVar);
        if (i - 1 == com.baidu.tieba.homepage.framework.a.a.aiU().cvL) {
            bVar.setEnableLastReadPosition(true);
            return bVar;
        }
        bVar.setEnableLastReadPosition(false);
        return bVar;
    }

    private void aiD() {
        this.lastResumeTime = System.currentTimeMillis();
        if (!aiF() && !aiE() && com.baidu.tieba.homepage.framework.a.a.aiU().cvN >= 0) {
            if (com.baidu.tieba.homepage.framework.a.a.aiU().cvN == 0) {
                this.aFr = "a002";
            } else if (com.baidu.tieba.homepage.framework.a.a.aiU().cvN == com.baidu.tieba.homepage.framework.a.a.aiU().cvL) {
                this.aFr = "a003";
            } else {
                this.aFr = "a004";
            }
        }
    }

    private boolean aiE() {
        int i = com.baidu.tieba.homepage.framework.a.a.aiU().cvN;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cuw.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo ajN = aVar.ajN();
        if (ajN == null || ajN.tag_type.intValue() != 7) {
            return false;
        }
        this.aFr = "c11825";
        return true;
    }

    private boolean aiF() {
        int i = com.baidu.tieba.homepage.framework.a.a.aiU().cvN;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cuw.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo ajN = aVar.ajN();
        if (ajN == null || ajN.tag_type.intValue() != 5) {
            return false;
        }
        this.aFr = com.baidu.tieba.tbadkCore.t.pU(ajN.lego_qs);
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
        if (this.cuw == null || this.cuw.get(i) == null || this.cuw.get(i).ajN() == null) {
            return null;
        }
        return this.cuw.get(i).ajN().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* renamed from: do  reason: not valid java name */
    public void m19do(int i) {
        if (this.bpX != null) {
            if (this.cux != null) {
                this.cux.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bpX.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        aiD();
        if (i == 0) {
            this.cux.ajg();
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.bpX, i % 3);
        if (bVar != null) {
            if (i == com.baidu.tieba.homepage.framework.a.a.aiU().cvL) {
                TiebaStatic.log(new as("c10952"));
            }
            if (i == com.baidu.tieba.homepage.framework.a.a.aiU().cvL && com.baidu.tieba.homepage.framework.a.a.aiU().cvP) {
                com.baidu.tieba.homepage.framework.a.a.aiU().cvP = false;
                eO(false);
                return;
            }
            bVar.ajg();
        }
    }

    public void eO(boolean z) {
        int i = com.baidu.tieba.homepage.framework.a.a.aiU().cvN;
        if (i == 0) {
            if (this.cux != null) {
                this.cux.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.bpX, i % 3);
        if (bVar != null) {
            bVar.eZ(z);
        }
    }

    private View aiG() {
        int i = com.baidu.tieba.homepage.framework.a.a.aiU().cvN;
        if (i == 0) {
            return this.cux;
        }
        return (View) com.baidu.tbadk.core.util.x.c(this.bpX, i % 3);
    }

    public void onDestroy() {
        this.cux.onDestroy();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bpX.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void aiH() {
        View aiG = aiG();
        if (this.cux != null) {
            this.cux.setTabInForeBackgroundState(this.cux != aiG);
        }
        if (this.bpX != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bpX.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setTabInForeBackgroundState(next != aiG);
                }
            }
        }
    }

    public void eN(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.O(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.Gb().a(this.mContext, pageStayDurationItem);
        }
        View aiG = aiG();
        if (aiG instanceof com.baidu.tieba.homepage.recommendfrs.b) {
            ((com.baidu.tieba.homepage.recommendfrs.b) aiG).ajh();
        } else if (aiG instanceof com.baidu.tieba.homepage.personalize.a) {
            ((com.baidu.tieba.homepage.personalize.a) aiG).ajh();
        }
    }

    public void aiI() {
        int i = com.baidu.tieba.homepage.framework.a.a.aiU().cvN;
        if (i == 0) {
            if (this.cux != null) {
                this.cux.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.bpX, i % 3);
        if (bVar != null) {
            bVar.ajg();
        }
    }

    public void jH(int i) {
        if (i == 0 && this.cux != null) {
            this.cux.aji();
        } else if (i == com.baidu.tieba.homepage.framework.a.a.aiU().cvL && (aiG() instanceof com.baidu.tieba.homepage.recommendfrs.b)) {
            ((com.baidu.tieba.homepage.recommendfrs.b) aiG()).ajx();
        }
    }

    public void jI(int i) {
        com.baidu.tbadk.util.t.a(new e(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.framework.x xVar) {
        if (!this.cuA) {
            this.cuA = true;
            com.baidu.tbadk.util.t.a(new f(this), new g(this, xVar));
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.aFr;
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
