package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes5.dex */
public final class f40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return new byte[]{ExifInterface.MARKER_SOF7, 117, 76, 90, 52, -92, 15, ExifInterface.START_CODE, 26, 37, 0, -124, 69, 32, ByteCompanionObject.MAX_VALUE, -32, -73, -44, 32, 20, ExifInterface.MARKER_APP1, -20, -28, 118, -89, ByteCompanionObject.MAX_VALUE, -6, 83, 34, -42};
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new byte[]{ExifInterface.MARKER_SOF7, 117, 76, 90, 52, -92, 15, ExifInterface.START_CODE, 26, 37, 0, -124, 65, 58, 123, -19, -88, -44, 32, 20, ExifInterface.MARKER_APP1, -20, -28, 118, -89, ByteCompanionObject.MAX_VALUE, -6, 83, 34, -42};
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new byte[]{ExifInterface.MARKER_SOF7, 117, 76, 90, 52, -92, 15, ExifInterface.START_CODE, 26, 37, 0, -124, 84, 45, 108, -20, -73, -28, 7, 15, ExifInterface.MARKER_SOI, ExifInterface.MARKER_EOI, -13, 105, -93, Constants.SHORT_PING_CMD_TYPE, -6, 73, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, -41, 23};
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new byte[]{ExifInterface.MARKER_SOF7, 117, 76, 90, 52, -92, 15, ExifInterface.START_CODE, 26, 37, 0, -124, 84, 45, 118, -26, -67, -14, 55, 45, -44, -5, -27, 114, -67, 120, -24, 88, 33, -35, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, -37, Constants.GZIP_CAST_TYPE, 17, -24, 67, -119, 93, 51, 122, 111, 9, 58};
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new byte[]{ExifInterface.MARKER_SOF7, 117, 76, 90, 52, -92, 15, ExifInterface.START_CODE, 26, 37, 0, -124, 82, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 113, -26, -116, -28, 32, 14, ExifInterface.MARKER_SOI, -6, -30, 122, -84, 96, -20, 111, 63, -47, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, -52, 16, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, -28, 66, -105, 93, 47, 103};
        }
        return (byte[]) invokeV.objValue;
    }
}
