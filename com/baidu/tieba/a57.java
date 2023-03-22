package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes3.dex */
public interface a57 extends FrsLoadMoreModel.b {
    FrsViewData W0();

    a9 getPageContext();

    BdUniqueId getUniqueId();

    String v();
}
