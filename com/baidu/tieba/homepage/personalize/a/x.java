package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
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
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JZ;
    private String LC;
    private com.baidu.adp.widget.ListView.r OT;
    public BdUniqueId dBK;
    private NEGFeedBackView.a dUT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUT = null;
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bvm().id(true);
                com.baidu.tieba.a.d.aXK().cu("page_recommend", "show_");
                if (view != null && kVar != null && kVar.aAj() != null && !StringUtils.isNull(kVar.aAj().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.Ad("c12642"));
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvI());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bvM());
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvM());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.bvK());
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvK());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.bvK());
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvK());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.bvJ());
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvJ());
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c10760");
                        anVar.X("obj_locate", 4);
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c10760");
                        anVar2.X("obj_locate", 2);
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar3 = new an("c10760");
                        anVar3.X("obj_locate", 1);
                        TiebaStatic.log(anVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar4 = new an("c10760");
                            anVar4.X("obj_locate", 3);
                            TiebaStatic.log(anVar4);
                        }
                        TiebaStatic.log(kVar.bvL());
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvL());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRt, x.this.dBK, kVar.bvw(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        bPl();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dBK);
        eVar.aL(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.2
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
        com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext);
        zVar.b((Boolean) false);
        zVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds27));
        zVar.setFrom("index");
        aVar.c(zVar);
        com.baidu.card.z zVar2 = new com.baidu.card.z(this.mPageContext);
        zVar2.b((Boolean) true);
        zVar2.setFrom("index");
        zVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds29), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
        zVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aAj() != null && aVar2.aAj().cUe != null) {
                    au.a(aVar2.aAj().cUe, x.this.mContext, 2);
                }
            }
        });
        aVar.a((com.baidu.card.h) zVar2);
        ak akVar = new ak(this.mPageContext.getPageActivity());
        akVar.b((Boolean) true);
        akVar.setFrom("index");
        akVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aAj() != null && aVar2.aAj().cUe != null) {
                    au.a(aVar2.aAj().cUe, x.this.mContext, 3);
                }
            }
        });
        akVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.5
            @Override // com.baidu.card.view.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                boolean z = true;
                if (aVar2 != null && aVar2.aAj() != null && aVar2.aAj().cUe != null) {
                    if (aVar2.aAj().cUe.videoInfo == null) {
                        z = false;
                    } else if (aVar2.aAj().cUe.videoInfo.is_vertical.intValue() != 1) {
                        z = false;
                    }
                    if (z) {
                        x.this.f(aVar2.aAj().cUe);
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                        x.this.ao(aVar2.aAj());
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                        x.this.d(aVar2);
                    } else {
                        x.this.ao(aVar2.aAj());
                    }
                }
            }
        });
        aVar.a((com.baidu.card.h) akVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 1;
        dVar.cNV = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.aZ(2);
        aVar.b(agVar);
        aVar.ni().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.ad a = aVar.a(true, viewGroup, this.OT);
        a.aQ(2);
        af<com.baidu.tieba.card.data.k> afVar = new af<>(a);
        afVar.setPageId(this.dBK);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.x.6
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (x.this.JZ != null) {
                        x.this.JZ.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    afVar2.nk().b(new a.C0052a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cRt == null) {
            return null;
        }
        kVar.rv(kVar.position + 1);
        afVar.nk().setPosition(i);
        com.baidu.tieba.card.r.bvm().e(kVar.Ac("c12641"));
        com.baidu.tieba.a.d.aXK().a("page_recommend", "show_", kVar.bvH());
        afVar.nk().setPage(this.LC);
        afVar.ag(true).a(this.dUT);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.JZ);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRt, this.dBK, kVar.bvw());
        return afVar.getView();
    }

    private void bPl() {
        com.baidu.tieba.card.data.k.fNz = "c10705";
        com.baidu.tieba.card.data.k.fNA = "c10730";
        com.baidu.tieba.card.data.k.fNB = "c10731";
        com.baidu.tieba.card.data.k.fNC = "c10704";
        com.baidu.tieba.card.data.k.fND = "c10755";
        com.baidu.tieba.card.data.k.fNE = "c10710";
        com.baidu.tieba.card.data.k.fNF = "c10736";
        com.baidu.tieba.card.data.k.fNG = "c10737";
        com.baidu.tieba.card.data.k.fNH = "c10711";
        com.baidu.tieba.card.data.k.fNI = "c10758";
        com.baidu.tieba.card.data.k.fNJ = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUT = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.a aVar) {
        au.a(aVar.aAj().cUe, this.mContext, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(bj bjVar) {
        if (bjVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(bjVar);
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, "index", videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.l.aCd(), bjVar.aAm(), videoSerializeVideoThreadInfo);
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
