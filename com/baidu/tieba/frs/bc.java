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
public abstract class bc<T, V extends x.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected BaseActivity<?> aSJ;
    protected ListView aTA;
    protected int aTw;
    protected int aTx;
    protected com.baidu.tieba.tbadkCore.n aUy;
    protected au aWk;
    protected int aWl;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bc(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        d(baseActivity);
    }

    public void d(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.aSJ = baseActivity;
            this.aTw = this.mContext.getResources().getDimensionPixelSize(i.d.ds8);
            this.aTx = this.mContext.getResources().getDimensionPixelSize(i.d.ds16);
        }
    }

    public void release() {
        this.mContext = null;
        this.aSJ = null;
        this.aWk = null;
        this.GH = null;
        this.GI = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aTA = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        this.aUy = nVar;
    }

    public void a(au auVar) {
        this.aWk = auVar;
    }

    public void fh(int i) {
        this.aWl = i;
    }
}
