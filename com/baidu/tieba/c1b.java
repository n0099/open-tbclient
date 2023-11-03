package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes5.dex */
public final class c1b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final hr6 a(ThemeColorInfo themeColorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeColorInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfo, "themeColorInfo");
            return new hr6(i(themeColorInfo), h(themeColorInfo), g(themeColorInfo));
        }
        return (hr6) invokeL.objValue;
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
                return aqa.f(c);
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

    public static final String e(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, themeColorInfoInfo)) == null) {
            Intrinsics.checkNotNullParameter(themeColorInfoInfo, "themeColorInfoInfo");
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            if (skinType != 0) {
                if (skinType != 4) {
                    return "";
                }
                ThemeElement themeElement = themeColorInfoInfo.dark;
                if (themeElement != null) {
                    str = themeElement.font_color;
                }
                if (str == null) {
                    return "";
                }
            } else {
                ThemeElement themeElement2 = themeColorInfoInfo.day;
                if (themeElement2 != null) {
                    str = themeElement2.font_color;
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

    public static final String g(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, themeColorInfoInfo)) == null) {
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

    public static final int h(ThemeColorInfo themeColorInfoInfo) {
        InterceptResult invokeL;
        Long l;
        long longValue;
        ThemeElement themeElement;
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, themeColorInfoInfo)) == null) {
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

    public static final ThemeColorInfo j(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            ThemeColorInfo.Builder builder = new ThemeColorInfo.Builder();
            if (jSONObject != null) {
                builder.day = k(jSONObject.optJSONObject("day"));
                builder.dark = k(jSONObject.optJSONObject("dark"));
            }
            ThemeColorInfo build = builder.build(true);
            Intrinsics.checkNotNullExpressionValue(build, "colorInfoBuilder.build(true)");
            return build;
        }
        return (ThemeColorInfo) invokeL.objValue;
    }

    public static final ThemeElement k(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            ThemeElement.Builder builder = new ThemeElement.Builder();
            if (jSONObject != null) {
                builder.common_color = jSONObject.optString("common_color", "");
                builder.dark_color = jSONObject.optString("dark_color", "");
                builder.light_color = jSONObject.optString("light_color", "");
                builder.pattern_image = jSONObject.optString("pattern_image", "");
                builder.font_color = jSONObject.optString("font_color", "");
                Long DEFAULT_PATTERN_IMAGE_HEIGHT = ThemeElement.DEFAULT_PATTERN_IMAGE_HEIGHT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT_PATTERN_IMAGE_HEIGHT, "DEFAULT_PATTERN_IMAGE_HEIGHT");
                builder.pattern_image_height = Long.valueOf(jSONObject.optLong("pattern_image_height", DEFAULT_PATTERN_IMAGE_HEIGHT.longValue()));
                Long DEFAULT_PATTERN_IMAGE_WIDTH = ThemeElement.DEFAULT_PATTERN_IMAGE_WIDTH;
                Intrinsics.checkNotNullExpressionValue(DEFAULT_PATTERN_IMAGE_WIDTH, "DEFAULT_PATTERN_IMAGE_WIDTH");
                builder.pattern_image_width = Long.valueOf(jSONObject.optLong("pattern_image_width", DEFAULT_PATTERN_IMAGE_WIDTH.longValue()));
            }
            ThemeElement build = builder.build(true);
            Intrinsics.checkNotNullExpressionValue(build, "elementBuilder.build(true)");
            return build;
        }
        return (ThemeElement) invokeL.objValue;
    }
}
