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
import d.a.c.a.f;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.v.d.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaNewSquareSubListModel extends BdBaseModel {
    public static final int FIRST_PN = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f13895e;

    /* renamed from: f  reason: collision with root package name */
    public int f13896f;

    /* renamed from: g  reason: collision with root package name */
    public String f13897g;

    /* renamed from: h  reason: collision with root package name */
    public String f13898h;

    /* renamed from: i  reason: collision with root package name */
    public String f13899i;
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
        public a(int i2) {
            super(i2);
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
                    AlaNewSquareSubListModel.this.f13895e = alaNewSquareSubListRequestMessage.getPn();
                    if (AlaNewSquareSubListModel.this.f13895e == 0 || ListUtils.getCount(AlaNewSquareSubListModel.this.p) == 0) {
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
        void a(int i2, String str);

        void b(boolean z);
    }

    public AlaNewSquareSubListModel(f fVar) {
        super(fVar);
        this.f13895e = 0;
        this.f13896f = 20;
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
        int i2 = alaNewSquareSubListModel.f13895e;
        alaNewSquareSubListModel.f13895e = i2 + 1;
        return i2;
    }

    public void E(List<a2> list, boolean z) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.q = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (this.r) {
                d.a.n0.v.d.g.b.a aVar = new d.a.n0.v.d.g.b.a();
                c cVar = new c();
                cVar.f61418i = this.l;
                cVar.f61415f = this.f13899i;
                cVar.f61416g = this.f13898h;
                cVar.f61417h = list.get(i2);
                aVar.f61784e = cVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    c cVar2 = new c();
                    cVar2.f61418i = this.l;
                    cVar2.f61415f = this.f13899i;
                    cVar2.f61416g = this.f13898h;
                    cVar2.f61417h = list.get(i3);
                    aVar.f61785f = cVar2;
                }
                this.q.add(aVar);
            } else {
                d.a.n0.v.d.g.b.b bVar = new d.a.n0.v.d.g.b.b();
                c cVar3 = new c();
                cVar3.f61418i = this.l;
                cVar3.f61415f = this.f13899i;
                cVar3.f61416g = this.f13898h;
                cVar3.f61417h = list.get(i2);
                bVar.f61787e = cVar3;
                int i4 = i2 + 1;
                if (i4 < size) {
                    c cVar4 = new c();
                    cVar4.f61418i = this.l;
                    cVar4.f61415f = this.f13899i;
                    cVar4.f61416g = this.f13898h;
                    cVar4.f61417h = list.get(i4);
                    bVar.f61788f = cVar4;
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
            if (a2Var != null && (a2Var.u1() == 49 || a2Var.u1() == 69)) {
                String y1 = a2Var.y1();
                if (!TextUtils.isEmpty(y1)) {
                    boolean z = false;
                    Iterator<a2> it = this.p.iterator();
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
                        this.p.add(a2Var);
                    }
                }
            }
        }
    }

    public boolean L() {
        if (this.m) {
            AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
            alaNewSquareSubListRequestMessage.setPn(this.f13895e);
            alaNewSquareSubListRequestMessage.setPs(this.f13896f);
            alaNewSquareSubListRequestMessage.setSortType(this.f13897g);
            alaNewSquareSubListRequestMessage.setEntryName(this.f13899i);
            alaNewSquareSubListRequestMessage.setLableName(this.f13898h);
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
        this.f13895e = 0;
        AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
        alaNewSquareSubListRequestMessage.setPn(this.f13895e);
        alaNewSquareSubListRequestMessage.setPs(this.f13896f);
        alaNewSquareSubListRequestMessage.setSortType(this.f13897g);
        alaNewSquareSubListRequestMessage.setEntryName(this.f13899i);
        alaNewSquareSubListRequestMessage.setLableName(this.f13898h);
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
        return this.f13895e;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.t);
    }

    public void setEntryName(String str) {
        this.f13899i = str;
    }

    public void setLabelName(String str) {
        this.f13898h = str;
    }

    public void setLat(String str) {
        this.k = str;
    }

    public void setLng(String str) {
        this.j = str;
    }

    public void setSortType(String str) {
        this.f13897g = str;
    }
}
