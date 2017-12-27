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
    public final com.baidu.adp.base.d dKK;
    public final com.baidu.adp.base.d dKL;
    private final CustomMessageListener dtL;

    public b(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dtL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dKK = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dKL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dKN.refresh();
                }
            }
        };
        iVar.registerListener(this.dtL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l atn = this.dKN.atn();
            if (this.dwP != null && this.dwQ != null && this.dwH != null && atn != null && atn.aYy() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(atn.aYy().getId())) {
                    atn.aYy().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        atn.aYy().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.getUserLevel() >= 0) {
                        atn.aYy().setUser_level(rVar.getUserLevel());
                    }
                    if (z) {
                        this.dwQ.a(atn, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dKN.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bzX().aa(this.dKN.getForumName(), false);
                    atn.aYy().setLike(0);
                    this.dwQ.ayb();
                    TbadkCoreApplication.getInst().delLikeForum(this.dKN.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    atn.sT(rVar.getFid());
                    this.dwQ.f(atn);
                    this.dLH.a(atn, this.dwP.axn());
                }
                if (atn.aYy().getBannerListData() != null) {
                    atn.aYy().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dwH.atE();
            }
        }
    }
}
