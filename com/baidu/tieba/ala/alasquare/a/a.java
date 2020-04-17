package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eNI = BdUniqueId.gen();
    public SdkLiveInfoData eNJ;
    public String fid;
    public String fname;
    public int position;
    public boolean dtP = false;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean eNK = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNI;
    }
}
