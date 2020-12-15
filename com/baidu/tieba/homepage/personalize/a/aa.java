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
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class aa extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agG;
    private String aiw;
    private com.baidu.adp.widget.ListView.v amH;
    private NEGFeedBackView.a fWC;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWC = null;
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.csh().mj(true);
                com.baidu.tieba.a.d.bLU().dS("page_recommend", "show_");
                if (view != null && kVar != null && kVar.bmn() != null && !StringUtils.isNull(kVar.bmn().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.Jz("c12642"));
                        com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csA());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.csK());
                        com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csK());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.csI());
                        com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csI());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.csI());
                        com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csI());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.csz());
                        com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csz());
                    } else if (id == R.id.god_reply_voice_btn) {
                        ar arVar = new ar("c10760");
                        arVar.al("obj_locate", 4);
                        TiebaStatic.log(arVar);
                    } else if (id == R.id.god_reply_content) {
                        ar arVar2 = new ar("c10760");
                        arVar2.al("obj_locate", 2);
                        TiebaStatic.log(arVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        ar arVar3 = new ar("c10760");
                        arVar3.al("obj_locate", 1);
                        TiebaStatic.log(arVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            ar arVar4 = new ar("c10760");
                            arVar4.al("obj_locate", 3);
                            TiebaStatic.log(arVar4);
                        }
                        TiebaStatic.log(kVar.csJ());
                        com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csJ());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, aa.this.fzO, kVar.cst(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cNQ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.card.data.k> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fzO);
        eVar.bt(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.aa.2
            @Override // com.baidu.card.e.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.setFrom("index");
        aVar.c(afVar);
        com.baidu.card.af afVar2 = new com.baidu.card.af(this.mPageContext);
        afVar2.b((Boolean) true);
        afVar2.setFrom("index");
        afVar2.e(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        afVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.aa.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bmn() != null && aVar2.bmn().eLH != null) {
                    az.a(aVar2.bmn().eLH, aa.this.mContext, 2);
                }
            }
        });
        aVar.a((com.baidu.card.i) afVar2);
        as asVar = new as(this.mPageContext.getPageActivity());
        asVar.b((Boolean) true);
        asVar.setFrom("index");
        asVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.aa.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bmn() != null && aVar2.bmn().eLH != null) {
                    az.a(aVar2.bmn().eLH, aa.this.mContext, 3);
                }
            }
        });
        asVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.homepage.personalize.a.aa.5
            @Override // com.baidu.card.view.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                boolean z = true;
                if (aVar2 != null && aVar2.bmn() != null && aVar2.bmn().eLH != null) {
                    if (aVar2.bmn().eLH.videoInfo == null) {
                        z = false;
                    } else if (aVar2.bmn().eLH.videoInfo.is_vertical.intValue() != 1) {
                        z = false;
                    }
                    if (z) {
                        aa.this.f(aVar2.bmn().eLH);
                    } else {
                        aa.this.ar(aVar2.bmn());
                    }
                }
            }
        });
        aVar.a((com.baidu.card.i) asVar);
        aVar.a((com.baidu.card.i) new ap(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 1;
        dVar.eEP = 1;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(1);
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        aVar.b(anVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amH);
        a2.setSourceForPb(2);
        am<com.baidu.tieba.card.data.k> amVar = new am<>(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.aa.6
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (aa.this.agG != null) {
                        aa.this.agG.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, am<com.baidu.tieba.card.data.k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.eCR == null) {
            return null;
        }
        kVar.ym(kVar.position + 1);
        amVar.tZ().setPosition(i);
        com.baidu.tieba.card.t.csh().e(kVar.Jy("c12641"));
        com.baidu.tieba.a.d.bLU().a("page_recommend", "show_", kVar.csC());
        amVar.tZ().setPage(this.aiw);
        amVar.aN(true).a(this.fWC);
        amVar.a(kVar.bmx(), this.jII);
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, this.fzO, kVar.cst());
        return amVar.getView();
    }

    private void cNQ() {
        com.baidu.tieba.card.data.k.imW = "c10705";
        com.baidu.tieba.card.data.k.imX = "c10730";
        com.baidu.tieba.card.data.k.imY = "c10731";
        com.baidu.tieba.card.data.k.imZ = "c10704";
        com.baidu.tieba.card.data.k.ina = "c10755";
        com.baidu.tieba.card.data.k.inb = "c10710";
        com.baidu.tieba.card.data.k.inc = "c10736";
        com.baidu.tieba.card.data.k.ind = "c10737";
        com.baidu.tieba.card.data.k.ine = "c10711";
        com.baidu.tieba.card.data.k.inf = "c10758";
        com.baidu.tieba.card.data.k.ing = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fWC = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(by byVar) {
        if (byVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(byVar);
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, "index", videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.n.boB(), byVar.bmq(), videoSerializeVideoThreadInfo);
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
