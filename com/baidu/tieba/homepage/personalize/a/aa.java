package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.ap;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class aa extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l> afF;
    private String ahu;
    private com.baidu.adp.widget.ListView.v alD;
    private NEGFeedBackView.a fPf;
    public BdUniqueId fsQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fPf = null;
        this.afF = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.cor().lN(true);
                com.baidu.tieba.a.d.bIR().dM("page_recommend", "show_");
                if (view != null && lVar != null && lVar.bjZ() != null && !StringUtils.isNull(lVar.bjZ().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(lVar.Ji("c12642"));
                        com.baidu.tieba.a.d.bIR().a("page_recommend", "clk_", lVar.coQ());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(lVar.coU());
                        com.baidu.tieba.a.d.bIR().a("page_recommend", "clk_", lVar.coU());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(lVar.coS());
                        com.baidu.tieba.a.d.bIR().a("page_recommend", "clk_", lVar.coS());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(lVar.coS());
                        com.baidu.tieba.a.d.bIR().a("page_recommend", "clk_", lVar.coS());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(lVar.coR());
                        com.baidu.tieba.a.d.bIR().a("page_recommend", "clk_", lVar.coR());
                    } else if (id == R.id.god_reply_voice_btn) {
                        aq aqVar = new aq("c10760");
                        aqVar.al("obj_locate", 4);
                        TiebaStatic.log(aqVar);
                    } else if (id == R.id.god_reply_content) {
                        aq aqVar2 = new aq("c10760");
                        aqVar2.al("obj_locate", 2);
                        TiebaStatic.log(aqVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        aq aqVar3 = new aq("c10760");
                        aqVar3.al("obj_locate", 1);
                        TiebaStatic.log(aqVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            aq aqVar4 = new aq("c10760");
                            aqVar4.al("obj_locate", 3);
                            TiebaStatic.log(aqVar4);
                        }
                        TiebaStatic.log(lVar.coT());
                        com.baidu.tieba.a.d.bIR().a("page_recommend", "clk_", lVar.coT());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(lVar.exA, aa.this.fsQ, lVar.coD(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cIV();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fsQ);
        eVar.bp(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.aa.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds15));
        afVar.setFrom("index");
        aVar.c(afVar);
        com.baidu.card.af afVar2 = new com.baidu.card.af(this.mPageContext);
        afVar2.b((Boolean) true);
        afVar2.setFrom("index");
        afVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds27), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds31));
        afVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.aa.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && absThreadDataSupport.bjZ().eGn != null) {
                    ay.a(absThreadDataSupport.bjZ().eGn, aa.this.mContext, 2);
                }
            }
        });
        aVar.a((com.baidu.card.i) afVar2);
        as asVar = new as(this.mPageContext.getPageActivity());
        asVar.b((Boolean) true);
        asVar.setFrom("index");
        asVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.aa.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && absThreadDataSupport.bjZ().eGn != null) {
                    ay.a(absThreadDataSupport.bjZ().eGn, aa.this.mContext, 3);
                }
            }
        });
        asVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.homepage.personalize.a.aa.5
            @Override // com.baidu.card.view.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                boolean z = true;
                if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && absThreadDataSupport.bjZ().eGn != null) {
                    if (absThreadDataSupport.bjZ().eGn.videoInfo == null) {
                        z = false;
                    } else if (absThreadDataSupport.bjZ().eGn.videoInfo.is_vertical.intValue() != 1) {
                        z = false;
                    }
                    if (z) {
                        aa.this.f(absThreadDataSupport.bjZ().eGn);
                    } else {
                        aa.this.ap(absThreadDataSupport.bjZ());
                    }
                }
            }
        });
        aVar.a((com.baidu.card.i) asVar);
        aVar.a((com.baidu.card.i) new ap(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ezt = 1;
        cVar.ezz = 1;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(1);
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        aVar.b(anVar);
        aVar.tU().setBackgroundResource(R.drawable.addresslist_item_bg);
        ak a2 = aVar.a(true, viewGroup, this.alD);
        a2.setSourceForPb(2);
        am<com.baidu.tieba.card.data.l> amVar = new am<>(a2);
        amVar.setPageId(this.fsQ);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.aa.6
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (aa.this.afF != null) {
                        aa.this.afF.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false);
                    amVar2.tW().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, am<com.baidu.tieba.card.data.l> amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.exA == null) {
            return null;
        }
        lVar.xj(lVar.position + 1);
        amVar.tW().setPosition(i);
        com.baidu.tieba.card.t.cor().e(lVar.Jh("c12641"));
        com.baidu.tieba.a.d.bIR().a("page_recommend", "show_", lVar.coP());
        amVar.tW().setPage(this.ahu);
        amVar.aL(true).a(this.fPf);
        amVar.a(lVar.bkl(), this.juz);
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afF);
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.exA, this.fsQ, lVar.coD());
        return amVar.getView();
    }

    private void cIV() {
        com.baidu.tieba.card.data.l.ibf = "c10705";
        com.baidu.tieba.card.data.l.ibg = "c10730";
        com.baidu.tieba.card.data.l.ibh = "c10731";
        com.baidu.tieba.card.data.l.ibi = "c10704";
        com.baidu.tieba.card.data.l.ibj = "c10755";
        com.baidu.tieba.card.data.l.ibk = "c10710";
        com.baidu.tieba.card.data.l.ibl = "c10736";
        com.baidu.tieba.card.data.l.ibm = "c10737";
        com.baidu.tieba.card.data.l.ibn = "c10711";
        com.baidu.tieba.card.data.l.ibo = "c10758";
        com.baidu.tieba.card.data.l.ibp = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fPf = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bw bwVar) {
        if (bwVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(bwVar);
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, "index", videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.n.bmm(), bwVar.bkc(), videoSerializeVideoThreadInfo);
            if (videoSerializeVideoThreadInfo.mBaijiahaoData != null) {
                videoMiddlePageActivityConfig.setNid(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithOriginThreadData(originalThreadInfo);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", null, "index");
            if (originalThreadInfo.oriUgcInfo != null) {
                videoPlayActivityConfig.setNid(originalThreadInfo.oriUgcInfo.oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }
}
