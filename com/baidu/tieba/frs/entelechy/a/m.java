package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class m extends com.baidu.tieba.frs.k<bv, am<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aht;
    private NEGFeedBackView.a gAR;
    private com.baidu.tieba.card.aa<bw> gAn;
    private int iyR;
    private boolean izn;
    private String mFrom;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.izn = false;
        this.iyR = 3;
        this.gAn = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (m.this.ioA != null) {
                        m.this.ioA.a(view, (View) bwVar, (Object) m.this.getType());
                    }
                    if ("c13010".equals(m.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").aj("obj_type", 1).u("fid", bwVar.getFid()).dK("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, m.this.mPageId, com.baidu.tieba.frs.d.d.iyS, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, m.this.mPageId, com.baidu.tieba.frs.d.d.iyS, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, m.this.mPageId, com.baidu.tieba.frs.d.d.iyS, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, m.this.mPageId, com.baidu.tieba.frs.d.d.iyS, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, m.this.mPageId, com.baidu.tieba.frs.d.d.iyS, m.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (m.this.gAn.aiI instanceof Boolean) {
                            if (((Boolean) m.this.gAn.aiI).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bwVar, 1, m.this.mPageId, com.baidu.tieba.frs.d.d.iyS, m.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bwVar, 3, m.this.mPageId, com.baidu.tieba.frs.d.d.iyS, m.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, m.this.mPageId, com.baidu.tieba.frs.d.d.iyS, m.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, m.this.mPageId, com.baidu.tieba.frs.d.d.iyS, m.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.bgN()) {
                        m.this.aq(bwVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(com.baidu.tieba.frs.d.d.iyS, bwVar.bfH());
                    } else if (view instanceof TbImageView) {
                        if (m.this.gAn.aiI instanceof Boolean) {
                            if (((Boolean) m.this.gAn.aiI).booleanValue()) {
                                com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bwVar.bjK() != null && bwVar.bjK().dEr() != null && bwVar.bjK().dEr().bBq() != null && bwVar.bjK().dEr().bBq().size() > 0) {
                            i = bwVar.bjK().mEN ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, 1);
                    }
                }
            }
        };
        this.gAR = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.m.4
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                TiebaStatic.log(new aq("c11973").dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).dK("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar) {
                if (arrayList != null && arVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new aq("c11974").dK("obj_locate", sb.toString()).dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).dK("nid", arVar.getNid()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("source", arVar.source).dK("weight", arVar.weight).dK("ab_tag", arVar.abTag).dK("extra", arVar.extra).aj(IntentConfig.CARD_TYPE, arVar.cardType).aj("obj_floor", arVar.ens));
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
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ela = this.izn ? 10 : 2;
        cVar.elg = 2;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(2);
        anVar.setStType("frs_page");
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(3);
        anVar.bo(16);
        aVar.b(anVar);
        com.baidu.card.ak a2 = aVar.a(true, viewGroup, this.hUo);
        a2.setSourceForPb(3);
        am<bw> amVar = new am<>(a2);
        amVar.setPageId(this.mPageId);
        amVar.aM(true);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.m.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = ((bv) qVar).eji;
                    bwVar.objType = 1;
                    if (m.this.gAn != null) {
                        m.this.gAn.a(amVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), m.this.iyR, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, bv bvVar, am amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) amVar);
        if (bvVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tW().setPage(this.aht);
        amVar.tW().setPosition(i);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.iou);
        if (this.iou != null && this.iou.getForum() != null && !StringUtils.isNull(this.iou.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iou.getForum().getTopic_special_icon_right())) {
            bvVar.eji.dz(this.iou.getForum().getTopic_special_icon(), this.iou.getForum().getTopic_special_icon_right());
        }
        amVar.a(false, Align.ALIGN_RIGHT_BOTTOM, this.gAR);
        if (bvVar.eji.bjw()) {
            amVar.tW().tQ().bo(32);
        }
        if (amVar.tW().tQ() instanceof an) {
            ((an) amVar.tW().tQ()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.m.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                    }
                }
            });
        }
        amVar.b((am) bvVar.eji);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gAn);
        bvVar.eji.bjt();
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
        this.iyR = i;
    }

    @Override // com.baidu.tieba.card.z
    public void nZ(boolean z) {
        this.izn = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return iyS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dK("tid", bwVar.getId()).aj("obj_locate", csq() ? 2 : 1).u("obj_id", bwVar.biB() == null ? -1L : bwVar.biB().live_id).aj("obj_type", 1));
    }
}
