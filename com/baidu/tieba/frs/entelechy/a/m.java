package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class m extends com.baidu.tieba.frs.j<bu, com.baidu.card.ak<bv>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String afx;
    private com.baidu.tieba.card.aa<bv> fWK;
    private NEGFeedBackView.a fXo;
    private int hOF;
    private boolean hPb;
    private String mFrom;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hPb = false;
        this.hOF = 3;
        this.fWK = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if (m.this.hFd != null) {
                        m.this.hFd.a(view, (View) bvVar, (Object) m.this.getType());
                    }
                    if ("c13010".equals(m.this.mFrom)) {
                        TiebaStatic.log(new ap("c13010").ah("obj_type", 1).t("fid", bvVar.getFid()).dn("tid", bvVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 2, m.this.mPageId, com.baidu.tieba.frs.d.d.hOG, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 5, m.this.mPageId, com.baidu.tieba.frs.d.d.hOG, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 14, m.this.mPageId, com.baidu.tieba.frs.d.d.hOG, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 12, m.this.mPageId, com.baidu.tieba.frs.d.d.hOG, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 13, m.this.mPageId, com.baidu.tieba.frs.d.d.hOG, m.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (m.this.fWK.agK instanceof Boolean) {
                            if (((Boolean) m.this.fWK.agK).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bvVar, 1, m.this.mPageId, com.baidu.tieba.frs.d.d.hOG, m.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bvVar, 3, m.this.mPageId, com.baidu.tieba.frs.d.d.hOG, m.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 15, m.this.mPageId, com.baidu.tieba.frs.d.d.hOG, m.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar, 1, m.this.mPageId, com.baidu.tieba.frs.d.d.hOG, m.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bvVar.aUR()) {
                        m.this.ap(bvVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOG, bvVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.hOG, bvVar.aTO());
                    } else if (view instanceof TbImageView) {
                        if (m.this.fWK.agK instanceof Boolean) {
                            if (((Boolean) m.this.fWK.agK).booleanValue()) {
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
        this.fXo = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.m.4
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aq aqVar) {
                TiebaStatic.log(new ap("c11973").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
                if (arrayList != null && aqVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ap("c11974").dn("obj_locate", sb.toString()).dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("nid", aqVar.getNid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("source", aqVar.source).dn("weight", aqVar.weight).dn("ab_tag", aqVar.abTag).dn("extra", aqVar.extra).ah(IntentConfig.CARD_TYPE, aqVar.cardType).ah("obj_floor", aqVar.dPI));
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
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.al alVar = new com.baidu.card.al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = this.hPb ? 10 : 2;
        cVar.dNH = 2;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(2);
        alVar.setStType("frs_page");
        alVar.setShareReportFrom(1);
        alVar.setFromForPb(3);
        alVar.bf(16);
        aVar.b(alVar);
        com.baidu.card.ai a = aVar.a(true, viewGroup, this.hlu);
        a.setSourceForPb(3);
        com.baidu.card.ak<bv> akVar = new com.baidu.card.ak<>(a);
        akVar.setPageId(this.mPageId);
        akVar.aL(true);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.m.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bu) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar2 = (com.baidu.card.ak) view.getTag();
                    bv bvVar = ((bu) qVar).dLK;
                    bvVar.objType = 1;
                    if (m.this.fWK != null) {
                        m.this.fWK.a(akVar2.getView(), bvVar);
                    }
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), m.this.hOF, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, bu buVar, com.baidu.card.ak akVar) {
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
        akVar.a(false, Align.ALIGN_RIGHT_BOTTOM, this.fXo);
        if (buVar.dLK.aXA()) {
            akVar.sg().sa().bf(32);
        }
        if (akVar.sg().sa() instanceof com.baidu.card.al) {
            ((com.baidu.card.al) akVar.sg().sa()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.m.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                    }
                }
            });
        }
        akVar.b((com.baidu.card.ak) buVar.dLK);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.fWK);
        buVar.dLK.aXx();
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
        this.hPb = z;
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
