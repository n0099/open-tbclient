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
    private String aif;
    private boolean akO;
    private com.baidu.tieba.card.ab<cb> hnd;
    private int jqD;
    private String mFrom;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.akO = true;
        this.jqD = 3;
        this.hnd = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if (q.this.jga != null) {
                        q.this.jga.a(view, (View) cbVar, (Object) q.this.getType());
                    }
                    if ("c13010".equals(q.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ap("obj_type", 1).v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, q.this.mPageId, com.baidu.tieba.frs.b.d.jqE, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, q.this.mPageId, com.baidu.tieba.frs.b.d.jqE, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 14, q.this.mPageId, com.baidu.tieba.frs.b.d.jqE, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 12, q.this.mPageId, com.baidu.tieba.frs.b.d.jqE, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 13, q.this.mPageId, com.baidu.tieba.frs.b.d.jqE, q.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (q.this.hnd.ajn instanceof Boolean) {
                            if (((Boolean) q.this.hnd.ajn).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(cbVar, 1, q.this.mPageId, com.baidu.tieba.frs.b.d.jqE, q.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(cbVar, 3, q.this.mPageId, com.baidu.tieba.frs.b.d.jqE, q.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 15, q.this.mPageId, com.baidu.tieba.frs.b.d.jqE, q.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, q.this.mPageId, com.baidu.tieba.frs.b.d.jqE, q.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && cbVar.bmv()) {
                        q.this.as(cbVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(com.baidu.tieba.frs.b.d.jqE, cbVar.blo());
                    } else if (view instanceof TbImageView) {
                        if (q.this.hnd.ajn instanceof Boolean) {
                            if (((Boolean) q.this.hnd.ajn).booleanValue()) {
                                com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, 1);
                            } else {
                                com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (cbVar.bpv() != null && cbVar.bpv().dNH() != null && cbVar.bpv().dNH().bHz() != null && cbVar.bpv().dNH().bHz().size() > 0) {
                            i = cbVar.bpv().nxE ? 9 : 8;
                        }
                        com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, i);
                    } else {
                        com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, 1);
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
        nVar.setFromCDN(this.akO);
        nVar.setForm("frs");
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.iLY);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<cb> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.q.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    if ((com.baidu.tieba.frs.b.cBy().cBs() || com.baidu.tieba.frs.a.cBr().cBs()) && !nVar.sX()) {
                        cb cbVar = ((ca) nVar2).eJQ;
                        if (cbVar != null) {
                            if (!cbVar.bpD() && com.baidu.tieba.frs.b.cBy().cBs()) {
                                if (com.baidu.tieba.frs.b.cBy().am(cbVar)) {
                                    cbVar.jA(true);
                                }
                            } else if (!cbVar.bpE() && com.baidu.tieba.frs.a.cBr().cBs()) {
                                if (com.baidu.tieba.frs.a.cBr().am(cbVar)) {
                                    cbVar.jB(true);
                                }
                            } else {
                                com.baidu.tieba.frs.b.cBy().an(cbVar);
                                cbVar.jA(false);
                                com.baidu.tieba.frs.a.cBr().an(cbVar);
                                cbVar.jB(false);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, cbVar));
                            return;
                        }
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    cb cbVar2 = ((ca) nVar2).eJQ;
                    cbVar2.objType = 1;
                    if (q.this.hnd != null) {
                        q.this.hnd.a(threadCardViewHolder2.getView(), cbVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar2, view.getContext(), q.this.jqD, false);
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
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
        threadCardViewHolder.tj().setPage(this.aif);
        threadCardViewHolder.tj().setPosition(i);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tj().td(), this.jfU);
        if (this.jfU != null && this.jfU.getForum() != null && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon_right())) {
            caVar.eJQ.dD(this.jfU.getForum().getTopic_special_icon(), this.jfU.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) caVar.eJQ);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.hnd);
        caVar.eJQ.bpd();
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
        this.jqD = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void pD(boolean z) {
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return jqE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(cb cbVar) {
        TiebaStatic.log(new ar("c12126").dR("tid", cbVar.getId()).ap("obj_locate", cCn() ? 2 : 1).v("obj_id", cbVar.boj() == null ? -1L : cbVar.boj().live_id).ap("obj_type", 1));
    }
}
