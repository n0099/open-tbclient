package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.a;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public interface cc {
    a<? extends com.baidu.tbadk.core.data.bk, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId, boolean z);

    aq<ICardInfo, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId);

    a<? extends com.baidu.tbadk.core.data.bk, ? extends y.a> b(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId);
}
