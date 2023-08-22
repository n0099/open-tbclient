package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.a29;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cc5 implements a29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public String o;
    public a29.a p;
    public int q;
    public String r;

    public cc5() {
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

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !"0".equals(this.r);
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return PraiseUBCHelper.SOURCE_DYNAMIC.equals(this.e);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a29
    public a29.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.p;
        }
        return (a29.a) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (StringUtils.isNull(this.a) && StringUtils.isNull(this.j) && StringUtils.isNull(this.l)) {
                return true;
            }
            if (c()) {
                if (StringUtils.isNull(this.c) || StringUtils.isNull(this.d)) {
                    return true;
                }
                return false;
            }
            return StringUtils.isNull(this.b);
        }
        return invokeV.booleanValue;
    }

    public final JSONArray d(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void e(JSONObject jSONObject) {
        String lowerCase;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("url");
        this.b = jSONObject.optString("icon_url");
        this.c = jSONObject.optString("fold_lottie");
        this.d = jSONObject.optString("unfold_lottie");
        this.e = jSONObject.optString("float_type");
        jSONObject.optString("fold_name");
        jSONObject.optString("unfold_name");
        this.h = jSONObject.optString("view_statistics_url");
        this.i = jSONObject.optString("click_statistics_url");
        this.j = jSONObject.optString("scheme");
        this.k = jSONObject.optString("package_name");
        this.l = jSONObject.optString(InvokeStatisticKt.SCHEME_INVOKE_PAGE_DEEPLINK);
        this.n = jSONObject.optInt("source", 1);
        this.m = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
        this.o = jSONObject.optString(LegoListActivityConfig.AD_ID);
        this.r = jSONObject.optString("display_ad_icon");
        a29.a aVar = new a29.a();
        this.p = aVar;
        aVar.a = jSONObject.optString("parallel_charge_url");
        this.p.c = f(d(jSONObject, "show_urls"));
        this.p.d = f(d(jSONObject, "click_urls"));
        String c = ji.c(TbadkApplication.getInst().getAndroidId());
        String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
        StringBuilder sb = new StringBuilder();
        sb.append("&ANDROIDID=");
        String str = "";
        if (c == null) {
            lowerCase = "";
        } else {
            lowerCase = c.toLowerCase();
        }
        sb.append(lowerCase);
        sb.append("&OAID=");
        if (lastCachedOid != null) {
            str = lastCachedOid.toUpperCase();
        }
        sb.append(str);
        String sb2 = sb.toString();
        if (!StringUtils.isNull(this.h)) {
            this.h += sb2;
        }
        if (!StringUtils.isNull(this.i)) {
            this.i += sb2;
        }
    }

    public final ArrayList<String> f(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONArray)) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                ArrayList<String> arrayList = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("url");
                        if (!StringUtils.isNull(optString)) {
                            arrayList.add(optString);
                        }
                    }
                }
                return arrayList;
            }
            return new ArrayList<>();
        }
        return (ArrayList) invokeL.objValue;
    }
}
