package com.baidu.tieba.frs;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes21.dex */
public abstract class k<T, V extends af.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int iAN;
    protected static final int iAO;
    protected static final int iAP;
    protected FrsViewData iAQ;
    protected f iAR;
    protected int iAS;
    protected i iAT;
    private boolean iAU;
    private boolean iAV;
    protected com.baidu.tieba.card.ab iAW;
    protected com.baidu.adp.widget.ListView.v igO;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TbPageTag mTbPageTag;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        iAN = resources.getDimensionPixelSize(R.dimen.ds8);
        iAO = resources.getDimensionPixelSize(R.dimen.ds16);
        iAP = resources.getDimensionPixelSize(R.dimen.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.iAV = false;
        this.mTbPageTag = null;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.iAV = false;
        this.mTbPageTag = null;
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
        this.iAR = null;
        this.Vu = null;
        this.Vv = null;
        if (this.iAT != null) {
            this.iAT.destory();
            this.iAT = null;
        }
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.igO = vVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.igO = (com.baidu.adp.widget.ListView.v) viewGroup;
        if (t instanceof bv) {
            ((bv) t).erH.nY(2);
            return null;
        }
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void b(FrsViewData frsViewData) {
        this.iAQ = frsViewData;
    }

    public void a(f fVar) {
        this.iAR = fVar;
    }

    public void yn(int i) {
        this.iAS = i;
    }

    public void a(i iVar) {
        this.iAT = iVar;
    }

    public boolean cvx() {
        return this.iAU;
    }

    public View x(ViewGroup viewGroup, int i) {
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

    public void a(TbPageTag tbPageTag) {
        this.mTbPageTag = tbPageTag;
    }

    public TbPageTag getTbPageTag() {
        return this.mTbPageTag;
    }
}
