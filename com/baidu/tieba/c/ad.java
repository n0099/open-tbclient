package com.baidu.tieba.c;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.Character;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ad {
    private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static SimpleDateFormat b = new SimpleDateFormat("yyyy年");
    private static SimpleDateFormat c = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat d = new SimpleDateFormat("M月d日");
    private static SimpleDateFormat e = new SimpleDateFormat("M月d日 HH:mm");
    private static final char[] f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] g = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] h = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a() {
        String format;
        Date date = new Date();
        synchronized (a) {
            format = a.format(date);
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

    public static String a(InputStream inputStream) {
        String str = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    inputStream.close();
                    str = a(messageDigest.digest());
                    return str;
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception e2) {
            ae.a("StringHelper", "ToMd5", e2.toString());
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

    public static String a(String str, int i) {
        if (str == null || i <= 0) {
            return String.valueOf("");
        }
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            i3 = a(str.charAt(i2)) ? i3 + 2 : i3 + 1;
            if (i3 >= i) {
                break;
            }
            i2++;
        }
        return i2 < length ? String.valueOf(str.substring(0, i2 + 1)) + "..." : str;
    }

    public static String a(Date date) {
        String format;
        synchronized (c) {
            format = c.format(date);
        }
        return format;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(f[(bArr[i] & 240) >>> 4]);
            sb.append(f[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static boolean a(char c2) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c2);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static String b(Date date) {
        String format;
        synchronized (b) {
            format = b.format(date);
        }
        return format;
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(g[i3 >>> 2]);
                stringBuffer.append(g[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            if (i4 == length) {
                stringBuffer.append(g[i3 >>> 2]);
                stringBuffer.append(g[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                stringBuffer.append(g[(i5 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i = i4 + 1;
            int i6 = bArr[i4] & 255;
            stringBuffer.append(g[i3 >>> 2]);
            stringBuffer.append(g[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
            stringBuffer.append(g[((i5 & 15) << 2) | ((i6 & 192) >>> 6)]);
            stringBuffer.append(g[i6 & 63]);
        }
        return stringBuffer.toString();
    }

    public static boolean b(String str) {
        if (Pattern.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\w]+$").matcher(str).matches()) {
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                i = String.valueOf(str.charAt(i2)).getBytes().length == 1 ? i + 1 : i + 2;
            }
            return i > 0 && i <= 14;
        }
        return false;
    }

    public static String c(Date date) {
        String format;
        synchronized (d) {
            format = d.format(date);
        }
        return format;
    }

    public static boolean c(String str) {
        int length = str.length();
        return length >= 6 && length <= 14 && str.getBytes().length <= length;
    }

    public static String d(Date date) {
        if (date == null) {
            return "";
        }
        Date date2 = new Date();
        return date2.getYear() == date.getYear() ? (date2.getMonth() == date.getMonth() && date2.getDate() == date.getDate()) ? a(date) : c(date) : b(date);
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
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String g(String str) {
        return a(str);
    }
}
