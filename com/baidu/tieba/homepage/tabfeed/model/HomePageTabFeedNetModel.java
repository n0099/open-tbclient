package com.baidu.tieba.homepage.tabfeed.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListSocketResponsedMessage;
import d.a.k0.a1.i.c;
/* loaded from: classes4.dex */
public class HomePageTabFeedNetModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f16616e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16617f;

    /* renamed from: g  reason: collision with root package name */
    public int f16618g;

    /* renamed from: h  reason: collision with root package name */
    public String f16619h;

    /* renamed from: i  reason: collision with root package name */
    public String f16620i;
    public c j;
    public d.a.k0.a1.i.f.a k;
    public d.a.c.c.g.a l;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            HomePageTabFeedNetModel.this.f16617f = false;
            if (responsedMessage == null) {
                return;
            }
            d.a.k0.a1.i.e.a aVar = null;
            if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).tabFeedData;
            } else if (responsedMessage instanceof TabFeedListSocketResponsedMessage) {
                aVar = ((TabFeedListSocketResponsedMessage) responsedMessage).tabFeedData;
            }
            HomePageTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
            HomePageTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(HomePageTabFeedNetModel.this.mErrorCode);
            errorData.setError_msg(HomePageTabFeedNetModel.this.mErrorString);
            if (HomePageTabFeedNetModel.this.j == null) {
                return;
            }
            if (HomePageTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                HomePageTabFeedNetModel.this.j.onServerError(errorData);
            } else {
                HomePageTabFeedNetModel.this.D(aVar);
            }
        }
    }

    public HomePageTabFeedNetModel(TbPageContext tbPageContext, c cVar) {
        super(tbPageContext);
        this.f16616e = true;
        this.f16617f = false;
        this.f16618g = 1;
        this.l = new a(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, 309655);
        d.a.k0.d3.d0.a.h(309655, TabFeedListSocketResponsedMessage.class, false, false);
        d.a.k0.d3.d0.a.c(309655, CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, TbConfig.URL_TAB_ACTIVITY_TAB, TabFeedListHttpResponsedMessage.class, false, false, true, false);
        this.k = new d.a.k0.a1.i.f.a();
        this.j = cVar;
    }

    public boolean A() {
        d.a.k0.a1.i.f.a aVar = this.k;
        if (aVar == null) {
            return false;
        }
        return aVar.c();
    }

    public final void B(int i2) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i2;
        tabFeedListRequestMessage.tabCode = this.f16620i;
        tabFeedListRequestMessage.tabName = this.f16619h;
        if (i2 == 2) {
            tabFeedListRequestMessage.pn = this.f16618g + 1;
        } else if (i2 != 1) {
            return;
        } else {
            tabFeedListRequestMessage.pn = 1;
        }
        this.f16617f = true;
        sendMessage(tabFeedListRequestMessage);
    }

    public void C() {
        if (this.f16617f) {
            return;
        }
        this.f16616e = false;
        B(2);
    }

    public final void D(d.a.k0.a1.i.e.a aVar) {
        if (aVar != null) {
            this.f16618g = aVar.b();
        }
        if (this.j != null) {
            this.j.M(this.k.a(this.f16616e, aVar));
        }
    }

    public void E() {
        if (this.f16617f) {
            return;
        }
        this.f16616e = true;
        B(1);
    }

    public void F(BdUniqueId bdUniqueId) {
        setUniqueId(bdUniqueId);
        MessageManager.getInstance().unRegisterListener(this.l);
        this.l.getHttpMessageListener().setSelfListener(true);
        this.l.getSocketMessageListener().setSelfListener(true);
        registerListener(this.l);
    }

    public void G(String str, String str2) {
        this.f16620i = str;
        this.f16619h = str2;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.f16617f = false;
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.l);
        this.f16617f = false;
        this.f16616e = true;
    }
}
