package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.p;
/* loaded from: classes.dex */
public class b extends h {
    public final com.baidu.adp.base.d cOh;
    public final com.baidu.adp.base.d cOi;
    private final CustomMessageListener cvg;

    public b(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cvg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof p)) {
                    b.this.b((p) customResponsedMessage.getData());
                }
            }
        };
        this.cOh = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cOi = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.cFg.refresh();
                }
            }
        };
        fVar.registerListener(this.cvg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(p pVar) {
        if (pVar != null) {
            com.baidu.tieba.tbadkCore.j ajB = this.cFg.ajB();
            if (this.cyd != null && this.cye != null && this.cxU != null && ajB != null && ajB.aPU() != null && pVar.getFid() != null) {
                boolean z = pVar.isLike() == 1;
                if (pVar.getFid().equals(ajB.aPU().getId())) {
                    ajB.aPU().setLike(pVar.isLike());
                    if (!StringUtils.isNULL(pVar.getLevelName())) {
                        ajB.aPU().setLevelName(pVar.getLevelName());
                    }
                    if (pVar.getUserLevel() >= 0) {
                        ajB.aPU().setUser_level(pVar.getUserLevel());
                    }
                    if (z) {
                        this.cye.a(ajB, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.cFg.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bsx().W(this.cFg.getForumName(), false);
                    ajB.aPU().setLike(0);
                    this.cye.aoR();
                    TbadkCoreApplication.getInst().delLikeForum(this.cFg.getForumName());
                    return;
                }
                if (pVar.isLike() == 1) {
                    ajB.ss(pVar.getFid());
                    this.cye.f(ajB);
                    this.cyf.a(this.cxU.getListView(), ajB, this.cyd.anY());
                }
                if (ajB.aPU().getBannerListData() != null) {
                    ajB.aPU().getBannerListData().setFeedForumLiked(pVar.getFid(), pVar.isLike());
                }
                this.cxU.ajR();
            }
        }
    }
}
