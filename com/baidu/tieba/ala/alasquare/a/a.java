package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eNN = BdUniqueId.gen();
    public SdkLiveInfoData eNO;
    public String fid;
    public String fname;
    public int position;
    public boolean dtT = false;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean eNP = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNN;
    }
}
