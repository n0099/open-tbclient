package com.baidu.tieba;

import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
@Service
/* loaded from: classes5.dex */
public final class e59 implements re5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e59() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0027 A[Catch: Exception -> 0x0031, TRY_LEAVE, TryCatch #0 {Exception -> 0x0031, blocks: (B:5:0x0009, B:7:0x0011, B:10:0x001b, B:16:0x0027), top: B:26:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c A[ORIG_RETURN, RETURN] */
    @Override // com.baidu.tieba.re5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseJson(JSONObject json) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONObject optJSONObject = json.optJSONObject("member_info");
                if (optJSONObject != null) {
                    str = optJSONObject.optString("member_recharge");
                } else {
                    str = null;
                }
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                    if (z) {
                        SharedPrefHelper.getInstance().putString(PayPanelUtils.KEY_PAY_PANEL_URL, str);
                        return;
                    }
                    return;
                }
                z = true;
                if (z) {
                }
            } catch (Exception e) {
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return;
                }
                throw e;
            }
        }
    }
}
