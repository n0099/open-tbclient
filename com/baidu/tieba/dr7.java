package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes5.dex */
public interface dr7 extends FrsLoadMoreModel.b {
    FrsViewData c1();

    l9 getPageContext();

    BdUniqueId getUniqueId();

    String v();
}
