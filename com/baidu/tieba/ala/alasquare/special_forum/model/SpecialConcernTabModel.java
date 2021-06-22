package com.baidu.tieba.ala.alasquare.special_forum.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialConcernResponse;
import d.a.c.k.e.n;
import d.a.o0.v.d.f.c.d;
import d.a.o0.v.d.f.c.e;
import d.a.o0.v.d.f.c.f;
import d.a.o0.v.d.f.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialConcernTabModel extends BdBaseModel {

    /* renamed from: f  reason: collision with root package name */
    public b f13967f;

    /* renamed from: e  reason: collision with root package name */
    public int f13966e = 1;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f13969h = new a(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);

    /* renamed from: g  reason: collision with root package name */
    public List<n> f13968g = new ArrayList();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021094 && (httpResponsedMessage instanceof AlaSpecialConcernResponse)) {
                AlaSpecialConcernResponse alaSpecialConcernResponse = (AlaSpecialConcernResponse) httpResponsedMessage;
                if (alaSpecialConcernResponse.isSuccess()) {
                    if (SpecialConcernTabModel.this.f13966e == 1) {
                        SpecialConcernTabModel.this.f13968g.clear();
                    }
                    boolean z = alaSpecialConcernResponse.hasMore;
                    if (ListUtils.isEmpty(alaSpecialConcernResponse.followList)) {
                        if (SpecialConcernTabModel.this.f13966e == 1) {
                            SpecialConcernTabModel.this.f13968g.add(new e());
                        }
                    } else {
                        for (d dVar : alaSpecialConcernResponse.followList) {
                            f fVar = new f();
                            fVar.f65565e = dVar.f65560a;
                            fVar.f65566f = dVar.f65561b;
                            fVar.f65567g = false;
                            SpecialConcernTabModel.this.f13968g.add(fVar);
                        }
                    }
                    if (!ListUtils.isEmpty(alaSpecialConcernResponse.recommendList)) {
                        g gVar = new g();
                        if (!ListUtils.isEmpty(alaSpecialConcernResponse.followList)) {
                            gVar.f65569e = false;
                        } else {
                            gVar.f65569e = true;
                        }
                        SpecialConcernTabModel.this.f13968g.add(gVar);
                        for (d dVar2 : alaSpecialConcernResponse.recommendList) {
                            f fVar2 = new f();
                            fVar2.f65565e = dVar2.f65560a;
                            fVar2.f65566f = dVar2.f65561b;
                            fVar2.f65567g = true;
                            SpecialConcernTabModel.this.f13968g.add(fVar2);
                        }
                    }
                    SpecialConcernTabModel.x(SpecialConcernTabModel.this);
                    if (SpecialConcernTabModel.this.f13967f != null) {
                        SpecialConcernTabModel.this.f13967f.b(SpecialConcernTabModel.this.f13968g, z, alaSpecialConcernResponse.totalFollowCount);
                    }
                } else if (SpecialConcernTabModel.this.f13967f != null) {
                    SpecialConcernTabModel.this.f13967f.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str);

        void b(List<n> list, boolean z, int i2);
    }

    public SpecialConcernTabModel(TbPageContext tbPageContext) {
        MessageManager.getInstance().registerListener(this.f13969h);
    }

    public static /* synthetic */ int x(SpecialConcernTabModel specialConcernTabModel) {
        int i2 = specialConcernTabModel.f13966e;
        specialConcernTabModel.f13966e = i2 + 1;
        return i2;
    }

    public final void A(int i2) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void B() {
        A(this.f13966e + 1);
    }

    public void C() {
        this.f13966e = 1;
        A(1);
    }

    public void D(b bVar) {
        this.f13967f = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f13969h);
    }
}
