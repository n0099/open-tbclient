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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class h<T, V extends q.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int diZ;
    protected static final int dja;
    protected static final int djb;
    protected com.baidu.tieba.tbadkCore.l djc;
    protected d djd;
    protected com.baidu.adp.widget.ListView.j dje;
    protected int djf;
    protected f djg;
    private boolean djh;
    private boolean dji;
    protected com.baidu.tieba.card.ad djj;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        diZ = resources.getDimensionPixelSize(d.e.ds8);
        dja = resources.getDimensionPixelSize(d.e.ds16);
        djb = resources.getDimensionPixelSize(d.e.ds1);
    }

    public void c(com.baidu.tieba.card.ad adVar) {
        this.djj = adVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.dji = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.dji = false;
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
        this.djd = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.djg != null) {
            this.djg.destory();
            this.djg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dje = (com.baidu.adp.widget.ListView.j) viewGroup;
        if (t instanceof bc) {
            ((bc) t).setResource(2);
            return null;
        }
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        this.djc = lVar;
    }

    public void a(d dVar) {
        this.djd = dVar;
    }

    public void ke(int i) {
        this.djf = i;
    }

    public void a(f fVar) {
        this.djg = fVar;
    }

    public boolean atx() {
        return this.djh;
    }

    public View n(ViewGroup viewGroup, int i) {
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
