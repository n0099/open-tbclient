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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.voice.VoiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends PagerAdapter implements com.baidu.tbadk.pageStayDuration.a {
    private BdUniqueId aUC;
    private com.baidu.tieba.homepage.personalize.a cuy;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String azJ = null;
    private String cuz = "recommendFrsLastReadTabPositionNamespace";
    private String cuA = "recommendFrsLastReadTabPositionKey";
    private boolean cuB = false;
    private com.baidu.tieba.homepage.framework.d cuC = new b(this);
    private CustomMessageListener cuD = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener cuc = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private int cuE = 0;
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.data.a> cux = new ArrayList<>();
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.b> bjv = new ArrayList<>();

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cuy != null) {
            this.cuy.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
        if (this.bjv != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bjv.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setRecommendFrsNavigationAnimDispatcher(eVar);
                }
            }
        }
    }

    public void onPause() {
        kc(this.cuE);
        this.cuy.onPause();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bjv.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onPause();
            }
        }
    }

    public void onResume() {
        if (this.cuy != null) {
            this.cuy.onResume();
        }
    }

    public void completePullRefresh() {
        if (this.cuy != null) {
            this.cuy.completePullRefresh();
        }
        if (this.bjv != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bjv.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.completePullRefresh();
                }
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cuy != null) {
            this.cuy.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.bjv != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bjv.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.b(view, i, i2, i3, i4);
                }
            }
        }
        if (this.cuy != null) {
            this.cuy.b(view, i, i2, i3, i4);
        }
    }

    public a(Context context, com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aUC = bdUniqueId;
        this.bjv.add(a(bVar));
        this.bjv.add(a(bVar));
        this.bjv.add(a(bVar));
        this.cuy = new com.baidu.tieba.homepage.personalize.a(context);
        this.cuy.setPageUniqueId(bdUniqueId);
        this.cuy.setCallback(cVar);
        this.cuD.setTag(bdUniqueId);
        this.cuc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cuD);
        MessageManager.getInstance().registerListener(this.cuc);
    }

    private com.baidu.tieba.homepage.recommendfrs.b a(com.baidu.tieba.homepage.framework.b bVar) {
        com.baidu.tieba.homepage.recommendfrs.b bVar2 = new com.baidu.tieba.homepage.recommendfrs.b(this.mContext);
        bVar2.j(this.aUC);
        bVar2.setCallback(bVar);
        bVar2.setScrollCallback(this.cuC);
        return bVar2;
    }

    public void aD(List<com.baidu.tieba.homepage.recommendfrs.data.a> list) {
        if (this.cux == null) {
            this.cux = new ArrayList<>();
        }
        this.cux.clear();
        if (list != null && list.size() > 0) {
            this.cux.addAll(list);
        }
        notifyDataSetChanged();
        aju();
    }

    private void aju() {
        int size = this.bjv.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.homepage.recommendfrs.b bVar = this.bjv.get(i % size);
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.w.c(this.cux, i);
            if (bVar != null && aVar != null) {
                bVar.a(aVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cux != null && !this.cux.isEmpty()) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cux.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.akH() != null && j == next.akH().tag_code.longValue()) {
                    next.a(z, cVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void a(long j, String str, int i) {
        if (j == this.cuy.getTagCode()) {
            this.cuy.T(str, i);
        } else if (this.bjv != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bjv.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.br(j)) {
                    next.T(str, i);
                    return;
                }
            }
        }
    }

    public void ajv() {
        if (this.cuy != null) {
            this.cuy.ajv();
            ajw();
        }
    }

    private void a(long j, com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z) {
        if (this.bjv != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bjv.iterator();
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
        if (this.cux == null) {
            return 0;
        }
        return this.cux.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.homepage.framework.a.a.ajO().cvO != i) {
            eW(true);
            com.baidu.tieba.homepage.framework.a.a.ajO().cvO = i;
            ajw();
            ajA();
            VoiceManager bw = com.baidu.tieba.tbadkCore.voice.b.bw(this.mContext);
            if (bw != null) {
                bw.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.homepage.recommendfrs.b) {
                com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) obj;
                bVar.aka();
                bVar.VN();
                if (i == com.baidu.tieba.homepage.framework.a.a.ajO().cvM) {
                    TiebaStatic.log(new ar("c10952"));
                    if (com.baidu.tieba.homepage.framework.a.a.ajO().cvN != 0 || com.baidu.tieba.homepage.framework.a.a.ajO().cvQ) {
                        com.baidu.tieba.homepage.framework.a.a.ajO().cvQ = false;
                        eX(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.homepage.personalize.a) {
                com.baidu.tieba.homepage.personalize.a aVar = (com.baidu.tieba.homepage.personalize.a) obj;
                aVar.aka();
                aVar.VN();
            }
        }
        this.cuE = i;
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (com.baidu.tbadk.core.util.w.r(this.cux) <= 0) {
            if (this.cuy != null) {
                this.cuy.a(dataRes, z);
            }
        } else if (j == 0 && (aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.w.c(this.cux, 0)) != null) {
            aVar.c(dataRes);
            this.cuy.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cux.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.akH() != null && j == next.akH().tag_code.longValue()) {
                    next.c(dataRes);
                    next.fj(z);
                    this.cuy.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bj(long j) {
        if (this.cux == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cux.get(i);
            if (aVar != null && aVar.akH() != null && aVar.akH().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.cuy.getParent() != null) {
                viewGroup.removeView(this.cuy);
            }
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.w.c(this.cux, i);
            if (aVar != null) {
                this.cuy.setTagInfo(aVar.akH());
            }
            viewGroup.addView(this.cuy);
            return this.cuy;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = this.bjv.get(i % 3);
        if (bVar.getParent() != null) {
            viewGroup.removeView(bVar);
        }
        bVar.a(this.cux.get(i), true, false);
        viewGroup.addView(bVar);
        if (i - 1 == com.baidu.tieba.homepage.framework.a.a.ajO().cvM) {
            bVar.setEnableLastReadPosition(true);
            return bVar;
        }
        bVar.setEnableLastReadPosition(false);
        return bVar;
    }

    private void ajw() {
        this.lastResumeTime = System.currentTimeMillis();
        if (!ajy() && !ajx() && com.baidu.tieba.homepage.framework.a.a.ajO().cvO >= 0) {
            if (com.baidu.tieba.homepage.framework.a.a.ajO().cvO == 0) {
                this.azJ = "a002";
            } else if (com.baidu.tieba.homepage.framework.a.a.ajO().cvO == com.baidu.tieba.homepage.framework.a.a.ajO().cvM) {
                this.azJ = "a003";
            } else {
                this.azJ = "a004";
            }
        }
    }

    private boolean ajx() {
        int i = com.baidu.tieba.homepage.framework.a.a.ajO().cvO;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cux.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo akH = aVar.akH();
        if (akH == null || akH.tag_type.intValue() != 7) {
            return false;
        }
        this.azJ = "c11825";
        return true;
    }

    private boolean ajy() {
        int i = com.baidu.tieba.homepage.framework.a.a.ajO().cvO;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cux.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo akH = aVar.akH();
        if (akH == null || akH.tag_type.intValue() != 5) {
            return false;
        }
        this.azJ = com.baidu.tieba.tbadkCore.t.qu(akH.lego_qs);
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
        if (this.cux == null || this.cux.get(i) == null || this.cux.get(i).akH() == null) {
            return null;
        }
        return this.cux.get(i).akH().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dp(int i) {
        if (this.bjv != null) {
            if (this.cuy != null) {
                this.cuy.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bjv.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        ajw();
        if (i == 0) {
            this.cuy.aka();
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.w.c(this.bjv, i % 3);
        if (bVar != null) {
            if (i == com.baidu.tieba.homepage.framework.a.a.ajO().cvM) {
                TiebaStatic.log(new ar("c10952"));
            }
            if (i == com.baidu.tieba.homepage.framework.a.a.ajO().cvM && com.baidu.tieba.homepage.framework.a.a.ajO().cvQ) {
                com.baidu.tieba.homepage.framework.a.a.ajO().cvQ = false;
                eX(false);
                return;
            }
            bVar.aka();
        }
    }

    public void eX(boolean z) {
        int i = com.baidu.tieba.homepage.framework.a.a.ajO().cvO;
        if (i == 0) {
            if (this.cuy != null) {
                this.cuy.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.w.c(this.bjv, i % 3);
        if (bVar != null) {
            bVar.fi(z);
        }
    }

    private View ajz() {
        int i = com.baidu.tieba.homepage.framework.a.a.ajO().cvO;
        if (i == 0) {
            return this.cuy;
        }
        return (View) com.baidu.tbadk.core.util.w.c(this.bjv, i % 3);
    }

    public void onDestroy() {
        this.cuy.onDestroy();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bjv.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void ajA() {
        View ajz = ajz();
        if (this.cuy != null) {
            this.cuy.setTabInForeBackgroundState(this.cuy != ajz);
        }
        if (this.bjv != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.bjv.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setTabInForeBackgroundState(next != ajz);
                }
            }
        }
    }

    public void eW(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.O(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.Fj().a(this.mContext, pageStayDurationItem);
        }
        View ajz = ajz();
        if (ajz instanceof com.baidu.tieba.homepage.recommendfrs.b) {
            ((com.baidu.tieba.homepage.recommendfrs.b) ajz).akb();
        } else if (ajz instanceof com.baidu.tieba.homepage.personalize.a) {
            ((com.baidu.tieba.homepage.personalize.a) ajz).akb();
        }
    }

    public void ajB() {
        int i = com.baidu.tieba.homepage.framework.a.a.ajO().cvO;
        if (i == 0) {
            if (this.cuy != null) {
                this.cuy.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.w.c(this.bjv, i % 3);
        if (bVar != null) {
            bVar.aka();
        }
    }

    public void kb(int i) {
        if (i == 0 && this.cuy != null) {
            this.cuy.akc();
        } else if (i == com.baidu.tieba.homepage.framework.a.a.ajO().cvM && (ajz() instanceof com.baidu.tieba.homepage.recommendfrs.b)) {
            ((com.baidu.tieba.homepage.recommendfrs.b) ajz()).akr();
        }
    }

    public void kc(int i) {
        com.baidu.tbadk.util.t.a(new e(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.framework.x xVar) {
        if (!this.cuB) {
            this.cuB = true;
            com.baidu.tbadk.util.t.a(new f(this), new g(this, xVar));
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.azJ;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        if (this.mContext instanceof com.baidu.tbadk.pageStayDuration.a) {
            arrayList2 = (ArrayList) ((com.baidu.tbadk.pageStayDuration.a) this.mContext).getCurrentPageSourceKeyList();
        }
        if (!com.baidu.tbadk.core.util.w.s(arrayList2)) {
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
        if (com.baidu.tbadk.core.util.w.s(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Fd()) && !StringUtils.isNull(currentPageKey)) {
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
        this.pageStayDurationItem.B(getCurrentPageSourceKeyList());
        this.pageStayDurationItem.gc(getCurrentPageKey());
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
