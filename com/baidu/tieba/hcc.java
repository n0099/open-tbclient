package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public interface hcc {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(adc adcVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(adc adcVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(adc adcVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(adc adcVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(adc adcVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(adc adcVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(adc adcVar, byte[] bArr, int i);
}
