package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.p;
/* loaded from: classes.dex */
public class b extends h {
    public final com.baidu.adp.base.d cNN;
    public final com.baidu.adp.base.d cNO;
    private final CustomMessageListener cuN;

    public b(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cuN = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof p)) {
                    b.this.b((p) customResponsedMessage.getData());
                }
            }
        };
        this.cNN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cNO = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.cEN.refresh();
                }
            }
        };
        fVar.registerListener(this.cuN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(p pVar) {
        if (pVar != null) {
            com.baidu.tieba.tbadkCore.j ajn = this.cEN.ajn();
            if (this.cxK != null && this.cxL != null && this.cxB != null && ajn != null && ajn.aPM() != null && pVar.getFid() != null) {
                boolean z = pVar.isLike() == 1;
                if (pVar.getFid().equals(ajn.aPM().getId())) {
                    ajn.aPM().setLike(pVar.isLike());
                    if (!StringUtils.isNULL(pVar.getLevelName())) {
                        ajn.aPM().setLevelName(pVar.getLevelName());
                    }
                    if (pVar.getUserLevel() >= 0) {
                        ajn.aPM().setUser_level(pVar.getUserLevel());
                    }
                    if (z) {
                        this.cxL.a(ajn, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.cEN.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bsm().W(this.cEN.getForumName(), false);
                    ajn.aPM().setLike(0);
                    this.cxL.aoC();
                    TbadkCoreApplication.getInst().delLikeForum(this.cEN.getForumName());
                    return;
                }
                if (pVar.isLike() == 1) {
                    ajn.sm(pVar.getFid());
                    this.cxL.f(ajn);
                    this.cxM.a(this.cxB.getListView(), ajn, this.cxK.anJ());
                }
                if (ajn.aPM().getBannerListData() != null) {
                    ajn.aPM().getBannerListData().setFeedForumLiked(pVar.getFid(), pVar.isLike());
                }
                this.cxB.ajD();
            }
        }
    }
}
