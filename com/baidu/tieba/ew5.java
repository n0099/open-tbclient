package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ew5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static Fragment a(@NonNull FragmentManager fragmentManager, int i, @NonNull Fragment fragment) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, fragmentManager, i, fragment)) == null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(i, fragment, fragment.getClass().getCanonicalName());
            beginTransaction.commitAllowingStateLoss();
            return fragment;
        }
        return (Fragment) invokeLIL.objValue;
    }

    @Nullable
    public static <T extends Fragment> T b(@NonNull FragmentManager fragmentManager, @NonNull Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fragmentManager, cls)) == null) {
            return (T) fragmentManager.findFragmentByTag(cls.getCanonicalName());
        }
        return (T) invokeLL.objValue;
    }
}
