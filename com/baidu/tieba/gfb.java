package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public interface gfb {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(zfb zfbVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(zfb zfbVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(zfb zfbVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(zfb zfbVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(zfb zfbVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(zfb zfbVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(zfb zfbVar, byte[] bArr, int i);
}
