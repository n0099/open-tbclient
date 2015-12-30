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
public abstract class bp<T, V extends x.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected BaseActivity<?> bbA;
    protected int bcm;
    protected int bcn;
    protected ListView bcq;
    protected int bdi;
    protected com.baidu.tieba.tbadkCore.p bdo;
    protected bf bfE;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bp(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        e(baseActivity);
    }

    public void e(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.bbA = baseActivity;
            this.bcm = this.mContext.getResources().getDimensionPixelSize(n.e.ds8);
            this.bcn = this.mContext.getResources().getDimensionPixelSize(n.e.ds16);
        }
    }

    public void release() {
        this.mContext = null;
        this.bbA = null;
        this.bfE = null;
        this.Hr = null;
        this.Hs = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bcq = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        this.bdo = pVar;
    }

    public void a(bf bfVar) {
        this.bfE = bfVar;
    }

    public void fT(int i) {
        this.bdi = i;
    }
}
