package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRespMessage;
import d.a.c.a.f;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.j0.t.e.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaFrsLiveModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;

    /* renamed from: e  reason: collision with root package name */
    public String f14724e;

    /* renamed from: f  reason: collision with root package name */
    public int f14725f;

    /* renamed from: g  reason: collision with root package name */
    public int f14726g;

    /* renamed from: h  reason: collision with root package name */
    public String f14727h;

    /* renamed from: i  reason: collision with root package name */
    public int f14728i;
    public int j;
    public boolean k;
    public int l;
    public List<n> m;
    public boolean n;
    public b o;
    public HttpMessageListener p;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGameFrsLiveThreadsRespMessage)) {
                AlaGameFrsLiveThreadsRespMessage alaGameFrsLiveThreadsRespMessage = (AlaGameFrsLiveThreadsRespMessage) httpResponsedMessage;
                if (httpResponsedMessage.getOrginalMessage() instanceof AlaGameFrsLiveThreadsRequestMessage) {
                    AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = (AlaGameFrsLiveThreadsRequestMessage) httpResponsedMessage.getOrginalMessage();
                    if (httpResponsedMessage.hasError()) {
                        if (AlaFrsLiveModel.this.o != null) {
                            AlaFrsLiveModel.this.o.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    List<n> liveList = alaGameFrsLiveThreadsRespMessage.getLiveList();
                    if (AlaFrsLiveModel.this.m == null) {
                        AlaFrsLiveModel.this.m = new ArrayList();
                    }
                    if (AlaFrsLiveModel.this.f14725f != 1 || ListUtils.getCount(liveList) != 0 || AlaFrsLiveModel.this.j != 2) {
                        AlaFrsLiveModel.this.n = false;
                        AlaFrsLiveModel.this.k = alaGameFrsLiveThreadsRespMessage.hasMore();
                        AlaFrsLiveModel.this.f14725f = alaGameFrsLiveThreadsRequestMessage.getPn();
                        AlaFrsLiveModel.this.l = alaGameFrsLiveThreadsRespMessage.getLiveCount();
                        if (AlaFrsLiveModel.this.f14725f == 1 || ListUtils.getCount(AlaFrsLiveModel.this.m) == 0) {
                            if (liveList != null) {
                                AlaFrsLiveModel.this.m.clear();
                                AlaFrsLiveModel.this.m.addAll(liveList);
                            }
                        } else if (ListUtils.getCount(liveList) > 0) {
                            AlaFrsLiveModel alaFrsLiveModel = AlaFrsLiveModel.this;
                            alaFrsLiveModel.m = alaFrsLiveModel.H(alaFrsLiveModel.m, liveList);
                        }
                    } else {
                        List<n> recommandList = alaGameFrsLiveThreadsRespMessage.getRecommandList();
                        AlaFrsLiveModel.this.k = false;
                        AlaFrsLiveModel.this.f14725f = alaGameFrsLiveThreadsRequestMessage.getPn();
                        AlaFrsLiveModel.this.l = 0;
                        if (recommandList != null) {
                            AlaFrsLiveModel.this.m.clear();
                            AlaFrsLiveModel.this.m.addAll(recommandList);
                        }
                        AlaFrsLiveModel.this.n = true;
                    }
                    if (AlaFrsLiveModel.this.o != null) {
                        AlaFrsLiveModel.this.o.b(AlaFrsLiveModel.this.k);
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

    public AlaFrsLiveModel(f fVar) {
        super(fVar);
        this.f14725f = 1;
        this.f14726g = 30;
        this.f14728i = 1;
        this.j = 1;
        this.n = false;
        a aVar = new a(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME, true);
        this.p = aVar;
        registerListener(aVar);
    }

    public int D() {
        return this.l;
    }

    public int E() {
        return this.f14728i;
    }

    public boolean F() {
        return this.k;
    }

    public boolean G() {
        return this.n;
    }

    public final List<n> H(List<n> list, List<n> list2) {
        a2 a2Var;
        a2 a2Var2;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (n nVar : list2) {
            if (nVar != null && (nVar instanceof c) && (a2Var = ((c) nVar).f60859e) != null && (a2Var.s1() == 49 || a2Var.s1() == 69)) {
                String w1 = a2Var.w1();
                if (!TextUtils.isEmpty(w1)) {
                    boolean z = false;
                    Iterator<n> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        n next = it.next();
                        if (next != null && (next instanceof c) && (a2Var2 = ((c) next).f60859e) != null && w1.equals(a2Var2.w1())) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        linkedList.add(nVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public boolean I() {
        if (this.k) {
            AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = new AlaGameFrsLiveThreadsRequestMessage();
            alaGameFrsLiveThreadsRequestMessage.setForumId(this.f14724e);
            alaGameFrsLiveThreadsRequestMessage.setPn(this.f14725f + 1);
            alaGameFrsLiveThreadsRequestMessage.setPs(this.f14726g);
            alaGameFrsLiveThreadsRequestMessage.setForumGameLabel(this.f14727h);
            alaGameFrsLiveThreadsRequestMessage.setSortType(this.f14728i);
            alaGameFrsLiveThreadsRequestMessage.setHttpParams();
            sendMessage(alaGameFrsLiveThreadsRequestMessage);
            return true;
        }
        return false;
    }

    public void J() {
        AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = new AlaGameFrsLiveThreadsRequestMessage();
        alaGameFrsLiveThreadsRequestMessage.setForumId(this.f14724e);
        alaGameFrsLiveThreadsRequestMessage.setPn(1);
        alaGameFrsLiveThreadsRequestMessage.setPs(this.f14726g);
        alaGameFrsLiveThreadsRequestMessage.setForumGameLabel(this.f14727h);
        alaGameFrsLiveThreadsRequestMessage.setSortType(this.f14728i);
        alaGameFrsLiveThreadsRequestMessage.setHttpParams();
        sendMessage(alaGameFrsLiveThreadsRequestMessage);
    }

    public void K(int i2) {
        this.j = i2;
    }

    public void L(b bVar) {
        this.o = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void clearData() {
        List<n> list = this.m;
        if (list != null) {
            list.clear();
        }
    }

    public List<n> getData() {
        return this.m;
    }

    public void setForumGameLabel(String str) {
        this.f14727h = str;
    }

    public void setForumId(String str) {
        this.f14724e = str;
    }

    public void setSortType(int i2) {
        this.f14728i = i2;
    }
}
