package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.poly.widget.toast.ToastLoadingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class id1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ToastLoadingView a;

        public a(ToastLoadingView toastLoadingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toastLoadingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = toastLoadingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                id1.b(this.a);
            }
        }
    }

    public static void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, ToastLoadingView toastLoadingView, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{viewGroup, layoutParams, toastLoadingView, Long.valueOf(j)}) == null) {
            if (toastLoadingView.getParent() instanceof ViewGroup) {
                ((ViewGroup) toastLoadingView.getParent()).removeView(toastLoadingView);
            }
            viewGroup.addView(toastLoadingView, layoutParams);
            toastLoadingView.setLoading(true);
            if (j != -1) {
                viewGroup.postDelayed(new a(toastLoadingView), j);
            }
        }
    }

    public static void b(ToastLoadingView toastLoadingView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, toastLoadingView) == null) && toastLoadingView != null && (toastLoadingView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) toastLoadingView.getParent()).removeView(toastLoadingView);
            toastLoadingView.setLoading(false);
        }
    }

    public static ToastLoadingView c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{viewGroup, layoutParams, str, Long.valueOf(j)})) == null) {
            if (viewGroup == null) {
                return null;
            }
            ToastLoadingView toastLoadingView = new ToastLoadingView(viewGroup.getContext());
            if (!TextUtils.isEmpty(str)) {
                toastLoadingView.setText(str);
            }
            a(viewGroup, layoutParams, toastLoadingView, j);
            return toastLoadingView;
        }
        return (ToastLoadingView) invokeCommon.objValue;
    }
}
