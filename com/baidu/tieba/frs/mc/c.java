package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class c extends i {
    private final CustomMessageListener cgU;
    public final com.baidu.adp.base.d cwB;
    public final com.baidu.adp.base.d cwC;

    public c(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cgU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o)) {
                    c.this.b((o) customResponsedMessage.getData());
                }
            }
        };
        this.cwB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.c.2
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cwC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.c.3
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    c.this.coV.refresh();
                }
            }
        };
        fVar.registerListener(this.cgU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.tieba.tbadkCore.i afH = this.coV.afH();
            if (this.cjU != null && this.cjV != null && this.cjL != null && afH != null && afH.aPJ() != null && oVar.getFid() != null) {
                boolean z = oVar.isLike() == 1;
                if (oVar.getFid().equals(afH.aPJ().getId())) {
                    afH.aPJ().setLike(oVar.isLike());
                    if (!StringUtils.isNULL(oVar.getLevelName())) {
                        afH.aPJ().setLevelName(oVar.getLevelName());
                    }
                    if (oVar.getUserLevel() >= 0) {
                        afH.aPJ().setUser_level(oVar.getUserLevel());
                    }
                    if (z) {
                        this.cjV.a(afH, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.coV.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bqV().aa(this.coV.getForumName(), false);
                    afH.aPJ().setLike(0);
                    this.cjV.ajZ();
                    TbadkCoreApplication.getInst().delLikeForum(this.coV.getForumName());
                    return;
                }
                if (oVar.isLike() == 1) {
                    afH.rY(oVar.getFid());
                    this.cjV.f(afH);
                    this.cjW.a(this.cjL.getListView(), afH, this.cjU.ajf());
                }
                if (afH.aPJ().getBannerListData() != null) {
                    afH.aPJ().getBannerListData().setFeedForumLiked(oVar.getFid(), oVar.isLike());
                }
                this.cjL.afY();
            }
        }
    }
}
