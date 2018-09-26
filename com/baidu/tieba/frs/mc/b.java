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
    public final com.baidu.adp.base.d dKg;
    public final com.baidu.adp.base.d dKh;
    private final CustomMessageListener doQ;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.doQ = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dKg = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void j(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dKh = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void j(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dKj.refresh();
                }
            }
        };
        frsFragment.registerListener(this.doQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l awv = this.dKj.awv();
            if (this.dsw != null && this.dsx != null && this.dsl != null && awv != null && awv.bbH() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(awv.bbH().getId())) {
                    awv.bbH().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        awv.bbH().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.bvg() >= 0) {
                        awv.bbH().setUser_level(rVar.bvg());
                    }
                    if (z) {
                        this.dsx.a(awv, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dKj.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bwy().U(this.dKj.getForumName(), false);
                    awv.bbH().setLike(0);
                    this.dsx.aCL();
                    TbadkCoreApplication.getInst().delLikeForum(this.dKj.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    awv.um(rVar.getFid());
                    this.dsx.h(awv);
                    this.dLg.a(awv, this.dsw.aBR());
                }
                if (awv.bbH().getBannerListData() != null) {
                    awv.bbH().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dsl.axc();
            }
        }
    }
}
