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
    protected BaseActivity<?> aRT;
    protected int aSG;
    protected int aSH;
    protected ListView aSK;
    protected int aTF;
    protected com.baidu.tieba.tbadkCore.o aTL;
    protected bd aVV;
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
            this.aRT = baseActivity;
            this.aSG = this.mContext.getResources().getDimensionPixelSize(i.d.ds8);
            this.aSH = this.mContext.getResources().getDimensionPixelSize(i.d.ds16);
        }
    }

    public void release() {
        this.mContext = null;
        this.aRT = null;
        this.aVV = null;
        this.GH = null;
        this.GI = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aSK = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        this.aTL = oVar;
    }

    public void a(bd bdVar) {
        this.aVV = bdVar;
    }

    public void fu(int i) {
        this.aTF = i;
    }
}
