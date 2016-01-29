package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.au;
import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
/* loaded from: classes.dex */
public class af {
    public static boolean b(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            com.baidu.tbadk.core.util.TiebaStatic.log(new au("c10836").aa("obj_type", "checkRSA input args is null"));
            return false;
        }
        try {
            PublicKey D = com.baidu.adp.lib.util.v.D(com.baidu.adp.lib.util.c.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGKmjUQl+RAVovXDJpDU/V8IEWm0Mejnq1yFD8V7mbTT0iD3XvoZNGQ46xiawGYv/f3MlYrttv2kectaH9HjQHsZI2mM6NbxOm+3lv6oRfAIH+2LQvopr1GRZIyueCCfdzBk+w6twrQFfWrAOAl+8g4+k1eic0oPMyT2EknFv2xwIDAQAB"));
            if (D == null) {
                com.baidu.tbadk.core.util.TiebaStatic.log(new au("c10836").aa("obj_type", "publicKeyCode is null").aa("obj_source", file.getName()));
                return false;
            }
            byte[] gl = gl(str);
            if (gl == null || gl.length <= 0) {
                com.baidu.tbadk.core.util.TiebaStatic.log(new au("c10836").aa("obj_type", "server_data is null").aa("obj_source", file.getName()));
                return false;
            }
            byte[] b = com.baidu.adp.lib.util.v.b(D, gl);
            if (b == null || b.length <= 0) {
                com.baidu.tbadk.core.util.TiebaStatic.log(new au("c10836").aa("obj_type", "des is null").aa("obj_source", file.getName()));
                return false;
            }
            String trim = new String(b, "UTF-8").trim();
            String f = com.baidu.adp.lib.util.t.f(new FileInputStream(file));
            if (f != null) {
                f = f.trim();
            }
            if (TextUtils.isEmpty(f) || TextUtils.isEmpty(trim)) {
                com.baidu.tbadk.core.util.TiebaStatic.log(new au("c10836").aa("obj_type", "apkMd5 or serverMD5 is null").aa("obj_source", file.getName()));
                return false;
            } else if (f.equalsIgnoreCase(trim)) {
                return true;
            } else {
                com.baidu.tbadk.core.util.TiebaStatic.log(new au("c10836").aa("obj_type", "apkMd5 != serverMD5").aa("obj_source", file.getName()));
                BdLog.e("download MD5 RSA ERROR; file:" + file.getName());
                return false;
            }
        } catch (Exception e) {
            com.baidu.tbadk.core.util.TiebaStatic.log(new au("c10836").aa("obj_type", "exception:" + e.getMessage()).aa("obj_source", file.getName()));
            BdLog.e("download MD5 RSA ERROR！Exception:" + e.getMessage() + " ; file:" + file.getName());
            return false;
        }
    }

    private static int f(char c) {
        int digit = Character.digit(c, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + c);
        }
        return digit;
    }

    public static byte[] gl(String str) {
        int i = 0;
        if (str == null) {
            throw new IllegalArgumentException("binary string is null");
        }
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[charArray.length / 2];
        if (charArray.length % 2 != 0) {
            return null;
        }
        for (int i2 = 0; i + 1 < charArray.length && i2 < bArr.length; i2++) {
            int i3 = i + 1;
            int f = f(charArray[i]) << 4;
            i = i3 + 1;
            bArr[i2] = (byte) (f(charArray[i3]) | f);
        }
        return bArr;
    }
}
