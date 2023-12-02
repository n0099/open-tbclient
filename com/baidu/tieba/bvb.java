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
/* loaded from: classes5.dex */
public class bvb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public rvb h;

    public bvb(List<String> list, String str, rvb rvbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, rvbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        swb.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = rvbVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        avb avbVar;
        int i3;
        avb avbVar2;
        int i4;
        avb avbVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            swb.e("VideoComposer", j + " compose " + str);
            avb avbVar4 = new avb();
            avbVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = avbVar4.d();
            avb avbVar5 = null;
            if (d < 0) {
                avbVar4.j();
                avbVar4 = null;
            } else {
                avbVar4.l(this.e);
            }
            avb avbVar6 = new avb();
            avbVar6.m(str, "audio/");
            int d2 = avbVar6.d();
            if (d2 < 0) {
                avbVar6.j();
            } else {
                avbVar6.l(this.d);
                avbVar5 = avbVar6;
            }
            boolean z2 = false;
            if (avbVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (avbVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || avbVar5.e() - avbVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    avbVar = avbVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    avbVar = avbVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = avbVar.h();
                if (h == null) {
                    i4 = d;
                    avb avbVar7 = avbVar;
                    if (avbVar7 == avbVar4) {
                        j2 = avbVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (avbVar7 == avbVar5) {
                        j3 = avbVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        avbVar2 = avbVar4;
                        avbVar3 = avbVar5;
                        str2 = str3;
                    }
                } else {
                    avbVar2 = avbVar4;
                    i4 = d;
                    avb avbVar8 = avbVar;
                    if (avbVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        avbVar3 = avbVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(avbVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        swb.e(str3, sb.toString());
                    } else {
                        avbVar3 = avbVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, avbVar8.c(), h);
                    avbVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                avbVar4 = avbVar2;
                avbVar5 = avbVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            rvb rvbVar = this.h;
            if (rvbVar != null) {
                rvbVar.c(max);
            }
            swb.e(str3, "finish one file, ptsOffset " + max);
            if (avbVar4 != null) {
                avbVar4.j();
            }
            if (avbVar5 != null) {
                avbVar5.j();
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
                    avb avbVar = new avb();
                    try {
                        avbVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = avbVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                swb.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = avbVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                swb.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        swb.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    avbVar.j();
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
                    swb.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            swb.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
