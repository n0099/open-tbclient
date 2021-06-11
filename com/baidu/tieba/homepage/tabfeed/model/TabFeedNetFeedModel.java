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
import d.a.m0.r.q.a2;
import d.a.n0.b1.j.e;
import d.a.n0.b1.j.f;
import java.util.List;
/* loaded from: classes4.dex */
public class TabFeedNetFeedModel extends BdBaseModel implements f {

    /* renamed from: e  reason: collision with root package name */
    public boolean f16602e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16603f;

    /* renamed from: g  reason: collision with root package name */
    public int f16604g;

    /* renamed from: h  reason: collision with root package name */
    public String f16605h;

    /* renamed from: i  reason: collision with root package name */
    public String f16606i;
    public e j;
    public d.a.n0.b1.j.j.a k;
    public d.a.c.c.g.a l;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            TabFeedNetFeedModel.this.f16603f = false;
            if (responsedMessage == null) {
                return;
            }
            d.a.n0.b1.j.h.a aVar = null;
            if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).tabFeedData;
            } else if (responsedMessage instanceof TabFeedListSocketResponsedMessage) {
                aVar = ((TabFeedListSocketResponsedMessage) responsedMessage).tabFeedData;
            }
            TabFeedNetFeedModel.this.mErrorCode = responsedMessage.getError();
            TabFeedNetFeedModel.this.mErrorString = responsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(TabFeedNetFeedModel.this.mErrorCode);
            errorData.setError_msg(TabFeedNetFeedModel.this.mErrorString);
            if (TabFeedNetFeedModel.this.j == null) {
                return;
            }
            if (TabFeedNetFeedModel.this.mErrorCode != 0 || aVar == null) {
                TabFeedNetFeedModel.this.j.onServerError(errorData);
            } else {
                TabFeedNetFeedModel.this.F(aVar);
            }
        }
    }

    public TabFeedNetFeedModel(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.f16602e = true;
        this.f16603f = false;
        this.f16604g = 1;
        this.l = new a(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, 309655);
        d.a.n0.e3.d0.a.h(309655, TabFeedListSocketResponsedMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309655, CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, TbConfig.URL_TAB_ACTIVITY_TAB, TabFeedListHttpResponsedMessage.class, false, false, true, false);
        this.k = new d.a.n0.b1.j.j.a();
        this.j = eVar;
    }

    public final void E(int i2) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i2;
        tabFeedListRequestMessage.tabCode = this.f16606i;
        tabFeedListRequestMessage.tabName = this.f16605h;
        if (i2 == 2) {
            tabFeedListRequestMessage.pn = this.f16604g + 1;
        } else if (i2 != 1) {
            return;
        } else {
            tabFeedListRequestMessage.pn = 1;
        }
        this.f16603f = true;
        tabFeedListRequestMessage.setTag(getUniqueId());
        sendMessage(tabFeedListRequestMessage);
    }

    public final void F(d.a.n0.b1.j.h.a aVar) {
        if (aVar != null) {
            this.f16604g = aVar.b();
        }
        if (this.j != null) {
            this.j.N(this.k.a(this.f16602e, aVar));
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // d.a.n0.b1.j.f
    public boolean b() {
        d.a.n0.b1.j.j.a aVar = this.k;
        if (aVar == null) {
            return false;
        }
        return aVar.c();
    }

    @Override // d.a.n0.b1.j.f
    public void c(BdUniqueId bdUniqueId) {
        setUniqueId(bdUniqueId);
        MessageManager.getInstance().unRegisterListener(this.l);
        this.l.getHttpMessageListener().setSelfListener(true);
        this.l.getSocketMessageListener().setSelfListener(true);
        registerListener(this.l);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.f16603f = false;
    }

    @Override // d.a.n0.b1.j.f
    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.l);
        this.f16603f = false;
        this.f16602e = true;
    }

    @Override // d.a.n0.b1.j.f
    public List<a2> i() {
        d.a.n0.b1.j.j.a aVar = this.k;
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    @Override // d.a.n0.b1.j.f
    public void loadMore() {
        if (this.f16603f) {
            return;
        }
        this.f16602e = false;
        E(2);
    }

    @Override // d.a.n0.b1.j.f
    public void o(String str, String str2, int i2) {
        this.f16606i = str;
        this.f16605h = str2;
    }

    @Override // d.a.n0.b1.j.f
    public void refresh() {
        if (this.f16603f) {
            return;
        }
        this.f16602e = true;
        E(1);
    }
}
