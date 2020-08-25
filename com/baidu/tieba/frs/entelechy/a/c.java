package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.b;
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
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.frs.k<bw, com.baidu.card.al<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String agH;
    private boolean ajr;
    private boolean eue;
    private com.baidu.tieba.card.aa<bw> giJ;
    private NEGFeedBackView.a gjn;
    private HashSet<String> icJ;
    private int icK;
    private com.baidu.tieba.frs.d.b icL;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.eue = false;
        this.ajr = true;
        this.icK = 3;
        this.icL = new com.baidu.tieba.frs.d.b();
        this.giJ = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if ("c13010".equals(c.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 3).u("fid", bwVar.getFid()).dD("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, c.this.mPageId, c.this.icL, c.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, c.this.mPageId, c.this.icL, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, c.this.mPageId, c.this.icL, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, c.this.mPageId, c.this.icL, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, c.this.mPageId, c.this.icL, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, c.this.mPageId, c.this.icL, c.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, c.this.mPageId, c.this.icL, c.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.csu().a(c.this.icL, bwVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.csu().a(c.this.icL, bwVar, 1);
                    } else {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        aq aqVar = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        aqVar.dD("obj_type", "1");
                        aqVar.dD("tid", bwVar.getTid());
                        TiebaStatic.log(aqVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        aq aqVar2 = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        aqVar2.dD("obj_type", "3");
                        aqVar2.dD("tid", bwVar.getTid());
                        TiebaStatic.log(aqVar2);
                    }
                }
            }
        };
        this.gjn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                TiebaStatic.log(new aq("c11973").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new aq("c11974").dD("obj_locate", sb.toString()).dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("nid", arVar.getNid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("source", arVar.source).dD("weight", arVar.weight).dD("ab_tag", arVar.abTag).dD("extra", arVar.extra).ai(IntentConfig.CARD_TYPE, arVar.cardType).ai("obj_floor", arVar.dZb));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.al<bw> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bk(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.3
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
        com.baidu.card.ae aeVar = new com.baidu.card.ae(this.mPageContext);
        aeVar.b((Boolean) false);
        aeVar.setFrom("frs");
        if (this.icK == 502) {
            aeVar.setNeedFrsTabName(false);
        } else {
            aeVar.setNeedFrsTabName(true);
        }
        aeVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        aVar.tP().br(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(aeVar);
        com.baidu.card.ae aeVar2 = new com.baidu.card.ae(this.mPageContext);
        aeVar2.b((Boolean) true);
        aeVar2.setFrom("frs");
        if (this.icK == 502) {
            aeVar2.setNeedFrsTabName(false);
        } else {
            aeVar2.setNeedFrsTabName(true);
        }
        aeVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39));
        aeVar2.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && absThreadDataSupport.bce().edE != null) {
                    ay.a(absThreadDataSupport.bce().edE, c.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.h) aeVar2);
        an anVar = new an(this.mPageContext.getPageActivity());
        anVar.b((Boolean) true);
        anVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.5
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && absThreadDataSupport.bce().edE != null) {
                    ay.a(absThreadDataSupport.bce().edE, c.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.h) anVar);
        com.baidu.card.m mVar = new com.baidu.card.m(this.mPageContext.getPageActivity());
        mVar.setFromCDN(this.ajr);
        mVar.setForm("frs");
        aVar.a((com.baidu.card.h) mVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 2;
        cVar.dWQ = 2;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(3);
        amVar.bk(16);
        aVar.b(amVar);
        aVar.tP().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.aj a = aVar.a(true, viewGroup, this.hyl);
        a.setSourceForPb(3);
        com.baidu.card.al<bw> alVar = new com.baidu.card.al<>(a);
        alVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.c.6
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof com.baidu.card.al)) {
                    com.baidu.card.al alVar2 = (com.baidu.card.al) view.getTag();
                    bw bwVar = (bw) qVar;
                    bwVar.objType = 1;
                    if (c.this.giJ != null) {
                        c.this.giJ.a(alVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), c.this.icK, false);
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        alVar.tS();
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, com.baidu.card.al<bw> alVar) {
        if (bwVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        if (alVar.tR() instanceof com.baidu.tieba.a.e) {
            alVar.tR().setPage(this.agH);
        }
        alVar.tR().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) alVar);
        com.baidu.tieba.frs.j.a(alVar.tR().tL(), this.hSn);
        if (this.hSn != null && this.hSn.getForum() != null && !StringUtils.isNull(this.hSn.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hSn.getForum().getTopic_special_icon_right())) {
            bwVar.du(this.hSn.getForum().getTopic_special_icon(), this.hSn.getForum().getTopic_special_icon_right());
        }
        boolean z = (bwVar.beE() == null || bwVar.beE().getUserId() == null || !bwVar.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bwVar.bfT() && bwVar.getFeedBackReasonMap() != null && !z) {
            alVar.aL(true).a(this.gjn);
        }
        alVar.tT();
        if (bwVar.bfT() && alVar.tR().tL() != null) {
            alVar.tR().tL().bk(32);
        }
        alVar.b((com.baidu.card.al<bw>) bwVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.giJ);
        if (this.icL != null) {
            bwVar.dZb = (bwVar.position + 1) - (this.hSn != null ? this.hSn.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.csu().a(this.icL, bwVar);
        an(bwVar);
        bwVar.bfQ();
        com.baidu.tieba.frs.d.a.a(bwVar, this.mPageId, this.icL, getTbPageTag());
        if (bwVar != null) {
            bwVar.bfQ();
        }
        return alVar.getView();
    }

    private void an(bw bwVar) {
        if (this.icJ == null) {
            this.icJ = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.csu().a(bwVar, this.icJ);
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icK = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.icL;
    }
}
