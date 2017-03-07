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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class at<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int bOf;
    protected static final int bOg;
    protected static final int bOh;
    protected int bMH;
    protected com.baidu.tieba.tbadkCore.n bMO;
    protected ar bOi;
    protected ListView bOj;
    protected as bOk;
    protected BaseActivity<?> bcF;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.m9getInst().getContext().getResources();
        bOf = resources.getDimensionPixelSize(w.f.ds8);
        bOg = resources.getDimensionPixelSize(w.f.ds16);
        bOh = resources.getDimensionPixelSize(w.f.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public at(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        e(baseActivity);
    }

    public void e(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.bcF = baseActivity;
        }
    }

    public void release() {
        this.mContext = null;
        this.bcF = null;
        this.bOi = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.bOk != null) {
            this.bOk.destory();
            this.bOk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.bOj = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        this.bMO = nVar;
    }

    public void a(ar arVar) {
        this.bOi = arVar;
    }

    public void hL(int i) {
        this.bMH = i;
    }

    public void a(as asVar) {
        this.bOk = asVar;
    }
}
