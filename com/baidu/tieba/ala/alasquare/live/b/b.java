package com.baidu.tieba.ala.alasquare.live.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId duR = BdUniqueId.gen();
    public String Os;
    public int categoryType;
    public List<String> duQ;
    public String entryName;
    public String labelName;
    public int tabId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return duR;
    }
}
