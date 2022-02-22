package com.baidu.tbadk.util;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.u0.a4.e;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class BdListViewHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes12.dex */
    public static final class HeadType {
        public static final /* synthetic */ HeadType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HeadType DEFAULT;
        public static final HeadType HASTAB;
        public static final HeadType HAS_NO_NETWORK_BAR;
        public static final HeadType TIP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1020764422, "Lcom/baidu/tbadk/util/BdListViewHelper$HeadType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1020764422, "Lcom/baidu/tbadk/util/BdListViewHelper$HeadType;");
                    return;
                }
            }
            DEFAULT = new HeadType(EngineName.DEFAULT_ENGINE, 0);
            HASTAB = new HeadType("HASTAB", 1);
            HAS_NO_NETWORK_BAR = new HeadType("HAS_NO_NETWORK_BAR", 2);
            HeadType headType = new HeadType("TIP", 3);
            TIP = headType;
            $VALUES = new HeadType[]{DEFAULT, HASTAB, HAS_NO_NETWORK_BAR, headType};
        }

        public HeadType(String str, int i2) {
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

        public static HeadType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HeadType) Enum.valueOf(HeadType.class, str) : (HeadType) invokeL.objValue;
        }

        public static HeadType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HeadType[]) $VALUES.clone() : (HeadType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1546937665, "Lcom/baidu/tbadk/util/BdListViewHelper$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1546937665, "Lcom/baidu/tbadk/util/BdListViewHelper$a;");
                    return;
                }
            }
            int[] iArr = new int[HeadType.values().length];
            a = iArr;
            try {
                iArr[HeadType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[HeadType.HASTAB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[HeadType.HAS_NO_NETWORK_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[HeadType.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(171441950, "Lcom/baidu/tbadk/util/BdListViewHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(171441950, "Lcom/baidu/tbadk/util/BdListViewHelper;");
                return;
            }
        }
        a = n.f(TbadkCoreApplication.getInst().getContext(), e.ds320);
    }

    public static int a(HeadType headType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, headType)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int i2 = a.a[headType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return UtilHelper.getLightStatusBarHeight() + n.f(context, e.ds88);
                        }
                        return n.f(context, e.ds56);
                    }
                    return UtilHelper.getLightStatusBarHeight() + n.f(context, e.ds168);
                }
                return UtilHelper.getLightStatusBarHeight() + n.f(context, e.ds176);
            }
            return UtilHelper.getLightStatusBarHeight() + n.f(context, e.ds88);
        }
        return invokeL.intValue;
    }

    public static int b(HeadType headType, boolean z) {
        InterceptResult invokeLZ;
        int lightStatusBarHeight;
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, headType, z)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            if (z) {
                return a(headType);
            }
            if (HeadType.DEFAULT == headType) {
                lightStatusBarHeight = UtilHelper.getLightStatusBarHeight();
                f2 = n.f(context, e.ds170);
            } else {
                lightStatusBarHeight = UtilHelper.getLightStatusBarHeight();
                f2 = n.f(context, e.ds240);
            }
            return lightStatusBarHeight + f2;
        }
        return invokeLZ.intValue;
    }

    public static void c(View view, HeadType headType, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65539, null, view, headType, z) == null) || view == null || headType == null) {
            return;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (z) {
            layoutParams.height = a(headType);
        } else if (HeadType.DEFAULT == headType) {
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + n.f(context, e.ds170);
        } else {
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + n.f(context, e.ds240);
        }
        view.setLayoutParams(layoutParams);
    }

    public static View d(Context context, BdListView bdListView, HeadType headType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, bdListView, headType)) == null) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, a(headType)));
            bdListView.addHeaderView(textView, 0);
            return textView;
        }
        return (View) invokeLLL.objValue;
    }
}
