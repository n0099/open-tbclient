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
    private BdUniqueId baP;
    private cc baR;
    private boolean bYN = false;
    private boolean bKX = true;
    private boolean aPy = false;
    private int mCurrentPage = 0;
    private cm bYO = new cm();
    private final ArrayList<v> bYP = new ArrayList<>();
    private com.baidu.adp.framework.listener.a bAB = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener bYQ = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.baP = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(int i, int i2, cj cjVar) {
        if (i == 2 && cjVar != null) {
            if (cjVar.pn == -1) {
                cjVar.pn = 1;
                this.aPy = true;
            } else {
                this.aPy = false;
            }
            if (this.bKX) {
                this.bYO.forumId = cjVar.forumId;
                this.bYO.pn = cjVar.pn;
                iA(cjVar.forumId);
            } else if (cjVar.pn == this.mCurrentPage && !this.aPy) {
                acH();
            } else {
                b(com.baidu.adp.lib.g.b.c(cjVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(cc ccVar) {
        this.baR = ccVar;
    }

    @Override // com.baidu.tieba.frs.cb
    public void init() {
        registerListener();
        Ee();
    }

    @Override // com.baidu.tieba.frs.cb
    public void MQ() {
        unRegisterListener();
    }

    private void iA(String str) {
        FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = new FrsHotThreadRequestCacheMessage(str);
        if (this.baP != null) {
            frsHotThreadRequestCacheMessage.setTag(this.baP);
        }
        MessageManager.getInstance().sendMessage(frsHotThreadRequestCacheMessage);
    }

    private void acH() {
        if (this.baR != null) {
            if (this.bYP == null || this.bYP.size() == 0) {
                this.bYO.bQu = false;
            } else {
                this.bYO.bQu = true;
            }
            this.baR.a(2, 0, this.bYO, this.bYP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        if (!this.bYN) {
            RequestFrsHotThreadMessage requestFrsHotThreadMessage = new RequestFrsHotThreadMessage(j, this.bYO.pn);
            if (this.baP != null) {
                requestFrsHotThreadMessage.setTag(this.baP);
            }
            MessageManager.getInstance().sendMessage(requestFrsHotThreadMessage);
            this.bYN = true;
        }
    }

    private void registerListener() {
        if (this.baP != null) {
            this.bYQ.setTag(this.baP);
            this.bAB.setTag(this.baP);
            if (this.bAB.getHttpMessageListener() != null) {
                this.bAB.getHttpMessageListener().setSelfListener(true);
            }
            if (this.bAB.getSocketMessageListener() != null) {
                this.bAB.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.bAB);
        MessageManager.getInstance().registerListener(this.bYQ);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bAB);
        MessageManager.getInstance().unRegisterListener(this.bYQ);
    }

    private void Ee() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
