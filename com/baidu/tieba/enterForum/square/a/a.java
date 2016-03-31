package com.baidu.tieba.enterForum.square.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.x.a;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public abstract class a<T, V extends x.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    public final TbPageContext<?> ND;
    public boolean bcn;
    private BdUniqueId mTag;

    public abstract void de(int i);

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bcn = true;
        this.mTag = null;
        this.ND = tbPageContext;
    }

    public void onStart() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
