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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.voice.VoiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends PagerAdapter implements com.baidu.tbadk.pageStayDuration.a {
    private BdUniqueId bbl;
    private com.baidu.tieba.homepage.personalize.a cnw;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String aAR = null;
    private String cnx = "recommendFrsLastReadTabPositionNamespace";
    private String cny = "recommendFrsLastReadTabPositionKey";
    private boolean cnz = false;
    private com.baidu.tieba.homepage.framework.d cnA = new b(this);
    private CustomMessageListener cnB = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener cnc = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private int cnC = 0;
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.data.a> cnv = new ArrayList<>();
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.b> aZH = new ArrayList<>();

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cnw != null) {
            this.cnw.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
        if (this.aZH != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aZH.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setRecommendFrsNavigationAnimDispatcher(eVar);
                }
            }
        }
    }

    public void onPause() {
        jp(this.cnC);
        this.cnw.onPause();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aZH.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onPause();
            }
        }
    }

    public void onResume() {
        if (this.cnw != null) {
            this.cnw.onResume();
        }
    }

    public void ku() {
        if (this.cnw != null) {
            this.cnw.ku();
        }
        if (this.aZH != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aZH.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.ku();
                }
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cnw != null) {
            this.cnw.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.aZH != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aZH.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.b(view, i, i2, i3, i4);
                }
            }
        }
        if (this.cnw != null) {
            this.cnw.b(view, i, i2, i3, i4);
        }
    }

    public a(Context context, com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.bbl = bdUniqueId;
        this.aZH.add(a(bVar));
        this.aZH.add(a(bVar));
        this.aZH.add(a(bVar));
        this.cnw = new com.baidu.tieba.homepage.personalize.a(context);
        this.cnw.setPageUniqueId(bdUniqueId);
        this.cnw.setCallback(cVar);
        this.cnB.setTag(bdUniqueId);
        this.cnc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cnB);
        MessageManager.getInstance().registerListener(this.cnc);
    }

    private com.baidu.tieba.homepage.recommendfrs.b a(com.baidu.tieba.homepage.framework.b bVar) {
        com.baidu.tieba.homepage.recommendfrs.b bVar2 = new com.baidu.tieba.homepage.recommendfrs.b(this.mContext);
        bVar2.j(this.bbl);
        bVar2.setCallback(bVar);
        bVar2.setScrollCallback(this.cnA);
        return bVar2;
    }

    public void az(List<com.baidu.tieba.homepage.recommendfrs.data.a> list) {
        if (this.cnv == null) {
            this.cnv = new ArrayList<>();
        }
        this.cnv.clear();
        if (list != null && list.size() > 0) {
            this.cnv.addAll(list);
        }
        notifyDataSetChanged();
        ain();
    }

    private void ain() {
        int size = this.aZH.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.homepage.recommendfrs.b bVar = this.aZH.get(i % size);
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cnv, i);
            if (bVar != null && aVar != null) {
                bVar.a(aVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cnv != null && !this.cnv.isEmpty()) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cnv.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.ajA() != null && j == next.ajA().tag_code.longValue()) {
                    next.a(z, cVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void a(long j, String str, int i) {
        if (j == this.cnw.getTagCode()) {
            this.cnw.T(str, i);
        } else if (this.aZH != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aZH.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.bw(j)) {
                    next.T(str, i);
                    return;
                }
            }
        }
    }

    public void aio() {
        if (this.cnw != null) {
            this.cnw.aio();
            aip();
        }
    }

    private void a(long j, com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z) {
        if (this.aZH != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aZH.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.bw(j)) {
                    next.a(aVar, false, z);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.cnv == null) {
            return 0;
        }
        return this.cnv.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.homepage.framework.a.a.aiG().coM != i) {
            eS(true);
            com.baidu.tieba.homepage.framework.a.a.aiG().coM = i;
            aip();
            ais();
            VoiceManager bu = com.baidu.tieba.tbadkCore.voice.b.bu(this.mContext);
            if (bu != null) {
                bu.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.homepage.recommendfrs.b) {
                com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) obj;
                bVar.aiT();
                bVar.Us();
                if (i == com.baidu.tieba.homepage.framework.a.a.aiG().coK) {
                    TiebaStatic.log(new at("c10952"));
                    if (com.baidu.tieba.homepage.framework.a.a.aiG().coL != 0 || com.baidu.tieba.homepage.framework.a.a.aiG().coO) {
                        com.baidu.tieba.homepage.framework.a.a.aiG().coO = false;
                        eT(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.homepage.personalize.a) {
                com.baidu.tieba.homepage.personalize.a aVar = (com.baidu.tieba.homepage.personalize.a) obj;
                aVar.aiT();
                aVar.Us();
            }
        }
        this.cnC = i;
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (com.baidu.tbadk.core.util.x.s(this.cnv) <= 0) {
            if (this.cnw != null) {
                this.cnw.a(dataRes, z);
            }
        } else if (j == 0 && (aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cnv, 0)) != null) {
            aVar.c(dataRes);
            this.cnw.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cnv.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.ajA() != null && j == next.ajA().tag_code.longValue()) {
                    next.c(dataRes);
                    next.ff(z);
                    this.cnw.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bo(long j) {
        if (this.cnv == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cnv.get(i);
            if (aVar != null && aVar.ajA() != null && aVar.ajA().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.cnw.getParent() != null) {
                viewGroup.removeView(this.cnw);
            }
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cnv, i);
            if (aVar != null) {
                this.cnw.setTagInfo(aVar.ajA());
            }
            viewGroup.addView(this.cnw);
            return this.cnw;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = this.aZH.get(i % 3);
        if (bVar.getParent() != null) {
            viewGroup.removeView(bVar);
        }
        bVar.a(this.cnv.get(i), true, false);
        viewGroup.addView(bVar);
        if (i == 1) {
            bVar.setEnableLastReadPosition(true);
            return bVar;
        }
        bVar.setEnableLastReadPosition(false);
        return bVar;
    }

    private void aip() {
        this.lastResumeTime = System.currentTimeMillis();
        if (!aiq() && com.baidu.tieba.homepage.framework.a.a.aiG().coM >= 0) {
            if (com.baidu.tieba.homepage.framework.a.a.aiG().coM == 0) {
                this.aAR = "a002";
            } else if (com.baidu.tieba.homepage.framework.a.a.aiG().coM == com.baidu.tieba.homepage.framework.a.a.aiG().coK) {
                this.aAR = "a003";
            } else {
                this.aAR = "a004";
            }
        }
    }

    private boolean aiq() {
        int i = com.baidu.tieba.homepage.framework.a.a.aiG().coM;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cnv.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo ajA = aVar.ajA();
        if (ajA == null || ajA.tag_type.intValue() != 5) {
            return false;
        }
        this.aAR = com.baidu.tieba.tbadkCore.u.qa(ajA.lego_qs);
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
        if (this.cnv == null || this.cnv.get(i) == null || this.cnv.get(i).ajA() == null) {
            return null;
        }
        return this.cnv.get(i).ajA().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* renamed from: do  reason: not valid java name */
    public void m18do(int i) {
        if (this.aZH != null) {
            if (this.cnw != null) {
                this.cnw.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aZH.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        aip();
        if (i == 0) {
            this.cnw.aiT();
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.aZH, i % 3);
        if (bVar != null) {
            if (i == com.baidu.tieba.homepage.framework.a.a.aiG().coK) {
                TiebaStatic.log(new at("c10952"));
            }
            if (i == com.baidu.tieba.homepage.framework.a.a.aiG().coK && com.baidu.tieba.homepage.framework.a.a.aiG().coO) {
                com.baidu.tieba.homepage.framework.a.a.aiG().coO = false;
                eT(false);
                return;
            }
            bVar.aiT();
        }
    }

    public void eT(boolean z) {
        int i = com.baidu.tieba.homepage.framework.a.a.aiG().coM;
        if (i == 0) {
            if (this.cnw != null) {
                this.cnw.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.aZH, i % 3);
        if (bVar != null) {
            bVar.fe(z);
        }
    }

    private View air() {
        int i = com.baidu.tieba.homepage.framework.a.a.aiG().coM;
        if (i == 0) {
            return this.cnw;
        }
        return (View) com.baidu.tbadk.core.util.x.c(this.aZH, i % 3);
    }

    public void onDestroy() {
        this.cnw.onDestroy();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aZH.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void ais() {
        View air = air();
        if (this.cnw != null) {
            this.cnw.setTabInForeBackgroundState(this.cnw != air);
        }
        if (this.aZH != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aZH.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setTabInForeBackgroundState(next != air);
                }
            }
        }
    }

    public void eS(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.P(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.Fp().a(this.mContext, pageStayDurationItem);
        }
        View air = air();
        if (air instanceof com.baidu.tieba.homepage.recommendfrs.b) {
            ((com.baidu.tieba.homepage.recommendfrs.b) air).aiU();
        } else if (air instanceof com.baidu.tieba.homepage.personalize.a) {
            ((com.baidu.tieba.homepage.personalize.a) air).aiU();
        }
    }

    public void ait() {
        int i = com.baidu.tieba.homepage.framework.a.a.aiG().coM;
        if (i == 0) {
            if (this.cnw != null) {
                this.cnw.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.aZH, i % 3);
        if (bVar != null) {
            bVar.aiT();
        }
    }

    public void jo(int i) {
        if (i == 0 && this.cnw != null) {
            this.cnw.aiV();
        } else if (i == 1 && (air() instanceof com.baidu.tieba.homepage.recommendfrs.b)) {
            ((com.baidu.tieba.homepage.recommendfrs.b) air()).ajk();
        }
    }

    public void jp(int i) {
        com.baidu.tbadk.util.t.a(new e(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.framework.x xVar) {
        if (!this.cnz) {
            this.cnz = true;
            com.baidu.tbadk.util.t.a(new f(this), new g(this, xVar));
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.aAR;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        if (this.mContext instanceof com.baidu.tbadk.pageStayDuration.a) {
            arrayList2 = (ArrayList) ((com.baidu.tbadk.pageStayDuration.a) this.mContext).getCurrentPageSourceKeyList();
        }
        if (!com.baidu.tbadk.core.util.x.t(arrayList2)) {
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
        if (com.baidu.tbadk.core.util.x.t(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Fj()) && !StringUtils.isNull(currentPageKey)) {
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
        this.pageStayDurationItem.gf(getCurrentPageKey());
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
