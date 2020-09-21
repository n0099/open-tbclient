package com.baidu.tieba.homepage.personalize.model;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.data.q;
import com.baidu.tieba.homepage.personalize.data.f;
import com.baidu.tieba.homepage.personalize.data.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes21.dex */
public class a {
    private int iYO;
    private int iYP;
    private int iYL = 0;
    private com.baidu.tieba.homepage.personalize.b.d iYM = new com.baidu.tieba.homepage.personalize.b.d();
    private int iYN = 0;
    private Long iYS = 0L;
    private final c iPX = new c();
    private final int iYK = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("home_page_max_thread_count", 300);
    private ArrayList<ThreadInfo> iYQ = new ArrayList<>();
    private ArrayList<App> iYR = new ArrayList<>();

    public int cCh() {
        return this.iYK;
    }

    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (i != 0 && i != 1) {
            return null;
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        DataRes.Builder builder3 = builder2 == null ? new DataRes.Builder() : builder2;
        d.e(builder);
        d.e(builder3);
        b(z, builder, builder3, i);
        List<ThreadInfo> a = a(builder, i, this.iYK);
        d.g(builder);
        List<q> d = d.d(builder);
        dt(d);
        List<com.baidu.adp.widget.ListView.q> a2 = a(builder.thread_list, d, builder3.user_follow_live, i, 0, builder3);
        List<com.baidu.adp.widget.ListView.q> a3 = a(a, new ArrayList(), builder3.user_follow_live, i, 1, null);
        this.iYM.dw(a2);
        b.a(builder, a2);
        this.iPX.fnr = a2;
        this.iPX.iYW = a3 == null ? 0 : a3.size();
        return this.iPX;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            this.iYN = (builder2.fresh_ctrl_num == null || builder2.fresh_ctrl_num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
            this.iYN = this.iYN > this.iYK ? this.iYK : this.iYN;
            d(z, builder, builder2, i);
            c(z, builder, builder2, i);
            s(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void s(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.iYL, this.iYO, this.iYP);
    }

    private void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null && builder.thread_list != null && builder2.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            List<ThreadInfo> list2 = builder2.thread_list;
            this.iYO = y.getCount(list);
            if (builder.banner_list != null) {
                this.iYP = y.getCount(builder.banner_list.app);
            } else {
                this.iYP = 0;
            }
            int count = y.getCount(list) + y.getCount(this.iYQ);
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null && !TextUtils.isEmpty(threadInfo.lego_card)) {
                    hashSet2.add(threadInfo.lego_card);
                } else if (threadInfo != null && threadInfo.tid != null) {
                    hashSet.add(threadInfo.tid);
                }
            }
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = new HashSet();
            Iterator<ThreadInfo> it = this.iYQ.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                    hashSet4.add(next.lego_card);
                } else if (next != null && next.tid != null) {
                    hashSet3.add(next.tid);
                }
            }
            if (i == 1) {
                if (!y.isEmpty(list2)) {
                    this.iYM.b((ThreadInfo) y.getItem(list2, 0));
                }
                for (ThreadInfo threadInfo2 : list2) {
                    if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                        if (!hashSet2.contains(threadInfo2.lego_card) && !hashSet4.contains(threadInfo2.lego_card)) {
                            list.add(threadInfo2);
                        }
                    } else if (threadInfo2 != null && threadInfo2.tid != null && !hashSet.contains(threadInfo2.tid) && !hashSet3.contains(threadInfo2.tid)) {
                        list.add(threadInfo2);
                        JSONObject f = com.baidu.tieba.recapp.report.b.f(threadInfo2);
                        if (f != null) {
                            arrayList.add(f);
                        }
                    }
                }
            } else {
                this.iYM.g(z, list);
                if (cCk()) {
                    if (builder.banner_list != null && !y.isEmpty(builder.banner_list.app)) {
                        this.iYR.addAll(0, builder.banner_list.app);
                        BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                        builder3.app = new LinkedList();
                        builder.banner_list = builder3.build(false);
                    }
                    this.iYQ.addAll(0, list);
                    list.clear();
                    hashSet.clear();
                    hashSet2.clear();
                    if (y.getCount(this.iYQ) > this.iYK) {
                        int size = this.iYQ.size();
                        while (true) {
                            size--;
                            if (size < this.iYK) {
                                break;
                            }
                            this.iYQ.remove(size);
                        }
                    }
                    hashSet3.clear();
                    hashSet4.clear();
                    Iterator<ThreadInfo> it2 = this.iYQ.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo next2 = it2.next();
                        if (next2 != null && !TextUtils.isEmpty(next2.lego_card)) {
                            hashSet4.add(next2.lego_card);
                        } else if (next2 != null && next2.tid != null) {
                            hashSet3.add(next2.tid);
                        }
                    }
                }
                for (int count2 = y.getCount(list2) - 1; count2 >= 0; count2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) y.getItem(list2, count2);
                    if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                        if (!hashSet2.contains(threadInfo3.lego_card) && !hashSet4.contains(threadInfo3.lego_card)) {
                            list.add(0, threadInfo3);
                        }
                    } else if (threadInfo3 != null && threadInfo3.tid != null && !hashSet.contains(threadInfo3.tid) && !hashSet3.contains(threadInfo3.tid)) {
                        list.add(0, threadInfo3);
                        JSONObject f2 = com.baidu.tieba.recapp.report.b.f(threadInfo3);
                        if (f2 != null) {
                            arrayList.add(0, f2);
                        }
                    }
                }
            }
            if (cCk()) {
                if (!y.isEmpty(this.iYR) && builder2.banner_list != null) {
                    int count3 = y.getCount(list2) + y.getCount(builder2.banner_list.app);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= this.iYR.size()) {
                            break;
                        }
                        App app = this.iYR.get(i3);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            builder4.pos_name = String.valueOf(com.baidu.adp.lib.f.b.toInt(app.pos_name, 0) + count3);
                            App build = builder4.build(false);
                            this.iYR.remove(i3);
                            this.iYR.add(i3, build);
                        }
                        i2 = i3 + 1;
                    }
                }
                if (y.getCount(list) >= this.iYN) {
                    list.addAll(this.iYQ);
                    this.iYQ.clear();
                    BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                    if (builder5.app == null) {
                        builder5.app = new LinkedList();
                    }
                    builder5.app.addAll(this.iYR);
                    builder.banner_list = builder5.build(false);
                    this.iYR.clear();
                }
            }
            int count4 = y.getCount(list) + y.getCount(this.iYQ);
            this.iPX.iYV = count4 - count;
            this.iYL = count4 - count;
            com.baidu.tieba.recapp.report.b.drP().fe(arrayList);
        }
    }

    private void dt(List<q> list) {
        if (list != null) {
            Collections.sort(list, new Comparator<q>() { // from class: com.baidu.tieba.homepage.personalize.model.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(q qVar, q qVar2) {
                    if (qVar == null || qVar2 == null) {
                        return 0;
                    }
                    if (qVar.getPosition() > qVar2.getPosition()) {
                        return 1;
                    }
                    return qVar.getPosition() < qVar2.getPosition() ? -1 : 0;
                }
            });
        }
    }

    private List<com.baidu.adp.widget.ListView.q> a(List<ThreadInfo> list, List<q> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder) {
        f cCi;
        int i3;
        int i4;
        int i5;
        l aB;
        l aB2;
        l aB3;
        String format;
        if (list == null) {
            return null;
        }
        if (builder != null && !y.isEmpty(builder.thread_list) && builder.active_center != null) {
            ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
            if (threadInfo.id.longValue() > 0 && com.baidu.tbadk.BdToken.q.aZL().aZN()) {
                this.iYS = threadInfo.id;
            }
        }
        List<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(y.getCount(list));
        for (ThreadInfo threadInfo2 : list) {
            bw bwVar = new bw();
            com.baidu.tbadk.a.a.a.a(bwVar);
            bwVar.egt = true;
            bwVar.a(threadInfo2);
            arrayList.add(bwVar);
        }
        if (builder != null && com.baidu.tieba.homepage.concern.a.d.a(builder.hot_recomforum, -1)) {
            com.baidu.tieba.homepage.concern.a.d dVar = new com.baidu.tieba.homepage.concern.a.d();
            dVar.floorPosition = builder.hot_recomforum.floor.intValue() > 0 ? builder.hot_recomforum.floor.intValue() - 1 : 0;
            if (dVar.di(builder.hot_recomforum.tab_list)) {
                a(dVar, dVar.floorPosition, arrayList);
            }
        }
        LinkedList linkedList = new LinkedList();
        int i6 = 0;
        for (com.baidu.adp.widget.ListView.q qVar : arrayList) {
            if (qVar instanceof bw) {
                bw bwVar2 = (bw) qVar;
                if (!TextUtils.isEmpty(bwVar2.bgI())) {
                    ak akVar = new ak();
                    akVar.zx(bwVar2.bgI());
                    akVar.position = i6;
                    linkedList.add(akVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.ab(bwVar2)) {
                    if (!StringUtils.isNull(bwVar2.bhr().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(bwVar2.bhr());
                        aVar.from = 1;
                        aVar.position = i6;
                        aVar.setThreadData(bwVar2);
                        linkedList.add(aVar);
                    }
                } else if (l.ab(bwVar2) || m.ab(bwVar2)) {
                    boolean z = false;
                    l aB4 = d.aB(bwVar2);
                    if (aB4 != null) {
                        if (bwVar2.bde()) {
                            if (aB4.isValid()) {
                                aB4.tid = bwVar2.getTid();
                                aB4.position = i6;
                                d.a(aB4);
                                linkedList.add(aB4);
                            }
                            z = false;
                        } else {
                            bw bwVar3 = aB4.dXg;
                            if (bwVar3 != null && bwVar3.bhm() != null && !StringUtils.isNull(bwVar3.bhm().forumName)) {
                                aB4.tid = bwVar2.getTid();
                                aB4.position = i6;
                                d.h(aB4);
                                linkedList.add(aB4);
                                z = true;
                            } else {
                                if (aB4.isValid()) {
                                    aB4.tid = bwVar2.getTid();
                                    aB4.position = i6;
                                    d.a(aB4);
                                    linkedList.add(aB4);
                                }
                                z = false;
                            }
                        }
                    }
                    int[] imageWidthAndHeight = bwVar2.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.c aA = d.aA(bwVar2);
                    if (aA != null) {
                        aA.tid = bwVar2.getTid();
                        aA.position = i6;
                        if (aA instanceof l) {
                            if (bwVar2.bht()) {
                                d.d(aA);
                            } else if (bwVar2.bgE() == 1) {
                                d.b(aA);
                                aA.edd = imageWidthAndHeight[0];
                                aA.ede = imageWidthAndHeight[1];
                            } else if (bwVar2.bgE() >= 2) {
                                d.c(aA);
                            } else {
                                d.e(aA);
                            }
                        } else if (aA instanceof m) {
                            d.f(aA);
                        }
                    }
                    if (aA != null && aA.isValid()) {
                        aA.dXg.bfa();
                        if (!bwVar2.bei() && bwVar2.bfy() != null && z) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bwVar2.bfy().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, bwVar2.bfy().getUserId()) { // from class: com.baidu.tieba.homepage.personalize.model.a.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    aq ah;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (aA instanceof l) {
                                        ah = ((l) aA).cfO();
                                    } else {
                                        ah = aA instanceof m ? ((m) aA).ah(null) : null;
                                    }
                                    TiebaStatic.log(ah);
                                }
                            }, 0, format.length() - 1, 33);
                            aA.dXg.a(spannableString);
                        }
                        linkedList.add(aA);
                    }
                    if (bwVar2.bhB() != null && (aB3 = d.aB(bwVar2)) != null) {
                        aB3.tid = bwVar2.getTid();
                        aB3.position = i6;
                        d.k(aB3);
                        if (l.ab(bwVar2)) {
                            aB3.Hz("1");
                        } else if (m.ab(bwVar2)) {
                            aB3.Hz("2");
                        }
                        linkedList.add(aB3);
                    }
                    if ((!y.isEmpty(bwVar2.bhE()) || !y.isEmpty(bwVar2.bhF())) && (aB = d.aB(bwVar2)) != null) {
                        aB.tid = bwVar2.getTid();
                        aB.position = i6;
                        if (y.getCount(bwVar2.bhE()) + y.getCount(bwVar2.bhF()) == 1) {
                            d.l(aB);
                        } else {
                            d.m(aB);
                        }
                        linkedList.add(aB);
                    }
                    if (bwVar2.bde() && (aB2 = d.aB(bwVar2)) != null) {
                        aB2.tid = bwVar2.getTid();
                        aB2.position = i6;
                        d.g(aB2);
                        if (l.ab(bwVar2)) {
                            aB2.Hz("1");
                        } else if (m.ab(bwVar2)) {
                            aB2.Hz("2");
                        }
                        if (bwVar2.bde() && !StringUtils.isNull(bwVar2.bfC())) {
                            linkedList.add(aB2);
                        } else if (!StringUtils.isNull(bwVar2.bfC())) {
                            linkedList.add(aB2);
                        }
                    }
                    if (bwVar2.bhb() != null) {
                        l aB5 = d.aB(bwVar2);
                        if (aB5 != null) {
                            aB5.tid = bwVar2.getTid();
                            aB5.position = i6;
                            d.i(aB5);
                        }
                        if (aB5 != null && aB5.isValid()) {
                            linkedList.add(aB5);
                        }
                    }
                    l aB6 = d.aB(bwVar2);
                    if (aB6 != null) {
                        aB6.tid = bwVar2.getTid();
                        aB6.position = i6;
                        d.j(aB6);
                    }
                    if (aB6 != null && aB6.isValid()) {
                        linkedList.add(aB6);
                    }
                } else if (com.baidu.tieba.card.data.f.ab(bwVar2) && bwVar2.beg()) {
                    com.baidu.tieba.card.data.f fVar = new com.baidu.tieba.card.data.f(bwVar2);
                    fVar.position = i6;
                    linkedList.add(fVar);
                } else {
                    com.baidu.tieba.card.data.c aA2 = d.aA(bwVar2);
                    if (aA2 != null) {
                        aA2.tid = bwVar2.getTid();
                        aA2.position = i6;
                    }
                    if (aA2 != null && aA2.isValid()) {
                        linkedList.add(aA2);
                    }
                }
                long j = com.baidu.adp.lib.f.b.toLong(bwVar2.getId(), 0L);
                if (j != 0 && j == this.iYS.longValue()) {
                    g gVar = null;
                    if (builder.active_center != null) {
                        gVar = new g();
                        gVar.a(builder.active_center);
                    }
                    if (gVar == null) {
                        gVar = cCj();
                    }
                    if (gVar != null) {
                        i6++;
                        gVar.position = i6;
                        linkedList.add(gVar);
                    }
                }
            } else if (qVar instanceof com.baidu.tieba.card.data.b) {
                linkedList.add(qVar);
            } else {
                linkedList.add(qVar);
            }
            i6++;
        }
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i9 < y.getCount(list2)) {
            q qVar2 = (q) y.getItem(list2, i9);
            if (qVar2 == null || i8 >= linkedList.size()) {
                int i10 = i7;
                i3 = i8;
                i4 = i10;
            } else {
                while (true) {
                    i5 = i8;
                    if (i5 >= linkedList.size() || ((linkedList.get(i5) instanceof com.baidu.tieba.card.data.c) && ((com.baidu.tieba.card.data.c) linkedList.get(i5)).position + i7 == qVar2.getPosition() - 1)) {
                        break;
                    }
                    i8 = i5 + 1;
                }
                if (linkedList.size() <= i5 || i5 <= 0) {
                    i4 = i7;
                    i3 = i5;
                } else {
                    linkedList.add(i5, qVar2);
                    i4 = i7 + 1;
                    i3 = i5;
                }
            }
            i9++;
            int i11 = i4;
            i8 = i3;
            i7 = i11;
        }
        int i12 = 0;
        Iterator it = linkedList.iterator();
        while (true) {
            int i13 = i12;
            if (!it.hasNext()) {
                break;
            }
            com.baidu.adp.widget.ListView.q qVar3 = (com.baidu.adp.widget.ListView.q) it.next();
            if (qVar3 instanceof com.baidu.tieba.homepage.personalize.data.a) {
                i13++;
            } else if (qVar3 instanceof com.baidu.tieba.card.data.b) {
                ((com.baidu.tieba.card.data.b) qVar3).position += i13;
            }
            i12 = i13;
        }
        if (i2 == 0) {
            if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !y.isEmpty(userFollowLive.user_follow_live)) {
                f fVar2 = new f();
                fVar2.a(userFollowLive);
                linkedList.add(0, fVar2);
                fVar2.position = -1;
                int i14 = i6 + 1;
            } else if (i == 1 && (cCi = cCi()) != null) {
                linkedList.add(0, cCi);
                cCi.position = -1;
                int i15 = i6 + 1;
            }
        }
        com.baidu.tbadk.a.a.a.aK(linkedList);
        return linkedList;
    }

    public void a(AbsThreadDataSupport absThreadDataSupport, int i, List<com.baidu.adp.widget.ListView.q> list) {
        int i2;
        if (absThreadDataSupport != null && list != null && i > 0) {
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                if (!(list.get(i3) instanceof bw)) {
                    i2 = i4;
                } else if (i == i4) {
                    absThreadDataSupport.floorPosition = i;
                    y.add(list, i3, absThreadDataSupport);
                    return;
                } else {
                    i2 = i4 + 1;
                }
                i3++;
                i4 = i2;
            }
        }
    }

    private List<ThreadInfo> a(DataRes.Builder builder, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int count = (y.getCount(list) - i2) + 30;
                while (true) {
                    count--;
                    if (count < 30) {
                        break;
                    } else if (list.size() > count) {
                        arrayList.add(list.remove(count));
                    }
                }
            } else {
                for (int count2 = y.getCount(list) - 1; count2 >= i2; count2--) {
                    list.remove(count2);
                }
            }
        }
        return arrayList;
    }

    private f cCi() {
        if (this.iPX == null || y.isEmpty(this.iPX.fnr)) {
            return null;
        }
        for (com.baidu.adp.widget.ListView.q qVar : this.iPX.fnr) {
            if (qVar instanceof f) {
                return (f) qVar;
            }
        }
        return null;
    }

    private g cCj() {
        if (this.iPX == null || y.isEmpty(this.iPX.fnr)) {
            return null;
        }
        for (com.baidu.adp.widget.ListView.q qVar : this.iPX.fnr) {
            if (qVar instanceof g) {
                return (g) qVar;
            }
        }
        return null;
    }

    private boolean cCk() {
        return this.iYN > 0;
    }

    public boolean cCl() {
        return (this.iYQ == null || y.isEmpty(this.iYQ)) ? false : true;
    }

    public List<ThreadInfo> cCm() {
        return this.iYQ;
    }
}
