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
public abstract class e<T, V extends j.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int cGL;
    protected static final int cGM;
    protected static final int cGN;
    protected com.baidu.tieba.tbadkCore.k cGO;
    protected b cGP;
    protected int cGQ;
    protected c cGR;
    private boolean cGS;
    private boolean cGT;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        cGL = resources.getDimensionPixelSize(d.e.ds8);
        cGM = resources.getDimensionPixelSize(d.e.ds16);
        cGN = resources.getDimensionPixelSize(d.e.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.cGT = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.cGT = false;
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
        this.cGP = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.cGR != null) {
            this.cGR.destory();
            this.cGR = null;
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

    public void b(com.baidu.tieba.tbadkCore.k kVar) {
        this.cGO = kVar;
    }

    public void a(b bVar) {
        this.cGP = bVar;
    }

    public void jL(int i) {
        this.cGQ = i;
    }

    public void a(c cVar) {
        this.cGR = cVar;
    }

    public void cN(boolean z) {
        this.cGS = z;
    }

    public boolean alb() {
        return this.cGS;
    }

    protected boolean alc() {
        return this.cGT;
    }
}
