package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRespMessage;
import d.a.c.a.f;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaFrsStoryLiveGatherModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;

    /* renamed from: e  reason: collision with root package name */
    public String f13955e;

    /* renamed from: f  reason: collision with root package name */
    public int f13956f;

    /* renamed from: g  reason: collision with root package name */
    public int f13957g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13958h;

    /* renamed from: i  reason: collision with root package name */
    public int f13959i;
    public boolean j;
    public int k;
    public List<a2> l;
    public List<a2> m;
    public List<n> n;
    public List<n> o;
    public List<n> p;
    public int q;
    public b r;
    public HttpMessageListener s;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                    AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                    if (httpResponsedMessage.hasError()) {
                        if (AlaFrsStoryLiveGatherModel.this.r != null) {
                            AlaFrsStoryLiveGatherModel.this.r.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    List<a2> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                    List<a2> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                    if (AlaFrsStoryLiveGatherModel.this.f13956f != 1 || ListUtils.getCount(liveList) > 10) {
                        AlaFrsStoryLiveGatherModel.this.q = 0;
                        AlaFrsStoryLiveGatherModel.this.j = alaFrsStoryLiveGatherRespMessage.hasMore();
                        AlaFrsStoryLiveGatherModel.this.f13956f = alaFrsStoryLiveGatherRequestMessage.getPn();
                        AlaFrsStoryLiveGatherModel.this.k = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                        if (AlaFrsStoryLiveGatherModel.this.f13956f == 1 || ListUtils.getCount(AlaFrsStoryLiveGatherModel.this.l) == 0) {
                            AlaFrsStoryLiveGatherModel.this.l = liveList;
                        } else if (ListUtils.getCount(liveList) > 0) {
                            AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel = AlaFrsStoryLiveGatherModel.this;
                            alaFrsStoryLiveGatherModel.l = alaFrsStoryLiveGatherModel.L(alaFrsStoryLiveGatherModel.l, liveList);
                        }
                    } else {
                        AlaFrsStoryLiveGatherModel.this.j = false;
                        AlaFrsStoryLiveGatherModel.this.f13956f = alaFrsStoryLiveGatherRequestMessage.getPn();
                        AlaFrsStoryLiveGatherModel.this.k = ListUtils.getCount(liveList);
                        AlaFrsStoryLiveGatherModel.this.l = liveList;
                        AlaFrsStoryLiveGatherModel.this.m = recommandList;
                        AlaFrsStoryLiveGatherModel.this.q = 1;
                    }
                    AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel2 = AlaFrsStoryLiveGatherModel.this;
                    alaFrsStoryLiveGatherModel2.K(alaFrsStoryLiveGatherModel2.l, AlaFrsStoryLiveGatherModel.this.m);
                    if (AlaFrsStoryLiveGatherModel.this.r != null) {
                        AlaFrsStoryLiveGatherModel.this.r.b(AlaFrsStoryLiveGatherModel.this.j);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str);

        void b(boolean z);
    }

    public AlaFrsStoryLiveGatherModel(f fVar) {
        super(fVar);
        this.f13956f = 1;
        this.f13957g = 30;
        this.f13959i = 1;
        this.q = 1;
        a aVar = new a(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER);
        this.s = aVar;
        registerListener(aVar);
    }

    public List<n> F(List<a2> list) {
        if (list == null || ListUtils.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            d.a.n0.v.h.b.a aVar = new d.a.n0.v.h.b.a();
            a2 a2Var = list.get(i2);
            aVar.f61966e = a2Var;
            if (a2Var.T() != null) {
                TiebaStatic.log(new StatisticItem("c12549").param("obj_param1", aVar.f61966e.T().getUserId()));
            }
            int i3 = i2 + 1;
            if (i3 < size) {
                a2 a2Var2 = list.get(i3);
                aVar.f61967f = a2Var2;
                if (a2Var2.T() != null) {
                    TiebaStatic.log(new StatisticItem("c12549").param("obj_param1", aVar.f61967f.T().getUserId()));
                }
            }
            linkedList.add(aVar);
        }
        return linkedList;
    }

    public List<n> G() {
        return this.p;
    }

    public int H() {
        return this.k;
    }

    public List<a2> I() {
        return this.l;
    }

    public int J() {
        return this.f13959i;
    }

    public final void K(List<a2> list, List<a2> list2) {
        this.n = F(list);
        this.o = F(list2);
        if (ListUtils.getCount(this.n) == 0 && ListUtils.getCount(this.o) == 0) {
            return;
        }
        List<n> list3 = this.p;
        if (list3 == null) {
            this.p = new ArrayList();
        } else {
            list3.clear();
        }
        List<n> list4 = this.n;
        if (list4 != null && list4.size() != 0) {
            this.p.addAll(this.n);
            this.f13958h = true;
        } else {
            this.p.add(new d.a.n0.v.e.b.a());
            this.f13958h = false;
        }
        if (ListUtils.getCount(this.o) <= 0 || this.j) {
            return;
        }
        this.p.add(new d.a.n0.v.e.b.b());
        for (int i2 = 0; i2 < 3 && i2 < ListUtils.getCount(this.o); i2++) {
            if (this.o.get(i2) != null) {
                this.p.add(this.o.get(i2));
            }
        }
    }

    public final List<a2> L(List<a2> list, List<a2> list2) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (a2 a2Var : list2) {
            if (a2Var != null && (a2Var.u1() == 49 || a2Var.u1() == 69)) {
                String y1 = a2Var.y1();
                if (!TextUtils.isEmpty(y1)) {
                    boolean z = false;
                    Iterator<a2> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (y1.equals(it.next().y1())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        linkedList.add(a2Var);
                    }
                }
            }
        }
        return linkedList;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public boolean M() {
        return this.f13958h;
    }

    public boolean N() {
        if (this.j) {
            AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
            alaFrsStoryLiveGatherRequestMessage.setForumId(this.f13955e);
            alaFrsStoryLiveGatherRequestMessage.setPn(this.f13956f + 1);
            alaFrsStoryLiveGatherRequestMessage.setPs(this.f13957g);
            alaFrsStoryLiveGatherRequestMessage.setSortType(this.f13959i);
            alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.q);
            alaFrsStoryLiveGatherRequestMessage.setHttpParams();
            sendMessage(alaFrsStoryLiveGatherRequestMessage);
            return true;
        }
        return false;
    }

    public void O() {
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.f13955e);
        alaFrsStoryLiveGatherRequestMessage.setPn(1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.f13957g);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.f13959i);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.q);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public void P(b bVar) {
        this.r = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void setForumId(String str) {
        this.f13955e = str;
    }

    public void setSortType(int i2) {
        this.f13959i = i2;
    }
}
