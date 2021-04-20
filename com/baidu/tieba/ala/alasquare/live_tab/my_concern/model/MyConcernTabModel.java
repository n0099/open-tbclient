package com.baidu.tieba.ala.alasquare.live_tab.my_concern.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class MyConcernTabModel extends BdBaseModel {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f14455f;

    /* renamed from: g  reason: collision with root package name */
    public b f14456g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.t.d.c.f.c.b f14457h;

    /* renamed from: e  reason: collision with root package name */
    public int f14454e = 1;
    public HttpMessageListener i = new a(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021140 && (httpResponsedMessage instanceof AlaLiveTabMyConcernResponse)) {
                AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse = (AlaLiveTabMyConcernResponse) httpResponsedMessage;
                boolean z = ListUtils.isEmpty(alaLiveTabMyConcernResponse.followList) && ListUtils.isEmpty(alaLiveTabMyConcernResponse.recommendList) && ListUtils.isEmpty(alaLiveTabMyConcernResponse.followCloseList) && alaLiveTabMyConcernResponse.followStatus == 0;
                if (alaLiveTabMyConcernResponse.getError() != 0 || !alaLiveTabMyConcernResponse.isSuccess() || z) {
                    if (MyConcernTabModel.this.f14456g != null) {
                        MyConcernTabModel.this.f14456g.b(MyConcernTabModel.this.f14454e == 1);
                        return;
                    }
                    return;
                }
                MyConcernTabModel.this.f14457h.e(alaLiveTabMyConcernResponse, MyConcernTabModel.this.f14454e == 1);
                if (MyConcernTabModel.this.f14456g != null) {
                    MyConcernTabModel.this.f14456g.a(MyConcernTabModel.this.f14457h.h(), alaLiveTabMyConcernResponse.hasMore, MyConcernTabModel.this.f14454e == 1);
                }
                MyConcernTabModel.this.f14454e = alaLiveTabMyConcernResponse.pn + 1;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(List<n> list, boolean z, boolean z2);

        void b(boolean z);
    }

    public MyConcernTabModel(TbPageContext tbPageContext) {
        this.f14455f = tbPageContext;
        this.f14457h = new d.b.i0.t.d.c.f.c.b(this.f14455f);
        z();
        MessageManager.getInstance().registerListener(this.i);
    }

    public void A(Class<? extends BaseCardInfo> cls) {
        this.f14457h.j(cls);
    }

    public void B(b bVar) {
        this.f14456g = bVar;
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
        this.f14457h.a();
        if (this.i != null) {
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public final void w(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void x() {
        w(this.f14454e);
    }

    public void y() {
        this.f14454e = 1;
        this.f14457h.a();
        w(1);
    }

    public final void z() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_TAB_SUB_MY_CONCERN_LIST);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaLiveTabMyConcernResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
