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
    protected static final int bQl;
    protected static final int bQm;
    protected static final int bQn;
    protected int bOO;
    protected com.baidu.tieba.tbadkCore.n bOV;
    protected at bQo;
    protected ListView bQp;
    protected au bQq;
    protected BaseActivity<?> bdG;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.m9getInst().getContext().getResources();
        bQl = resources.getDimensionPixelSize(w.f.ds8);
        bQm = resources.getDimensionPixelSize(w.f.ds16);
        bQn = resources.getDimensionPixelSize(w.f.ds1);
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
            this.bdG = baseActivity;
        }
    }

    public void release() {
        this.mContext = null;
        this.bdG = null;
        this.bQo = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.bQq != null) {
            this.bQq.destory();
            this.bQq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.bQp = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        this.bOV = nVar;
    }

    public void a(at atVar) {
        this.bQo = atVar;
    }

    public void hU(int i) {
        this.bOO = i;
    }

    public void a(au auVar) {
        this.bQq = auVar;
    }
}
