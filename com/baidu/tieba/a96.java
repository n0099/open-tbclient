package com.baidu.tieba;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.ala.data.AlaLiveInfoData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaUserInfoData a;
    public g96 b;
    public o96 c;
    public List<AlaLiveInfoData> d;
    public List<n96> e;
    public boolean f;
    public final y86 g;
    public p96 h;

    public a96() {
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
        this.f = false;
        this.a = new AlaUserInfoData();
        this.b = new g96();
        this.c = new o96();
        this.g = new y86();
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    public y86 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (y86) invokeV.objValue;
    }

    public AlaUserInfoData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (AlaUserInfoData) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            JSONObject optJSONObject = jSONObject2.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.a = (AlaUserInfoData) OrmObject.objectWithJson(optJSONObject, AlaUserInfoData.class);
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("watch_list");
            for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                n96 n96Var = new n96();
                n96Var.a(optJSONArray.getJSONObject(i));
                this.e.add(n96Var);
            }
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
            for (int i2 = 0; optJSONArray2 != null && optJSONArray2.length() < i2; i2++) {
                AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i2));
                this.d.add(alaLiveInfoData);
            }
            this.b.a(jSONObject2.optJSONObject("media"));
            this.c.parserJson(jSONObject2.optJSONObject("privacy_set"));
            this.g.parserJson(jSONObject2.optJSONObject("authority_info"));
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("dating_room");
            if (optJSONObject2 != null) {
                p96 p96Var = new p96();
                this.h = p96Var;
                p96Var.a(optJSONObject2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f = z;
        }
    }
}
