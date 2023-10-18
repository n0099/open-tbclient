package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.tieba.ye4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes5.dex */
public class br3 implements zf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public br3() {
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

    @Override // com.baidu.tieba.ye4
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ye4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            if (PMSConstants.a(ad4.b())) {
                se4.b(str, map, map2, jSONObject, new so3(aVar));
            } else {
                se4.b(str, map, map2, jSONObject, new ze4(aVar));
            }
        }
    }

    @Override // com.baidu.tieba.zf4
    public lf4 c(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            return jf4.a(str, i);
        }
        return (lf4) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.ye4
    public void z(String str, Map<String, String> map, Map<String, String> map2, ye4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, map, map2, aVar) == null) {
            if (PMSConstants.a(ad4.b())) {
                se4.a(str, map, map2, new so3(aVar));
            } else {
                se4.a(str, map, map2, new ze4(aVar));
            }
        }
    }
}
