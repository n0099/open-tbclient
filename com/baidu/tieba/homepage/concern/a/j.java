package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
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
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, al<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> aeT;
    private String agH;
    private boolean ajr;
    private com.baidu.adp.widget.ListView.v akI;
    public BdUniqueId ePv;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajr = true;
        this.aeT = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && lVar != null && lVar.bce() != null && !StringUtils.isNull(lVar.bce().getTid())) {
                    j.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.akI = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.b.a(view, lVar, 2);
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
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            aq aqVar5 = new aq("c13423");
            aqVar5.ai("obj_locate", 3);
            if (lVar != null) {
                aqVar5.dD("tid", lVar.tid);
                if (lVar.dUS != null && lVar.dUS.bgh() != null) {
                    aqVar5.dD("pid", lVar.dUS.bgh().getId());
                }
            }
            TiebaStatic.log(aqVar5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.m mVar = new com.baidu.card.m(this.mPageContext.getPageActivity());
        mVar.setFromCDN(this.ajr);
        mVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) mVar);
        aj a = aVar.a(false, viewGroup, this.akI);
        a.setSourceForPb(1);
        al alVar = new al(a);
        alVar.setPageId(this.ePv);
        a(new ab() { // from class: com.baidu.tieba.homepage.concern.a.j.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (j.this.aeT != null) {
                        j.this.aeT.a(alVar2.getView(), lVar);
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
        com.baidu.tieba.card.s.cbX().e(new aq("c13424"));
        alVar.tR().setPosition(i);
        if (alVar.tR() instanceof com.baidu.tieba.a.e) {
            alVar.tR().setPage(this.agH);
        }
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
