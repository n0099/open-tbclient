package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.chosen.posts.request.ChosenPostCacheModel;
import com.baidu.tieba.chosen.posts.request.ChosenPostModel;
import com.baidu.tieba.chosen.unlike.UnlikeHttpResponse;
import com.baidu.tieba.chosen.unlike.UnlikeRequest;
import com.baidu.tieba.chosen.unlike.UnlikeSocketReponse;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class ChosenPostModelController extends BdBaseModel<ChosenPostActivity> implements NetModel.k<d.a.n0.a0.a.d.a, d.a.n0.a0.a.d.b> {

    /* renamed from: e  reason: collision with root package name */
    public ChosenPostActivity f14343e;

    /* renamed from: f  reason: collision with root package name */
    public ChosenPostModel f14344f;

    /* renamed from: g  reason: collision with root package name */
    public ChosenPostCacheModel f14345g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.g0.d.a f14346h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.a0.a.d.a f14347i;
    public CacheModel.c<d.a.n0.a0.a.d.b> j;
    public d.a.c.c.g.a k;

    /* loaded from: classes4.dex */
    public class a implements CacheModel.c<d.a.n0.a0.a.d.b> {
        public a() {
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataGet(ReadCacheRespMsg<List<d.a.n0.a0.a.d.b>> readCacheRespMsg, ReadCacheMessage<d.a.n0.a0.a.d.b> readCacheMessage) {
            d.a.n0.a0.a.d.b bVar;
            List<d.a.n0.a0.a.d.b> data = readCacheRespMsg.getData();
            if (data != null && !data.isEmpty() && (bVar = data.get(0)) != null) {
                d.a.m0.g0.c.b bVar2 = new d.a.m0.g0.c.b(4099, bVar, null, null);
                bVar2.i(ChosenPostModelController.this.getUniqueId());
                ChosenPostModelController.this.f14343e.getEventCenter().dispatchMvcEvent(bVar2);
            }
            ChosenPostModelController.this.f14347i.a();
            ChosenPostModelController.this.f14344f.R();
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataWrite(WriteCacheRespMsg<List<d.a.n0.a0.a.d.b>> writeCacheRespMsg, WriteCacheMessage<d.a.n0.a0.a.d.b> writeCacheMessage) {
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getError() != 0) {
                BdToast d2 = BdToast.d(ChosenPostModelController.this.f14343e.getActivity(), responsedMessage.getErrorString(), 0);
                d2.a();
                d2.q();
            } else if (responsedMessage instanceof UnlikeHttpResponse) {
                ChosenPostModelController.this.J(((UnlikeHttpResponse) responsedMessage).getThreadId());
            } else if (responsedMessage instanceof UnlikeSocketReponse) {
                ChosenPostModelController.this.J(((UnlikeSocketReponse) responsedMessage).getThreadId());
            }
        }
    }

    public ChosenPostModelController(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.f14346h = new d.a.m0.g0.d.a();
        this.j = new a();
        this.k = new b(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, 307007);
        this.f14343e = chosenPostActivity;
        G();
        H();
        registerListener(this.k);
    }

    public boolean A() {
        this.f14345g.L();
        return true;
    }

    public void B(Bundle bundle) {
        this.f14347i = new d.a.n0.a0.a.d.a();
        ChosenPostModel chosenPostModel = new ChosenPostModel(this.f14343e.getPageContext(), this.f14347i);
        this.f14344f = chosenPostModel;
        chosenPostModel.Z(this);
        ChosenPostCacheModel chosenPostCacheModel = new ChosenPostCacheModel(this.f14343e.getPageContext());
        this.f14345g = chosenPostCacheModel;
        chosenPostCacheModel.O(this.j);
    }

    public boolean C() {
        this.f14347i.a();
        this.f14344f.R();
        this.f14346h.f(true);
        this.f14346h.h(true);
        I(false);
        this.f14343e.getViewController().u(this.f14346h);
        return true;
    }

    public boolean D(d.a.m0.g0.c.b bVar) {
        if (bVar.b() == 4100) {
            this.f14344f.R();
            return false;
        } else if (bVar.b() == 4101) {
            Object c2 = bVar.c();
            if (c2 instanceof tinfo) {
                tinfo tinfoVar = (tinfo) c2;
                UnlikeRequest unlikeRequest = new UnlikeRequest();
                unlikeRequest.setThreadId(tinfoVar.thread_id.longValue());
                unlikeRequest.setType(tinfoVar.type.intValue());
                sendMessage(unlikeRequest);
                return false;
            }
            return false;
        } else {
            return false;
        }
    }

    public boolean E(d.a.n0.a0.a.d.a aVar, d.a.n0.a0.a.d.b bVar) {
        this.f14343e.getViewController().t(bVar);
        if (bVar != null) {
            this.f14346h.g(false);
            this.f14346h.f(false);
            this.f14343e.getViewController().u(this.f14346h);
            return true;
        }
        return true;
    }

    public boolean F(boolean z) {
        this.f14346h.g(true);
        this.f14343e.getViewController().u(this.f14346h);
        I(true);
        this.f14347i.a();
        this.f14344f.R();
        return true;
    }

    public final void G() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, d.a.n0.e3.d0.a.a(TbConfig.HOT_THREAD_UNLIKE, 307007));
        tbHttpMessageTask.setResponsedClass(UnlikeHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public final void H() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(307007);
        socketMessageTask.g(true);
        socketMessageTask.setResponsedClass(UnlikeSocketReponse.class);
        socketMessageTask.h(false);
        MessageManager.getInstance().registerTask(socketMessageTask);
    }

    public final void I(boolean z) {
        d.a.m0.g0.c.b bVar;
        if (z) {
            bVar = new d.a.m0.g0.c.b(4097, null, null, null);
        } else {
            bVar = new d.a.m0.g0.c.b(4098, null, null, null);
        }
        bVar.i(getUniqueId());
        this.f14343e.getEventCenter().dispatchMvcEvent(bVar);
    }

    public final void J(long j) {
        d.a.m0.g0.c.b bVar = new d.a.m0.g0.c.b(4102, null, null, null);
        bVar.g(Long.valueOf(j));
        bVar.i(getUniqueId());
        this.f14343e.getEventCenter().dispatchMvcEvent(bVar);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage<d.a.n0.a0.a.d.b, ?> mvcSocketResponsedMessage, MvcSocketMessage<d.a.n0.a0.a.d.a, d.a.n0.a0.a.d.b> mvcSocketMessage, MvcNetMessage<d.a.n0.a0.a.d.a, d.a.n0.a0.a.d.b> mvcNetMessage) {
        d.a.n0.a0.a.d.b bVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            bVar = null;
        } else {
            bVar = mvcSocketResponsedMessage.getData();
            r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        }
        if (r0 == null || bVar == null || !E(r0, bVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f14343e.onServerError(errorData);
            this.f14343e.getViewController().onServerError(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage<d.a.n0.a0.a.d.b> mvcHttpResponsedMessage, MvcHttpMessage<d.a.n0.a0.a.d.a, d.a.n0.a0.a.d.b> mvcHttpMessage, MvcNetMessage<d.a.n0.a0.a.d.a, d.a.n0.a0.a.d.b> mvcNetMessage) {
        d.a.n0.a0.a.d.b bVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            bVar = null;
        } else {
            bVar = mvcHttpResponsedMessage.getData();
            r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        }
        if (r0 == null || bVar == null || !E(r0, bVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f14343e.onServerError(errorData);
            this.f14343e.getViewController().onServerError(errorData);
        }
    }
}
