package com.baidu.tbadk.img;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.p45;
import com.repackage.wl4;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class GetEmotionInfosModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public final HttpMessageListener b;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GetEmotionInfosModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GetEmotionInfosModel getEmotionInfosModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {getEmotionInfosModel, Integer.valueOf(i)};
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
            this.a = getEmotionInfosModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003353 && (httpResponsedMessage instanceof GetEmotionInfosResponseMessage) && this.a.a != null) {
                GetEmotionInfosResponseMessage getEmotionInfosResponseMessage = (GetEmotionInfosResponseMessage) httpResponsedMessage;
                if (getEmotionInfosResponseMessage.getEmotionList() != null) {
                    this.a.a.onSuccess(getEmotionInfosResponseMessage.getEmotionList());
                } else {
                    this.a.a.onFail(getEmotionInfosResponseMessage.getError(), getEmotionInfosResponseMessage.getErrorString());
                }
                this.a.a = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onFail(int i, String str);

        void onSuccess(List<p45> list);
    }

    public GetEmotionInfosModel() {
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
        this.b = new a(this, CmdConfigHttp.CMD_GET_EMOTION_INFOS);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.b.setTag(getUniqueId());
        this.b.setSelfListener(true);
        registerListener(this.b);
    }

    public void C(List<String> list, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, bVar) == null) {
            this.a = bVar;
            if (list == null || list.isEmpty()) {
                if (bVar != null) {
                    bVar.onFail(0, "list is empty");
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_INFOS);
            httpMessage.addParam("pic_urls", wl4.q(jSONArray.toString()));
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.b);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_EMOTION_INFOS);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_INFOS, TbConfig.SERVER_ADDRESS + "c/e/meme/pic2idJson");
            tbHttpMessageTask.setResponsedClass(GetEmotionInfosResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
