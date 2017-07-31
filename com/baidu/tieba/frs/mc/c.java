package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class c extends i {
    private final CustomMessageListener cgh;
    public final com.baidu.adp.base.d cux;
    public final com.baidu.adp.base.d cuy;

    public c(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cgh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o)) {
                    c.this.b((o) customResponsedMessage.getData());
                }
            }
        };
        this.cux = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.c.2
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cuy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.c.3
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    c.this.f5com.refresh();
                }
            }
        };
        fVar.registerListener(this.cgh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.tieba.tbadkCore.i afr = this.f5com.afr();
            if (this.cjg != null && this.cjh != null && this.ciX != null && afr != null && afr.aPh() != null && oVar.getFid() != null) {
                boolean z = oVar.isLike() == 1;
                if (oVar.getFid().equals(afr.aPh().getId())) {
                    afr.aPh().setLike(oVar.isLike());
                    if (!StringUtils.isNULL(oVar.getLevelName())) {
                        afr.aPh().setLevelName(oVar.getLevelName());
                    }
                    if (oVar.getUserLevel() >= 0) {
                        afr.aPh().setUser_level(oVar.getUserLevel());
                    }
                    if (z) {
                        this.cjh.a(afr, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.f5com.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bqu().Z(this.f5com.getForumName(), false);
                    afr.aPh().setLike(0);
                    this.cjh.ajz();
                    TbadkCoreApplication.getInst().delLikeForum(this.f5com.getForumName());
                    return;
                }
                if (oVar.isLike() == 1) {
                    afr.rR(oVar.getFid());
                    this.cjh.f(afr);
                    this.cji.a(this.ciX.getListView(), afr, this.cjg.aiE());
                }
                if (afr.aPh().getBannerListData() != null) {
                    afr.aPh().getBannerListData().setFeedForumLiked(oVar.getFid(), oVar.isLike());
                }
                this.ciX.afH();
            }
        }
    }
}
