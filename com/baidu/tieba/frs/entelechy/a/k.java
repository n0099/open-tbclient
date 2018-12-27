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
public class k extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.frs.entelechy.d.b> implements ab, com.baidu.tieba.frs.e.d {
    private ad<bb> caA;
    private int dSY;
    private com.baidu.tieba.frs.e.b dSZ;
    private Set<String> dTp;
    private boolean dTq;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dTq = false;
        this.dSY = 3;
        this.dSZ = new com.baidu.tieba.frs.e.b();
        this.caA = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_header || view.getId() == e.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.c.aHz().a(k.this.dSZ, bbVar, 2);
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, k.this.mPageId, k.this.dSZ);
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
                        com.baidu.tieba.frs.e.c.aHz().a(k.this.dSZ, bbVar, 1);
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, k.this.mPageId, k.this.dSZ);
                    } else if (view.getId() == e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, k.this.mPageId, k.this.dSZ);
                    }
                }
            }
        };
        this.dTp = new HashSet();
        this.dTq = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f aFa = gVar.aFa();
        if (aFa != null) {
            aFa.j(this.mPageId);
            aFa.b(this.caA);
        }
        com.baidu.tieba.frs.entelechy.view.h aFb = gVar.aFb();
        if (aFb != null) {
            aFb.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.Az() ? "3" : "2";
        zVar.daG = this.dSZ.eef;
        zVar.biz = bbVar.getTid();
        zVar.mSource = bbVar.mRecomSource;
        zVar.gHE = bbVar.auX;
        zVar.gHF = bbVar.mRecomWeight;
        zVar.gHH = bbVar.mRecomAbTag;
        if (bbVar.zY() != null) {
            zVar.gHI = bbVar.zY().video_md5;
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f aFg;
        com.baidu.tieba.frs.entelechy.view.g aFh = bVar.aFh();
        if (aFh == null || bVar == null) {
            return null;
        }
        if (this.dSZ != null) {
            int i2 = 0;
            if (this.dKt != null) {
                i2 = this.dKt.aHd();
            }
            bbVar.avH = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHz().a(this.dSZ, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dSZ);
        ba zn = bbVar.zn();
        if (zn != null) {
            String taskId = zn.getTaskId();
            String yg = zn.yg();
            if (StringUtils.isNull(yg)) {
                yg = zn.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.frs.am) {
                com.baidu.tieba.frs.am amVar = (com.baidu.tieba.frs.am) this.mPageContext.getOrignalPage();
                if (this.dTp.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", amVar.getForumId(), amVar.getForumName(), zn.getThreadId(), "tieba.baidu.com/p/" + bbVar.getTid(), yg);
                }
            }
            am amVar2 = new am("c13324");
            amVar2.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
            amVar2.aA("tid", bbVar.getTid());
            amVar2.aA(VideoPlayActivityConfig.OBJ_ID, taskId);
            amVar2.x("thread_type", bbVar.getThreadType());
            TiebaStatic.log(amVar2);
        }
        if (bbVar != null) {
            bbVar.AD();
            int i3 = bbVar.zY() != null ? 2 : 1;
            aFh.show(i3);
            if (i3 == 2) {
                a aFi = bVar.aFi();
                if (aFi == null) {
                    return null;
                }
                if (aFi.aqT() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) aFi.aqT();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(X(bbVar));
                    hVar.a(bbVar);
                    hVar.b(this.caA);
                    return aFi.getView();
                }
            }
            if (i3 == 1) {
                com.baidu.tieba.frs.entelechy.d.a aFj = bVar.aFj();
                if (aFj != null && (aFg = aFj.aFg()) != null) {
                    aFg.setFromCDN(this.mIsFromCDN);
                    aFg.a(bbVar);
                    aFg.hf(this.dTq);
                    return aFj.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.dTp.clear();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dSY = i;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aEI() {
        return this.dSZ;
    }
}
