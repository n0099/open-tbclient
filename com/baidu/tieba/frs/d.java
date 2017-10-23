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
    protected static final int cpK;
    protected static final int cpL;
    protected static final int cpM;
    protected com.baidu.tieba.tbadkCore.i cpN;
    protected b cpO;
    protected int cpP;
    protected c cpQ;
    private boolean cpR;
    private boolean cpS;
    protected TbPageContext<?> mH;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected int mSkinType;

    static {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        cpK = resources.getDimensionPixelSize(d.f.ds8);
        cpL = resources.getDimensionPixelSize(d.f.ds16);
        cpM = resources.getDimensionPixelSize(d.f.ds1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = false;
        this.cpS = false;
        a(tbPageContext, bdUniqueId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.cpS = false;
        a(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mH = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    public void release() {
        this.mContext = null;
        this.mH = null;
        this.cpO = null;
        this.mAdapterItemClickListener = null;
        this.mAdapterItemLongClickListener = null;
        if (this.cpQ != null) {
            this.cpQ.destory();
            this.cpQ = null;
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
        this.cpN = iVar;
    }

    public void a(b bVar) {
        this.cpO = bVar;
    }

    public void iW(int i) {
        this.cpP = i;
    }

    public void a(c cVar) {
        this.cpQ = cVar;
    }

    public void cI(boolean z) {
        this.cpR = z;
    }

    public boolean agD() {
        return this.cpR;
    }

    public void ev(boolean z) {
        this.cpS = z;
    }

    protected boolean agE() {
        return this.cpS;
    }
}
