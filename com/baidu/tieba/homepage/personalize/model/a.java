package com.baidu.tieba.homepage.personalize.model;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.p;
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
/* loaded from: classes22.dex */
public class a {
    private int jUO;
    private int jUP;
    private int jUL = 0;
    private com.baidu.tieba.homepage.personalize.b.d jUM = new com.baidu.tieba.homepage.personalize.b.d();
    private int jUN = 0;
    private Long jUS = 0L;
    private final c jLH = new c();
    private final int jUK = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("home_page_max_thread_count", 300);
    private ArrayList<ThreadInfo> jUQ = new ArrayList<>();
    private ArrayList<App> jUR = new ArrayList<>();

    public int cQt() {
        return this.jUK;
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
        List<ThreadInfo> a2 = a(builder, i, this.jUK);
        d.g(builder);
        List<p> d = d.d(builder);
        dY(d);
        List<q> a3 = a(builder.thread_list, d, builder3.user_follow_live, i, 0, builder3);
        List<q> a4 = a(a2, new ArrayList(), builder3.user_follow_live, i, 1, null);
        this.jUM.eb(a3);
        b.a(builder, a3);
        this.jLH.fVe = a3;
        this.jLH.jUW = a4 == null ? 0 : a4.size();
        return this.jLH;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            this.jUN = (builder2.fresh_ctrl_num == null || builder2.fresh_ctrl_num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
            this.jUN = this.jUN > this.jUK ? this.jUK : this.jUN;
            d(z, builder, builder2, i);
            c(z, builder, builder2, i);
            v(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void v(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.jUL, this.jUO, this.jUP);
    }

    private void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null && builder.thread_list != null && builder2.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            List<ThreadInfo> list2 = builder2.thread_list;
            this.jUO = y.getCount(list);
            if (builder.banner_list != null) {
                this.jUP = y.getCount(builder.banner_list.app);
            } else {
                this.jUP = 0;
            }
            int count = y.getCount(list) + y.getCount(this.jUQ);
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
            Iterator<ThreadInfo> it = this.jUQ.iterator();
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
                    this.jUM.b((ThreadInfo) y.getItem(list2, 0));
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
                this.jUM.f(z, list);
                if (cQw()) {
                    if (builder.banner_list != null && !y.isEmpty(builder.banner_list.app)) {
                        this.jUR.addAll(0, builder.banner_list.app);
                        BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                        builder3.app = new LinkedList();
                        builder.banner_list = builder3.build(false);
                    }
                    this.jUQ.addAll(0, list);
                    list.clear();
                    hashSet.clear();
                    hashSet2.clear();
                    if (y.getCount(this.jUQ) > this.jUK) {
                        int size = this.jUQ.size();
                        while (true) {
                            size--;
                            if (size < this.jUK) {
                                break;
                            }
                            this.jUQ.remove(size);
                        }
                    }
                    hashSet3.clear();
                    hashSet4.clear();
                    Iterator<ThreadInfo> it2 = this.jUQ.iterator();
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
            if (cQw()) {
                if (!y.isEmpty(this.jUR) && builder2.banner_list != null) {
                    int count3 = y.getCount(list2) + y.getCount(builder2.banner_list.app);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= this.jUR.size()) {
                            break;
                        }
                        App app = this.jUR.get(i3);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            builder4.pos_name = String.valueOf(com.baidu.adp.lib.f.b.toInt(app.pos_name, 0) + count3);
                            App build = builder4.build(false);
                            this.jUR.remove(i3);
                            this.jUR.add(i3, build);
                        }
                        i2 = i3 + 1;
                    }
                }
                if (y.getCount(list) >= this.jUN) {
                    list.addAll(this.jUQ);
                    this.jUQ.clear();
                    BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                    if (builder5.app == null) {
                        builder5.app = new LinkedList();
                    }
                    builder5.app.addAll(this.jUR);
                    builder.banner_list = builder5.build(false);
                    this.jUR.clear();
                }
            }
            int count4 = y.getCount(list) + y.getCount(this.jUQ);
            this.jLH.jUV = count4 - count;
            this.jUL = count4 - count;
            com.baidu.tieba.recapp.report.b.dGf().q("tag_home_recommend_tab", arrayList);
        }
    }

    private void dY(List<p> list) {
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

    private List<q> a(List<ThreadInfo> list, List<p> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder) {
        f cQu;
        int i3;
        int i4;
        int i5;
        k aD;
        k aD2;
        k aD3;
        String format;
        if (list == null) {
            return null;
        }
        if (builder != null && !y.isEmpty(builder.thread_list) && builder.active_center != null) {
            ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
            if (threadInfo.id.longValue() > 0 && com.baidu.tbadk.BdToken.q.bjk().bjm()) {
                this.jUS = threadInfo.id;
            }
        }
        List<q> arrayList = new ArrayList<>(y.getCount(list));
        for (ThreadInfo threadInfo2 : list) {
            by byVar = new by();
            com.baidu.tbadk.a.a.a.a(byVar);
            byVar.eMi = true;
            byVar.a(threadInfo2);
            arrayList.add(byVar);
        }
        if (builder != null && com.baidu.tieba.homepage.concern.a.c.a(builder.hot_recomforum, -1)) {
            com.baidu.tieba.homepage.concern.a.c cVar = new com.baidu.tieba.homepage.concern.a.c();
            cVar.floorPosition = builder.hot_recomforum.floor.intValue() > 0 ? builder.hot_recomforum.floor.intValue() - 1 : 0;
            if (cVar.dN(builder.hot_recomforum.tab_list)) {
                a(cVar, cVar.floorPosition, arrayList);
            }
        }
        LinkedList linkedList = new LinkedList();
        int i6 = 0;
        for (q qVar : arrayList) {
            if (qVar instanceof by) {
                by byVar2 = (by) qVar;
                if (!TextUtils.isEmpty(byVar2.bqb())) {
                    am amVar = new am();
                    amVar.AS(byVar2.bqb());
                    amVar.position = i6;
                    linkedList.add(amVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.ad(byVar2)) {
                    if (!StringUtils.isNull(byVar2.bqK().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(byVar2.bqK());
                        aVar.from = 1;
                        aVar.position = i6;
                        aVar.setThreadData(byVar2);
                        aVar.setSupportType(BaseCardInfo.SupportType.FULL);
                        linkedList.add(aVar);
                    }
                } else if (k.ad(byVar2) || l.ad(byVar2)) {
                    boolean z = false;
                    k aD4 = d.aD(byVar2);
                    if (aD4 != null) {
                        if (byVar2.bmr()) {
                            if (aD4.isValid()) {
                                aD4.tid = byVar2.getTid();
                                aD4.position = i6;
                                d.a(aD4);
                                linkedList.add(aD4);
                            }
                            z = false;
                        } else {
                            by byVar3 = aD4.eCR;
                            if (byVar3 != null && byVar3.bqF() != null && !StringUtils.isNull(byVar3.bqF().forumName)) {
                                aD4.tid = byVar2.getTid();
                                aD4.position = i6;
                                d.h(aD4);
                                linkedList.add(aD4);
                                z = true;
                            } else {
                                if (aD4.isValid()) {
                                    aD4.tid = byVar2.getTid();
                                    aD4.position = i6;
                                    d.a(aD4);
                                    linkedList.add(aD4);
                                }
                                z = false;
                            }
                        }
                    }
                    int[] imageWidthAndHeight = byVar2.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.b aC = d.aC(byVar2);
                    if (aC != null) {
                        aC.tid = byVar2.getTid();
                        aC.position = i6;
                        if (aC instanceof k) {
                            if (byVar2.bqM()) {
                                d.d(aC);
                            } else if (byVar2.bpX() == 1) {
                                d.b(aC);
                                aC.eIP = imageWidthAndHeight[0];
                                aC.eIQ = imageWidthAndHeight[1];
                            } else if (byVar2.bpX() >= 2) {
                                d.c(aC);
                            } else {
                                d.e(aC);
                            }
                        } else if (aC instanceof l) {
                            d.f(aC);
                        }
                    }
                    if (aC != null && aC.isValid()) {
                        aC.eCR.bor();
                        if (!byVar2.bnz() && byVar2.boP() != null && z) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), byVar2.boP().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, byVar2.boP().getUserId()) { // from class: com.baidu.tieba.homepage.personalize.model.a.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    ar aj;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (aC instanceof k) {
                                        aj = ((k) aC).csI();
                                    } else {
                                        aj = aC instanceof l ? ((l) aC).aj(null) : null;
                                    }
                                    TiebaStatic.log(aj);
                                }
                            }, 0, format.length() - 1, 33);
                            aC.eCR.a(spannableString);
                        }
                        linkedList.add(aC);
                    }
                    if (byVar2.bqV() != null && (aD3 = d.aD(byVar2)) != null) {
                        aD3.tid = byVar2.getTid();
                        aD3.position = i6;
                        d.k(aD3);
                        if (k.ad(byVar2)) {
                            aD3.Jt("1");
                        } else if (l.ad(byVar2)) {
                            aD3.Jt("2");
                        }
                        linkedList.add(aD3);
                    }
                    if ((!y.isEmpty(byVar2.bqY()) || !y.isEmpty(byVar2.bqZ())) && (aD = d.aD(byVar2)) != null) {
                        aD.tid = byVar2.getTid();
                        aD.position = i6;
                        if (y.getCount(byVar2.bqY()) + y.getCount(byVar2.bqZ()) == 1) {
                            d.l(aD);
                        } else {
                            d.m(aD);
                        }
                        linkedList.add(aD);
                    }
                    if (byVar2.bmr() && (aD2 = d.aD(byVar2)) != null) {
                        aD2.tid = byVar2.getTid();
                        aD2.position = i6;
                        d.g(aD2);
                        if (k.ad(byVar2)) {
                            aD2.Jt("1");
                        } else if (l.ad(byVar2)) {
                            aD2.Jt("2");
                        }
                        if (byVar2.bmr() && !StringUtils.isNull(byVar2.boT())) {
                            linkedList.add(aD2);
                        } else if (!StringUtils.isNull(byVar2.boT())) {
                            linkedList.add(aD2);
                        }
                    }
                    if (byVar2.bqu() != null) {
                        k aD5 = d.aD(byVar2);
                        if (aD5 != null) {
                            aD5.tid = byVar2.getTid();
                            aD5.position = i6;
                            d.i(aD5);
                        }
                        if (aD5 != null && aD5.isValid()) {
                            linkedList.add(aD5);
                        }
                    }
                    k aD6 = d.aD(byVar2);
                    if (aD6 != null) {
                        aD6.tid = byVar2.getTid();
                        aD6.position = i6;
                        d.j(aD6);
                    }
                    if (aD6 != null && aD6.isValid()) {
                        linkedList.add(aD6);
                    }
                } else if (com.baidu.tieba.card.data.e.ad(byVar2) && byVar2.bnx()) {
                    com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e(byVar2);
                    eVar.position = i6;
                    linkedList.add(eVar);
                } else {
                    com.baidu.tieba.card.data.b aC2 = d.aC(byVar2);
                    if (aC2 != null) {
                        aC2.tid = byVar2.getTid();
                        aC2.position = i6;
                    }
                    if (aC2 != null && aC2.isValid()) {
                        linkedList.add(aC2);
                    }
                }
                long j = com.baidu.adp.lib.f.b.toLong(byVar2.getId(), 0L);
                if (j != 0 && j == this.jUS.longValue()) {
                    g gVar = null;
                    if (builder.active_center != null) {
                        gVar = new g();
                        gVar.a(builder.active_center);
                    }
                    if (gVar == null) {
                        gVar = cQv();
                    }
                    if (gVar != null) {
                        i6++;
                        gVar.position = i6;
                        linkedList.add(gVar);
                    }
                }
            } else if (qVar instanceof BaseCardInfo) {
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
            p pVar = (p) y.getItem(list2, i9);
            if (pVar == null || i8 >= linkedList.size()) {
                int i10 = i7;
                i3 = i8;
                i4 = i10;
            } else {
                while (true) {
                    i5 = i8;
                    if (i5 >= linkedList.size() || ((linkedList.get(i5) instanceof com.baidu.tieba.card.data.b) && ((com.baidu.tieba.card.data.b) linkedList.get(i5)).position + i7 == pVar.getPosition() - 1)) {
                        break;
                    }
                    i8 = i5 + 1;
                }
                if (linkedList.size() <= i5 || i5 <= 0) {
                    i4 = i7;
                    i3 = i5;
                } else {
                    linkedList.add(i5, pVar);
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
            q qVar2 = (q) it.next();
            if (qVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) {
                i13++;
            } else if (qVar2 instanceof BaseCardInfo) {
                ((BaseCardInfo) qVar2).position += i13;
            }
            i12 = i13;
        }
        if (i2 == 0) {
            if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !y.isEmpty(userFollowLive.user_follow_live)) {
                f fVar = new f();
                fVar.a(userFollowLive);
                linkedList.add(0, fVar);
                fVar.position = -1;
                int i14 = i6 + 1;
            } else if (i == 1 && (cQu = cQu()) != null) {
                linkedList.add(0, cQu);
                cQu.position = -1;
                int i15 = i6 + 1;
            }
        }
        com.baidu.tbadk.a.a.a.bh(linkedList);
        return linkedList;
    }

    public void a(com.baidu.tbadk.core.data.a aVar, int i, List<q> list) {
        int i2;
        if (aVar != null && list != null && i > 0) {
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                if (!(list.get(i3) instanceof by)) {
                    i2 = i4;
                } else if (i == i4) {
                    aVar.floorPosition = i;
                    y.add(list, i3, aVar);
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

    private f cQu() {
        if (this.jLH == null || y.isEmpty(this.jLH.fVe)) {
            return null;
        }
        for (q qVar : this.jLH.fVe) {
            if (qVar instanceof f) {
                return (f) qVar;
            }
        }
        return null;
    }

    private g cQv() {
        if (this.jLH == null || y.isEmpty(this.jLH.fVe)) {
            return null;
        }
        for (q qVar : this.jLH.fVe) {
            if (qVar instanceof g) {
                return (g) qVar;
            }
        }
        return null;
    }

    private boolean cQw() {
        return this.jUN > 0;
    }

    public boolean cQx() {
        return (this.jUQ == null || y.isEmpty(this.jUQ)) ? false : true;
    }

    public List<ThreadInfo> cQy() {
        return this.jUQ;
    }
}
