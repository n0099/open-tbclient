package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.x.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public abstract class bm<T, V extends x.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected BaseActivity<?> aXA;
    protected int aYn;
    protected int aYo;
    protected ListView aYr;
    protected int aZm;
    protected com.baidu.tieba.tbadkCore.p aZs;
    protected bc bbF;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bm(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        c(baseActivity);
    }

    public void c(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.aXA = baseActivity;
            this.aYn = this.mContext.getResources().getDimensionPixelSize(n.d.ds8);
            this.aYo = this.mContext.getResources().getDimensionPixelSize(n.d.ds16);
        }
    }

    public void release() {
        this.mContext = null;
        this.aXA = null;
        this.bbF = null;
        this.Hb = null;
        this.Hc = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aYr = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        this.aZs = pVar;
    }

    public void a(bc bcVar) {
        this.bbF = bcVar;
    }

    public void fY(int i) {
        this.aZm = i;
    }
}
