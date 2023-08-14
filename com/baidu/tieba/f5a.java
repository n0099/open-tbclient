package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f5a implements NetworkInfoRecord {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i5a a;
    public i5a b;

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "850" : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "94" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.statistics.NetworkInfoRecord
    public boolean shouldRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f5a() {
        this(new g5a(10, 100));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((i5a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public f5a(i5a i5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i5aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i5aVar;
        this.b = new h5a();
    }

    @Override // com.baidu.searchbox.http.statistics.NetworkInfoRecord
    public void doRecord(NetworkStatRecord networkStatRecord) {
        JSONObject uBCJson;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, networkStatRecord) == null) && networkStatRecord != null && (uBCJson = networkStatRecord.toUBCJson()) != null) {
            String jSONObject = uBCJson.toString();
            e5a a = e5a.a();
            if (a.g()) {
                a.c(jSONObject);
            }
            if (a.f(networkStatRecord)) {
                a.b(jSONObject);
            }
            i5a i5aVar = this.a;
            if (i5aVar != null && i5aVar.a(networkStatRecord)) {
                int i = 0;
                if (s4a.a) {
                    i = 64;
                }
                UBC.onEvent(b(), jSONObject, i);
            }
            if (s4a.a && networkStatRecord.from != 3 && networkStatRecord.netEngine < 0) {
                Log.i("SearchBoxNetRecord", "baidu_networkSearchBoxNetRecord onFinishRecord UBC.onEvent!UbcEventId:" + b() + "，ubcJson:" + uBCJson);
            }
            i5a i5aVar2 = this.b;
            if (i5aVar2 != null && i5aVar2.a(networkStatRecord)) {
                UBC.onEvent(a(), jSONObject);
            }
        }
    }
}
