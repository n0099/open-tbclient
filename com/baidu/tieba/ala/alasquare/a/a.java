package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes6.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId gpB = BdUniqueId.gen();
    public String fid;
    public String fname;
    public SdkLiveInfoData gpC;
    public int position;
    public boolean eMh = false;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean gpD = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gpB;
    }
}
