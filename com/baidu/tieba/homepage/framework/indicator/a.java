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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.voice.VoiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends PagerAdapter implements com.baidu.tbadk.pageStayDuration.a {
    private BdUniqueId aTm;
    private com.baidu.tieba.homepage.personalize.z crb;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String axW = null;
    private String crc = "recommendFrsLastReadTabPositionNamespace";
    private String crd = "recommendFrsLastReadTabPositionKey";
    private boolean cre = false;
    private com.baidu.tieba.homepage.framework.d crf = new b(this);
    private CustomMessageListener crg = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener cqI = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private int crh = 0;
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.data.a> cra = new ArrayList<>();
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.b> aRJ = new ArrayList<>();

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        if (this.crb != null) {
            this.crb.a(aVar, onTouchListener, viewGroup);
        }
        if (this.aRJ != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aRJ.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.a(aVar, onTouchListener);
                }
            }
        }
    }

    public void onPause() {
        jp(this.crh);
        this.crb.onPause();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aRJ.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onPause();
            }
        }
    }

    public void jz() {
        if (this.crb != null) {
            this.crb.jz();
        }
        if (this.aRJ != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aRJ.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.jz();
                }
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.crb != null) {
            this.crb.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.aRJ != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aRJ.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.b(view, i, i2, i3, i4);
                }
            }
        }
        if (this.crb != null) {
            this.crb.b(view, i, i2, i3, i4);
        }
    }

    public a(Context context, com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aTm = bdUniqueId;
        this.aRJ.add(a(bVar));
        this.aRJ.add(a(bVar));
        this.aRJ.add(a(bVar));
        this.crb = new com.baidu.tieba.homepage.personalize.z(context);
        this.crb.setPageUniqueId(bdUniqueId);
        this.crb.setCallback(cVar);
        this.crg.setTag(bdUniqueId);
        this.cqI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.crg);
        MessageManager.getInstance().registerListener(this.cqI);
    }

    private com.baidu.tieba.homepage.recommendfrs.b a(com.baidu.tieba.homepage.framework.b bVar) {
        com.baidu.tieba.homepage.recommendfrs.b bVar2 = new com.baidu.tieba.homepage.recommendfrs.b(this.mContext);
        bVar2.j(this.aTm);
        bVar2.setCallback(bVar);
        bVar2.setScrollCallback(this.crf);
        return bVar2;
    }

    public void aD(List<com.baidu.tieba.homepage.recommendfrs.data.a> list) {
        if (this.cra == null) {
            this.cra = new ArrayList<>();
        }
        this.cra.clear();
        if (list != null && list.size() > 0) {
            this.cra.addAll(list);
        }
        notifyDataSetChanged();
        agT();
    }

    private void agT() {
        int size = this.aRJ.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.homepage.recommendfrs.b bVar = this.aRJ.get(i % size);
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.y.c(this.cra, i);
            if (bVar != null && aVar != null) {
                bVar.a(aVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cra != null && !this.cra.isEmpty()) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cra.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.aid() != null && j == next.aid().tag_code.longValue()) {
                    next.a(z, cVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void a(long j, String str, int i) {
        if (j == this.crb.getTagCode()) {
            this.crb.V(str, i);
        } else if (this.aRJ != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aRJ.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.bn(j)) {
                    next.V(str, i);
                    return;
                }
            }
        }
    }

    public void agU() {
        if (this.crb != null) {
            this.crb.agU();
            agV();
        }
    }

    private void a(long j, com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z) {
        if (this.aRJ != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aRJ.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.bn(j)) {
                    next.a(aVar, false, z);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.cra == null) {
            return 0;
        }
        return this.cra.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.homepage.framework.a.a.ahm().csr != i) {
            ev(true);
            com.baidu.tieba.homepage.framework.a.a.ahm().csr = i;
            agV();
            VoiceManager aX = com.baidu.tieba.tbadkCore.voice.b.aX(this.mContext);
            if (aX != null) {
                aX.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.homepage.recommendfrs.b) {
                com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) obj;
                bVar.ahM();
                bVar.XC();
                if (i == com.baidu.tieba.homepage.framework.a.a.ahm().csp) {
                    TiebaStatic.log(new ay("c10952"));
                    if (com.baidu.tieba.homepage.framework.a.a.ahm().csq != 0 || com.baidu.tieba.homepage.framework.a.a.ahm().cst) {
                        com.baidu.tieba.homepage.framework.a.a.ahm().cst = false;
                        ew(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.homepage.personalize.z) {
                com.baidu.tieba.homepage.personalize.z zVar = (com.baidu.tieba.homepage.personalize.z) obj;
                zVar.ahM();
                zVar.XC();
            }
        }
        this.crh = i;
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (com.baidu.tbadk.core.util.y.s(this.cra) <= 0) {
            if (this.crb != null) {
                this.crb.a(dataRes, z);
            }
        } else if (j == 0 && (aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.y.c(this.cra, 0)) != null) {
            aVar.c(dataRes);
            this.crb.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cra.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.aid() != null && j == next.aid().tag_code.longValue()) {
                    next.c(dataRes);
                    next.eI(z);
                    this.crb.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bf(long j) {
        if (this.cra == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cra.get(i);
            if (aVar != null && aVar.aid() != null && aVar.aid().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.crb.getParent() != null) {
                viewGroup.removeView(this.crb);
            }
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.y.c(this.cra, i);
            if (aVar != null) {
                this.crb.setTagInfo(aVar.aid());
            }
            viewGroup.addView(this.crb);
            return this.crb;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = this.aRJ.get(i % 3);
        if (bVar.getParent() != null) {
            viewGroup.removeView(bVar);
        }
        bVar.a(this.cra.get(i), true, false);
        viewGroup.addView(bVar);
        if (i == 1) {
            bVar.ahZ();
            return bVar;
        }
        return bVar;
    }

    private void agV() {
        this.lastResumeTime = System.currentTimeMillis();
        if (!agW() && com.baidu.tieba.homepage.framework.a.a.ahm().csr >= 0) {
            if (com.baidu.tieba.homepage.framework.a.a.ahm().csr == 0) {
                this.axW = "a002";
            } else if (com.baidu.tieba.homepage.framework.a.a.ahm().csr == com.baidu.tieba.homepage.framework.a.a.ahm().csp) {
                this.axW = "a003";
            } else {
                this.axW = "a004";
            }
        }
    }

    private boolean agW() {
        int i = com.baidu.tieba.homepage.framework.a.a.ahm().csr;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cra.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo aid = aVar.aid();
        if (aid == null || aid.tag_type.intValue() != 5) {
            return false;
        }
        this.axW = com.baidu.tieba.tbadkCore.w.qe(aid.lego_qs);
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
        if (this.cra == null || this.cra.get(i) == null || this.cra.get(i).aid() == null) {
            return null;
        }
        return this.cra.get(i).aid().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void cX(int i) {
        if (this.aRJ != null) {
            if (this.crb != null) {
                this.crb.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aRJ.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        agV();
        if (i == 0) {
            this.crb.ahM();
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.y.c(this.aRJ, i % 3);
        if (bVar != null) {
            if (i == com.baidu.tieba.homepage.framework.a.a.ahm().csp) {
                TiebaStatic.log(new ay("c10952"));
            }
            if (i == com.baidu.tieba.homepage.framework.a.a.ahm().csp && com.baidu.tieba.homepage.framework.a.a.ahm().cst) {
                com.baidu.tieba.homepage.framework.a.a.ahm().cst = false;
                ew(false);
                return;
            }
            bVar.ahM();
        }
    }

    public void ew(boolean z) {
        int i = com.baidu.tieba.homepage.framework.a.a.ahm().csr;
        if (i == 0) {
            if (this.crb != null) {
                this.crb.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.y.c(this.aRJ, i % 3);
        if (bVar != null) {
            bVar.eH(z);
        }
    }

    private View agX() {
        int i = com.baidu.tieba.homepage.framework.a.a.ahm().csr;
        if (i == 0) {
            return this.crb;
        }
        return (View) com.baidu.tbadk.core.util.y.c(this.aRJ, i % 3);
    }

    public void onDestroy() {
        this.crb.onDestroy();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aRJ.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void ev(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.N(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.Es().a(this.mContext, pageStayDurationItem);
        }
        View agX = agX();
        if (agX instanceof com.baidu.tieba.homepage.recommendfrs.b) {
            ((com.baidu.tieba.homepage.recommendfrs.b) agX).ahN();
        } else if (agX instanceof com.baidu.tieba.homepage.personalize.z) {
            ((com.baidu.tieba.homepage.personalize.z) agX).ahN();
        }
    }

    public void agY() {
        int i = com.baidu.tieba.homepage.framework.a.a.ahm().csr;
        if (i == 0) {
            if (this.crb != null) {
                this.crb.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.y.c(this.aRJ, i % 3);
        if (bVar != null) {
            bVar.ahM();
        }
    }

    public void jo(int i) {
        if (i == 0 && this.crb != null) {
            this.crb.ahO();
        } else if (i == 1 && (agX() instanceof com.baidu.tieba.homepage.recommendfrs.b)) {
            ((com.baidu.tieba.homepage.recommendfrs.b) agX()).ahJ();
        }
    }

    public void jp(int i) {
        com.baidu.tbadk.util.u.a(new e(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.framework.x xVar) {
        if (!this.cre) {
            this.cre = true;
            com.baidu.tbadk.util.u.a(new f(this), new g(this, xVar));
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.axW;
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
        if ((getPageStayFilter() == null || getPageStayFilter().Em()) && !StringUtils.isNull(currentPageKey)) {
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
        this.pageStayDurationItem.ga(getCurrentPageKey());
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
