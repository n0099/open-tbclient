package com.baidu.tieba.frs.loadmore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes16.dex */
public interface a extends FrsLoadMoreModel.a {
    FrsViewData cmw();

    String getForumName();

    e getPageContext();

    BdUniqueId getUniqueId();
}
