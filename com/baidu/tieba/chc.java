package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public interface chc {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(vhc vhcVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(vhc vhcVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(vhc vhcVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(vhc vhcVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(vhc vhcVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(vhc vhcVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(vhc vhcVar, byte[] bArr, int i);
}
