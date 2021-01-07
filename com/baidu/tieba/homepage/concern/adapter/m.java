package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.k> ahf;
    private String aji;
    private boolean alQ;
    private com.baidu.adp.widget.ListView.s anl;
    public BdUniqueId fJu;
    private TbPageContext<?> mPageContext;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alQ = true;
        this.ahf = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.boP() != null && !StringUtils.isNull(kVar.boP().getTid())) {
                    m.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anl = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.c.a(view, kVar, 2);
        } else if (id == R.id.god_reply_voice_btn) {
            aq aqVar = new aq("c13423");
            aqVar.an("obj_locate", 4);
            if (kVar != null) {
                aqVar.dX("tid", kVar.tid);
                if (kVar.eMv != null && kVar.eMv.bsX() != null) {
                    aqVar.dX("pid", kVar.eMv.bsX().getId());
                }
            }
            TiebaStatic.log(aqVar);
        } else if (id == R.id.god_reply_content) {
            aq aqVar2 = new aq("c13423");
            aqVar2.an("obj_locate", 2);
            if (kVar != null) {
                aqVar2.dX("tid", kVar.tid);
                if (kVar.eMv != null && kVar.eMv.bsX() != null) {
                    aqVar2.dX("pid", kVar.eMv.bsX().getId());
                }
            }
            TiebaStatic.log(aqVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            aq aqVar3 = new aq("c13423");
            aqVar3.an("obj_locate", 1);
            if (kVar != null) {
                aqVar3.dX("tid", kVar.tid);
                if (kVar.eMv != null && kVar.eMv.bsX() != null) {
                    aqVar3.dX("pid", kVar.eMv.bsX().getId());
                }
            }
            TiebaStatic.log(aqVar3);
        } else if (id == R.id.god_reply_agree_view) {
            aq aqVar4 = new aq("c13423");
            aqVar4.an("obj_locate", 5);
            if (kVar != null) {
                aqVar4.dX("tid", kVar.tid);
                if (kVar.eMv != null && kVar.eMv.bsX() != null) {
                    aqVar4.dX("pid", kVar.eMv.bsX().getId());
                }
            }
            TiebaStatic.log(aqVar4);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            aq aqVar5 = new aq("c13423");
            aqVar5.an("obj_locate", 3);
            if (kVar != null) {
                aqVar5.dX("tid", kVar.tid);
                if (kVar.eMv != null && kVar.eMv.bsX() != null) {
                    aqVar5.dX("pid", kVar.eMv.bsX().getId());
                }
            }
            TiebaStatic.log(aqVar5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alQ);
        nVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) nVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.anl);
        a2.setSourceForPb(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fJu);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.m.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar2;
                    kVar.objType = 1;
                    if (m.this.ahf != null) {
                        m.this.ahf.a(threadCardViewHolder2.getView(), kVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false);
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eMv == null) {
            return null;
        }
        kVar.yA(kVar.position + 1);
        com.baidu.tieba.card.s.cvb().e(new aq("c13424"));
        threadCardViewHolder.ty().setPosition(i);
        if (threadCardViewHolder.ty() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.ty().setPage(this.aji);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fl(String str) {
        this.aji = str;
    }
}
