package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.Color;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.tbadk.core.util.StringHelper;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes4.dex */
public class dj {
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

    public static String getWeekShow(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i)) == null) {
            switch (i) {
                case 1:
                    return "周日";
                case 2:
                    return "周一";
                case 3:
                    return "周二";
                case 4:
                    return "周三";
                case 5:
                    return "周四";
                case 6:
                    return "周五";
                case 7:
                    return "周六";
                default:
                    return "";
            }
        }
        return (String) invokeI.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302567, "Lcom/baidu/tieba/dj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302567, "Lcom/baidu/tieba/dj;");
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

    public dj() {
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

    public static String getCurrentString() {
        InterceptResult invokeV;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            Date date = new Date();
            synchronized (FORMATE_DATE_ALL) {
                format = FORMATE_DATE_ALL.format(date);
            }
            return format;
        }
        return (String) invokeV.objValue;
    }

    public static boolean ContentChinese(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null && str.length() >= 1) {
                for (int i = 0; i < str.length(); i++) {
                    if (isChinese(str.charAt(i))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String GetTimeString2(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, date)) == null) {
            if (date == null) {
                return "";
            }
            Date date2 = new Date();
            if (date2.getMonth() == date.getMonth() && date2.getDate() == date.getDate()) {
                return getDateStringHm(date);
            }
            return getDateStringDay(date);
        }
        return (String) invokeL.objValue;
    }

    public static int byteLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
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

    public static String getNameFromUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            try {
                int lastIndexOf = str.lastIndexOf("/");
                int lastIndexOf2 = str.lastIndexOf(".");
                if (lastIndexOf != -1) {
                    if (lastIndexOf < lastIndexOf2) {
                        return str.substring(lastIndexOf, lastIndexOf2);
                    }
                    return str.substring(lastIndexOf);
                }
                return str;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean isChinese(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{Character.valueOf(c)})) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, strArr)) == null) {
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

    public static long[] parseVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) {
            long[] jArr = new long[3];
            if (str != null) {
                String[] split = str.replace(".", "#").split("#");
                jArr[0] = Long.parseLong(split[0]);
                jArr[1] = Long.parseLong(split[1]);
                jArr[2] = Long.parseLong(split[2]);
            }
            return jArr;
        }
        return (long[]) invokeL.objValue;
    }

    public static String StringFilter(String str) throws PatternSyntaxException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return Pattern.compile("[/\\:*?<>|\"\n\t]").matcher(str).replaceAll("").trim();
        }
        return (String) invokeL.objValue;
    }

    public static String getDateStringDay(Date date) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, date)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, date)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, date)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, date)) == null) {
            synchronized (FORMATE_DATE_MOUTH) {
                format = FORMATE_DATE_MOUTH.format(date);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getDateStringYear(Date date) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, date)) == null) {
            synchronized (FORMATE_DATE_YEAR) {
                format = FORMATE_DATE_YEAR.format(date);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getMinuteShow(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i)) == null) {
            if (i < 10) {
                return "0" + i;
            }
            return String.valueOf(i);
        }
        return (String) invokeI.objValue;
    }

    public static String getTimeString(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65556, null, j)) == null) {
            Date date = new Date(j);
            synchronized (FORMATE_DATE_ALL) {
                format = FORMATE_DATE_ALL.format(date);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getTimeString3(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, date)) == null) {
            if (date == null) {
                return "";
            }
            String timeStringWithinMonth = getTimeStringWithinMonth(date);
            if (timeStringWithinMonth != null) {
                return timeStringWithinMonth;
            }
            return getDateStringDay(date);
        }
        return (String) invokeL.objValue;
    }

    public static String getTimeStringNoYear(Date date) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, date)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            try {
                return URLDecoder.decode(str, IMAudioTransRequest.CHARSET);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            if (str != null && str.length() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isMobileNo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
            return Pattern.compile("1\\d{10}").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static boolean isPassword(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
            int length = str.length();
            if (length < 6 || length > 14 || str.getBytes().length > length) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String charSequence2String(CharSequence charSequence, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, charSequence, str)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, str, str2)) == null) {
            if (str != null && str2 != null) {
                return str.equals(str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int compareVersion(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            long[] parseVersion = parseVersion(str);
            long[] parseVersion2 = parseVersion(str2);
            long j = 0;
            long j2 = 0;
            for (int i = 0; i < 3; i++) {
                j2 += parseVersion[i] << (24 - (i * 8));
            }
            for (int i2 = 0; i2 < 3; i2++) {
                j += parseVersion2[i2] << (24 - (i2 * 8));
            }
            int i3 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
            if (i3 > 0) {
                return 1;
            }
            if (i3 != 0) {
                return -1;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static String cutString(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i)) == null) {
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
                    return str.substring(0, i2 + 1) + StringHelper.STRING_MORE;
                }
                return str;
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static String getHighLightString(String str, Color color) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, color)) == null) {
            if (str == null) {
                return "";
            }
            String str2 = null;
            try {
                str2 = str.replaceAll("<em>", "<font color='#007bd1'>");
                return str2.replaceAll("</em>", "</font>");
            } catch (Exception e) {
                BdLog.e(e.toString());
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getHourShow(int i) {
        InterceptResult invokeI;
        String valueOf;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            if (i < 10) {
                valueOf = "0" + i;
            } else {
                valueOf = String.valueOf(i);
            }
            if (i >= 0 && i < 6) {
                str = "凌晨";
            } else if (i >= 6 && i < 9) {
                str = "早晨";
            } else if (i >= 9 && i < 12) {
                str = "上午";
            } else if (i >= 12 && i < 14) {
                str = "中午";
            } else if (i >= 14 && i < 18) {
                str = "下午";
            } else if (i >= 18 && i < 24) {
                str = "晚上";
            } else {
                str = "";
            }
            return str + valueOf;
        }
        return (String) invokeI.objValue;
    }

    public static String getMicroMsgTime(long j, long j2) {
        InterceptResult invokeCommon;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j2 == 0) {
                j3 = System.currentTimeMillis() / 1000;
            } else {
                j3 = j2;
            }
            Calendar gregorianCalendar = GregorianCalendar.getInstance();
            gregorianCalendar.setTimeInMillis(j * 1000);
            int i = gregorianCalendar.get(1);
            int i2 = gregorianCalendar.get(2) + 1;
            int i3 = gregorianCalendar.get(5);
            int i4 = gregorianCalendar.get(11);
            int i5 = gregorianCalendar.get(12);
            int i6 = gregorianCalendar.get(3);
            int i7 = gregorianCalendar.get(7);
            gregorianCalendar.setTimeInMillis(1000 * j3);
            int i8 = gregorianCalendar.get(1);
            int i9 = gregorianCalendar.get(2) + 1;
            int i10 = gregorianCalendar.get(5);
            int i11 = gregorianCalendar.get(3);
            String hourShow = getHourShow(i4);
            String minuteShow = getMinuteShow(i5);
            if (j > j3) {
                if (i3 == i10) {
                    return hourShow + ":" + minuteShow;
                }
                return i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
            } else if (i < i8) {
                return i + "年" + i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
            } else if (i2 < i9) {
                return i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
            } else if (i3 < i10) {
                if (i6 < i11) {
                    return i2 + "月" + i3 + "日 " + hourShow + ":" + minuteShow;
                }
                String weekShow = getWeekShow(i7);
                return weekShow + " " + hourShow + ":" + minuteShow;
            } else {
                return hourShow + ":" + minuteShow;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String getTimeStringWithinMonth(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, date)) == null) {
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

    public static boolean isAccount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            if (!Pattern.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\w]+$").matcher(str).matches()) {
                return false;
            }
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (String.valueOf(str.charAt(i2)).getBytes().length == 1) {
                    i++;
                } else {
                    i += 2;
                }
            }
            if (i <= 0 || i > 14) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
