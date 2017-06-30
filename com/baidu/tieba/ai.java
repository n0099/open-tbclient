package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
/* loaded from: classes.dex */
public class ai {
    public static boolean c(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            TiebaStatic.log(new au("c10836").Z("obj_type", "checkRSA input args is null"));
            return false;
        }
        try {
            PublicKey p = com.baidu.adp.lib.util.v.p(com.baidu.adp.lib.util.c.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGKmjUQl+RAVovXDJpDU/V8IEWm0Mejnq1yFD8V7mbTT0iD3XvoZNGQ46xiawGYv/f3MlYrttv2kectaH9HjQHsZI2mM6NbxOm+3lv6oRfAIH+2LQvopr1GRZIyueCCfdzBk+w6twrQFfWrAOAl+8g4+k1eic0oPMyT2EknFv2xwIDAQAB"));
            if (p == null) {
                TiebaStatic.log(new au("c10836").Z("obj_type", "publicKeyCode is null").Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
                return false;
            }
            byte[] gU = gU(str);
            if (gU == null || gU.length <= 0) {
                TiebaStatic.log(new au("c10836").Z("obj_type", "server_data is null").Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
                return false;
            }
            byte[] b = com.baidu.adp.lib.util.v.b(p, gU);
            if (b == null || b.length <= 0) {
                TiebaStatic.log(new au("c10836").Z("obj_type", "des is null").Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
                return false;
            }
            String trim = new String(b, "UTF-8").trim();
            String k = com.baidu.adp.lib.util.t.k(new FileInputStream(file));
            if (k != null) {
                k = k.trim();
            }
            if (TextUtils.isEmpty(k) || TextUtils.isEmpty(trim)) {
                TiebaStatic.log(new au("c10836").Z("obj_type", "apkMd5 or serverMD5 is null").Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
                return false;
            } else if (k.equalsIgnoreCase(trim)) {
                return true;
            } else {
                TiebaStatic.log(new au("c10836").Z("obj_type", "apkMd5 != serverMD5").Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
                BdLog.e("download MD5 RSA ERROR; file:" + file.getName());
                return false;
            }
        } catch (Exception e) {
            TiebaStatic.log(new au("c10836").Z("obj_type", "exception:" + e.getMessage()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
            BdLog.e("download MD5 RSA ERROR！Exception:" + e.getMessage() + " ; file:" + file.getName());
            return false;
        }
    }

    private static int g(char c) {
        int digit = Character.digit(c, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + c);
        }
        return digit;
    }

    public static byte[] gU(String str) {
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
            int g = g(charArray[i]) << 4;
            i = i3 + 1;
            bArr[i2] = (byte) (g(charArray[i3]) | g);
        }
        return bArr;
    }
}
