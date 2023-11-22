package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public class had {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-752218111, "Lcom/baidu/tieba/had$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-752218111, "Lcom/baidu/tieba/had$a;");
                    return;
                }
            }
            int[] iArr = new int[PayDialogType.values().length];
            a = iArr;
            try {
                iArr[PayDialogType.PAY_AMOUNT_DIALOG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PayDialogType.PAY_INPUT_DIALOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PayDialogType.PAY_WAY_DIALOG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PayDialogType.PAY_SPLIT_ORDER_DIALOG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static PayFinishInfo a(PayDialogType payDialogType, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, payDialogType, i, str)) == null) {
            return b(payDialogType, i, str, false);
        }
        return (PayFinishInfo) invokeLIL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PayFinishInfo b(PayDialogType payDialogType, int i, String str, boolean z) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{payDialogType, Integer.valueOf(i), str, Boolean.valueOf(z)})) == null) {
            PayFinishInfo payFinishInfo = new PayFinishInfo();
            int i2 = a.a[payDialogType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            payFinishInfo.step = p7d.h;
                            if (TextUtils.isEmpty(str)) {
                                str2 = "支付拆单选择面板";
                            } else {
                                str2 = "支付拆单选择面板," + str;
                            }
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        payFinishInfo.message = str;
                        payFinishInfo.code = i;
                        return payFinishInfo;
                    } else if (z) {
                        payFinishInfo.step = p7d.g;
                        if (TextUtils.isEmpty(str)) {
                            str2 = "支付渠道选择面板(快捷)";
                        } else {
                            str2 = "支付渠道选择面板(快捷)," + str;
                        }
                    } else {
                        payFinishInfo.step = p7d.c;
                        if (TextUtils.isEmpty(str)) {
                            str2 = "支付渠道选择面板";
                        } else {
                            str2 = "支付渠道选择面板," + str;
                        }
                    }
                } else {
                    payFinishInfo.step = p7d.b;
                    if (TextUtils.isEmpty(str)) {
                        str2 = "支付金额输入面板";
                    } else {
                        str2 = "支付金额输入面板," + str;
                    }
                }
            } else {
                payFinishInfo.step = p7d.a;
                if (TextUtils.isEmpty(str)) {
                    str2 = "支付金额选择面板";
                } else {
                    str2 = "支付金额选择面板," + str;
                }
            }
            str = str2;
            if (TextUtils.isEmpty(str)) {
            }
            payFinishInfo.message = str;
            payFinishInfo.code = i;
            return payFinishInfo;
        }
        return (PayFinishInfo) invokeCommon.objValue;
    }

    public static PayFinishInfo c(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, str)) == null) {
            PayFinishInfo payFinishInfo = new PayFinishInfo();
            payFinishInfo.step = p7d.e;
            payFinishInfo.code = i;
            payFinishInfo.message = str;
            return payFinishInfo;
        }
        return (PayFinishInfo) invokeIL.objValue;
    }

    public static PayFinishInfo d(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, str)) == null) {
            PayFinishInfo payFinishInfo = new PayFinishInfo();
            payFinishInfo.step = p7d.d;
            payFinishInfo.code = i;
            payFinishInfo.message = str;
            return payFinishInfo;
        }
        return (PayFinishInfo) invokeIL.objValue;
    }

    public static PayFinishInfo e(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str)) == null) {
            PayFinishInfo payFinishInfo = new PayFinishInfo();
            payFinishInfo.step = p7d.f;
            payFinishInfo.code = i;
            payFinishInfo.message = str;
            return payFinishInfo;
        }
        return (PayFinishInfo) invokeIL.objValue;
    }
}
