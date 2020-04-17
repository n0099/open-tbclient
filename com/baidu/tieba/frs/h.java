package com.baidu.tieba.frs;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.adp.widget.ListView.y.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes8.dex */
public abstract class h<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int gXL;
    protected static final int gXM;
    protected static final int gXN;
    protected com.baidu.adp.widget.ListView.r gEc;
    protected FrsViewData gXO;
    protected d gXP;
    protected int gXQ;
    protected f gXR;
    private boolean gXS;
    private boolean gXT;
    protected com.baidu.tieba.card.z gXU;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TbPageTag mTbPageTag;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        gXL = resources.getDimensionPixelSize(R.dimen.ds8);
        gXM = resources.getDimensionPixelSize(R.dimen.ds16);
        gXN = resources.getDimensionPixelSize(R.dimen.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.gXT = false;
        this.mTbPageTag = null;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.gXT = false;
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
        this.gXP = null;
        this.Tt = null;
        this.Tu = null;
        if (this.gXR != null) {
            this.gXR.destory();
            this.gXR = null;
        }
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gEc = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.gEc = (com.baidu.adp.widget.ListView.r) viewGroup;
        if (t instanceof bi) {
            ((bi) t).dqA.jP(2);
            return null;
        }
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void b(FrsViewData frsViewData) {
        this.gXO = frsViewData;
    }

    public void a(d dVar) {
        this.gXP = dVar;
    }

    public void sZ(int i) {
        this.gXQ = i;
    }

    public void a(f fVar) {
        this.gXR = fVar;
    }

    public boolean bOk() {
        return this.gXS;
    }

    public View u(ViewGroup viewGroup, int i) {
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
