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
    protected static final int cpx;
    protected static final int cpy;
    protected static final int cpz;
    protected com.baidu.tieba.tbadkCore.i cpA;
    protected b cpB;
    protected int cpC;
    protected c cpD;
    private boolean cpE;
    private boolean cpF;
    protected TbPageContext<?> mF;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        cpx = resources.getDimensionPixelSize(d.f.ds8);
        cpy = resources.getDimensionPixelSize(d.f.ds16);
        cpz = resources.getDimensionPixelSize(d.f.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.cpF = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.cpF = false;
        a(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mF = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    public void release() {
        this.mContext = null;
        this.mF = null;
        this.cpB = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.cpD != null) {
            this.cpD.destory();
            this.cpD = null;
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

    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        this.cpA = iVar;
    }

    public void a(b bVar) {
        this.cpB = bVar;
    }

    public void iP(int i) {
        this.cpC = i;
    }

    public void a(c cVar) {
        this.cpD = cVar;
    }

    public void cK(boolean z) {
        this.cpE = z;
    }

    public boolean agM() {
        return this.cpE;
    }

    public void eG(boolean z) {
        this.cpF = z;
    }

    protected boolean agN() {
        return this.cpF;
    }
}
