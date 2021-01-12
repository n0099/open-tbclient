package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId gvM = BdUniqueId.gen();
    public String fid;
    public String fname;
    public SdkLiveInfoData gvN;
    public int position;
    public boolean eRr = false;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean gvO = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gvM;
    }
}
