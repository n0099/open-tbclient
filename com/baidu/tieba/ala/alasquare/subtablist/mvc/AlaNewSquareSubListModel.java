package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListRequestMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import d.b.c.a.f;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.j0.t.d.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaNewSquareSubListModel extends BdBaseModel {
    public static final int FIRST_PN = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f14604e;

    /* renamed from: f  reason: collision with root package name */
    public int f14605f;

    /* renamed from: g  reason: collision with root package name */
    public String f14606g;

    /* renamed from: h  reason: collision with root package name */
    public String f14607h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public boolean m;
    public int n;
    public List<String> o;
    public List<a2> p;
    public List<n> q;
    public boolean r;
    public b s;
    public BdUniqueId t;
    public HttpMessageListener u;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNewSquareSubListResponseMessage)) {
                AlaNewSquareSubListResponseMessage alaNewSquareSubListResponseMessage = (AlaNewSquareSubListResponseMessage) httpResponsedMessage;
                if (httpResponsedMessage.getOrginalMessage() instanceof AlaNewSquareSubListRequestMessage) {
                    AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = (AlaNewSquareSubListRequestMessage) httpResponsedMessage.getOrginalMessage();
                    if (httpResponsedMessage.hasError()) {
                        if (AlaNewSquareSubListModel.this.s != null) {
                            AlaNewSquareSubListModel.this.s.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    List<a2> liveList = alaNewSquareSubListResponseMessage.getLiveList();
                    AlaNewSquareSubListModel.this.m = alaNewSquareSubListResponseMessage.hasMore();
                    AlaNewSquareSubListModel.this.f14604e = alaNewSquareSubListRequestMessage.getPn();
                    if (AlaNewSquareSubListModel.this.f14604e == 0 || ListUtils.getCount(AlaNewSquareSubListModel.this.p) == 0) {
                        AlaNewSquareSubListModel.this.p.clear();
                        AlaNewSquareSubListModel.this.q.clear();
                        AlaNewSquareSubListModel.this.p = liveList;
                        AlaNewSquareSubListModel.this.n = alaNewSquareSubListResponseMessage.getLiveCount();
                        AlaNewSquareSubListModel.this.o = alaNewSquareSubListResponseMessage.getSortTypeList();
                    } else if (ListUtils.getCount(liveList) > 0) {
                        AlaNewSquareSubListModel.this.K(liveList);
                    }
                    AlaNewSquareSubListModel.x(AlaNewSquareSubListModel.this);
                    AlaNewSquareSubListModel alaNewSquareSubListModel = AlaNewSquareSubListModel.this;
                    alaNewSquareSubListModel.E(alaNewSquareSubListModel.p, AlaNewSquareSubListModel.this.m);
                    if (AlaNewSquareSubListModel.this.s != null) {
                        AlaNewSquareSubListModel.this.s.b(AlaNewSquareSubListModel.this.m);
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

    public AlaNewSquareSubListModel(f fVar) {
        super(fVar);
        this.f14604e = 0;
        this.f14605f = 20;
        this.j = "";
        this.k = "";
        this.l = false;
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.t = BdUniqueId.gen();
        this.u = new a(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
        setUniqueId(this.t);
        this.u.setTag(this.t);
        this.u.setSelfListener(true);
        registerListener(this.u);
    }

    public static /* synthetic */ int x(AlaNewSquareSubListModel alaNewSquareSubListModel) {
        int i = alaNewSquareSubListModel.f14604e;
        alaNewSquareSubListModel.f14604e = i + 1;
        return i;
    }

    public void E(List<a2> list, boolean z) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.q = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            if (this.r) {
                d.b.j0.t.d.g.b.a aVar = new d.b.j0.t.d.g.b.a();
                c cVar = new c();
                cVar.i = this.l;
                cVar.f62225f = this.i;
                cVar.f62226g = this.f14607h;
                cVar.f62227h = list.get(i);
                aVar.f62590e = cVar;
                int i2 = i + 1;
                if (i2 < size) {
                    c cVar2 = new c();
                    cVar2.i = this.l;
                    cVar2.f62225f = this.i;
                    cVar2.f62226g = this.f14607h;
                    cVar2.f62227h = list.get(i2);
                    aVar.f62591f = cVar2;
                }
                this.q.add(aVar);
            } else {
                d.b.j0.t.d.g.b.b bVar = new d.b.j0.t.d.g.b.b();
                c cVar3 = new c();
                cVar3.i = this.l;
                cVar3.f62225f = this.i;
                cVar3.f62226g = this.f14607h;
                cVar3.f62227h = list.get(i);
                bVar.f62593e = cVar3;
                int i3 = i + 1;
                if (i3 < size) {
                    c cVar4 = new c();
                    cVar4.i = this.l;
                    cVar4.f62225f = this.i;
                    cVar4.f62226g = this.f14607h;
                    cVar4.f62227h = list.get(i3);
                    bVar.f62594f = cVar4;
                }
                this.q.add(bVar);
            }
        }
    }

    public List<n> F() {
        return this.q;
    }

    public int G() {
        return this.n;
    }

    public List<a2> H() {
        return this.p;
    }

    public List<String> I() {
        return this.o;
    }

    public boolean J() {
        return this.m;
    }

    public final void K(List<a2> list) {
        for (a2 a2Var : list) {
            if (a2Var != null && a2Var.s1() == 49) {
                String w1 = a2Var.w1();
                if (!TextUtils.isEmpty(w1)) {
                    boolean z = false;
                    Iterator<a2> it = this.p.iterator();
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
                        this.p.add(a2Var);
                    }
                }
            }
        }
    }

    public boolean L() {
        if (this.m) {
            AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
            alaNewSquareSubListRequestMessage.setPn(this.f14604e);
            alaNewSquareSubListRequestMessage.setPs(this.f14605f);
            alaNewSquareSubListRequestMessage.setSortType(this.f14606g);
            alaNewSquareSubListRequestMessage.setEntryName(this.i);
            alaNewSquareSubListRequestMessage.setLableName(this.f14607h);
            alaNewSquareSubListRequestMessage.setLat(this.k);
            alaNewSquareSubListRequestMessage.setLng(this.j);
            alaNewSquareSubListRequestMessage.setHttpParams();
            sendMessage(alaNewSquareSubListRequestMessage);
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M() {
        this.f14604e = 0;
        AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
        alaNewSquareSubListRequestMessage.setPn(this.f14604e);
        alaNewSquareSubListRequestMessage.setPs(this.f14605f);
        alaNewSquareSubListRequestMessage.setSortType(this.f14606g);
        alaNewSquareSubListRequestMessage.setEntryName(this.i);
        alaNewSquareSubListRequestMessage.setLableName(this.f14607h);
        alaNewSquareSubListRequestMessage.setLat(this.k);
        alaNewSquareSubListRequestMessage.setLng(this.j);
        alaNewSquareSubListRequestMessage.setHttpParams();
        sendMessage(alaNewSquareSubListRequestMessage);
    }

    public void N(b bVar) {
        this.s = bVar;
    }

    public void O(boolean z) {
        this.r = z;
    }

    public void P(boolean z) {
        this.l = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public int getPn() {
        return this.f14604e;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.t);
    }

    public void setEntryName(String str) {
        this.i = str;
    }

    public void setLabelName(String str) {
        this.f14607h = str;
    }

    public void setLat(String str) {
        this.k = str;
    }

    public void setLng(String str) {
        this.j = str;
    }

    public void setSortType(String str) {
        this.f14606g = str;
    }
}
