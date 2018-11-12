package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes6.dex */
public class b extends h {
    public final com.baidu.adp.base.d dTj;
    public final com.baidu.adp.base.d dTk;
    private final CustomMessageListener dyk;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.dyk = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dTj = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dTk = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dTm.refresh();
                }
            }
        };
        frsFragment.registerListener(this.dyk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l azp = this.dTm.azp();
            if (this.dBO != null && this.dBP != null && this.dBE != null && azp != null && azp.ber() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(azp.ber().getId())) {
                    azp.ber().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        azp.ber().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.bxR() >= 0) {
                        azp.ber().setUser_level(rVar.bxR());
                    }
                    if (z) {
                        this.dBP.a(azp, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dTm.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bzj().ab(this.dTm.getForumName(), false);
                    azp.ber().setLike(0);
                    this.dBP.aFz();
                    TbadkCoreApplication.getInst().delLikeForum(this.dTm.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    azp.uS(rVar.getFid());
                    this.dBP.h(azp);
                    this.dUj.a(azp, this.dBO.aEG());
                }
                if (azp.ber().getBannerListData() != null) {
                    azp.ber().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dBE.azV();
            }
        }
    }
}
