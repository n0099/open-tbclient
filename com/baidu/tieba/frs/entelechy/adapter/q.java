package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class q extends com.baidu.tieba.frs.k<ca, ThreadCardViewHolder<cb>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String ajx;
    private boolean amh;
    private com.baidu.tieba.card.ab<cb> hoN;
    private int jsm;
    private String mFrom;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.amh = true;
        this.jsm = 3;
        this.hoN = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if (q.this.jhJ != null) {
                        q.this.jhJ.a(view, (View) cbVar, (Object) q.this.getType());
                    }
                    if ("c13010".equals(q.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").aq("obj_type", 1).v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, q.this.mPageId, com.baidu.tieba.frs.b.d.jsn, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, q.this.mPageId, com.baidu.tieba.frs.b.d.jsn, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 14, q.this.mPageId, com.baidu.tieba.frs.b.d.jsn, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 12, q.this.mPageId, com.baidu.tieba.frs.b.d.jsn, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 13, q.this.mPageId, com.baidu.tieba.frs.b.d.jsn, q.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (q.this.hoN.akF instanceof Boolean) {
                            if (((Boolean) q.this.hoN.akF).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(cbVar, 1, q.this.mPageId, com.baidu.tieba.frs.b.d.jsn, q.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(cbVar, 3, q.this.mPageId, com.baidu.tieba.frs.b.d.jsn, q.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 15, q.this.mPageId, com.baidu.tieba.frs.b.d.jsn, q.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, q.this.mPageId, com.baidu.tieba.frs.b.d.jsn, q.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && cbVar.bmx()) {
                        q.this.as(cbVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKr().a(com.baidu.tieba.frs.b.d.jsn, cbVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(com.baidu.tieba.frs.b.d.jsn, cbVar.blq());
                    } else if (view instanceof TbImageView) {
                        if (q.this.hoN.akF instanceof Boolean) {
                            if (((Boolean) q.this.hoN.akF).booleanValue()) {
                                com.baidu.tieba.frs.b.c.cKr().a(com.baidu.tieba.frs.b.d.jsn, cbVar, 1);
                            } else {
                                com.baidu.tieba.frs.b.c.cKr().a(com.baidu.tieba.frs.b.d.jsn, cbVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).aq("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.b.c.cKr().a(com.baidu.tieba.frs.b.d.jsn, cbVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (cbVar.bpx() != null && cbVar.bpx().dNQ() != null && cbVar.bpx().dNQ().bHD() != null && cbVar.bpx().dNQ().bHD().size() > 0) {
                            i = cbVar.bpx().nzJ ? 9 : 8;
                        }
                        com.baidu.tieba.frs.b.c.cKr().a(com.baidu.tieba.frs.b.d.jsn, cbVar, i);
                    } else {
                        com.baidu.tieba.frs.b.c.cKr().a(com.baidu.tieba.frs.b.d.jsn, cbVar, 1);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<cb> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) nVar);
        nVar.setFromCDN(this.amh);
        nVar.setForm("frs");
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.iNH);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<cb> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.q.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    if ((com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy()) && !nVar.sX()) {
                        cb cbVar = ((ca) nVar2).eLr;
                        if (cbVar != null) {
                            if (!cbVar.bpF() && com.baidu.tieba.frs.b.cBE().cBy()) {
                                if (com.baidu.tieba.frs.b.cBE().am(cbVar)) {
                                    cbVar.jA(true);
                                }
                            } else if (!cbVar.bpG() && com.baidu.tieba.frs.a.cBx().cBy()) {
                                if (com.baidu.tieba.frs.a.cBx().am(cbVar)) {
                                    cbVar.jB(true);
                                }
                            } else {
                                com.baidu.tieba.frs.b.cBE().an(cbVar);
                                cbVar.jA(false);
                                com.baidu.tieba.frs.a.cBx().an(cbVar);
                                cbVar.jB(false);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, cbVar));
                            return;
                        }
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    cb cbVar2 = ((ca) nVar2).eLr;
                    cbVar2.objType = 1;
                    if (q.this.hoN != null) {
                        q.this.hoN.a(threadCardViewHolder2.getView(), cbVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar2, view.getContext(), q.this.jsm, false);
                    threadCardViewHolder2.tj().b(new a.C0095a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, ThreadCardViewHolder<cb> threadCardViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) caVar, (ca) threadCardViewHolder);
        if (caVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.tj().setPage(this.ajx);
        threadCardViewHolder.tj().setPosition(i);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tj().td(), this.jhD);
        if (this.jhD != null && this.jhD.getForum() != null && !StringUtils.isNull(this.jhD.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jhD.getForum().getTopic_special_icon_right())) {
            caVar.eLr.dD(this.jhD.getForum().getTopic_special_icon(), this.jhD.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) caVar.eLr);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.hoN);
        caVar.eLr.bpf();
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uZ(int i) {
        this.jsm = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void pD(boolean z) {
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return jsn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(cb cbVar) {
        TiebaStatic.log(new ar("c12126").dR("tid", cbVar.getId()).aq("obj_locate", cCt() ? 2 : 1).v("obj_id", cbVar.bol() == null ? -1L : cbVar.bol().live_id).aq("obj_type", 1));
    }
}
