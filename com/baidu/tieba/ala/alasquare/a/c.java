package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gyU = BdUniqueId.gen();
    public String activity_url;
    public String gyP;
    public String gyQ;
    public int gyR;
    public int gyS;
    public String gyT;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gyU;
    }
}
