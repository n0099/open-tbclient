package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.card.al;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class w extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ag<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adt;
    private String aeX;
    private com.baidu.adp.widget.ListView.t aib;
    private NEGFeedBackView.a eJK;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eJK = null;
        this.adt = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.bLs().jv(true);
                com.baidu.tieba.a.d.bmb().de("page_recommend", "show_");
                if (view != null && kVar != null && kVar.aOi() != null && !StringUtils.isNull(kVar.aOi().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.Dw("c12642"));
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLO());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bLS());
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLS());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.bLQ());
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLQ());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.bLQ());
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLQ());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.bLP());
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLP());
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c10760");
                        anVar.ag("obj_locate", 4);
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c10760");
                        anVar2.ag("obj_locate", 2);
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar3 = new an("c10760");
                        anVar3.ag("obj_locate", 1);
                        TiebaStatic.log(anVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar4 = new an("c10760");
                            anVar4.ag("obj_locate", 3);
                            TiebaStatic.log(anVar4);
                        }
                        TiebaStatic.log(kVar.bLR());
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLR());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dEA, w.this.epM, kVar.bLB(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cgp();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.aY(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.w.2
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
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext);
        aaVar.b((Boolean) false);
        aaVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds27));
        aaVar.setFrom("index");
        aVar.c(aaVar);
        com.baidu.card.aa aaVar2 = new com.baidu.card.aa(this.mPageContext);
        aaVar2.b((Boolean) true);
        aaVar2.setFrom("index");
        aaVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds29), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
        aaVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.w.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    au.a(absThreadDataSupport.aOi().dHm, w.this.mContext, 2);
                }
            }
        });
        aVar.a((com.baidu.card.h) aaVar2);
        al alVar = new al(this.mPageContext.getPageActivity());
        alVar.b((Boolean) true);
        alVar.setFrom("index");
        alVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.w.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    au.a(absThreadDataSupport.aOi().dHm, w.this.mContext, 3);
                }
            }
        });
        alVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.homepage.personalize.a.w.5
            @Override // com.baidu.card.view.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                boolean z = true;
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    if (absThreadDataSupport.aOi().dHm.videoInfo == null) {
                        z = false;
                    } else if (absThreadDataSupport.aOi().dHm.videoInfo.is_vertical.intValue() != 1) {
                        z = false;
                    }
                    if (z) {
                        w.this.f(absThreadDataSupport.aOi().dHm);
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                        w.this.ar(absThreadDataSupport.aOi());
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                        w.this.g(absThreadDataSupport);
                    } else {
                        w.this.ar(absThreadDataSupport.aOi());
                    }
                }
            }
        });
        aVar.a((com.baidu.card.h) alVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        ah ahVar = new ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 1;
        cVar.dBf = 1;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(1);
        ahVar.setShareReportFrom(3);
        ahVar.bm(2);
        aVar.b(ahVar);
        aVar.rK().setBackgroundResource(R.drawable.addresslist_item_bg);
        ae a = aVar.a(true, viewGroup, this.aib);
        a.setSourceForPb(2);
        ag<com.baidu.tieba.card.data.k> agVar = new ag<>(a);
        agVar.setPageId(this.epM);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.homepage.personalize.a.w.6
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) oVar;
                    kVar.objType = 1;
                    if (w.this.adt != null) {
                        w.this.adt.a(agVar2.getView(), kVar);
                    }
                    au.a((AbsThreadDataSupport) kVar, view.getContext(), 2, false);
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ag<com.baidu.tieba.card.data.k> agVar) {
        if (kVar == null || agVar == null || agVar.getView() == null || kVar.dEA == null) {
            return null;
        }
        kVar.st(kVar.position + 1);
        agVar.rM().setPosition(i);
        com.baidu.tieba.card.s.bLs().e(kVar.Dv("c12641"));
        com.baidu.tieba.a.d.bmb().a("page_recommend", "show_", kVar.bLN());
        agVar.rM().setPage(this.aeX);
        agVar.aH(true).a(this.eJK);
        agVar.a(kVar.aOs(), this.hWZ);
        agVar.b((ag<com.baidu.tieba.card.data.k>) kVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dEA, this.epM, kVar.bLB());
        return agVar.getView();
    }

    private void cgp() {
        com.baidu.tieba.card.data.k.gHm = "c10705";
        com.baidu.tieba.card.data.k.gHn = "c10730";
        com.baidu.tieba.card.data.k.gHo = "c10731";
        com.baidu.tieba.card.data.k.gHp = "c10704";
        com.baidu.tieba.card.data.k.gHq = "c10755";
        com.baidu.tieba.card.data.k.gHr = "c10710";
        com.baidu.tieba.card.data.k.gHs = "c10736";
        com.baidu.tieba.card.data.k.gHt = "c10737";
        com.baidu.tieba.card.data.k.gHu = "c10711";
        com.baidu.tieba.card.data.k.gHv = "c10758";
        com.baidu.tieba.card.data.k.gHw = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eJK = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(AbsThreadDataSupport absThreadDataSupport) {
        au.a(absThreadDataSupport.aOi().dHm, this.mContext, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(bk bkVar) {
        if (bkVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(bkVar);
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, "index", videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.m.aQj(), bkVar.aOl(), videoSerializeVideoThreadInfo);
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
