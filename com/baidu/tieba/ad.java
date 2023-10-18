package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes5.dex */
public class ad {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleDateFormat FORMATE_DATE_ALL;
    public static SimpleDateFormat FORMATE_DATE_DAY;
    public static SimpleDateFormat FORMATE_DATE_DAY_1;
    public static SimpleDateFormat FORMATE_DATE_DAY_NO_YEAR;
    public static SimpleDateFormat FORMATE_DATE_DAY_WEEK;
    public static SimpleDateFormat FORMATE_DATE_MOUTH;
    public static SimpleDateFormat FORMATE_DATE_MOUTH_TIME;
    public static SimpleDateFormat FORMATE_DATE_MS;
    public static SimpleDateFormat FORMATE_DATE_TIME;
    public static SimpleDateFormat FORMATE_DATE_YEAR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448299498, "Lcom/baidu/tieba/ad;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448299498, "Lcom/baidu/tieba/ad;");
                return;
            }
        }
        FORMATE_DATE_ALL = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        FORMATE_DATE_YEAR = new SimpleDateFormat("yyyy年");
        FORMATE_DATE_TIME = new SimpleDateFormat("HH:mm");
        FORMATE_DATE_MOUTH = new SimpleDateFormat("M月d日");
        FORMATE_DATE_MOUTH_TIME = new SimpleDateFormat("M月d日 HH:mm");
        FORMATE_DATE_DAY = new SimpleDateFormat("yyyy-MM-dd");
        FORMATE_DATE_DAY_WEEK = new SimpleDateFormat("yyyy-MM-dd E");
        FORMATE_DATE_DAY_1 = new SimpleDateFormat("yy-M-d");
        FORMATE_DATE_MS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        FORMATE_DATE_DAY_NO_YEAR = new SimpleDateFormat("MM-dd");
    }

    public ad() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int byteLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (Integer.toHexString(str.charAt(i2)).length() == 4) {
                    i += 2;
                } else {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static boolean isChinese(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Character.valueOf(c)})) == null) {
            Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
            if (of != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS && of != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS && of != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A && of != Character.UnicodeBlock.GENERAL_PUNCTUATION && of != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION && of != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static String join(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, strArr)) == null) {
            if (strArr != null && strArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                for (String str : strArr) {
                    sb.append(str);
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String charSequence2String(CharSequence charSequence, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, charSequence, str)) == null) {
            if (charSequence instanceof String) {
                return (String) charSequence;
            }
            if (charSequence != null) {
                return charSequence.toString();
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isEquals(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, str, str2)) == null) {
            if (str != null && str2 != null) {
                return str.equals(str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String cutString(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            if (str != null && i > 0) {
                int length = str.length();
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    if (isChinese(str.charAt(i2))) {
                        i3 += 2;
                    } else {
                        i3++;
                    }
                    if (i3 >= i) {
                        break;
                    }
                    i2++;
                }
                if (i2 < length - 1) {
                    return str.substring(0, i2 + 1) + "...";
                }
                return str;
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static String getDateStringDay(Date date) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, date)) == null) {
            synchronized (FORMATE_DATE_DAY) {
                format = FORMATE_DATE_DAY.format(date);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getDateStringHm(Date date) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, date)) == null) {
            synchronized (FORMATE_DATE_TIME) {
                format = FORMATE_DATE_TIME.format(date);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getDateStringMdHm(Date date) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, date)) == null) {
            synchronized (FORMATE_DATE_MOUTH_TIME) {
                format = FORMATE_DATE_MOUTH_TIME.format(date);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getDateStringMouth(Date date) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, date)) == null) {
            synchronized (FORMATE_DATE_MOUTH) {
                format = FORMATE_DATE_MOUTH.format(date);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getTimeStringNoYear(Date date) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, date)) == null) {
            if (date == null) {
                return "";
            }
            String timeStringWithinMonth = getTimeStringWithinMonth(date);
            if (timeStringWithinMonth != null) {
                return timeStringWithinMonth;
            }
            synchronized (FORMATE_DATE_DAY_NO_YEAR) {
                format = FORMATE_DATE_DAY_NO_YEAR.format(date);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getUrlDecode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getUrlEncode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean isEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (str != null && str.length() != 0 && !str.equals(StringUtil.NULL_STRING)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isEmptyStringAfterTrim(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (str != null && str.trim().length() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isForumName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (str != null && str.length() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String getTimeStringWithinMonth(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, date)) == null) {
            Date date2 = new Date();
            int day = date2.getDay() - date.getDay();
            long time = date2.getTime() - date.getTime();
            if (time < 30000) {
                return "刚刚";
            }
            if (time < 60000) {
                return "半分钟前";
            }
            if (time < 3600000) {
                return String.valueOf((time * 60) / 3600000) + "分钟前";
            } else if (time < 86400000) {
                if (day == 0) {
                    return getDateStringHm(date);
                }
                return "1天前";
            } else if (time < 2678400000L) {
                return String.valueOf((time * 31) / 2678400000L) + "天前";
            } else if (time < 2764800000L) {
                return "1个月前";
            } else {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
