package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId flP = BdUniqueId.gen();
    public String fid;
    public SdkLiveInfoData flQ;
    public String fname;
    public int position;
    public boolean dOx = false;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean flR = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return flP;
    }
}
