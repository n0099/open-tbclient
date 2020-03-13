package com.baidu.tieba.homepage.personalize.model;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.p;
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
/* loaded from: classes9.dex */
public class a {
    private int hfl = 0;
    private com.baidu.tieba.homepage.personalize.b.d hfm = new com.baidu.tieba.homepage.personalize.b.d();
    private final c gYD = new c();
    private final int hfk = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("home_page_max_thread_count", 300);

    public int bPj() {
        return this.hfk;
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
        List<ThreadInfo> a = a(builder, i, this.hfk);
        d.e(builder);
        List<p> b = d.b(builder);
        cE(b);
        List<m> n = n(builder.thread_list, b);
        List<m> n2 = n(a, new ArrayList());
        this.hfm.cH(n);
        b.a(builder, n);
        this.gYD.dTr = n;
        this.gYD.hfq = n2 == null ? 0 : n2.size();
        return this.gYD;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            a(z, builder.thread_list, builder2.thread_list, i);
            c(z, builder, builder2, i);
            m(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void m(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.hfl);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        if (list != null && list2 != null) {
            int count = v.getCount(list);
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
                this.hfm.ac(list);
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
                this.hfm.a(z, list2.size() - 1, list, list2);
                for (int count2 = v.getCount(list2) - 1; count2 >= 0; count2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) v.getItem(list2, count2);
                    if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                        if (!hashSet2.contains(threadInfo3.lego_card)) {
                            list.add(0, threadInfo3);
                        }
                    } else if (threadInfo3 != null && threadInfo3.tid != null && !hashSet.contains(threadInfo3.tid)) {
                        list.add(0, threadInfo3);
                    }
                }
            }
            int count3 = v.getCount(list);
            this.gYD.hfp = count3 - count;
            this.hfl = count3 - count;
        }
    }

    private void cE(List<p> list) {
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

    private List<m> n(List<ThreadInfo> list, List<p> list2) {
        int i;
        int i2;
        int i3;
        int i4;
        String format;
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int i5 = 0;
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bj bjVar = new bj();
                bjVar.cUs = true;
                bjVar.a(threadInfo);
                if (!TextUtils.isEmpty(bjVar.aDu())) {
                    ae aeVar = new ae();
                    aeVar.sx(bjVar.aDu());
                    aeVar.position = i5;
                    linkedList.add(aeVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.aa(bjVar)) {
                    if (!StringUtils.isNull(bjVar.aEd().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(bjVar.aEd());
                        aVar.from = 1;
                        aVar.position = i5;
                        aVar.setThreadData(bjVar);
                        linkedList.add(aVar);
                    }
                } else if (k.aa(bjVar) || l.aa(bjVar)) {
                    k aA = d.aA(bjVar);
                    if (aA != null && aA.cRg != null && aA.cRg.aDX() != null && !StringUtils.isNull(aA.cRg.aDX().forumName)) {
                        aA.tid = bjVar.getTid();
                        aA.position = i5;
                        d.h(aA);
                        linkedList.add(aA);
                    } else {
                        k aA2 = d.aA(bjVar);
                        if (aA2 != null) {
                            aA2.tid = bjVar.getTid();
                            aA2.position = i5;
                            d.a(aA2);
                        }
                        if (aA2 != null && aA2.isValid()) {
                            linkedList.add(aA2);
                        }
                    }
                    int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.c az = d.az(bjVar);
                    if (az != null) {
                        az.tid = bjVar.getTid();
                        az.position = i5;
                        if (az instanceof k) {
                            if (bjVar.aEg()) {
                                d.d(az);
                            } else if (bjVar.aDq() == 1) {
                                d.b(az);
                                az.cRh = imageWidthAndHeight[0];
                                az.cRi = imageWidthAndHeight[1];
                            } else if (bjVar.aDq() >= 2) {
                                d.c(az);
                            } else {
                                d.e(az);
                            }
                        } else if (az instanceof l) {
                            d.f(az);
                        }
                    }
                    if (az != null && az.isValid()) {
                        if (!bjVar.aEi() && bjVar.aCo() != null && bjVar.aDX() != null && !StringUtils.isNull(bjVar.aDX().forumName)) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bjVar.aCo().getName_show()));
                            spannableString.setSpan(new f(16, bjVar.aCo().getUserId()) { // from class: com.baidu.tieba.homepage.personalize.model.a.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    an ag;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (az instanceof k) {
                                        ag = ((k) az).bvF();
                                    } else {
                                        ag = az instanceof l ? ((l) az).ag(null) : null;
                                    }
                                    TiebaStatic.log(ag);
                                }
                            }, 0, format.length() - 1, 33);
                            az.cRg.a(spannableString);
                        }
                        linkedList.add(az);
                    }
                    if (threadInfo.top_agree_post != null) {
                        k aA3 = d.aA(bjVar);
                        if (aA3 != null) {
                            aA3.tid = bjVar.getTid();
                            aA3.position = i5;
                            d.i(aA3);
                        }
                        if (aA3 != null && aA3.isValid()) {
                            linkedList.add(aA3);
                        }
                    }
                    k aA4 = d.aA(bjVar);
                    if (aA4 != null) {
                        aA4.tid = bjVar.getTid();
                        aA4.position = i5;
                        d.j(aA4);
                    }
                    if (aA4 != null && aA4.isValid()) {
                        linkedList.add(aA4);
                    }
                } else if (com.baidu.tieba.card.data.e.aa(bjVar) && bjVar.aBd()) {
                    com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e(bjVar);
                    eVar.position = i5;
                    linkedList.add(eVar);
                } else {
                    com.baidu.tieba.card.data.c az2 = d.az(bjVar);
                    if (az2 != null) {
                        az2.tid = bjVar.getTid();
                        az2.position = i5;
                    }
                    if (az2 != null && az2.isValid()) {
                        linkedList.add(az2);
                    }
                }
                i4 = i5 + 1;
            } else {
                i4 = i5;
            }
            i5 = i4;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i8 < v.getCount(list2)) {
            p pVar = (p) v.getItem(list2, i8);
            if (pVar == null || i7 >= linkedList.size()) {
                int i9 = i6;
                i = i7;
                i2 = i9;
            } else {
                while (true) {
                    i3 = i7;
                    if ((i3 >= linkedList.size() || (linkedList.get(i3) instanceof com.baidu.tieba.card.data.c)) && (i3 >= linkedList.size() || ((com.baidu.tieba.card.data.c) linkedList.get(i3)).position + i6 == pVar.getPosition() - 1)) {
                        break;
                    }
                    i7 = i3 + 1;
                }
                if (linkedList.size() <= i3 || i3 <= 0) {
                    i2 = i6;
                    i = i3;
                } else {
                    linkedList.add(i3, pVar);
                    i2 = i6 + 1;
                    i = i3;
                }
            }
            i8++;
            int i10 = i2;
            i7 = i;
            i6 = i10;
        }
        int i11 = 0;
        Iterator it = linkedList.iterator();
        while (true) {
            int i12 = i11;
            if (!it.hasNext()) {
                return linkedList;
            }
            m mVar = (m) it.next();
            if (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) {
                i12++;
            } else if (mVar instanceof com.baidu.tieba.card.data.b) {
                ((com.baidu.tieba.card.data.b) mVar).position += i12;
            }
            i11 = i12;
        }
    }

    private List<ThreadInfo> a(DataRes.Builder builder, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int count = (v.getCount(list) - i2) + 30;
                while (true) {
                    count--;
                    if (count < 30) {
                        break;
                    } else if (list.size() > count) {
                        arrayList.add(list.remove(count));
                    }
                }
            } else {
                for (int count2 = v.getCount(list) - 1; count2 >= i2; count2--) {
                    list.remove(count2);
                }
            }
        }
        return arrayList;
    }
}
