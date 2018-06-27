package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes2.dex */
public class b extends h {
    public final com.baidu.adp.base.d dAH;
    public final com.baidu.adp.base.d dAI;
    private final CustomMessageListener dgj;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.dgj = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dAH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dAI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dAK.refresh();
                }
            }
        };
        frsFragment.registerListener(this.dgj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l atZ = this.dAK.atZ();
            if (this.djL != null && this.djM != null && this.djA != null && atZ != null && atZ.baT() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(atZ.baT().getId())) {
                    atZ.baT().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        atZ.baT().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.btX() >= 0) {
                        atZ.baT().setUser_level(rVar.btX());
                    }
                    if (z) {
                        this.djM.a(atZ, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dAK.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bvo().U(this.dAK.getForumName(), false);
                    atZ.baT().setLike(0);
                    this.djM.azY();
                    TbadkCoreApplication.getInst().delLikeForum(this.dAK.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    atZ.tD(rVar.getFid());
                    this.djM.h(atZ);
                    this.dBH.a(atZ, this.djL.azf());
                }
                if (atZ.baT().getBannerListData() != null) {
                    atZ.baT().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.djA.auG();
            }
        }
    }
}
