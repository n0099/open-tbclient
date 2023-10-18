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
public class edb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public udb h;

    public edb(List<String> list, String str, udb udbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, udbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        veb.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = udbVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        ddb ddbVar;
        int i3;
        ddb ddbVar2;
        int i4;
        ddb ddbVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            veb.e("VideoComposer", j + " compose " + str);
            ddb ddbVar4 = new ddb();
            ddbVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = ddbVar4.d();
            ddb ddbVar5 = null;
            if (d < 0) {
                ddbVar4.j();
                ddbVar4 = null;
            } else {
                ddbVar4.l(this.e);
            }
            ddb ddbVar6 = new ddb();
            ddbVar6.m(str, "audio/");
            int d2 = ddbVar6.d();
            if (d2 < 0) {
                ddbVar6.j();
            } else {
                ddbVar6.l(this.d);
                ddbVar5 = ddbVar6;
            }
            boolean z2 = false;
            if (ddbVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (ddbVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || ddbVar5.e() - ddbVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    ddbVar = ddbVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    ddbVar = ddbVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = ddbVar.h();
                if (h == null) {
                    i4 = d;
                    ddb ddbVar7 = ddbVar;
                    if (ddbVar7 == ddbVar4) {
                        j2 = ddbVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (ddbVar7 == ddbVar5) {
                        j3 = ddbVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        ddbVar2 = ddbVar4;
                        ddbVar3 = ddbVar5;
                        str2 = str3;
                    }
                } else {
                    ddbVar2 = ddbVar4;
                    i4 = d;
                    ddb ddbVar8 = ddbVar;
                    if (ddbVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        ddbVar3 = ddbVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(ddbVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        veb.e(str3, sb.toString());
                    } else {
                        ddbVar3 = ddbVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, ddbVar8.c(), h);
                    ddbVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                ddbVar4 = ddbVar2;
                ddbVar5 = ddbVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            udb udbVar = this.h;
            if (udbVar != null) {
                udbVar.c(max);
            }
            veb.e(str3, "finish one file, ptsOffset " + max);
            if (ddbVar4 != null) {
                ddbVar4.j();
            }
            if (ddbVar5 != null) {
                ddbVar5.j();
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
                    ddb ddbVar = new ddb();
                    try {
                        ddbVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = ddbVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                veb.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = ddbVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                veb.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        veb.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    ddbVar.j();
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
                    veb.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            veb.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
