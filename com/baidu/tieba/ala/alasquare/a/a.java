package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId ghr = BdUniqueId.gen();
    public String fid;
    public String fname;
    public SdkLiveInfoData ghs;
    public int position;
    public boolean eFf = false;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean ght = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ghr;
    }
}
