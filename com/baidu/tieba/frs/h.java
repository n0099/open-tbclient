package com.baidu.tieba.frs;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.q.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public abstract class h<T, V extends q.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int dBd;
    protected static final int dBe;
    protected static final int dBf;
    protected com.baidu.tieba.tbadkCore.l dBg;
    protected d dBh;
    protected com.baidu.adp.widget.ListView.j dBi;
    protected int dBj;
    protected f dBk;
    private boolean dBl;
    private boolean dBm;
    protected com.baidu.tieba.card.ad dBn;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        dBd = resources.getDimensionPixelSize(e.C0200e.ds8);
        dBe = resources.getDimensionPixelSize(e.C0200e.ds16);
        dBf = resources.getDimensionPixelSize(e.C0200e.ds1);
    }

    public void c(com.baidu.tieba.card.ad adVar) {
        this.dBn = adVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.dBm = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.dBm = false;
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
        this.dBh = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.dBk != null) {
            this.dBk.destory();
            this.dBk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dBi = (com.baidu.adp.widget.ListView.j) viewGroup;
        if (t instanceof bb) {
            ((bb) t).setResource(2);
            return null;
        }
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        this.dBg = lVar;
    }

    public void a(d dVar) {
        this.dBh = dVar;
    }

    public void lD(int i) {
        this.dBj = i;
    }

    public void a(f fVar) {
        this.dBk = fVar;
    }

    public boolean ayN() {
        return this.dBl;
    }

    public View o(ViewGroup viewGroup, int i) {
        if (viewGroup == null) {
            return null;
        }
        if (viewGroup instanceof ListView) {
            ListView listView = (ListView) viewGroup;
            return listView.getChildAt(i - (listView.getFirstVisiblePosition() - listView.getHeaderViewsCount()));
        } else if (viewGroup instanceof BdRecyclerView) {
            BdRecyclerView bdRecyclerView = (BdRecyclerView) viewGroup;
            return bdRecyclerView.findViewHolderForAdapterPosition(i - (bdRecyclerView.getFirstVisiblePosition() - bdRecyclerView.getHeaderViewsCount())).itemView;
        } else if (!(viewGroup instanceof RecyclerView)) {
            return null;
        } else {
            return ((RecyclerView) viewGroup).findViewHolderForAdapterPosition(i).itemView;
        }
    }
}
