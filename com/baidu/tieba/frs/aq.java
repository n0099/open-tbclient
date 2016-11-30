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
public abstract class aq<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int bTl;
    protected static final int bTm;
    protected static final int bTn;
    protected BaseActivity<?> aTb;
    protected int bRQ;
    protected com.baidu.tieba.tbadkCore.p bRX;
    protected ao bTo;
    protected ListView bTp;
    protected ap bTq;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.m9getInst().getContext().getResources();
        bTl = resources.getDimensionPixelSize(r.e.ds8);
        bTm = resources.getDimensionPixelSize(r.e.ds16);
        bTn = resources.getDimensionPixelSize(r.e.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public aq(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        e(baseActivity);
    }

    public void e(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.aTb = baseActivity;
        }
    }

    public void release() {
        this.mContext = null;
        this.aTb = null;
        this.bTo = null;
        this.AT = null;
        this.AU = null;
        if (this.bTq != null) {
            this.bTq.destory();
            this.bTq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.bTp = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        this.bRX = pVar;
    }

    public void a(ao aoVar) {
        this.bTo = aoVar;
    }

    public void hT(int i) {
        this.bRQ = i;
    }

    public void a(ap apVar) {
        this.bTq = apVar;
    }
}
