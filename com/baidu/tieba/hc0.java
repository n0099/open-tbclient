package com.baidu.tieba;

import com.baidu.mario.audio.AudioParams;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public interface hc0 {
    void a(boolean z, AudioParams audioParams);

    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j);

    void onAudioStop(boolean z);
}
