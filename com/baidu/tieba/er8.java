package com.baidu.tieba;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class er8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gs8 a(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, recyclerView, i)) == null) {
            return new gs8(context, recyclerView, new cr8(), new dr8(), i, 1);
        }
        return (gs8) invokeLLI.objValue;
    }

    public static gs8 b(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, recyclerView, i)) == null) {
            return new gs8(context, recyclerView, new cr8(), new dr8(), i, 2);
        }
        return (gs8) invokeLLI.objValue;
    }

    public static fs8 c(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, recyclerView, i)) == null) {
            return new fs8(context, recyclerView, new cr8(), new dr8(), i, 1);
        }
        return (fs8) invokeLLI.objValue;
    }
}
