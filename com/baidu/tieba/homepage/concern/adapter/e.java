package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.ao;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> afK;
    private String ahw;
    private com.baidu.adp.widget.ListView.v alH;
    public BdUniqueId fsa;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afK = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.bjd() != null && !StringUtils.isNull(kVar.bjd().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 2);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 1);
                    } else if (id == R.id.god_reply_voice_btn) {
                        ar arVar = new ar("c13423");
                        arVar.ak("obj_locate", 4);
                        if (kVar != null) {
                            arVar.dR("tid", kVar.tid);
                            if (kVar.evQ != null && kVar.evQ.bnh() != null) {
                                arVar.dR("pid", kVar.evQ.bnh().getId());
                            }
                        }
                        TiebaStatic.log(arVar);
                    } else if (id == R.id.god_reply_content) {
                        ar arVar2 = new ar("c13423");
                        arVar2.ak("obj_locate", 2);
                        if (kVar != null) {
                            arVar2.dR("tid", kVar.tid);
                            if (kVar.evQ != null && kVar.evQ.bnh() != null) {
                                arVar2.dR("pid", kVar.evQ.bnh().getId());
                            }
                        }
                        TiebaStatic.log(arVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        ar arVar3 = new ar("c13423");
                        arVar3.ak("obj_locate", 1);
                        if (kVar != null) {
                            arVar3.dR("tid", kVar.tid);
                            if (kVar.evQ != null && kVar.evQ.bnh() != null) {
                                arVar3.dR("pid", kVar.evQ.bnh().getId());
                            }
                        }
                        TiebaStatic.log(arVar3);
                    } else if (id == R.id.god_reply_agree_view) {
                        ar arVar4 = new ar("c13423");
                        arVar4.ak("obj_locate", 5);
                        if (kVar != null) {
                            arVar4.dR("tid", kVar.tid);
                            if (kVar.evQ != null && kVar.evQ.bnh() != null) {
                                arVar4.dR("pid", kVar.evQ.bnh().getId());
                            }
                        }
                        TiebaStatic.log(arVar4);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 7);
                    } else if (id == R.id.thread_card_title || id == R.id.thread_card_abstract) {
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 2);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            ar arVar5 = new ar("c13423");
                            arVar5.ak("obj_locate", 3);
                            if (kVar != null) {
                                arVar5.dR("tid", kVar.tid);
                                if (kVar.evQ != null && kVar.evQ.bnh() != null) {
                                    arVar5.dR("pid", kVar.evQ.bnh().getId());
                                }
                            }
                            TiebaStatic.log(arVar5);
                            return;
                        }
                        com.baidu.tieba.homepage.concern.c.a(view, kVar, 6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.card.data.k> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fsa);
        eVar.bo(128);
        eVar.bp(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.concern.adapter.e.2
            @Override // com.baidu.card.e.a
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
        aVar.a(eVar);
        af afVar = new af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        aVar.tV().bv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        aVar.c(afVar);
        final af afVar2 = new af(this.mPageContext);
        afVar2.b((Boolean) true);
        afVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
        afVar2.e(com.baidu.tbadk.a.b.a.bhB(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.a.bhB(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        afVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.adapter.e.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bjd() != null && aVar2.bjd().eEF != null) {
                    az.a(aVar2.bjd().eEF, e.this.mContext, 1);
                    com.baidu.tieba.homepage.concern.c.a(afVar2.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.i) afVar2);
        final ao aoVar = new ao(this.mPageContext.getPageActivity());
        aoVar.b((Boolean) true);
        aoVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.adapter.e.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bjd() != null && aVar2.bjd().eEF != null) {
                    az.a(aVar2.bjd().eEF, e.this.mContext, 1);
                    com.baidu.tieba.homepage.concern.c.a(aoVar.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.i) aoVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exI = 9;
        dVar.exO = 9;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(9);
        anVar.setShareReportFrom(4);
        anVar.setFromForPb(1);
        anVar.bo(32);
        aVar.b(anVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.alH);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.k> amVar = new am<>(a2);
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.e.5
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (e.this.afK != null) {
                        e.this.afK.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, am<com.baidu.tieba.card.data.k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.evQ == null) {
            return null;
        }
        kVar.xH(kVar.position + 1);
        amVar.tW().setPosition(i);
        com.baidu.tieba.card.t.cnT().e(kVar.IF("c12351"));
        amVar.tW().setPage(this.ahw);
        amVar.a(true, Align.ALIGN_RIGHT_TOP);
        amVar.tZ();
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afK);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alH = vVar;
    }
}
