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
public abstract class av<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int bNU;
    protected static final int bNV;
    protected static final int bNW;
    protected com.baidu.tieba.tbadkCore.n bME;
    protected int bMx;
    protected at bNX;
    protected ListView bNY;
    protected au bNZ;
    protected BaseActivity<?> bcy;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.m9getInst().getContext().getResources();
        bNU = resources.getDimensionPixelSize(w.f.ds8);
        bNV = resources.getDimensionPixelSize(w.f.ds16);
        bNW = resources.getDimensionPixelSize(w.f.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public av(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        e(baseActivity);
    }

    public void e(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.bcy = baseActivity;
        }
    }

    public void release() {
        this.mContext = null;
        this.bcy = null;
        this.bNX = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.bNZ != null) {
            this.bNZ.destory();
            this.bNZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.bNY = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        this.bME = nVar;
    }

    public void a(at atVar) {
        this.bNX = atVar;
    }

    public void hO(int i) {
        this.bMx = i;
    }

    public void a(au auVar) {
        this.bNZ = auVar;
    }
}
