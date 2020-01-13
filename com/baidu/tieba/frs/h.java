package com.baidu.tieba.frs;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.v.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes6.dex */
public abstract class h<T, V extends v.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int glG;
    protected static final int glH;
    protected static final int glI;
    protected com.baidu.adp.widget.ListView.r fUA;
    protected FrsViewData glJ;
    protected d glK;
    protected int glL;
    protected f glM;
    private boolean glN;
    private boolean glO;
    protected com.baidu.tieba.card.z glP;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TbPageTag mTbPageTag;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        glG = resources.getDimensionPixelSize(R.dimen.ds8);
        glH = resources.getDimensionPixelSize(R.dimen.ds16);
        glI = resources.getDimensionPixelSize(R.dimen.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.glO = false;
        this.mTbPageTag = null;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.glO = false;
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
        this.glK = null;
        this.zL = null;
        this.zM = null;
        if (this.glM != null) {
            this.glM.destory();
            this.glM = null;
        }
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.fUA = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.fUA = (com.baidu.adp.widget.ListView.r) viewGroup;
        if (t instanceof bi) {
            ((bi) t).cNb.jr(2);
            return null;
        }
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void b(FrsViewData frsViewData) {
        this.glJ = frsViewData;
    }

    public void a(d dVar) {
        this.glK = dVar;
    }

    public void su(int i) {
        this.glL = i;
    }

    public void a(f fVar) {
        this.glM = fVar;
    }

    public boolean bBX() {
        return this.glN;
    }

    public View t(ViewGroup viewGroup, int i) {
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
