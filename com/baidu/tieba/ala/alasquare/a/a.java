package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId faF = BdUniqueId.gen();
    public SdkLiveInfoData faG;
    public String fid;
    public String fname;
    public int position;
    public boolean dHL = false;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean faH = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return faF;
    }
}
