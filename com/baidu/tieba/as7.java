package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes5.dex */
public interface as7 extends FrsLoadMoreModel.b {
    BdPageContext getPageContext();

    BdUniqueId getUniqueId();

    FrsViewData t1();

    String v();
}
