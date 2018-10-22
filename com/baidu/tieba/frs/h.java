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
    protected static final int dzM;
    protected static final int dzN;
    protected static final int dzO;
    protected com.baidu.tieba.tbadkCore.l dzP;
    protected d dzQ;
    protected com.baidu.adp.widget.ListView.j dzR;
    protected int dzS;
    protected f dzT;
    private boolean dzU;
    private boolean dzV;
    protected com.baidu.tieba.card.ad dzW;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        dzM = resources.getDimensionPixelSize(e.C0175e.ds8);
        dzN = resources.getDimensionPixelSize(e.C0175e.ds16);
        dzO = resources.getDimensionPixelSize(e.C0175e.ds1);
    }

    public void c(com.baidu.tieba.card.ad adVar) {
        this.dzW = adVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.dzV = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.dzV = false;
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
        this.dzQ = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.dzT != null) {
            this.dzT.destory();
            this.dzT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dzR = (com.baidu.adp.widget.ListView.j) viewGroup;
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
        this.dzP = lVar;
    }

    public void a(d dVar) {
        this.dzQ = dVar;
    }

    public void ll(int i) {
        this.dzS = i;
    }

    public void a(f fVar) {
        this.dzT = fVar;
    }

    public boolean azq() {
        return this.dzU;
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
