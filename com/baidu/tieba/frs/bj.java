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
    protected static final int bFC;
    protected static final int bFD;
    protected static final int bFE;
    protected int bDE;
    protected com.baidu.tieba.tbadkCore.p bDM;
    protected ba bFF;
    protected ListView bFG;
    protected bi bFH;
    protected BaseActivity<?> bem;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.m10getInst().getContext().getResources();
        bFC = resources.getDimensionPixelSize(u.e.ds8);
        bFD = resources.getDimensionPixelSize(u.e.ds16);
        bFE = resources.getDimensionPixelSize(u.e.ds1);
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
            this.bem = baseActivity;
        }
    }

    public void release() {
        this.mContext = null;
        this.bem = null;
        this.bFF = null;
        this.yE = null;
        this.yF = null;
        if (this.bFH != null) {
            this.bFH.destory();
            this.bFH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        this.bFG = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        this.bDM = pVar;
    }

    public void a(ba baVar) {
        this.bFF = baVar;
    }

    public void hn(int i) {
        this.bDE = i;
    }

    public void a(bi biVar) {
        this.bFH = biVar;
    }
}
