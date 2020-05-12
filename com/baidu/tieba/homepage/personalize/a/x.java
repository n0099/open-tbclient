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
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> ada;
    private String aeB;
    private com.baidu.adp.widget.ListView.r ahy;
    public BdUniqueId ebA;
    private NEGFeedBackView.a euX;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.euX = null;
        this.ada = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bEX().jd(true);
                com.baidu.tieba.a.d.bfN().cF("page_recommend", "show_");
                if (view != null && kVar != null && kVar.aIu() != null && !StringUtils.isNull(kVar.aIu().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.BN("c12642"));
                        com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFs());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bFw());
                        com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFw());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.bFu());
                        com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFu());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.bFu());
                        com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFu());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.bFt());
                        com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFt());
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c10760");
                        anVar.af("obj_locate", 4);
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c10760");
                        anVar2.af("obj_locate", 2);
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar3 = new an("c10760");
                        anVar3.af("obj_locate", 1);
                        TiebaStatic.log(anVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar4 = new an("c10760");
                            anVar4.af("obj_locate", 3);
                            TiebaStatic.log(anVar4);
                        }
                        TiebaStatic.log(kVar.bFv());
                        com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFv());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dqE, x.this.ebA, kVar.bFg(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        bZL();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ebA);
        eVar.aX(1024);
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
                if (aVar2 != null && aVar2.aIu() != null && aVar2.aIu().dtt != null) {
                    au.a(aVar2.aIu().dtt, x.this.mContext, 2);
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
                if (aVar2 != null && aVar2.aIu() != null && aVar2.aIu().dtt != null) {
                    au.a(aVar2.aIu().dtt, x.this.mContext, 3);
                }
            }
        });
        akVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.5
            @Override // com.baidu.card.view.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                boolean z = true;
                if (aVar2 != null && aVar2.aIu() != null && aVar2.aIu().dtt != null) {
                    if (aVar2.aIu().dtt.videoInfo == null) {
                        z = false;
                    } else if (aVar2.aIu().dtt.videoInfo.is_vertical.intValue() != 1) {
                        z = false;
                    }
                    if (z) {
                        x.this.f(aVar2.aIu().dtt);
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                        x.this.aq(aVar2.aIu());
                    } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                        x.this.d(aVar2);
                    } else {
                        x.this.aq(aVar2.aIu());
                    }
                }
            }
        });
        aVar.a((com.baidu.card.h) akVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmX = 1;
        dVar.dnd = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.bl(2);
        aVar.b(agVar);
        aVar.rB().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.ad a = aVar.a(true, viewGroup, this.ahy);
        a.bc(2);
        af<com.baidu.tieba.card.data.k> afVar = new af<>(a);
        afVar.setPageId(this.ebA);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.homepage.personalize.a.x.6
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (x.this.ada != null) {
                        x.this.ada.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    afVar2.rD().b(new a.C0095a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.dqE == null) {
            return null;
        }
        kVar.rN(kVar.position + 1);
        afVar.rD().setPosition(i);
        com.baidu.tieba.card.r.bEX().e(kVar.BM("c12641"));
        com.baidu.tieba.a.d.bfN().a("page_recommend", "show_", kVar.bFr());
        afVar.rD().setPage(this.aeB);
        afVar.aF(true).a(this.euX);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.ada);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dqE, this.ebA, kVar.bFg());
        return afVar.getView();
    }

    private void bZL() {
        com.baidu.tieba.card.data.k.gsm = "c10705";
        com.baidu.tieba.card.data.k.gsn = "c10730";
        com.baidu.tieba.card.data.k.gso = "c10731";
        com.baidu.tieba.card.data.k.gsp = "c10704";
        com.baidu.tieba.card.data.k.gsq = "c10755";
        com.baidu.tieba.card.data.k.gsr = "c10710";
        com.baidu.tieba.card.data.k.gss = "c10736";
        com.baidu.tieba.card.data.k.gst = "c10737";
        com.baidu.tieba.card.data.k.gsu = "c10711";
        com.baidu.tieba.card.data.k.gsv = "c10758";
        com.baidu.tieba.card.data.k.gsw = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.euX = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.a aVar) {
        au.a(aVar.aIu().dtt, this.mContext, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bj bjVar) {
        if (bjVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(bjVar);
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, "index", videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.l.aKo(), bjVar.aIx(), videoSerializeVideoThreadInfo);
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
