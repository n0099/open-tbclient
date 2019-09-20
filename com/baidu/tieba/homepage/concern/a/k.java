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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> VB;
    private String WM;
    private boolean Yd;
    private NEGFeedBackView.a cTD;
    public BdUniqueId cyA;
    private TbPageContext<?> mPageContext;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cTD = null;
        this.Yd = true;
        this.VB = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.acC() != null && !StringUtils.isNull(kVar.acC().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        an anVar = new an("c12352");
                        anVar.P("obj_locate", 2);
                        anVar.P("obj_type", 5);
                        anVar.bT("tid", kVar.threadData.getTid());
                        anVar.n("fid", kVar.threadData.getFid());
                        anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.thread_card_voice) {
                        an anVar2 = new an("c12352");
                        anVar2.P("obj_locate", 2);
                        anVar2.P("obj_type", 5);
                        anVar2.bT("tid", kVar.threadData.getTid());
                        anVar2.n("fid", kVar.threadData.getFid());
                        anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.user_avatar) {
                        an anVar3 = new an("c12352");
                        anVar3.P("obj_locate", 1);
                        anVar3.P("obj_type", 5);
                        anVar3.bT("tid", kVar.threadData.getTid());
                        anVar3.n("fid", kVar.threadData.getFid());
                        anVar3.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                        TiebaStatic.log(anVar3);
                    } else if (id == R.id.user_name) {
                        an anVar4 = new an("c12352");
                        anVar4.P("obj_locate", 1);
                        anVar4.P("obj_type", 5);
                        anVar4.bT("tid", kVar.threadData.getTid());
                        anVar4.n("fid", kVar.threadData.getFid());
                        anVar4.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                        TiebaStatic.log(anVar4);
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar5 = new an("c13423");
                        anVar5.P("obj_locate", 4);
                        if (kVar != null) {
                            anVar5.bT("tid", kVar.tid);
                            if (kVar.threadData != null && kVar.threadData.aga() != null) {
                                anVar5.bT(Info.kBaiduPIDKey, kVar.threadData.aga().getId());
                            }
                        }
                        TiebaStatic.log(anVar5);
                    } else if (id == R.id.god_reply_content) {
                        an anVar6 = new an("c13423");
                        anVar6.P("obj_locate", 2);
                        if (kVar != null) {
                            anVar6.bT("tid", kVar.tid);
                            if (kVar.threadData != null && kVar.threadData.aga() != null) {
                                anVar6.bT(Info.kBaiduPIDKey, kVar.threadData.aga().getId());
                            }
                        }
                        TiebaStatic.log(anVar6);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar7 = new an("c13423");
                        anVar7.P("obj_locate", 1);
                        if (kVar != null) {
                            anVar7.bT("tid", kVar.tid);
                            if (kVar.threadData != null && kVar.threadData.aga() != null) {
                                anVar7.bT(Info.kBaiduPIDKey, kVar.threadData.aga().getId());
                            }
                        }
                        TiebaStatic.log(anVar7);
                    } else if (id == R.id.god_reply_agree_view) {
                        an anVar8 = new an("c13423");
                        anVar8.P("obj_locate", 5);
                        if (kVar != null) {
                            anVar8.bT("tid", kVar.tid);
                            if (kVar.threadData != null && kVar.threadData.aga() != null) {
                                anVar8.bT(Info.kBaiduPIDKey, kVar.threadData.aga().getId());
                            }
                        }
                        TiebaStatic.log(anVar8);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar9 = new an("c13423");
                            anVar9.P("obj_locate", 3);
                            if (kVar != null) {
                                anVar9.bT("tid", kVar.tid);
                                if (kVar.threadData != null && kVar.threadData.aga() != null) {
                                    anVar9.bT(Info.kBaiduPIDKey, kVar.threadData.aga().getId());
                                }
                            }
                            TiebaStatic.log(anVar9);
                            return;
                        }
                        an anVar10 = new an("c12352");
                        anVar10.P("obj_locate", 2);
                        anVar10.P("obj_type", 5);
                        anVar10.bT("tid", kVar.threadData.getTid());
                        anVar10.n("fid", kVar.threadData.getFid());
                        anVar10.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                        TiebaStatic.log(anVar10);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public z<com.baidu.tieba.card.data.k> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cyA);
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
        hVar.setFromCDN(this.Yd);
        hVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bFY = 1;
        dVar2.bGd = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(9);
        aaVar.setShareReportFrom(3);
        aaVar.bw(1);
        aVar.a(aaVar);
        x qP = aVar.qP();
        qP.bq(1);
        z<com.baidu.tieba.card.data.k> zVar = new z<>(qP);
        zVar.setPageId(this.cyA);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.homepage.concern.a.k.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (k.this.VB != null) {
                        k.this.VB.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false);
                    zVar2.qQ().b(new a.C0038a(1));
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
        kVar.pN(kVar.position + 1);
        t.bat().c(kVar.wd("c12351"));
        zVar.qQ().setPage(this.WM);
        zVar.a(kVar);
        zVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qQ().a(this.VB);
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }
}
