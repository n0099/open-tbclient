package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class b extends h {
    public final com.baidu.adp.base.d cEM;
    public final com.baidu.adp.base.d cEN;
    private final CustomMessageListener cnF;

    public b(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cnF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o)) {
                    b.this.b((o) customResponsedMessage.getData());
                }
            }
        };
        this.cEM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cEN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.cxi.refresh();
                }
            }
        };
        fVar.registerListener(this.cnF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.tieba.tbadkCore.i ahk = this.cxi.ahk();
            if (this.cqC != null && this.cqD != null && this.cqt != null && ahk != null && ahk.aMZ() != null && oVar.getFid() != null) {
                boolean z = oVar.isLike() == 1;
                if (oVar.getFid().equals(ahk.aMZ().getId())) {
                    ahk.aMZ().setLike(oVar.isLike());
                    if (!StringUtils.isNULL(oVar.getLevelName())) {
                        ahk.aMZ().setLevelName(oVar.getLevelName());
                    }
                    if (oVar.getUserLevel() >= 0) {
                        ahk.aMZ().setUser_level(oVar.getUserLevel());
                    }
                    if (z) {
                        this.cqD.a(ahk, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.cxi.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bpp().Y(this.cxi.getForumName(), false);
                    ahk.aMZ().setLike(0);
                    this.cqD.alW();
                    TbadkCoreApplication.getInst().delLikeForum(this.cxi.getForumName());
                    return;
                }
                if (oVar.isLike() == 1) {
                    ahk.rF(oVar.getFid());
                    this.cqD.f(ahk);
                    this.cqE.a(this.cqt.getListView(), ahk, this.cqC.ald());
                }
                if (ahk.aMZ().getBannerListData() != null) {
                    ahk.aMZ().getBannerListData().setFeedForumLiked(oVar.getFid(), oVar.isLike());
                }
                this.cqt.ahA();
            }
        }
    }
}
