package com.baidu.tieba.faceshop;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ax4;
import com.baidu.tieba.ke9;
import com.baidu.tieba.newfaceshop.FaceBaseModel;
import com.baidu.tieba.r47;
import com.baidu.tieba.vu6;
import com.baidu.tieba.ym5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class UserCollectModel extends FaceBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALL_DELETE = "all_delete";
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpMessageListener a;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserCollectModel a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.a.a.cancelLoadData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(UserCollectModel userCollectModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userCollectModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003339 && (httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                try {
                    ke9.u(((Long) ((HttpMessage) ((JsonHttpResponsedMessage) httpResponsedMessage).getOrginalMessage()).getParams().get("pic_update_time")).longValue());
                } catch (Exception e) {
                    BdLog.e(e);
                }
                new Handler().postDelayed(new a(this), 2000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserCollectModel a;

        public a(UserCollectModel userCollectModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userCollectModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<CollectEmotionData> q = r47.o().q(TbadkCoreApplication.getCurrentAccountForEmotion());
                HashSet hashSet = new HashSet();
                if (q == null) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                try {
                    for (CollectEmotionData collectEmotionData : q) {
                        if (!ym5.f.equals(collectEmotionData.getSharpText()) && !hashSet.contains(collectEmotionData.getSharpText())) {
                            jSONArray.put(collectEmotionData.toJSON());
                            hashSet.add(collectEmotionData.getSharpText());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                long currentTimeMillis = System.currentTimeMillis();
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO);
                if (jSONArray.length() > 0) {
                    httpMessage.addParam(SocialConstants.PARAM_IMAGE, ax4.t(jSONArray.toString()));
                } else {
                    httpMessage.addParam(SocialConstants.PARAM_IMAGE, "all_delete");
                }
                httpMessage.addParam("pic_update_time", currentTimeMillis);
                this.a.sendMessage(httpMessage);
            }
        }
    }

    public UserCollectModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new b(this, CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.a.setTag(getUniqueId());
        this.a.setSelfListener(true);
        registerListener(this.a);
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            vu6.a(new a(this), "UserCollect", 1);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.a);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO, TbConfig.SERVER_ADDRESS + "c/e/meme/collect");
            tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
