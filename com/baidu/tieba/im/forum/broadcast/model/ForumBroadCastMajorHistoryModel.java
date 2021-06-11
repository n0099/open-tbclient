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
    public final d.a.n0.f1.i.a.a f17236e;

    /* renamed from: f  reason: collision with root package name */
    public final String f17237f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17238g;

    /* renamed from: h  reason: collision with root package name */
    public long f17239h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17240i;
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
            ForumBroadCastMajorHistoryModel.this.f17238g = false;
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
            if (ForumBroadCastMajorHistoryModel.this.f17236e == null) {
                return;
            }
            if (ForumBroadCastMajorHistoryModel.this.mErrorCode != 0 || aVar == null) {
                ForumBroadCastMajorHistoryModel.this.f17236e.onServerError(errorData);
                return;
            }
            ForumBroadCastMajorHistoryModel.this.j = aVar;
            ForumBroadCastMajorHistoryModel.this.I();
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
            if (ForumBroadCastMajorHistoryModel.this.f17236e != null) {
                ForumBroadCastMajorHistoryModel.this.f17236e.netResidueCallback(data);
            }
        }
    }

    public ForumBroadCastMajorHistoryModel(TbPageContext tbPageContext, d.a.n0.f1.i.a.a aVar, String str) {
        super(tbPageContext);
        this.f17239h = 0L;
        this.j = null;
        this.k = new a(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669);
        this.l = new b(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
        d.a.n0.e3.d0.a.h(309669, ResponseSocketMajorHistoryMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309669, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, TbConfig.URL_FORUM_BROADCAST_HISTORY, ResponseHttpMajorHistoryMessage.class, true, false, true, false);
        d.a.n0.e3.d0.a.e(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE, "c/f/forum/getForumMangerRights", ResponseHttpMajorResidueMessage.class, true, true, true, true);
        registerListener(this.k);
        registerListener(this.l);
        this.f17236e = aVar;
        this.f17237f = str;
    }

    public void F() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("forum_id", this.f17237f);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void G(int i2) {
        BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
        broadcastMajorHistoryRequestMessage.queryType = 1;
        broadcastMajorHistoryRequestMessage.needCount = 15;
        try {
            broadcastMajorHistoryRequestMessage.forumId = Long.parseLong(this.f17237f);
        } catch (Exception unused) {
            broadcastMajorHistoryRequestMessage.forumId = 0L;
        }
        if (i2 == 2) {
            broadcastMajorHistoryRequestMessage.lastId = this.f17239h;
        } else if (i2 != 1) {
            return;
        } else {
            broadcastMajorHistoryRequestMessage.lastId = 0L;
        }
        this.f17238g = true;
        sendMessage(broadcastMajorHistoryRequestMessage);
    }

    public void H() {
        this.j = null;
    }

    public final void I() {
        if (this.j.b() != null && this.j.b().size() > 1) {
            this.f17239h = this.j.b().get(this.j.b().size() - 1).b();
        }
        this.j.e(this.f17240i);
        this.f17236e.netCallback(this.j);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public boolean b() {
        d.a.n0.f1.i.a.b.a aVar = this.j;
        if (aVar == null) {
            return false;
        }
        return !ListUtils.isEmpty(aVar.b());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void loadMore() {
        if (this.f17238g) {
            return;
        }
        this.f17240i = false;
        G(2);
    }

    public void refresh() {
        if (this.f17238g) {
            return;
        }
        this.f17240i = true;
        G(1);
    }
}
