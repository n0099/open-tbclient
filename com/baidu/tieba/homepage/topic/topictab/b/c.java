package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hjx = BdUniqueId.gen();
    public int fXY = R.dimen.tbds16;
    public int hjy = R.color.cp_bg_line_c;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hjx;
    }
}
