package com.baidu.tieba.frs;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.adp.widget.ListView.z.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class p<T, V extends z.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected static final int cbK;
    protected static final int cbL;
    protected static final int cbM;
    protected TbPageContext<?> ajP;
    protected com.baidu.tieba.tbadkCore.n cbN;
    protected n cbO;
    protected ListView cbP;
    protected int cbQ;
    protected o cbR;
    private boolean cbS;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.m9getInst().getContext().getResources();
        cbK = resources.getDimensionPixelSize(w.f.ds8);
        cbL = resources.getDimensionPixelSize(w.f.ds16);
        cbM = resources.getDimensionPixelSize(w.f.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        a(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.ajP = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    public void release() {
        this.mContext = null;
        this.ajP = null;
        this.cbO = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.cbR != null) {
            this.cbR.destory();
            this.cbR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.cbP = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        this.cbN = nVar;
    }

    public void a(n nVar) {
        this.cbO = nVar;
    }

    public void iq(int i) {
        this.cbQ = i;
    }

    public void a(o oVar) {
        this.cbR = oVar;
    }

    public void cA(boolean z) {
        this.cbS = z;
    }

    public boolean adJ() {
        return this.cbS;
    }
}
