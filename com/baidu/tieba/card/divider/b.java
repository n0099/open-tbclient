package com.baidu.tieba.card.divider;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public int iAI = R.color.CAM_X0204;
    public int dividerHeight = UtilHelper.getDimenPixelSize(R.dimen.tbds16);

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
