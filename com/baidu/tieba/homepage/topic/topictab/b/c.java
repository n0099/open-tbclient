package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hTm = BdUniqueId.gen();
    public int gEI = R.dimen.tbds16;
    public int hTn = R.color.cp_bg_line_c;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hTm;
    }
}
