package com.baidu.tieba;

import android.content.Context;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public interface eg0 {
    long a();

    void b(int i, int i2);

    @Deprecated
    int c(int i, int i2, Map<String, float[]> map);

    int d(MediaTrack mediaTrack, int i, Map<String, float[]> map);

    void e(List<MediaTrack> list, Map<String, ShaderConfig> map);

    int f(MediaTrack mediaTrack, int i, int i2, Map<String, float[]> map);

    void g(int i, long j);

    int h(MediaSegment mediaSegment, int i, Map<String, float[]> map);

    int i(MediaTrack mediaTrack, int i, Map<String, float[]> map);

    void j(Context context);

    int k(int i, float[] fArr, float[] fArr2, int i2, int i3, float f);

    List<MediaTrack> l();

    @Deprecated
    int m(int i, float[] fArr, float[] fArr2, int i2, int i3, int i4, Map<String, float[]> map);

    void n(List<MediaTrack> list);

    void release();
}
