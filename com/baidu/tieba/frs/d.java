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
    protected static final int cxx;
    protected static final int cxy;
    protected static final int cxz;
    protected com.baidu.tieba.tbadkCore.j cxA;
    protected b cxB;
    protected int cxC;
    protected c cxD;
    private boolean cxE;
    private boolean cxF;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        cxx = resources.getDimensionPixelSize(d.e.ds8);
        cxy = resources.getDimensionPixelSize(d.e.ds16);
        cxz = resources.getDimensionPixelSize(d.e.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.cxF = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.cxF = false;
        a(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mPageContext = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    public void release() {
        this.mContext = null;
        this.mPageContext = null;
        this.cxB = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.cxD != null) {
            this.cxD.destory();
            this.cxD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.mListView = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.j jVar) {
        this.cxA = jVar;
    }

    public void a(b bVar) {
        this.cxB = bVar;
    }

    public void jl(int i) {
        this.cxC = i;
    }

    public void a(c cVar) {
        this.cxD = cVar;
    }

    public void cE(boolean z) {
        this.cxE = z;
    }

    public boolean aiY() {
        return this.cxE;
    }

    protected boolean aiZ() {
        return this.cxF;
    }
}
