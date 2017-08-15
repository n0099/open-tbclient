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
    protected static final int cjk;
    protected static final int cjl;
    protected static final int cjm;
    protected com.baidu.tieba.tbadkCore.i cjn;
    protected b cjo;
    protected ListView cjp;
    protected int cjq;
    protected c cjr;
    private boolean cjs;
    private boolean cjt;
    protected boolean mIsFromCDN;
    protected int mSkinType;
    protected TbPageContext<?> oV;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        cjk = resources.getDimensionPixelSize(d.f.ds8);
        cjl = resources.getDimensionPixelSize(d.f.ds16);
        cjm = resources.getDimensionPixelSize(d.f.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.cjt = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.cjt = false;
        a(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.oV = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    public void release() {
        this.mContext = null;
        this.oV = null;
        this.cjo = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.cjr != null) {
            this.cjr.destory();
            this.cjr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.cjp = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        this.cjn = iVar;
    }

    public void a(b bVar) {
        this.cjo = bVar;
    }

    public void iB(int i) {
        this.cjq = i;
    }

    public void a(c cVar) {
        this.cjr = cVar;
    }

    public void cH(boolean z) {
        this.cjs = z;
    }

    public boolean afj() {
        return this.cjs;
    }

    public void eC(boolean z) {
        this.cjt = z;
    }

    protected boolean afk() {
        return this.cjt;
    }
}
