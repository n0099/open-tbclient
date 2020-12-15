package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class p extends com.baidu.tieba.frs.k<bx, com.baidu.card.am<by>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aiw;
    private boolean alo;
    private com.baidu.tieba.card.ab<by> hbw;
    private int jcT;
    private String mFrom;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.alo = true;
        this.jcT = 3;
        this.hbw = new com.baidu.tieba.card.ab<by>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if (p.this.iSB != null) {
                        p.this.iSB.a(view, (View) byVar, (Object) p.this.getType());
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").al("obj_type", 1).w("fid", byVar.getFid()).dY("tid", byVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(byVar, 2, p.this.mPageId, com.baidu.tieba.frs.d.d.jcU, p.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 5, p.this.mPageId, com.baidu.tieba.frs.d.d.jcU, p.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 14, p.this.mPageId, com.baidu.tieba.frs.d.d.jcU, p.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 12, p.this.mPageId, com.baidu.tieba.frs.d.d.jcU, p.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 13, p.this.mPageId, com.baidu.tieba.frs.d.d.jcU, p.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (p.this.hbw.ajN instanceof Boolean) {
                            if (((Boolean) p.this.hbw.ajN).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(byVar, 1, p.this.mPageId, com.baidu.tieba.frs.d.d.jcU, p.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(byVar, 3, p.this.mPageId, com.baidu.tieba.frs.d.d.jcU, p.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(byVar, 15, p.this.mPageId, com.baidu.tieba.frs.d.d.jcU, p.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(byVar, 1, p.this.mPageId, com.baidu.tieba.frs.d.d.jcU, p.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && byVar.bnv()) {
                        p.this.as(byVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cJI().a(com.baidu.tieba.frs.d.d.jcU, byVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.k.a(com.baidu.tieba.frs.d.d.jcU, byVar.bmo());
                    } else if (view instanceof TbImageView) {
                        if (p.this.hbw.ajN instanceof Boolean) {
                            if (((Boolean) p.this.hbw.ajN).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cJI().a(com.baidu.tieba.frs.d.d.jcU, byVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cJI().a(com.baidu.tieba.frs.d.d.jcU, byVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cJI().a(com.baidu.tieba.frs.d.d.jcU, byVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (byVar.bqu() != null && byVar.bqu().dPj() != null && byVar.bqu().dPj().bIC() != null && byVar.bqu().dPj().bIC().size() > 0) {
                            i = byVar.bqu().nmp ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cJI().a(com.baidu.tieba.frs.d.d.jcU, byVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.cJI().a(com.baidu.tieba.frs.d.d.jcU, byVar, 1);
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
    /* renamed from: aR */
    public com.baidu.card.am<by> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.i) nVar);
        nVar.setFromCDN(this.alo);
        nVar.setForm("frs");
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.iyv);
        a2.setSourceForPb(3);
        com.baidu.card.am<by> amVar = new com.baidu.card.am<>(a2);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.p.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof com.baidu.card.am)) {
                    if ((com.baidu.tieba.frs.b.cBe().cAY() || com.baidu.tieba.frs.a.cAX().cAY()) && !nVar.tN()) {
                        by byVar = ((bx) qVar).eCR;
                        if (byVar != null) {
                            if (!byVar.bqC() && com.baidu.tieba.frs.b.cBe().cAY()) {
                                if (com.baidu.tieba.frs.b.cBe().al(byVar)) {
                                    byVar.jg(true);
                                }
                            } else if (!byVar.bqD() && com.baidu.tieba.frs.a.cAX().cAY()) {
                                if (com.baidu.tieba.frs.a.cAX().al(byVar)) {
                                    byVar.jh(true);
                                }
                            } else {
                                com.baidu.tieba.frs.b.cBe().am(byVar);
                                byVar.jg(false);
                                com.baidu.tieba.frs.a.cAX().am(byVar);
                                byVar.jh(false);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, byVar));
                            return;
                        }
                        return;
                    }
                    com.baidu.card.am amVar2 = (com.baidu.card.am) view.getTag();
                    by byVar2 = ((bx) qVar).eCR;
                    byVar2.objType = 1;
                    if (p.this.hbw != null) {
                        p.this.hbw.a(amVar2.getView(), byVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar2, view.getContext(), p.this.jcT, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, com.baidu.card.am<by> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bxVar, (bx) amVar);
        if (bxVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tZ().setPage(this.aiw);
        amVar.tZ().setPosition(i);
        com.baidu.tieba.frs.j.a(amVar.tZ().tT(), this.iSv);
        if (this.iSv != null && this.iSv.getForum() != null && !StringUtils.isNull(this.iSv.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iSv.getForum().getTopic_special_icon_right())) {
            bxVar.eCR.dL(this.iSv.getForum().getTopic_special_icon(), this.iSv.getForum().getTopic_special_icon_right());
        }
        amVar.b((com.baidu.card.am<by>) bxVar.eCR);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.hbw);
        bxVar.eCR.bqd();
        return amVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
        this.jcT = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void oZ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return jcU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(by byVar) {
        TiebaStatic.log(new ar("c12126").dY("tid", byVar.getId()).al("obj_locate", cBS() ? 2 : 1).w("obj_id", byVar.bpj() == null ? -1L : byVar.bpj().live_id).al("obj_type", 1));
    }
}
