package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public interface i5c {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(b6c b6cVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(b6c b6cVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(b6c b6cVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(b6c b6cVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(b6c b6cVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(b6c b6cVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(b6c b6cVar, byte[] bArr, int i);
}
