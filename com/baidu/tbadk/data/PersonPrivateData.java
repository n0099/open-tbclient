package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes3.dex */
public class PersonPrivateData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public PersonPrivateData() {
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
        this.a = 1;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public void H(PrivSets privSets) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, privSets) != null) || privSets == null) {
            return;
        }
        try {
            privSets.location.intValue();
            this.a = privSets.like.intValue();
            privSets.group.intValue();
            privSets.post.intValue();
            privSets.friend.intValue();
            privSets.live.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        jSONObject.optInt("location", 1);
        this.a = jSONObject.optInt("like", 1);
        jSONObject.optInt("group", 1);
        jSONObject.optInt("post", 1);
        jSONObject.optInt("friend", 1);
        jSONObject.optInt("live", 1);
    }
}
