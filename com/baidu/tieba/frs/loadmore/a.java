package com.baidu.tieba.frs.loadmore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes7.dex */
public interface a extends FrsLoadMoreModel.a {
    FrsViewData bCK();

    String getForumName();

    e getPageContext();

    BdUniqueId getUniqueId();
}
