package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.play.y;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.frs.f<bd, com.baidu.tieba.frs.entelechy.d.b> implements aa, com.baidu.tieba.frs.e.c {
    private ab<bd> bvY;
    private Set<String> ddU;
    private boolean ddV;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ddV = false;
        this.bvY = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, bd bdVar) {
                if (view2 != null && bdVar != null) {
                    if (view2.getId() == d.g.card_home_page_normal_thread_user_header || view2.getId() == d.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.b.auH().a(com.baidu.tieba.frs.e.c.dov, bdVar, 2);
                    } else if (view2.getId() == d.g.card_home_page_normal_thread_root || view2.getId() == d.g.layout_root) {
                        if (bdVar.sq() == 2 && bdVar.rA() != null) {
                            String qw = bdVar.rA().qw();
                            if (StringUtils.isNull(qw)) {
                                qw = bdVar.rA().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bdVar.getFid()), bdVar.rV(), bdVar.rA().getThreadId(), "tieba.baidu.com/p/" + bdVar.rA().getThreadId(), qw);
                        }
                        com.baidu.tieba.frs.e.b.auH().a(com.baidu.tieba.frs.e.c.dov, bdVar, 1);
                    }
                }
            }
        };
        this.ddU = new HashSet();
        this.ddV = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f asl = gVar.asl();
        if (asl != null) {
            asl.j(this.mPageId);
            asl.b(this.bvY);
        }
        com.baidu.tieba.frs.entelechy.view.h asm = gVar.asm();
        if (asm != null) {
            asm.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private y Q(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bdVar.sG() ? "3" : "2";
        yVar.crG = dov.dol;
        yVar.aNu = bdVar.getTid();
        yVar.mSource = bdVar.mRecomSource;
        yVar.fQJ = bdVar.abq;
        yVar.fQK = bdVar.mRecomWeight;
        yVar.fQM = bdVar.mRecomAbTag;
        if (bdVar.sh() != null) {
            yVar.fQN = bdVar.sh().video_md5;
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f asq;
        com.baidu.tieba.frs.entelechy.view.g asr = bVar.asr();
        if (asr == null || bVar == null) {
            return null;
        }
        com.baidu.tieba.frs.e.b.auH().a(dov, bdVar);
        bb rA = bdVar.rA();
        if (rA != null) {
            String taskId = rA.getTaskId();
            String qw = rA.qw();
            if (StringUtils.isNull(qw)) {
                qw = rA.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof ak) {
                ak akVar = (ak) this.mPageContext.getOrignalPage();
                if (this.ddU.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", akVar.getForumId(), akVar.getForumName(), rA.getThreadId(), "tieba.baidu.com/p/" + bdVar.getTid(), qw);
                }
            }
        }
        if (bdVar != null) {
            bdVar.sK();
            int i2 = bdVar.sh() != null ? 2 : 1;
            asr.show(i2);
            if (i2 == 2) {
                a ass = bVar.ass();
                if (ass == null) {
                    return null;
                }
                if (ass.afY() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) ass.afY();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(Q(bdVar));
                    hVar.a(bdVar);
                    hVar.b(this.bvY);
                    return ass.getView();
                }
            }
            if (i2 == 1) {
                com.baidu.tieba.frs.entelechy.d.a ast = bVar.ast();
                if (ast != null && (asq = ast.asq()) != null) {
                    asq.setFromCDN(this.mIsFromCDN);
                    asq.a(bdVar);
                    asq.fL(this.ddV);
                    return ast.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.f
    public void release() {
        super.release();
        this.ddU.clear();
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
    }
}
