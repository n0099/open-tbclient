package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
/* loaded from: classes.dex */
public class h {
    public static boolean o(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            TiebaStatic.log(new aq("c10836").dF("obj_type", "checkRSA input args is null"));
            return false;
        }
        try {
            PublicKey loadRSAPublicKey = u.loadRSAPublicKey(com.baidu.adp.lib.util.c.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGKmjUQl+RAVovXDJpDU/V8IEWm0Mejnq1yFD8V7mbTT0iD3XvoZNGQ46xiawGYv/f3MlYrttv2kectaH9HjQHsZI2mM6NbxOm+3lv6oRfAIH+2LQvopr1GRZIyueCCfdzBk+w6twrQFfWrAOAl+8g4+k1eic0oPMyT2EknFv2xwIDAQAB"));
            if (loadRSAPublicKey == null) {
                TiebaStatic.log(new aq("c10836").dF("obj_type", "publicKeyCode is null").dF("obj_source", file.getName()));
                return false;
            }
            byte[] decodeHex = decodeHex(str);
            if (decodeHex == null || decodeHex.length <= 0) {
                TiebaStatic.log(new aq("c10836").dF("obj_type", "server_data is null").dF("obj_source", file.getName()));
                return false;
            }
            byte[] decryptWithRSA = u.decryptWithRSA(loadRSAPublicKey, decodeHex);
            if (decryptWithRSA == null || decryptWithRSA.length <= 0) {
                TiebaStatic.log(new aq("c10836").dF("obj_type", "des is null").dF("obj_source", file.getName()));
                return false;
            }
            String trim = new String(decryptWithRSA, "UTF-8").trim();
            String md5 = s.toMd5(new FileInputStream(file));
            if (md5 != null) {
                md5 = md5.trim();
            }
            if (TextUtils.isEmpty(md5) || TextUtils.isEmpty(trim)) {
                TiebaStatic.log(new aq("c10836").dF("obj_type", "apkMd5 or serverMD5 is null").dF("obj_source", file.getName()));
                return false;
            } else if (md5.equalsIgnoreCase(trim)) {
                return true;
            } else {
                TiebaStatic.log(new aq("c10836").dF("obj_type", "apkMd5 != serverMD5").dF("obj_source", file.getName()));
                BdLog.e("download MD5 RSA ERROR; file:" + file.getName());
                return false;
            }
        } catch (Exception e) {
            TiebaStatic.log(new aq("c10836").dF("obj_type", "exception:" + e.getMessage()).dF("obj_source", file.getName()));
            BdLog.e("download MD5 RSA ERROR！Exception:" + e.getMessage() + " ; file:" + file.getName());
            return false;
        }
    }

    private static int e(char c) {
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
            int e = e(charArray[i]) << 4;
            i = i3 + 1;
            bArr[i2] = (byte) (e(charArray[i3]) | e);
        }
        return bArr;
    }
}
