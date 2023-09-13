package com.baidu.tieba;

import android.animation.TypeEvaluator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ge8 implements TypeEvaluator<ie8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ie8 a;

    public ge8(ie8 ie8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ie8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ie8Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public ie8 evaluate(float f, ie8 ie8Var, ie8 ie8Var2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), ie8Var, ie8Var2})) == null) {
            float f2 = 1.0f - f;
            float f3 = f2 * f2;
            float f4 = 2.0f * f * f2;
            ie8 ie8Var3 = this.a;
            float f5 = f * f;
            return new ie8((int) ((ie8Var.a * f3) + (ie8Var3.a * f4) + (ie8Var2.a * f5)), (int) ((f3 * ie8Var.b) + (f4 * ie8Var3.b) + (f5 * ie8Var2.b)));
        }
        return (ie8) invokeCommon.objValue;
    }
}
