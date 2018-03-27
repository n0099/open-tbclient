package com.baidu.tieba.frs.loadmore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.m;
/* loaded from: classes2.dex */
public interface a extends FrsLoadMoreModel.a {
    m avl();

    String getForumName();

    e getPageContext();

    BdUniqueId getUniqueId();
}
