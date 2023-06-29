package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class h28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, @NonNull List<xn> list, @NonNull String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65536, null, i, list, str)) == null) {
            if (!ListUtils.isEmpty(list) && i >= 0 && i < list.size()) {
                while (i < list.size()) {
                    i++;
                    if (i >= list.size()) {
                        return list.size();
                    }
                    if (list.get(i) instanceof yo6) {
                        yo6 yo6Var = (yo6) list.get(i);
                        if (yo6Var.getThreadData() == null || (!TextUtils.isEmpty(yo6Var.getThreadData().getTid()) && str.equals(yo6Var.getThreadData().getTid()))) {
                        }
                    }
                    return i;
                }
            }
            return -1;
        }
        return invokeILL.intValue;
    }
}
