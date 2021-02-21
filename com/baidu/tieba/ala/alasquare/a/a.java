package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId gyK = BdUniqueId.gen();
    public String fid;
    public String fname;
    public SdkLiveInfoData gyL;
    public int position;
    public boolean eTD = false;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean gyM = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gyK;
    }
}
