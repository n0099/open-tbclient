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
    private ab<bd> bES;
    private Set<String> dor;
    private boolean dos;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dos = false;
        this.bES = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_header || view.getId() == d.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 2);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_root || view.getId() == d.g.layout_root) {
                        if (bdVar.vM() == 2 && bdVar.uV() != null) {
                            String tR = bdVar.uV().tR();
                            if (StringUtils.isNull(tR)) {
                                tR = bdVar.uV().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bdVar.getFid()), bdVar.vr(), bdVar.uV().getThreadId(), "tieba.baidu.com/p/" + bdVar.uV().getThreadId(), tR);
                        }
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 1);
                    }
                }
            }
        };
        this.dor = new HashSet();
        this.dos = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f awp = gVar.awp();
        if (awp != null) {
            awp.j(this.mPageId);
            awp.b(this.bES);
        }
        com.baidu.tieba.frs.entelechy.view.h awq = gVar.awq();
        if (awq != null) {
            awq.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private y Q(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bdVar.wc() ? "3" : "2";
        yVar.cBu = dyP.dyF;
        yVar.aVt = bdVar.getTid();
        yVar.mSource = bdVar.mRecomSource;
        yVar.gdb = bdVar.ajv;
        yVar.gdc = bdVar.mRecomWeight;
        yVar.gde = bdVar.mRecomAbTag;
        if (bdVar.vD() != null) {
            yVar.gdf = bdVar.vD().video_md5;
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f awv;
        com.baidu.tieba.frs.entelechy.view.g aww = bVar.aww();
        if (aww == null || bVar == null) {
            return null;
        }
        com.baidu.tieba.frs.e.b.ayQ().a(dyP, bdVar);
        bb uV = bdVar.uV();
        if (uV != null) {
            String taskId = uV.getTaskId();
            String tR = uV.tR();
            if (StringUtils.isNull(tR)) {
                tR = uV.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof ak) {
                ak akVar = (ak) this.mPageContext.getOrignalPage();
                if (this.dor.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", akVar.getForumId(), akVar.getForumName(), uV.getThreadId(), "tieba.baidu.com/p/" + bdVar.getTid(), tR);
                }
            }
        }
        if (bdVar != null) {
            bdVar.wg();
            int i2 = bdVar.vD() != null ? 2 : 1;
            aww.show(i2);
            if (i2 == 2) {
                a awx = bVar.awx();
                if (awx == null) {
                    return null;
                }
                if (awx.ajG() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) awx.ajG();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(Q(bdVar));
                    hVar.a(bdVar);
                    hVar.b(this.bES);
                    return awx.getView();
                }
            }
            if (i2 == 1) {
                com.baidu.tieba.frs.entelechy.d.a awy = bVar.awy();
                if (awy != null && (awv = awy.awv()) != null) {
                    awv.setFromCDN(this.mIsFromCDN);
                    awv.a(bdVar);
                    awv.fR(this.dos);
                    return awy.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.f
    public void release() {
        super.release();
        this.dor.clear();
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
    }
}
