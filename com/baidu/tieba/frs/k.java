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
    protected static final int jfR;
    protected static final int jfS;
    protected static final int jfT;
    protected com.baidu.adp.widget.ListView.s iLY;
    protected FrsViewData jfU;
    protected f jfV;
    protected int jfW;
    protected i jfX;
    private boolean jfY;
    private boolean jfZ;
    protected com.baidu.tieba.card.ab jga;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TbPageTag mTbPageTag;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        jfR = resources.getDimensionPixelSize(R.dimen.ds8);
        jfS = resources.getDimensionPixelSize(R.dimen.ds16);
        jfT = resources.getDimensionPixelSize(R.dimen.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.jfZ = false;
        this.mTbPageTag = null;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.jfZ = false;
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
        this.jfV = null;
        this.Wk = null;
        this.Wl = null;
        if (this.jfX != null) {
            this.jfX.destory();
            this.jfX = null;
        }
    }

    public void b(com.baidu.adp.widget.ListView.s sVar) {
        this.iLY = sVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.iLY = (com.baidu.adp.widget.ListView.s) viewGroup;
        if (t instanceof ca) {
            ((ca) t).eJQ.nj(2);
            return null;
        }
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void b(FrsViewData frsViewData) {
        this.jfU = frsViewData;
    }

    public void a(f fVar) {
        this.jfV = fVar;
    }

    public void yu(int i) {
        this.jfW = i;
    }

    public void a(i iVar) {
        this.jfX = iVar;
    }

    public boolean cCn() {
        return this.jfY;
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

    public boolean cCo() {
        if (this.mTbPageTag == null) {
            return false;
        }
        return this.mTbPageTag.tabType == 91 || this.mTbPageTag.tabId == 89 || this.mTbPageTag.tabId == 504 || this.mTbPageTag.tabType == 15 || this.mTbPageTag.tabType == 16 || this.mTbPageTag.tabType == 3;
    }
}
