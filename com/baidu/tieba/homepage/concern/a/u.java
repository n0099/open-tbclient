package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.am;
import com.baidu.card.ao;
import com.baidu.card.ap;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, al<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> aeT;
    private String agH;
    private boolean ajr;
    public BdUniqueId ePv;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajr = true;
        this.aeT = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && lVar != null && lVar.bce() != null && !StringUtils.isNull(lVar.bce().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 2);
                    } else if (id == R.id.thread_card_voice) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 6);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 1);
                    } else if (id == R.id.god_reply_voice_btn) {
                        aq aqVar = new aq("c13423");
                        aqVar.ai("obj_locate", 4);
                        if (lVar != null) {
                            aqVar.dD("tid", lVar.tid);
                            if (lVar.dUS != null && lVar.dUS.bgh() != null) {
                                aqVar.dD("pid", lVar.dUS.bgh().getId());
                            }
                        }
                        TiebaStatic.log(aqVar);
                    } else if (id == R.id.god_reply_content) {
                        aq aqVar2 = new aq("c13423");
                        aqVar2.ai("obj_locate", 2);
                        if (lVar != null) {
                            aqVar2.dD("tid", lVar.tid);
                            if (lVar.dUS != null && lVar.dUS.bgh() != null) {
                                aqVar2.dD("pid", lVar.dUS.bgh().getId());
                            }
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        aq aqVar3 = new aq("c13423");
                        aqVar3.ai("obj_locate", 1);
                        if (lVar != null) {
                            aqVar3.dD("tid", lVar.tid);
                            if (lVar.dUS != null && lVar.dUS.bgh() != null) {
                                aqVar3.dD("pid", lVar.dUS.bgh().getId());
                            }
                        }
                        TiebaStatic.log(aqVar3);
                    } else if (id == R.id.god_reply_agree_view) {
                        aq aqVar4 = new aq("c13423");
                        aqVar4.ai("obj_locate", 5);
                        if (lVar != null) {
                            aqVar4.dD("tid", lVar.tid);
                            if (lVar.dUS != null && lVar.dUS.bgh() != null) {
                                aqVar4.dD("pid", lVar.dUS.bgh().getId());
                            }
                        }
                        TiebaStatic.log(aqVar4);
                    } else if (view.getId() == R.id.forum_name_text) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 7);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            aq aqVar5 = new aq("c13423");
                            aqVar5.ai("obj_locate", 3);
                            if (lVar != null) {
                                aqVar5.dD("tid", lVar.tid);
                                if (lVar.dUS != null && lVar.dUS.bgh() != null) {
                                    aqVar5.dD("pid", lVar.dUS.bgh().getId());
                                }
                            }
                            TiebaStatic.log(aqVar5);
                            return;
                        }
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ePv);
        eVar.bk(128);
        eVar.bl(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.concern.a.u.2
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
        ap apVar = new ap(this.mPageContext.getPageActivity());
        aVar.c(apVar);
        apVar.bz(2);
        aVar.a((com.baidu.card.h) new ao(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        com.baidu.card.m mVar = new com.baidu.card.m(this.mPageContext.getPageActivity());
        mVar.setFromCDN(this.ajr);
        mVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) mVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 9;
        cVar.dWQ = 9;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(9);
        amVar.setShareReportFrom(4);
        amVar.setFromForPb(1);
        aVar.b(amVar);
        aj tQ = aVar.tQ();
        tQ.setSourceForPb(1);
        al<com.baidu.tieba.card.data.l> alVar = new al<>(tQ);
        alVar.setPageId(this.ePv);
        a(new ab() { // from class: com.baidu.tieba.homepage.concern.a.u.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (u.this.aeT != null) {
                        u.this.aeT.a(alVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 1, false);
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, al<com.baidu.tieba.card.data.l> alVar) {
        if (lVar == null || alVar == null || alVar.getView() == null || lVar.dUS == null) {
            return null;
        }
        lVar.vy(lVar.position + 1);
        com.baidu.tieba.card.s.cbX().e(lVar.He("c12351"));
        alVar.tR().setPage(this.agH);
        alVar.a(true, Align.ALIGN_RIGHT_TOP);
        alVar.b((al<com.baidu.tieba.card.data.l>) lVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.aeT);
        return alVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }
}
