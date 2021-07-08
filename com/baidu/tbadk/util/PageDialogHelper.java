package com.baidu.tbadk.util;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
/* loaded from: classes3.dex */
public class PageDialogHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class PayForm {
        public static final /* synthetic */ PayForm[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PayForm DIALOG;
        public static final PayForm NORMAL;
        public static final PayForm NOT_SET;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1561503780, "Lcom/baidu/tbadk/util/PageDialogHelper$PayForm;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1561503780, "Lcom/baidu/tbadk/util/PageDialogHelper$PayForm;");
                    return;
                }
            }
            NOT_SET = new PayForm("NOT_SET", 0);
            DIALOG = new PayForm("DIALOG", 1);
            PayForm payForm = new PayForm("NORMAL", 2);
            NORMAL = payForm;
            $VALUES = new PayForm[]{NOT_SET, DIALOG, payForm};
        }

        public PayForm(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PayForm valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PayForm) Enum.valueOf(PayForm.class, str) : (PayForm) invokeL.objValue;
        }

        public static PayForm[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PayForm[]) $VALUES.clone() : (PayForm[]) invokeV.objValue;
        }
    }

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, activity) == null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
            attributes.x = 0;
            attributes.height = displayMetrics.heightPixels + ErrorCode.ARGS_ERROR;
            attributes.width = -1;
            attributes.y = 0;
            attributes.gravity = 80;
            activity.getWindow().setAttributes(attributes);
            activity.setFinishOnTouchOutside(false);
        }
    }
}
