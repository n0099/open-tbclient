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
import d.a.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class MyConcernTabModel extends BdBaseModel {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f13751f;

    /* renamed from: g  reason: collision with root package name */
    public b f13752g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.v.d.c.f.c.b f13753h;

    /* renamed from: e  reason: collision with root package name */
    public int f13750e = 1;

    /* renamed from: i  reason: collision with root package name */
    public HttpMessageListener f13754i = new a(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021140 && (httpResponsedMessage instanceof AlaLiveTabMyConcernResponse)) {
                AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse = (AlaLiveTabMyConcernResponse) httpResponsedMessage;
                boolean z = ListUtils.isEmpty(alaLiveTabMyConcernResponse.followList) && ListUtils.isEmpty(alaLiveTabMyConcernResponse.recommendList) && ListUtils.isEmpty(alaLiveTabMyConcernResponse.followCloseList) && alaLiveTabMyConcernResponse.followStatus == 0;
                if (alaLiveTabMyConcernResponse.getError() != 0 || !alaLiveTabMyConcernResponse.isSuccess() || z) {
                    if (MyConcernTabModel.this.f13752g != null) {
                        MyConcernTabModel.this.f13752g.b(MyConcernTabModel.this.f13750e == 1);
                        return;
                    }
                    return;
                }
                MyConcernTabModel.this.f13753h.e(alaLiveTabMyConcernResponse, MyConcernTabModel.this.f13750e == 1);
                if (MyConcernTabModel.this.f13752g != null) {
                    MyConcernTabModel.this.f13752g.a(MyConcernTabModel.this.f13753h.h(), alaLiveTabMyConcernResponse.hasMore, MyConcernTabModel.this.f13750e == 1);
                }
                MyConcernTabModel.this.f13750e = alaLiveTabMyConcernResponse.pn + 1;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(List<n> list, boolean z, boolean z2);

        void b(boolean z);
    }

    public MyConcernTabModel(TbPageContext tbPageContext) {
        this.f13751f = tbPageContext;
        this.f13753h = new d.a.n0.v.d.c.f.c.b(this.f13751f);
        z();
        MessageManager.getInstance().registerListener(this.f13754i);
    }

    public void A(Class<? extends BaseCardInfo> cls) {
        this.f13753h.j(cls);
    }

    public void B(b bVar) {
        this.f13752g = bVar;
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
        this.f13753h.a();
        if (this.f13754i != null) {
            MessageManager.getInstance().unRegisterListener(this.f13754i);
        }
    }

    public final void w(int i2) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
        httpMessage.addParam(Config.PACKAGE_NAME, i2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void x() {
        w(this.f13750e);
    }

    public void y() {
        this.f13750e = 1;
        this.f13753h.a();
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
