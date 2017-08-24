package com.baidu.tieba.frs;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.adp.widget.ListView.j.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class d<T, V extends j.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int cjl;
    protected static final int cjm;
    protected static final int cjn;
    protected com.baidu.tieba.tbadkCore.i cjo;
    protected b cjp;
    protected ListView cjq;
    protected int cjr;
    protected c cjs;
    private boolean cjt;
    private boolean cju;
    protected boolean mIsFromCDN;
    protected int mSkinType;
    protected TbPageContext<?> oW;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        cjl = resources.getDimensionPixelSize(d.f.ds8);
        cjm = resources.getDimensionPixelSize(d.f.ds16);
        cjn = resources.getDimensionPixelSize(d.f.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.cju = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.cju = false;
        a(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.oW = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    public void release() {
        this.mContext = null;
        this.oW = null;
        this.cjp = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.cjs != null) {
            this.cjs.destory();
            this.cjs = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.cjq = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        this.cjo = iVar;
    }

    public void a(b bVar) {
        this.cjp = bVar;
    }

    public void iB(int i) {
        this.cjr = i;
    }

    public void a(c cVar) {
        this.cjs = cVar;
    }

    public void cH(boolean z) {
        this.cjt = z;
    }

    public boolean afd() {
        return this.cjt;
    }

    public void eC(boolean z) {
        this.cju = z;
    }

    protected boolean afe() {
        return this.cju;
    }
}
