package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes5.dex */
public interface dz7 extends FrsLoadMoreModel.b {
    FrsViewData F1();

    BdPageContext getPageContext();

    BdUniqueId getUniqueId();

    String v();
}
