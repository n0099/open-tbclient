package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import com.baidu.tieba.ei;
import com.baidu.tieba.fe5;
import com.baidu.tieba.hu6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<UpdateAttentionData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class UpdateAttentionData {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int EACH_ATTENTION = 2;
        public static final int NOT_ATTENTION = 0;
        public static final int SINGLE_ATTENTION = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public BlockPopInfoData blockData;
        public String blockUrl;
        public String errorString;
        public boolean hasShownForbiddenAlert;
        public boolean interceptToast;
        public boolean isAttention;
        public boolean isFromLive;
        public boolean isGod;
        public boolean isShowMessage;
        public boolean isSucc;
        public HttpResponse response;
        public JSONObject resultJson;
        public String showMsg;
        public int status;
        public String toUid;

        public UpdateAttentionData() {
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
            this.isFromLive = false;
            this.isGod = false;
            this.isShowMessage = false;
            this.status = 0;
        }

        private void parseBlockAnti(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65537, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.blockUrl = jSONObject.optString("block_dealurl");
            String optString = jSONObject.optString("block_content");
            String optString2 = jSONObject.optString("block_confirm");
            String optString3 = jSONObject.optString("block_cancel");
            if (!ei.isEmpty(optString) && !ei.isEmpty(this.blockUrl) && !ei.isEmpty(optString2) && !ei.isEmpty(optString3)) {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                this.blockData = blockPopInfoData;
                blockPopInfoData.block_info = optString;
                blockPopInfoData.ahead_url = this.blockUrl;
                blockPopInfoData.ahead_info = optString2;
                blockPopInfoData.ok_info = optString3;
            }
        }

        public void parserJson(String str, boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, str, z) != null) || str == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.resultJson = jSONObject;
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject == null) {
                    return;
                }
                this.status = jSONObject.optInt("status");
                boolean z3 = false;
                if (optJSONObject.optInt("is_toast", 0) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    z3 = true;
                }
                this.isShowMessage = z3;
                this.showMsg = optJSONObject.optString("toast_text");
                parseBlockAnti(optJSONObject);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionData data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                hu6.b().b(new fe5(data));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2016229152, "Lcom/baidu/tbadk/coreExtra/message/UpdateAttentionMessage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2016229152, "Lcom/baidu/tbadk/coreExtra/message/UpdateAttentionMessage;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2001115));
    }

    public boolean isAttention() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getData() != null && (getData() instanceof UpdateAttentionData)) {
                return getData().isAttention;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getData() != null && (getData() instanceof UpdateAttentionData)) {
                return getData().isGod;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSucc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getData() != null && (getData() instanceof UpdateAttentionData)) {
                return getData().isSucc;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateAttentionMessage(UpdateAttentionData updateAttentionData) {
        super(2001115, updateAttentionData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {updateAttentionData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
