package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.am;
import com.baidu.card.at;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes16.dex */
public class v extends com.baidu.tieba.frs.k<bv, com.baidu.card.al<bv>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String agH;
    private boolean ajr;
    private com.baidu.tieba.card.aa<bv> giJ;
    private NEGFeedBackView.a gjn;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hZl;
    private com.baidu.adp.lib.d.b<TbImageView> hZm;
    private int icH;
    private HashSet<String> icJ;
    private com.baidu.tieba.frs.d.b icL;
    private boolean idg;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.idg = false;
        this.ajr = true;
        this.icL = new com.baidu.tieba.frs.d.b();
        this.giJ = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if (v.this.hSt != null) {
                        v.this.hSt.a(view, (View) bvVar, (Object) v.this.getType());
                    }
                    if ("c13010".equals(v.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 1).u("fid", bvVar.dUS.getFid()).dD("tid", bvVar.dUS.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bvVar.dUS, 2, v.this.mPageId, v.this.icL, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar.dUS, 5, v.this.mPageId, v.this.icL, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar.dUS, 14, v.this.mPageId, v.this.icL, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bvVar.dUS, 12, v.this.mPageId, v.this.icL, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bvVar.dUS, 13, v.this.mPageId, v.this.icL, v.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (v.this.giJ.ahT instanceof Boolean) {
                            if (((Boolean) v.this.giJ.ahT).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bvVar.dUS, 1, v.this.mPageId, v.this.icL, v.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bvVar.dUS, 3, v.this.mPageId, v.this.icL, v.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bvVar.dUS, 15, v.this.mPageId, v.this.icL, v.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar.dUS, 1, v.this.mPageId, v.this.icL, v.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.csu().a(v.this.icL, bvVar.dUS, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(v.this.icL, bvVar.bcf());
                    } else if (view instanceof TbImageView) {
                        if (v.this.giJ.ahT instanceof Boolean) {
                            if (((Boolean) v.this.giJ.ahT).booleanValue()) {
                                com.baidu.tieba.frs.d.c.csu().a(v.this.icL, bvVar.dUS, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.csu().a(v.this.icL, bvVar.dUS, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.csu().a(v.this.icL, bvVar.dUS, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.csu().a(v.this.icL, bvVar.dUS, 1);
                    } else {
                        int i = 6;
                        if (bvVar.dUS.bgh() != null && bvVar.dUS.bgh().dwH() != null && bvVar.dUS.bgh().dwH().bxw() != null && bvVar.dUS.bgh().dwH().bxw().size() > 0) {
                            i = bvVar.dUS.bgh().mft ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.csu().a(v.this.icL, bvVar.dUS, i);
                    }
                }
            }
        };
        this.gjn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.v.2
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
        this.hZl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.v.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: coB */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(v.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.hZm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.v.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blb */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(v.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ap.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.al<bv> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bk(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.v.5
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
        final com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
        vVar.setFrom("frs");
        if (this.icH == 502) {
            vVar.setNeedFrsTabName(false);
        } else {
            vVar.setNeedFrsTabName(true);
        }
        vVar.setConstrainLayoutPool(this.hZl);
        vVar.setConstrainImagePool(this.hZm);
        vVar.setFromCDN(this.ajr);
        aVar.c(vVar);
        at atVar = new at(this.mPageContext.getPageActivity());
        atVar.setPageContext(this.mPageContext);
        atVar.setFromForPb(3);
        aVar.a((com.baidu.card.h) atVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ah(this.mPageContext.getPageActivity()));
        com.baidu.card.m mVar = new com.baidu.card.m(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) mVar);
        mVar.setFromCDN(this.ajr);
        mVar.setForm("frs");
        if (!aE(1) || !aE(2)) {
            vVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.v.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    v.this.h(i, i2, i3);
                    if (v.this.aE(1) && v.this.aE(2)) {
                        vVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = this.idg ? 10 : 2;
        cVar.dWQ = 2;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(3);
        amVar.bk(16);
        aVar.b(amVar);
        aVar.tP().br(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.aj tQ = aVar.tQ();
        tQ.setSourceForPb(3);
        com.baidu.card.al<bv> alVar = new com.baidu.card.al<>(tQ);
        alVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.v.7
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof com.baidu.card.al)) {
                    com.baidu.card.al alVar2 = (com.baidu.card.al) view.getTag();
                    bw bwVar = ((bv) qVar).dUS;
                    bwVar.objType = 1;
                    if (v.this.giJ != null) {
                        v.this.giJ.a(alVar2.getView(), (bv) qVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 3, false);
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
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.al<bv> alVar) {
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) alVar);
        if (bvVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        alVar.tR().setPage(this.agH);
        com.baidu.tieba.frs.j.a(alVar.tR().tL(), this.hSn);
        if (this.hSn != null && this.hSn.getForum() != null && !StringUtils.isNull(this.hSn.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hSn.getForum().getTopic_special_icon_right())) {
            bvVar.dUS.du(this.hSn.getForum().getTopic_special_icon(), this.hSn.getForum().getTopic_special_icon_right());
        }
        boolean z = (bvVar.dUS.beE() == null || bvVar.dUS.beE().getUserId() == null || !bvVar.dUS.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bvVar.dUS.bfT() && bvVar.dUS.getFeedBackReasonMap() != null && !z) {
            alVar.aL(true).a(this.gjn);
        }
        alVar.tT();
        if (bvVar.dUS.bfT() && alVar.tR().tL() != null) {
            alVar.tR().tL().bk(32);
        }
        alVar.b((com.baidu.card.al<bv>) bvVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.giJ);
        if (this.icL != null) {
            bvVar.dUS.dZb = (bvVar.position + 1) - (this.hSn != null ? this.hSn.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.csu().a(this.icL, bvVar.dUS);
        an(bvVar.dUS);
        bvVar.dUS.bfQ();
        com.baidu.tieba.frs.d.a.a(bvVar.dUS, this.mPageId, this.icL, getTbPageTag());
        if (bvVar != null) {
            bvVar.dUS.bfQ();
        }
        return alVar.getView();
    }

    private void an(bw bwVar) {
        if (this.icJ == null) {
            this.icJ = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.csu().a(bwVar, this.icJ);
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icH = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nm(boolean z) {
        this.idg = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.icL;
    }
}
