package com.baidu.tieba.frs;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.v.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes3.dex */
public abstract class h<T, V extends v.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int eYt;
    protected static final int eYu;
    protected static final int eYv;
    protected r eEv;
    private boolean eYA;
    private boolean eYB;
    protected com.baidu.tieba.card.ab eYC;
    protected FrsViewData eYw;
    protected d eYx;
    protected int eYy;
    protected f eYz;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        eYt = resources.getDimensionPixelSize(d.e.ds8);
        eYu = resources.getDimensionPixelSize(d.e.ds16);
        eYv = resources.getDimensionPixelSize(d.e.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.eYB = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.eYB = false;
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
        this.eYx = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.eYz != null) {
            this.eYz.destory();
            this.eYz = null;
        }
    }

    public void a(r rVar) {
        this.eEv = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.eEv = (r) viewGroup;
        if (t instanceof bf) {
            ((bf) t).threadData.setResource(2);
            return null;
        }
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void b(FrsViewData frsViewData) {
        this.eYw = frsViewData;
    }

    public void a(d dVar) {
        this.eYx = dVar;
    }

    public void pS(int i) {
        this.eYy = i;
    }

    public void a(f fVar) {
        this.eYz = fVar;
    }

    public boolean bcj() {
        return this.eYA;
    }

    public View p(ViewGroup viewGroup, int i) {
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
