package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ad2 extends lg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<kg2> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad2() {
        super("combine");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.kg2
    public String c(i52 i52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i52Var)) == null) {
            if (i52Var != null && this.d.size() > 0) {
                int i = 0;
                StringBuilder sb = new StringBuilder();
                for (kg2 kg2Var : this.d) {
                    sb.append(kg2Var.d("event" + i, i52Var));
                    i++;
                }
                if (kg2.b) {
                    Log.d("JSEventDispatcher", "combine msg - " + sb.toString());
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.kg2
    public void h(i52 i52Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i52Var) == null) && i52Var != null && !i52Var.isWebView() && this.d.size() > 0) {
            if (kg2.b) {
                Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
            }
            for (kg2 kg2Var : this.d) {
                JSEvent e = kg2Var.e(i52Var);
                if (e != null) {
                    j(i52Var, e);
                    if (kg2.b) {
                        Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
                    }
                }
            }
        }
    }

    public ad2 t(kg2 kg2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kg2Var)) == null) {
            if (kg2Var != null && !this.d.contains(kg2Var)) {
                this.d.add(kg2Var);
            }
            return this;
        }
        return (ad2) invokeL.objValue;
    }
}
