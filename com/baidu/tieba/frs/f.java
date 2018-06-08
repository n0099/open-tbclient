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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class f<T, V extends q.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int dhc;
    protected static final int dhd;
    protected static final int dhe;
    protected com.baidu.tieba.tbadkCore.l dhf;
    protected b dhg;
    protected com.baidu.adp.widget.ListView.j dhh;
    protected int dhi;
    protected d dhj;
    private boolean dhk;
    private boolean dhl;
    protected com.baidu.tieba.card.ab dhm;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        dhc = resources.getDimensionPixelSize(d.e.ds8);
        dhd = resources.getDimensionPixelSize(d.e.ds16);
        dhe = resources.getDimensionPixelSize(d.e.ds1);
    }

    public void c(com.baidu.tieba.card.ab abVar) {
        this.dhm = abVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.dhl = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.dhl = false;
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
        this.dhg = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.dhj != null) {
            this.dhj.destory();
            this.dhj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dhh = (com.baidu.adp.widget.ListView.j) viewGroup;
        if (t instanceof bd) {
            ((bd) t).setResource(2);
            return null;
        }
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        this.dhf = lVar;
    }

    public void a(b bVar) {
        this.dhg = bVar;
    }

    public void ka(int i) {
        this.dhi = i;
    }

    public void a(d dVar) {
        this.dhj = dVar;
    }

    public boolean atg() {
        return this.dhk;
    }

    public View j(ViewGroup viewGroup, int i) {
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
