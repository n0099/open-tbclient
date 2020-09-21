package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class u extends com.baidu.tieba.frs.k<bv, am<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String ahc;
    private boolean ajR;
    private com.baidu.tieba.card.aa<bw> glU;
    private int ijR;
    private String mFrom;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ajR = true;
        this.glU = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (u.this.hZz != null) {
                        u.this.hZz.a(view, (View) bwVar, (Object) u.this.getType());
                    }
                    if ("c13010".equals(u.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 1).u("fid", bwVar.getFid()).dF("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, u.this.mPageId, com.baidu.tieba.frs.d.d.ijV, u.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, u.this.mPageId, com.baidu.tieba.frs.d.d.ijV, u.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, u.this.mPageId, com.baidu.tieba.frs.d.d.ijV, u.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (u.this.glU.aiq instanceof Boolean) {
                            if (((Boolean) u.this.glU.aiq).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bwVar, 1, u.this.mPageId, com.baidu.tieba.frs.d.d.ijV, u.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bwVar, 3, u.this.mPageId, com.baidu.tieba.frs.d.d.ijV, u.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, u.this.mPageId, com.baidu.tieba.frs.d.d.ijV, u.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, u.this.mPageId, com.baidu.tieba.frs.d.d.ijV, u.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(com.baidu.tieba.frs.d.d.ijV, bwVar.bcZ());
                    } else if (view instanceof TbImageView) {
                        if (u.this.glU.aiq instanceof Boolean) {
                            if (((Boolean) u.this.glU.aiq).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bwVar.bhb() != null && bwVar.bhb().dAF() != null && bwVar.bhb().dAF().byG() != null && bwVar.bhb().dAF().byG().size() > 0) {
                            i = bwVar.bhb().mph ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, 1);
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
    public am<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
        vVar.setFrom("frs");
        vVar.setFromCDN(this.ajR);
        if (this.ijR == 502) {
            vVar.setNeedFrsTabName(false);
        } else {
            vVar.setNeedFrsTabName(true);
        }
        aVar.c(vVar);
        com.baidu.card.ak a = aVar.a(false, viewGroup, this.hFt);
        a.setSourceForPb(3);
        am<bw> amVar = new am<>(a);
        amVar.setPageId(this.mPageId);
        amVar.aM(false);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.u.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = ((bv) qVar).dXg;
                    bwVar.objType = 1;
                    if (u.this.glU != null) {
                        u.this.glU.a(amVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 3, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, am<bw> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) amVar);
        if (bvVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tW().setPage(this.ahc);
        amVar.tW().setPosition(i);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.hZt);
        if (this.hZt != null && this.hZt.getForum() != null && !StringUtils.isNull(this.hZt.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hZt.getForum().getTopic_special_icon_right())) {
            bvVar.dXg.du(this.hZt.getForum().getTopic_special_icon(), this.hZt.getForum().getTopic_special_icon_right());
        }
        amVar.b((am<bw>) bvVar.dXg);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.glU);
        bvVar.dXg.bgK();
        return amVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
        this.ijR = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return ijV;
    }
}
