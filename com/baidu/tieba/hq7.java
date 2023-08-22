package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes6.dex */
public interface hq7 extends FrsLoadMoreModel.b {
    BdPageContext getPageContext();

    BdUniqueId getUniqueId();

    FrsViewData l1();

    String v();
}
