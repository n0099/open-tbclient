package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class dc5 implements Cdo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public String f;
    public String g;
    public List<cc5> h;
    public String i;
    public boolean j;
    public int k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947699763, "Lcom/baidu/tieba/dc5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947699763, "Lcom/baidu/tieba/dc5;");
                return;
            }
        }
        l = BdUniqueId.gen();
    }

    public dc5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.Cdo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return l;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("user_id");
        this.b = jSONObject.optString("name_show");
        this.c = jSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
        this.d = jSONObject.optInt("user_gender");
        this.e = jSONObject.optInt("user_age", 0);
        this.f = jSONObject.optString("user_constellation");
        this.g = jSONObject.optString("distance");
        JSONArray optJSONArray = jSONObject.optJSONArray("favorite_forum_list");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            this.h = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                cc5 cc5Var = new cc5();
                cc5Var.a(optJSONArray.optJSONObject(i));
                this.h.add(cc5Var);
            }
        }
        this.i = jSONObject.optString("user_slogan");
        boolean z = true;
        if (jSONObject.optInt("is_friend", 0) != 1) {
            z = false;
        }
        this.j = z;
        this.k = jSONObject.optInt("active_status", 0);
    }
}
