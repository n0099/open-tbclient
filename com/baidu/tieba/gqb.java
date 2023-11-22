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
public class gqb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public wqb h;

    public gqb(List<String> list, String str, wqb wqbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, wqbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        xrb.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = wqbVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        fqb fqbVar;
        int i3;
        fqb fqbVar2;
        int i4;
        fqb fqbVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            xrb.e("VideoComposer", j + " compose " + str);
            fqb fqbVar4 = new fqb();
            fqbVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = fqbVar4.d();
            fqb fqbVar5 = null;
            if (d < 0) {
                fqbVar4.j();
                fqbVar4 = null;
            } else {
                fqbVar4.l(this.e);
            }
            fqb fqbVar6 = new fqb();
            fqbVar6.m(str, "audio/");
            int d2 = fqbVar6.d();
            if (d2 < 0) {
                fqbVar6.j();
            } else {
                fqbVar6.l(this.d);
                fqbVar5 = fqbVar6;
            }
            boolean z2 = false;
            if (fqbVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (fqbVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || fqbVar5.e() - fqbVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    fqbVar = fqbVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    fqbVar = fqbVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = fqbVar.h();
                if (h == null) {
                    i4 = d;
                    fqb fqbVar7 = fqbVar;
                    if (fqbVar7 == fqbVar4) {
                        j2 = fqbVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (fqbVar7 == fqbVar5) {
                        j3 = fqbVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        fqbVar2 = fqbVar4;
                        fqbVar3 = fqbVar5;
                        str2 = str3;
                    }
                } else {
                    fqbVar2 = fqbVar4;
                    i4 = d;
                    fqb fqbVar8 = fqbVar;
                    if (fqbVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        fqbVar3 = fqbVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(fqbVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        xrb.e(str3, sb.toString());
                    } else {
                        fqbVar3 = fqbVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, fqbVar8.c(), h);
                    fqbVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                fqbVar4 = fqbVar2;
                fqbVar5 = fqbVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            wqb wqbVar = this.h;
            if (wqbVar != null) {
                wqbVar.c(max);
            }
            xrb.e(str3, "finish one file, ptsOffset " + max);
            if (fqbVar4 != null) {
                fqbVar4.j();
            }
            if (fqbVar5 != null) {
                fqbVar5.j();
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
                    fqb fqbVar = new fqb();
                    try {
                        fqbVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = fqbVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                xrb.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = fqbVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                xrb.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        xrb.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    fqbVar.j();
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
                    xrb.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            xrb.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
