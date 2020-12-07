package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
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
public class v extends com.baidu.tieba.frs.k<bx, com.baidu.card.am<by>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aiw;
    private boolean alo;
    private com.baidu.tieba.card.ab<by> hbu;
    private int jcO;
    private String mFrom;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.alo = true;
        this.hbu = new com.baidu.tieba.card.ab<by>() { // from class: com.baidu.tieba.frs.entelechy.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if (v.this.iSz != null) {
                        v.this.iSz.a(view, (View) byVar, (Object) v.this.getType());
                    }
                    if ("c13010".equals(v.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").al("obj_type", 1).w("fid", byVar.getFid()).dY("tid", byVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(byVar, 2, v.this.mPageId, com.baidu.tieba.frs.d.d.jcS, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 5, v.this.mPageId, com.baidu.tieba.frs.d.d.jcS, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 14, v.this.mPageId, com.baidu.tieba.frs.d.d.jcS, v.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (v.this.hbu.ajN instanceof Boolean) {
                            if (((Boolean) v.this.hbu.ajN).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(byVar, 1, v.this.mPageId, com.baidu.tieba.frs.d.d.jcS, v.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(byVar, 3, v.this.mPageId, com.baidu.tieba.frs.d.d.jcS, v.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(byVar, 15, v.this.mPageId, com.baidu.tieba.frs.d.d.jcS, v.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(byVar, 1, v.this.mPageId, com.baidu.tieba.frs.d.d.jcS, v.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cJH().a(com.baidu.tieba.frs.d.d.jcS, byVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.k.a(com.baidu.tieba.frs.d.d.jcS, byVar.bmo());
                    } else if (view instanceof TbImageView) {
                        if (v.this.hbu.ajN instanceof Boolean) {
                            if (((Boolean) v.this.hbu.ajN).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cJH().a(com.baidu.tieba.frs.d.d.jcS, byVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cJH().a(com.baidu.tieba.frs.d.d.jcS, byVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cJH().a(com.baidu.tieba.frs.d.d.jcS, byVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (byVar.bqu() != null && byVar.bqu().dPi() != null && byVar.bqu().dPi().bIC() != null && byVar.bqu().dPi().bIC().size() > 0) {
                            i = byVar.bqu().nmn ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cJH().a(com.baidu.tieba.frs.d.d.jcS, byVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.cJH().a(com.baidu.tieba.frs.d.d.jcS, byVar, 1);
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
        com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
        vVar.setFrom("frs");
        vVar.setFromCDN(this.alo);
        if (this.jcO == 502) {
            vVar.setNeedFrsTabName(false);
        } else {
            vVar.setNeedFrsTabName(true);
        }
        aVar.c(vVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.iyt);
        a2.setSourceForPb(3);
        com.baidu.card.am<by> amVar = new com.baidu.card.am<>(a2);
        amVar.setPageId(this.mPageId);
        amVar.aO(false);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.v.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof com.baidu.card.am)) {
                    com.baidu.card.am amVar2 = (com.baidu.card.am) view.getTag();
                    by byVar = ((bx) qVar).eCR;
                    byVar.objType = 1;
                    if (v.this.hbu != null) {
                        v.this.hbu.a(amVar2.getView(), byVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), 3, false);
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
        com.baidu.tieba.frs.j.a(amVar.tZ().tT(), this.iSt);
        if (this.iSt != null && this.iSt.getForum() != null && !StringUtils.isNull(this.iSt.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iSt.getForum().getTopic_special_icon_right())) {
            bxVar.eCR.dL(this.iSt.getForum().getTopic_special_icon(), this.iSt.getForum().getTopic_special_icon_right());
        }
        amVar.b((com.baidu.card.am<by>) bxVar.eCR);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.hbu);
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
        this.jcO = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return jcS;
    }
}
