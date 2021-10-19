package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class ChosenPostModelController extends BdBaseModel<ChosenPostActivity> implements NetModel.k<c.a.r0.c0.a.d.a, c.a.r0.c0.a.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ChosenPostActivity f50059e;

    /* renamed from: f  reason: collision with root package name */
    public ChosenPostModel f50060f;

    /* renamed from: g  reason: collision with root package name */
    public ChosenPostCacheModel f50061g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.k0.d.a f50062h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.c0.a.d.a f50063i;

    /* renamed from: j  reason: collision with root package name */
    public CacheModel.c<c.a.r0.c0.a.d.b> f50064j;
    public c.a.e.c.g.a k;

    /* loaded from: classes7.dex */
    public class a implements CacheModel.c<c.a.r0.c0.a.d.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChosenPostModelController f50065e;

        public a(ChosenPostModelController chosenPostModelController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chosenPostModelController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50065e = chosenPostModelController;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataGet(ReadCacheRespMsg<List<c.a.r0.c0.a.d.b>> readCacheRespMsg, ReadCacheMessage<c.a.r0.c0.a.d.b> readCacheMessage) {
            c.a.r0.c0.a.d.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, readCacheRespMsg, readCacheMessage) == null) {
                List<c.a.r0.c0.a.d.b> data = readCacheRespMsg.getData();
                if (data != null && !data.isEmpty() && (bVar = data.get(0)) != null) {
                    c.a.q0.k0.c.b bVar2 = new c.a.q0.k0.c.b(4099, bVar, null, null);
                    bVar2.i(this.f50065e.getUniqueId());
                    this.f50065e.f50059e.getEventCenter().dispatchMvcEvent(bVar2);
                }
                this.f50065e.f50063i.a();
                this.f50065e.f50060f.loadData();
            }
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataWrite(WriteCacheRespMsg<List<c.a.r0.c0.a.d.b>> writeCacheRespMsg, WriteCacheMessage<c.a.r0.c0.a.d.b> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeCacheRespMsg, writeCacheMessage) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChosenPostModelController f50066a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ChosenPostModelController chosenPostModelController, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chosenPostModelController, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50066a = chosenPostModelController;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getError() != 0) {
                BdToast d2 = BdToast.d(this.f50066a.f50059e.getActivity(), responsedMessage.getErrorString(), 0);
                d2.a();
                d2.q();
            } else if (responsedMessage instanceof UnlikeHttpResponse) {
                this.f50066a.J(((UnlikeHttpResponse) responsedMessage).getThreadId());
            } else if (responsedMessage instanceof UnlikeSocketReponse) {
                this.f50066a.J(((UnlikeSocketReponse) responsedMessage).getThreadId());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChosenPostModelController(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chosenPostActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50062h = new c.a.q0.k0.d.a();
        this.f50064j = new a(this);
        this.k = new b(this, CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, 307007);
        this.f50059e = chosenPostActivity;
        G();
        H();
        registerListener(this.k);
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f50061g.L();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void B(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.f50063i = new c.a.r0.c0.a.d.a();
            ChosenPostModel chosenPostModel = new ChosenPostModel(this.f50059e.getPageContext(), this.f50063i);
            this.f50060f = chosenPostModel;
            chosenPostModel.Y(this);
            ChosenPostCacheModel chosenPostCacheModel = new ChosenPostCacheModel(this.f50059e.getPageContext());
            this.f50061g = chosenPostCacheModel;
            chosenPostCacheModel.O(this.f50064j);
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f50063i.a();
            this.f50060f.loadData();
            this.f50062h.f(true);
            this.f50062h.h(true);
            I(false);
            this.f50059e.getViewController().s(this.f50062h);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean D(c.a.q0.k0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            if (bVar.b() == 4100) {
                this.f50060f.loadData();
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
        return invokeL.booleanValue;
    }

    public boolean E(c.a.r0.c0.a.d.a aVar, c.a.r0.c0.a.d.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, aVar, bVar)) == null) {
            this.f50059e.getViewController().r(bVar);
            if (bVar != null) {
                this.f50062h.g(false);
                this.f50062h.f(false);
                this.f50059e.getViewController().s(this.f50062h);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean F(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f50062h.g(true);
            this.f50059e.getViewController().s(this.f50062h);
            I(true);
            this.f50063i.a();
            this.f50060f.loadData();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, c.a.r0.k3.e0.a.a(TbConfig.HOT_THREAD_UNLIKE, 307007));
            tbHttpMessageTask.setResponsedClass(UnlikeHttpResponse.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SocketMessageTask socketMessageTask = new SocketMessageTask(307007);
            socketMessageTask.g(true);
            socketMessageTask.setResponsedClass(UnlikeSocketReponse.class);
            socketMessageTask.h(false);
            MessageManager.getInstance().registerTask(socketMessageTask);
        }
    }

    public final void I(boolean z) {
        c.a.q0.k0.c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                bVar = new c.a.q0.k0.c.b(4097, null, null, null);
            } else {
                bVar = new c.a.q0.k0.c.b(4098, null, null, null);
            }
            bVar.i(getUniqueId());
            this.f50059e.getEventCenter().dispatchMvcEvent(bVar);
        }
    }

    public final void J(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            c.a.q0.k0.c.b bVar = new c.a.q0.k0.c.b(4102, null, null, null);
            bVar.g(Long.valueOf(j2));
            bVar.i(getUniqueId());
            this.f50059e.getEventCenter().dispatchMvcEvent(bVar);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage<c.a.r0.c0.a.d.b, ?> mvcSocketResponsedMessage, MvcSocketMessage<c.a.r0.c0.a.d.a, c.a.r0.c0.a.d.b> mvcSocketMessage, MvcNetMessage<c.a.r0.c0.a.d.a, c.a.r0.c0.a.d.b> mvcNetMessage) {
        c.a.r0.c0.a.d.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
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
                this.f50059e.onServerError(errorData);
                this.f50059e.getViewController().onServerError(errorData);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage<c.a.r0.c0.a.d.b> mvcHttpResponsedMessage, MvcHttpMessage<c.a.r0.c0.a.d.a, c.a.r0.c0.a.d.b> mvcHttpMessage, MvcNetMessage<c.a.r0.c0.a.d.a, c.a.r0.c0.a.d.b> mvcNetMessage) {
        c.a.r0.c0.a.d.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                this.f50059e.onServerError(errorData);
                this.f50059e.getViewController().onServerError(errorData);
            }
        }
    }
}
