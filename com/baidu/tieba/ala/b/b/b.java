package com.baidu.tieba.ala.b.b;

import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes10.dex */
public class b {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(HEX_DIGITS[(bArr[i] & 240) >>> 4]);
            sb.append(HEX_DIGITS[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static String getFileMD5(String str) {
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return toHexString(messageDigest.digest());
                }
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static String ep(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = EncryptUtils.ENCRYPT_MD5;
            }
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            if (TextUtils.isEmpty(str) || messageDigest == null) {
                return null;
            }
            messageDigest.update(str.getBytes());
            StringBuilder sb = new StringBuilder();
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return null;
            }
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 >> 4) & 15));
                sb.append(Integer.toHexString(b2 & 15));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
