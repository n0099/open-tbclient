package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes5.dex */
public interface eh7 extends FrsLoadMoreModel.b {
    FrsViewData b1();

    g9 getPageContext();

    BdUniqueId getUniqueId();

    String v();
}
