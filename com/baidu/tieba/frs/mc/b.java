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
    public final com.baidu.adp.base.d dPH;
    public final com.baidu.adp.base.d dPI;
    private final CustomMessageListener dyH;

    public b(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dyH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dPH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dPI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dPK.refresh();
                }
            }
        };
        iVar.registerListener(this.dyH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l auv = this.dPK.auv();
            if (this.dBL != null && this.dBM != null && this.dBD != null && auv != null && auv.aYJ() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(auv.aYJ().getId())) {
                    auv.aYJ().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        auv.aYJ().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.bsc() >= 0) {
                        auv.aYJ().setUser_level(rVar.bsc());
                    }
                    if (z) {
                        this.dBM.a(auv, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dPK.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.btv().aa(this.dPK.getForumName(), false);
                    auv.aYJ().setLike(0);
                    this.dBM.azj();
                    TbadkCoreApplication.getInst().delLikeForum(this.dPK.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    auv.sv(rVar.getFid());
                    this.dBM.f(auv);
                    this.dQE.a(auv, this.dBL.ayv());
                }
                if (auv.aYJ().getBannerListData() != null) {
                    auv.aYJ().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dBD.auM();
            }
        }
    }
}
