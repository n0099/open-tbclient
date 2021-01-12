package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gvW = BdUniqueId.gen();
    public String activity_url;
    public String gvR;
    public String gvS;
    public int gvT;
    public int gvU;
    public String gvV;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gvW;
    }
}
