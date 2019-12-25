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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class a {
    private int gZz = 0;
    private com.baidu.tieba.homepage.personalize.b.d gZA = new com.baidu.tieba.homepage.personalize.b.d();
    private final c gSU = new c();
    private final int gZy = com.baidu.tbadk.core.sharedPref.b.aCY().getInt("home_page_max_thread_count", 300);

    public int bMw() {
        return this.gZy;
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
        a(builder, i, this.gZy);
        d.e(builder);
        List<p> b = d.b(builder);
        cI(b);
        List<m> n = n(builder.thread_list, b);
        this.gZA.cL(n);
        b.a(builder, n);
        this.gSU.dOP = n;
        return this.gSU;
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
        d.a(z, builder, builder2, i, this.gZz);
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
                this.gZA.ad(list);
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
                this.gZA.a(z, list2.size() - 1, list, list2);
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
            this.gSU.gZD = count3 - count;
            this.gZz = count3 - count;
        }
    }

    private void cI(List<p> list) {
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
                bjVar.cQe = true;
                bjVar.a(threadInfo);
                if (!TextUtils.isEmpty(bjVar.aAM())) {
                    ae aeVar = new ae();
                    aeVar.sd(bjVar.aAM());
                    aeVar.position = i5;
                    linkedList.add(aeVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.Y(bjVar)) {
                    if (!StringUtils.isNull(bjVar.aBw().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(bjVar.aBw());
                        aVar.from = 1;
                        aVar.position = i5;
                        aVar.setThreadData(bjVar);
                        linkedList.add(aVar);
                    }
                } else if (k.Y(bjVar) || l.Y(bjVar)) {
                    k av = d.av(bjVar);
                    if (av != null && av.cMR != null && av.cMR.aBq() != null && !StringUtils.isNull(av.cMR.aBq().forumName)) {
                        av.tid = bjVar.getTid();
                        av.position = i5;
                        d.h(av);
                        linkedList.add(av);
                    } else {
                        k av2 = d.av(bjVar);
                        if (av2 != null) {
                            av2.tid = bjVar.getTid();
                            av2.position = i5;
                            d.a(av2);
                        }
                        if (av2 != null && av2.isValid()) {
                            linkedList.add(av2);
                        }
                    }
                    int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.c au = d.au(bjVar);
                    if (au != null) {
                        au.tid = bjVar.getTid();
                        au.position = i5;
                        if (au instanceof k) {
                            if (bjVar.aBA()) {
                                d.d(au);
                            } else if (bjVar.aAI() == 1) {
                                d.b(au);
                                au.cMS = imageWidthAndHeight[0];
                                au.cMT = imageWidthAndHeight[1];
                            } else if (bjVar.aAI() >= 2) {
                                d.c(au);
                            } else {
                                d.e(au);
                            }
                        } else if (au instanceof l) {
                            d.f(au);
                        }
                    }
                    if (au != null && au.isValid()) {
                        if (!bjVar.aBC() && bjVar.azE() != null && bjVar.aBq() != null && !StringUtils.isNull(bjVar.aBq().forumName)) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bjVar.azE().getName_show()));
                            spannableString.setSpan(new f(16, bjVar.azE().getUserId()) { // from class: com.baidu.tieba.homepage.personalize.model.a.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    an ae;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (au instanceof k) {
                                        ae = ((k) au).bsW();
                                    } else {
                                        ae = au instanceof l ? ((l) au).ae(null) : null;
                                    }
                                    TiebaStatic.log(ae);
                                }
                            }, 0, format.length() - 1, 33);
                            au.cMR.a(spannableString);
                        }
                        linkedList.add(au);
                    }
                    if (threadInfo.top_agree_post != null) {
                        k av3 = d.av(bjVar);
                        if (av3 != null) {
                            av3.tid = bjVar.getTid();
                            av3.position = i5;
                            d.i(av3);
                        }
                        if (av3 != null && av3.isValid()) {
                            linkedList.add(av3);
                        }
                    }
                    k av4 = d.av(bjVar);
                    if (av4 != null) {
                        av4.tid = bjVar.getTid();
                        av4.position = i5;
                        d.j(av4);
                    }
                    if (av4 != null && av4.isValid()) {
                        linkedList.add(av4);
                    }
                } else if (com.baidu.tieba.card.data.e.Y(bjVar) && bjVar.ays()) {
                    com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e(bjVar);
                    eVar.position = i5;
                    linkedList.add(eVar);
                } else {
                    com.baidu.tieba.card.data.c au2 = d.au(bjVar);
                    if (au2 != null) {
                        au2.tid = bjVar.getTid();
                        au2.position = i5;
                    }
                    if (au2 != null && au2.isValid()) {
                        linkedList.add(au2);
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

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int count = (v.getCount(list) - i2) + 30;
                while (true) {
                    count--;
                    if (count >= 30) {
                        if (list.size() > count) {
                            list.remove(count);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int count2 = v.getCount(list) - 1; count2 >= i2; count2--) {
                    list.remove(count2);
                }
            }
        }
    }
}
