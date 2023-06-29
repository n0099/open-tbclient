package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public String c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public String h;
        public BlockPopInfoData i;
        public int j;

        public a() {
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
            this.e = false;
            this.f = false;
            this.j = 0;
        }

        public final void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.h = jSONObject.optString("block_dealurl");
            String optString = jSONObject.optString("block_content");
            String optString2 = jSONObject.optString("block_confirm");
            String optString3 = jSONObject.optString("block_cancel");
            if (!wi.isEmpty(optString) && !wi.isEmpty(this.h) && !wi.isEmpty(optString2) && !wi.isEmpty(optString3)) {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                this.i = blockPopInfoData;
                blockPopInfoData.block_info = optString;
                blockPopInfoData.ahead_url = this.h;
                blockPopInfoData.ahead_info = optString2;
                blockPopInfoData.ok_info = optString3;
            }
        }

        public void b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) != null) || str == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject == null) {
                    return;
                }
                this.j = jSONObject.optInt("status");
                if (optJSONObject.optInt("is_toast", 0) == 1) {
                }
                optJSONObject.optString("toast_text");
                a(optJSONObject);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateAttentionMessage(a aVar) {
        super(2001115, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean isAttention() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getData() != null && (getData() instanceof a)) {
                return getData().d;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getData() != null && (getData() instanceof a)) {
                return getData().f;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSucc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getData() != null && (getData() instanceof a)) {
                return getData().a;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
