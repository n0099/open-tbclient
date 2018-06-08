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
    private final CustomMessageListener der;
    public final com.baidu.adp.base.d dxt;
    public final com.baidu.adp.base.d dxu;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.der = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dxt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dxu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dxw.refresh();
                }
            }
        };
        frsFragment.registerListener(this.der);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l atI = this.dxw.atI();
            if (this.dhN != null && this.dhO != null && this.dhC != null && atI != null && atI.bam() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(atI.bam().getId())) {
                    atI.bam().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        atI.bam().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.btx() >= 0) {
                        atI.bam().setUser_level(rVar.btx());
                    }
                    if (z) {
                        this.dhO.a(atI, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dxw.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.buO().T(this.dxw.getForumName(), false);
                    atI.bam().setLike(0);
                    this.dhO.azs();
                    TbadkCoreApplication.getInst().delLikeForum(this.dxw.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    atI.tE(rVar.getFid());
                    this.dhO.g(atI);
                    this.dys.a(atI, this.dhN.ayz());
                }
                if (atI.bam().getBannerListData() != null) {
                    atI.bam().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dhC.auo();
            }
        }
    }
}
