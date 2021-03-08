package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.frs.k<cb, ThreadCardViewHolder<cb>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String ajx;
    private boolean amh;
    private com.baidu.tieba.card.ab<cb> hoQ;
    private boolean jsE;
    private boolean jsF;
    private int jsm;
    private com.baidu.tieba.frs.b.b jsn;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.amh = false;
        this.jsE = false;
        this.jsm = 3;
        this.jsn = new com.baidu.tieba.frs.b.b();
        this.hoQ = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    BdToast.b(f.this.mContext, f.this.mContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.br(4272);
        dVar.setPageUniqueId(this.mPageId);
        aVar.a(dVar);
        com.baidu.card.i iVar = new com.baidu.card.i(this.mPageContext.getPageActivity());
        if (this.jsm == 502) {
            iVar.setNeedFrsTabName(false);
        } else {
            iVar.setNeedFrsTabName(true);
        }
        aVar.c(iVar);
        if (this.jsF) {
            aVar.a((com.baidu.card.h) new com.baidu.card.s(this.mPageContext.getPageActivity()));
        }
        aVar.a((com.baidu.card.h) new com.baidu.card.ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.l(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.amh);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 2;
        eVar.eNC = 2;
        eVar.eNH = 2;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(this.jsm);
        amVar.br(Opcodes.ARETURN);
        if (this.jsE) {
            amVar.bs(4);
        }
        aVar.b(amVar);
        aVar.ti().by(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak th = aVar.th();
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(th);
        threadCardViewHolder.setPageId(this.mPageId);
        th.a(this.hoQ);
        th.setSourceForPb(this.jsm);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.f.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                BdToast.b(f.this.mContext, f.this.mContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
            }
        });
        threadCardViewHolder.tk();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, ThreadCardViewHolder threadCardViewHolder) {
        if (threadCardViewHolder == null) {
            return null;
        }
        if (cbVar == null) {
            return threadCardViewHolder.getView();
        }
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.ajx);
        }
        super.a(i, view, viewGroup, (ViewGroup) cbVar, (cb) threadCardViewHolder);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tj().td(), this.jhD);
        if (this.jhD != null && this.jhD.getForum() != null && !StringUtils.isNull(this.jhD.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jhD.getForum().getTopic_special_icon_right())) {
            cbVar.dD(this.jhD.getForum().getTopic_special_icon(), this.jhD.getForum().getTopic_special_icon_right());
        }
        if (!cbVar.isBjh()) {
            threadCardViewHolder.tl();
        }
        threadCardViewHolder.b((ThreadCardViewHolder) cbVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.hoQ);
        cbVar.bpf();
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uZ(int i) {
        this.jsm = i;
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    @Override // com.baidu.tieba.card.aa
    public void pD(boolean z) {
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jsn;
    }

    public void rd(boolean z) {
        this.jsE = z;
    }

    public void re(boolean z) {
        this.jsF = z;
    }
}
