package com.baidu.tieba.ala.alasquare.live.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId gzw = BdUniqueId.gen();
    public String bitmapRatio;
    public int categoryType;
    public String entryName;
    public List<String> gzv;
    public String labelName;
    public int tabId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gzw;
    }
}
