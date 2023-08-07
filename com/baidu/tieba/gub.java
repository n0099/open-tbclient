package com.baidu.tieba;
/* loaded from: classes6.dex */
public interface gub {
    void onPlayerAudioStalls(oub oubVar, boolean z, int i);

    void onPlayerDecodeBitrate(oub oubVar, int i, int i2);

    void onPlayerDecodeOuputSize(oub oubVar, int i, int i2);

    void onPlayerDecodeType(oub oubVar, int i);

    void onPlayerReceiveToRenderDelay(oub oubVar, int i);

    void onPlayerRenderFramerate(oub oubVar, int i);

    void onPlayerVideoStalls(oub oubVar, boolean z, int i);
}
