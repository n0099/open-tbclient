package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gAD = BdUniqueId.gen();
    public String activity_url;
    public int gAA;
    public int gAB;
    public String gAC;
    public String gAy;
    public String gAz;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gAD;
    }
}
