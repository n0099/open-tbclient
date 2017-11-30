package com.baidu.tieba.frs;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.adp.widget.ListView.j.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class d<T, V extends j.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int cGD;
    protected static final int cGE;
    protected static final int cGF;
    protected com.baidu.tieba.tbadkCore.k cGG;
    protected b cGH;
    protected int cGI;
    protected c cGJ;
    private boolean cGK;
    private boolean cGL;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        cGD = resources.getDimensionPixelSize(d.e.ds8);
        cGE = resources.getDimensionPixelSize(d.e.ds16);
        cGF = resources.getDimensionPixelSize(d.e.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.cGL = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.cGL = false;
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
        this.cGH = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.cGJ != null) {
            this.cGJ.destory();
            this.cGJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.mListView = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.k kVar) {
        this.cGG = kVar;
    }

    public void a(b bVar) {
        this.cGH = bVar;
    }

    public void jJ(int i) {
        this.cGI = i;
    }

    public void a(c cVar) {
        this.cGJ = cVar;
    }

    public void cM(boolean z) {
        this.cGK = z;
    }

    public boolean akS() {
        return this.cGK;
    }

    protected boolean akT() {
        return this.cGL;
    }
}
