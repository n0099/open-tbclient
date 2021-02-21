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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> agg;
    private String aif;
    private boolean akO;
    private com.baidu.adp.widget.ListView.s amk;
    public BdUniqueId fGZ;
    private TbPageContext<?> mPageContext;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akO = true;
        this.agg = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.bln() != null && !StringUtils.isNull(kVar.bln().getTid())) {
                    m.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amk = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.c.a(view, kVar, 2);
        } else if (id == R.id.god_reply_voice_btn) {
            ar arVar = new ar("c13423");
            arVar.ap("obj_locate", 4);
            if (kVar != null) {
                arVar.dR("tid", kVar.tid);
                if (kVar.eJQ != null && kVar.eJQ.bpv() != null) {
                    arVar.dR("pid", kVar.eJQ.bpv().getId());
                }
            }
            TiebaStatic.log(arVar);
        } else if (id == R.id.god_reply_content) {
            ar arVar2 = new ar("c13423");
            arVar2.ap("obj_locate", 2);
            if (kVar != null) {
                arVar2.dR("tid", kVar.tid);
                if (kVar.eJQ != null && kVar.eJQ.bpv() != null) {
                    arVar2.dR("pid", kVar.eJQ.bpv().getId());
                }
            }
            TiebaStatic.log(arVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ar arVar3 = new ar("c13423");
            arVar3.ap("obj_locate", 1);
            if (kVar != null) {
                arVar3.dR("tid", kVar.tid);
                if (kVar.eJQ != null && kVar.eJQ.bpv() != null) {
                    arVar3.dR("pid", kVar.eJQ.bpv().getId());
                }
            }
            TiebaStatic.log(arVar3);
        } else if (id == R.id.god_reply_agree_view) {
            ar arVar4 = new ar("c13423");
            arVar4.ap("obj_locate", 5);
            if (kVar != null) {
                arVar4.dR("tid", kVar.tid);
                if (kVar.eJQ != null && kVar.eJQ.bpv() != null) {
                    arVar4.dR("pid", kVar.eJQ.bpv().getId());
                }
            }
            TiebaStatic.log(arVar4);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            ar arVar5 = new ar("c13423");
            arVar5.ap("obj_locate", 3);
            if (kVar != null) {
                arVar5.dR("tid", kVar.tid);
                if (kVar.eJQ != null && kVar.eJQ.bpv() != null) {
                    arVar5.dR("pid", kVar.eJQ.bpv().getId());
                }
            }
            TiebaStatic.log(arVar5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akO);
        nVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) nVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.amk);
        a2.setSourceForPb(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.m.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar2;
                    kVar.objType = 1;
                    if (m.this.agg != null) {
                        m.this.agg.a(threadCardViewHolder2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false);
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eJQ == null) {
            return null;
        }
        kVar.xd(kVar.position + 1);
        com.baidu.tieba.card.t.csB().e(new ar("c13424"));
        threadCardViewHolder.tj().setPosition(i);
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }
}
