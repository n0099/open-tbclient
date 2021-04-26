package com.baidu.tieba.ala.alasquare.live.model;

import android.util.Pair;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveHttpResponseMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveRequestMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveSocketResponseMessage;
import d.a.c.a.f;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.j0.t.d.a.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
/* loaded from: classes4.dex */
public class AlaSquareLiveModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public f f14458e;

    /* renamed from: f  reason: collision with root package name */
    public b f14459f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<FunctionListInfo> f14460g;

    /* renamed from: h  reason: collision with root package name */
    public HeadLiveInfo f14461h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.j0.t.d.b.b.a> f14462i;
    public List<n> j;
    public List<n> k;
    public boolean m;
    public boolean p;
    public int q;
    public List<Long> r;
    public d.a.c.c.g.a s;
    public int l = 1;
    public boolean n = false;
    public boolean o = false;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            LinkedList<d.a.j0.t.d.b.b.a> linkedList;
            boolean z;
            AlaSquareLiveModel.this.p = false;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                if (AlaSquareLiveModel.this.o) {
                    AlaSquareLiveModel.this.o = false;
                }
                if (AlaSquareLiveModel.this.f14459f != null) {
                    AlaSquareLiveModel.this.f14459f.a(responsedMessage.getError(), responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof AlaSquareLiveSocketResponseMessage) {
                AlaSquareLiveSocketResponseMessage alaSquareLiveSocketResponseMessage = (AlaSquareLiveSocketResponseMessage) responsedMessage;
                alaSquareLiveSocketResponseMessage.setPn(AlaSquareLiveModel.this.l);
                z = alaSquareLiveSocketResponseMessage.hasMore();
                if (AlaSquareLiveModel.this.l == 1) {
                    AlaSquareLiveModel.this.f14460g.clear();
                    AlaSquareLiveModel.this.f14460g.addAll(alaSquareLiveSocketResponseMessage.getFunctionList());
                }
                linkedList = alaSquareLiveSocketResponseMessage.getCategoryList();
                AlaSquareLiveModel.this.f14461h = alaSquareLiveSocketResponseMessage.getHeadLiveInfo();
                AlaSquareLiveModel.this.q = alaSquareLiveSocketResponseMessage.getIsSmallFollow();
            } else if (responsedMessage instanceof AlaSquareLiveHttpResponseMessage) {
                AlaSquareLiveHttpResponseMessage alaSquareLiveHttpResponseMessage = (AlaSquareLiveHttpResponseMessage) responsedMessage;
                alaSquareLiveHttpResponseMessage.setPn(AlaSquareLiveModel.this.l);
                z = alaSquareLiveHttpResponseMessage.hasMore();
                if (AlaSquareLiveModel.this.l == 1) {
                    AlaSquareLiveModel.this.f14460g.clear();
                    AlaSquareLiveModel.this.f14460g.addAll(alaSquareLiveHttpResponseMessage.getFunctionList());
                }
                linkedList = alaSquareLiveHttpResponseMessage.getCategoryList();
                AlaSquareLiveModel.this.f14461h = alaSquareLiveHttpResponseMessage.getHeadLiveInfo();
                AlaSquareLiveModel.this.q = alaSquareLiveHttpResponseMessage.getIsSmallFollow();
            } else {
                linkedList = null;
                z = false;
            }
            boolean z2 = AlaSquareLiveModel.this.o;
            if (AlaSquareLiveModel.this.o) {
                AlaSquareLiveModel.this.o = false;
                d.a.j0.t.d.a.b.c(AlaSquareLiveModel.this.f14462i, linkedList, AlaSquareLiveModel.this.r);
            } else {
                AlaSquareLiveModel alaSquareLiveModel = AlaSquareLiveModel.this;
                alaSquareLiveModel.f14462i = d.a.j0.t.d.a.b.g(alaSquareLiveModel.f14462i, linkedList, AlaSquareLiveModel.this.m);
                AlaSquareLiveModel.this.n = z;
            }
            AlaSquareLiveModel.this.F();
            if (AlaSquareLiveModel.this.f14459f != null) {
                AlaSquareLiveModel.this.f14459f.b(z, false, z2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str);

        void b(boolean z, boolean z2, boolean z3);
    }

    public AlaSquareLiveModel(f fVar, BdUniqueId bdUniqueId, b bVar) {
        a aVar = new a(AlaCmdConfigHttp.CMD_SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE);
        this.s = aVar;
        this.f14458e = fVar;
        this.unique_id = bdUniqueId;
        this.f14459f = bVar;
        registerListener(aVar);
        R();
        this.f14462i = new ArrayList();
        this.f14460g = new LinkedList<>();
    }

    public static void R() {
        d.a.j0.d3.d0.a.h(AlaCmdConfigSocket.CMD_SQUARE_LIVE, AlaSquareLiveSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_SQUARE_LIVE, d.a.j0.d3.d0.a.a(AlaConfig.SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaSquareLiveHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void F() {
        Pair<List<n>, List<n>> d2 = d.a.j0.t.d.a.b.d(this.f14458e.getString(R.string.square_live_category_title_hotest), this.f14462i);
        if (d2 != null) {
            this.j = (List) d2.first;
            this.k = (List) d2.second;
        }
    }

    public List<Long> G() {
        c cVar;
        a2 a2Var;
        if (ListUtils.isEmpty(this.k)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.k) {
            if ((nVar instanceof c) && (a2Var = (cVar = (c) nVar).f60405h) != null && a2Var.q1() != null) {
                linkedList.add(Long.valueOf(cVar.f60405h.q1().live_id));
            }
        }
        return linkedList;
    }

    public List<n> H() {
        return this.j;
    }

    public LinkedList<FunctionListInfo> I() {
        return this.f14460g;
    }

    public HeadLiveInfo J() {
        return this.f14461h;
    }

    public int K() {
        return this.q;
    }

    public boolean L() {
        return this.n;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(List<Long> list) {
        if (ListUtils.isEmpty(list) || this.o) {
            return;
        }
        this.r = list;
        Q();
    }

    public boolean N() {
        return this.p;
    }

    public void O() {
        if (L()) {
            this.o = false;
            this.m = true;
            int i2 = this.l + 1;
            this.l = i2;
            sendMessage(new AlaSquareLiveRequestMessage(i2, false));
        }
    }

    public void P() {
        List<d.a.j0.t.d.b.b.a> list = this.f14462i;
        if (list != null) {
            list.clear();
        }
        List<n> list2 = this.j;
        if (list2 != null) {
            list2.clear();
        }
        List<n> list3 = this.k;
        if (list3 != null) {
            list3.clear();
        }
        this.p = true;
        this.o = false;
        this.m = false;
        this.l = 1;
        sendMessage(new AlaSquareLiveRequestMessage(1, false));
    }

    public void Q() {
        this.o = true;
        sendMessage(new AlaSquareLiveRequestMessage(1, false));
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        LinkedList<FunctionListInfo> linkedList = this.f14460g;
        if (linkedList != null) {
            linkedList.clear();
            this.f14460g = null;
        }
        if (this.f14461h != null) {
            this.f14461h = null;
        }
        List<d.a.j0.t.d.b.b.a> list = this.f14462i;
        if (list != null) {
            list.clear();
            this.f14462i = null;
        }
        List<n> list2 = this.j;
        if (list2 != null) {
            list2.clear();
            this.j = null;
        }
        List<n> list3 = this.k;
        if (list3 != null) {
            list3.clear();
            this.k = null;
        }
    }
}
