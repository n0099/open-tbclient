package com.baidu.tieba.ad.asyncpv;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes12.dex */
public class AdAsyncRequestModel {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<PlaceId, String> f41703d;
    public transient /* synthetic */ FieldHolder $fh;
    public final PlaceId a;

    /* renamed from: b  reason: collision with root package name */
    public final b f41704b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f41705c;

    /* loaded from: classes12.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdAsyncRequestModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AdAsyncRequestModel adAsyncRequestModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adAsyncRequestModel, Integer.valueOf(i2)};
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
            this.a = adAsyncRequestModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof AdAsyncResponseData) && httpResponsedMessage.getCmd() == 1003491) {
                AdAsyncResponseData adAsyncResponseData = (AdAsyncResponseData) httpResponsedMessage;
                Message<?> orginalMessage = adAsyncResponseData.getOrginalMessage();
                if (orginalMessage instanceof AdAsyncRequestData) {
                    if (!TextUtils.equals(this.a.a.value, (String) ((AdAsyncRequestData) orginalMessage).getParams().get("pid"))) {
                        return;
                    }
                }
                if (this.a.f41704b != null) {
                    this.a.f41704b.a(adAsyncResponseData.isSuccess(), adAsyncResponseData.getAds());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a(boolean z, List<AdvertAppInfo> list);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-438019213, "Lcom/baidu/tieba/ad/asyncpv/AdAsyncRequestModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-438019213, "Lcom/baidu/tieba/ad/asyncpv/AdAsyncRequestModel;");
                return;
            }
        }
        f41703d = new HashMap<PlaceId, String>() { // from class: com.baidu.tieba.ad.asyncpv.AdAsyncRequestModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put(PlaceId.PIC_PAGE_BANNER, "picbanner");
                put(PlaceId.PIC_PAGE_INSERT, "picpage");
                put(PlaceId.VIDEO_FLOW, "videoflow");
            }
        };
    }

    public AdAsyncRequestModel(@NonNull b bVar, @NonNull PlaceId placeId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, placeId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41705c = new a(this, CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST);
        this.a = placeId;
        this.f41704b = bVar;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST, TbConfig.SERVER_ADDRESS + "tiebaads/commonbatch?adcmd=" + f41703d.get(placeId));
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsNeedAddStatisticsParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setmIsNBaiduServer(false);
        tbHttpMessageTask.setResponsedClass(AdAsyncResponseData.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.f41705c);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f41705c);
        }
    }

    public void d(Map<String, String> map, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, i2) == null) {
            MessageManager.getInstance().sendMessage(new AdAsyncRequestData(this.a, map, i2));
        }
    }
}
