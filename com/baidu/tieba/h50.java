package com.baidu.tieba;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
/* loaded from: classes6.dex */
public final class h50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? new byte[]{ExifInterface.MARKER_SOF7, 117, 76, 90, 52, -92, 15, ExifInterface.START_CODE, 26, 37, 0, -124, 76, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 108, -30, -14, -12, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, 20, -35, -89, -20, 114, -66, 34, ExifInterface.MARKER_SOF10, 104, 14, -117, 75} : (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new byte[]{ExifInterface.MARKER_SOF7, 117, 76, 90, 52, -92, 15, ExifInterface.START_CODE, 26, 37, 0, -124, 83, 56, 126, -30, -88, -28} : (byte[]) invokeV.objValue;
    }

    public static byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new byte[]{ExifInterface.MARKER_SOF7, 117, 76, 90, 52, -92, 15, ExifInterface.START_CODE, 26, 37, 0, -124, 65, 45, 110, -43, -67, -19, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 24} : (byte[]) invokeV.objValue;
    }
}
