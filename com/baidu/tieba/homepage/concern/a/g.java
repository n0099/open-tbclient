package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.s;
import com.baidu.appsearchlib.Info;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Vj;
    private String Wt;
    private boolean XJ;
    private r YE;
    public BdUniqueId cwh;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.XJ = true;
        this.Vj = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.abv() != null && !StringUtils.isNull(kVar.abv().getTid())) {
                    g.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(r rVar) {
        this.YE = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, false);
        } else if (id == R.id.god_reply_voice_btn) {
            am amVar = new am("c13423");
            amVar.P("obj_locate", 4);
            if (kVar != null) {
                amVar.bT("tid", kVar.tid);
                if (kVar.threadData != null && kVar.threadData.aeT() != null) {
                    amVar.bT(Info.kBaiduPIDKey, kVar.threadData.aeT().getId());
                }
            }
            TiebaStatic.log(amVar);
        } else if (id == R.id.god_reply_content) {
            am amVar2 = new am("c13423");
            amVar2.P("obj_locate", 2);
            if (kVar != null) {
                amVar2.bT("tid", kVar.tid);
                if (kVar.threadData != null && kVar.threadData.aeT() != null) {
                    amVar2.bT(Info.kBaiduPIDKey, kVar.threadData.aeT().getId());
                }
            }
            TiebaStatic.log(amVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            am amVar3 = new am("c13423");
            amVar3.P("obj_locate", 1);
            if (kVar != null) {
                amVar3.bT("tid", kVar.tid);
                if (kVar.threadData != null && kVar.threadData.aeT() != null) {
                    amVar3.bT(Info.kBaiduPIDKey, kVar.threadData.aeT().getId());
                }
            }
            TiebaStatic.log(amVar3);
        } else if (id == R.id.god_reply_agree_view) {
            am amVar4 = new am("c13423");
            amVar4.P("obj_locate", 5);
            if (kVar != null) {
                amVar4.bT("tid", kVar.tid);
                if (kVar.threadData != null && kVar.threadData.aeT() != null) {
                    amVar4.bT(Info.kBaiduPIDKey, kVar.threadData.aeT().getId());
                }
            }
            TiebaStatic.log(amVar4);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            am amVar5 = new am("c13423");
            amVar5.P("obj_locate", 3);
            if (kVar != null) {
                amVar5.bT("tid", kVar.tid);
                if (kVar.threadData != null && kVar.threadData.aeT() != null) {
                    amVar5.bT(Info.kBaiduPIDKey, kVar.threadData.aeT().getId());
                }
            }
            TiebaStatic.log(amVar5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.XJ);
        hVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.f) hVar);
        aVar.qq().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.YE);
        a.bq(1);
        z zVar = new z(a);
        zVar.setPageId(this.cwh);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.homepage.concern.a.g.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (g.this.Vj != null) {
                        g.this.Vj.a(zVar2.getView(), kVar);
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
        t.aXM().b(new am("c13424"));
        zVar.qs().setPosition(i);
        if (zVar.qs() instanceof com.baidu.tieba.a.e) {
            zVar.qs().setPage(this.Wt);
        }
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
