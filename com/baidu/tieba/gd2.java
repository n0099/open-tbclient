package com.baidu.tieba;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.an2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gd2 implements dd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] a;

    public gd2() {
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
        this.a = new String[]{mb3.w(), mb3.y(), j82.c()};
    }

    @Override // com.baidu.tieba.dd2
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.a) {
                String K = ik4.K(str);
                if (!TextUtils.isEmpty(K)) {
                    arraySet.add(K);
                }
            }
            if (ok1.a) {
                b(arraySet);
            }
            e12.k("SwanSdcardFileCollector", "recovery renameAllFiles:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    public final void b(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arraySet) != null) || arraySet == null) {
            return;
        }
        String[] strArr = {ve2.b().getAbsolutePath(), ld3.c().getAbsolutePath(), an2.b.d(), tg3.b(), dn2.k(), by2.b()};
        for (int i = 0; i < 6; i++) {
            String K = ik4.K(strArr[i]);
            if (!TextUtils.isEmpty(K)) {
                arraySet.add(K);
            }
        }
    }
}
