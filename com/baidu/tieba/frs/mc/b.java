package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.q;
/* loaded from: classes.dex */
public class b extends h {
    private final CustomMessageListener cEk;
    public final com.baidu.adp.base.d cXw;
    public final com.baidu.adp.base.d cXx;

    public b(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cEk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof q)) {
                    b.this.b((q) customResponsedMessage.getData());
                }
            }
        };
        this.cXw = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cXx = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.cOm.refresh();
                }
            }
        };
        fVar.registerListener(this.cEk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(q qVar) {
        if (qVar != null) {
            k alv = this.cOm.alv();
            if (this.cHi != null && this.cHj != null && this.cHa != null && alv != null && alv.aRf() != null && qVar.getFid() != null) {
                boolean z = qVar.isLike() == 1;
                if (qVar.getFid().equals(alv.aRf().getId())) {
                    alv.aRf().setLike(qVar.isLike());
                    if (!StringUtils.isNULL(qVar.getLevelName())) {
                        alv.aRf().setLevelName(qVar.getLevelName());
                    }
                    if (qVar.getUserLevel() >= 0) {
                        alv.aRf().setUser_level(qVar.getUserLevel());
                    }
                    if (z) {
                        this.cHj.a(alv, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.cOm.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bue().Y(this.cOm.getForumName(), false);
                    alv.aRf().setLike(0);
                    this.cHj.aqL();
                    TbadkCoreApplication.getInst().delLikeForum(this.cOm.getForumName());
                    return;
                }
                if (qVar.isLike() == 1) {
                    alv.sO(qVar.getFid());
                    this.cHj.f(alv);
                    this.cHk.a(this.cHa.getListView(), alv, this.cHi.apS());
                }
                if (alv.aRf().getBannerListData() != null) {
                    alv.aRf().getBannerListData().setFeedForumLiked(qVar.getFid(), qVar.isLike());
                }
                this.cHa.alL();
            }
        }
    }
}
