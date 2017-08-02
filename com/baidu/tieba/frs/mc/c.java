package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class c extends i {
    private final CustomMessageListener cfb;
    public final com.baidu.adp.base.d ctd;
    public final com.baidu.adp.base.d cte;

    public c(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cfb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o)) {
                    c.this.b((o) customResponsedMessage.getData());
                }
            }
        };
        this.ctd = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.c.2
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cte = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.c.3
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    c.this.cna.refresh();
                }
            }
        };
        fVar.registerListener(this.cfb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.tieba.tbadkCore.i afm = this.cna.afm();
            if (this.chZ != null && this.cia != null && this.chQ != null && afm != null && afm.aOW() != null && oVar.getFid() != null) {
                boolean z = oVar.isLike() == 1;
                if (oVar.getFid().equals(afm.aOW().getId())) {
                    afm.aOW().setLike(oVar.isLike());
                    if (!StringUtils.isNULL(oVar.getLevelName())) {
                        afm.aOW().setLevelName(oVar.getLevelName());
                    }
                    if (oVar.getUserLevel() >= 0) {
                        afm.aOW().setUser_level(oVar.getUserLevel());
                    }
                    if (z) {
                        this.cia.a(afm, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.cna.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bqn().aa(this.cna.getForumName(), false);
                    afm.aOW().setLike(0);
                    this.cia.ajm();
                    TbadkCoreApplication.getInst().delLikeForum(this.cna.getForumName());
                    return;
                }
                if (oVar.isLike() == 1) {
                    afm.rM(oVar.getFid());
                    this.cia.f(afm);
                    this.cib.a(this.chQ.getListView(), afm, this.chZ.ais());
                }
                if (afm.aOW().getBannerListData() != null) {
                    afm.aOW().getBannerListData().setFeedForumLiked(oVar.getFid(), oVar.isLike());
                }
                this.chQ.afC();
            }
        }
    }
}
