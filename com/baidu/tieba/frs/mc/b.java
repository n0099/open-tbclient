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
    private final CustomMessageListener cVg;
    public final com.baidu.adp.base.d dob;
    public final com.baidu.adp.base.d dod;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.cVg = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dob = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dod = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dof.refresh();
                }
            }
        };
        frsFragment.registerListener(this.cVg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l apD = this.dof.apD();
            if (this.cYw != null && this.cYx != null && this.cYo != null && apD != null && apD.aVq() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(apD.aVq().getId())) {
                    apD.aVq().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        apD.aVq().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.box() >= 0) {
                        apD.aVq().setUser_level(rVar.box());
                    }
                    if (z) {
                        this.cYx.a(apD, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dof.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bpO().T(this.dof.getForumName(), false);
                    apD.aVq().setLike(0);
                    this.cYx.avj();
                    TbadkCoreApplication.getInst().delLikeForum(this.dof.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    apD.sN(rVar.getFid());
                    this.cYx.f(apD);
                    this.dpb.a(apD, this.cYw.aum());
                }
                if (apD.aVq().getBannerListData() != null) {
                    apD.aVq().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.cYo.aqj();
            }
        }
    }
}
