package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fCt = BdUniqueId.gen();
    public SdkLiveInfoData fCu;
    public String fid;
    public String fname;
    public int position;
    public boolean eee = false;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean fCv = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fCt;
    }
}
