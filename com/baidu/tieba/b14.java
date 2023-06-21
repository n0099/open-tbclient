package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b14 extends c14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String q;
    public String r;
    public String s;
    public String t;

    @Override // com.baidu.tieba.c14
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b14(Context context, a14 a14Var) {
        super(context, a14Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, a14Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (a14) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = SpeedStatsUtils.UBC_VALUE_BANNER;
        this.r = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
        this.s = "MSSP,ANTI,NMON";
        this.t = "LP,DL";
    }

    @Override // com.baidu.tieba.c14
    public HashMap<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("act", this.t);
            hashMap.put("prod", this.q);
            hashMap.put("at", this.r);
            hashMap.put("fet", this.s);
            if (this.i != null) {
                hashMap.put("w", "" + this.i.d());
                hashMap.put("h", "" + this.i.a());
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
