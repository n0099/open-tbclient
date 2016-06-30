package com.baidu.tieba.frs;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.adp.widget.ListView.y.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public abstract class bj<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int bBA;
    protected static final int bBz;
    protected static final int bEs;
    protected ListView bBD;
    protected com.baidu.tieba.tbadkCore.p bCF;
    protected int bCx;
    protected ba bEt;
    protected bi bEu;
    protected BaseActivity<?> bkc;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.m9getInst().getContext().getResources();
        bBz = resources.getDimensionPixelSize(u.e.ds8);
        bBA = resources.getDimensionPixelSize(u.e.ds16);
        bEs = resources.getDimensionPixelSize(u.e.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bj(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        e(baseActivity);
    }

    public void e(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.bkc = baseActivity;
        }
    }

    public void release() {
        this.mContext = null;
        this.bkc = null;
        this.bEt = null;
        this.yd = null;
        this.ye = null;
        if (this.bEu != null) {
            this.bEu.destory();
            this.bEu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.bBD = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        this.bCF = pVar;
    }

    public void a(ba baVar) {
        this.bEt = baVar;
    }

    public void hn(int i) {
        this.bCx = i;
    }

    public void a(bi biVar) {
        this.bEu = biVar;
    }
}
