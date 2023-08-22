package com.baidu.tieba;

import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Service
/* loaded from: classes5.dex */
public final class a0a implements ye5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a0a() {
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

    @Override // com.baidu.tieba.ye5
    public void parseJson(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                zz9.d.a().q(json);
            } catch (Exception e) {
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    e.printStackTrace();
                    return;
                }
                throw e;
            }
        }
    }
}
