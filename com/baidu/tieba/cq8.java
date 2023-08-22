package com.baidu.tieba;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static er8 a(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, recyclerView, i)) == null) {
            return new er8(context, recyclerView, new aq8(), new bq8(), i, 1);
        }
        return (er8) invokeLLI.objValue;
    }

    public static er8 b(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, recyclerView, i)) == null) {
            return new er8(context, recyclerView, new aq8(), new bq8(), i, 2);
        }
        return (er8) invokeLLI.objValue;
    }

    public static dr8 c(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, recyclerView, i)) == null) {
            return new dr8(context, recyclerView, new aq8(), new bq8(), i, 1);
        }
        return (dr8) invokeLLI.objValue;
    }
}
