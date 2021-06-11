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
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.v.d.a.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
/* loaded from: classes4.dex */
public class AlaSquareLiveModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public f f13741e;

    /* renamed from: f  reason: collision with root package name */
    public b f13742f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<FunctionListInfo> f13743g;

    /* renamed from: h  reason: collision with root package name */
    public HeadLiveInfo f13744h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.n0.v.d.b.b.a> f13745i;
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
            LinkedList<d.a.n0.v.d.b.b.a> linkedList;
            boolean z;
            AlaSquareLiveModel.this.p = false;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                if (AlaSquareLiveModel.this.o) {
                    AlaSquareLiveModel.this.o = false;
                }
                if (AlaSquareLiveModel.this.f13742f != null) {
                    AlaSquareLiveModel.this.f13742f.a(responsedMessage.getError(), responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof AlaSquareLiveSocketResponseMessage) {
                AlaSquareLiveSocketResponseMessage alaSquareLiveSocketResponseMessage = (AlaSquareLiveSocketResponseMessage) responsedMessage;
                alaSquareLiveSocketResponseMessage.setPn(AlaSquareLiveModel.this.l);
                z = alaSquareLiveSocketResponseMessage.hasMore();
                if (AlaSquareLiveModel.this.l == 1) {
                    AlaSquareLiveModel.this.f13743g.clear();
                    AlaSquareLiveModel.this.f13743g.addAll(alaSquareLiveSocketResponseMessage.getFunctionList());
                }
                linkedList = alaSquareLiveSocketResponseMessage.getCategoryList();
                AlaSquareLiveModel.this.f13744h = alaSquareLiveSocketResponseMessage.getHeadLiveInfo();
                AlaSquareLiveModel.this.q = alaSquareLiveSocketResponseMessage.getIsSmallFollow();
            } else if (responsedMessage instanceof AlaSquareLiveHttpResponseMessage) {
                AlaSquareLiveHttpResponseMessage alaSquareLiveHttpResponseMessage = (AlaSquareLiveHttpResponseMessage) responsedMessage;
                alaSquareLiveHttpResponseMessage.setPn(AlaSquareLiveModel.this.l);
                z = alaSquareLiveHttpResponseMessage.hasMore();
                if (AlaSquareLiveModel.this.l == 1) {
                    AlaSquareLiveModel.this.f13743g.clear();
                    AlaSquareLiveModel.this.f13743g.addAll(alaSquareLiveHttpResponseMessage.getFunctionList());
                }
                linkedList = alaSquareLiveHttpResponseMessage.getCategoryList();
                AlaSquareLiveModel.this.f13744h = alaSquareLiveHttpResponseMessage.getHeadLiveInfo();
                AlaSquareLiveModel.this.q = alaSquareLiveHttpResponseMessage.getIsSmallFollow();
            } else {
                linkedList = null;
                z = false;
            }
            boolean z2 = AlaSquareLiveModel.this.o;
            if (AlaSquareLiveModel.this.o) {
                AlaSquareLiveModel.this.o = false;
                d.a.n0.v.d.a.b.c(AlaSquareLiveModel.this.f13745i, linkedList, AlaSquareLiveModel.this.r);
            } else {
                AlaSquareLiveModel alaSquareLiveModel = AlaSquareLiveModel.this;
                alaSquareLiveModel.f13745i = d.a.n0.v.d.a.b.g(alaSquareLiveModel.f13745i, linkedList, AlaSquareLiveModel.this.m);
                AlaSquareLiveModel.this.n = z;
            }
            AlaSquareLiveModel.this.J();
            if (AlaSquareLiveModel.this.f13742f != null) {
                AlaSquareLiveModel.this.f13742f.b(z, false, z2);
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
        this.f13741e = fVar;
        this.unique_id = bdUniqueId;
        this.f13742f = bVar;
        registerListener(aVar);
        T();
        this.f13745i = new ArrayList();
        this.f13743g = new LinkedList<>();
    }

    public static void T() {
        d.a.n0.e3.d0.a.h(AlaCmdConfigSocket.CMD_SQUARE_LIVE, AlaSquareLiveSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_SQUARE_LIVE, d.a.n0.e3.d0.a.a(AlaConfig.SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaSquareLiveHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void J() {
        Pair<List<n>, List<n>> d2 = d.a.n0.v.d.a.b.d(this.f13741e.getString(R.string.square_live_category_title_hotest), this.f13745i);
        if (d2 != null) {
            this.j = (List) d2.first;
            this.k = (List) d2.second;
        }
    }

    public List<Long> K() {
        c cVar;
        a2 a2Var;
        if (ListUtils.isEmpty(this.k)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.k) {
            if ((nVar instanceof c) && (a2Var = (cVar = (c) nVar).f65130h) != null && a2Var.s1() != null) {
                linkedList.add(Long.valueOf(cVar.f65130h.s1().live_id));
            }
        }
        return linkedList;
    }

    public List<n> L() {
        return this.j;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public LinkedList<FunctionListInfo> M() {
        return this.f13743g;
    }

    public HeadLiveInfo N() {
        return this.f13744h;
    }

    public int O() {
        return this.q;
    }

    public boolean P() {
        return this.n;
    }

    public void Q(List<Long> list) {
        if (ListUtils.isEmpty(list) || this.o) {
            return;
        }
        this.r = list;
        S();
    }

    public boolean R() {
        return this.p;
    }

    public void S() {
        this.o = true;
        sendMessage(new AlaSquareLiveRequestMessage(1, false));
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void loadMore() {
        if (P()) {
            this.o = false;
            this.m = true;
            int i2 = this.l + 1;
            this.l = i2;
            sendMessage(new AlaSquareLiveRequestMessage(i2, false));
        }
    }

    public void onDestroy() {
        LinkedList<FunctionListInfo> linkedList = this.f13743g;
        if (linkedList != null) {
            linkedList.clear();
            this.f13743g = null;
        }
        if (this.f13744h != null) {
            this.f13744h = null;
        }
        List<d.a.n0.v.d.b.b.a> list = this.f13745i;
        if (list != null) {
            list.clear();
            this.f13745i = null;
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

    public void refresh() {
        List<d.a.n0.v.d.b.b.a> list = this.f13745i;
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
}
