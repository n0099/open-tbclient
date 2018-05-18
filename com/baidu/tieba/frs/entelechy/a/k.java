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
    private ab<bd> bwP;
    private Set<String> dfc;
    private boolean dfd;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dfd = false;
        this.bwP = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, bd bdVar) {
                if (view2 != null && bdVar != null) {
                    if (view2.getId() == d.g.card_home_page_normal_thread_user_header || view2.getId() == d.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 2);
                    } else if (view2.getId() == d.g.card_home_page_normal_thread_root || view2.getId() == d.g.layout_root) {
                        if (bdVar.sp() == 2 && bdVar.rz() != null) {
                            String qv = bdVar.rz().qv();
                            if (StringUtils.isNull(qv)) {
                                qv = bdVar.rz().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bdVar.getFid()), bdVar.rU(), bdVar.rz().getThreadId(), "tieba.baidu.com/p/" + bdVar.rz().getThreadId(), qv);
                        }
                        com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 1);
                    }
                }
            }
        };
        this.dfc = new HashSet();
        this.dfd = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f ask = gVar.ask();
        if (ask != null) {
            ask.j(this.mPageId);
            ask.b(this.bwP);
        }
        com.baidu.tieba.frs.entelechy.view.h asl = gVar.asl();
        if (asl != null) {
            asl.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private y Q(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bdVar.sF() ? "3" : "2";
        yVar.csP = dpD.dpt;
        yVar.aNv = bdVar.getTid();
        yVar.mSource = bdVar.mRecomSource;
        yVar.fRP = bdVar.abr;
        yVar.fRQ = bdVar.mRecomWeight;
        yVar.fRS = bdVar.mRecomAbTag;
        if (bdVar.sg() != null) {
            yVar.fRT = bdVar.sg().video_md5;
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f asp;
        com.baidu.tieba.frs.entelechy.view.g asq = bVar.asq();
        if (asq == null || bVar == null) {
            return null;
        }
        com.baidu.tieba.frs.e.b.auG().a(dpD, bdVar);
        bb rz = bdVar.rz();
        if (rz != null) {
            String taskId = rz.getTaskId();
            String qv = rz.qv();
            if (StringUtils.isNull(qv)) {
                qv = rz.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof ak) {
                ak akVar = (ak) this.mPageContext.getOrignalPage();
                if (this.dfc.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", akVar.getForumId(), akVar.getForumName(), rz.getThreadId(), "tieba.baidu.com/p/" + bdVar.getTid(), qv);
                }
            }
        }
        if (bdVar != null) {
            bdVar.sJ();
            int i2 = bdVar.sg() != null ? 2 : 1;
            asq.show(i2);
            if (i2 == 2) {
                a asr = bVar.asr();
                if (asr == null) {
                    return null;
                }
                if (asr.afY() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) asr.afY();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(Q(bdVar));
                    hVar.a(bdVar);
                    hVar.b(this.bwP);
                    return asr.getView();
                }
            }
            if (i2 == 1) {
                com.baidu.tieba.frs.entelechy.d.a ass = bVar.ass();
                if (ass != null && (asp = ass.asp()) != null) {
                    asp.setFromCDN(this.mIsFromCDN);
                    asp.a(bdVar);
                    asp.fM(this.dfd);
                    return ass.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.f
    public void release() {
        super.release();
        this.dfc.clear();
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
    }
}
