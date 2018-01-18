package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes2.dex */
public class b extends h {
    public final com.baidu.adp.base.d dPm;
    public final com.baidu.adp.base.d dPn;
    private final CustomMessageListener dym;

    public b(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dym = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dPm = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dPn = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dPp.refresh();
                }
            }
        };
        iVar.registerListener(this.dym);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l auq = this.dPp.auq();
            if (this.dBq != null && this.dBr != null && this.dBi != null && auq != null && auq.aYE() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(auq.aYE().getId())) {
                    auq.aYE().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        auq.aYE().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.bsa() >= 0) {
                        auq.aYE().setUser_level(rVar.bsa());
                    }
                    if (z) {
                        this.dBr.a(auq, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dPp.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.btt().aa(this.dPp.getForumName(), false);
                    auq.aYE().setLike(0);
                    this.dBr.aze();
                    TbadkCoreApplication.getInst().delLikeForum(this.dPp.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    auq.sm(rVar.getFid());
                    this.dBr.f(auq);
                    this.dQj.a(auq, this.dBq.ayq());
                }
                if (auq.aYE().getBannerListData() != null) {
                    auq.aYE().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dBi.auH();
            }
        }
    }
}
