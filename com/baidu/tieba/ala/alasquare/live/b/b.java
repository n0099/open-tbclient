package com.baidu.tieba.ala.alasquare.live.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId frC = BdUniqueId.gen();
    public String bitmapRatio;
    public int categoryType;
    public String entryName;
    public List<String> frB;
    public String labelName;
    public int tabId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return frC;
    }
}
