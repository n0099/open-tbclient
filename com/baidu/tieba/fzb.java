package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public interface fzb {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(yzb yzbVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(yzb yzbVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(yzb yzbVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(yzb yzbVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(yzb yzbVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(yzb yzbVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(yzb yzbVar, byte[] bArr, int i);
}
