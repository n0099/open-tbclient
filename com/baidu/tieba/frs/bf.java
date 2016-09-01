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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class bf<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int bQK;
    protected static final int bQL;
    protected static final int bQM;
    protected BaseActivity<?> aPR;
    protected int bPi;
    protected com.baidu.tieba.tbadkCore.p bPq;
    protected ba bQN;
    protected ListView bQO;
    protected be bQP;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.m9getInst().getContext().getResources();
        bQK = resources.getDimensionPixelSize(t.e.ds8);
        bQL = resources.getDimensionPixelSize(t.e.ds16);
        bQM = resources.getDimensionPixelSize(t.e.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bf(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        e(baseActivity);
    }

    public void e(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.aPR = baseActivity;
        }
    }

    public void release() {
        this.mContext = null;
        this.aPR = null;
        this.bQN = null;
        this.AT = null;
        this.AU = null;
        if (this.bQP != null) {
            this.bQP.destory();
            this.bQP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.bQO = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        this.bPq = pVar;
    }

    public void a(ba baVar) {
        this.bQN = baVar;
    }

    public void hQ(int i) {
        this.bPi = i;
    }

    public void a(be beVar) {
        this.bQP = beVar;
    }
}
