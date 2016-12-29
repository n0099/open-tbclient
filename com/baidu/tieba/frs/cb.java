package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public interface cb {
    com.baidu.adp.widget.ListView.a<? extends com.baidu.tbadk.core.data.bg, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId, boolean z);

    au<ICardInfo, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId);

    com.baidu.adp.widget.ListView.a<? extends com.baidu.tbadk.core.data.bg, ? extends y.a> b(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId);
}
