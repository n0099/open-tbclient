package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public interface ehb {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(xhb xhbVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(xhb xhbVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(xhb xhbVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(xhb xhbVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(xhb xhbVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(xhb xhbVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(xhb xhbVar, byte[] bArr, int i);
}
