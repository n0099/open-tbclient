package com.baidu.tieba.ala.alasquare.live.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dvI = BdUniqueId.gen();
    public String OV;
    public int categoryType;
    public List<String> dvH;
    public String entryName;
    public String labelName;
    public int tabId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dvI;
    }
}
