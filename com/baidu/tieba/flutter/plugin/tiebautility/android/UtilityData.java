package com.baidu.tieba.flutter.plugin.tiebautility.android;

import android.content.res.Resources;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityDataAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.h;
import d.a.d.e.m.a;
import d.a.d.e.p.k;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class UtilityData implements TiebaUtilityDataAuto.HostUtilityData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilityData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private int getResIdBySkin(String str, int i2) {
        InterceptResult invokeLI;
        int darkResourceId;
        int nightResouceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, str, i2)) == null) {
            if (k.isEmpty(str)) {
                return i2;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(str) && (nightResouceId = SkinManager.getNightResouceId(TbadkCoreApplication.getInst().getResources(), i2)) > 0) {
                i2 = nightResouceId;
            }
            return (!SkinManager.SKIN_TYPE_STR_DARK.equals(str) || (darkResourceId = SkinManager.getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i2)) <= 0) ? i2 : darkResourceId;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityDataAuto.HostUtilityData
    public void getLottieBytes(TiebaUtilityDataAuto.GetLottieParam getLottieParam, TiebaUtilityDataAuto.Result<TiebaUtilityDataAuto.LottieResult> result) {
        byte[] readFileFromRaw;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, getLottieParam, result) == null) {
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
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0034 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x004c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.InputStream] */
    public byte[] readFileFromAsset(String str) {
        InterceptResult invokeL;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
            return (byte[]) invokeL.objValue;
        }
        byte[] bArr = new byte[1024];
        InputStream inputStream = null;
        try {
            try {
                str = BdBaseApplication.getInst().getAssets().open(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            str = 0;
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
                    int read = str.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        a.c(str);
                        a.d(byteArrayOutputStream);
                        return byteArray;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    a.c(str);
                    a.d(byteArrayOutputStream);
                    return null;
                }
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            inputStream = str;
            a.c(inputStream);
            a.d(outputStream);
            throw th;
        }
    }

    public byte[] readFileFromRaw(Resources resources, int i2) {
        InterceptResult invokeLI;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, resources, i2)) != null) {
            return (byte[]) invokeLI.objValue;
        }
        byte[] bArr = new byte[1024];
        InputStream inputStream2 = null;
        try {
            inputStream = resources.openRawResource(i2);
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
            a.c(inputStream2);
            a.d(byteArrayOutputStream);
            throw th;
        }
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
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        a.c(inputStream);
                        a.d(byteArrayOutputStream);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    a.c(inputStream2);
                    a.d(byteArrayOutputStream);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            inputStream2 = inputStream;
            a.c(inputStream2);
            a.d(byteArrayOutputStream);
            throw th;
        }
    }
}
