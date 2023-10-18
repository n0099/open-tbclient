package com.baidu.tbadk.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/baidu/tbadk/data/JSONLikeSerializable;", "Ljava/io/Serializable;", "()V", "isJsonArray", "", "()Z", "setJsonArray", "(Z)V", "jsonString", "", "getJsonString", "()Ljava/lang/String;", "setJsonString", "(Ljava/lang/String;)V", "parseJsonArray", "", "jsonArray", "Lorg/json/JSONArray;", "parseJsonObject", "jsonObject", "Lorg/json/JSONObject;", "toJsonArray", "toJsonObject", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JSONLikeSerializable implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isJsonArray;
    public String jsonString;

    public JSONLikeSerializable() {
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

    public final String getJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.jsonString;
        }
        return (String) invokeV.objValue;
    }

    public final boolean isJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.isJsonArray;
        }
        return invokeV.booleanValue;
    }

    public final JSONArray toJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = this.jsonString;
            if (str != null) {
                return new JSONArray(str);
            }
            return null;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final JSONObject toJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = this.jsonString;
            if (str != null) {
                return new JSONObject(str);
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void parseJsonArray(JSONArray jsonArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsonArray) == null) {
            Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
            this.jsonString = jsonArray.toString();
            this.isJsonArray = true;
        }
    }

    public final void parseJsonObject(JSONObject jsonObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsonObject) == null) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            this.jsonString = jsonObject.toString();
            this.isJsonArray = false;
        }
    }

    public final void setJsonArray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.isJsonArray = z;
        }
    }

    public final void setJsonString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.jsonString = str;
        }
    }
}
