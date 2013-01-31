package com.baidu.tieba.c;

import android.graphics.Color;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.zeus.NotificationProxy;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ae {
    private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static SimpleDateFormat b = new SimpleDateFormat("yyyy年");
    private static SimpleDateFormat c = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat d = new SimpleDateFormat("M月d日");
    private static SimpleDateFormat e = new SimpleDateFormat("M月d日 HH:mm");
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    private static final char[] g = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] h = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] i = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(Date date) {
        String format;
        synchronized (c) {
            format = c.format(date);
        }
        return format;
    }

    public static String b(Date date) {
        String format;
        synchronized (b) {
            format = b.format(date);
        }
        return format;
    }

    public static String c(Date date) {
        String format;
        synchronized (d) {
            format = d.format(date);
        }
        return format;
    }

    public static String d(Date date) {
        String format;
        synchronized (f) {
            format = f.format(date);
        }
        return format;
    }

    public static String a(long j) {
        String format;
        Date date = new Date(j);
        synchronized (a) {
            format = a.format(date);
        }
        return format;
    }

    public static String a() {
        String format;
        Date date = new Date();
        synchronized (a) {
            format = a.format(date);
        }
        return format;
    }

    public static String e(Date date) {
        if (date == null) {
            return "";
        }
        Date date2 = new Date();
        if (date2.getYear() == date.getYear()) {
            if (date2.getMonth() == date.getMonth() && date2.getDate() == date.getDate()) {
                return a(date);
            }
            return c(date);
        }
        return b(date);
    }

    public static String f(Date date) {
        if (date == null) {
            return "";
        }
        Date date2 = new Date();
        if (date2.getMonth() == date.getMonth() && date2.getDate() == date.getDate()) {
            return a(date);
        }
        return d(date);
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(g[(bArr[i2] & 240) >>> 4]);
            sb.append(g[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    public static String a(InputStream inputStream) {
        String str = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    inputStream.close();
                    str = a(messageDigest.digest());
                    return str;
                }
            }
        } catch (Exception e2) {
            af.a("StringHelper", "ToMd5", e2.toString());
            return str;
        }
    }

    public static String a(String str) {
        try {
            return a(new ByteArrayInputStream(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            return null;
        }
    }

    public static boolean a(char c2) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c2);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean b(String str) {
        if (Pattern.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\w]+$").matcher(str).matches()) {
            int i2 = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                if (String.valueOf(str.charAt(i3)).getBytes().length == 1) {
                    i2++;
                } else {
                    i2 += 2;
                }
            }
            return i2 > 0 && i2 <= 14;
        }
        return false;
    }

    public static boolean c(String str) {
        int length = str.length();
        return length >= 6 && length <= 14 && str.getBytes().length <= length;
    }

    public static boolean d(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean e(String str) {
        return str == null || str.length() == 0 || str.equals("null");
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, BdUtil.UTF8);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String g(String str) {
        try {
            return URLDecoder.decode(str, BdUtil.UTF8);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, int i2) {
        if (str == null || i2 <= 0) {
            return String.valueOf("");
        }
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (a(str.charAt(i3))) {
                i4 += 2;
            } else {
                i4++;
            }
            if (i4 >= i2) {
                break;
            }
            i3++;
        }
        if (i3 < length) {
            return String.valueOf(str.substring(0, i3 + 1)) + "...";
        }
        return str;
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(h[i4 >>> 2]);
                stringBuffer.append(h[(i4 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                stringBuffer.append(h[i4 >>> 2]);
                stringBuffer.append(h[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                stringBuffer.append(h[(i6 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i2 = i5 + 1;
            int i7 = bArr[i5] & 255;
            stringBuffer.append(h[i4 >>> 2]);
            stringBuffer.append(h[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
            stringBuffer.append(h[((i6 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(h[i7 & 63]);
        }
        return stringBuffer.toString();
    }

    public static String h(String str) {
        return a(str);
    }

    public static String a(String str, Color color) {
        String str2;
        Exception exc;
        if (str == null) {
            return "";
        }
        try {
            String replaceAll = str.replaceAll("<em>", "<font color='#007bd1'>");
            try {
                return replaceAll.replaceAll("</em>", "</font>");
            } catch (Exception e2) {
                str2 = replaceAll;
                exc = e2;
                af.a("StringHelper", "getHighLightString", exc.toString());
                return str2;
            }
        } catch (Exception e3) {
            str2 = null;
            exc = e3;
        }
    }

    private static long[] i(String str) {
        long[] jArr = new long[3];
        if (str != null) {
            String[] split = str.replace(".", "#").split("#");
            jArr[0] = Long.parseLong(split[0]);
            jArr[1] = Long.parseLong(split[1]);
            jArr[2] = Long.parseLong(split[2]);
        }
        return jArr;
    }

    public static int a(String str, String str2) {
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        long[] i2 = i(str);
        long[] i3 = i(str2);
        long j = 0;
        long j2 = 0;
        for (int i4 = 0; i4 < 3; i4++) {
            j += i2[i4] << (24 - (i4 * 8));
        }
        for (int i5 = 0; i5 < 3; i5++) {
            j2 += i3[i5] << (24 - (i5 * 8));
        }
        if (j > j2) {
            return 1;
        }
        if (j == j2) {
            return 0;
        }
        return -1;
    }
}
