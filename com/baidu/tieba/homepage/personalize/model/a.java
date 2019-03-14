package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.p;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {
    private int fNw = 0;
    private com.baidu.tieba.homepage.personalize.b.d fNx = new com.baidu.tieba.homepage.personalize.b.d();
    private final c fHg = new c();
    private final int dfS = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_page_max_thread_count", 300);

    public int bmX() {
        return this.dfS;
    }

    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (i != 0 && i != 1) {
            return null;
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        if (builder2 == null) {
            builder2 = new DataRes.Builder();
        }
        d.c(builder);
        d.c(builder2);
        b(z, builder, builder2, i);
        a(builder, i, this.dfS);
        d.e(builder);
        List<p> b = d.b(builder);
        cA(b);
        List<m> l = l(builder.thread_list, b);
        this.fNx.cD(l);
        b.a(builder, l);
        this.fHg.cHJ = l;
        return this.fHg;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            a(z, builder.thread_list, builder2.thread_list, i);
            c(z, builder, builder2, i);
            k(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void k(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.fNw);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        if (list != null && list2 != null) {
            int S = v.S(list);
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null && !TextUtils.isEmpty(threadInfo.lego_card)) {
                    hashSet2.add(threadInfo.lego_card);
                } else if (threadInfo != null && threadInfo.tid != null) {
                    hashSet.add(threadInfo.tid);
                }
            }
            if (i == 1) {
                this.fNx.ay(list);
                for (ThreadInfo threadInfo2 : list2) {
                    if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                        if (!hashSet2.contains(threadInfo2.lego_card)) {
                            list.add(threadInfo2);
                        }
                    } else if (threadInfo2 != null && threadInfo2.tid != null && !hashSet.contains(threadInfo2.tid)) {
                        list.add(threadInfo2);
                    }
                }
            } else {
                this.fNx.a(z, list2.size() - 1, list, list2);
                for (int S2 = v.S(list2) - 1; S2 >= 0; S2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) v.c(list2, S2);
                    if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                        if (!hashSet2.contains(threadInfo3.lego_card)) {
                            list.add(0, threadInfo3);
                        }
                    } else if (threadInfo3 != null && threadInfo3.tid != null && !hashSet.contains(threadInfo3.tid)) {
                        list.add(0, threadInfo3);
                    }
                }
            }
            int S3 = v.S(list);
            this.fHg.fNz = S3 - S;
            this.fNw = S3 - S;
        }
    }

    private void cA(List<p> list) {
        if (list != null) {
            Collections.sort(list, new Comparator<p>() { // from class: com.baidu.tieba.homepage.personalize.model.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(p pVar, p pVar2) {
                    if (pVar == null || pVar2 == null) {
                        return 0;
                    }
                    if (pVar.getPosition() > pVar2.getPosition()) {
                        return 1;
                    }
                    return pVar.getPosition() < pVar2.getPosition() ? -1 : 0;
                }
            });
        }
    }

    private List<m> l(List<ThreadInfo> list, List<p> list2) {
        boolean z;
        boolean z2;
        p pVar;
        int i;
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        p pVar2 = null;
        if (v.S(list2) > 0) {
            z = true;
        } else {
            z = false;
        }
        Iterator<ThreadInfo> it = list.iterator();
        boolean z3 = true;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean z4 = z3;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            if (z && z4 && i2 < v.S(list2)) {
                z2 = false;
                pVar = (p) v.c(list2, i2);
            } else {
                p pVar3 = pVar2;
                z2 = z4;
                pVar = pVar3;
            }
            if (next != null) {
                if (pVar != null && pVar.getPosition() - 1 == i3) {
                    linkedList.add(pVar);
                    z2 = true;
                    i2++;
                }
                bg bgVar = new bg();
                bgVar.a(next);
                bgVar.setCurrentPage(1);
                if (!TextUtils.isEmpty(bgVar.ZT())) {
                    ad adVar = new ad();
                    adVar.la(bgVar.ZT());
                    adVar.position = i3;
                    linkedList.add(adVar);
                } else if (k.W(bgVar) || l.W(bgVar)) {
                    int[] aq = aq(bgVar);
                    k as = d.as(bgVar);
                    if (as != null) {
                        as.tid = bgVar.getTid();
                        as.position = i3;
                        d.a(as);
                    }
                    if (as != null && as.isValid()) {
                        linkedList.add(as);
                    }
                    com.baidu.tieba.card.data.c ar = d.ar(bgVar);
                    if (ar != null) {
                        ar.tid = bgVar.getTid();
                        ar.position = i3;
                        if (ar instanceof k) {
                            if (bgVar.ZP() == 1) {
                                d.b(ar);
                                ar.bAN = aq[0];
                                ar.bAO = aq[1];
                            } else if (bgVar.ZP() >= 2) {
                                d.c(ar);
                            } else {
                                d.d(ar);
                            }
                        } else if (ar instanceof l) {
                            d.e(ar);
                        }
                    }
                    if (ar != null && ar.isValid()) {
                        linkedList.add(ar);
                    }
                    k as2 = d.as(bgVar);
                    if (as2 != null) {
                        as2.tid = bgVar.getTid();
                        as2.position = i3;
                        d.f(as2);
                    }
                    if (as2 != null && as2.isValid()) {
                        linkedList.add(as2);
                    }
                    if (next.top_agree_post != null) {
                        k as3 = d.as(bgVar);
                        if (as3 != null) {
                            as3.tid = bgVar.getTid();
                            as3.position = i3;
                            d.g(as3);
                        }
                        if (as3 != null && as3.isValid()) {
                            linkedList.add(as3);
                        }
                    }
                    k as4 = d.as(bgVar);
                    if (as4 != null) {
                        as4.tid = bgVar.getTid();
                        as4.position = i3;
                        d.h(as4);
                    }
                    if (as4 != null && as4.isValid()) {
                        linkedList.add(as4);
                    }
                } else {
                    com.baidu.tieba.card.data.c ar2 = d.ar(bgVar);
                    if (ar2 != null) {
                        ar2.tid = bgVar.getTid();
                        ar2.position = i3;
                    }
                    if (ar2 != null && ar2.isValid()) {
                        linkedList.add(ar2);
                    }
                }
                i = i3 + 1;
            } else {
                i = i3;
            }
            i3 = i;
            z3 = z2;
            pVar2 = pVar;
        }
    }

    private int[] aq(bg bgVar) {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.aS(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> Zb = bgVar.Zb();
        if (i.Wy().WC() && v.S(Zb) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < Zb.size(); i3++) {
                MediaData mediaData = (MediaData) v.c(Zb, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) v.c(Zb, 0);
        if (mediaData2 != null && mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
            if (mediaData2.picWidth * 2 <= mediaData2.picHeight) {
                i = ((int) (i2 * 1.5f)) + dimensionPixelSize;
                i2 = (i2 * 2) + dimensionPixelSize;
            } else if (mediaData2.picHeight * 2 <= mediaData2.picWidth) {
                i = (i2 * 2) + dimensionPixelSize;
                i2 = ((int) (i2 * 1.5f)) + dimensionPixelSize;
            } else if (mediaData2.picWidth < i2) {
                if (mediaData2.picHeight < i2) {
                    if (mediaData2.picWidth < mediaData2.picHeight) {
                        int i4 = (mediaData2.picHeight * i2) / mediaData2.picWidth;
                        i = i2;
                        i2 = i4;
                    } else {
                        i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
                    }
                } else if (mediaData2.picHeight < i2 || mediaData2.picHeight >= i2 * 2) {
                    i2 = 0;
                    i = 0;
                } else {
                    int i5 = (mediaData2.picHeight * i2) / mediaData2.picWidth;
                    i = i2;
                    i2 = i5;
                }
            } else if (mediaData2.picWidth >= i2 && mediaData2.picWidth < i2 * 2) {
                if (mediaData2.picHeight < i2) {
                    i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
                } else if (mediaData2.picHeight >= i2 && mediaData2.picHeight < i2 * 2) {
                    int i6 = mediaData2.picWidth;
                    i2 = mediaData2.picHeight;
                    i = i6;
                } else {
                    i2 = (i2 * 2) + dimensionPixelSize;
                    i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
                }
            } else if (mediaData2.picHeight < i2) {
                i2 = 0;
                i = 0;
            } else if (mediaData2.picHeight >= i2 && mediaData2.picHeight < i2 * 2) {
                int i7 = (i2 * 2) + dimensionPixelSize;
                i2 = (mediaData2.picHeight * i7) / mediaData2.picWidth;
                i = i7;
            } else if (mediaData2.picWidth < mediaData2.picHeight) {
                i2 = (i2 * 2) + dimensionPixelSize;
                i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
            } else {
                int i8 = (i2 * 2) + dimensionPixelSize;
                i2 = (mediaData2.picHeight * i8) / mediaData2.picWidth;
                i = i8;
            }
        } else {
            i2 = (i2 * 2) + dimensionPixelSize;
            i = i2;
        }
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int S = (v.S(list) - i2) + 30;
                while (true) {
                    S--;
                    if (S >= 30) {
                        if (list.size() > S) {
                            list.remove(S);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int S2 = v.S(list) - 1; S2 >= i2; S2--) {
                    list.remove(S2);
                }
            }
        }
    }
}
