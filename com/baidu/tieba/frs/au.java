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
public abstract class au<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int bzw;
    protected static final int bzx;
    protected static final int bzy;
    protected BaseActivity<?> aSs;
    protected int byb;
    protected com.baidu.tieba.tbadkCore.o byh;
    protected ListView bzA;
    protected at bzB;
    protected as bzz;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.m9getInst().getContext().getResources();
        bzw = resources.getDimensionPixelSize(r.e.ds8);
        bzx = resources.getDimensionPixelSize(r.e.ds16);
        bzy = resources.getDimensionPixelSize(r.e.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public au(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity == null ? null : baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        e(baseActivity);
    }

    public void e(BaseActivity<?> baseActivity) {
        if (baseActivity != null) {
            this.mContext = baseActivity.getActivity();
            this.aSs = baseActivity;
        }
    }

    public void release() {
        this.mContext = null;
        this.aSs = null;
        this.bzz = null;
        this.AR = null;
        this.AS = null;
        if (this.bzB != null) {
            this.bzB.destory();
            this.bzB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.bzA = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        this.byh = oVar;
    }

    public void a(as asVar) {
        this.bzz = asVar;
    }

    public void hd(int i) {
        this.byb = i;
    }

    public void a(at atVar) {
        this.bzB = atVar;
    }
}
