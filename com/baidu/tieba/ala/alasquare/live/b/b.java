package com.baidu.tieba.ala.alasquare.live.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId efT = BdUniqueId.gen();
    public String bitmapRatio;
    public int categoryType;
    public List<String> efS;
    public String entryName;
    public String labelName;
    public int tabId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return efT;
    }
}
