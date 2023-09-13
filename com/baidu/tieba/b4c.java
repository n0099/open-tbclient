package com.baidu.tieba;
/* loaded from: classes5.dex */
public interface b4c {
    void onPlayerAudioStalls(j4c j4cVar, boolean z, int i);

    void onPlayerDecodeBitrate(j4c j4cVar, int i, int i2);

    void onPlayerDecodeOuputSize(j4c j4cVar, int i, int i2);

    void onPlayerDecodeType(j4c j4cVar, int i);

    void onPlayerReceiveToRenderDelay(j4c j4cVar, int i);

    void onPlayerRenderFramerate(j4c j4cVar, int i);

    void onPlayerVideoStalls(j4c j4cVar, boolean z, int i);
}
