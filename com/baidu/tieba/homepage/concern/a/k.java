package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.s;
import com.baidu.appsearchlib.Info;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Vj;
    private String Wt;
    private boolean XJ;
    private NEGFeedBackView.a cRg;
    public BdUniqueId cwh;
    private TbPageContext<?> mPageContext;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cRg = null;
        this.XJ = true;
        this.Vj = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.abv() != null && !StringUtils.isNull(kVar.abv().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        am amVar = new am("c12352");
                        amVar.P("obj_locate", 2);
                        amVar.P("obj_type", 5);
                        amVar.bT("tid", kVar.threadData.getTid());
                        amVar.l("fid", kVar.threadData.getFid());
                        amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                        TiebaStatic.log(amVar);
                    } else if (id == R.id.thread_card_voice) {
                        am amVar2 = new am("c12352");
                        amVar2.P("obj_locate", 2);
                        amVar2.P("obj_type", 5);
                        amVar2.bT("tid", kVar.threadData.getTid());
                        amVar2.l("fid", kVar.threadData.getFid());
                        amVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                        TiebaStatic.log(amVar2);
                    } else if (id == R.id.user_avatar) {
                        am amVar3 = new am("c12352");
                        amVar3.P("obj_locate", 1);
                        amVar3.P("obj_type", 5);
                        amVar3.bT("tid", kVar.threadData.getTid());
                        amVar3.l("fid", kVar.threadData.getFid());
                        amVar3.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                        TiebaStatic.log(amVar3);
                    } else if (id == R.id.user_name) {
                        am amVar4 = new am("c12352");
                        amVar4.P("obj_locate", 1);
                        amVar4.P("obj_type", 5);
                        amVar4.bT("tid", kVar.threadData.getTid());
                        amVar4.l("fid", kVar.threadData.getFid());
                        amVar4.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                        TiebaStatic.log(amVar4);
                    } else if (id == R.id.god_reply_voice_btn) {
                        am amVar5 = new am("c13423");
                        amVar5.P("obj_locate", 4);
                        if (kVar != null) {
                            amVar5.bT("tid", kVar.tid);
                            if (kVar.threadData != null && kVar.threadData.aeT() != null) {
                                amVar5.bT(Info.kBaiduPIDKey, kVar.threadData.aeT().getId());
                            }
                        }
                        TiebaStatic.log(amVar5);
                    } else if (id == R.id.god_reply_content) {
                        am amVar6 = new am("c13423");
                        amVar6.P("obj_locate", 2);
                        if (kVar != null) {
                            amVar6.bT("tid", kVar.tid);
                            if (kVar.threadData != null && kVar.threadData.aeT() != null) {
                                amVar6.bT(Info.kBaiduPIDKey, kVar.threadData.aeT().getId());
                            }
                        }
                        TiebaStatic.log(amVar6);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        am amVar7 = new am("c13423");
                        amVar7.P("obj_locate", 1);
                        if (kVar != null) {
                            amVar7.bT("tid", kVar.tid);
                            if (kVar.threadData != null && kVar.threadData.aeT() != null) {
                                amVar7.bT(Info.kBaiduPIDKey, kVar.threadData.aeT().getId());
                            }
                        }
                        TiebaStatic.log(amVar7);
                    } else if (id == R.id.god_reply_agree_view) {
                        am amVar8 = new am("c13423");
                        amVar8.P("obj_locate", 5);
                        if (kVar != null) {
                            amVar8.bT("tid", kVar.tid);
                            if (kVar.threadData != null && kVar.threadData.aeT() != null) {
                                amVar8.bT(Info.kBaiduPIDKey, kVar.threadData.aeT().getId());
                            }
                        }
                        TiebaStatic.log(amVar8);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            am amVar9 = new am("c13423");
                            amVar9.P("obj_locate", 3);
                            if (kVar != null) {
                                amVar9.bT("tid", kVar.tid);
                                if (kVar.threadData != null && kVar.threadData.aeT() != null) {
                                    amVar9.bT(Info.kBaiduPIDKey, kVar.threadData.aeT().getId());
                                }
                            }
                            TiebaStatic.log(amVar9);
                            return;
                        }
                        am amVar10 = new am("c12352");
                        amVar10.P("obj_locate", 2);
                        amVar10.P("obj_type", 5);
                        amVar10.bT("tid", kVar.threadData.getTid());
                        amVar10.l("fid", kVar.threadData.getFid());
                        amVar10.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                        TiebaStatic.log(amVar10);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z<com.baidu.tieba.card.data.k> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cwh);
        dVar.bm(128);
        dVar.bn(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.concern.a.k.2
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.c(dVar);
        com.baidu.card.ab abVar = new com.baidu.card.ab(this.mPageContext.getPageActivity());
        aVar.b(abVar);
        abVar.bx(2);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.XJ);
        hVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bEy = 1;
        dVar2.bED = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(9);
        aaVar.setShareReportFrom(3);
        aaVar.bw(1);
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        x qr = aVar.qr();
        qr.bq(1);
        z<com.baidu.tieba.card.data.k> zVar = new z<>(qr);
        zVar.setPageId(this.cwh);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.homepage.concern.a.k.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (k.this.Vj != null) {
                        k.this.Vj.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false);
                    zVar2.qs().b(new a.C0038a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.threadData == null) {
            return null;
        }
        kVar.ps(kVar.position + 1);
        t.aXP().b(kVar.uZ("c12351"));
        zVar.qs().setPage(this.Wt);
        zVar.a(kVar);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qs().a(this.Vj);
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }
}
