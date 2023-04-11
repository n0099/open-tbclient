package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.codec.net.QCodec;
/* loaded from: classes3.dex */
public class ai {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public static final byte[] b;
    public static final byte[] c;
    public static final byte[] d;
    public static final byte[] e;
    public static final byte[] f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public int b;
        public byte[] c;
        public int d;
        public int e;
        public boolean f;
        public byte[] g;
        public boolean h;
        public int i;
        public byte[] j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OutputStream outputStream, int i) {
            super(outputStream);
            boolean z;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if ((i & 8) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.f = z;
            boolean z2 = (i & 1) != 0;
            this.a = z2;
            if (z2) {
                i2 = 3;
            } else {
                i2 = 4;
            }
            this.d = i2;
            this.c = new byte[i2];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i;
            this.j = ai.o(i);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.ai.c(byte[], byte[], int, int):byte[]
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        public void a() throws java.io.IOException {
            /*
                r5 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.ai.a.$ic
                if (r0 != 0) goto L27
            L4:
                int r0 = r5.b
                if (r0 <= 0) goto L26
                boolean r1 = r5.a
                if (r1 == 0) goto L1e
                java.io.OutputStream r1 = r5.out
                byte[] r2 = r5.g
                byte[] r3 = r5.c
                int r4 = r5.i
                com.baidu.tieba.ai.c(r2, r3, r0, r4)
                r1.write(r2)
                r0 = 0
                r5.b = r0
                goto L26
            L1e:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Base64 input not properly padded."
                r0.<init>(r1)
                throw r0
            L26:
                return
            L27:
                r3 = r0
                r4 = 1048576(0x100000, float:1.469368E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r3.invokeV(r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ai.a.a():void");
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a();
                super.close();
                this.c = null;
                ((FilterOutputStream) this).out = null;
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.ai.c(byte[], byte[], int, int):byte[]
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int r6) throws java.io.IOException {
            /*
                r5 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.ai.a.$ic
                if (r0 != 0) goto L7f
            L4:
                boolean r0 = r5.h
                if (r0 == 0) goto Le
                java.io.OutputStream r0 = r5.out
                r0.write(r6)
                return
            Le:
                boolean r0 = r5.a
                r1 = 0
                if (r0 == 0) goto L48
                byte[] r0 = r5.c
                int r2 = r5.b
                int r3 = r2 + 1
                r5.b = r3
                byte r6 = (byte) r6
                r0[r2] = r6
                int r6 = r5.d
                if (r3 < r6) goto L76
                java.io.OutputStream r2 = r5.out
                byte[] r3 = r5.g
                int r4 = r5.i
                com.baidu.tieba.ai.c(r3, r0, r6, r4)
                r2.write(r3)
                int r6 = r5.e
                int r6 = r6 + 4
                r5.e = r6
                boolean r0 = r5.f
                if (r0 == 0) goto L45
                r0 = 76
                if (r6 < r0) goto L45
                java.io.OutputStream r6 = r5.out
                r0 = 10
                r6.write(r0)
                r5.e = r1
            L45:
                r5.b = r1
                goto L76
            L48:
                byte[] r0 = r5.j
                r2 = r6 & 127(0x7f, float:1.78E-43)
                r3 = r0[r2]
                r4 = -5
                if (r3 <= r4) goto L72
                byte[] r0 = r5.c
                int r2 = r5.b
                int r3 = r2 + 1
                r5.b = r3
                byte r6 = (byte) r6
                r0[r2] = r6
                int r6 = r5.d
                if (r3 < r6) goto L76
                byte[] r6 = r5.g
                int r2 = r5.i
                int r6 = com.baidu.tieba.ai.b(r0, r1, r6, r1, r2)
                java.io.OutputStream r0 = r5.out
                byte[] r2 = r5.g
                r0.write(r2, r1, r6)
                r5.b = r1
                goto L76
            L72:
                r6 = r0[r2]
                if (r6 != r4) goto L77
            L76:
                return
            L77:
                java.io.IOException r6 = new java.io.IOException
                java.lang.String r0 = "Invalid character in Base64 data."
                r6.<init>(r0)
                throw r6
            L7f:
                r3 = r0
                r4 = 1048578(0x100002, float:1.469371E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r3.invokeI(r4, r5, r6)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ai.a.write(int):void");
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i, i2) == null) {
                if (this.h) {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                    return;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    write(bArr[i + i3]);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448299653, "Lcom/baidu/tieba/ai;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448299653, "Lcom/baidu/tieba/ai;");
                return;
            }
        }
        a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        b = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 37, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        c = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, QCodec.UNDERSCORE};
        d = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 37, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        e = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, QCodec.UNDERSCORE, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        f = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, -9, -9, -9, -9, 37, -9, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    public static byte[] d(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return e(str, 0);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String j(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            try {
                return l(bArr, 0, bArr.length, 0);
            } catch (IOException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static final byte[] n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i)) == null) {
            if ((i & 16) == 16) {
                return c;
            }
            if ((i & 32) == 32) {
                return e;
            }
            return a;
        }
        return (byte[]) invokeI.objValue;
    }

    public static final byte[] o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) {
            if ((i & 16) == 16) {
                return d;
            }
            if ((i & 32) == 32) {
                return f;
            }
            return b;
        }
        return (byte[]) invokeI.objValue;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.ai.a.write(int):void] */
    public static /* synthetic */ int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        return g(bArr, i, bArr2, i2, i3);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ byte[] c(byte[] r0, byte[] r1, int r2, int r3) {
        /*
            i(r0, r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ai.c(byte[], byte[], int, int):byte[]");
    }

    public static byte[] i(byte[] bArr, byte[] bArr2, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65545, null, bArr, bArr2, i, i2)) == null) {
            h(bArr2, 0, i, bArr, 0, i2);
            return bArr;
        }
        return (byte[]) invokeLLII.objValue;
    }

    public static String l(byte[] bArr, int i, int i2, int i3) throws IOException {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65548, null, bArr, i, i2, i3)) == null) {
            byte[] m = m(bArr, i, i2, i3);
            try {
                return new String(m, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                return new String(m);
            }
        }
        return (String) invokeLIII.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0066 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0086 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x005d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x003d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x005d -> B:81:0x005d). Please submit an issue!!! */
    public static byte[] e(String str, int i) throws IOException {
        GZIPInputStream gZIPInputStream;
        byte[] bytes;
        boolean z;
        ?? length;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            gZIPInputStream = null;
            InterceptResult invokeLI = interceptable.invokeLI(65541, null, str, i);
            if (invokeLI != null) {
                return (byte[]) invokeLI.objValue;
            }
        }
        if (str != null) {
            try {
                bytes = str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                bytes = str.getBytes();
            }
            byte[] f2 = f(bytes, 0, bytes.length, i);
            if ((i & 4) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (f2 != null && (length = f2.length) >= 4 && !z && 35615 == ((f2[0] & 255) | ((f2[1] << 8) & 65280))) {
                byte[] bArr = new byte[2048];
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            length = new ByteArrayInputStream(f2);
                            try {
                                gZIPInputStream = new GZIPInputStream(length);
                                while (true) {
                                    try {
                                        int read = gZIPInputStream.read(bArr);
                                        if (read < 0) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr, 0, read);
                                    } catch (IOException e2) {
                                        e = e2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        length = length;
                                        try {
                                            e.printStackTrace();
                                            byteArrayOutputStream.close();
                                            gZIPInputStream.close();
                                            length.close();
                                            return f2;
                                        } catch (Throwable th) {
                                            th = th;
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused2) {
                                            }
                                            try {
                                                gZIPInputStream.close();
                                            } catch (Exception unused3) {
                                            }
                                            try {
                                                length.close();
                                            } catch (Exception unused4) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        byteArrayOutputStream.close();
                                        gZIPInputStream.close();
                                        length.close();
                                        throw th;
                                    }
                                }
                                f2 = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.close();
                            } catch (IOException e3) {
                                e = e3;
                                gZIPInputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPInputStream = null;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            length = 0;
                            gZIPInputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            length = 0;
                            gZIPInputStream = null;
                        }
                    } catch (Exception unused5) {
                    }
                } catch (IOException e5) {
                    e = e5;
                    length = 0;
                    gZIPInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    length = 0;
                    gZIPInputStream = null;
                }
                try {
                    gZIPInputStream.close();
                } catch (Exception unused6) {
                }
                try {
                    length.close();
                } catch (Exception unused7) {
                }
            }
            return f2;
        }
        throw new NullPointerException("Input string was null.");
    }

    public static byte[] f(byte[] bArr, int i, int i2, int i3) throws IOException {
        InterceptResult invokeLIII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65542, null, bArr, i, i2, i3)) == null) {
            if (bArr != null) {
                if (i >= 0 && (i4 = i + i2) <= bArr.length) {
                    if (i2 == 0) {
                        return new byte[0];
                    }
                    if (i2 >= 4) {
                        byte[] o = o(i3);
                        byte[] bArr2 = new byte[(i2 * 3) / 4];
                        byte[] bArr3 = new byte[4];
                        int i5 = 0;
                        int i6 = 0;
                        while (i < i4) {
                            byte b2 = o[bArr[i] & 255];
                            if (b2 >= -5) {
                                if (b2 >= -1) {
                                    int i7 = i5 + 1;
                                    bArr3[i5] = bArr[i];
                                    if (i7 > 3) {
                                        i6 += g(bArr3, 0, bArr2, i6, i3);
                                        if (bArr[i] == 61) {
                                            break;
                                        }
                                        i5 = 0;
                                    } else {
                                        i5 = i7;
                                    }
                                }
                                i++;
                            } else {
                                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i] & 255), Integer.valueOf(i)));
                            }
                        }
                        byte[] bArr4 = new byte[i6];
                        System.arraycopy(bArr2, 0, bArr4, 0, i6);
                        return bArr4;
                    }
                    throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i2);
                }
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            throw new NullPointerException("Cannot decode null source array.");
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static int g(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (bArr != null) {
                if (bArr2 != null) {
                    if (i >= 0 && (i4 = i + 3) < bArr.length) {
                        if (i2 >= 0 && (i5 = i2 + 2) < bArr2.length) {
                            byte[] o = o(i3);
                            int i6 = i + 2;
                            if (bArr[i6] == 61) {
                                bArr2[i2] = (byte) ((((o[bArr[i + 1]] & 255) << 12) | ((o[bArr[i]] & 255) << 18)) >>> 16);
                                return 1;
                            } else if (bArr[i4] == 61) {
                                int i7 = ((o[bArr[i6]] & 255) << 6) | ((o[bArr[i + 1]] & 255) << 12) | ((o[bArr[i]] & 255) << 18);
                                bArr2[i2] = (byte) (i7 >>> 16);
                                bArr2[i2 + 1] = (byte) (i7 >>> 8);
                                return 2;
                            } else {
                                int i8 = (o[bArr[i4]] & 255) | ((o[bArr[i + 1]] & 255) << 12) | ((o[bArr[i]] & 255) << 18) | ((o[bArr[i6]] & 255) << 6);
                                bArr2[i2] = (byte) (i8 >> 16);
                                bArr2[i2 + 1] = (byte) (i8 >> 8);
                                bArr2[i5] = (byte) i8;
                                return 3;
                            }
                        }
                        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
                    }
                    throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
                }
                throw new NullPointerException("Destination array was null.");
            }
            throw new NullPointerException("Source array was null.");
        }
        return invokeCommon.intValue;
    }

    public static byte[] h(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            byte[] n = n(i4);
            int i7 = 0;
            if (i2 > 0) {
                i5 = (bArr[i] << 24) >>> 8;
            } else {
                i5 = 0;
            }
            if (i2 > 1) {
                i6 = (bArr[i + 1] << 24) >>> 16;
            } else {
                i6 = 0;
            }
            int i8 = i5 | i6;
            if (i2 > 2) {
                i7 = (bArr[i + 2] << 24) >>> 24;
            }
            int i9 = i8 | i7;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return bArr2;
                    }
                    bArr2[i3] = n[i9 >>> 18];
                    bArr2[i3 + 1] = n[(i9 >>> 12) & 63];
                    bArr2[i3 + 2] = n[(i9 >>> 6) & 63];
                    bArr2[i3 + 3] = n[i9 & 63];
                    return bArr2;
                }
                bArr2[i3] = n[i9 >>> 18];
                bArr2[i3 + 1] = n[(i9 >>> 12) & 63];
                bArr2[i3 + 2] = n[(i9 >>> 6) & 63];
                bArr2[i3 + 3] = 61;
                return bArr2;
            }
            bArr2[i3] = n[i9 >>> 18];
            bArr2[i3 + 1] = n[(i9 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static String k(byte[] bArr, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, bArr, i)) == null) {
            return l(bArr, 0, bArr.length, i);
        }
        return (String) invokeLI.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0040 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0044 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v20, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] m(byte[] bArr, int i, int i2, int i3) throws IOException {
        InterceptResult invokeLIII;
        boolean z;
        int i4;
        ByteArrayOutputStream byteArrayOutputStream;
        a aVar;
        GZIPOutputStream gZIPOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65549, null, bArr, i, i2, i3)) == null) {
            if (bArr != null) {
                if (i >= 0) {
                    if (i2 >= 0) {
                        if (i + i2 <= bArr.length) {
                            if ((i3 & 2) != 0) {
                                GZIPOutputStream gZIPOutputStream2 = null;
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    try {
                                        aVar = new a(byteArrayOutputStream, i3 | 1);
                                        try {
                                            gZIPOutputStream = new GZIPOutputStream(aVar);
                                            try {
                                                gZIPOutputStream.write(bArr, i, i2);
                                                gZIPOutputStream.close();
                                                try {
                                                    gZIPOutputStream.close();
                                                } catch (Exception unused) {
                                                }
                                                try {
                                                    aVar.close();
                                                } catch (Exception unused2) {
                                                }
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Exception unused3) {
                                                }
                                                return byteArrayOutputStream.toByteArray();
                                            } catch (IOException e2) {
                                                e = e2;
                                                gZIPOutputStream2 = byteArrayOutputStream;
                                                try {
                                                    throw e;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    byteArrayOutputStream = gZIPOutputStream2;
                                                    gZIPOutputStream2 = gZIPOutputStream;
                                                    try {
                                                        gZIPOutputStream2.close();
                                                    } catch (Exception unused4) {
                                                    }
                                                    try {
                                                        aVar.close();
                                                    } catch (Exception unused5) {
                                                    }
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused6) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                gZIPOutputStream2 = gZIPOutputStream;
                                                gZIPOutputStream2.close();
                                                aVar.close();
                                                byteArrayOutputStream.close();
                                                throw th;
                                            }
                                        } catch (IOException e3) {
                                            e = e3;
                                            gZIPOutputStream = null;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            gZIPOutputStream2.close();
                                            aVar.close();
                                            byteArrayOutputStream.close();
                                            throw th;
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                        aVar = null;
                                        gZIPOutputStream = null;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        aVar = null;
                                    }
                                } catch (IOException e5) {
                                    e = e5;
                                    aVar = null;
                                    gZIPOutputStream = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    byteArrayOutputStream = 0;
                                    aVar = null;
                                }
                            } else {
                                if ((i3 & 8) != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                int i5 = (i2 / 3) * 4;
                                if (i2 % 3 > 0) {
                                    i4 = 4;
                                } else {
                                    i4 = 0;
                                }
                                int i6 = i5 + i4;
                                if (z) {
                                    i6 += i6 / 76;
                                }
                                int i7 = i6;
                                byte[] bArr2 = new byte[i7];
                                int i8 = i2 - 2;
                                int i9 = 0;
                                int i10 = 0;
                                int i11 = 0;
                                while (i9 < i8) {
                                    int i12 = i9;
                                    h(bArr, i9 + i, 3, bArr2, i10, i3);
                                    int i13 = i11 + 4;
                                    if (z && i13 >= 76) {
                                        bArr2[i10 + 4] = 10;
                                        i10++;
                                        i11 = 0;
                                    } else {
                                        i11 = i13;
                                    }
                                    i9 = i12 + 3;
                                    i10 += 4;
                                }
                                int i14 = i9;
                                if (i14 < i2) {
                                    h(bArr, i14 + i, i2 - i14, bArr2, i10, i3);
                                    i10 += 4;
                                }
                                int i15 = i10;
                                if (i15 <= i7 - 1) {
                                    byte[] bArr3 = new byte[i15];
                                    System.arraycopy(bArr2, 0, bArr3, 0, i15);
                                    return bArr3;
                                }
                                return bArr2;
                            }
                        } else {
                            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot have length offset: " + i2);
                    }
                } else {
                    throw new IllegalArgumentException("Cannot have negative offset: " + i);
                }
            } else {
                throw new NullPointerException("Cannot serialize a null array.");
            }
        } else {
            return (byte[]) invokeLIII.objValue;
        }
    }
}
