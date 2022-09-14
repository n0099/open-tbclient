package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes4.dex */
public class fc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<String> a(String str, InputStream inputStream) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, str, inputStream)) != null) {
            return (List) invokeLL.objValue;
        }
        ZipInputStream zipInputStream = null;
        try {
            ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(inputStream));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    } else if (!nextEntry.isDirectory()) {
                        h(str, nextEntry.getName(), zipInputStream2);
                    }
                } catch (Throwable th) {
                    th = th;
                    zipInputStream = zipInputStream2;
                    fj.e(zipInputStream);
                    throw th;
                }
            }
            zipInputStream2.close();
            fj.e(zipInputStream2);
            byte[] e = e(str, "map.txt");
            if (e != null) {
                String str2 = new String(e, "UTF-8");
                LinkedList linkedList = new LinkedList();
                for (String str3 : str2.split("\n")) {
                    String trim = str3.trim();
                    if (trim.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                        String[] split = trim.split("=");
                        if (split.length == 2) {
                            String trim2 = split[0].trim();
                            String trim3 = split[1].trim();
                            g(str, "s_" + trim3 + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX, b(trim2, false));
                            g(str, "d_" + trim3 + ".gif", b(trim2, true));
                            linkedList.add(trim2);
                        }
                    }
                }
                return linkedList;
            }
            throw new FileNotFoundException("map.txt file not exsit!");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, str, z)) == null) {
            long hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "d_" : "s_");
            sb.append(hashCode);
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static String c(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            long hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "s_" : "d_");
            sb.append(hashCode);
            String sb2 = sb.toString();
            if (z2 && !z) {
                return sb2 + ".gif";
            }
            return sb2 + ".jpg";
        }
        return (String) invokeCommon.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Bitmap f = f(str, "panel.png");
            if (f == null) {
                return false;
            }
            f.recycle();
            return true;
        }
        return invokeL.booleanValue;
    }

    public static byte[] e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            return FileHelper.GetFileData(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + (".emotions/" + str) + "/" + str2);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static Bitmap f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            return FileHelper.getImage(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + (".emotions/" + str) + "/" + str2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static boolean g(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, str2, str3)) == null) {
            String str4 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.emotions/" + str + "/";
            File file = new File(str4, str2);
            if (file.exists()) {
                File file2 = new File(str4, str3);
                if (file2.exists()) {
                    if (file2.delete() && file.renameTo(file2)) {
                        return true;
                    }
                    return FileHelper.copyFileByRelativelyPath(file.getAbsolutePath(), file2.getAbsolutePath());
                } else if (file.renameTo(file2)) {
                    return true;
                } else {
                    return FileHelper.copyFileByRelativelyPath(file.getAbsolutePath(), file2.getAbsolutePath());
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean h(String str, String str2, InputStream inputStream) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, inputStream)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath());
            sb.append("/");
            sb.append(".emotions/" + str);
            sb.append("/");
            sb.append(str2);
            return FileHelper.saveFileByStream(sb.toString(), inputStream) != null;
        }
        return invokeLLL.booleanValue;
    }
}
