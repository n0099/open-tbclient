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
import d.b.c.j.e.n;
import d.b.i0.t.d.f.c.d;
import d.b.i0.t.d.f.c.e;
import d.b.i0.t.d.f.c.f;
import d.b.i0.t.d.f.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialConcernTabModel extends BdBaseModel {

    /* renamed from: f  reason: collision with root package name */
    public b f14528f;

    /* renamed from: e  reason: collision with root package name */
    public int f14527e = 1;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f14530h = new a(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);

    /* renamed from: g  reason: collision with root package name */
    public List<n> f14529g = new ArrayList();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021094 && (httpResponsedMessage instanceof AlaSpecialConcernResponse)) {
                AlaSpecialConcernResponse alaSpecialConcernResponse = (AlaSpecialConcernResponse) httpResponsedMessage;
                if (alaSpecialConcernResponse.isSuccess()) {
                    if (SpecialConcernTabModel.this.f14527e == 1) {
                        SpecialConcernTabModel.this.f14529g.clear();
                    }
                    boolean z = alaSpecialConcernResponse.hasMore;
                    if (ListUtils.isEmpty(alaSpecialConcernResponse.followList)) {
                        if (SpecialConcernTabModel.this.f14527e == 1) {
                            SpecialConcernTabModel.this.f14529g.add(new e());
                        }
                    } else {
                        for (d dVar : alaSpecialConcernResponse.followList) {
                            f fVar = new f();
                            fVar.f62105e = dVar.f62100a;
                            fVar.f62106f = dVar.f62101b;
                            fVar.f62107g = false;
                            SpecialConcernTabModel.this.f14529g.add(fVar);
                        }
                    }
                    if (!ListUtils.isEmpty(alaSpecialConcernResponse.recommendList)) {
                        g gVar = new g();
                        if (!ListUtils.isEmpty(alaSpecialConcernResponse.followList)) {
                            gVar.f62109e = false;
                        } else {
                            gVar.f62109e = true;
                        }
                        SpecialConcernTabModel.this.f14529g.add(gVar);
                        for (d dVar2 : alaSpecialConcernResponse.recommendList) {
                            f fVar2 = new f();
                            fVar2.f62105e = dVar2.f62100a;
                            fVar2.f62106f = dVar2.f62101b;
                            fVar2.f62107g = true;
                            SpecialConcernTabModel.this.f14529g.add(fVar2);
                        }
                    }
                    SpecialConcernTabModel.t(SpecialConcernTabModel.this);
                    if (SpecialConcernTabModel.this.f14528f != null) {
                        SpecialConcernTabModel.this.f14528f.b(SpecialConcernTabModel.this.f14529g, z, alaSpecialConcernResponse.totalFollowCount);
                    }
                } else if (SpecialConcernTabModel.this.f14528f != null) {
                    SpecialConcernTabModel.this.f14528f.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str);

        void b(List<n> list, boolean z, int i);
    }

    public SpecialConcernTabModel(TbPageContext tbPageContext) {
        MessageManager.getInstance().registerListener(this.f14530h);
    }

    public static /* synthetic */ int t(SpecialConcernTabModel specialConcernTabModel) {
        int i = specialConcernTabModel.f14527e;
        specialConcernTabModel.f14527e = i + 1;
        return i;
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
        MessageManager.getInstance().unRegisterListener(this.f14530h);
    }

    public final void w(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void x() {
        w(this.f14527e + 1);
    }

    public void y() {
        this.f14527e = 1;
        w(1);
    }

    public void z(b bVar) {
        this.f14528f = bVar;
    }
}
