package com.baidu.tieba;

import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public boolean c;
    public boolean d;
    public int e;
    public String f;

    public b94() {
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
        this.a = "";
        this.b = Integer.MAX_VALUE;
        this.c = false;
        this.d = false;
    }

    public boolean a(o32 o32Var) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, o32Var)) == null) {
            try {
                this.a = o32Var.B("defaultValue");
                this.b = o32Var.q("maxLength");
                this.c = o32Var.l("multiple");
                this.d = o32Var.l("confirmHold");
                String B = o32Var.B("confirmType");
                char c = 65535;
                switch (B.hashCode()) {
                    case -906336856:
                        if (B.equals("search")) {
                            c = 2;
                            break;
                        }
                        break;
                    case SpeedStatsStampTable.AD_LOAD_BEAR_END_STAMP_KEY /* 3304 */:
                        if (B.equals("go")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 3089282:
                        if (B.equals("done")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3377907:
                        if (B.equals("next")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3526536:
                        if (B.equals("send")) {
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
                                    this.e = 6;
                                    this.f = "done";
                                } else {
                                    this.e = 4;
                                    this.f = "send";
                                }
                            } else {
                                this.e = 2;
                                this.f = "go";
                            }
                        } else {
                            this.e = 3;
                            this.f = "search";
                        }
                    } else {
                        this.e = 5;
                        this.f = "next";
                    }
                } else {
                    this.e = 6;
                    this.f = "done";
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
