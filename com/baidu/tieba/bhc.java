package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public interface bhc {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(uhc uhcVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(uhc uhcVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(uhc uhcVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(uhc uhcVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(uhc uhcVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(uhc uhcVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(uhc uhcVar, byte[] bArr, int i);
}
