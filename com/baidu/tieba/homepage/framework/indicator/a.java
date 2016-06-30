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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.homepage.personalize.s;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends PagerAdapter implements com.baidu.tbadk.pageStayDuration.a {
    private BdUniqueId aSq;
    private s coO;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String axh = null;
    private com.baidu.tieba.homepage.framework.d coP = new b(this);
    private CustomMessageListener coQ = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener cov = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.data.a> coN = new ArrayList<>();
    private ArrayList<com.baidu.tieba.homepage.recommendfrs.b> aQP = new ArrayList<>();

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        if (this.coO != null) {
            this.coO.a(aVar, onTouchListener, viewGroup);
        }
        if (this.aQP != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aQP.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.a(aVar, onTouchListener);
                }
            }
        }
    }

    public void jA() {
        if (this.coO != null) {
            this.coO.jA();
        }
        if (this.aQP != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aQP.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.jA();
                }
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.coO != null) {
            this.coO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.aQP != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aQP.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.b(view, i, i2, i3, i4);
                }
            }
        }
        if (this.coO != null) {
            this.coO.b(view, i, i2, i3, i4);
        }
    }

    public a(Context context, com.baidu.tieba.homepage.framework.b bVar, com.baidu.tieba.homepage.framework.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aSq = bdUniqueId;
        this.aQP.add(a(bVar));
        this.aQP.add(a(bVar));
        this.aQP.add(a(bVar));
        this.coO = new s(context);
        this.coO.setPageUniqueId(bdUniqueId);
        this.coO.setCallback(cVar);
        this.coQ.setTag(bdUniqueId);
        this.cov.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.coQ);
        MessageManager.getInstance().registerListener(this.cov);
    }

    private com.baidu.tieba.homepage.recommendfrs.b a(com.baidu.tieba.homepage.framework.b bVar) {
        com.baidu.tieba.homepage.recommendfrs.b bVar2 = new com.baidu.tieba.homepage.recommendfrs.b(this.mContext);
        bVar2.j(this.aSq);
        bVar2.setCallback(bVar);
        bVar2.setScrollCallback(this.coP);
        return bVar2;
    }

    public void az(List<com.baidu.tieba.homepage.recommendfrs.data.a> list) {
        if (this.coN == null) {
            this.coN = new ArrayList<>();
        }
        this.coN.clear();
        if (list != null && list.size() > 0) {
            this.coN.addAll(list);
        }
        notifyDataSetChanged();
        agq();
    }

    private void agq() {
        int size = this.aQP.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.homepage.recommendfrs.b bVar = this.aQP.get(i % size);
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) y.c(this.coN, i);
            if (bVar != null && aVar != null) {
                bVar.a(aVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2) {
        if (this.coN != null && !this.coN.isEmpty()) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.coN.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.aht() != null && j == next.aht().tag_code.longValue()) {
                    next.a(z, cVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void a(long j, String str, int i) {
        if (j == this.coO.getTagCode()) {
            this.coO.V(str, i);
        } else if (this.aQP != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aQP.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.bs(j)) {
                    next.V(str, i);
                    return;
                }
            }
        }
    }

    public void agr() {
        if (this.coO != null) {
            this.coO.agr();
            ags();
        }
    }

    private void a(long j, com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z) {
        if (this.aQP != null) {
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aQP.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null && next.bs(j)) {
                    next.a(aVar, false, z);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.coN == null) {
            return 0;
        }
        return this.coN.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.homepage.framework.a.a.agG().cpM != i) {
            eu(true);
            com.baidu.tieba.homepage.framework.a.a.agG().cpM = i;
            ags();
            VoiceManager aX = com.baidu.tieba.tbadkCore.voice.b.aX(this.mContext);
            if (aX != null) {
                aX.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.homepage.recommendfrs.b) {
                com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) obj;
                bVar.ahe();
                bVar.Xk();
                if (i == com.baidu.tieba.homepage.framework.a.a.agG().cpK) {
                    TiebaStatic.log(new ay("c10952"));
                    if (com.baidu.tieba.homepage.framework.a.a.agG().cpL != 0 || com.baidu.tieba.homepage.framework.a.a.agG().cpO) {
                        com.baidu.tieba.homepage.framework.a.a.agG().cpO = false;
                        ev(false);
                    }
                }
            } else if (obj instanceof s) {
                s sVar = (s) obj;
                sVar.ahe();
                sVar.Xk();
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (y.s(this.coN) <= 0) {
            if (this.coO != null) {
                this.coO.a(dataRes, z);
            }
        } else if (j == 0 && (aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) y.c(this.coN, 0)) != null) {
            aVar.c(dataRes);
            this.coO.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.homepage.recommendfrs.data.a> it = this.coN.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.data.a next = it.next();
                if (next != null && next.aht() != null && j == next.aht().tag_code.longValue()) {
                    next.c(dataRes);
                    next.eH(z);
                    this.coO.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bk(long j) {
        if (this.coN == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.coN.get(i);
            if (aVar != null && aVar.aht() != null && aVar.aht().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.coO.getParent() != null) {
                viewGroup.removeView(this.coO);
            }
            com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) y.c(this.coN, i);
            if (aVar != null) {
                this.coO.setTagInfo(aVar.aht());
            }
            viewGroup.addView(this.coO);
            return this.coO;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = this.aQP.get(i % 3);
        if (bVar.getParent() != null) {
            viewGroup.removeView(bVar);
        }
        bVar.a(this.coN.get(i), true, false);
        viewGroup.addView(bVar);
        return bVar;
    }

    private void ags() {
        this.lastResumeTime = System.currentTimeMillis();
        if (!agt() && com.baidu.tieba.homepage.framework.a.a.agG().cpM >= 0) {
            if (com.baidu.tieba.homepage.framework.a.a.agG().cpM == 0) {
                this.axh = "a002";
            } else if (com.baidu.tieba.homepage.framework.a.a.agG().cpM == com.baidu.tieba.homepage.framework.a.a.agG().cpK) {
                this.axh = "a003";
            } else {
                this.axh = "a004";
            }
        }
    }

    private boolean agt() {
        int i = com.baidu.tieba.homepage.framework.a.a.agG().cpM;
        if (i >= getCount() || i < 0) {
            return false;
        }
        com.baidu.tieba.homepage.recommendfrs.data.a aVar = this.coN.get(i);
        if (aVar == null) {
            return false;
        }
        TagInfo aht = aVar.aht();
        if (aht == null || aht.tag_type.intValue() != 5) {
            return false;
        }
        this.axh = w.pu(aht.lego_qs);
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
        if (this.coN == null || this.coN.get(i) == null || this.coN.get(i).aht() == null) {
            return null;
        }
        return this.coN.get(i).aht().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void cX(int i) {
        if (this.aQP != null) {
            if (this.coO != null) {
                this.coO.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aQP.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.recommendfrs.b next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        ags();
        if (i == 0) {
            this.coO.ahe();
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) y.c(this.aQP, i % 3);
        if (bVar != null) {
            if (i == com.baidu.tieba.homepage.framework.a.a.agG().cpK) {
                TiebaStatic.log(new ay("c10952"));
            }
            if (i == com.baidu.tieba.homepage.framework.a.a.agG().cpK && com.baidu.tieba.homepage.framework.a.a.agG().cpO) {
                com.baidu.tieba.homepage.framework.a.a.agG().cpO = false;
                ev(false);
                return;
            }
            bVar.ahe();
        }
    }

    public void ev(boolean z) {
        int i = com.baidu.tieba.homepage.framework.a.a.agG().cpM;
        if (i == 0) {
            if (this.coO != null) {
                this.coO.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) y.c(this.aQP, i % 3);
        if (bVar != null) {
            bVar.eG(z);
        }
    }

    private View agu() {
        int i = com.baidu.tieba.homepage.framework.a.a.agG().cpM;
        if (i == 0) {
            return this.coO;
        }
        return (View) y.c(this.aQP, i % 3);
    }

    public void onDestroy() {
        this.coO.onDestroy();
        Iterator<com.baidu.tieba.homepage.recommendfrs.b> it = this.aQP.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.recommendfrs.b next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void eu(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.S(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.Et().a(this.mContext, pageStayDurationItem);
        }
        View agu = agu();
        if (agu instanceof com.baidu.tieba.homepage.recommendfrs.b) {
            ((com.baidu.tieba.homepage.recommendfrs.b) agu).ahf();
        } else if (agu instanceof s) {
            ((s) agu).ahf();
        }
    }

    public void agv() {
        int i = com.baidu.tieba.homepage.framework.a.a.agG().cpM;
        if (i == 0) {
            if (this.coO != null) {
                this.coO.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.homepage.recommendfrs.b bVar = (com.baidu.tieba.homepage.recommendfrs.b) y.c(this.aQP, i % 3);
        if (bVar != null) {
            bVar.ahe();
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.axh;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        if (this.mContext instanceof com.baidu.tbadk.pageStayDuration.a) {
            arrayList2 = (ArrayList) ((com.baidu.tbadk.pageStayDuration.a) this.mContext).getCurrentPageSourceKeyList();
        }
        if (!y.t(arrayList2)) {
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
        if (y.t(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().En()) && !StringUtils.isNull(currentPageKey)) {
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
        this.pageStayDurationItem.gc(getCurrentPageKey());
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
