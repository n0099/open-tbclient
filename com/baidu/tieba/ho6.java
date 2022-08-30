package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes4.dex */
public interface ho6 extends FrsLoadMoreModel.b {
    FrsViewData P0();

    String c();

    d9 getPageContext();

    BdUniqueId getUniqueId();
}
