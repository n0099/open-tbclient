package com.baidu.tieba.im.forum.broadcast.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.im.forum.broadcast.data.BroadcastMajorHistoryRequestMessage;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorHistoryMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorResidueMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseSocketMajorHistoryMessage;
/* loaded from: classes4.dex */
public class ForumBroadCastMajorHistoryModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public final d.a.n0.f1.i.a.a f17160e;

    /* renamed from: f  reason: collision with root package name */
    public final String f17161f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17162g;

    /* renamed from: h  reason: collision with root package name */
    public long f17163h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17164i;
    public d.a.n0.f1.i.a.b.a j;
    public d.a.c.c.g.a k;
    public HttpMessageListener l;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            ForumBroadCastMajorHistoryModel.this.f17162g = false;
            if (responsedMessage == null) {
                return;
            }
            d.a.n0.f1.i.a.b.a aVar = null;
            if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                aVar = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
            } else if (responsedMessage instanceof ResponseSocketMajorHistoryMessage) {
                aVar = ((ResponseSocketMajorHistoryMessage) responsedMessage).getData();
            }
            ForumBroadCastMajorHistoryModel.this.mErrorCode = responsedMessage.getError();
            ForumBroadCastMajorHistoryModel.this.mErrorString = responsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(ForumBroadCastMajorHistoryModel.this.mErrorCode);
            errorData.setError_msg(ForumBroadCastMajorHistoryModel.this.mErrorString);
            if (ForumBroadCastMajorHistoryModel.this.f17160e == null) {
                return;
            }
            if (ForumBroadCastMajorHistoryModel.this.mErrorCode != 0 || aVar == null) {
                ForumBroadCastMajorHistoryModel.this.f17160e.onServerError(errorData);
                return;
            }
            ForumBroadCastMajorHistoryModel.this.j = aVar;
            ForumBroadCastMajorHistoryModel.this.G();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            ForumBroadcastMajorResidueData data = httpResponsedMessage instanceof ResponseHttpMajorResidueMessage ? ((ResponseHttpMajorResidueMessage) httpResponsedMessage).getData() : null;
            if (ForumBroadCastMajorHistoryModel.this.f17160e != null) {
                ForumBroadCastMajorHistoryModel.this.f17160e.netResidueCallback(data);
            }
        }
    }

    public ForumBroadCastMajorHistoryModel(TbPageContext tbPageContext, d.a.n0.f1.i.a.a aVar, String str) {
        super(tbPageContext);
        this.f17163h = 0L;
        this.j = null;
        this.k = new a(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669);
        this.l = new b(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
        d.a.n0.e3.d0.a.h(309669, ResponseSocketMajorHistoryMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309669, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, TbConfig.URL_FORUM_BROADCAST_HISTORY, ResponseHttpMajorHistoryMessage.class, true, false, true, false);
        d.a.n0.e3.d0.a.e(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE, "c/f/forum/getForumMangerRights", ResponseHttpMajorResidueMessage.class, true, true, true, true);
        registerListener(this.k);
        registerListener(this.l);
        this.f17160e = aVar;
        this.f17161f = str;
    }

    public void B() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("forum_id", this.f17161f);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public boolean C() {
        d.a.n0.f1.i.a.b.a aVar = this.j;
        if (aVar == null) {
            return false;
        }
        return !ListUtils.isEmpty(aVar.b());
    }

    public final void D(int i2) {
        BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
        broadcastMajorHistoryRequestMessage.queryType = 1;
        broadcastMajorHistoryRequestMessage.needCount = 15;
        try {
            broadcastMajorHistoryRequestMessage.forumId = Long.parseLong(this.f17161f);
        } catch (Exception unused) {
            broadcastMajorHistoryRequestMessage.forumId = 0L;
        }
        if (i2 == 2) {
            broadcastMajorHistoryRequestMessage.lastId = this.f17163h;
        } else if (i2 != 1) {
            return;
        } else {
            broadcastMajorHistoryRequestMessage.lastId = 0L;
        }
        this.f17162g = true;
        sendMessage(broadcastMajorHistoryRequestMessage);
    }

    public void E() {
        if (this.f17162g) {
            return;
        }
        this.f17164i = false;
        D(2);
    }

    public void F() {
        this.j = null;
    }

    public final void G() {
        if (this.j.b() != null && this.j.b().size() > 1) {
            this.f17163h = this.j.b().get(this.j.b().size() - 1).b();
        }
        this.j.e(this.f17164i);
        this.f17160e.netCallback(this.j);
    }

    public void H() {
        if (this.f17162g) {
            return;
        }
        this.f17164i = true;
        D(1);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
