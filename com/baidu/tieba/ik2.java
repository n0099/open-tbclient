package com.baidu.tieba;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.baidu.tieba.du2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ik2 implements gk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] a;

    public ik2() {
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
        this.a = new String[]{du2.i(), du2.l(), du2.r(), du2.b.f(), a92.f(), a92.d(), l82.c(), du2.f.f(), du2.f.d(), zo2.d};
    }

    @Override // com.baidu.tieba.gk2
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.a) {
                String K = lr4.K(str);
                if (!TextUtils.isEmpty(K)) {
                    arraySet.add(K);
                }
            }
            h82.k("SwanSandboxFileCollector", "recovery renameAllFiles:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }
}
