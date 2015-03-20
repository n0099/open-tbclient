package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class av<T, V extends com.baidu.adp.widget.ListView.am> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected final int aHT;
    protected final int aHU;
    protected com.baidu.tieba.tbadkCore.w aIV;
    protected FrsActivity aJT;
    protected an aKC;
    protected int aKD;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public av(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.aJT = frsActivity;
        this.aHT = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds8);
        this.aHU = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds16);
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
        this.aIV = wVar;
    }

    public void a(an anVar) {
        this.aKC = anVar;
    }

    public void eH(int i) {
        this.aKD = i;
    }
}
