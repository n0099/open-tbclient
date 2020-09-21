package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.ap;
import com.baidu.card.au;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes21.dex */
public class af extends com.baidu.tieba.frs.k<bw, am<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String ahc;
    private boolean ajR;
    private boolean ewm;
    private com.baidu.tieba.card.aa<bw> glU;
    private NEGFeedBackView.a gmy;
    private HashSet<String> ijT;
    private int ijU;
    private com.baidu.tieba.frs.d.b ijV;
    private boolean iks;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public af(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ewm = false;
        this.ajR = true;
        this.ijV = new com.baidu.tieba.frs.d.b();
        this.glU = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.af.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if ("c13010".equals(af.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 3).u("fid", bwVar.getFid()).dF("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, af.this.mPageId, af.this.ijV, af.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, af.this.mPageId, af.this.ijV, af.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, af.this.mPageId, af.this.ijV, af.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, af.this.mPageId, af.this.ijV, af.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, af.this.mPageId, af.this.ijV, af.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, af.this.mPageId, af.this.ijV, af.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, af.this.mPageId, af.this.ijV, af.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cvK().a(af.this.ijV, bwVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.cvK().a(af.this.ijV, bwVar, 1);
                    } else {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        aq aqVar = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        aqVar.dF("obj_type", "1");
                        aqVar.dF("tid", bwVar.getTid());
                        TiebaStatic.log(aqVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        aq aqVar2 = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        aqVar2.dF("obj_type", "3");
                        aqVar2.dF("tid", bwVar.getTid());
                        TiebaStatic.log(aqVar2);
                    }
                }
            }
        };
        this.gmy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.af.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                TiebaStatic.log(new aq("c11973").dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new aq("c11974").dF("obj_locate", sb.toString()).dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("nid", arVar.getNid()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("source", arVar.source).dF("weight", arVar.weight).dF("ab_tag", arVar.abTag).dF("extra", arVar.extra).ai(IntentConfig.CARD_TYPE, arVar.cardType).ai("obj_floor", arVar.ebp));
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
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bo(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.af.3
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
        com.baidu.card.aq aqVar = new com.baidu.card.aq(this.mPageContext.getPageActivity());
        aVar.c(aqVar);
        aqVar.bD(3);
        if (this.ijU == 502) {
            aqVar.setNeedFrsTabName(false);
        } else {
            aqVar.setNeedFrsTabName(true);
        }
        aVar.a((com.baidu.card.i) new ap(this.mPageContext.getPageActivity()));
        au auVar = new au(this.mPageContext.getPageActivity());
        auVar.setPageContext(this.mPageContext);
        auVar.setFromForPb(3);
        aVar.a((com.baidu.card.i) auVar);
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        agVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds24));
        aVar.a((com.baidu.card.i) agVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        aaVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds24));
        aVar.a((com.baidu.card.i) aaVar);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds24));
        aVar.a((com.baidu.card.i) lVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.ajR);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 2;
        cVar.dZe = 2;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(2);
        anVar.setFromForPb(3);
        anVar.bo(16);
        aVar.b(anVar);
        com.baidu.card.ak tV = aVar.tV();
        tV.setSourceForPb(3);
        am<bw> amVar = new am<>(tV);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.af.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = (bw) qVar;
                    bwVar.objType = 1;
                    if (af.this.glU != null) {
                        af.this.glU.a(amVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 3, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        amVar.tX();
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, am<bw> amVar) {
        if (bwVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahc);
        }
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) amVar);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.hZt);
        if (this.hZt != null && this.hZt.getForum() != null && !StringUtils.isNull(this.hZt.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hZt.getForum().getTopic_special_icon_right())) {
            bwVar.du(this.hZt.getForum().getTopic_special_icon(), this.hZt.getForum().getTopic_special_icon_right());
        }
        boolean z = (bwVar.bfy() == null || bwVar.bfy().getUserId() == null || !bwVar.bfy().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bwVar.bgN() && bwVar.getFeedBackReasonMap() != null && !z) {
            amVar.aL(true).a(this.gmy);
        }
        amVar.tY();
        amVar.b((am<bw>) bwVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.glU);
        if (this.ijV != null) {
            bwVar.ebp = (i + 1) - (this.hZt != null ? this.hZt.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cvK().a(this.ijV, bwVar);
        ao(bwVar);
        bwVar.bgK();
        com.baidu.tieba.frs.d.a.a(bwVar, this.mPageId, this.ijV, getTbPageTag());
        if (bwVar != null) {
            bwVar.bgK();
        }
        return amVar.getView();
    }

    private void ao(bw bwVar) {
        if (this.ijT == null) {
            this.ijT = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.cvK().a(bwVar, this.ijT);
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
        this.ijU = i;
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.ijV;
    }

    public void oU(boolean z) {
        this.iks = z;
    }
}
