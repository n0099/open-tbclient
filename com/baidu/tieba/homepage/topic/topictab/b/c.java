package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId kqr = BdUniqueId.gen();
    public int iMy = R.dimen.tbds16;
    public int eWx = R.color.CAM_X0204;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kqr;
    }
}
