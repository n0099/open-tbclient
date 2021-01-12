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
    private aa<com.baidu.tieba.card.data.k> ago;
    private String air;
    private boolean akY;
    private com.baidu.adp.widget.ListView.s amu;
    public BdUniqueId fEN;
    private TbPageContext<?> mPageContext;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akY = true;
        this.ago = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.bkV() != null && !StringUtils.isNull(kVar.bkV().getTid())) {
                    m.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amu = sVar;
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
                aqVar.dW("tid", kVar.tid);
                if (kVar.eHK != null && kVar.eHK.bpd() != null) {
                    aqVar.dW("pid", kVar.eHK.bpd().getId());
                }
            }
            TiebaStatic.log(aqVar);
        } else if (id == R.id.god_reply_content) {
            aq aqVar2 = new aq("c13423");
            aqVar2.an("obj_locate", 2);
            if (kVar != null) {
                aqVar2.dW("tid", kVar.tid);
                if (kVar.eHK != null && kVar.eHK.bpd() != null) {
                    aqVar2.dW("pid", kVar.eHK.bpd().getId());
                }
            }
            TiebaStatic.log(aqVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            aq aqVar3 = new aq("c13423");
            aqVar3.an("obj_locate", 1);
            if (kVar != null) {
                aqVar3.dW("tid", kVar.tid);
                if (kVar.eHK != null && kVar.eHK.bpd() != null) {
                    aqVar3.dW("pid", kVar.eHK.bpd().getId());
                }
            }
            TiebaStatic.log(aqVar3);
        } else if (id == R.id.god_reply_agree_view) {
            aq aqVar4 = new aq("c13423");
            aqVar4.an("obj_locate", 5);
            if (kVar != null) {
                aqVar4.dW("tid", kVar.tid);
                if (kVar.eHK != null && kVar.eHK.bpd() != null) {
                    aqVar4.dW("pid", kVar.eHK.bpd().getId());
                }
            }
            TiebaStatic.log(aqVar4);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            aq aqVar5 = new aq("c13423");
            aqVar5.an("obj_locate", 3);
            if (kVar != null) {
                aqVar5.dW("tid", kVar.tid);
                if (kVar.eHK != null && kVar.eHK.bpd() != null) {
                    aqVar5.dW("pid", kVar.eHK.bpd().getId());
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
        nVar.setFromCDN(this.akY);
        nVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) nVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.amu);
        a2.setSourceForPb(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fEN);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.m.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar2;
                    kVar.objType = 1;
                    if (m.this.ago != null) {
                        m.this.ago.a(threadCardViewHolder2.getView(), kVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false);
                    threadCardViewHolder2.tm().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eHK == null) {
            return null;
        }
        kVar.wT(kVar.position + 1);
        com.baidu.tieba.card.s.crj().e(new aq("c13424"));
        threadCardViewHolder.tm().setPosition(i);
        if (threadCardViewHolder.tm() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tm().setPage(this.air);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tm().a(this.ago);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }
}
