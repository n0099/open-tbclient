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
public class cvb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public svb h;

    public cvb(List<String> list, String str, svb svbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, svbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        twb.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = svbVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        bvb bvbVar;
        int i3;
        bvb bvbVar2;
        int i4;
        bvb bvbVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            twb.e("VideoComposer", j + " compose " + str);
            bvb bvbVar4 = new bvb();
            bvbVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = bvbVar4.d();
            bvb bvbVar5 = null;
            if (d < 0) {
                bvbVar4.j();
                bvbVar4 = null;
            } else {
                bvbVar4.l(this.e);
            }
            bvb bvbVar6 = new bvb();
            bvbVar6.m(str, "audio/");
            int d2 = bvbVar6.d();
            if (d2 < 0) {
                bvbVar6.j();
            } else {
                bvbVar6.l(this.d);
                bvbVar5 = bvbVar6;
            }
            boolean z2 = false;
            if (bvbVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (bvbVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || bvbVar5.e() - bvbVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    bvbVar = bvbVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    bvbVar = bvbVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = bvbVar.h();
                if (h == null) {
                    i4 = d;
                    bvb bvbVar7 = bvbVar;
                    if (bvbVar7 == bvbVar4) {
                        j2 = bvbVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (bvbVar7 == bvbVar5) {
                        j3 = bvbVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        bvbVar2 = bvbVar4;
                        bvbVar3 = bvbVar5;
                        str2 = str3;
                    }
                } else {
                    bvbVar2 = bvbVar4;
                    i4 = d;
                    bvb bvbVar8 = bvbVar;
                    if (bvbVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        bvbVar3 = bvbVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(bvbVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        twb.e(str3, sb.toString());
                    } else {
                        bvbVar3 = bvbVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, bvbVar8.c(), h);
                    bvbVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                bvbVar4 = bvbVar2;
                bvbVar5 = bvbVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            svb svbVar = this.h;
            if (svbVar != null) {
                svbVar.c(max);
            }
            twb.e(str3, "finish one file, ptsOffset " + max);
            if (bvbVar4 != null) {
                bvbVar4.j();
            }
            if (bvbVar5 != null) {
                bvbVar5.j();
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
                    bvb bvbVar = new bvb();
                    try {
                        bvbVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = bvbVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                twb.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = bvbVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                twb.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        twb.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    bvbVar.j();
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
                    twb.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            twb.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
