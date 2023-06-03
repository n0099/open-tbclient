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
public class cta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public sta h;

    public cta(List<String> list, String str, sta staVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, staVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        tua.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = staVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        bta btaVar;
        int i3;
        bta btaVar2;
        int i4;
        bta btaVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            tua.e("VideoComposer", j + " compose " + str);
            bta btaVar4 = new bta();
            btaVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = btaVar4.d();
            bta btaVar5 = null;
            if (d < 0) {
                btaVar4.j();
                btaVar4 = null;
            } else {
                btaVar4.l(this.e);
            }
            bta btaVar6 = new bta();
            btaVar6.m(str, "audio/");
            int d2 = btaVar6.d();
            if (d2 < 0) {
                btaVar6.j();
            } else {
                btaVar6.l(this.d);
                btaVar5 = btaVar6;
            }
            boolean z2 = false;
            if (btaVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (btaVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || btaVar5.e() - btaVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    btaVar = btaVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    btaVar = btaVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = btaVar.h();
                if (h == null) {
                    i4 = d;
                    bta btaVar7 = btaVar;
                    if (btaVar7 == btaVar4) {
                        j2 = btaVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (btaVar7 == btaVar5) {
                        j3 = btaVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        btaVar2 = btaVar4;
                        btaVar3 = btaVar5;
                        str2 = str3;
                    }
                } else {
                    btaVar2 = btaVar4;
                    i4 = d;
                    bta btaVar8 = btaVar;
                    if (btaVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        btaVar3 = btaVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(btaVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        tua.e(str3, sb.toString());
                    } else {
                        btaVar3 = btaVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, btaVar8.c(), h);
                    btaVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                btaVar4 = btaVar2;
                btaVar5 = btaVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            sta staVar = this.h;
            if (staVar != null) {
                staVar.b(max);
            }
            tua.e(str3, "finish one file, ptsOffset " + max);
            if (btaVar4 != null) {
                btaVar4.j();
            }
            if (btaVar5 != null) {
                btaVar5.j();
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
                    bta btaVar = new bta();
                    try {
                        btaVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = btaVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                tua.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = btaVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                tua.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        tua.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    btaVar.j();
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
                    tua.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            tua.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
