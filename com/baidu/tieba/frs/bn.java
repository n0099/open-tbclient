package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.x.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public abstract class bn<T, V extends x.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected int aSR;
    protected int aSS;
    protected ListView aSV;
    protected BaseActivity<?> aSe;
    protected int aTQ;
    protected com.baidu.tieba.tbadkCore.o aTW;
    protected bd aWg;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bn(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        d(baseActivity);
    }

    public void d(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.aSe = baseActivity;
            this.aSR = this.mContext.getResources().getDimensionPixelSize(i.d.ds8);
            this.aSS = this.mContext.getResources().getDimensionPixelSize(i.d.ds16);
        }
    }

    public void release() {
        this.mContext = null;
        this.aSe = null;
        this.aWg = null;
        this.GI = null;
        this.GJ = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aSV = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        this.aTW = oVar;
    }

    public void a(bd bdVar) {
        this.aWg = bdVar;
    }

    public void fu(int i) {
        this.aTQ = i;
    }
}
