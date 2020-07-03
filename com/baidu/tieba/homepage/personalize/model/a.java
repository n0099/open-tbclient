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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
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
/* loaded from: classes9.dex */
public class a {
    private int ive;
    private int ivf;
    private int ivb = 0;
    private com.baidu.tieba.homepage.personalize.b.d ivc = new com.baidu.tieba.homepage.personalize.b.d();
    private int ivd = 0;
    private Long ivi = 0L;
    private final c inz = new c();
    private final int iva = com.baidu.tbadk.core.sharedPref.b.aVP().getInt("home_page_max_thread_count", 300);
    private ArrayList<ThreadInfo> ivg = new ArrayList<>();
    private ArrayList<App> ivh = new ArrayList<>();

    public int cke() {
        return this.iva;
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
        List<ThreadInfo> a = a(builder, i, this.iva);
        d.g(builder);
        List<p> d = d.d(builder);
        cZ(d);
        List<q> a2 = a(builder.thread_list, d, builder3.user_follow_live, i, 0, builder3);
        List<q> a3 = a(a, new ArrayList(), builder3.user_follow_live, i, 1, null);
        this.ivc.dc(a2);
        b.a(builder, a2);
        this.inz.eSH = a2;
        this.inz.ivm = a3 == null ? 0 : a3.size();
        return this.inz;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            this.ivd = (builder2.fresh_ctrl_num == null || builder2.fresh_ctrl_num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
            this.ivd = this.ivd > this.iva ? this.iva : this.ivd;
            d(z, builder, builder2, i);
            c(z, builder, builder2, i);
            o(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void o(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.ivb, this.ive, this.ivf);
    }

    private void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null && builder.thread_list != null && builder2.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            List<ThreadInfo> list2 = builder2.thread_list;
            this.ive = w.getCount(list);
            if (builder.banner_list != null) {
                this.ivf = w.getCount(builder.banner_list.app);
            } else {
                this.ivf = 0;
            }
            int count = w.getCount(list) + w.getCount(this.ivg);
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
            Iterator<ThreadInfo> it = this.ivg.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                    hashSet4.add(next.lego_card);
                } else if (next != null && next.tid != null) {
                    hashSet3.add(next.tid);
                }
            }
            if (i == 1) {
                if (!w.isEmpty(list2)) {
                    this.ivc.b((ThreadInfo) w.getItem(list2, 0));
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
                this.ivc.f(z, list);
                if (ckh()) {
                    if (builder.banner_list != null && !w.isEmpty(builder.banner_list.app)) {
                        this.ivh.addAll(0, builder.banner_list.app);
                        BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                        builder3.app = new LinkedList();
                        builder.banner_list = builder3.build(false);
                    }
                    this.ivg.addAll(0, list);
                    list.clear();
                    hashSet.clear();
                    hashSet2.clear();
                    if (w.getCount(this.ivg) > this.iva) {
                        int size = this.ivg.size();
                        while (true) {
                            size--;
                            if (size < this.iva) {
                                break;
                            }
                            this.ivg.remove(size);
                        }
                    }
                    hashSet3.clear();
                    hashSet4.clear();
                    Iterator<ThreadInfo> it2 = this.ivg.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo next2 = it2.next();
                        if (next2 != null && !TextUtils.isEmpty(next2.lego_card)) {
                            hashSet4.add(next2.lego_card);
                        } else if (next2 != null && next2.tid != null) {
                            hashSet3.add(next2.tid);
                        }
                    }
                }
                for (int count2 = w.getCount(list2) - 1; count2 >= 0; count2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) w.getItem(list2, count2);
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
            if (ckh()) {
                if (!w.isEmpty(this.ivh) && builder2.banner_list != null) {
                    int count3 = w.getCount(list2) + w.getCount(builder2.banner_list.app);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= this.ivh.size()) {
                            break;
                        }
                        App app = this.ivh.get(i3);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            builder4.pos_name = String.valueOf(com.baidu.adp.lib.f.b.toInt(app.pos_name, 0) + count3);
                            App build = builder4.build(false);
                            this.ivh.remove(i3);
                            this.ivh.add(i3, build);
                        }
                        i2 = i3 + 1;
                    }
                }
                if (w.getCount(list) >= this.ivd) {
                    list.addAll(this.ivg);
                    this.ivg.clear();
                    BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                    if (builder5.app == null) {
                        builder5.app = new LinkedList();
                    }
                    builder5.app.addAll(this.ivh);
                    builder.banner_list = builder5.build(false);
                    this.ivh.clear();
                }
            }
            int count4 = w.getCount(list) + w.getCount(this.ivg);
            this.inz.ivl = count4 - count;
            this.ivb = count4 - count;
            com.baidu.tieba.recapp.report.b.cZK().eI(arrayList);
        }
    }

    private void cZ(List<p> list) {
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
        f ckf;
        int i3;
        int i4;
        int i5;
        int i6;
        k aC;
        k aC2;
        k aC3;
        String format;
        if (list == null) {
            return null;
        }
        if (builder != null && !w.isEmpty(builder.thread_list) && builder.active_center != null) {
            ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
            if (threadInfo.id.longValue() > 0 && com.baidu.tbadk.BdToken.q.aMU().aMW()) {
                this.ivi = threadInfo.id;
            }
        }
        com.baidu.tbadk.a.e aOa = com.baidu.tbadk.a.a.c.aOa();
        LinkedList linkedList = new LinkedList();
        int i7 = 0;
        for (ThreadInfo threadInfo2 : list) {
            if (threadInfo2 != null) {
                bu buVar = new bu();
                com.baidu.tbadk.a.a.c.a(aOa, buVar);
                buVar.dOy = true;
                buVar.a(threadInfo2);
                if (!TextUtils.isEmpty(buVar.aTz())) {
                    ai aiVar = new ai();
                    aiVar.vG(buVar.aTz());
                    aiVar.position = i7;
                    linkedList.add(aiVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.ad(buVar)) {
                    if (!StringUtils.isNull(buVar.aUj().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(buVar.aUj());
                        aVar.from = 1;
                        aVar.position = i7;
                        aVar.setThreadData(buVar);
                        linkedList.add(aVar);
                    }
                } else if (k.ad(buVar) || l.ad(buVar)) {
                    boolean z = false;
                    k aC4 = d.aC(buVar);
                    if (aC4 != null) {
                        if (buVar.aPY()) {
                            if (aC4.isValid()) {
                                aC4.tid = buVar.getTid();
                                aC4.position = i7;
                                d.a(aC4);
                                linkedList.add(aC4);
                            }
                            z = false;
                        } else {
                            bu buVar2 = aC4.dLi;
                            if (buVar2 != null && buVar2.aUd() != null && !StringUtils.isNull(buVar2.aUd().forumName)) {
                                aC4.tid = buVar.getTid();
                                aC4.position = i7;
                                d.h(aC4);
                                linkedList.add(aC4);
                                z = true;
                            } else {
                                if (aC4.isValid()) {
                                    aC4.tid = buVar.getTid();
                                    aC4.position = i7;
                                    d.a(aC4);
                                    linkedList.add(aC4);
                                }
                                z = false;
                            }
                        }
                    }
                    int[] imageWidthAndHeight = buVar.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.c aB = d.aB(buVar);
                    if (aB != null) {
                        aB.tid = buVar.getTid();
                        aB.position = i7;
                        if (aB instanceof k) {
                            if (buVar.aUl()) {
                                d.d(aB);
                            } else if (buVar.aTv() == 1) {
                                d.b(aB);
                                aB.dLj = imageWidthAndHeight[0];
                                aB.dLk = imageWidthAndHeight[1];
                            } else if (buVar.aTv() >= 2) {
                                d.c(aB);
                            } else {
                                d.e(aB);
                            }
                        } else if (aB instanceof l) {
                            d.f(aB);
                        }
                    }
                    if (aB != null && aB.isValid()) {
                        aB.dLi.aRR();
                        if (!buVar.aQZ() && buVar.aSp() != null && z) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), buVar.aSp().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, buVar.aSp().getUserId()) { // from class: com.baidu.tieba.homepage.personalize.model.a.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    ao aj;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (aB instanceof k) {
                                        aj = ((k) aB).bPa();
                                    } else {
                                        aj = aB instanceof l ? ((l) aB).aj(null) : null;
                                    }
                                    TiebaStatic.log(aj);
                                }
                            }, 0, format.length() - 1, 33);
                            aB.dLi.a(spannableString);
                        }
                        linkedList.add(aB);
                    }
                    if (buVar.aUu() != null && (aC3 = d.aC(buVar)) != null) {
                        aC3.tid = buVar.getTid();
                        aC3.position = i7;
                        d.k(aC3);
                        if (k.ad(buVar)) {
                            aC3.DR("1");
                        } else if (l.ad(buVar)) {
                            aC3.DR("2");
                        }
                        linkedList.add(aC3);
                    }
                    if (!w.isEmpty(buVar.aUx()) && (aC2 = d.aC(buVar)) != null) {
                        aC2.tid = buVar.getTid();
                        aC2.position = i7;
                        if (w.getCount(buVar.aUx()) == 1) {
                            d.l(aC2);
                        } else {
                            d.m(aC2);
                        }
                        linkedList.add(aC2);
                    }
                    if ((buVar.aPY() || buVar.aQa()) && (aC = d.aC(buVar)) != null) {
                        aC.tid = buVar.getTid();
                        aC.position = i7;
                        d.g(aC);
                        if (k.ad(buVar)) {
                            aC.DR("1");
                        } else if (l.ad(buVar)) {
                            aC.DR("2");
                        }
                        if (buVar.aPY() && !z && !StringUtils.isNull(buVar.aSt())) {
                            linkedList.add(aC);
                        } else if (buVar.aQa() && !StringUtils.isNull(buVar.aUr())) {
                            linkedList.add(aC);
                        }
                    }
                    if (threadInfo2.top_agree_post != null) {
                        k aC5 = d.aC(buVar);
                        if (aC5 != null) {
                            aC5.tid = buVar.getTid();
                            aC5.position = i7;
                            d.i(aC5);
                        }
                        if (aC5 != null && aC5.isValid()) {
                            linkedList.add(aC5);
                        }
                    }
                    k aC6 = d.aC(buVar);
                    if (aC6 != null) {
                        aC6.tid = buVar.getTid();
                        aC6.position = i7;
                        d.j(aC6);
                    }
                    if (aC6 != null && aC6.isValid()) {
                        linkedList.add(aC6);
                    }
                } else if (com.baidu.tieba.card.data.e.ad(buVar) && buVar.aQX()) {
                    com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e(buVar);
                    eVar.position = i7;
                    linkedList.add(eVar);
                } else {
                    com.baidu.tieba.card.data.c aB2 = d.aB(buVar);
                    if (aB2 != null) {
                        aB2.tid = buVar.getTid();
                        aB2.position = i7;
                    }
                    if (aB2 != null && aB2.isValid()) {
                        linkedList.add(aB2);
                    }
                }
                if (threadInfo2.id.longValue() != 0 && threadInfo2.id.equals(this.ivi)) {
                    g gVar = null;
                    if (builder.active_center != null) {
                        gVar = new g();
                        gVar.a(builder.active_center);
                    }
                    if (gVar == null) {
                        gVar = ckg();
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
        while (i10 < w.getCount(list2)) {
            p pVar = (p) w.getItem(list2, i10);
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
            q qVar = (q) it.next();
            if (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) {
                i14++;
            } else if (qVar instanceof com.baidu.tieba.card.data.b) {
                ((com.baidu.tieba.card.data.b) qVar).position += i14;
            }
            i13 = i14;
        }
        if (i2 == 0) {
            if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !w.isEmpty(userFollowLive.user_follow_live)) {
                f fVar = new f();
                fVar.a(userFollowLive);
                linkedList.add(0, fVar);
                fVar.position = -1;
                int i15 = i7 + 1;
            } else if (i == 1 && (ckf = ckf()) != null) {
                linkedList.add(0, ckf);
                ckf.position = -1;
                int i16 = i7 + 1;
            }
        }
        com.baidu.tbadk.a.a.c.a(aOa, linkedList);
        return linkedList;
    }

    private List<ThreadInfo> a(DataRes.Builder builder, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int count = (w.getCount(list) - i2) + 30;
                while (true) {
                    count--;
                    if (count < 30) {
                        break;
                    } else if (list.size() > count) {
                        arrayList.add(list.remove(count));
                    }
                }
            } else {
                for (int count2 = w.getCount(list) - 1; count2 >= i2; count2--) {
                    list.remove(count2);
                }
            }
        }
        return arrayList;
    }

    private f ckf() {
        if (this.inz == null || w.isEmpty(this.inz.eSH)) {
            return null;
        }
        for (q qVar : this.inz.eSH) {
            if (qVar instanceof f) {
                return (f) qVar;
            }
        }
        return null;
    }

    private g ckg() {
        if (this.inz == null || w.isEmpty(this.inz.eSH)) {
            return null;
        }
        for (q qVar : this.inz.eSH) {
            if (qVar instanceof g) {
                return (g) qVar;
            }
        }
        return null;
    }

    private boolean ckh() {
        return this.ivd > 0;
    }

    public boolean cki() {
        return (this.ivg == null || w.isEmpty(this.ivg)) ? false : true;
    }

    public List<ThreadInfo> ckj() {
        return this.ivg;
    }
}
