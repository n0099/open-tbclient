package com.baidu.tieba;
/* loaded from: classes5.dex */
public interface gmb {
    void onPlayerAudioStalls(omb ombVar, boolean z, int i);

    void onPlayerDecodeBitrate(omb ombVar, int i, int i2);

    void onPlayerDecodeOuputSize(omb ombVar, int i, int i2);

    void onPlayerDecodeType(omb ombVar, int i);

    void onPlayerReceiveToRenderDelay(omb ombVar, int i);

    void onPlayerRenderFramerate(omb ombVar, int i);

    void onPlayerVideoStalls(omb ombVar, boolean z, int i);
}
