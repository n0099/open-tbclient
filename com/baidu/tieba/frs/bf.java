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
public abstract class bf<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int bQD;
    protected static final int bQE;
    protected static final int bQF;
    protected BaseActivity<?> aRd;
    protected int bPc;
    protected com.baidu.tieba.tbadkCore.p bPk;
    protected ba bQG;
    protected ListView bQH;
    protected be bQI;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.m9getInst().getContext().getResources();
        bQD = resources.getDimensionPixelSize(r.e.ds8);
        bQE = resources.getDimensionPixelSize(r.e.ds16);
        bQF = resources.getDimensionPixelSize(r.e.ds1);
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
            this.aRd = baseActivity;
        }
    }

    public void release() {
        this.mContext = null;
        this.aRd = null;
        this.bQG = null;
        this.AT = null;
        this.AU = null;
        if (this.bQI != null) {
            this.bQI.destory();
            this.bQI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.bQH = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        this.bPk = pVar;
    }

    public void a(ba baVar) {
        this.bQG = baVar;
    }

    public void hU(int i) {
        this.bPc = i;
    }

    public void a(be beVar) {
        this.bQI = beVar;
    }
}
