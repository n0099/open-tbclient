package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class bh<T> extends com.baidu.adp.widget.ListView.a<T> {
    protected final int aCc;
    protected final int aCd;
    protected com.baidu.tieba.tbadkCore.e aEI;
    protected az aEJ;
    protected int aEK;
    protected FrsActivity aEd;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bh(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.aEd = frsActivity;
        this.aCc = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin);
        this.aCd = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_divider_height);
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
        this.aEI = eVar;
    }

    public void a(az azVar) {
        this.aEJ = azVar;
    }

    public void eM(int i) {
        this.aEK = i;
    }
}
