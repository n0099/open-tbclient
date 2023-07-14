package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ad2 a(@NonNull String str) {
        InterceptResult invokeL;
        ad2 fd2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            synchronized (bd2.class) {
                char c = 65535;
                switch (str.hashCode()) {
                    case 48:
                        if (str.equals("0")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 49:
                        if (str.equals("1")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 50:
                        if (str.equals("2")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 51:
                        if (str.equals("3")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 52:
                        if (str.equals("4")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                if (c != 4) {
                                    fd2Var = new zc2();
                                } else {
                                    fd2Var = new dd2();
                                }
                            } else {
                                fd2Var = new cd2();
                            }
                        } else {
                            fd2Var = new ed2();
                        }
                    } else {
                        fd2Var = new yc2();
                    }
                } else {
                    fd2Var = new fd2();
                }
            }
            return fd2Var;
        }
        return (ad2) invokeL.objValue;
    }
}
