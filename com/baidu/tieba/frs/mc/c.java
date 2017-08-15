package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class c extends i {
    private final CustomMessageListener cgT;
    public final com.baidu.adp.base.d cwB;
    public final com.baidu.adp.base.d cwC;

    public c(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cgT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.c.1
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
                    c.this.coU.refresh();
                }
            }
        };
        fVar.registerListener(this.cgT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.tieba.tbadkCore.i afN = this.coU.afN();
            if (this.cjT != null && this.cjU != null && this.cjK != null && afN != null && afN.aPO() != null && oVar.getFid() != null) {
                boolean z = oVar.isLike() == 1;
                if (oVar.getFid().equals(afN.aPO().getId())) {
                    afN.aPO().setLike(oVar.isLike());
                    if (!StringUtils.isNULL(oVar.getLevelName())) {
                        afN.aPO().setLevelName(oVar.getLevelName());
                    }
                    if (oVar.getUserLevel() >= 0) {
                        afN.aPO().setUser_level(oVar.getUserLevel());
                    }
                    if (z) {
                        this.cjU.a(afN, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.coU.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.brc().aa(this.coU.getForumName(), false);
                    afN.aPO().setLike(0);
                    this.cjU.akf();
                    TbadkCoreApplication.getInst().delLikeForum(this.coU.getForumName());
                    return;
                }
                if (oVar.isLike() == 1) {
                    afN.rT(oVar.getFid());
                    this.cjU.f(afN);
                    this.cjV.a(this.cjK.getListView(), afN, this.cjT.ajl());
                }
                if (afN.aPO().getBannerListData() != null) {
                    afN.aPO().getBannerListData().setFeedForumLiked(oVar.getFid(), oVar.isLike());
                }
                this.cjK.age();
            }
        }
    }
}
