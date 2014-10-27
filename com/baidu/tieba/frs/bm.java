package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public abstract class bm<T> extends com.baidu.adp.widget.ListView.a<T> {
    protected b aBV;
    protected be aBW;
    protected int aBX;
    protected FrsActivity aBp;
    protected final int ayR;
    protected final int ayS;
    protected ListView ayV;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bm(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.mIsFromCDN = false;
        this.aBp = frsActivity;
        this.ayR = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin);
        this.ayS = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_divider_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View b(int i, View view, ViewGroup viewGroup, T t) {
        this.mSkinType = TbadkApplication.m251getInst().getSkinType();
        this.ayV = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void h(b bVar) {
        this.aBV = bVar;
    }

    public void a(be beVar) {
        this.aBW = beVar;
    }

    public void eI(int i) {
        this.aBX = i;
    }
}
