package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.x.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class bv<T, V extends x.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected BaseActivity<?> bdK;
    protected int beB;
    protected int beC;
    protected ListView beF;
    protected com.baidu.tieba.tbadkCore.o bfF;
    protected int bfz;
    protected bu bhx;
    protected bh bim;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bv(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        e(baseActivity);
    }

    public void e(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.bdK = baseActivity;
            this.beB = this.mContext.getResources().getDimensionPixelSize(t.e.ds8);
            this.beC = this.mContext.getResources().getDimensionPixelSize(t.e.ds16);
        }
    }

    public void release() {
        this.mContext = null;
        this.bdK = null;
        this.bim = null;
        this.HD = null;
        this.HE = null;
        if (this.bhx != null) {
            this.bhx.destory();
            this.bhx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.beF = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        this.bfF = oVar;
    }

    public void a(bh bhVar) {
        this.bim = bhVar;
    }

    public void gq(int i) {
        this.bfz = i;
    }

    public void a(bu buVar) {
        this.bhx = buVar;
    }
}
