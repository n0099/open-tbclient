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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.p;
import com.baidu.tieba.homepage.personalize.data.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class a {
    private int hgI = 0;
    private com.baidu.tieba.homepage.personalize.b.d hgJ = new com.baidu.tieba.homepage.personalize.b.d();
    private final c gZK = new c();
    private final int hgH = com.baidu.tbadk.core.sharedPref.b.aFH().getInt("home_page_max_thread_count", 300);

    public int bPz() {
        return this.hgH;
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
        d.d(builder);
        d.d(builder2);
        b(z, builder, builder2, i);
        List<ThreadInfo> a = a(builder, i, this.hgH);
        d.f(builder);
        List<p> c = d.c(builder);
        cE(c);
        List<m> a2 = a(builder.thread_list, c, builder2.user_follow_live, i, 0);
        List<m> a3 = a(a, new ArrayList(), builder2.user_follow_live, i, 1);
        this.hgJ.cH(a2);
        b.a(builder, a2);
        this.gZK.dTH = a2;
        this.gZK.hgN = a3 == null ? 0 : a3.size();
        return this.gZK;
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
        d.a(z, builder, builder2, i, this.hgI);
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
                this.hgJ.ac(list);
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
                this.hgJ.a(z, list2.size() - 1, list, list2);
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
            this.gZK.hgM = count3 - count;
            this.hgI = count3 - count;
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

    private List<m> a(List<ThreadInfo> list, List<p> list2, UserFollowLive userFollowLive, int i, int i2) {
        f bPA;
        int i3;
        int i4;
        int i5;
        int i6;
        String format;
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int i7 = 0;
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bj bjVar = new bj();
                bjVar.cUF = true;
                bjVar.a(threadInfo);
                if (!TextUtils.isEmpty(bjVar.aDy())) {
                    ae aeVar = new ae();
                    aeVar.sx(bjVar.aDy());
                    aeVar.position = i7;
                    linkedList.add(aeVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.ab(bjVar)) {
                    if (!StringUtils.isNull(bjVar.aEh().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(bjVar.aEh());
                        aVar.from = 1;
                        aVar.position = i7;
                        aVar.setThreadData(bjVar);
                        linkedList.add(aVar);
                    }
                } else if (k.ab(bjVar) || l.ab(bjVar)) {
                    k aB = d.aB(bjVar);
                    if (aB != null && aB.cRt != null && aB.cRt.aEb() != null && !StringUtils.isNull(aB.cRt.aEb().forumName)) {
                        aB.tid = bjVar.getTid();
                        aB.position = i7;
                        d.h(aB);
                        linkedList.add(aB);
                    } else {
                        k aB2 = d.aB(bjVar);
                        if (aB2 != null) {
                            aB2.tid = bjVar.getTid();
                            aB2.position = i7;
                            d.a(aB2);
                        }
                        if (aB2 != null && aB2.isValid()) {
                            linkedList.add(aB2);
                        }
                    }
                    int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.c aA = d.aA(bjVar);
                    if (aA != null) {
                        aA.tid = bjVar.getTid();
                        aA.position = i7;
                        if (aA instanceof k) {
                            if (bjVar.aEk()) {
                                d.d(aA);
                            } else if (bjVar.aDu() == 1) {
                                d.b(aA);
                                aA.cRu = imageWidthAndHeight[0];
                                aA.cRv = imageWidthAndHeight[1];
                            } else if (bjVar.aDu() >= 2) {
                                d.c(aA);
                            } else {
                                d.e(aA);
                            }
                        } else if (aA instanceof l) {
                            d.f(aA);
                        }
                    }
                    if (aA != null && aA.isValid()) {
                        if (!bjVar.aEm() && bjVar.aCr() != null && bjVar.aEb() != null && !StringUtils.isNull(bjVar.aEb().forumName)) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bjVar.aCr().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, bjVar.aCr().getUserId()) { // from class: com.baidu.tieba.homepage.personalize.model.a.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    an ah;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (aA instanceof k) {
                                        ah = ((k) aA).bvK();
                                    } else {
                                        ah = aA instanceof l ? ((l) aA).ah(null) : null;
                                    }
                                    TiebaStatic.log(ah);
                                }
                            }, 0, format.length() - 1, 33);
                            aA.cRt.a(spannableString);
                        }
                        linkedList.add(aA);
                    }
                    if (threadInfo.top_agree_post != null) {
                        k aB3 = d.aB(bjVar);
                        if (aB3 != null) {
                            aB3.tid = bjVar.getTid();
                            aB3.position = i7;
                            d.i(aB3);
                        }
                        if (aB3 != null && aB3.isValid()) {
                            linkedList.add(aB3);
                        }
                    }
                    k aB4 = d.aB(bjVar);
                    if (aB4 != null) {
                        aB4.tid = bjVar.getTid();
                        aB4.position = i7;
                        d.j(aB4);
                    }
                    if (aB4 != null && aB4.isValid()) {
                        linkedList.add(aB4);
                    }
                } else if (com.baidu.tieba.card.data.e.ab(bjVar) && bjVar.aBg()) {
                    com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e(bjVar);
                    eVar.position = i7;
                    linkedList.add(eVar);
                } else {
                    com.baidu.tieba.card.data.c aA2 = d.aA(bjVar);
                    if (aA2 != null) {
                        aA2.tid = bjVar.getTid();
                        aA2.position = i7;
                    }
                    if (aA2 != null && aA2.isValid()) {
                        linkedList.add(aA2);
                    }
                }
                i6 = i7 + 1;
            } else {
                i6 = i7;
            }
            i7 = i6;
        }
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i10 < v.getCount(list2)) {
            p pVar = (p) v.getItem(list2, i10);
            if (pVar == null || i9 >= linkedList.size()) {
                int i11 = i8;
                i3 = i9;
                i4 = i11;
            } else {
                while (true) {
                    i5 = i9;
                    if (i5 >= linkedList.size() || ((linkedList.get(i5) instanceof com.baidu.tieba.card.data.c) && ((com.baidu.tieba.card.data.c) linkedList.get(i5)).position + i8 == pVar.getPosition() - 1)) {
                        break;
                    }
                    i9 = i5 + 1;
                }
                if (linkedList.size() <= i5 || i5 <= 0) {
                    i4 = i8;
                    i3 = i5;
                } else {
                    linkedList.add(i5, pVar);
                    i4 = i8 + 1;
                    i3 = i5;
                }
            }
            i10++;
            int i12 = i4;
            i9 = i3;
            i8 = i12;
        }
        int i13 = 0;
        Iterator it = linkedList.iterator();
        while (true) {
            int i14 = i13;
            if (!it.hasNext()) {
                break;
            }
            m mVar = (m) it.next();
            if (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) {
                i14++;
            } else if (mVar instanceof com.baidu.tieba.card.data.b) {
                ((com.baidu.tieba.card.data.b) mVar).position += i14;
            }
            i13 = i14;
        }
        if (i2 == 0) {
            if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !v.isEmpty(userFollowLive.user_follow_live)) {
                f fVar = new f();
                fVar.a(userFollowLive);
                linkedList.add(0, fVar);
                fVar.position = -1;
                int i15 = i7 + 1;
            } else if (i == 1 && (bPA = bPA()) != null) {
                linkedList.add(0, bPA);
                bPA.position = -1;
                int i16 = i7 + 1;
            }
        }
        return linkedList;
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

    private f bPA() {
        if (this.gZK == null || v.isEmpty(this.gZK.dTH)) {
            return null;
        }
        for (m mVar : this.gZK.dTH) {
            if (mVar instanceof f) {
                return (f) mVar;
            }
        }
        return null;
    }
}
