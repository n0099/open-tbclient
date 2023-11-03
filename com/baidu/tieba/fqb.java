package com.baidu.tieba;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.util.List;
@TargetApi(18)
/* loaded from: classes6.dex */
public class fqb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public vqb h;

    public fqb(List<String> list, String str, vqb vqbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, vqbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        wrb.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = vqbVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        eqb eqbVar;
        int i3;
        eqb eqbVar2;
        int i4;
        eqb eqbVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            wrb.e("VideoComposer", j + " compose " + str);
            eqb eqbVar4 = new eqb();
            eqbVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = eqbVar4.d();
            eqb eqbVar5 = null;
            if (d < 0) {
                eqbVar4.j();
                eqbVar4 = null;
            } else {
                eqbVar4.l(this.e);
            }
            eqb eqbVar6 = new eqb();
            eqbVar6.m(str, "audio/");
            int d2 = eqbVar6.d();
            if (d2 < 0) {
                eqbVar6.j();
            } else {
                eqbVar6.l(this.d);
                eqbVar5 = eqbVar6;
            }
            boolean z2 = false;
            if (eqbVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (eqbVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || eqbVar5.e() - eqbVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    eqbVar = eqbVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    eqbVar = eqbVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = eqbVar.h();
                if (h == null) {
                    i4 = d;
                    eqb eqbVar7 = eqbVar;
                    if (eqbVar7 == eqbVar4) {
                        j2 = eqbVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (eqbVar7 == eqbVar5) {
                        j3 = eqbVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        eqbVar2 = eqbVar4;
                        eqbVar3 = eqbVar5;
                        str2 = str3;
                    }
                } else {
                    eqbVar2 = eqbVar4;
                    i4 = d;
                    eqb eqbVar8 = eqbVar;
                    if (eqbVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        eqbVar3 = eqbVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(eqbVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        wrb.e(str3, sb.toString());
                    } else {
                        eqbVar3 = eqbVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, eqbVar8.c(), h);
                    eqbVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                eqbVar4 = eqbVar2;
                eqbVar5 = eqbVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            vqb vqbVar = this.h;
            if (vqbVar != null) {
                vqbVar.c(max);
            }
            wrb.e(str3, "finish one file, ptsOffset " + max);
            if (eqbVar4 != null) {
                eqbVar4.j();
            }
            if (eqbVar5 != null) {
                eqbVar5.j();
            }
            return max;
        }
        return invokeJL.longValue;
    }

    public boolean b(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb)) == null) {
            boolean z = false;
            boolean z2 = false;
            for (String str : this.a) {
                try {
                    eqb eqbVar = new eqb();
                    try {
                        eqbVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = eqbVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                wrb.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = eqbVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                wrb.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        wrb.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    eqbVar.j();
                    if (z && z2) {
                        break;
                    }
                } catch (Exception e2) {
                    if (sb != null) {
                        sb.append("VideoSplicer codec 录制视频拼接过程中发生异常:" + e2.getMessage());
                    }
                    e2.printStackTrace();
                    return false;
                }
            }
            MediaMuxer mediaMuxer = new MediaMuxer(this.b, 0);
            this.c = mediaMuxer;
            if (z) {
                this.e = mediaMuxer.addTrack(this.g);
            }
            if (z2) {
                this.d = this.c.addTrack(this.f);
            }
            this.c.start();
            long j = 0;
            for (String str2 : this.a) {
                j = a(j, str2);
            }
            if (this.c != null) {
                try {
                    this.c.stop();
                    this.c.release();
                } catch (Exception unused) {
                    wrb.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            wrb.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
