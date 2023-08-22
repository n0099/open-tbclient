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
public class heb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public xeb h;

    public heb(List<String> list, String str, xeb xebVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, xebVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        yfb.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = xebVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        geb gebVar;
        int i3;
        geb gebVar2;
        int i4;
        geb gebVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            yfb.e("VideoComposer", j + " compose " + str);
            geb gebVar4 = new geb();
            gebVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = gebVar4.d();
            geb gebVar5 = null;
            if (d < 0) {
                gebVar4.j();
                gebVar4 = null;
            } else {
                gebVar4.l(this.e);
            }
            geb gebVar6 = new geb();
            gebVar6.m(str, "audio/");
            int d2 = gebVar6.d();
            if (d2 < 0) {
                gebVar6.j();
            } else {
                gebVar6.l(this.d);
                gebVar5 = gebVar6;
            }
            boolean z2 = false;
            if (gebVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (gebVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || gebVar5.e() - gebVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    gebVar = gebVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    gebVar = gebVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = gebVar.h();
                if (h == null) {
                    i4 = d;
                    geb gebVar7 = gebVar;
                    if (gebVar7 == gebVar4) {
                        j2 = gebVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (gebVar7 == gebVar5) {
                        j3 = gebVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        gebVar2 = gebVar4;
                        gebVar3 = gebVar5;
                        str2 = str3;
                    }
                } else {
                    gebVar2 = gebVar4;
                    i4 = d;
                    geb gebVar8 = gebVar;
                    if (gebVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        gebVar3 = gebVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(gebVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        yfb.e(str3, sb.toString());
                    } else {
                        gebVar3 = gebVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, gebVar8.c(), h);
                    gebVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                gebVar4 = gebVar2;
                gebVar5 = gebVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            xeb xebVar = this.h;
            if (xebVar != null) {
                xebVar.c(max);
            }
            yfb.e(str3, "finish one file, ptsOffset " + max);
            if (gebVar4 != null) {
                gebVar4.j();
            }
            if (gebVar5 != null) {
                gebVar5.j();
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
                    geb gebVar = new geb();
                    try {
                        gebVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = gebVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                yfb.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = gebVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                yfb.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        yfb.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    gebVar.j();
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
                    yfb.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            yfb.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
