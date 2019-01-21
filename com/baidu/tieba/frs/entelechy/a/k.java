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
    private ad<bb> cbm;
    private int dTF;
    private com.baidu.tieba.frs.e.b dTG;
    private Set<String> dTW;
    private boolean dTX;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dTX = false;
        this.dTF = 3;
        this.dTG = new com.baidu.tieba.frs.e.b();
        this.cbm = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_header || view.getId() == e.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.c.aHW().a(k.this.dTG, bbVar, 2);
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, k.this.mPageId, k.this.dTG);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_root || view.getId() == e.g.layout_root) {
                        if (bbVar.Av() == 2 && bbVar.zA() != null) {
                            String yt = bbVar.zA().yt();
                            if (StringUtils.isNull(yt)) {
                                yt = bbVar.zA().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bbVar.getFid()), bbVar.zZ(), bbVar.zA().getThreadId(), "tieba.baidu.com/p/" + bbVar.zA().getThreadId(), yt);
                            String taskId = bbVar.zA().getTaskId();
                            am amVar = new am("c13329");
                            amVar.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
                            amVar.aB(VideoPlayActivityConfig.OBJ_ID, taskId);
                            TiebaStatic.log(amVar);
                        }
                        com.baidu.tieba.frs.e.c.aHW().a(k.this.dTG, bbVar, 1);
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, k.this.mPageId, k.this.dTG);
                    } else if (view.getId() == e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, k.this.mPageId, k.this.dTG);
                    }
                }
            }
        };
        this.dTW = new HashSet();
        this.dTX = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f aFx = gVar.aFx();
        if (aFx != null) {
            aFx.j(this.mPageId);
            aFx.b(this.cbm);
        }
        com.baidu.tieba.frs.entelechy.view.h aFy = gVar.aFy();
        if (aFy != null) {
            aFy.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.AM() ? "3" : "2";
        zVar.dbs = this.dTG.eeM;
        zVar.bjn = bbVar.getTid();
        zVar.mSource = bbVar.mRecomSource;
        zVar.gIJ = bbVar.avA;
        zVar.gIK = bbVar.mRecomWeight;
        zVar.gIM = bbVar.mRecomAbTag;
        if (bbVar.Al() != null) {
            zVar.gIN = bbVar.Al().video_md5;
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f aFD;
        com.baidu.tieba.frs.entelechy.view.g aFE = bVar.aFE();
        if (aFE == null || bVar == null) {
            return null;
        }
        if (this.dTG != null) {
            int i2 = 0;
            if (this.dLd != null) {
                i2 = this.dLd.aHA();
            }
            bbVar.awk = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHW().a(this.dTG, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dTG);
        ba zA = bbVar.zA();
        if (zA != null) {
            String taskId = zA.getTaskId();
            String yt = zA.yt();
            if (StringUtils.isNull(yt)) {
                yt = zA.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof com.baidu.tieba.frs.am) {
                com.baidu.tieba.frs.am amVar = (com.baidu.tieba.frs.am) this.mPageContext.getOrignalPage();
                if (this.dTW.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", amVar.getForumId(), amVar.getForumName(), zA.getThreadId(), "tieba.baidu.com/p/" + bbVar.getTid(), yt);
                }
            }
            am amVar2 = new am("c13324");
            amVar2.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
            amVar2.aB("tid", bbVar.getTid());
            amVar2.aB(VideoPlayActivityConfig.OBJ_ID, taskId);
            amVar2.y("thread_type", bbVar.getThreadType());
            TiebaStatic.log(amVar2);
        }
        if (bbVar != null) {
            bbVar.AQ();
            int i3 = bbVar.Al() != null ? 2 : 1;
            aFE.show(i3);
            if (i3 == 2) {
                a aFF = bVar.aFF();
                if (aFF == null) {
                    return null;
                }
                if (aFF.arr() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) aFF.arr();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(X(bbVar));
                    hVar.a(bbVar);
                    hVar.b(this.cbm);
                    return aFF.getView();
                }
            }
            if (i3 == 1) {
                com.baidu.tieba.frs.entelechy.d.a aFG = bVar.aFG();
                if (aFG != null && (aFD = aFG.aFD()) != null) {
                    aFD.setFromCDN(this.mIsFromCDN);
                    aFD.a(bbVar);
                    aFD.hi(this.dTX);
                    return aFG.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.dTW.clear();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dTF = i;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aFf() {
        return this.dTG;
    }
}
