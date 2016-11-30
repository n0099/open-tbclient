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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.voice.VoiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends PagerAdapter implements com.baidu.tbadk.pageStayDuration.a {
    private BdUniqueId bcf;
    private com.baidu.tieba.homepage.personalize.a cIb;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String aBx = null;
    private String cIc = "recommendFrsLastReadTabPositionNamespace";
    private String cId = "recommendFrsLastReadTabPositionKey";
    private boolean cIe = false;
    private com.baidu.tieba.homepage.framework.d cIf = new b(this);
    private CustomMessageListener cIg = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener cHI = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private int cIh = 0;
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.data.a> cIa = new ArrayList<>();
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.b> baU = new ArrayList<>();

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cIb != null) {
            this.cIb.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
        if (this.baU != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.baU.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setRecommendFrsNavigationAnimDispatcher(eVar);
                }
            }
        }
    }

    public void onPause() {
        ke(this.cIh);
        this.cIb.onPause();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.baU.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onPause();
            }
        }
    }

    public void onResume() {
        if (this.cIb != null) {
            this.cIb.onResume();
        }
    }

    public void ku() {
        if (this.cIb != null) {
            this.cIb.ku();
        }
        if (this.baU != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.baU.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.ku();
                }
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cIb != null) {
            this.cIb.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.baU != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.baU.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.b(view, i, i2, i3, i4);
                }
            }
        }
        if (this.cIb != null) {
            this.cIb.b(view, i, i2, i3, i4);
        }
    }

    public a(Context context, com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.bcf = bdUniqueId;
        this.baU.add(a(bVar));
        this.baU.add(a(bVar));
        this.baU.add(a(bVar));
        this.cIb = new com.baidu.tieba.homepage.personalize.a(context);
        this.cIb.setPageUniqueId(bdUniqueId);
        this.cIb.setCallback(cVar);
        this.cIg.setTag(bdUniqueId);
        this.cHI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cIg);
        MessageManager.getInstance().registerListener(this.cHI);
    }

    private com.baidu.tieba.homepage.recommendfrs.b a(com.baidu.tieba.homepage.framework.b bVar) {
        com.baidu.tieba.homepage.recommendfrs.b bVar2 = new com.baidu.tieba.homepage.recommendfrs.b(this.mContext);
        bVar2.j(this.bcf);
        bVar2.setCallback(bVar);
        bVar2.setScrollCallback(this.cIf);
        return bVar2;
    }

    public void aH(List<com.baidu.tieba.homepage.recommendfrs.data.a> list) {
        if (this.cIa == null) {
            this.cIa = new ArrayList<>();
        }
        this.cIa.clear();
        if (list != null && list.size() > 0) {
            this.cIa.addAll(list);
        }
        notifyDataSetChanged();
        anN();
    }

    private void anN() {
        int size = this.baU.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.homepage.recommendfrs.b bVar = this.baU.get(i % size);
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cIa, i);
            if (bVar != null && aVar != null) {
                bVar.a(aVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cIa != null && !this.cIa.isEmpty()) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cIa.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.aoZ() != null && j == next.aoZ().tag_code.longValue()) {
                    next.a(z, cVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void a(long j, String str, int i) {
        if (j == this.cIb.getTagCode()) {
            this.cIb.V(str, i);
        } else if (this.baU != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.baU.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.bI(j)) {
                    next.V(str, i);
                    return;
                }
            }
        }
    }

    public void anO() {
        if (this.cIb != null) {
            this.cIb.anO();
            anP();
        }
    }

    private void a(long j, com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z) {
        if (this.baU != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.baU.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.bI(j)) {
                    next.a(aVar, false, z);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.cIa == null) {
            return 0;
        }
        return this.cIa.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.homepage.framework.a.a.aog().cJr != i) {
            fh(true);
            com.baidu.tieba.homepage.framework.a.a.aog().cJr = i;
            anP();
            anS();
            VoiceManager bv = com.baidu.tieba.tbadkCore.voice.b.bv(this.mContext);
            if (bv != null) {
                bv.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.homepage.recommendfrs.b) {
                com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) obj;
                bVar.aot();
                bVar.aaf();
                if (i == com.baidu.tieba.homepage.framework.a.a.aog().cJp) {
                    TiebaStatic.log(new av("c10952"));
                    if (com.baidu.tieba.homepage.framework.a.a.aog().cJq != 0 || com.baidu.tieba.homepage.framework.a.a.aog().cJt) {
                        com.baidu.tieba.homepage.framework.a.a.aog().cJt = false;
                        fi(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.homepage.personalize.a) {
                com.baidu.tieba.homepage.personalize.a aVar = (com.baidu.tieba.homepage.personalize.a) obj;
                aVar.aot();
                aVar.aaf();
            }
        }
        this.cIh = i;
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (com.baidu.tbadk.core.util.x.s(this.cIa) <= 0) {
            if (this.cIb != null) {
                this.cIb.a(dataRes, z);
            }
        } else if (j == 0 && (aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cIa, 0)) != null) {
            aVar.c(dataRes);
            this.cIb.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cIa.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.aoZ() != null && j == next.aoZ().tag_code.longValue()) {
                    next.c(dataRes);
                    next.fu(z);
                    this.cIb.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bA(long j) {
        if (this.cIa == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cIa.get(i);
            if (aVar != null && aVar.aoZ() != null && aVar.aoZ().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.cIb.getParent() != null) {
                viewGroup.removeView(this.cIb);
            }
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.x.c(this.cIa, i);
            if (aVar != null) {
                this.cIb.setTagInfo(aVar.aoZ());
            }
            viewGroup.addView(this.cIb);
            return this.cIb;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = this.baU.get(i % 3);
        if (bVar.getParent() != null) {
            viewGroup.removeView(bVar);
        }
        bVar.a(this.cIa.get(i), true, false);
        viewGroup.addView(bVar);
        if (i == 1) {
            bVar.setEnableLastReadPosition(true);
            return bVar;
        }
        bVar.setEnableLastReadPosition(false);
        return bVar;
    }

    private void anP() {
        this.lastResumeTime = System.currentTimeMillis();
        if (!anQ() && com.baidu.tieba.homepage.framework.a.a.aog().cJr >= 0) {
            if (com.baidu.tieba.homepage.framework.a.a.aog().cJr == 0) {
                this.aBx = "a002";
            } else if (com.baidu.tieba.homepage.framework.a.a.aog().cJr == com.baidu.tieba.homepage.framework.a.a.aog().cJp) {
                this.aBx = "a003";
            } else {
                this.aBx = "a004";
            }
        }
    }

    private boolean anQ() {
        int i = com.baidu.tieba.homepage.framework.a.a.aog().cJr;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cIa.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo aoZ = aVar.aoZ();
        if (aoZ == null || aoZ.tag_type.intValue() != 5) {
            return false;
        }
        this.aBx = com.baidu.tieba.tbadkCore.v.rw(aoZ.lego_qs);
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
        if (this.cIa == null || this.cIa.get(i) == null || this.cIa.get(i).aoZ() == null) {
            return null;
        }
        return this.cIa.get(i).aoZ().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dm(int i) {
        if (this.baU != null) {
            if (this.cIb != null) {
                this.cIb.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.baU.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        anP();
        if (i == 0) {
            this.cIb.aot();
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.baU, i % 3);
        if (bVar != null) {
            if (i == com.baidu.tieba.homepage.framework.a.a.aog().cJp) {
                TiebaStatic.log(new av("c10952"));
            }
            if (i == com.baidu.tieba.homepage.framework.a.a.aog().cJp && com.baidu.tieba.homepage.framework.a.a.aog().cJt) {
                com.baidu.tieba.homepage.framework.a.a.aog().cJt = false;
                fi(false);
                return;
            }
            bVar.aot();
        }
    }

    public void fi(boolean z) {
        int i = com.baidu.tieba.homepage.framework.a.a.aog().cJr;
        if (i == 0) {
            if (this.cIb != null) {
                this.cIb.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.baU, i % 3);
        if (bVar != null) {
            bVar.ft(z);
        }
    }

    private View anR() {
        int i = com.baidu.tieba.homepage.framework.a.a.aog().cJr;
        if (i == 0) {
            return this.cIb;
        }
        return (View) com.baidu.tbadk.core.util.x.c(this.baU, i % 3);
    }

    public void onDestroy() {
        this.cIb.onDestroy();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.baU.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void anS() {
        View anR = anR();
        if (this.cIb != null) {
            this.cIb.setTabInForeBackgroundState(this.cIb != anR);
        }
        if (this.baU != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.baU.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.setTabInForeBackgroundState(next != anR);
                }
            }
        }
    }

    public void fh(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.Q(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.FP().a(this.mContext, pageStayDurationItem);
        }
        View anR = anR();
        if (anR instanceof com.baidu.tieba.homepage.recommendfrs.b) {
            ((com.baidu.tieba.homepage.recommendfrs.b) anR).aou();
        } else if (anR instanceof com.baidu.tieba.homepage.personalize.a) {
            ((com.baidu.tieba.homepage.personalize.a) anR).aou();
        }
    }

    public void anT() {
        int i = com.baidu.tieba.homepage.framework.a.a.aog().cJr;
        if (i == 0) {
            if (this.cIb != null) {
                this.cIb.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.x.c(this.baU, i % 3);
        if (bVar != null) {
            bVar.aot();
        }
    }

    public void kd(int i) {
        if (i == 0 && this.cIb != null) {
            this.cIb.aov();
        } else if (i == 1 && (anR() instanceof com.baidu.tieba.homepage.recommendfrs.b)) {
            ((com.baidu.tieba.homepage.recommendfrs.b) anR()).aoK();
        }
    }

    public void ke(int i) {
        com.baidu.tbadk.util.t.a(new e(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.framework.x xVar) {
        if (!this.cIe) {
            this.cIe = true;
            com.baidu.tbadk.util.t.a(new f(this), new g(this, xVar));
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.aBx;
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
        if ((getPageStayFilter() == null || getPageStayFilter().FJ()) && !StringUtils.isNull(currentPageKey)) {
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
        this.pageStayDurationItem.gk(getCurrentPageKey());
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
