package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.card.an;
import com.baidu.card.aq;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class z extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adX;
    private String afG;
    private com.baidu.adp.widget.ListView.v ajy;
    private NEGFeedBackView.a eTW;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eTW = null;
        this.adX = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.bOB().jI(true);
                com.baidu.tieba.a.d.boB().dh("page_recommend", "show_");
                if (view != null && kVar != null && kVar.aPS() != null && !StringUtils.isNull(kVar.aPS().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.DX("c12642"));
                        com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bOZ());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bPd());
                        com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bPd());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.bPb());
                        com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bPb());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.bPb());
                        com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bPb());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.bPa());
                        com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bPa());
                    } else if (id == R.id.god_reply_voice_btn) {
                        ao aoVar = new ao("c10760");
                        aoVar.ag("obj_locate", 4);
                        TiebaStatic.log(aoVar);
                    } else if (id == R.id.god_reply_content) {
                        ao aoVar2 = new ao("c10760");
                        aoVar2.ag("obj_locate", 2);
                        TiebaStatic.log(aoVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        ao aoVar3 = new ao("c10760");
                        aoVar3.ag("obj_locate", 1);
                        TiebaStatic.log(aoVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            ao aoVar4 = new ao("c10760");
                            aoVar4.ag("obj_locate", 3);
                            TiebaStatic.log(aoVar4);
                        }
                        TiebaStatic.log(kVar.bPc());
                        com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bPc());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLi, z.this.eyE, kVar.bOM(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cjQ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eyE);
        eVar.be(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.z.2
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
        com.baidu.card.ad adVar = new com.baidu.card.ad(this.mPageContext);
        adVar.b((Boolean) false);
        adVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds27));
        adVar.setFrom("index");
        aVar.c(adVar);
        com.baidu.card.ad adVar2 = new com.baidu.card.ad(this.mPageContext);
        adVar2.b((Boolean) true);
        adVar2.setFrom("index");
        adVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds29), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
        adVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.z.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null && absThreadDataSupport.aPS().dNX != null) {
                    aw.a(absThreadDataSupport.aPS().dNX, z.this.mContext, 2);
                }
            }
        });
        aVar.a((com.baidu.card.h) adVar2);
        aq aqVar = new aq(this.mPageContext.getPageActivity());
        aqVar.b((Boolean) true);
        aqVar.setFrom("index");
        aqVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.z.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null && absThreadDataSupport.aPS().dNX != null) {
                    aw.a(absThreadDataSupport.aPS().dNX, z.this.mContext, 3);
                }
            }
        });
        aqVar.setVideoAreaClickListener(new com.baidu.card.view.a() { // from class: com.baidu.tieba.homepage.personalize.a.z.5
            @Override // com.baidu.card.view.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                boolean z = true;
                if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null && absThreadDataSupport.aPS().dNX != null) {
                    if (absThreadDataSupport.aPS().dNX.videoInfo == null) {
                        z = false;
                    } else if (absThreadDataSupport.aPS().dNX.videoInfo.is_vertical.intValue() != 1) {
                        z = false;
                    }
                    if (z) {
                        z.this.f(absThreadDataSupport.aPS().dNX);
                    } else {
                        z.this.ar(absThreadDataSupport.aPS());
                    }
                }
            }
        });
        aVar.a((com.baidu.card.h) aqVar);
        aVar.a((com.baidu.card.h) new an(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 1;
        cVar.dHw = 1;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(1);
        alVar.setShareReportFrom(3);
        alVar.setFromForPb(2);
        aVar.b(alVar);
        aVar.sc().setBackgroundResource(R.drawable.addresslist_item_bg);
        ai a = aVar.a(true, viewGroup, this.ajy);
        a.setSourceForPb(2);
        ak<com.baidu.tieba.card.data.k> akVar = new ak<>(a);
        akVar.setPageId(this.eyE);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.z.6
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (z.this.adX != null) {
                        z.this.adX.a(akVar2.getView(), kVar);
                    }
                    aw.a((AbsThreadDataSupport) kVar, view.getContext(), 2, false);
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLi == null) {
            return null;
        }
        kVar.sR(kVar.position + 1);
        akVar.se().setPosition(i);
        com.baidu.tieba.card.s.bOB().e(kVar.DW("c12641"));
        com.baidu.tieba.a.d.boB().a("page_recommend", "show_", kVar.bOY());
        akVar.se().setPage(this.afG);
        akVar.aI(true).a(this.eTW);
        akVar.a(kVar.aQc(), this.ilu);
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLi, this.eyE, kVar.bOM());
        return akVar.getView();
    }

    private void cjQ() {
        com.baidu.tieba.card.data.k.gUm = "c10705";
        com.baidu.tieba.card.data.k.gUn = "c10730";
        com.baidu.tieba.card.data.k.gUo = "c10731";
        com.baidu.tieba.card.data.k.gUp = "c10704";
        com.baidu.tieba.card.data.k.gUq = "c10755";
        com.baidu.tieba.card.data.k.gUr = "c10710";
        com.baidu.tieba.card.data.k.gUs = "c10736";
        com.baidu.tieba.card.data.k.gUt = "c10737";
        com.baidu.tieba.card.data.k.gUu = "c10711";
        com.baidu.tieba.card.data.k.gUv = "c10758";
        com.baidu.tieba.card.data.k.gUw = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eTW = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(bu buVar) {
        if (buVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(buVar);
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, "index", videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.m.aSb(), buVar.aPV(), videoSerializeVideoThreadInfo);
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
