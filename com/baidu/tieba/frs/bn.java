package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.x.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public abstract class bn<T, V extends x.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected int aSZ;
    protected BaseActivity<?> aSm;
    protected int aTY;
    protected int aTa;
    protected ListView aTd;
    protected com.baidu.tieba.tbadkCore.o aUe;
    protected bd aWo;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bn(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        d(baseActivity);
    }

    public void d(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.aSm = baseActivity;
            this.aSZ = this.mContext.getResources().getDimensionPixelSize(i.d.ds8);
            this.aTa = this.mContext.getResources().getDimensionPixelSize(i.d.ds16);
        }
    }

    public void release() {
        this.mContext = null;
        this.aSm = null;
        this.aWo = null;
        this.GJ = null;
        this.GK = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aTd = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        this.aUe = oVar;
    }

    public void a(bd bdVar) {
        this.aWo = bdVar;
    }

    public void fC(int i) {
        this.aTY = i;
    }
}
