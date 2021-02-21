package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.frs.k<ca, ThreadCardViewHolder<cb>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aif;
    private int jqD;
    private com.baidu.tieba.frs.b.b jqE;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jqD = 3;
        this.jqE = new com.baidu.tieba.frs.b.b();
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.i iVar = new com.baidu.card.i(this.mPageContext.getPageActivity());
        if (this.jqD == 502) {
            iVar.setNeedFrsTabName(false);
        } else {
            iVar.setNeedFrsTabName(true);
        }
        aVar.c(iVar);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.iLY));
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.p.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                BdToast.b(p.this.mContext, p.this.mContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
            }
        });
        threadCardViewHolder.aL(false);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, ThreadCardViewHolder<cb> threadCardViewHolder) {
        if (threadCardViewHolder == null) {
            return null;
        }
        if (caVar == null) {
            return threadCardViewHolder.getView();
        }
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        super.a(i, view, viewGroup, (ViewGroup) caVar, (ca) threadCardViewHolder);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tj().td(), this.jfU);
        threadCardViewHolder.tj().setPosition(i);
        if (this.jfU != null && this.jfU.getForum() != null && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon_right())) {
            caVar.eJQ.dD(this.jfU.getForum().getTopic_special_icon(), this.jfU.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) caVar.eJQ);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        caVar.eJQ.bpd();
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
        this.jqD = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    @Override // com.baidu.tieba.card.aa
    public void pD(boolean z) {
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jqE;
    }
}
