package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class bi<T> extends com.baidu.adp.widget.ListView.a<T> {
    protected final int aBb;
    protected final int aBc;
    protected com.baidu.tieba.tbadkCore.e aDH;
    protected ba aDI;
    protected int aDJ;
    protected FrsActivity aDc;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bi(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.aDc = frsActivity;
        this.aBb = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin);
        this.aBc = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_divider_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View b(int i, View view, ViewGroup viewGroup, T t) {
        this.mSkinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.mListView = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void e(com.baidu.tieba.tbadkCore.e eVar) {
        this.aDH = eVar;
    }

    public void a(ba baVar) {
        this.aDI = baVar;
    }

    public void eG(int i) {
        this.aDJ = i;
    }
}
