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
    private BdUniqueId aYu;
    private com.baidu.tieba.homepage.personalize.z cCj;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String aBd = null;
    private String cCk = "recommendFrsLastReadTabPositionNamespace";
    private String cCl = "recommendFrsLastReadTabPositionKey";
    private boolean cCm = false;
    private com.baidu.tieba.homepage.framework.d cCn = new b(this);
    private CustomMessageListener cCo = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener cBQ = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private int cCp = 0;
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.data.a> cCi = new ArrayList<>();
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.b> aXh = new ArrayList<>();

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        if (this.cCj != null) {
            this.cCj.a(aVar, onTouchListener, viewGroup);
        }
        if (this.aXh != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXh.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.a(aVar, onTouchListener);
                }
            }
        }
    }

    public void onPause() {
        jR(this.cCp);
        this.cCj.onPause();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXh.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onPause();
            }
        }
    }

    public void onResume() {
        if (this.cCj != null) {
            this.cCj.onResume();
        }
    }

    public void ku() {
        if (this.cCj != null) {
            this.cCj.ku();
        }
        if (this.aXh != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXh.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.ku();
                }
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cCj != null) {
            this.cCj.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.aXh != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXh.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.b(view, i, i2, i3, i4);
                }
            }
        }
        if (this.cCj != null) {
            this.cCj.b(view, i, i2, i3, i4);
        }
    }

    public a(Context context, com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aYu = bdUniqueId;
        this.aXh.add(a(bVar));
        this.aXh.add(a(bVar));
        this.aXh.add(a(bVar));
        this.cCj = new com.baidu.tieba.homepage.personalize.z(context);
        this.cCj.setPageUniqueId(bdUniqueId);
        this.cCj.setCallback(cVar);
        this.cCo.setTag(bdUniqueId);
        this.cBQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cCo);
        MessageManager.getInstance().registerListener(this.cBQ);
    }

    private com.baidu.tieba.homepage.recommendfrs.b a(com.baidu.tieba.homepage.framework.b bVar) {
        com.baidu.tieba.homepage.recommendfrs.b bVar2 = new com.baidu.tieba.homepage.recommendfrs.b(this.mContext);
        bVar2.j(this.aYu);
        bVar2.setCallback(bVar);
        bVar2.setScrollCallback(this.cCn);
        return bVar2;
    }

    public void aF(List<com.baidu.tieba.homepage.recommendfrs.data.a> list) {
        if (this.cCi == null) {
            this.cCi = new ArrayList<>();
        }
        this.cCi.clear();
        if (list != null && list.size() > 0) {
            this.cCi.addAll(list);
        }
        notifyDataSetChanged();
        alE();
    }

    private void alE() {
        int size = this.aXh.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.homepage.recommendfrs.b bVar = this.aXh.get(i % size);
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.y.c(this.cCi, i);
            if (bVar != null && aVar != null) {
                bVar.a(aVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.cCi != null && !this.cCi.isEmpty()) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cCi.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.amR() != null && j == next.amR().tag_code.longValue()) {
                    next.a(z, cVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void a(long j, String str, int i) {
        if (j == this.cCj.getTagCode()) {
            this.cCj.V(str, i);
        } else if (this.aXh != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXh.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.bJ(j)) {
                    next.V(str, i);
                    return;
                }
            }
        }
    }

    public void alF() {
        if (this.cCj != null) {
            this.cCj.alF();
            alG();
        }
    }

    private void a(long j, com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z) {
        if (this.aXh != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXh.iterator();
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
        if (this.cCi == null) {
            return 0;
        }
        return this.cCi.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.homepage.framework.a.a.alX().cDz != i) {
            eR(true);
            com.baidu.tieba.homepage.framework.a.a.alX().cDz = i;
            alG();
            VoiceManager bk = com.baidu.tieba.tbadkCore.voice.b.bk(this.mContext);
            if (bk != null) {
                bk.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.homepage.recommendfrs.b) {
                com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) obj;
                bVar.amB();
                bVar.YO();
                if (i == com.baidu.tieba.homepage.framework.a.a.alX().cDx) {
                    TiebaStatic.log(new ay("c10952"));
                    if (com.baidu.tieba.homepage.framework.a.a.alX().cDy != 0 || com.baidu.tieba.homepage.framework.a.a.alX().cDB) {
                        com.baidu.tieba.homepage.framework.a.a.alX().cDB = false;
                        eS(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.homepage.personalize.z) {
                com.baidu.tieba.homepage.personalize.z zVar = (com.baidu.tieba.homepage.personalize.z) obj;
                zVar.amB();
                zVar.YO();
            }
        }
        this.cCp = i;
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (com.baidu.tbadk.core.util.y.s(this.cCi) <= 0) {
            if (this.cCj != null) {
                this.cCj.a(dataRes, z);
            }
        } else if (j == 0 && (aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.y.c(this.cCi, 0)) != null) {
            aVar.c(dataRes);
            this.cCj.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.cCi.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.amR() != null && j == next.amR().tag_code.longValue()) {
                    next.c(dataRes);
                    next.fe(z);
                    this.cCj.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bB(long j) {
        if (this.cCi == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cCi.get(i);
            if (aVar != null && aVar.amR() != null && aVar.amR().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.cCj.getParent() != null) {
                viewGroup.removeView(this.cCj);
            }
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) com.baidu.tbadk.core.util.y.c(this.cCi, i);
            if (aVar != null) {
                this.cCj.setTagInfo(aVar.amR());
            }
            viewGroup.addView(this.cCj);
            return this.cCj;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = this.aXh.get(i % 3);
        if (bVar.getParent() != null) {
            viewGroup.removeView(bVar);
        }
        bVar.a(this.cCi.get(i), true, false);
        viewGroup.addView(bVar);
        if (i == 1) {
            bVar.setEnableLastReadPosition(true);
            return bVar;
        }
        bVar.setEnableLastReadPosition(false);
        return bVar;
    }

    private void alG() {
        this.lastResumeTime = System.currentTimeMillis();
        if (!alH() && com.baidu.tieba.homepage.framework.a.a.alX().cDz >= 0) {
            if (com.baidu.tieba.homepage.framework.a.a.alX().cDz == 0) {
                this.aBd = "a002";
            } else if (com.baidu.tieba.homepage.framework.a.a.alX().cDz == com.baidu.tieba.homepage.framework.a.a.alX().cDx) {
                this.aBd = "a003";
            } else {
                this.aBd = "a004";
            }
        }
    }

    private boolean alH() {
        int i = com.baidu.tieba.homepage.framework.a.a.alX().cDz;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.cCi.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo amR = aVar.amR();
        if (amR == null || amR.tag_type.intValue() != 5) {
            return false;
        }
        this.aBd = com.baidu.tieba.tbadkCore.v.qO(amR.lego_qs);
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
        if (this.cCi == null || this.cCi.get(i) == null || this.cCi.get(i).amR() == null) {
            return null;
        }
        return this.cCi.get(i).amR().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dl(int i) {
        if (this.aXh != null) {
            if (this.cCj != null) {
                this.cCj.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXh.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        alG();
        if (i == 0) {
            this.cCj.amB();
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.y.c(this.aXh, i % 3);
        if (bVar != null) {
            if (i == com.baidu.tieba.homepage.framework.a.a.alX().cDx) {
                TiebaStatic.log(new ay("c10952"));
            }
            if (i == com.baidu.tieba.homepage.framework.a.a.alX().cDx && com.baidu.tieba.homepage.framework.a.a.alX().cDB) {
                com.baidu.tieba.homepage.framework.a.a.alX().cDB = false;
                eS(false);
                return;
            }
            bVar.amB();
        }
    }

    public void eS(boolean z) {
        int i = com.baidu.tieba.homepage.framework.a.a.alX().cDz;
        if (i == 0) {
            if (this.cCj != null) {
                this.cCj.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.y.c(this.aXh, i % 3);
        if (bVar != null) {
            bVar.fd(z);
        }
    }

    private View alI() {
        int i = com.baidu.tieba.homepage.framework.a.a.alX().cDz;
        if (i == 0) {
            return this.cCj;
        }
        return (View) com.baidu.tbadk.core.util.y.c(this.aXh, i % 3);
    }

    public void onDestroy() {
        this.cCj.onDestroy();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aXh.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void eR(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.R(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.FM().a(this.mContext, pageStayDurationItem);
        }
        View alI = alI();
        if (alI instanceof com.baidu.tieba.homepage.recommendfrs.b) {
            ((com.baidu.tieba.homepage.recommendfrs.b) alI).amC();
        } else if (alI instanceof com.baidu.tieba.homepage.personalize.z) {
            ((com.baidu.tieba.homepage.personalize.z) alI).amC();
        }
    }

    public void alJ() {
        int i = com.baidu.tieba.homepage.framework.a.a.alX().cDz;
        if (i == 0) {
            if (this.cCj != null) {
                this.cCj.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) com.baidu.tbadk.core.util.y.c(this.aXh, i % 3);
        if (bVar != null) {
            bVar.amB();
        }
    }

    public void jQ(int i) {
        if (i == 0 && this.cCj != null) {
            this.cCj.amD();
        } else if (i == 1 && (alI() instanceof com.baidu.tieba.homepage.recommendfrs.b)) {
            ((com.baidu.tieba.homepage.recommendfrs.b) alI()).amy();
        }
    }

    public void jR(int i) {
        com.baidu.tbadk.util.u.a(new e(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.framework.x xVar) {
        if (!this.cCm) {
            this.cCm = true;
            com.baidu.tbadk.util.u.a(new f(this), new g(this, xVar));
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.aBd;
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
        if ((getPageStayFilter() == null || getPageStayFilter().FG()) && !StringUtils.isNull(currentPageKey)) {
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
        this.pageStayDurationItem.gd(getCurrentPageKey());
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
