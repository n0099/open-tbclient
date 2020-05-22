package com.baidu.tieba.homepage.personalize.model;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bk;
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
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class a {
    private int ifg;
    private int ifh;
    private int ifd = 0;
    private com.baidu.tieba.homepage.personalize.b.d ife = new com.baidu.tieba.homepage.personalize.b.d();
    private int iff = 0;
    private final c hYk = new c();
    private final int ifc = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("home_page_max_thread_count", 300);
    private ArrayList<ThreadInfo> ifi = new ArrayList<>();
    private ArrayList<App> ifj = new ArrayList<>();

    public int cgv() {
        return this.ifc;
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
        List<ThreadInfo> a = a(builder, i, this.ifc);
        d.f(builder);
        List<p> c = d.c(builder);
        cM(c);
        List<o> a2 = a(builder.thread_list, c, builder2.user_follow_live, i, 0);
        List<o> a3 = a(a, new ArrayList(), builder2.user_follow_live, i, 1);
        this.ife.cP(a2);
        b.a(builder, a2);
        this.hYk.eIk = a2;
        this.hYk.ifn = a3 == null ? 0 : a3.size();
        return this.hYk;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            this.iff = (builder2.fresh_ctrl_num == null || builder2.fresh_ctrl_num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
            this.iff = this.iff > this.ifc ? this.ifc : this.iff;
            d(z, builder, builder2, i);
            c(z, builder, builder2, i);
            n(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void n(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.ifd, this.ifg, this.ifh);
    }

    private void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null && builder.thread_list != null && builder2.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            List<ThreadInfo> list2 = builder2.thread_list;
            this.ifg = v.getCount(list);
            if (builder.banner_list != null) {
                this.ifh = v.getCount(builder.banner_list.app);
            } else {
                this.ifh = 0;
            }
            int count = v.getCount(list) + v.getCount(this.ifi);
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
            Iterator<ThreadInfo> it = this.ifi.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                    hashSet4.add(next.lego_card);
                } else if (next != null && next.tid != null) {
                    hashSet3.add(next.tid);
                }
            }
            if (i == 1) {
                if (!v.isEmpty(list2)) {
                    this.ife.b((ThreadInfo) v.getItem(list2, 0));
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
                this.ife.e(z, list);
                if (cgx()) {
                    if (builder.banner_list != null && !v.isEmpty(builder.banner_list.app)) {
                        this.ifj.addAll(0, builder.banner_list.app);
                        BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                        builder3.app = new LinkedList();
                        builder.banner_list = builder3.build(false);
                    }
                    this.ifi.addAll(0, list);
                    list.clear();
                    hashSet.clear();
                    hashSet2.clear();
                    if (v.getCount(this.ifi) > this.ifc) {
                        int size = this.ifi.size();
                        while (true) {
                            size--;
                            if (size < this.ifc) {
                                break;
                            }
                            this.ifi.remove(size);
                        }
                    }
                    hashSet3.clear();
                    hashSet4.clear();
                    Iterator<ThreadInfo> it2 = this.ifi.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo next2 = it2.next();
                        if (next2 != null && !TextUtils.isEmpty(next2.lego_card)) {
                            hashSet4.add(next2.lego_card);
                        } else if (next2 != null && next2.tid != null) {
                            hashSet3.add(next2.tid);
                        }
                    }
                }
                for (int count2 = v.getCount(list2) - 1; count2 >= 0; count2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) v.getItem(list2, count2);
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
            if (cgx()) {
                if (!v.isEmpty(this.ifj) && builder2.banner_list != null) {
                    int count3 = v.getCount(list2) + v.getCount(builder2.banner_list.app);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= this.ifj.size()) {
                            break;
                        }
                        App app = this.ifj.get(i3);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            builder4.pos_name = String.valueOf(com.baidu.adp.lib.f.b.toInt(app.pos_name, 0) + count3);
                            App build = builder4.build(false);
                            this.ifj.remove(i3);
                            this.ifj.add(i3, build);
                        }
                        i2 = i3 + 1;
                    }
                }
                if (v.getCount(list) >= this.iff) {
                    list.addAll(this.ifi);
                    this.ifi.clear();
                    BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                    if (builder5.app == null) {
                        builder5.app = new LinkedList();
                    }
                    builder5.app.addAll(this.ifj);
                    builder.banner_list = builder5.build(false);
                    this.ifj.clear();
                }
            }
            int count4 = v.getCount(list) + v.getCount(this.ifi);
            this.hYk.ifm = count4 - count;
            this.ifd = count4 - count;
            com.baidu.tieba.recapp.report.b.cVe().es(arrayList);
        }
    }

    private void cM(List<p> list) {
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

    private List<o> a(List<ThreadInfo> list, List<p> list2, UserFollowLive userFollowLive, int i, int i2) {
        f cgw;
        int i3;
        int i4;
        int i5;
        int i6;
        k aC;
        String format;
        if (list == null) {
            return null;
        }
        com.baidu.tbadk.a.e aMx = com.baidu.tbadk.a.a.c.aMx();
        LinkedList linkedList = new LinkedList();
        int i7 = 0;
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bk bkVar = new bk();
                com.baidu.tbadk.a.a.c.a(aMx, bkVar);
                bkVar.dHM = true;
                bkVar.a(threadInfo);
                if (!TextUtils.isEmpty(bkVar.aRI())) {
                    ad adVar = new ad();
                    adVar.vt(bkVar.aRI());
                    adVar.position = i7;
                    linkedList.add(adVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.ac(bkVar)) {
                    if (!StringUtils.isNull(bkVar.aSs().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(bkVar.aSs());
                        aVar.from = 1;
                        aVar.position = i7;
                        aVar.setThreadData(bkVar);
                        linkedList.add(aVar);
                    }
                } else if (k.ac(bkVar) || l.ac(bkVar)) {
                    boolean z = false;
                    k aC2 = d.aC(bkVar);
                    if (aC2 != null) {
                        if (bkVar.aOo()) {
                            if (aC2.isValid()) {
                                aC2.tid = bkVar.getTid();
                                aC2.position = i7;
                                d.a(aC2);
                                linkedList.add(aC2);
                            }
                            z = false;
                        } else {
                            bk bkVar2 = aC2.dEA;
                            if (bkVar2 != null && bkVar2.aSm() != null && !StringUtils.isNull(bkVar2.aSm().forumName)) {
                                aC2.tid = bkVar.getTid();
                                aC2.position = i7;
                                d.h(aC2);
                                linkedList.add(aC2);
                                z = true;
                            } else {
                                if (aC2.isValid()) {
                                    aC2.tid = bkVar.getTid();
                                    aC2.position = i7;
                                    d.a(aC2);
                                    linkedList.add(aC2);
                                }
                                z = false;
                            }
                        }
                    }
                    int[] imageWidthAndHeight = bkVar.getImageWidthAndHeight();
                    final com.baidu.tieba.card.data.c aB = d.aB(bkVar);
                    if (aB != null) {
                        aB.tid = bkVar.getTid();
                        aB.position = i7;
                        if (aB instanceof k) {
                            if (bkVar.aSv()) {
                                d.d(aB);
                            } else if (bkVar.aRE() == 1) {
                                d.b(aB);
                                aB.dEB = imageWidthAndHeight[0];
                                aB.dEC = imageWidthAndHeight[1];
                            } else if (bkVar.aRE() >= 2) {
                                d.c(aB);
                            } else {
                                d.e(aB);
                            }
                        } else if (aB instanceof l) {
                            d.f(aB);
                        }
                    }
                    if (aB != null && aB.isValid()) {
                        if (!bkVar.aSx() && bkVar.aQx() != null && z) {
                            SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bkVar.aQx().getName_show()));
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(16, bkVar.aQx().getUserId()) { // from class: com.baidu.tieba.homepage.personalize.model.a.2
                                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    an ai;
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                                    if (aB instanceof k) {
                                        ai = ((k) aB).bLO();
                                    } else {
                                        ai = aB instanceof l ? ((l) aB).ai(null) : null;
                                    }
                                    TiebaStatic.log(ai);
                                }
                            }, 0, format.length() - 1, 33);
                            aB.dEA.a(spannableString);
                        }
                        linkedList.add(aB);
                    }
                    if ((bkVar.aOo() || bkVar.aOq()) && (aC = d.aC(bkVar)) != null) {
                        aC.tid = bkVar.getTid();
                        aC.position = i7;
                        d.g(aC);
                        if (k.ac(bkVar)) {
                            aC.Dq("1");
                        } else if (l.ac(bkVar)) {
                            aC.Dq("2");
                        }
                        if (bkVar.aOo() && !z && !StringUtils.isNull(bkVar.aQC())) {
                            linkedList.add(aC);
                        } else if (bkVar.aOq() && !StringUtils.isNull(bkVar.aSC())) {
                            linkedList.add(aC);
                        }
                    }
                    if (threadInfo.top_agree_post != null) {
                        k aC3 = d.aC(bkVar);
                        if (aC3 != null) {
                            aC3.tid = bkVar.getTid();
                            aC3.position = i7;
                            d.i(aC3);
                        }
                        if (aC3 != null && aC3.isValid()) {
                            linkedList.add(aC3);
                        }
                    }
                    k aC4 = d.aC(bkVar);
                    if (aC4 != null) {
                        aC4.tid = bkVar.getTid();
                        aC4.position = i7;
                        d.j(aC4);
                    }
                    if (aC4 != null && aC4.isValid()) {
                        linkedList.add(aC4);
                    }
                } else if (com.baidu.tieba.card.data.e.ac(bkVar) && bkVar.aPm()) {
                    com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e(bkVar);
                    eVar.position = i7;
                    linkedList.add(eVar);
                } else {
                    com.baidu.tieba.card.data.c aB2 = d.aB(bkVar);
                    if (aB2 != null) {
                        aB2.tid = bkVar.getTid();
                        aB2.position = i7;
                    }
                    if (aB2 != null && aB2.isValid()) {
                        linkedList.add(aB2);
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
            o oVar = (o) it.next();
            if (oVar instanceof com.baidu.tieba.homepage.personalize.data.a) {
                i14++;
            } else if (oVar instanceof com.baidu.tieba.card.data.b) {
                ((com.baidu.tieba.card.data.b) oVar).position += i14;
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
            } else if (i == 1 && (cgw = cgw()) != null) {
                linkedList.add(0, cgw);
                cgw.position = -1;
                int i16 = i7 + 1;
            }
        }
        com.baidu.tbadk.a.a.c.a(aMx, linkedList);
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

    private f cgw() {
        if (this.hYk == null || v.isEmpty(this.hYk.eIk)) {
            return null;
        }
        for (o oVar : this.hYk.eIk) {
            if (oVar instanceof f) {
                return (f) oVar;
            }
        }
        return null;
    }

    private boolean cgx() {
        return this.iff > 0;
    }

    public boolean cgy() {
        return (this.ifi == null || v.isEmpty(this.ifi)) ? false : true;
    }

    public List<ThreadInfo> cgz() {
        return this.ifi;
    }
}
