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
/* loaded from: classes5.dex */
public class PageDialogHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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

        public PayForm(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (PayForm) Enum.valueOf(PayForm.class, str);
            }
            return (PayForm) invokeL.objValue;
        }

        public static PayForm[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (PayForm[]) $VALUES.clone();
            }
            return (PayForm[]) invokeV.objValue;
        }
    }

    public PageDialogHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void setDialogLayout(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
            attributes.x = 0;
            attributes.height = displayMetrics.heightPixels - 400;
            attributes.width = -1;
            attributes.y = 0;
            attributes.gravity = 80;
            activity.getWindow().setAttributes(attributes);
            activity.setFinishOnTouchOutside(false);
        }
    }
}
