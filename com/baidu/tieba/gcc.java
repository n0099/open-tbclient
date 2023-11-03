package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public interface gcc {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(zcc zccVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(zcc zccVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(zcc zccVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(zcc zccVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(zcc zccVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(zcc zccVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(zcc zccVar, byte[] bArr, int i);
}
