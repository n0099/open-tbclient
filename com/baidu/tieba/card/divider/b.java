package com.baidu.tieba.card.divider;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public int fLF = R.color.cp_bg_line_c;
    public int fLG = UtilHelper.getDimenPixelSize(R.dimen.tbds16);

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }
}
