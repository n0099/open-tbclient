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
import d.b.b.a.f;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
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
    public String f14988e;

    /* renamed from: f  reason: collision with root package name */
    public int f14989f;

    /* renamed from: g  reason: collision with root package name */
    public int f14990g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14991h;
    public int i;
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
        public a(int i) {
            super(i);
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
                    if (AlaFrsStoryLiveGatherModel.this.f14989f != 1 || ListUtils.getCount(liveList) > 10) {
                        AlaFrsStoryLiveGatherModel.this.q = 0;
                        AlaFrsStoryLiveGatherModel.this.j = alaFrsStoryLiveGatherRespMessage.hasMore();
                        AlaFrsStoryLiveGatherModel.this.f14989f = alaFrsStoryLiveGatherRequestMessage.getPn();
                        AlaFrsStoryLiveGatherModel.this.k = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                        if (AlaFrsStoryLiveGatherModel.this.f14989f == 1 || ListUtils.getCount(AlaFrsStoryLiveGatherModel.this.l) == 0) {
                            AlaFrsStoryLiveGatherModel.this.l = liveList;
                        } else if (ListUtils.getCount(liveList) > 0) {
                            AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel = AlaFrsStoryLiveGatherModel.this;
                            alaFrsStoryLiveGatherModel.l = alaFrsStoryLiveGatherModel.L(alaFrsStoryLiveGatherModel.l, liveList);
                        }
                    } else {
                        AlaFrsStoryLiveGatherModel.this.j = false;
                        AlaFrsStoryLiveGatherModel.this.f14989f = alaFrsStoryLiveGatherRequestMessage.getPn();
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
        void a(int i, String str);

        void b(boolean z);
    }

    public AlaFrsStoryLiveGatherModel(f fVar) {
        super(fVar);
        this.f14989f = 1;
        this.f14990g = 30;
        this.i = 1;
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
        for (int i = 0; i < size; i += 2) {
            d.b.i0.t.h.b.a aVar = new d.b.i0.t.h.b.a();
            a2 a2Var = list.get(i);
            aVar.f60772e = a2Var;
            if (a2Var.T() != null) {
                TiebaStatic.log(new StatisticItem("c12549").param("obj_param1", aVar.f60772e.T().getUserId()));
            }
            int i2 = i + 1;
            if (i2 < size) {
                a2 a2Var2 = list.get(i2);
                aVar.f60773f = a2Var2;
                if (a2Var2.T() != null) {
                    TiebaStatic.log(new StatisticItem("c12549").param("obj_param1", aVar.f60773f.T().getUserId()));
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
        return this.i;
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
            this.f14991h = true;
        } else {
            this.p.add(new d.b.i0.t.e.b.a());
            this.f14991h = false;
        }
        if (ListUtils.getCount(this.o) <= 0 || this.j) {
            return;
        }
        this.p.add(new d.b.i0.t.e.b.b());
        for (int i = 0; i < 3 && i < ListUtils.getCount(this.o); i++) {
            if (this.o.get(i) != null) {
                this.p.add(this.o.get(i));
            }
        }
    }

    public final List<a2> L(List<a2> list, List<a2> list2) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (a2 a2Var : list2) {
            if (a2Var != null && a2Var.s1() == 49) {
                String w1 = a2Var.w1();
                if (!TextUtils.isEmpty(w1)) {
                    boolean z = false;
                    Iterator<a2> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (w1.equals(it.next().w1())) {
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
        return this.f14991h;
    }

    public boolean N() {
        if (this.j) {
            AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
            alaFrsStoryLiveGatherRequestMessage.setForumId(this.f14988e);
            alaFrsStoryLiveGatherRequestMessage.setPn(this.f14989f + 1);
            alaFrsStoryLiveGatherRequestMessage.setPs(this.f14990g);
            alaFrsStoryLiveGatherRequestMessage.setSortType(this.i);
            alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.q);
            alaFrsStoryLiveGatherRequestMessage.setHttpParams();
            sendMessage(alaFrsStoryLiveGatherRequestMessage);
            return true;
        }
        return false;
    }

    public void O() {
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.f14988e);
        alaFrsStoryLiveGatherRequestMessage.setPn(1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.f14990g);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.i);
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
        this.f14988e = str;
    }

    public void setSortType(int i) {
        this.i = i;
    }
}
