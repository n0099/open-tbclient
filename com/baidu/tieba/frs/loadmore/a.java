package com.baidu.tieba.frs.loadmore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes6.dex */
public interface a extends FrsLoadMoreModel.a {
    l azS();

    String getForumName();

    e getPageContext();

    BdUniqueId getUniqueId();
}
