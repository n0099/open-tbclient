package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListRequestMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import d.a.c.a.f;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.o0.v.d.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaNewSquareSubListModel extends BdBaseModel {
    public static final int FIRST_PN = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f14034e;

    /* renamed from: f  reason: collision with root package name */
    public int f14035f;

    /* renamed from: g  reason: collision with root package name */
    public String f14036g;

    /* renamed from: h  reason: collision with root package name */
    public String f14037h;

    /* renamed from: i  reason: collision with root package name */
    public String f14038i;
    public int j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public int o;
    public List<String> p;
    public List<a2> q;
    public List<n> r;
    public boolean s;
    public b t;
    public BdUniqueId u;
    public long v;
    public int w;
    public HttpMessageListener x;

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
                        if (AlaNewSquareSubListModel.this.t != null) {
                            AlaNewSquareSubListModel.this.t.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    List<a2> liveList = alaNewSquareSubListResponseMessage.getLiveList();
                    AlaNewSquareSubListModel.this.n = alaNewSquareSubListResponseMessage.hasMore();
                    AlaNewSquareSubListModel.this.f14034e = alaNewSquareSubListRequestMessage.getPn();
                    if (AlaNewSquareSubListModel.this.f14034e != 0 && ListUtils.getCount(AlaNewSquareSubListModel.this.q) != 0) {
                        if (ListUtils.getCount(liveList) > 0) {
                            AlaNewSquareSubListModel.this.O(liveList);
                        }
                    } else {
                        SpecialLiveFragment.o1(alaNewSquareSubListRequestMessage.tabId);
                        AlaNewSquareSubListModel.this.q.clear();
                        AlaNewSquareSubListModel.this.r.clear();
                        AlaNewSquareSubListModel.this.q = liveList;
                        AlaNewSquareSubListModel.this.o = alaNewSquareSubListResponseMessage.getLiveCount();
                        AlaNewSquareSubListModel.this.p = alaNewSquareSubListResponseMessage.getSortTypeList();
                    }
                    AlaNewSquareSubListModel.B(AlaNewSquareSubListModel.this);
                    AlaNewSquareSubListModel alaNewSquareSubListModel = AlaNewSquareSubListModel.this;
                    alaNewSquareSubListModel.I(alaNewSquareSubListModel.q, AlaNewSquareSubListModel.this.n);
                    if (AlaNewSquareSubListModel.this.t != null) {
                        AlaNewSquareSubListModel.this.t.b(AlaNewSquareSubListModel.this.n);
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
        this.f14034e = 0;
        this.f14035f = 20;
        this.j = 0;
        this.k = "";
        this.l = "";
        this.m = false;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.u = BdUniqueId.gen();
        this.w = 60;
        this.x = new a(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
        setUniqueId(this.u);
        this.x.setTag(this.u);
        this.x.setSelfListener(true);
        registerListener(this.x);
    }

    public static /* synthetic */ int B(AlaNewSquareSubListModel alaNewSquareSubListModel) {
        int i2 = alaNewSquareSubListModel.f14034e;
        alaNewSquareSubListModel.f14034e = i2 + 1;
        return i2;
    }

    public void I(List<a2> list, boolean z) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.r = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (this.s) {
                d.a.o0.v.d.g.b.a aVar = new d.a.o0.v.d.g.b.a();
                c cVar = new c();
                cVar.f65256i = this.m;
                cVar.f65253f = this.f14038i;
                cVar.f65254g = this.f14037h;
                cVar.f65255h = list.get(i2);
                aVar.f65624e = cVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    c cVar2 = new c();
                    cVar2.f65256i = this.m;
                    cVar2.f65253f = this.f14038i;
                    cVar2.f65254g = this.f14037h;
                    cVar2.f65255h = list.get(i3);
                    aVar.f65625f = cVar2;
                }
                this.r.add(aVar);
            } else {
                d.a.o0.v.d.g.b.b bVar = new d.a.o0.v.d.g.b.b();
                c cVar3 = new c();
                cVar3.f65256i = this.m;
                cVar3.f65253f = this.f14038i;
                cVar3.f65254g = this.f14037h;
                cVar3.f65255h = list.get(i2);
                bVar.f65627e = cVar3;
                int i4 = i2 + 1;
                if (i4 < size) {
                    c cVar4 = new c();
                    cVar4.f65256i = this.m;
                    cVar4.f65253f = this.f14038i;
                    cVar4.f65254g = this.f14037h;
                    cVar4.f65255h = list.get(i4);
                    bVar.f65628f = cVar4;
                }
                this.r.add(bVar);
            }
        }
    }

    public List<n> J() {
        return this.r;
    }

    public int K() {
        return this.o;
    }

    public List<a2> L() {
        return this.q;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public List<String> M() {
        return this.p;
    }

    public boolean N() {
        return this.n;
    }

    public final void O(List<a2> list) {
        for (a2 a2Var : list) {
            String z1 = a2Var.z1();
            if (!TextUtils.isEmpty(z1)) {
                boolean z = false;
                Iterator<a2> it = this.q.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (z1.equals(it.next().z1())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    this.q.add(a2Var);
                }
            }
        }
    }

    public boolean P() {
        if (this.n) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.v >= this.w * 30 * 1000) {
                this.v = currentTimeMillis;
            }
            AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
            alaNewSquareSubListRequestMessage.setPn(this.f14034e);
            alaNewSquareSubListRequestMessage.setPs(this.f14035f);
            alaNewSquareSubListRequestMessage.setSortType(this.f14036g);
            alaNewSquareSubListRequestMessage.setEntryName(this.f14038i);
            alaNewSquareSubListRequestMessage.setLableName(this.f14037h);
            alaNewSquareSubListRequestMessage.setLat(this.l);
            alaNewSquareSubListRequestMessage.setLng(this.k);
            int i2 = this.j;
            alaNewSquareSubListRequestMessage.tabId = i2;
            alaNewSquareSubListRequestMessage.sessionId = this.v;
            alaNewSquareSubListRequestMessage.refreshType = 1;
            alaNewSquareSubListRequestMessage.refreshCount = SpecialLiveFragment.A1(i2) - 1;
            alaNewSquareSubListRequestMessage.setHttpParams();
            sendMessage(alaNewSquareSubListRequestMessage);
            return true;
        }
        return false;
    }

    public void Q() {
        this.f14034e = 0;
        this.v = System.currentTimeMillis();
        AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
        alaNewSquareSubListRequestMessage.setPn(this.f14034e);
        alaNewSquareSubListRequestMessage.setPs(this.f14035f);
        alaNewSquareSubListRequestMessage.setSortType(this.f14036g);
        alaNewSquareSubListRequestMessage.setEntryName(this.f14038i);
        alaNewSquareSubListRequestMessage.setLableName(this.f14037h);
        alaNewSquareSubListRequestMessage.setLat(this.l);
        alaNewSquareSubListRequestMessage.setLng(this.k);
        int i2 = this.j;
        alaNewSquareSubListRequestMessage.tabId = i2;
        alaNewSquareSubListRequestMessage.sessionId = this.v;
        alaNewSquareSubListRequestMessage.refreshType = 0;
        alaNewSquareSubListRequestMessage.refreshCount = SpecialLiveFragment.A1(i2);
        alaNewSquareSubListRequestMessage.setHttpParams();
        sendMessage(alaNewSquareSubListRequestMessage);
    }

    public void R(b bVar) {
        this.t = bVar;
    }

    public void S(boolean z) {
        this.s = z;
    }

    public void T(boolean z) {
        this.m = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public int getPn() {
        return this.f14034e;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.u);
    }

    public void setEntryName(String str) {
        this.f14038i = str;
    }

    public void setLabelName(String str) {
        this.f14037h = str;
    }

    public void setLat(String str) {
        this.l = str;
    }

    public void setLng(String str) {
        this.k = str;
    }

    public void setSortType(String str) {
        this.f14036g = str;
    }

    public void setTabId(int i2) {
        this.j = i2;
    }
}
