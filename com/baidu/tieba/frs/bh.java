package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class bh<T> extends com.baidu.adp.widget.ListView.a<T> {
    protected final int aBZ;
    protected final int aCa;
    protected com.baidu.tieba.tbadkCore.e aEF;
    protected az aEG;
    protected int aEH;
    protected FrsActivity aEa;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bh(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.aEa = frsActivity;
        this.aBZ = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin);
        this.aCa = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_divider_height);
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
        this.aEF = eVar;
    }

    public void a(az azVar) {
        this.aEG = azVar;
    }

    public void eM(int i) {
        this.aEH = i;
    }
}
