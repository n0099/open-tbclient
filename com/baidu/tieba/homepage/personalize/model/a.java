package com.baidu.tieba.homepage.personalize.model;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BdToken.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes2.dex */
public class a {
    private int knT;
    private int knU;
    private int knQ = 0;
    private com.baidu.tieba.homepage.personalize.readProgressBar.c knR = new com.baidu.tieba.homepage.personalize.readProgressBar.c();
    private int knS = 0;
    private Long knX = 0L;
    private final c keh = new c();
    private final int knP = com.baidu.tbadk.core.sharedPref.b.brR().getInt("home_page_max_thread_count", 300);
    private ArrayList<ThreadInfo> knV = new ArrayList<>();
    private ArrayList<App> knW = new ArrayList<>();

    public int cRV() {
        return this.knP;
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
        List<ThreadInfo> a2 = a(builder, i, this.knP);
        d.g(builder);
        List<p> d = d.d(builder);
        ed(d);
        List<n> a3 = a(builder.thread_list, d, builder3.user_follow_live, i, 0, builder3);
        List<n> a4 = a(a2, new ArrayList(), builder3.user_follow_live, i, 1, null);
        this.knR.eg(a3);
        b.a(builder, a3);
        this.keh.gdY = a3;
        this.keh.kob = a4 == null ? 0 : a4.size();
        return this.keh;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            this.knS = (builder2.fresh_ctrl_num == null || builder2.fresh_ctrl_num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
            this.knS = this.knS > this.knP ? this.knP : this.knS;
            d(z, builder, builder2, i);
            c(z, builder, builder2, i);
            w(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void w(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.knQ, this.knT, this.knU);
    }

    private void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null && builder.thread_list != null && builder2.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            List<ThreadInfo> list2 = builder2.thread_list;
            this.knT = y.getCount(list);
            if (builder.banner_list != null) {
                this.knU = y.getCount(builder.banner_list.app);
            } else {
                this.knU = 0;
            }
            int count = y.getCount(list) + y.getCount(this.knV);
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
            Iterator<ThreadInfo> it = this.knV.iterator();
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
                    this.knR.b((ThreadInfo) y.getItem(list2, 0));
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
                this.knR.h(z, list);
                if (cRY()) {
                    if (builder.banner_list != null && !y.isEmpty(builder.banner_list.app)) {
                        this.knW.addAll(0, builder.banner_list.app);
                        BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                        builder3.app = new LinkedList();
                        builder.banner_list = builder3.build(false);
                    }
                    this.knV.addAll(0, list);
                    list.clear();
                    hashSet.clear();
                    hashSet2.clear();
                    if (y.getCount(this.knV) > this.knP) {
                        int size = this.knV.size();
                        while (true) {
                            size--;
                            if (size < this.knP) {
                                break;
                            }
                            this.knV.remove(size);
                        }
                    }
                    hashSet3.clear();
                    hashSet4.clear();
                    Iterator<ThreadInfo> it2 = this.knV.iterator();
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
            if (cRY()) {
                if (!y.isEmpty(this.knW) && builder2.banner_list != null) {
                    int count3 = y.getCount(list2) + y.getCount(builder2.banner_list.app);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= this.knW.size()) {
                            break;
                        }
                        App app = this.knW.get(i3);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            builder4.pos_name = String.valueOf(com.baidu.adp.lib.f.b.toInt(app.pos_name, 0) + count3);
                            App build = builder4.build(false);
                            this.knW.remove(i3);
                            this.knW.add(i3, build);
                        }
                        i2 = i3 + 1;
                    }
                }
                if (y.getCount(list) >= this.knS) {
                    list.addAll(this.knV);
                    this.knV.clear();
                    BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                    if (builder5.app == null) {
                        builder5.app = new LinkedList();
                    }
                    builder5.app.addAll(this.knW);
                    builder.banner_list = builder5.build(false);
                    this.knW.clear();
                }
            }
            int count4 = y.getCount(list) + y.getCount(this.knV);
            this.keh.koa = count4 - count;
            this.knQ = count4 - count;
            com.baidu.tieba.recapp.report.b.dEB().q("NEWINDEX", arrayList);
        }
    }

    private void ed(List<p> list) {
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

    private List<n> a(List<ThreadInfo> list, List<p> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder) {
        f cRW;
        k aF;
        k aF2;
        k aF3;
        String format;
        if (list == null) {
            return null;
        }
        if (builder != null && !y.isEmpty(builder.thread_list) && builder.active_center != null) {
            ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
            if (threadInfo.id.longValue() > 0 && q.bhW().bhY()) {
                this.knX = threadInfo.id;
            }
        }
        List<n> arrayList = new ArrayList<>(y.getCount(list));
        for (ThreadInfo threadInfo2 : list) {
            cb cbVar = new cb();
            com.baidu.tbadk.a.a.a.a(cbVar);
            cbVar.eVf = true;
            cbVar.a(threadInfo2);
            arrayList.add(cbVar);
        }
        if (builder != null && com.baidu.tieba.homepage.concern.a.c.a(builder.hot_recomforum, -1)) {
            com.baidu.tieba.homepage.concern.a.c cVar = new com.baidu.tieba.homepage.concern.a.c();
            cVar.floorPosition = builder.hot_recomforum.floor.intValue() > 0 ? builder.hot_recomforum.floor.intValue() - 1 : 0;
            if (cVar.dS(builder.hot_recomforum.tab_list)) {
                a(cVar, cVar.floorPosition, arrayList);
            }
        }
        LinkedList linkedList = new LinkedList();
        int i3 = 0;
        for (n nVar : arrayList) {
            if (nVar instanceof cb) {
                cb cbVar2 = (cb) nVar;
                if (!TextUtils.isEmpty(cbVar2.bpd())) {
                    an anVar = new an();
                    anVar.Ac(cbVar2.bpd());
                    anVar.position = i3;
                    linkedList.add(anVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.ae(cbVar2)) {
                    if (!StringUtils.isNull(cbVar2.bpN().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(cbVar2.bpN());
                        aVar.from = 1;
                        aVar.position = i3;
                        aVar.setThreadData(cbVar2);
                        aVar.setSupportType(BaseCardInfo.SupportType.FULL);
                        linkedList.add(aVar);
                    }
                } else if (k.ae(cbVar2) || l.ae(cbVar2)) {
                    boolean z = false;
                    k aF4 = d.aF(cbVar2);
                    if (aF4 != null) {
                        if (cbVar2.blt()) {
                            if (aF4.isValid()) {
                                aF4.tid = cbVar2.getTid();
                                aF4.position = i3;
                                d.a(aF4);
                                linkedList.add(aF4);
                            }
                            z = false;
                        } else {
                            cb cbVar3 = aF4.eLr;
                            if (cbVar3 != null && cbVar3.bpI() != null && !StringUtils.isNull(cbVar3.bpI().forumName)) {
                                aF4.tid = cbVar2.getTid();
                                aF4.position = i3;
                                d.h(aF4);
                                linkedList.add(aF4);
                                z = true;
                            } else {
                                if (aF4.isValid()) {
                                    aF4.tid = cbVar2.getTid();
                                    aF4.position = i3;
                                    d.a(aF4);
                                    linkedList.add(aF4);
                                }
                                z = false;
                            }
                        }
                    }
                    int[] imageWidthAndHeight = cbVar2.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.b aE = d.aE(cbVar2);
                    if (aE != null) {
                        aE.tid = cbVar2.getTid();
                        aE.position = i3;
                        if (aE instanceof k) {
                            if (cbVar2.bpP()) {
                                d.d(aE);
                            } else if (cbVar2.boZ() == 1) {
                                d.b(aE);
                                aE.eRK = imageWidthAndHeight[0];
                                aE.eRL = imageWidthAndHeight[1];
                            } else if (cbVar2.boZ() >= 2) {
                                d.c(aE);
                            } else {
                                d.e(aE);
                            }
                        } else if (aE instanceof l) {
                            d.f(aE);
                        }
                    }
                    if (aE != null && aE.isValid()) {
                        aE.eLr.bnu();
                        if (!cbVar2.bmB() && cbVar2.bnS() != null && z) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), cbVar2.bnS().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, cbVar2.bnS().getUserId()) { // from class: com.baidu.tieba.homepage.personalize.model.a.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    ar ak;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (aE instanceof k) {
                                        ak = ((k) aE).ctj();
                                    } else {
                                        ak = aE instanceof l ? ((l) aE).ak(null) : null;
                                    }
                                    TiebaStatic.log(ak);
                                }
                            }, 0, format.length() - 1, 33);
                            aE.eLr.a(spannableString);
                        }
                        linkedList.add(aE);
                    }
                    if (cbVar2.bpY() != null && (aF3 = d.aF(cbVar2)) != null) {
                        aF3.tid = cbVar2.getTid();
                        aF3.position = i3;
                        d.k(aF3);
                        if (k.ae(cbVar2)) {
                            aF3.Ja("1");
                        } else if (l.ae(cbVar2)) {
                            aF3.Ja("2");
                        }
                        linkedList.add(aF3);
                    }
                    if ((!y.isEmpty(cbVar2.bqb()) || !y.isEmpty(cbVar2.bqc())) && (aF = d.aF(cbVar2)) != null) {
                        aF.tid = cbVar2.getTid();
                        aF.position = i3;
                        if (y.getCount(cbVar2.bqb()) + y.getCount(cbVar2.bqc()) == 1) {
                            d.l(aF);
                        } else {
                            d.m(aF);
                        }
                        linkedList.add(aF);
                    }
                    if (cbVar2.blt() && (aF2 = d.aF(cbVar2)) != null) {
                        aF2.tid = cbVar2.getTid();
                        aF2.position = i3;
                        d.g(aF2);
                        if (k.ae(cbVar2)) {
                            aF2.Ja("1");
                        } else if (l.ae(cbVar2)) {
                            aF2.Ja("2");
                        }
                        if (cbVar2.blt() && !StringUtils.isNull(cbVar2.bnW())) {
                            linkedList.add(aF2);
                        } else if (!StringUtils.isNull(cbVar2.bnW())) {
                            linkedList.add(aF2);
                        }
                    }
                    if (cbVar2.bpx() != null) {
                        k aF5 = d.aF(cbVar2);
                        if (aF5 != null) {
                            aF5.tid = cbVar2.getTid();
                            aF5.position = i3;
                            d.i(aF5);
                        }
                        if (aF5 != null && aF5.isValid()) {
                            linkedList.add(aF5);
                        }
                    }
                    k aF6 = d.aF(cbVar2);
                    if (aF6 != null) {
                        aF6.tid = cbVar2.getTid();
                        aF6.position = i3;
                        d.j(aF6);
                    }
                    if (aF6 != null && aF6.isValid()) {
                        linkedList.add(aF6);
                    }
                } else if (com.baidu.tieba.card.data.e.ae(cbVar2) && cbVar2.bmz()) {
                    com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e(cbVar2);
                    eVar.position = i3;
                    linkedList.add(eVar);
                } else {
                    com.baidu.tieba.card.data.b aE2 = d.aE(cbVar2);
                    if (aE2 != null) {
                        aE2.tid = cbVar2.getTid();
                        aE2.position = i3;
                    }
                    if (aE2 != null && aE2.isValid()) {
                        linkedList.add(aE2);
                    }
                }
                long j = com.baidu.adp.lib.f.b.toLong(cbVar2.getId(), 0L);
                if (j != 0 && j == this.knX.longValue()) {
                    g gVar = null;
                    if (builder.active_center != null) {
                        gVar = new g();
                        gVar.a(builder.active_center);
                    }
                    if (gVar == null) {
                        gVar = cRX();
                    }
                    if (gVar != null) {
                        i3++;
                        gVar.position = i3;
                        linkedList.add(gVar);
                    }
                }
            } else if (nVar instanceof BaseCardInfo) {
                linkedList.add(nVar);
            } else {
                linkedList.add(nVar);
            }
            i3++;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            int i8 = i5;
            if (i7 >= y.getCount(list2)) {
                break;
            }
            p pVar = (p) y.getItem(list2, i7);
            if (pVar != null && i4 < linkedList.size()) {
                while (i4 < linkedList.size() && (!(linkedList.get(i4) instanceof com.baidu.tieba.card.data.b) || ((com.baidu.tieba.card.data.b) linkedList.get(i4)).position + i8 != pVar.getPosition() - 1)) {
                    i4++;
                }
                if (linkedList.size() > i4 && i4 > 0) {
                    linkedList.add(i4, pVar);
                    i8++;
                }
            }
            i5 = i8;
            i6 = i7 + 1;
        }
        int i9 = 0;
        int i10 = 0;
        Iterator it = linkedList.iterator();
        while (true) {
            int i11 = i10;
            if (!it.hasNext()) {
                break;
            }
            n nVar2 = (n) it.next();
            if (nVar2 instanceof am) {
                ((am) nVar2).setPosition(i11 + 1);
                i9++;
            } else if (nVar2 instanceof BaseCardInfo) {
                BaseCardInfo baseCardInfo = (BaseCardInfo) nVar2;
                baseCardInfo.position += i9;
                i11 = baseCardInfo.position;
            }
            i10 = i11;
        }
        if (i2 == 0) {
            if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !y.isEmpty(userFollowLive.user_follow_live)) {
                f fVar = new f();
                fVar.a(userFollowLive);
                linkedList.add(0, fVar);
                fVar.position = -1;
                int i12 = i3 + 1;
            } else if (i == 1 && (cRW = cRW()) != null) {
                linkedList.add(0, cRW);
                cRW.position = -1;
                int i13 = i3 + 1;
            }
        }
        com.baidu.tbadk.a.a.a.bj(linkedList);
        return linkedList;
    }

    public void a(com.baidu.tbadk.core.data.a aVar, int i, List<n> list) {
        int i2;
        if (aVar != null && list != null && i > 0) {
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                if (!(list.get(i3) instanceof cb)) {
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

    private f cRW() {
        if (this.keh == null || y.isEmpty(this.keh.gdY)) {
            return null;
        }
        for (n nVar : this.keh.gdY) {
            if (nVar instanceof f) {
                return (f) nVar;
            }
        }
        return null;
    }

    private g cRX() {
        if (this.keh == null || y.isEmpty(this.keh.gdY)) {
            return null;
        }
        for (n nVar : this.keh.gdY) {
            if (nVar instanceof g) {
                return (g) nVar;
            }
        }
        return null;
    }

    private boolean cRY() {
        return this.knS > 0;
    }

    public boolean cRZ() {
        return (this.knV == null || y.isEmpty(this.knV)) ? false : true;
    }

    public List<ThreadInfo> cSa() {
        return this.knV;
    }
}
