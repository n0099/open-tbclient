package com.baidu.tieba;
/* loaded from: classes5.dex */
public interface dvb {
    void onPlayerAudioStalls(lvb lvbVar, boolean z, int i);

    void onPlayerDecodeBitrate(lvb lvbVar, int i, int i2);

    void onPlayerDecodeOuputSize(lvb lvbVar, int i, int i2);

    void onPlayerDecodeType(lvb lvbVar, int i);

    void onPlayerReceiveToRenderDelay(lvb lvbVar, int i);

    void onPlayerRenderFramerate(lvb lvbVar, int i);

    void onPlayerVideoStalls(lvb lvbVar, boolean z, int i);
}
