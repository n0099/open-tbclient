package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public abstract class bm<T> extends com.baidu.adp.widget.ListView.a<T> {
    protected FrsActivity aBz;
    protected b aCf;
    protected be aCg;
    protected int aCh;
    protected final int aza;
    protected final int azb;
    protected ListView aze;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bm(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.mIsFromCDN = false;
        this.aBz = frsActivity;
        this.aza = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin);
        this.azb = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_divider_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View b(int i, View view, ViewGroup viewGroup, T t) {
        this.mSkinType = TbadkApplication.m251getInst().getSkinType();
        this.aze = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void h(b bVar) {
        this.aCf = bVar;
    }

    public void a(be beVar) {
        this.aCg = beVar;
    }

    public void eI(int i) {
        this.aCh = i;
    }
}
