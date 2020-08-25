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
/* loaded from: classes16.dex */
public class a {
    private int iQc;
    private int iQd;
    private int iPZ = 0;
    private com.baidu.tieba.homepage.personalize.b.d iQa = new com.baidu.tieba.homepage.personalize.b.d();
    private int iQb = 0;
    private Long iQg = 0L;
    private final c iHS = new c();
    private final int iPY = com.baidu.tbadk.core.sharedPref.b.bik().getInt("home_page_max_thread_count", 300);
    private ArrayList<ThreadInfo> iQe = new ArrayList<>();
    private ArrayList<App> iQf = new ArrayList<>();

    public int cyz() {
        return this.iPY;
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
        List<ThreadInfo> a = a(builder, i, this.iPY);
        d.g(builder);
        List<q> d = d.d(builder);
        dl(d);
        List<com.baidu.adp.widget.ListView.q> a2 = a(builder.thread_list, d, builder3.user_follow_live, i, 0, builder3);
        List<com.baidu.adp.widget.ListView.q> a3 = a(a, new ArrayList(), builder3.user_follow_live, i, 1, null);
        this.iQa.m42do(a2);
        b.a(builder, a2);
        this.iHS.fku = a2;
        this.iHS.iQk = a3 == null ? 0 : a3.size();
        return this.iHS;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            this.iQb = (builder2.fresh_ctrl_num == null || builder2.fresh_ctrl_num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
            this.iQb = this.iQb > this.iPY ? this.iPY : this.iQb;
            d(z, builder, builder2, i);
            c(z, builder, builder2, i);
            r(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void r(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.iPZ, this.iQc, this.iQd);
    }

    private void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null && builder.thread_list != null && builder2.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            List<ThreadInfo> list2 = builder2.thread_list;
            this.iQc = y.getCount(list);
            if (builder.banner_list != null) {
                this.iQd = y.getCount(builder.banner_list.app);
            } else {
                this.iQd = 0;
            }
            int count = y.getCount(list) + y.getCount(this.iQe);
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
            Iterator<ThreadInfo> it = this.iQe.iterator();
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
                    this.iQa.b((ThreadInfo) y.getItem(list2, 0));
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
                this.iQa.g(z, list);
                if (cyC()) {
                    if (builder.banner_list != null && !y.isEmpty(builder.banner_list.app)) {
                        this.iQf.addAll(0, builder.banner_list.app);
                        BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                        builder3.app = new LinkedList();
                        builder.banner_list = builder3.build(false);
                    }
                    this.iQe.addAll(0, list);
                    list.clear();
                    hashSet.clear();
                    hashSet2.clear();
                    if (y.getCount(this.iQe) > this.iPY) {
                        int size = this.iQe.size();
                        while (true) {
                            size--;
                            if (size < this.iPY) {
                                break;
                            }
                            this.iQe.remove(size);
                        }
                    }
                    hashSet3.clear();
                    hashSet4.clear();
                    Iterator<ThreadInfo> it2 = this.iQe.iterator();
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
            if (cyC()) {
                if (!y.isEmpty(this.iQf) && builder2.banner_list != null) {
                    int count3 = y.getCount(list2) + y.getCount(builder2.banner_list.app);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= this.iQf.size()) {
                            break;
                        }
                        App app = this.iQf.get(i3);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            builder4.pos_name = String.valueOf(com.baidu.adp.lib.f.b.toInt(app.pos_name, 0) + count3);
                            App build = builder4.build(false);
                            this.iQf.remove(i3);
                            this.iQf.add(i3, build);
                        }
                        i2 = i3 + 1;
                    }
                }
                if (y.getCount(list) >= this.iQb) {
                    list.addAll(this.iQe);
                    this.iQe.clear();
                    BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                    if (builder5.app == null) {
                        builder5.app = new LinkedList();
                    }
                    builder5.app.addAll(this.iQf);
                    builder.banner_list = builder5.build(false);
                    this.iQf.clear();
                }
            }
            int count4 = y.getCount(list) + y.getCount(this.iQe);
            this.iHS.iQj = count4 - count;
            this.iPZ = count4 - count;
            com.baidu.tieba.recapp.report.b.doc().eW(arrayList);
        }
    }

    private void dl(List<q> list) {
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
        f cyA;
        int i3;
        int i4;
        int i5;
        int i6;
        l aA;
        l aA2;
        l aA3;
        String format;
        if (list == null) {
            return null;
        }
        if (builder != null && !y.isEmpty(builder.thread_list) && builder.active_center != null) {
            ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
            if (threadInfo.id.longValue() > 0 && com.baidu.tbadk.BdToken.q.aYY().aZa()) {
                this.iQg = threadInfo.id;
            }
        }
        LinkedList linkedList = new LinkedList();
        int i7 = 0;
        for (ThreadInfo threadInfo2 : list) {
            if (threadInfo2 != null) {
                bw bwVar = new bw();
                com.baidu.tbadk.a.a.a.a(bwVar);
                bwVar.eef = true;
                bwVar.a(threadInfo2);
                if (!TextUtils.isEmpty(bwVar.bfO())) {
                    ak akVar = new ak();
                    akVar.zb(bwVar.bfO());
                    akVar.position = i7;
                    linkedList.add(akVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.aa(bwVar)) {
                    if (!StringUtils.isNull(bwVar.bgx().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(bwVar.bgx());
                        aVar.from = 1;
                        aVar.position = i7;
                        aVar.setThreadData(bwVar);
                        linkedList.add(aVar);
                    }
                } else if (l.aa(bwVar) || m.aa(bwVar)) {
                    boolean z = false;
                    l aA4 = d.aA(bwVar);
                    if (aA4 != null) {
                        if (bwVar.bck()) {
                            if (aA4.isValid()) {
                                aA4.tid = bwVar.getTid();
                                aA4.position = i7;
                                d.a(aA4);
                                linkedList.add(aA4);
                            }
                            z = false;
                        } else {
                            bw bwVar2 = aA4.dUS;
                            if (bwVar2 != null && bwVar2.bgs() != null && !StringUtils.isNull(bwVar2.bgs().forumName)) {
                                aA4.tid = bwVar.getTid();
                                aA4.position = i7;
                                d.h(aA4);
                                linkedList.add(aA4);
                                z = true;
                            } else {
                                if (aA4.isValid()) {
                                    aA4.tid = bwVar.getTid();
                                    aA4.position = i7;
                                    d.a(aA4);
                                    linkedList.add(aA4);
                                }
                                z = false;
                            }
                        }
                    }
                    int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.c az = d.az(bwVar);
                    if (az != null) {
                        az.tid = bwVar.getTid();
                        az.position = i7;
                        if (az instanceof l) {
                            if (bwVar.bgz()) {
                                d.d(az);
                            } else if (bwVar.bfK() == 1) {
                                d.b(az);
                                az.eaP = imageWidthAndHeight[0];
                                az.eaQ = imageWidthAndHeight[1];
                            } else if (bwVar.bfK() >= 2) {
                                d.c(az);
                            } else {
                                d.e(az);
                            }
                        } else if (az instanceof m) {
                            d.f(az);
                        }
                    }
                    if (az != null && az.isValid()) {
                        az.dUS.beg();
                        if (!bwVar.bdo() && bwVar.beE() != null && z) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bwVar.beE().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, bwVar.beE().getUserId()) { // from class: com.baidu.tieba.homepage.personalize.model.a.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    aq ag;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (az instanceof l) {
                                        ag = ((l) az).ccy();
                                    } else {
                                        ag = az instanceof m ? ((m) az).ag(null) : null;
                                    }
                                    TiebaStatic.log(ag);
                                }
                            }, 0, format.length() - 1, 33);
                            az.dUS.a(spannableString);
                        }
                        linkedList.add(az);
                    }
                    if (bwVar.bgH() != null && (aA3 = d.aA(bwVar)) != null) {
                        aA3.tid = bwVar.getTid();
                        aA3.position = i7;
                        d.k(aA3);
                        if (l.aa(bwVar)) {
                            aA3.Hb("1");
                        } else if (m.aa(bwVar)) {
                            aA3.Hb("2");
                        }
                        linkedList.add(aA3);
                    }
                    if ((!y.isEmpty(bwVar.bgK()) || !y.isEmpty(bwVar.bgL())) && (aA = d.aA(bwVar)) != null) {
                        aA.tid = bwVar.getTid();
                        aA.position = i7;
                        if (y.getCount(bwVar.bgK()) + y.getCount(bwVar.bgL()) == 1) {
                            d.l(aA);
                        } else {
                            d.m(aA);
                        }
                        linkedList.add(aA);
                    }
                    if (bwVar.bck() && (aA2 = d.aA(bwVar)) != null) {
                        aA2.tid = bwVar.getTid();
                        aA2.position = i7;
                        d.g(aA2);
                        if (l.aa(bwVar)) {
                            aA2.Hb("1");
                        } else if (m.aa(bwVar)) {
                            aA2.Hb("2");
                        }
                        if (bwVar.bck() && !StringUtils.isNull(bwVar.beI())) {
                            linkedList.add(aA2);
                        } else if (!StringUtils.isNull(bwVar.beI())) {
                            linkedList.add(aA2);
                        }
                    }
                    if (threadInfo2.top_agree_post != null) {
                        l aA5 = d.aA(bwVar);
                        if (aA5 != null) {
                            aA5.tid = bwVar.getTid();
                            aA5.position = i7;
                            d.i(aA5);
                        }
                        if (aA5 != null && aA5.isValid()) {
                            linkedList.add(aA5);
                        }
                    }
                    l aA6 = d.aA(bwVar);
                    if (aA6 != null) {
                        aA6.tid = bwVar.getTid();
                        aA6.position = i7;
                        d.j(aA6);
                    }
                    if (aA6 != null && aA6.isValid()) {
                        linkedList.add(aA6);
                    }
                } else if (com.baidu.tieba.card.data.f.aa(bwVar) && bwVar.bdm()) {
                    com.baidu.tieba.card.data.f fVar = new com.baidu.tieba.card.data.f(bwVar);
                    fVar.position = i7;
                    linkedList.add(fVar);
                } else {
                    com.baidu.tieba.card.data.c az2 = d.az(bwVar);
                    if (az2 != null) {
                        az2.tid = bwVar.getTid();
                        az2.position = i7;
                    }
                    if (az2 != null && az2.isValid()) {
                        linkedList.add(az2);
                    }
                }
                if (threadInfo2.id.longValue() != 0 && threadInfo2.id.equals(this.iQg)) {
                    g gVar = null;
                    if (builder.active_center != null) {
                        gVar = new g();
                        gVar.a(builder.active_center);
                    }
                    if (gVar == null) {
                        gVar = cyB();
                    }
                    if (gVar != null) {
                        i7++;
                        gVar.position = i7;
                        linkedList.add(gVar);
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
        while (i10 < y.getCount(list2)) {
            q qVar = (q) y.getItem(list2, i10);
            if (qVar == null || i9 >= linkedList.size()) {
                int i11 = i8;
                i3 = i9;
                i4 = i11;
            } else {
                while (true) {
                    i5 = i9;
                    if (i5 >= linkedList.size() || ((linkedList.get(i5) instanceof com.baidu.tieba.card.data.c) && ((com.baidu.tieba.card.data.c) linkedList.get(i5)).position + i8 == qVar.getPosition() - 1)) {
                        break;
                    }
                    i9 = i5 + 1;
                }
                if (linkedList.size() <= i5 || i5 <= 0) {
                    i4 = i8;
                    i3 = i5;
                } else {
                    linkedList.add(i5, qVar);
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
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) it.next();
            if (qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) {
                i14++;
            } else if (qVar2 instanceof com.baidu.tieba.card.data.b) {
                ((com.baidu.tieba.card.data.b) qVar2).position += i14;
            }
            i13 = i14;
        }
        if (i2 == 0) {
            if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !y.isEmpty(userFollowLive.user_follow_live)) {
                f fVar2 = new f();
                fVar2.a(userFollowLive);
                linkedList.add(0, fVar2);
                fVar2.position = -1;
                int i15 = i7 + 1;
            } else if (i == 1 && (cyA = cyA()) != null) {
                linkedList.add(0, cyA);
                cyA.position = -1;
                int i16 = i7 + 1;
            }
        }
        com.baidu.tbadk.a.a.a.aG(linkedList);
        return linkedList;
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

    private f cyA() {
        if (this.iHS == null || y.isEmpty(this.iHS.fku)) {
            return null;
        }
        for (com.baidu.adp.widget.ListView.q qVar : this.iHS.fku) {
            if (qVar instanceof f) {
                return (f) qVar;
            }
        }
        return null;
    }

    private g cyB() {
        if (this.iHS == null || y.isEmpty(this.iHS.fku)) {
            return null;
        }
        for (com.baidu.adp.widget.ListView.q qVar : this.iHS.fku) {
            if (qVar instanceof g) {
                return (g) qVar;
            }
        }
        return null;
    }

    private boolean cyC() {
        return this.iQb > 0;
    }

    public boolean cyD() {
        return (this.iQe == null || y.isEmpty(this.iQe)) ? false : true;
    }

    public List<ThreadInfo> cyE() {
        return this.iQe;
    }
}
