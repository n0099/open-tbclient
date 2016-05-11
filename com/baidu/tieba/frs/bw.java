package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.adp.widget.ListView.y.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class bw<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected BaseActivity<?> bek;
    protected int bfn;
    protected int bfo;
    protected ListView bfr;
    protected int bgj;
    protected com.baidu.tieba.tbadkCore.o bgq;
    protected int biw;
    protected bi bix;
    protected bv biy;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bw(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        e(baseActivity);
    }

    public void e(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.bek = baseActivity;
            this.bfn = this.mContext.getResources().getDimensionPixelSize(t.e.ds8);
            this.bfo = this.mContext.getResources().getDimensionPixelSize(t.e.ds16);
            this.biw = this.mContext.getResources().getDimensionPixelSize(t.e.ds1);
        }
    }

    public void release() {
        this.mContext = null;
        this.bek = null;
        this.bix = null;
        this.yb = null;
        this.yc = null;
        if (this.biy != null) {
            this.biy.destory();
            this.biy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        this.bfr = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        this.bgq = oVar;
    }

    public void a(bi biVar) {
        this.bix = biVar;
    }

    public void gn(int i) {
        this.bgj = i;
    }

    public void a(bv bvVar) {
        this.biy = bvVar;
    }
}
