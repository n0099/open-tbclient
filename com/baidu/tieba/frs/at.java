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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class at<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int bGW;
    protected static final int bGX;
    protected static final int bGY;
    protected BaseActivity<?> aWr;
    protected com.baidu.tieba.tbadkCore.n bFG;
    protected int bFz;
    protected ar bGZ;
    protected ListView bHa;
    protected as bHb;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.m9getInst().getContext().getResources();
        bGW = resources.getDimensionPixelSize(r.f.ds8);
        bGX = resources.getDimensionPixelSize(r.f.ds16);
        bGY = resources.getDimensionPixelSize(r.f.ds1);
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
            this.aWr = baseActivity;
        }
    }

    public void release() {
        this.mContext = null;
        this.aWr = null;
        this.bGZ = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.bHb != null) {
            this.bHb.destory();
            this.bHb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.bHa = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        this.bFG = nVar;
    }

    public void a(ar arVar) {
        this.bGZ = arVar;
    }

    public void hP(int i) {
        this.bFz = i;
    }

    public void a(as asVar) {
        this.bHb = asVar;
    }
}
