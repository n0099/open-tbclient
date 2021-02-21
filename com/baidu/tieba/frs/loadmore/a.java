package com.baidu.tieba.frs.loadmore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.f;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes2.dex */
public interface a extends FrsLoadMoreModel.a {
    FrsViewData cDg();

    String getForumName();

    f getPageContext();

    BdUniqueId getUniqueId();
}
