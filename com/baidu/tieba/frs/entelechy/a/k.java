package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.play.z;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.frs.entelechy.d.b> implements ab, com.baidu.tieba.frs.e.c {
    private ad<bb> cax;
    private int dQh;
    private com.baidu.tieba.frs.e.a dQi;
    private Set<String> dQy;
    private boolean dQz;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dQz = false;
        this.dQh = 3;
        this.dQi = new com.baidu.tieba.frs.e.a();
        this.cax = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_header || view.getId() == e.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.b.aGK().a(k.this.dQi, bbVar, 2);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_root || view.getId() == e.g.layout_root) {
                        if (bbVar.Ai() == 2 && bbVar.zn() != null) {
                            String yg = bbVar.zn().yg();
                            if (StringUtils.isNull(yg)) {
                                yg = bbVar.zn().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bbVar.getFid()), bbVar.zM(), bbVar.zn().getThreadId(), "tieba.baidu.com/p/" + bbVar.zn().getThreadId(), yg);
                            String taskId = bbVar.zn().getTaskId();
                            am amVar = new am("c13329");
                            amVar.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
                            amVar.aA(VideoPlayActivityConfig.OBJ_ID, taskId);
                            TiebaStatic.log(amVar);
                        }
                        com.baidu.tieba.frs.e.b.aGK().a(k.this.dQi, bbVar, 1);
                    }
                }
            }
        };
        this.dQy = new HashSet();
        this.dQz = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f aEl = gVar.aEl();
        if (aEl != null) {
            aEl.j(this.mPageId);
            aEl.b(this.cax);
        }
        com.baidu.tieba.frs.entelechy.view.h aEm = gVar.aEm();
        if (aEm != null) {
            aEm.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.Az() ? "3" : "2";
        zVar.cXO = this.dQi.ebo;
        zVar.biw = bbVar.getTid();
        zVar.mSource = bbVar.mRecomSource;
        zVar.gEN = bbVar.auX;
        zVar.gEO = bbVar.mRecomWeight;
        zVar.gEQ = bbVar.mRecomAbTag;
        if (bbVar.zY() != null) {
            zVar.gER = bbVar.zY().video_md5;
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f aEr;
        com.baidu.tieba.frs.entelechy.view.g aEs = bVar.aEs();
        if (aEs == null || bVar == null) {
            return null;
        }
        com.baidu.tieba.frs.e.b.aGK().a(this.dQi, bbVar);
        ba zn = bbVar.zn();
        if (zn != null) {
            String taskId = zn.getTaskId();
            String yg = zn.yg();
            if (StringUtils.isNull(yg)) {
                yg = zn.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.frs.am) {
                com.baidu.tieba.frs.am amVar = (com.baidu.tieba.frs.am) this.mPageContext.getOrignalPage();
                if (this.dQy.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", amVar.getForumId(), amVar.getForumName(), zn.getThreadId(), "tieba.baidu.com/p/" + bbVar.getTid(), yg);
                }
            }
            am amVar2 = new am("c13324");
            amVar2.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
            amVar2.aA("tid", bbVar.getTid());
            amVar2.aA(VideoPlayActivityConfig.OBJ_ID, taskId);
            TiebaStatic.log(amVar2);
        }
        if (bbVar != null) {
            bbVar.AD();
            int i2 = bbVar.zY() != null ? 2 : 1;
            aEs.show(i2);
            if (i2 == 2) {
                a aEt = bVar.aEt();
                if (aEt == null) {
                    return null;
                }
                if (aEt.aqe() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) aEt.aqe();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(X(bbVar));
                    hVar.a(bbVar);
                    hVar.b(this.cax);
                    return aEt.getView();
                }
            }
            if (i2 == 1) {
                com.baidu.tieba.frs.entelechy.d.a aEu = bVar.aEu();
                if (aEu != null && (aEr = aEu.aEr()) != null) {
                    aEr.setFromCDN(this.mIsFromCDN);
                    aEr.a(bbVar);
                    aEr.hc(this.dQz);
                    return aEu.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.dQy.clear();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void iJ(int i) {
        this.dQh = i;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aDT() {
        return this.dQi;
    }
}
