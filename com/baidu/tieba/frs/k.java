package com.baidu.tieba.frs;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes.dex */
public abstract class k<T, V extends TypeAdapter.ViewHolder> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int jhA;
    protected static final int jhB;
    protected static final int jhC;
    protected com.baidu.adp.widget.ListView.s iNH;
    protected FrsViewData jhD;
    protected f jhE;
    protected int jhF;
    protected i jhG;
    private boolean jhH;
    private boolean jhI;
    protected com.baidu.tieba.card.ab jhJ;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TbPageTag mTbPageTag;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        jhA = resources.getDimensionPixelSize(R.dimen.ds8);
        jhB = resources.getDimensionPixelSize(R.dimen.ds16);
        jhC = resources.getDimensionPixelSize(R.dimen.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.jhI = false;
        this.mTbPageTag = null;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.jhI = false;
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
        this.jhE = null;
        this.XE = null;
        this.XF = null;
        if (this.jhG != null) {
            this.jhG.destory();
            this.jhG = null;
        }
    }

    public void b(com.baidu.adp.widget.ListView.s sVar) {
        this.iNH = sVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.iNH = (com.baidu.adp.widget.ListView.s) viewGroup;
        if (t instanceof ca) {
            ((ca) t).eLr.nk(2);
            return null;
        }
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void b(FrsViewData frsViewData) {
        this.jhD = frsViewData;
    }

    public void a(f fVar) {
        this.jhE = fVar;
    }

    public void yv(int i) {
        this.jhF = i;
    }

    public void a(i iVar) {
        this.jhG = iVar;
    }

    public boolean cCt() {
        return this.jhH;
    }

    public View C(ViewGroup viewGroup, int i) {
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

    public boolean cCu() {
        if (this.mTbPageTag == null) {
            return false;
        }
        return this.mTbPageTag.tabType == 91 || this.mTbPageTag.tabId == 89 || this.mTbPageTag.tabId == 504 || this.mTbPageTag.tabType == 15 || this.mTbPageTag.tabType == 16 || this.mTbPageTag.tabType == 3;
    }
}
