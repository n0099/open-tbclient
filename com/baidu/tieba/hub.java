package com.baidu.tieba;
/* loaded from: classes6.dex */
public interface hub {
    void onPlayerAudioStalls(pub pubVar, boolean z, int i);

    void onPlayerDecodeBitrate(pub pubVar, int i, int i2);

    void onPlayerDecodeOuputSize(pub pubVar, int i, int i2);

    void onPlayerDecodeType(pub pubVar, int i);

    void onPlayerReceiveToRenderDelay(pub pubVar, int i);

    void onPlayerRenderFramerate(pub pubVar, int i);

    void onPlayerVideoStalls(pub pubVar, boolean z, int i);
}
