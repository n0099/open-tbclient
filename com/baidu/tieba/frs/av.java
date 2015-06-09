package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class av<T, V extends com.baidu.adp.widget.ListView.am> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected final int aKk;
    protected final int aKl;
    protected com.baidu.tieba.tbadkCore.w aLm;
    protected an aMU;
    protected int aMV;
    protected FrsActivity aMl;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public av(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.aMl = frsActivity;
        this.aKk = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds8);
        this.aKl = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.mListView = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        this.aLm = wVar;
    }

    public void a(an anVar) {
        this.aMU = anVar;
    }

    public void eV(int i) {
        this.aMV = i;
    }
}
