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
public class hta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public xta h;

    public hta(List<String> list, String str, xta xtaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, xtaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        yua.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = xtaVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        gta gtaVar;
        int i3;
        gta gtaVar2;
        int i4;
        gta gtaVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            yua.e("VideoComposer", j + " compose " + str);
            gta gtaVar4 = new gta();
            gtaVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = gtaVar4.d();
            gta gtaVar5 = null;
            if (d < 0) {
                gtaVar4.j();
                gtaVar4 = null;
            } else {
                gtaVar4.l(this.e);
            }
            gta gtaVar6 = new gta();
            gtaVar6.m(str, "audio/");
            int d2 = gtaVar6.d();
            if (d2 < 0) {
                gtaVar6.j();
            } else {
                gtaVar6.l(this.d);
                gtaVar5 = gtaVar6;
            }
            boolean z2 = false;
            if (gtaVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (gtaVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || gtaVar5.e() - gtaVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    gtaVar = gtaVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    gtaVar = gtaVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = gtaVar.h();
                if (h == null) {
                    i4 = d;
                    gta gtaVar7 = gtaVar;
                    if (gtaVar7 == gtaVar4) {
                        j2 = gtaVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (gtaVar7 == gtaVar5) {
                        j3 = gtaVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        gtaVar2 = gtaVar4;
                        gtaVar3 = gtaVar5;
                        str2 = str3;
                    }
                } else {
                    gtaVar2 = gtaVar4;
                    i4 = d;
                    gta gtaVar8 = gtaVar;
                    if (gtaVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        gtaVar3 = gtaVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(gtaVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        yua.e(str3, sb.toString());
                    } else {
                        gtaVar3 = gtaVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, gtaVar8.c(), h);
                    gtaVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                gtaVar4 = gtaVar2;
                gtaVar5 = gtaVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            xta xtaVar = this.h;
            if (xtaVar != null) {
                xtaVar.b(max);
            }
            yua.e(str3, "finish one file, ptsOffset " + max);
            if (gtaVar4 != null) {
                gtaVar4.j();
            }
            if (gtaVar5 != null) {
                gtaVar5.j();
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
                    gta gtaVar = new gta();
                    try {
                        gtaVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = gtaVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                yua.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = gtaVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                yua.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        yua.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    gtaVar.j();
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
                    yua.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            yua.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
