package com.baidu.tbadk.coreExtra.message;

import c.a.d.f.p.k;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f41555b;

        /* renamed from: c  reason: collision with root package name */
        public String f41556c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f41557d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41558e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f41559f;

        /* renamed from: g  reason: collision with root package name */
        public HttpResponse f41560g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f41561h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f41562i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f41563j;

        /* renamed from: k  reason: collision with root package name */
        public String f41564k;
        public BlockPopInfoData l;
        public int m;

        public a() {
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
            this.f41558e = false;
            this.f41559f = false;
            this.m = 0;
        }

        public final void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f41564k = jSONObject.optString("block_dealurl");
            String optString = jSONObject.optString("block_content");
            String optString2 = jSONObject.optString("block_confirm");
            String optString3 = jSONObject.optString("block_cancel");
            if (k.isEmpty(optString) || k.isEmpty(this.f41564k) || k.isEmpty(optString2) || k.isEmpty(optString3)) {
                return;
            }
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            this.l = blockPopInfoData;
            blockPopInfoData.block_info = optString;
            blockPopInfoData.ahead_url = this.f41564k;
            blockPopInfoData.ahead_info = optString2;
            blockPopInfoData.ok_info = optString3;
        }

        public void b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) || str == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f41561h = jSONObject;
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject == null) {
                    return;
                }
                this.m = jSONObject.optInt("status");
                if (optJSONObject.optInt("is_toast", 0) == 1) {
                }
                optJSONObject.optString("toast_text");
                a(optJSONObject);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (getData() == null || !(getData() instanceof a)) {
                return false;
            }
            return getData().f41557d;
        }
        return invokeV.booleanValue;
    }

    public boolean isGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getData() == null || !(getData() instanceof a)) {
                return false;
            }
            return getData().f41559f;
        }
        return invokeV.booleanValue;
    }

    public boolean isSucc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getData() == null || !(getData() instanceof a)) {
                return false;
            }
            return getData().a;
        }
        return invokeV.booleanValue;
    }
}
