package com.baidu.tieba.faceshop;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class EmotionPackageDetailModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f50164e;

    /* renamed from: f  reason: collision with root package name */
    public e f50165f;

    /* renamed from: g  reason: collision with root package name */
    public final HttpMessageListener f50166g;

    /* renamed from: h  reason: collision with root package name */
    public final HttpMessageListener f50167h;

    /* renamed from: i  reason: collision with root package name */
    public final HttpMessageListener f50168i;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailModel f50169a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EmotionPackageDetailModel emotionPackageDetailModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50169a = emotionPackageDetailModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003346 && (httpResponsedMessage instanceof PackageDetailResponseMessage) && this.f50169a.mLoadDataCallBack != null) {
                PackageDetailResponseMessage packageDetailResponseMessage = (PackageDetailResponseMessage) httpResponsedMessage;
                if (this.f50169a.mLoadDataCallBack != null) {
                    this.f50169a.mLoadDataCallBack.c(packageDetailResponseMessage.data);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailModel f50170a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionPackageDetailModel emotionPackageDetailModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50170a = emotionPackageDetailModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003347 || this.f50170a.f50164e == null) {
                return;
            }
            if (httpResponsedMessage.getError() == 0) {
                this.f50170a.f50164e.onResult(true);
            } else {
                this.f50170a.f50164e.onResult(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailModel f50171a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EmotionPackageDetailModel emotionPackageDetailModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50171a = emotionPackageDetailModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003358 || this.f50171a.f50165f == null) {
                return;
            }
            this.f50171a.f50165f.a(httpResponsedMessage);
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void onResult(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(HttpResponsedMessage httpResponsedMessage);
    }

    public EmotionPackageDetailModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50166g = new a(this, CmdConfigHttp.CMD_EMOTION_PACKAGE_DETAIL);
        this.f50167h = new b(this, CmdConfigHttp.CMD_DELETE_EMOTION_PACKAGE);
        this.f50168i = new c(this, CmdConfigHttp.CMD_VOTE_EMOTION);
        setUniqueId(BdUniqueId.gen());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_EMOTION_PACKAGE_DETAIL, TbConfig.SERVER_ADDRESS + TbConfig.GET_NEW_PACKAGE_DETAIL);
        tbHttpMessageTask.setResponsedClass(PackageDetailResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_DELETE_EMOTION_PACKAGE, TbConfig.SERVER_ADDRESS + TbConfig.DELETE_EMOTION_PACKAGE);
        tbHttpMessageTask2.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(CmdConfigHttp.CMD_VOTE_EMOTION, TbConfig.SERVER_ADDRESS + TbConfig.VOTE_EMOTION_PACKAGE);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        this.f50166g.setTag(getUniqueId());
        this.f50166g.setSelfListener(true);
        registerListener(this.f50166g);
        registerListener(this.f50167h);
        registerListener(this.f50168i);
    }

    public void B(int i2, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, dVar) == null) || i2 < 0) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_EMOTION_PACKAGE);
        httpMessage.addParam("package_id", i2);
        sendMessage(httpMessage);
        this.f50164e = dVar;
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 < 0) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_EMOTION_PACKAGE_DETAIL);
        httpMessage.addParam("id", i2);
        sendMessage(httpMessage);
    }

    public void D(int i2, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, eVar) == null) || i2 < 0) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VOTE_EMOTION);
        httpMessage.addParam(IntentConfig.PKG_ID, i2);
        sendMessage(httpMessage);
        this.f50165f = eVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.f50166g);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_EMOTION_PACKAGE_DETAIL);
            MessageManager.getInstance().unRegisterListener(this.f50167h);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_DELETE_EMOTION_PACKAGE);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VOTE_EMOTION);
            MessageManager.getInstance().unRegisterListener(this.f50168i);
            return true;
        }
        return invokeV.booleanValue;
    }
}
