package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.b9;
import com.repackage.hj8;
import com.repackage.i75;
import com.repackage.k75;
import com.repackage.wa;
import com.repackage.xy5;
import com.repackage.yy5;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class ChosenPostModelController extends BdBaseModel<ChosenPostActivity> implements NetModel.k<xy5, yy5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChosenPostActivity a;
    public ChosenPostModel b;
    public ChosenPostCacheModel c;
    public k75 d;
    public xy5 e;
    public CacheModel.c<yy5> f;
    public wa g;

    /* loaded from: classes3.dex */
    public class a implements CacheModel.c<yy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChosenPostModelController a;

        public a(ChosenPostModelController chosenPostModelController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chosenPostModelController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chosenPostModelController;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void e(WriteCacheRespMsg<List<yy5>> writeCacheRespMsg, WriteCacheMessage<yy5> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, writeCacheRespMsg, writeCacheMessage) == null) {
            }
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void g(ReadCacheRespMsg<List<yy5>> readCacheRespMsg, ReadCacheMessage<yy5> readCacheMessage) {
            yy5 yy5Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, readCacheRespMsg, readCacheMessage) == null) {
                List<yy5> data = readCacheRespMsg.getData();
                if (data != null && !data.isEmpty() && (yy5Var = data.get(0)) != null) {
                    i75 i75Var = new i75(4099, yy5Var, null, null);
                    i75Var.i(this.a.getUniqueId());
                    this.a.a.getEventCenter().dispatchMvcEvent(i75Var);
                }
                this.a.e.a();
                this.a.b.loadData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChosenPostModelController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ChosenPostModelController chosenPostModelController, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chosenPostModelController, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chosenPostModelController;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getError() != 0) {
                BdToast d = BdToast.d(this.a.a.getActivity(), responsedMessage.getErrorString(), 0);
                d.a();
                d.q();
            } else if (responsedMessage instanceof UnlikeHttpResponse) {
                this.a.K(((UnlikeHttpResponse) responsedMessage).getThreadId());
            } else if (responsedMessage instanceof UnlikeSocketReponse) {
                this.a.K(((UnlikeSocketReponse) responsedMessage).getThreadId());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new k75();
        this.f = new a(this);
        this.g = new b(this, CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, 307007);
        this.a = chosenPostActivity;
        registerHttpTask();
        I();
        registerListener(this.g);
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.c.N();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void D(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.e = new xy5();
            ChosenPostModel chosenPostModel = new ChosenPostModel(this.a.getPageContext(), this.e);
            this.b = chosenPostModel;
            chosenPostModel.a0(this);
            ChosenPostCacheModel chosenPostCacheModel = new ChosenPostCacheModel(this.a.getPageContext());
            this.c = chosenPostCacheModel;
            chosenPostCacheModel.Q(this.f);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.e.a();
            this.b.loadData();
            this.d.e(true);
            this.d.g(true);
            J(false);
            this.a.getViewController().w(this.d);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean F(i75 i75Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, i75Var)) == null) {
            if (i75Var.b() == 4100) {
                this.b.loadData();
                return false;
            } else if (i75Var.b() == 4101) {
                Object c = i75Var.c();
                if (c instanceof tinfo) {
                    tinfo tinfoVar = (tinfo) c;
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

    public boolean G(xy5 xy5Var, yy5 yy5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, xy5Var, yy5Var)) == null) {
            this.a.getViewController().v(yy5Var);
            if (yy5Var != null) {
                this.d.f(false);
                this.d.e(false);
                this.a.getViewController().w(this.d);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean H(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.d.f(true);
            this.a.getViewController().w(this.d);
            J(true);
            this.e.a();
            this.b.loadData();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SocketMessageTask socketMessageTask = new SocketMessageTask(307007);
            socketMessageTask.g(true);
            socketMessageTask.setResponsedClass(UnlikeSocketReponse.class);
            socketMessageTask.h(false);
            MessageManager.getInstance().registerTask(socketMessageTask);
        }
    }

    public final void J(boolean z) {
        i75 i75Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                i75Var = new i75(4097, null, null, null);
            } else {
                i75Var = new i75(4098, null, null, null);
            }
            i75Var.i(getUniqueId());
            this.a.getEventCenter().dispatchMvcEvent(i75Var);
        }
    }

    public final void K(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            i75 i75Var = new i75(4102, null, null, null);
            i75Var.g(Long.valueOf(j));
            i75Var.i(getUniqueId());
            this.a.getEventCenter().dispatchMvcEvent(i75Var);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage<yy5, ?> mvcSocketResponsedMessage, MvcSocketMessage<xy5, yy5> mvcSocketMessage, MvcNetMessage<xy5, yy5> mvcNetMessage) {
        yy5 yy5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
                yy5Var = null;
            } else {
                yy5Var = mvcSocketResponsedMessage.getData();
                r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r0 = mvcNetMessage.getRequestData();
                }
            }
            if (r0 == null || yy5Var == null || !G(r0, yy5Var)) {
                if (mvcSocketResponsedMessage != null) {
                    this.mErrorCode = mvcSocketResponsedMessage.getError();
                    this.mErrorString = mvcSocketResponsedMessage.getErrorString();
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                this.a.onServerError(errorData);
                this.a.getViewController().onServerError(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage<yy5> mvcHttpResponsedMessage, MvcHttpMessage<xy5, yy5> mvcHttpMessage, MvcNetMessage<xy5, yy5> mvcNetMessage) {
        yy5 yy5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
                yy5Var = null;
            } else {
                yy5Var = mvcHttpResponsedMessage.getData();
                r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r0 = mvcNetMessage.getRequestData();
                }
            }
            if (r0 == null || yy5Var == null || !G(r0, yy5Var)) {
                if (mvcHttpResponsedMessage != null) {
                    this.mErrorCode = mvcHttpResponsedMessage.getError();
                    this.mErrorString = mvcHttpResponsedMessage.getErrorString();
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                this.a.onServerError(errorData);
                this.a.getViewController().onServerError(errorData);
            }
        }
    }

    public final void registerHttpTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, hj8.a(TbConfig.HOT_THREAD_UNLIKE, 307007));
            tbHttpMessageTask.setResponsedClass(UnlikeHttpResponse.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }
}
