package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(Context context, Uri uri, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, uri, i)) == null) {
            try {
                return BitmapHelper.subSampleBitmap(context, uri, i);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap b(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, str, i)) == null) {
            try {
                return BitmapHelper.loadResizedBitmap(str, i, i);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap c(int i, Context context, Uri uri, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), context, uri, str, Integer.valueOf(i2)})) == null) {
            if (i == 12001) {
                return d(i2);
            }
            if (!TextUtils.isEmpty(str)) {
                return b(context, str, i2);
            }
            return a(context, uri, i2);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            try {
                int e = e(FileHelper.getFileDireciory(SelectImageHelper.TMP_IMAGE_NAME));
                Bitmap subSampleBitmap = BitmapHelper.subSampleBitmap(SelectImageHelper.TMP_IMAGE_NAME, i);
                if (e != 0 && subSampleBitmap != null) {
                    return BitmapHelper.rotateBitmapBydegree(subSampleBitmap, e);
                }
                return subSampleBitmap;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeI.objValue;
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt != 3) {
                    if (attributeInt != 6) {
                        if (attributeInt != 8) {
                            return 0;
                        }
                        return 270;
                    }
                    return 90;
                }
                return 180;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
