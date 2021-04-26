package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import android.content.res.Resources;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityDataAuto;
import d.a.c.a.h;
import d.a.c.e.m.a;
import d.a.c.e.p.k;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class UtilityData implements TiebaUtilityDataAuto.HostUtilityData {
    private int getResIdBySkin(String str, int i2) {
        int darkResourceId;
        int nightResouceId;
        if (k.isEmpty(str)) {
            return i2;
        }
        if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(str) && (nightResouceId = SkinManager.getNightResouceId(TbadkCoreApplication.getInst().getResources(), i2)) > 0) {
            i2 = nightResouceId;
        }
        return (!SkinManager.SKIN_TYPE_STR_DARK.equals(str) || (darkResourceId = SkinManager.getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i2)) <= 0) ? i2 : darkResourceId;
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityDataAuto.HostUtilityData
    public void getLottieBytes(TiebaUtilityDataAuto.GetLottieParam getLottieParam, TiebaUtilityDataAuto.Result<TiebaUtilityDataAuto.LottieResult> result) {
        byte[] readFileFromRaw;
        String name = getLottieParam.getName();
        String themeStr = getLottieParam.getThemeStr();
        Resources b2 = h.a().b();
        String androidAssetsNameFromIos = ResNameTransform.getAndroidAssetsNameFromIos(name);
        TiebaUtilityDataAuto.LottieResult lottieResult = new TiebaUtilityDataAuto.LottieResult();
        if (androidAssetsNameFromIos != null) {
            byte[] readFileFromAsset = readFileFromAsset(androidAssetsNameFromIos);
            if (readFileFromAsset == null || readFileFromAsset.length <= 0) {
                return;
            }
            lottieResult.setLottie(readFileFromAsset);
            result.success(lottieResult);
            return;
        }
        int resIdBySkin = getResIdBySkin(themeStr, b2.getIdentifier(ResNameTransform.getAndroidNameFromIos(name), "raw", BdBaseApplication.getInst().getPackageName()));
        if (resIdBySkin == 0 || (readFileFromRaw = readFileFromRaw(b2, resIdBySkin)) == null || readFileFromRaw.length <= 0) {
            return;
        }
        lottieResult.setLottie(readFileFromRaw);
        result.success(lottieResult);
    }

    public byte[] readFileFromAsset(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        byte[] bArr = new byte[1024];
        InputStream inputStream2 = null;
        try {
            inputStream = BdBaseApplication.getInst().getAssets().open(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        try {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                byteArrayOutputStream.flush();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                a.c(inputStream);
                                a.d(byteArrayOutputStream);
                                return byteArray;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            a.c(inputStream);
                            a.d(byteArrayOutputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                        a.c(inputStream2);
                        a.d(byteArrayOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                inputStream2 = inputStream;
                a.c(inputStream2);
                a.d(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            a.c(inputStream2);
            a.d(byteArrayOutputStream);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x0028 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0041 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public byte[] readFileFromRaw(Resources resources, int i2) {
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = new byte[1024];
        InputStream inputStream = null;
        try {
            try {
                resources = resources.openRawResource(i2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            resources = 0;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            a.c(inputStream);
            a.d(outputStream);
            throw th;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = resources.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        a.c(resources);
                        a.d(byteArrayOutputStream);
                        return byteArray;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    a.c(resources);
                    a.d(byteArrayOutputStream);
                    return null;
                }
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            i2 = 0;
            inputStream = resources;
            outputStream = i2;
            a.c(inputStream);
            a.d(outputStream);
            throw th;
        }
    }
}
