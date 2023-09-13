package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.ParseError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dr0 extends AdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final gr0 r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dr0(@NonNull nr0 nr0Var, @NonNull JSONObject jSONObject) throws ParseError {
        super(nr0Var, jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr0Var, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((nr0) objArr2[0], (JSONObject) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (nr0Var.k.size() >= 1) {
            this.r = nr0Var.k.get(0);
            return;
        }
        throw ParseError.contentError(3, nr0Var.a.value);
    }
}
