package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class aa extends com.baidu.tieba.frs.j<bu, com.baidu.card.ak<bv>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String afx;
    private com.baidu.tieba.card.aa<bv> fWK;
    private int hOF;
    private String mFrom;

    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hOF = 3;
        this.fWK = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if (aa.this.hFd != null) {
                        aa.this.hFd.a(view, (View) bvVar, (Object) aa.this.getType());
                    }
                    if ("c13010".equals(aa.this.mFrom)) {
                        TiebaStatic.log(new ap("c13010").ah("obj_type", 1).t("fid", bvVar.getFid()).dn("tid", bvVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 2, aa.this.mPageId, com.baidu.tieba.frs.d.d.hOG, aa.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (aa.this.fWK.agK instanceof Boolean) {
                            if (((Boolean) aa.this.fWK.agK).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bvVar, 1, aa.this.mPageId, com.baidu.tieba.frs.d.d.hOG, aa.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bvVar, 3, aa.this.mPageId, com.baidu.tieba.frs.d.d.hOG, aa.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 15, aa.this.mPageId, com.baidu.tieba.frs.d.d.hOG, aa.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar, 1, aa.this.mPageId, com.baidu.tieba.frs.d.d.hOG, aa.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bvVar.aUR()) {
                        aa.this.ap(bvVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOG, bvVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.hOG, bvVar.aTO());
                    } else if (view instanceof TbImageView) {
                        if (aa.this.fWK.agK instanceof Boolean) {
                            if (((Boolean) aa.this.fWK.agK).booleanValue()) {
                                com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOG, bvVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOG, bvVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOG, bvVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bvVar.aXO() != null && bvVar.aXO().dlk() != null && bvVar.aXO().dlk().boJ() != null && bvVar.aXO().dlk().boJ().size() > 0) {
                            i = bvVar.aXO().lNJ ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOG, bvVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOG, bvVar, 1);
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
    public com.baidu.card.ak<bv> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), true);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bf(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.aa.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.ai a = aVar.a(false, viewGroup, this.hlu);
        a.setSourceForPb(3);
        com.baidu.card.ak<bv> akVar = new com.baidu.card.ak<>(a);
        akVar.setPageId(this.mPageId);
        akVar.aL(false);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.aa.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bu) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar2 = (com.baidu.card.ak) view.getTag();
                    bv bvVar = ((bu) qVar).dLK;
                    bvVar.objType = 1;
                    if (aa.this.fWK != null) {
                        aa.this.fWK.a(akVar2.getView(), bvVar);
                    }
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), aa.this.hOF, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, com.baidu.card.ak<bv> akVar) {
        super.a(i, view, viewGroup, (ViewGroup) buVar, (bu) akVar);
        if (buVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        akVar.sg().setPage(this.afx);
        akVar.sg().setPosition(i);
        com.baidu.tieba.frs.i.a(akVar.sg().sa(), this.hEX);
        if (this.hEX != null && this.hEX.getForum() != null && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon_right())) {
            buVar.dLK.de(this.hEX.getForum().getTopic_special_icon(), this.hEX.getForum().getTopic_special_icon_right());
        }
        akVar.a(true, Align.ALIGN_RIGHT_TOP, null);
        if (!buVar.dLK.isBjh()) {
            akVar.si();
        }
        akVar.b((com.baidu.card.ak<bv>) buVar.dLK);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.fWK);
        buVar.dLK.aXx();
        if (hOG != null) {
            int i2 = 0;
            if (this.hEX != null) {
                i2 = this.hEX.getTopThreadSize();
            }
            buVar.dLK.dPI = (buVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.chQ().a(hOG, buVar.dLK);
        buVar.dLK.aXx();
        com.baidu.tieba.frs.d.a.a(buVar.dLK, this.mPageId, hOG, getTbPageTag());
        if (buVar != null) {
            buVar.dLK.aXx();
        }
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.hOF = i;
    }

    @Override // com.baidu.tieba.card.z
    public void mJ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hOG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bv bvVar) {
        TiebaStatic.log(new ap("c12126").dn("tid", bvVar.getId()).ah("obj_locate", cbj() ? 2 : 1).t("obj_id", bvVar.aWF() == null ? -1L : bvVar.aWF().live_id).ah("obj_type", 1));
    }
}
