package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.bumptech.glide.disklrucache.StrictLineReader;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes3.dex */
public class be0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends GZIPOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OutputStream outputStream) {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                ((GZIPOutputStream) this).def.setLevel(i);
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            byte[] bArr2 = new byte[bArr.length];
            byte[] bArr3 = {26, 31, -22, -104, 118, 81, -16, 6, 90, -75, Byte.MIN_VALUE, -40, 85, 92, 106, 114, -20, 34, 116, StrictLineReader.CR, -70, -77, 122, -71, -84, -25, -42, 99, 42, 100, 19, -37, -99, 32, -17, 70, -124, -24, -114, -120, 24, 73, -103, 3, -44, 1, 52, 91, 17, 40, -21, 66, -91, 21, 16, -59, 80, 49, 12, -123, 123, -92, 68, 102, Constants.SHORT_PING_CMD_TYPE, -6, -72, -89, -107, 10, 126, -102, -98, -52, -64, 120, -32, -55, -80, 98, 55, -85, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_END_OF_CAPTION, -101, 84, -90, 121, 125, -28, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, -63, 83, -113, BaseNCodec.PAD_DEFAULT, -67, -57, -15, 22, -19, 94, 28, -46, 97, 43, ByteCompanionObject.MAX_VALUE, -9, 20, 112, -54, Constants.GZIP_CAST_TYPE, -68, -2, -112, -79, -47, -13, 109, 27, -116, -96, -115, -18, -100, 5, Base64.INTERNAL_PADDING, 67, 48, 82, -23, 88, -66, -38, 50, 23, -4, -48, -58, -51, -29, -78, 115, -122, 69, -34, -86, 74, -50, -87, -1, -121, 124, 71, -126, 7, 62, 56, -94, 77, -110, -27, 30, -83, -62, 0, 18, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 104, 29, 78, 25, -41, 2, -65, -8, -3, 89, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, -56, 58, -45, 79, 14, 96, 72, -26, -14, -82, 15, 108, -30, -97, -108, -109, 54, -73, -11, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, -61, -33, 59, -49, 117, -95, 9, 87, 110, -125, -105, 86, 45, 60, -81, -39, -43, -31, -53, 63, -88, 76, -10, 8, 53, 93, 75, -60, 111, 105, -127, 103, -111, -93, 95, 64, -69, -106, -7, 113, 4, -5, -74, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, -117, -12, -35, 51, 119, 65, 33, -36, 107, -119, 57, -118, -76, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS};
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                i = (i + 1) & 255;
                i2 = (bArr3[i] + i2) & 255;
                byte b = bArr3[i];
                bArr3[i] = bArr3[i2];
                bArr3[i2] = b;
                bArr2[i3] = (byte) (bArr[i3] ^ bArr3[(bArr3[i] + bArr3[i2]) & 255]);
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            a aVar = new a(byteArrayOutputStream);
            aVar.a(9);
            aVar.write(bArr);
            aVar.close();
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }
}
