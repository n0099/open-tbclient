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
import d.b.i0.z0.i.c;
/* loaded from: classes3.dex */
public class HomePageTabFeedNetModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f17339e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17340f;

    /* renamed from: g  reason: collision with root package name */
    public int f17341g;

    /* renamed from: h  reason: collision with root package name */
    public String f17342h;
    public String i;
    public c j;
    public d.b.i0.z0.i.f.a k;
    public d.b.b.c.g.a l;

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            HomePageTabFeedNetModel.this.f17340f = false;
            if (responsedMessage == null) {
                return;
            }
            d.b.i0.z0.i.e.a aVar = null;
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
        this.f17339e = true;
        this.f17340f = false;
        this.f17341g = 1;
        this.l = new a(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, 309655);
        d.b.i0.c3.d0.a.h(309655, TabFeedListSocketResponsedMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309655, CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, TbConfig.URL_TAB_ACTIVITY_TAB, TabFeedListHttpResponsedMessage.class, false, false, true, false);
        this.k = new d.b.i0.z0.i.f.a();
        this.j = cVar;
    }

    public boolean A() {
        d.b.i0.z0.i.f.a aVar = this.k;
        if (aVar == null) {
            return false;
        }
        return aVar.c();
    }

    public final void B(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.i;
        tabFeedListRequestMessage.tabName = this.f17342h;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.f17341g + 1;
        } else if (i != 1) {
            return;
        } else {
            tabFeedListRequestMessage.pn = 1;
        }
        this.f17340f = true;
        sendMessage(tabFeedListRequestMessage);
    }

    public void C() {
        if (this.f17340f) {
            return;
        }
        this.f17339e = false;
        B(2);
    }

    public final void D(d.b.i0.z0.i.e.a aVar) {
        if (aVar != null) {
            this.f17341g = aVar.b();
        }
        if (this.j != null) {
            this.j.q0(this.k.a(this.f17339e, aVar));
        }
    }

    public void E() {
        if (this.f17340f) {
            return;
        }
        this.f17339e = true;
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
        this.i = str;
        this.f17342h = str2;
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
        this.f17340f = false;
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.l);
        this.f17340f = false;
        this.f17339e = true;
    }
}
