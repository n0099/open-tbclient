package com.baidu.tieba.enterForum.square.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.x.a;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public abstract class a<T, V extends x.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    public boolean aRB;
    public final TbPageContext<?> mPageContext;

    public abstract void cZ(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aRB = true;
        this.mPageContext = tbPageContext;
    }

    public void onStart() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
