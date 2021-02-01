package com.baidu.tieba.frs.entelechy.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class ad extends com.baidu.tieba.frs.k<ca, AutoVideoCardViewHolder<cb>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aif;
    private com.baidu.tieba.card.ab<cb> hmS;
    private int jqp;
    private com.baidu.tieba.frs.b.b jqq;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jqp = 3;
        this.jqq = new com.baidu.tieba.frs.b.b();
        this.hmS = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.ad.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if (ad.this.jfM != null) {
                        ad.this.jfM.a(view, (View) cbVar, (Object) cb.eQK);
                    }
                    if ("c13010".equals(ad.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ap("obj_type", 2).v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && cbVar.bmv()) {
                        com.baidu.tieba.frs.b.c.cKe().a(ad.this.jqq, cbVar, 1);
                        ad.this.as(cbVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKe().a(ad.this.jqq, cbVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.d.k.a(ad.this.jqq, cbVar.blo());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.b.c.cKe().a(ad.this.jqq, cbVar, 4);
                        ad.this.as(cbVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ad.this.as(cbVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 4, ad.this.mPageId, ad.this.jqq, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 4, ad.this.mPageId, ad.this.jqq, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, ad.this.mPageId, ad.this.jqq, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, ad.this.mPageId, ad.this.jqq, ad.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 15, ad.this.mPageId, ad.this.jqq, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 14, ad.this.mPageId, ad.this.jqq, ad.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, ad.this.mPageId, ad.this.jqq, ad.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity(), true);
        gVar.setFrom("frs");
        gVar.setStageType("2003");
        gVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.frs.entelechy.adapter.ad.2
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bs = az.bs(gVar.getVideoContainer());
                    if (!(aVar2 instanceof cb)) {
                        az.a(aVar2, ad.this.mContext, ad.this.jqp, false, bs);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, ad.this.mContext, ad.this.jqp, false, bs);
                }
            }
        });
        if (this.jqp == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        aVar.c(gVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.iLK);
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(a2);
        autoVideoCardViewHolder.setPageId(this.mPageId);
        a2.a(this.hmS);
        a2.setSourceForPb(this.jqp);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.ad.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = ((ca) nVar).eJQ;
                    cbVar.objType = 1;
                    if (ad.this.hmS != null) {
                        ad.this.hmS.a(threadCardViewHolder.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), ad.this.jqp, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder.tj().b(new a.C0089a(1));
                }
            }
        });
        autoVideoCardViewHolder.aL(false);
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, AutoVideoCardViewHolder<cb> autoVideoCardViewHolder) {
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        if (caVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            autoVideoCardViewHolder.tj().setPage(this.aif);
        }
        super.a(i, view, viewGroup, (ViewGroup) caVar, (ca) autoVideoCardViewHolder);
        com.baidu.tieba.frs.j.a(autoVideoCardViewHolder.tj().td(), this.jfG);
        autoVideoCardViewHolder.setVideoStatsData(al(caVar.eJQ));
        autoVideoCardViewHolder.tj().setPosition(i);
        if (this.jfG != null && this.jfG.getForum() != null && !StringUtils.isNull(this.jfG.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jfG.getForum().getTopic_special_icon_right())) {
            caVar.eJQ.dD(this.jfG.getForum().getTopic_special_icon(), this.jfG.getForum().getTopic_special_icon_right());
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<cb>) caVar.eJQ);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a(this.hmS);
        if (this.jqq != null) {
            int i2 = 0;
            if (this.jfG != null) {
                i2 = this.jfG.getTopThreadSize();
            }
            caVar.eJQ.eOs = (caVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.b.c.cKe().a(this.jqq, caVar.eJQ);
        com.baidu.tieba.frs.b.c.cKe().az(caVar.eJQ);
        com.baidu.tieba.frs.b.c.cKe().a(caVar.eJQ, cCg());
        com.baidu.tieba.frs.b.a.a(caVar.eJQ, this.mPageId, this.jqq, getTbPageTag());
        caVar.eJQ.bpd();
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o al(cb cbVar) {
        if (cbVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = cbVar.bpa() ? "3" : "2";
        if (this.jqq.jHn == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.fNd = this.jqq.jHm;
        oVar.amC = cbVar.getTid();
        oVar.mSource = cbVar.mRecomSource;
        oVar.mIe = cbVar.eSI;
        oVar.mIf = cbVar.mRecomWeight;
        oVar.mIi = cbVar.mRecomAbTag;
        if (cbVar.boh() != null) {
            oVar.mIj = cbVar.boh().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
        this.jqp = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ey(String str) {
        this.aif = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(cb cbVar) {
        TiebaStatic.log(new ar("c12126").dR("tid", cbVar.getId()).ap("obj_locate", cCg() ? 2 : 1).v("obj_id", cbVar.boj() == null ? -1L : cbVar.boj().live_id).ap("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void pD(boolean z) {
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jqq;
    }
}
