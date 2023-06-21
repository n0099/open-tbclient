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
public class ava {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public qva h;

    public ava(List<String> list, String str, qva qvaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, qvaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        rwa.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = qvaVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        zua zuaVar;
        int i3;
        zua zuaVar2;
        int i4;
        zua zuaVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            rwa.e("VideoComposer", j + " compose " + str);
            zua zuaVar4 = new zua();
            zuaVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = zuaVar4.d();
            zua zuaVar5 = null;
            if (d < 0) {
                zuaVar4.j();
                zuaVar4 = null;
            } else {
                zuaVar4.l(this.e);
            }
            zua zuaVar6 = new zua();
            zuaVar6.m(str, "audio/");
            int d2 = zuaVar6.d();
            if (d2 < 0) {
                zuaVar6.j();
            } else {
                zuaVar6.l(this.d);
                zuaVar5 = zuaVar6;
            }
            boolean z2 = false;
            if (zuaVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (zuaVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || zuaVar5.e() - zuaVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    zuaVar = zuaVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    zuaVar = zuaVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = zuaVar.h();
                if (h == null) {
                    i4 = d;
                    zua zuaVar7 = zuaVar;
                    if (zuaVar7 == zuaVar4) {
                        j2 = zuaVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (zuaVar7 == zuaVar5) {
                        j3 = zuaVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        zuaVar2 = zuaVar4;
                        zuaVar3 = zuaVar5;
                        str2 = str3;
                    }
                } else {
                    zuaVar2 = zuaVar4;
                    i4 = d;
                    zua zuaVar8 = zuaVar;
                    if (zuaVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        zuaVar3 = zuaVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(zuaVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        rwa.e(str3, sb.toString());
                    } else {
                        zuaVar3 = zuaVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, zuaVar8.c(), h);
                    zuaVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                zuaVar4 = zuaVar2;
                zuaVar5 = zuaVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            qva qvaVar = this.h;
            if (qvaVar != null) {
                qvaVar.b(max);
            }
            rwa.e(str3, "finish one file, ptsOffset " + max);
            if (zuaVar4 != null) {
                zuaVar4.j();
            }
            if (zuaVar5 != null) {
                zuaVar5.j();
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
                    zua zuaVar = new zua();
                    try {
                        zuaVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = zuaVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                rwa.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = zuaVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                rwa.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        rwa.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    zuaVar.j();
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
                    rwa.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            rwa.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
