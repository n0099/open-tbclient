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
/* loaded from: classes22.dex */
public class n extends com.baidu.tieba.frs.k<bv, am<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahu;
    private boolean akk;
    private com.baidu.tieba.card.ab<bw> gMb;
    private int iLn;
    private String mFrom;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.akk = true;
        this.iLn = 3;
        this.gMb = new com.baidu.tieba.card.ab<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (n.this.iAW != null) {
                        n.this.iAW.a(view, (View) bwVar, (Object) n.this.getType());
                    }
                    if ("c13010".equals(n.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").aj("obj_type", 1).w("fid", bwVar.getFid()).dR("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, n.this.mPageId, com.baidu.tieba.frs.d.d.iLo, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, n.this.mPageId, com.baidu.tieba.frs.d.d.iLo, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, n.this.mPageId, com.baidu.tieba.frs.d.d.iLo, n.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (n.this.gMb.aiJ instanceof Boolean) {
                            if (((Boolean) n.this.gMb.aiJ).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bwVar, 1, n.this.mPageId, com.baidu.tieba.frs.d.d.iLo, n.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bwVar, 3, n.this.mPageId, com.baidu.tieba.frs.d.d.iLo, n.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, n.this.mPageId, com.baidu.tieba.frs.d.d.iLo, n.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, n.this.mPageId, com.baidu.tieba.frs.d.d.iLo, n.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.biG()) {
                        n.this.aq(bwVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cCo().a(com.baidu.tieba.frs.d.d.iLo, bwVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(com.baidu.tieba.frs.d.d.iLo, bwVar.bhA());
                    } else if (view instanceof TbImageView) {
                        if (n.this.gMb.aiJ instanceof Boolean) {
                            if (((Boolean) n.this.gMb.aiJ).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cCo().a(com.baidu.tieba.frs.d.d.iLo, bwVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cCo().a(com.baidu.tieba.frs.d.d.iLo, bwVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cCo().a(com.baidu.tieba.frs.d.d.iLo, bwVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bwVar.blD() != null && bwVar.blD().dHz() != null && bwVar.blD().dHz().bDj() != null && bwVar.blD().dHz().bDj().size() > 0) {
                            i = bwVar.blD().mRu ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cCo().a(com.baidu.tieba.frs.d.d.iLo, bwVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.cCo().a(com.baidu.tieba.frs.d.d.iLo, bwVar, 1);
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
    /* renamed from: aT */
    public am<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext.getPageActivity());
        zVar.setFrom("frs");
        zVar.setFromCDN(this.akk);
        if (this.iLn == 502) {
            zVar.setNeedFrsTabName(false);
        } else {
            zVar.setNeedFrsTabName(true);
        }
        aVar.c(zVar);
        com.baidu.card.ak a2 = aVar.a(false, viewGroup, this.igO);
        a2.setSourceForPb(3);
        am<bw> amVar = new am<>(a2);
        amVar.setPageId(this.mPageId);
        amVar.aM(false);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.n.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = ((bv) qVar).erH;
                    bwVar.objType = 1;
                    if (n.this.gMb != null) {
                        n.this.gMb.a(amVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), n.this.iLn, false);
                    amVar2.tW().b(new a.C0097a(1));
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
        amVar.tW().setPage(this.ahu);
        amVar.tW().setPosition(i);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.iAQ);
        if (this.iAQ != null && this.iAQ.getForum() != null && !StringUtils.isNull(this.iAQ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iAQ.getForum().getTopic_special_icon_right())) {
            bvVar.erH.dG(this.iAQ.getForum().getTopic_special_icon(), this.iAQ.getForum().getTopic_special_icon_right());
        }
        amVar.b((am<bw>) bvVar.erH);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gMb);
        bvVar.erH.blm();
        return amVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uQ(int i) {
        this.iLn = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return iLo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dR("tid", bwVar.getId()).aj("obj_locate", cvx() ? 2 : 1).w("obj_id", bwVar.bku() == null ? -1L : bwVar.bku().live_id).aj("obj_type", 1));
    }
}
