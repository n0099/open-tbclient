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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
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
    private int khZ;
    private int kia;
    private int khW = 0;
    private com.baidu.tieba.homepage.personalize.readProgressBar.c khX = new com.baidu.tieba.homepage.personalize.readProgressBar.c();
    private int khY = 0;
    private Long kie = 0L;
    private final c jYV = new c();
    private final int khV = com.baidu.tbadk.core.sharedPref.b.bvr().getInt("home_page_max_thread_count", 300);
    private ArrayList<ThreadInfo> kib = new ArrayList<>();
    private ArrayList<App> kic = new ArrayList<>();

    public int cTA() {
        return this.khV;
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
        List<ThreadInfo> a2 = a(builder, i, this.khV);
        d.g(builder);
        List<p> d = d.d(builder);
        ef(d);
        List<n> a3 = a(builder.thread_list, d, builder3.user_follow_live, i, 0, builder3);
        List<n> a4 = a(a2, new ArrayList(), builder3.user_follow_live, i, 1, null);
        this.khX.ei(a3);
        b.a(builder, a3);
        this.jYV.geK = a3;
        this.jYV.kii = a4 == null ? 0 : a4.size();
        return this.jYV;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            this.khY = (builder2.fresh_ctrl_num == null || builder2.fresh_ctrl_num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
            this.khY = this.khY > this.khV ? this.khV : this.khY;
            d(z, builder, builder2, i);
            c(z, builder, builder2, i);
            y(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void y(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.khW, this.khZ, this.kia);
    }

    private void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null && builder.thread_list != null && builder2.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            List<ThreadInfo> list2 = builder2.thread_list;
            this.khZ = x.getCount(list);
            if (builder.banner_list != null) {
                this.kia = x.getCount(builder.banner_list.app);
            } else {
                this.kia = 0;
            }
            int count = x.getCount(list) + x.getCount(this.kib);
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
            Iterator<ThreadInfo> it = this.kib.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                    hashSet4.add(next.lego_card);
                } else if (next != null && next.tid != null) {
                    hashSet3.add(next.tid);
                }
            }
            if (i == 1) {
                if (!x.isEmpty(list2)) {
                    this.khX.b((ThreadInfo) x.getItem(list2, 0));
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
                this.khX.g(z, list);
                if (cTD()) {
                    if (builder.banner_list != null && !x.isEmpty(builder.banner_list.app)) {
                        this.kic.addAll(0, builder.banner_list.app);
                        BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                        builder3.app = new LinkedList();
                        builder.banner_list = builder3.build(false);
                    }
                    this.kib.addAll(0, list);
                    list.clear();
                    hashSet.clear();
                    hashSet2.clear();
                    if (x.getCount(this.kib) > this.khV) {
                        int size = this.kib.size();
                        while (true) {
                            size--;
                            if (size < this.khV) {
                                break;
                            }
                            this.kib.remove(size);
                        }
                    }
                    hashSet3.clear();
                    hashSet4.clear();
                    Iterator<ThreadInfo> it2 = this.kib.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo next2 = it2.next();
                        if (next2 != null && !TextUtils.isEmpty(next2.lego_card)) {
                            hashSet4.add(next2.lego_card);
                        } else if (next2 != null && next2.tid != null) {
                            hashSet3.add(next2.tid);
                        }
                    }
                }
                for (int count2 = x.getCount(list2) - 1; count2 >= 0; count2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) x.getItem(list2, count2);
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
            if (cTD()) {
                if (!x.isEmpty(this.kic) && builder2.banner_list != null) {
                    int count3 = x.getCount(list2) + x.getCount(builder2.banner_list.app);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= this.kic.size()) {
                            break;
                        }
                        App app = this.kic.get(i3);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            builder4.pos_name = String.valueOf(com.baidu.adp.lib.f.b.toInt(app.pos_name, 0) + count3);
                            App build = builder4.build(false);
                            this.kic.remove(i3);
                            this.kic.add(i3, build);
                        }
                        i2 = i3 + 1;
                    }
                }
                if (x.getCount(list) >= this.khY) {
                    list.addAll(this.kib);
                    this.kib.clear();
                    BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                    if (builder5.app == null) {
                        builder5.app = new LinkedList();
                    }
                    builder5.app.addAll(this.kic);
                    builder.banner_list = builder5.build(false);
                    this.kic.clear();
                }
            }
            int count4 = x.getCount(list) + x.getCount(this.kib);
            this.jYV.kih = count4 - count;
            this.khW = count4 - count;
            com.baidu.tieba.recapp.report.b.dFV().q("NEWINDEX", arrayList);
        }
    }

    private void ef(List<p> list) {
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
        f cTB;
        k aE;
        k aE2;
        k aE3;
        String format;
        if (list == null) {
            return null;
        }
        if (builder != null && !x.isEmpty(builder.thread_list) && builder.active_center != null) {
            ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
            if (threadInfo.id.longValue() > 0 && q.blB().blD()) {
                this.kie = threadInfo.id;
            }
        }
        List<n> arrayList = new ArrayList<>(x.getCount(list));
        for (ThreadInfo threadInfo2 : list) {
            bz bzVar = new bz();
            com.baidu.tbadk.a.a.a.a(bzVar);
            bzVar.eWd = true;
            bzVar.a(threadInfo2);
            arrayList.add(bzVar);
        }
        if (builder != null && com.baidu.tieba.homepage.concern.a.c.a(builder.hot_recomforum, -1)) {
            com.baidu.tieba.homepage.concern.a.c cVar = new com.baidu.tieba.homepage.concern.a.c();
            cVar.floorPosition = builder.hot_recomforum.floor.intValue() > 0 ? builder.hot_recomforum.floor.intValue() - 1 : 0;
            if (cVar.dV(builder.hot_recomforum.tab_list)) {
                a(cVar, cVar.floorPosition, arrayList);
            }
        }
        LinkedList linkedList = new LinkedList();
        int i3 = 0;
        for (n nVar : arrayList) {
            if (nVar instanceof bz) {
                bz bzVar2 = (bz) nVar;
                if (!TextUtils.isEmpty(bzVar2.bsD())) {
                    am amVar = new am();
                    amVar.AP(bzVar2.bsD());
                    amVar.position = i3;
                    linkedList.add(amVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.ad(bzVar2)) {
                    if (!StringUtils.isNull(bzVar2.btn().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(bzVar2.btn());
                        aVar.from = 1;
                        aVar.position = i3;
                        aVar.setThreadData(bzVar2);
                        aVar.setSupportType(BaseCardInfo.SupportType.FULL);
                        linkedList.add(aVar);
                    }
                } else if (k.ad(bzVar2) || l.ad(bzVar2)) {
                    boolean z = false;
                    k aE4 = d.aE(bzVar2);
                    if (aE4 != null) {
                        if (bzVar2.boT()) {
                            if (aE4.isValid()) {
                                aE4.tid = bzVar2.getTid();
                                aE4.position = i3;
                                d.a(aE4);
                                linkedList.add(aE4);
                            }
                            z = false;
                        } else {
                            bz bzVar3 = aE4.eMv;
                            if (bzVar3 != null && bzVar3.bti() != null && !StringUtils.isNull(bzVar3.bti().forumName)) {
                                aE4.tid = bzVar2.getTid();
                                aE4.position = i3;
                                d.h(aE4);
                                linkedList.add(aE4);
                                z = true;
                            } else {
                                if (aE4.isValid()) {
                                    aE4.tid = bzVar2.getTid();
                                    aE4.position = i3;
                                    d.a(aE4);
                                    linkedList.add(aE4);
                                }
                                z = false;
                            }
                        }
                    }
                    int[] imageWidthAndHeight = bzVar2.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.b aD = d.aD(bzVar2);
                    if (aD != null) {
                        aD.tid = bzVar2.getTid();
                        aD.position = i3;
                        if (aD instanceof k) {
                            if (bzVar2.btp()) {
                                d.d(aD);
                            } else if (bzVar2.bsz() == 1) {
                                d.b(aD);
                                aD.eSI = imageWidthAndHeight[0];
                                aD.eSJ = imageWidthAndHeight[1];
                            } else if (bzVar2.bsz() >= 2) {
                                d.c(aD);
                            } else {
                                d.e(aD);
                            }
                        } else if (aD instanceof l) {
                            d.f(aD);
                        }
                    }
                    if (aD != null && aD.isValid()) {
                        aD.eMv.bqT();
                        if (!bzVar2.bqa() && bzVar2.brr() != null && z) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bzVar2.brr().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, bzVar2.brr().getUserId()) { // from class: com.baidu.tieba.homepage.personalize.model.a.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    aq aj;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (aD instanceof k) {
                                        aj = ((k) aD).cvC();
                                    } else {
                                        aj = aD instanceof l ? ((l) aD).aj(null) : null;
                                    }
                                    TiebaStatic.log(aj);
                                }
                            }, 0, format.length() - 1, 33);
                            aD.eMv.a(spannableString);
                        }
                        linkedList.add(aD);
                    }
                    if (bzVar2.bty() != null && (aE3 = d.aE(bzVar2)) != null) {
                        aE3.tid = bzVar2.getTid();
                        aE3.position = i3;
                        d.k(aE3);
                        if (k.ad(bzVar2)) {
                            aE3.Jq("1");
                        } else if (l.ad(bzVar2)) {
                            aE3.Jq("2");
                        }
                        linkedList.add(aE3);
                    }
                    if ((!x.isEmpty(bzVar2.btB()) || !x.isEmpty(bzVar2.btC())) && (aE = d.aE(bzVar2)) != null) {
                        aE.tid = bzVar2.getTid();
                        aE.position = i3;
                        if (x.getCount(bzVar2.btB()) + x.getCount(bzVar2.btC()) == 1) {
                            d.l(aE);
                        } else {
                            d.m(aE);
                        }
                        linkedList.add(aE);
                    }
                    if (bzVar2.boT() && (aE2 = d.aE(bzVar2)) != null) {
                        aE2.tid = bzVar2.getTid();
                        aE2.position = i3;
                        d.g(aE2);
                        if (k.ad(bzVar2)) {
                            aE2.Jq("1");
                        } else if (l.ad(bzVar2)) {
                            aE2.Jq("2");
                        }
                        if (bzVar2.boT() && !StringUtils.isNull(bzVar2.brv())) {
                            linkedList.add(aE2);
                        } else if (!StringUtils.isNull(bzVar2.brv())) {
                            linkedList.add(aE2);
                        }
                    }
                    if (bzVar2.bsX() != null) {
                        k aE5 = d.aE(bzVar2);
                        if (aE5 != null) {
                            aE5.tid = bzVar2.getTid();
                            aE5.position = i3;
                            d.i(aE5);
                        }
                        if (aE5 != null && aE5.isValid()) {
                            linkedList.add(aE5);
                        }
                    }
                    k aE6 = d.aE(bzVar2);
                    if (aE6 != null) {
                        aE6.tid = bzVar2.getTid();
                        aE6.position = i3;
                        d.j(aE6);
                    }
                    if (aE6 != null && aE6.isValid()) {
                        linkedList.add(aE6);
                    }
                } else if (com.baidu.tieba.card.data.e.ad(bzVar2) && bzVar2.bpY()) {
                    com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e(bzVar2);
                    eVar.position = i3;
                    linkedList.add(eVar);
                } else {
                    com.baidu.tieba.card.data.b aD2 = d.aD(bzVar2);
                    if (aD2 != null) {
                        aD2.tid = bzVar2.getTid();
                        aD2.position = i3;
                    }
                    if (aD2 != null && aD2.isValid()) {
                        linkedList.add(aD2);
                    }
                }
                long j = com.baidu.adp.lib.f.b.toLong(bzVar2.getId(), 0L);
                if (j != 0 && j == this.kie.longValue()) {
                    g gVar = null;
                    if (builder.active_center != null) {
                        gVar = new g();
                        gVar.a(builder.active_center);
                    }
                    if (gVar == null) {
                        gVar = cTC();
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
            if (i7 >= x.getCount(list2)) {
                break;
            }
            p pVar = (p) x.getItem(list2, i7);
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
        Iterator it = linkedList.iterator();
        while (true) {
            int i10 = i9;
            if (!it.hasNext()) {
                break;
            }
            n nVar2 = (n) it.next();
            if (nVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) {
                i10++;
            } else if (nVar2 instanceof BaseCardInfo) {
                ((BaseCardInfo) nVar2).position += i10;
            }
            i9 = i10;
        }
        if (i2 == 0) {
            if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !x.isEmpty(userFollowLive.user_follow_live)) {
                f fVar = new f();
                fVar.a(userFollowLive);
                linkedList.add(0, fVar);
                fVar.position = -1;
                int i11 = i3 + 1;
            } else if (i == 1 && (cTB = cTB()) != null) {
                linkedList.add(0, cTB);
                cTB.position = -1;
                int i12 = i3 + 1;
            }
        }
        com.baidu.tbadk.a.a.a.bo(linkedList);
        return linkedList;
    }

    public void a(com.baidu.tbadk.core.data.a aVar, int i, List<n> list) {
        int i2;
        if (aVar != null && list != null && i > 0) {
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                if (!(list.get(i3) instanceof bz)) {
                    i2 = i4;
                } else if (i == i4) {
                    aVar.floorPosition = i;
                    x.add(list, i3, aVar);
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
                int count = (x.getCount(list) - i2) + 30;
                while (true) {
                    count--;
                    if (count < 30) {
                        break;
                    } else if (list.size() > count) {
                        arrayList.add(list.remove(count));
                    }
                }
            } else {
                for (int count2 = x.getCount(list) - 1; count2 >= i2; count2--) {
                    list.remove(count2);
                }
            }
        }
        return arrayList;
    }

    private f cTB() {
        if (this.jYV == null || x.isEmpty(this.jYV.geK)) {
            return null;
        }
        for (n nVar : this.jYV.geK) {
            if (nVar instanceof f) {
                return (f) nVar;
            }
        }
        return null;
    }

    private g cTC() {
        if (this.jYV == null || x.isEmpty(this.jYV.geK)) {
            return null;
        }
        for (n nVar : this.jYV.geK) {
            if (nVar instanceof g) {
                return (g) nVar;
            }
        }
        return null;
    }

    private boolean cTD() {
        return this.khY > 0;
    }

    public boolean cTE() {
        return (this.kib == null || x.isEmpty(this.kib)) ? false : true;
    }

    public List<ThreadInfo> cTF() {
        return this.kib;
    }
}
