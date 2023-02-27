package com.baidu.tieba;

import android.media.AudioRecord;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gp {
    public static /* synthetic */ Interceptable $ic;
    public static gp e;
    public static int[] f;
    public static short[] g;
    public static short[] h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public short b;
    public short c;
    public int d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448305636, "Lcom/baidu/tieba/gp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448305636, "Lcom/baidu/tieba/gp;");
                return;
            }
        }
        f = new int[]{8000, 11025, 16000, 22050, 32000, 44100, 47250, 48000};
        g = new short[]{2, 3};
        h = new short[]{2, 16, 12, 3};
    }

    public gp() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = -2;
    }

    public static gp b() {
        InterceptResult invokeV;
        gp gpVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            gp gpVar2 = e;
            if (gpVar2 == null) {
                synchronized (gp.class) {
                    if (e == null) {
                        e = new gp();
                    }
                    gpVar = e;
                }
                return gpVar;
            }
            return gpVar2;
        }
        return (gp) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x011c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AudioRecord a() throws IllegalArgumentException {
        InterceptResult invokeV;
        int[] iArr;
        int i;
        int i2;
        short[] sArr;
        short s;
        int i3;
        int i4;
        int minBufferSize;
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a > 0 && this.b > 0 && this.c > 0) {
                return new AudioRecord(1, this.a, this.c, this.b, this.d);
            }
            int[] iArr2 = f;
            int length = iArr2.length;
            AudioRecord audioRecord2 = null;
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = iArr2[i5];
                short[] sArr2 = g;
                int length2 = sArr2.length;
                int i7 = 0;
                while (i7 < length2) {
                    short s2 = sArr2[i7];
                    short[] sArr3 = h;
                    int length3 = sArr3.length;
                    AudioRecord audioRecord3 = audioRecord2;
                    int i8 = 0;
                    while (i8 < length3) {
                        short s3 = sArr3[i8];
                        try {
                            minBufferSize = AudioRecord.getMinBufferSize(i6, s3, s2);
                            this.d = minBufferSize;
                        } catch (Throwable th) {
                            th = th;
                            iArr = iArr2;
                            i = i8;
                            i2 = length3;
                            sArr = sArr3;
                            s = s2;
                            i3 = i7;
                            i4 = 1;
                        }
                        if (minBufferSize == -2) {
                            if (audioRecord3 != null && audioRecord3.getState() != 1) {
                                audioRecord3.release();
                                iArr = iArr2;
                                i = i8;
                                i2 = length3;
                                sArr = sArr3;
                                s = s2;
                                i3 = i7;
                                audioRecord3 = null;
                            } else {
                                iArr = iArr2;
                                i = i8;
                                i2 = length3;
                                sArr = sArr3;
                                s = s2;
                                i3 = i7;
                            }
                        } else {
                            int min = Math.min(minBufferSize * 8, 4096);
                            iArr = iArr2;
                            i4 = 1;
                            i = i8;
                            i2 = length3;
                            sArr = sArr3;
                            short s4 = s2;
                            i3 = i7;
                            try {
                                audioRecord = new AudioRecord(1, i6, s3, s2, min);
                                try {
                                } catch (Throwable th2) {
                                    th = th2;
                                    s = s4;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                if (audioRecord.getState() == 1) {
                                    try {
                                        this.a = i6;
                                        try {
                                            this.b = s4;
                                            this.c = s3;
                                            this.d = min;
                                            if (audioRecord.getState() != 1) {
                                                audioRecord.release();
                                            }
                                            return audioRecord;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            audioRecord3 = audioRecord;
                                            s = s4;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        audioRecord3 = audioRecord;
                                        s = s4;
                                        th.printStackTrace();
                                        if (audioRecord3 != null) {
                                        }
                                        i8 = i + 1;
                                        s2 = s;
                                        length3 = i2;
                                        iArr2 = iArr;
                                        sArr3 = sArr;
                                        i7 = i3;
                                    }
                                } else {
                                    try {
                                        audioRecord.release();
                                    } catch (Throwable th6) {
                                        th = th6;
                                        s = s4;
                                    }
                                    try {
                                        audioRecord3 = new AudioRecord(1, i6, s3, s4, this.d);
                                        try {
                                        } catch (Throwable th7) {
                                            th = th7;
                                            s = s4;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        s = s4;
                                        audioRecord3 = audioRecord;
                                        th.printStackTrace();
                                        if (audioRecord3 != null) {
                                        }
                                        i8 = i + 1;
                                        s2 = s;
                                        length3 = i2;
                                        iArr2 = iArr;
                                        sArr3 = sArr;
                                        i7 = i3;
                                    }
                                    if (audioRecord3.getState() == 1) {
                                        this.a = i6;
                                        s = s4;
                                        try {
                                            this.b = s;
                                            this.c = s3;
                                            if (audioRecord3.getState() != 1) {
                                                audioRecord3.release();
                                            }
                                            return audioRecord3;
                                        } catch (Throwable th9) {
                                            th = th9;
                                        }
                                    } else {
                                        s = s4;
                                        if (audioRecord3.getState() == 1) {
                                        }
                                        audioRecord3.release();
                                        audioRecord3 = null;
                                    }
                                }
                                th.printStackTrace();
                                if (audioRecord3 != null) {
                                    if (audioRecord3.getState() == i4) {
                                    }
                                    audioRecord3.release();
                                    audioRecord3 = null;
                                }
                            } catch (Throwable th10) {
                                if (audioRecord3 != null && audioRecord3.getState() != i4) {
                                    audioRecord3.release();
                                }
                                throw th10;
                            }
                        }
                        i8 = i + 1;
                        s2 = s;
                        length3 = i2;
                        iArr2 = iArr;
                        sArr3 = sArr;
                        i7 = i3;
                    }
                    i7++;
                    audioRecord2 = audioRecord3;
                }
            }
            throw new IllegalArgumentException("getInstance() failed : no suitable audio configurations on this device.");
        }
        return (AudioRecord) invokeV.objValue;
    }
}
