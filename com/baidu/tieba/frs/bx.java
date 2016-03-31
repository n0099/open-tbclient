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
public abstract class bx<T, V extends x.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected BaseActivity<?> bix;
    protected int bjn;
    protected int bjo;
    protected ListView bjr;
    protected int bkj;
    protected com.baidu.tieba.tbadkCore.o bkq;
    protected bj bmX;
    protected bw bmj;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bx(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        e(baseActivity);
    }

    public void e(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.bix = baseActivity;
            this.bjn = this.mContext.getResources().getDimensionPixelSize(t.e.ds8);
            this.bjo = this.mContext.getResources().getDimensionPixelSize(t.e.ds16);
        }
    }

    public void release() {
        this.mContext = null;
        this.bix = null;
        this.bmX = null;
        this.HJ = null;
        this.HK = null;
        if (this.bmj != null) {
            this.bmj.destory();
            this.bmj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bjr = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        this.bkq = oVar;
    }

    public void a(bj bjVar) {
        this.bmX = bjVar;
    }

    public void gH(int i) {
        this.bkj = i;
    }

    public void a(bw bwVar) {
        this.bmj = bwVar;
    }
}
