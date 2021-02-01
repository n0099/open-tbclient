package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gyG = BdUniqueId.gen();
    public String activity_url;
    public String gyB;
    public String gyC;
    public int gyD;
    public int gyE;
    public String gyF;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gyG;
    }
}
