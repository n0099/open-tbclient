package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public final class cy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final qm6 a(ThemeColorInfo themeColorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeColorInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfo, "themeColorInfo");
            return new qm6(j(themeColorInfo), i(themeColorInfo), h(themeColorInfo));
        }
        return (qm6) invokeL.objValue;
    }

    public static final int b(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            String c = c(themeColorInfoInfo);
            if (c.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return un9.f(c);
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }

    public static final String c(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            if (skinType != 0) {
                if (skinType != 4) {
                    return "";
                }
                ThemeElement themeElement = themeColorInfoInfo.dark;
                if (themeElement != null) {
                    str = themeElement.common_color;
                }
                if (str == null) {
                    return "";
                }
            } else {
                ThemeElement themeElement2 = themeColorInfoInfo.day;
                if (themeElement2 != null) {
                    str = themeElement2.common_color;
                }
                if (str == null) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final String d(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            if (skinType != 0) {
                if (skinType != 4) {
                    return "";
                }
                ThemeElement themeElement = themeColorInfoInfo.dark;
                if (themeElement != null) {
                    str = themeElement.dark_color;
                }
                if (str == null) {
                    return "";
                }
            } else {
                ThemeElement themeElement2 = themeColorInfoInfo.day;
                if (themeElement2 != null) {
                    str = themeElement2.dark_color;
                }
                if (str == null) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final String f(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            if (skinType != 0) {
                if (skinType != 4) {
                    return "";
                }
                ThemeElement themeElement = themeColorInfoInfo.dark;
                if (themeElement != null) {
                    str = themeElement.light_color;
                }
                if (str == null) {
                    return "";
                }
            } else {
                ThemeElement themeElement2 = themeColorInfoInfo.day;
                if (themeElement2 != null) {
                    str = themeElement2.light_color;
                }
                if (str == null) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final String h(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            if (skinType != 0) {
                if (skinType != 4) {
                    return "";
                }
                ThemeElement themeElement = themeColorInfoInfo.dark;
                if (themeElement != null) {
                    str = themeElement.pattern_image;
                }
                if (str == null) {
                    return "";
                }
            } else {
                ThemeElement themeElement2 = themeColorInfoInfo.day;
                if (themeElement2 != null) {
                    str = themeElement2.pattern_image;
                }
                if (str == null) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final int i(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Long l;
        long longValue;
        ThemeElement themeElement;
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 0) {
                if (skinType != 4 || (themeElement = themeColorInfoInfo.dark) == null || (l2 = themeElement.pattern_image_height) == null) {
                    return 0;
                }
                longValue = l2.longValue();
            } else {
                ThemeElement themeElement2 = themeColorInfoInfo.day;
                if (themeElement2 == null || (l = themeElement2.pattern_image_height) == null) {
                    return 0;
                }
                longValue = l.longValue();
            }
            return (int) longValue;
        }
        return invokeL.intValue;
    }

    public static final int j(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Long l;
        long longValue;
        ThemeElement themeElement;
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 0) {
                if (skinType != 4 || (themeElement = themeColorInfoInfo.dark) == null || (l2 = themeElement.pattern_image_width) == null) {
                    return 0;
                }
                longValue = l2.longValue();
            } else {
                ThemeElement themeElement2 = themeColorInfoInfo.day;
                if (themeElement2 == null || (l = themeElement2.pattern_image_width) == null) {
                    return 0;
                }
                longValue = l.longValue();
            }
            return (int) longValue;
        }
        return invokeL.intValue;
    }

    public static final String e(rc5 themeColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, themeColor)) == null) {
            Intrinsics.checkNotNullParameter(themeColor, "themeColor");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            if (skinType != 0) {
                if (skinType != 4) {
                    return "";
                }
                sc5 a = themeColor.a();
                if (a != null) {
                    str = a.a();
                }
                if (str == null) {
                    return "";
                }
            } else {
                sc5 b = themeColor.b();
                if (b != null) {
                    str = b.a();
                }
                if (str == null) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final String g(rc5 themeColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, themeColor)) == null) {
            Intrinsics.checkNotNullParameter(themeColor, "themeColor");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            if (skinType != 0) {
                if (skinType != 4) {
                    return "";
                }
                sc5 a = themeColor.a();
                if (a != null) {
                    str = a.b();
                }
                if (str == null) {
                    return "";
                }
            } else {
                sc5 b = themeColor.b();
                if (b != null) {
                    str = b.b();
                }
                if (str == null) {
                    return "";
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
