package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
@Service
/* loaded from: classes6.dex */
public final class fl0 extends re0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.re0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "rewardWebPanel" : (String) invokeV.objValue;
    }

    public fl0() {
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

    @Override // com.baidu.tieba.re0
    public boolean b(Context context, ve0 schemeModel, Map<String, Object> map, ze0 ze0Var) {
        InterceptResult invokeLLLL;
        String str;
        double d;
        int i;
        String str2;
        int i2;
        boolean z;
        long j;
        int i3;
        int i4;
        boolean z2;
        Integer intOrNull;
        Integer intOrNull2;
        Double doubleOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, schemeModel, map, ze0Var)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(schemeModel, "schemeModel");
            super.b(context, schemeModel, map, ze0Var);
            HashMap<String, String> d2 = schemeModel.d();
            Intrinsics.checkNotNullExpressionValue(d2, "schemeModel.params");
            String str3 = d2.get("url");
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            Intrinsics.checkNotNullExpressionValue(str, "params[\"url\"] ?: \"\"");
            String str4 = d2.get("height_ratio");
            if (str4 != null && (doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(str4)) != null) {
                d = doubleOrNull.doubleValue();
            } else {
                d = 0.7d;
            }
            String str5 = d2.get("height_calculate_mode");
            boolean z3 = false;
            if (str5 != null && (intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str5)) != null) {
                i = intOrNull2.intValue();
            } else {
                i = 0;
            }
            String str6 = d2.get(MigrateStatisticUtils.EXT_INFO);
            if (str6 == null) {
                str2 = "";
            } else {
                str2 = str6;
            }
            Intrinsics.checkNotNullExpressionValue(str2, "params[\"ext_info\"] ?: \"\"");
            p41 p41Var = new p41(str, d, i, str2);
            String str7 = d2.get("log_switch");
            if (str7 != null) {
                StringBuilder sb = new StringBuilder();
                int length = str7.length();
                for (int i5 = 0; i5 < length; i5++) {
                    char charAt = str7.charAt(i5);
                    if (!StringsKt__StringsJVMKt.isBlank(String.valueOf(charAt))) {
                        sb.append(charAt);
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
                if (sb2 != null) {
                    p41Var.J(sb2);
                }
            }
            String str8 = d2.get("top_blank_click_disable");
            if (str8 != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str8)) != null) {
                i2 = intOrNull.intValue();
            } else {
                i2 = 0;
            }
            if (i2 == 1) {
                z = true;
            } else {
                z = false;
            }
            p41Var.S(z);
            String str9 = d2.get("panel_control");
            if (str9 != null) {
                StringBuilder sb3 = new StringBuilder();
                int length2 = str9.length();
                for (int i6 = 0; i6 < length2; i6++) {
                    char charAt2 = str9.charAt(i6);
                    if (!StringsKt__StringsJVMKt.isBlank(String.valueOf(charAt2))) {
                        sb3.append(charAt2);
                    }
                }
                String sb4 = sb3.toString();
                Intrinsics.checkNotNullExpressionValue(sb4, "filterTo(StringBuilder(), predicate).toString()");
                if (sb4 != null) {
                    p41Var.M(sb4);
                }
            }
            String str10 = d2.get("lp_real_url");
            if (str10 != null) {
                p41Var.L(str10);
            }
            String it = d2.get("support_full_screen");
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Integer intOrNull3 = StringsKt__StringNumberConversionsKt.toIntOrNull(it);
                if (intOrNull3 != null) {
                    i4 = intOrNull3.intValue();
                } else {
                    i4 = 1;
                }
                if (i4 == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                p41Var.H(z2);
            }
            String str11 = d2.get("charge_url");
            if (str11 != null) {
                p41Var.E(str11);
            }
            String str12 = d2.get("lp_org_type");
            if (str12 != null) {
                p41Var.K(str12);
            }
            String str13 = d2.get("ad_invoke_flag");
            if (str13 != null) {
                p41Var.B(str13);
            }
            String str14 = d2.get("sdk_script");
            if (str14 != null) {
                p41Var.P(str14);
            }
            String it2 = d2.get("enable_outer_back");
            if (it2 != null) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Integer intOrNull4 = StringsKt__StringNumberConversionsKt.toIntOrNull(it2);
                if (intOrNull4 != null) {
                    i3 = intOrNull4.intValue();
                } else {
                    i3 = 0;
                }
                if (i3 == 0) {
                    z3 = true;
                }
                p41Var.N(z3);
            }
            String str15 = d2.get("auto_pop");
            if (str15 != null) {
                p41Var.C(Intrinsics.areEqual(str15, "1"));
            }
            String it3 = d2.get("charge_delay_time");
            if (it3 != null) {
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                Long longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(it3);
                if (longOrNull != null) {
                    j = longOrNull.longValue();
                } else {
                    j = -1;
                }
                p41Var.D(j);
            }
            ml0.e.d(context, p41Var);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
