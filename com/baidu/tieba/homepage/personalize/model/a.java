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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class a {
    private int iBk;
    private int iBl;
    private int iBh = 0;
    private com.baidu.tieba.homepage.personalize.b.d iBi = new com.baidu.tieba.homepage.personalize.b.d();
    private int iBj = 0;
    private Long iBo = 0L;
    private final c itD = new c();
    private final int iBg = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("home_page_max_thread_count", 300);
    private ArrayList<ThreadInfo> iBm = new ArrayList<>();
    private ArrayList<App> iBn = new ArrayList<>();

    public int cnG() {
        return this.iBg;
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
        List<ThreadInfo> a = a(builder, i, this.iBg);
        d.g(builder);
        List<p> d = d.d(builder);
        de(d);
        List<q> a2 = a(builder.thread_list, d, builder3.user_follow_live, i, 0, builder3);
        List<q> a3 = a(a, new ArrayList(), builder3.user_follow_live, i, 1, null);
        this.iBi.dh(a2);
        b.a(builder, a2);
        this.itD.eZc = a2;
        this.itD.iBs = a3 == null ? 0 : a3.size();
        return this.itD;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            this.iBj = (builder2.fresh_ctrl_num == null || builder2.fresh_ctrl_num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
            this.iBj = this.iBj > this.iBg ? this.iBg : this.iBj;
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
        d.a(z, builder, builder2, i, this.iBh, this.iBk, this.iBl);
    }

    private void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null && builder.thread_list != null && builder2.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            List<ThreadInfo> list2 = builder2.thread_list;
            this.iBk = x.getCount(list);
            if (builder.banner_list != null) {
                this.iBl = x.getCount(builder.banner_list.app);
            } else {
                this.iBl = 0;
            }
            int count = x.getCount(list) + x.getCount(this.iBm);
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
            Iterator<ThreadInfo> it = this.iBm.iterator();
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
                    this.iBi.b((ThreadInfo) x.getItem(list2, 0));
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
                this.iBi.f(z, list);
                if (cnJ()) {
                    if (builder.banner_list != null && !x.isEmpty(builder.banner_list.app)) {
                        this.iBn.addAll(0, builder.banner_list.app);
                        BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                        builder3.app = new LinkedList();
                        builder.banner_list = builder3.build(false);
                    }
                    this.iBm.addAll(0, list);
                    list.clear();
                    hashSet.clear();
                    hashSet2.clear();
                    if (x.getCount(this.iBm) > this.iBg) {
                        int size = this.iBm.size();
                        while (true) {
                            size--;
                            if (size < this.iBg) {
                                break;
                            }
                            this.iBm.remove(size);
                        }
                    }
                    hashSet3.clear();
                    hashSet4.clear();
                    Iterator<ThreadInfo> it2 = this.iBm.iterator();
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
            if (cnJ()) {
                if (!x.isEmpty(this.iBn) && builder2.banner_list != null) {
                    int count3 = x.getCount(list2) + x.getCount(builder2.banner_list.app);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= this.iBn.size()) {
                            break;
                        }
                        App app = this.iBn.get(i3);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            builder4.pos_name = String.valueOf(com.baidu.adp.lib.f.b.toInt(app.pos_name, 0) + count3);
                            App build = builder4.build(false);
                            this.iBn.remove(i3);
                            this.iBn.add(i3, build);
                        }
                        i2 = i3 + 1;
                    }
                }
                if (x.getCount(list) >= this.iBj) {
                    list.addAll(this.iBm);
                    this.iBm.clear();
                    BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                    if (builder5.app == null) {
                        builder5.app = new LinkedList();
                    }
                    builder5.app.addAll(this.iBn);
                    builder.banner_list = builder5.build(false);
                    this.iBn.clear();
                }
            }
            int count4 = x.getCount(list) + x.getCount(this.iBm);
            this.itD.iBr = count4 - count;
            this.iBh = count4 - count;
            com.baidu.tieba.recapp.report.b.dcS().eO(arrayList);
        }
    }

    private void de(List<p> list) {
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
        f cnH;
        int i3;
        int i4;
        int i5;
        int i6;
        k az;
        k az2;
        k az3;
        String format;
        if (list == null) {
            return null;
        }
        if (builder != null && !x.isEmpty(builder.thread_list) && builder.active_center != null) {
            ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
            if (threadInfo.id.longValue() > 0 && com.baidu.tbadk.BdToken.q.aQI().aQK()) {
                this.iBo = threadInfo.id;
            }
        }
        LinkedList linkedList = new LinkedList();
        int i7 = 0;
        for (ThreadInfo threadInfo2 : list) {
            if (threadInfo2 != null) {
                bv bvVar = new bv();
                com.baidu.tbadk.a.a.a.a(bvVar);
                bvVar.dUJ = true;
                bvVar.a(threadInfo2);
                if (!TextUtils.isEmpty(bvVar.aXv())) {
                    aj ajVar = new aj();
                    ajVar.wN(bvVar.aXv());
                    ajVar.position = i7;
                    linkedList.add(ajVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.aa(bvVar)) {
                    if (!StringUtils.isNull(bvVar.aYe().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(bvVar.aYe());
                        aVar.from = 1;
                        aVar.position = i7;
                        aVar.setThreadData(bvVar);
                        linkedList.add(aVar);
                    }
                } else if (k.aa(bvVar) || l.aa(bvVar)) {
                    boolean z = false;
                    k az4 = d.az(bvVar);
                    if (az4 != null) {
                        if (bvVar.aTT()) {
                            if (az4.isValid()) {
                                az4.tid = bvVar.getTid();
                                az4.position = i7;
                                d.a(az4);
                                linkedList.add(az4);
                            }
                            z = false;
                        } else {
                            bv bvVar2 = az4.dLK;
                            if (bvVar2 != null && bvVar2.aXZ() != null && !StringUtils.isNull(bvVar2.aXZ().forumName)) {
                                az4.tid = bvVar.getTid();
                                az4.position = i7;
                                d.h(az4);
                                linkedList.add(az4);
                                z = true;
                            } else {
                                if (az4.isValid()) {
                                    az4.tid = bvVar.getTid();
                                    az4.position = i7;
                                    d.a(az4);
                                    linkedList.add(az4);
                                }
                                z = false;
                            }
                        }
                    }
                    int[] imageWidthAndHeight = bvVar.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.c ay = d.ay(bvVar);
                    if (ay != null) {
                        ay.tid = bvVar.getTid();
                        ay.position = i7;
                        if (ay instanceof k) {
                            if (bvVar.aYg()) {
                                d.d(ay);
                            } else if (bvVar.aXr() == 1) {
                                d.b(ay);
                                ay.dRu = imageWidthAndHeight[0];
                                ay.dRv = imageWidthAndHeight[1];
                            } else if (bvVar.aXr() >= 2) {
                                d.c(ay);
                            } else {
                                d.e(ay);
                            }
                        } else if (ay instanceof l) {
                            d.f(ay);
                        }
                    }
                    if (ay != null && ay.isValid()) {
                        ay.dLK.aVN();
                        if (!bvVar.aUV() && bvVar.aWl() != null && z) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bvVar.aWl().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, bvVar.aWl().getUserId()) { // from class: com.baidu.tieba.homepage.personalize.model.a.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    ap ag;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (ay instanceof k) {
                                        ag = ((k) ay).bSm();
                                    } else {
                                        ag = ay instanceof l ? ((l) ay).ag(null) : null;
                                    }
                                    TiebaStatic.log(ag);
                                }
                            }, 0, format.length() - 1, 33);
                            ay.dLK.a(spannableString);
                        }
                        linkedList.add(ay);
                    }
                    if (bvVar.aYo() != null && (az3 = d.az(bvVar)) != null) {
                        az3.tid = bvVar.getTid();
                        az3.position = i7;
                        d.k(az3);
                        if (k.aa(bvVar)) {
                            az3.EC("1");
                        } else if (l.aa(bvVar)) {
                            az3.EC("2");
                        }
                        linkedList.add(az3);
                    }
                    if (!x.isEmpty(bvVar.aYr()) && (az2 = d.az(bvVar)) != null) {
                        az2.tid = bvVar.getTid();
                        az2.position = i7;
                        if (x.getCount(bvVar.aYr()) == 1) {
                            d.l(az2);
                        } else {
                            d.m(az2);
                        }
                        linkedList.add(az2);
                    }
                    if (bvVar.aTT() && (az = d.az(bvVar)) != null) {
                        az.tid = bvVar.getTid();
                        az.position = i7;
                        d.g(az);
                        if (k.aa(bvVar)) {
                            az.EC("1");
                        } else if (l.aa(bvVar)) {
                            az.EC("2");
                        }
                        if (bvVar.aTT() && !StringUtils.isNull(bvVar.aWp())) {
                            linkedList.add(az);
                        } else if (!StringUtils.isNull(bvVar.aWp())) {
                            linkedList.add(az);
                        }
                    }
                    if (threadInfo2.top_agree_post != null) {
                        k az5 = d.az(bvVar);
                        if (az5 != null) {
                            az5.tid = bvVar.getTid();
                            az5.position = i7;
                            d.i(az5);
                        }
                        if (az5 != null && az5.isValid()) {
                            linkedList.add(az5);
                        }
                    }
                    k az6 = d.az(bvVar);
                    if (az6 != null) {
                        az6.tid = bvVar.getTid();
                        az6.position = i7;
                        d.j(az6);
                    }
                    if (az6 != null && az6.isValid()) {
                        linkedList.add(az6);
                    }
                } else if (com.baidu.tieba.card.data.e.aa(bvVar) && bvVar.aUT()) {
                    com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e(bvVar);
                    eVar.position = i7;
                    linkedList.add(eVar);
                } else {
                    com.baidu.tieba.card.data.c ay2 = d.ay(bvVar);
                    if (ay2 != null) {
                        ay2.tid = bvVar.getTid();
                        ay2.position = i7;
                    }
                    if (ay2 != null && ay2.isValid()) {
                        linkedList.add(ay2);
                    }
                }
                if (threadInfo2.id.longValue() != 0 && threadInfo2.id.equals(this.iBo)) {
                    g gVar = null;
                    if (builder.active_center != null) {
                        gVar = new g();
                        gVar.a(builder.active_center);
                    }
                    if (gVar == null) {
                        gVar = cnI();
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
        while (i10 < x.getCount(list2)) {
            p pVar = (p) x.getItem(list2, i10);
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
            if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !x.isEmpty(userFollowLive.user_follow_live)) {
                f fVar = new f();
                fVar.a(userFollowLive);
                linkedList.add(0, fVar);
                fVar.position = -1;
                int i15 = i7 + 1;
            } else if (i == 1 && (cnH = cnH()) != null) {
                linkedList.add(0, cnH);
                cnH.position = -1;
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

    private f cnH() {
        if (this.itD == null || x.isEmpty(this.itD.eZc)) {
            return null;
        }
        for (q qVar : this.itD.eZc) {
            if (qVar instanceof f) {
                return (f) qVar;
            }
        }
        return null;
    }

    private g cnI() {
        if (this.itD == null || x.isEmpty(this.itD.eZc)) {
            return null;
        }
        for (q qVar : this.itD.eZc) {
            if (qVar instanceof g) {
                return (g) qVar;
            }
        }
        return null;
    }

    private boolean cnJ() {
        return this.iBj > 0;
    }

    public boolean cnK() {
        return (this.iBm == null || x.isEmpty(this.iBm)) ? false : true;
    }

    public List<ThreadInfo> cnL() {
        return this.iBm;
    }
}
