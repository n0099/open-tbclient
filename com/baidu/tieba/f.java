package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.PublicKey;
/* loaded from: classes.dex */
public class f {
    public static boolean c(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            TiebaStatic.log(new ak("c10836").ab("obj_type", "checkRSA input args is null"));
            return false;
        }
        try {
            PublicKey m = u.m(com.baidu.adp.lib.util.c.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGKmjUQl+RAVovXDJpDU/V8IEWm0Mejnq1yFD8V7mbTT0iD3XvoZNGQ46xiawGYv/f3MlYrttv2kectaH9HjQHsZI2mM6NbxOm+3lv6oRfAIH+2LQvopr1GRZIyueCCfdzBk+w6twrQFfWrAOAl+8g4+k1eic0oPMyT2EknFv2xwIDAQAB"));
            if (m == null) {
                TiebaStatic.log(new ak("c10836").ab("obj_type", "publicKeyCode is null").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
                return false;
            }
            byte[] decodeHex = decodeHex(str);
            if (decodeHex == null || decodeHex.length <= 0) {
                TiebaStatic.log(new ak("c10836").ab("obj_type", "server_data is null").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
                return false;
            }
            byte[] b = u.b((Key) m, decodeHex);
            if (b == null || b.length <= 0) {
                TiebaStatic.log(new ak("c10836").ab("obj_type", "des is null").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
                return false;
            }
            String trim = new String(b, "UTF-8").trim();
            String e = s.e(new FileInputStream(file));
            if (e != null) {
                e = e.trim();
            }
            if (TextUtils.isEmpty(e) || TextUtils.isEmpty(trim)) {
                TiebaStatic.log(new ak("c10836").ab("obj_type", "apkMd5 or serverMD5 is null").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
                return false;
            } else if (e.equalsIgnoreCase(trim)) {
                return true;
            } else {
                TiebaStatic.log(new ak("c10836").ab("obj_type", "apkMd5 != serverMD5").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
                BdLog.e("download MD5 RSA ERROR; file:" + file.getName());
                return false;
            }
        } catch (Exception e2) {
            TiebaStatic.log(new ak("c10836").ab("obj_type", "exception:" + e2.getMessage()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, file.getName()));
            BdLog.e("download MD5 RSA ERROR！Exception:" + e2.getMessage() + " ; file:" + file.getName());
            return false;
        }
    }

    private static int h(char c) {
        int digit = Character.digit(c, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + c);
        }
        return digit;
    }

    public static byte[] decodeHex(String str) {
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
            int h = h(charArray[i]) << 4;
            i = i3 + 1;
            bArr[i2] = (byte) (h(charArray[i3]) | h);
        }
        return bArr;
    }
}
