package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.q;
/* loaded from: classes.dex */
public class b extends h {
    private final CustomMessageListener cEw;
    public final com.baidu.adp.base.d cXL;
    public final com.baidu.adp.base.d cXM;

    public b(com.baidu.tieba.frs.g gVar) {
        super(gVar);
        this.cEw = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof q)) {
                    b.this.b((q) customResponsedMessage.getData());
                }
            }
        };
        this.cXL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cXM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.cOB.refresh();
                }
            }
        };
        gVar.registerListener(this.cEw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(q qVar) {
        if (qVar != null) {
            k alE = this.cOB.alE();
            if (this.cHu != null && this.cHv != null && this.cHm != null && alE != null && alE.aRo() != null && qVar.getFid() != null) {
                boolean z = qVar.isLike() == 1;
                if (qVar.getFid().equals(alE.aRo().getId())) {
                    alE.aRo().setLike(qVar.isLike());
                    if (!StringUtils.isNULL(qVar.getLevelName())) {
                        alE.aRo().setLevelName(qVar.getLevelName());
                    }
                    if (qVar.getUserLevel() >= 0) {
                        alE.aRo().setUser_level(qVar.getUserLevel());
                    }
                    if (z) {
                        this.cHv.a(alE, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.cOB.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.buK().Z(this.cOB.getForumName(), false);
                    alE.aRo().setLike(0);
                    this.cHv.aqU();
                    TbadkCoreApplication.getInst().delLikeForum(this.cOB.getForumName());
                    return;
                }
                if (qVar.isLike() == 1) {
                    alE.sT(qVar.getFid());
                    this.cHv.g(alE);
                    this.cHw.a(this.cHm.getListView(), alE, this.cHu.aqb());
                }
                if (alE.aRo().getBannerListData() != null) {
                    alE.aRo().getBannerListData().setFeedForumLiked(qVar.getFid(), qVar.isLike());
                }
                this.cHm.alU();
            }
        }
    }
}
