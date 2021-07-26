package com.baidu.tieba.faceshop;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.newfaceshop.FaceBaseModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import d.a.p0.b0.d;
import d.a.p0.m.c;
import d.a.q0.p0.g;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class UserCollectModel extends FaceBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALL_DELETE = "all_delete";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f15079e;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserCollectModel f15080e;

        public a(UserCollectModel userCollectModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15080e = userCollectModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<CollectEmotionData> n = g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
                HashSet hashSet = new HashSet();
                if (n == null) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                try {
                    for (CollectEmotionData collectEmotionData : n) {
                        if (!d.f52028d.equals(collectEmotionData.sharpText) && !hashSet.contains(collectEmotionData.sharpText)) {
                            jSONArray.put(collectEmotionData.toJSON());
                            hashSet.add(collectEmotionData.sharpText);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                long currentTimeMillis = System.currentTimeMillis();
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO);
                if (jSONArray.length() > 0) {
                    httpMessage.addParam(SocialConstants.PARAM_IMAGE, c.o(jSONArray.toString()));
                } else {
                    httpMessage.addParam(SocialConstants.PARAM_IMAGE, UserCollectModel.ALL_DELETE);
                }
                httpMessage.addParam("pic_update_time", currentTimeMillis);
                this.f15080e.sendMessage(httpMessage);
                d.a.q0.c2.d.s(currentTimeMillis);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserCollectModel f15081a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f15082e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15082e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f15082e.f15081a.cancelLoadData();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(UserCollectModel userCollectModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectModel, Integer.valueOf(i2)};
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
            this.f15081a = userCollectModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003339 && (httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                new Handler().postDelayed(new a(this), 2000L);
            }
        }
    }

    public UserCollectModel() {
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
        this.f15079e = new b(this, CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f15079e.setTag(getUniqueId());
        this.f15079e.setSelfListener(true);
        registerListener(this.f15079e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.f15079e);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO, TbConfig.SERVER_ADDRESS + "c/e/meme/collect");
            tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            new Thread(new a(this)).start();
        }
    }
}
