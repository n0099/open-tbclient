package com.baidu.tieba.card.divider;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes20.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public int idp = R.color.CAM_X0204;
    public int dividerHeight = UtilHelper.getDimenPixelSize(R.dimen.tbds16);

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
