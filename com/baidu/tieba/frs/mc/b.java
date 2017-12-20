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
    private final CustomMessageListener cEs;
    public final com.baidu.adp.base.d cXH;
    public final com.baidu.adp.base.d cXI;

    public b(com.baidu.tieba.frs.g gVar) {
        super(gVar);
        this.cEs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof q)) {
                    b.this.b((q) customResponsedMessage.getData());
                }
            }
        };
        this.cXH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cXI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.cOx.refresh();
                }
            }
        };
        gVar.registerListener(this.cEs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(q qVar) {
        if (qVar != null) {
            k alE = this.cOx.alE();
            if (this.cHq != null && this.cHr != null && this.cHi != null && alE != null && alE.aRn() != null && qVar.getFid() != null) {
                boolean z = qVar.isLike() == 1;
                if (qVar.getFid().equals(alE.aRn().getId())) {
                    alE.aRn().setLike(qVar.isLike());
                    if (!StringUtils.isNULL(qVar.getLevelName())) {
                        alE.aRn().setLevelName(qVar.getLevelName());
                    }
                    if (qVar.getUserLevel() >= 0) {
                        alE.aRn().setUser_level(qVar.getUserLevel());
                    }
                    if (z) {
                        this.cHr.a(alE, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.cOx.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.buJ().Z(this.cOx.getForumName(), false);
                    alE.aRn().setLike(0);
                    this.cHr.aqT();
                    TbadkCoreApplication.getInst().delLikeForum(this.cOx.getForumName());
                    return;
                }
                if (qVar.isLike() == 1) {
                    alE.sT(qVar.getFid());
                    this.cHr.g(alE);
                    this.cHs.a(this.cHi.getListView(), alE, this.cHq.aqa());
                }
                if (alE.aRn().getBannerListData() != null) {
                    alE.aRn().getBannerListData().setFeedForumLiked(qVar.getFid(), qVar.isLike());
                }
                this.cHi.alT();
            }
        }
    }
}
