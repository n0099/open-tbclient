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
public class ChosenPostModelController extends BdBaseModel<ChosenPostActivity> implements NetModel.k<d.a.k0.y.a.d.a, d.a.k0.y.a.d.b> {

    /* renamed from: e  reason: collision with root package name */
    public ChosenPostActivity f14383e;

    /* renamed from: f  reason: collision with root package name */
    public ChosenPostModel f14384f;

    /* renamed from: g  reason: collision with root package name */
    public ChosenPostCacheModel f14385g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.g0.d.a f14386h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.y.a.d.a f14387i;
    public CacheModel.c<d.a.k0.y.a.d.b> j;
    public d.a.c.c.g.a k;

    /* loaded from: classes4.dex */
    public class a implements CacheModel.c<d.a.k0.y.a.d.b> {
        public a() {
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataGet(ReadCacheRespMsg<List<d.a.k0.y.a.d.b>> readCacheRespMsg, ReadCacheMessage<d.a.k0.y.a.d.b> readCacheMessage) {
            d.a.k0.y.a.d.b bVar;
            List<d.a.k0.y.a.d.b> data = readCacheRespMsg.getData();
            if (data != null && !data.isEmpty() && (bVar = data.get(0)) != null) {
                d.a.j0.g0.c.b bVar2 = new d.a.j0.g0.c.b(4099, bVar, null, null);
                bVar2.i(ChosenPostModelController.this.getUniqueId());
                ChosenPostModelController.this.f14383e.getEventCenter().dispatchMvcEvent(bVar2);
            }
            ChosenPostModelController.this.f14387i.a();
            ChosenPostModelController.this.f14384f.N();
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataWrite(WriteCacheRespMsg<List<d.a.k0.y.a.d.b>> writeCacheRespMsg, WriteCacheMessage<d.a.k0.y.a.d.b> writeCacheMessage) {
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
                BdToast d2 = BdToast.d(ChosenPostModelController.this.f14383e.getActivity(), responsedMessage.getErrorString(), 0);
                d2.a();
                d2.q();
            } else if (responsedMessage instanceof UnlikeHttpResponse) {
                ChosenPostModelController.this.F(((UnlikeHttpResponse) responsedMessage).getThreadId());
            } else if (responsedMessage instanceof UnlikeSocketReponse) {
                ChosenPostModelController.this.F(((UnlikeSocketReponse) responsedMessage).getThreadId());
            }
        }
    }

    public ChosenPostModelController(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.f14386h = new d.a.j0.g0.d.a();
        this.j = new a();
        this.k = new b(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, 307007);
        this.f14383e = chosenPostActivity;
        C();
        D();
        registerListener(this.k);
    }

    public boolean A(d.a.k0.y.a.d.a aVar, d.a.k0.y.a.d.b bVar) {
        this.f14383e.getViewController().t(bVar);
        if (bVar != null) {
            this.f14386h.g(false);
            this.f14386h.f(false);
            this.f14383e.getViewController().u(this.f14386h);
            return true;
        }
        return true;
    }

    public boolean B(boolean z) {
        this.f14386h.g(true);
        this.f14383e.getViewController().u(this.f14386h);
        E(true);
        this.f14387i.a();
        this.f14384f.N();
        return true;
    }

    public final void C() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, d.a.k0.d3.d0.a.a(TbConfig.HOT_THREAD_UNLIKE, 307007));
        tbHttpMessageTask.setResponsedClass(UnlikeHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public final void D() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(307007);
        socketMessageTask.g(true);
        socketMessageTask.setResponsedClass(UnlikeSocketReponse.class);
        socketMessageTask.h(false);
        MessageManager.getInstance().registerTask(socketMessageTask);
    }

    public final void E(boolean z) {
        d.a.j0.g0.c.b bVar;
        if (z) {
            bVar = new d.a.j0.g0.c.b(4097, null, null, null);
        } else {
            bVar = new d.a.j0.g0.c.b(4098, null, null, null);
        }
        bVar.i(getUniqueId());
        this.f14383e.getEventCenter().dispatchMvcEvent(bVar);
    }

    public final void F(long j) {
        d.a.j0.g0.c.b bVar = new d.a.j0.g0.c.b(4102, null, null, null);
        bVar.g(Long.valueOf(j));
        bVar.i(getUniqueId());
        this.f14383e.getEventCenter().dispatchMvcEvent(bVar);
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
    public void h(MvcSocketResponsedMessage<d.a.k0.y.a.d.b, ?> mvcSocketResponsedMessage, MvcSocketMessage<d.a.k0.y.a.d.a, d.a.k0.y.a.d.b> mvcSocketMessage, MvcNetMessage<d.a.k0.y.a.d.a, d.a.k0.y.a.d.b> mvcNetMessage) {
        d.a.k0.y.a.d.b bVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            bVar = null;
        } else {
            bVar = mvcSocketResponsedMessage.getData();
            r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        }
        if (r0 == null || bVar == null || !A(r0, bVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f14383e.onServerError(errorData);
            this.f14383e.getViewController().onServerError(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void l(MvcHttpResponsedMessage<d.a.k0.y.a.d.b> mvcHttpResponsedMessage, MvcHttpMessage<d.a.k0.y.a.d.a, d.a.k0.y.a.d.b> mvcHttpMessage, MvcNetMessage<d.a.k0.y.a.d.a, d.a.k0.y.a.d.b> mvcNetMessage) {
        d.a.k0.y.a.d.b bVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            bVar = null;
        } else {
            bVar = mvcHttpResponsedMessage.getData();
            r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        }
        if (r0 == null || bVar == null || !A(r0, bVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f14383e.onServerError(errorData);
            this.f14383e.getViewController().onServerError(errorData);
        }
    }

    public boolean w() {
        this.f14385g.H();
        return true;
    }

    public void x(Bundle bundle) {
        this.f14387i = new d.a.k0.y.a.d.a();
        ChosenPostModel chosenPostModel = new ChosenPostModel(this.f14383e.getPageContext(), this.f14387i);
        this.f14384f = chosenPostModel;
        chosenPostModel.V(this);
        ChosenPostCacheModel chosenPostCacheModel = new ChosenPostCacheModel(this.f14383e.getPageContext());
        this.f14385g = chosenPostCacheModel;
        chosenPostCacheModel.K(this.j);
    }

    public boolean y() {
        this.f14387i.a();
        this.f14384f.N();
        this.f14386h.f(true);
        this.f14386h.h(true);
        E(false);
        this.f14383e.getViewController().u(this.f14386h);
        return true;
    }

    public boolean z(d.a.j0.g0.c.b bVar) {
        if (bVar.b() == 4100) {
            this.f14384f.N();
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
}
