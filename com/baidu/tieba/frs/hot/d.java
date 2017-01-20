package com.baidu.tieba.frs.hot;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cj;
import com.baidu.tieba.frs.cm;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements cb {
    private BdUniqueId aUC;
    private cc aUE;
    private boolean bRF = false;
    private boolean bDQ = true;
    private boolean aJO = false;
    private int mCurrentPage = 0;
    private cm bRG = new cm();
    private final ArrayList<v> bRH = new ArrayList<>();
    private com.baidu.adp.framework.listener.a btt = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener bRI = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aUC = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(int i, int i2, cj cjVar) {
        if (i == 2 && cjVar != null) {
            if (cjVar.pn == -1) {
                cjVar.pn = 1;
                this.aJO = true;
            } else {
                this.aJO = false;
            }
            if (this.bDQ) {
                this.bRG.forumId = cjVar.forumId;
                this.bRG.pn = cjVar.pn;
                iK(cjVar.forumId);
            } else if (cjVar.pn == this.mCurrentPage && !this.aJO) {
                abK();
            } else {
                b(com.baidu.adp.lib.g.b.c(cjVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(cc ccVar) {
        this.aUE = ccVar;
    }

    @Override // com.baidu.tieba.frs.cb
    public void init() {
        registerListener();
        DL();
    }

    @Override // com.baidu.tieba.frs.cb
    public void Me() {
        unRegisterListener();
    }

    private void iK(String str) {
        FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = new FrsHotThreadRequestCacheMessage(str);
        if (this.aUC != null) {
            frsHotThreadRequestCacheMessage.setTag(this.aUC);
        }
        MessageManager.getInstance().sendMessage(frsHotThreadRequestCacheMessage);
    }

    private void abK() {
        if (this.aUE != null) {
            if (this.bRH == null || this.bRH.size() == 0) {
                this.bRG.bJl = false;
            } else {
                this.bRG.bJl = true;
            }
            this.aUE.a(2, 0, this.bRG, this.bRH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        if (!this.bRF) {
            RequestFrsHotThreadMessage requestFrsHotThreadMessage = new RequestFrsHotThreadMessage(j, this.bRG.pn);
            if (this.aUC != null) {
                requestFrsHotThreadMessage.setTag(this.aUC);
            }
            MessageManager.getInstance().sendMessage(requestFrsHotThreadMessage);
            this.bRF = true;
        }
    }

    private void registerListener() {
        if (this.aUC != null) {
            this.bRI.setTag(this.aUC);
            this.btt.setTag(this.aUC);
            if (this.btt.getHttpMessageListener() != null) {
                this.btt.getHttpMessageListener().setSelfListener(true);
            }
            if (this.btt.getSocketMessageListener() != null) {
                this.btt.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.btt);
        MessageManager.getInstance().registerListener(this.bRI);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.btt);
        MessageManager.getInstance().unRegisterListener(this.bRI);
    }

    private void DL() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
