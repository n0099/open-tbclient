package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId efA = BdUniqueId.gen();
    public SdkLiveInfoData efB;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean efC = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return efA;
    }
}
