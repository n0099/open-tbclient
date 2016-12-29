package com.baidu.tieba.frs.hot;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.co;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements cd {
    private ce bLp;
    private BdUniqueId bbl;
    private boolean bLm = false;
    private boolean bwm = true;
    private boolean bLn = false;
    private int bLo = 0;
    private co bLq = new co();
    private final ArrayList<v> bLr = new ArrayList<>();
    private com.baidu.adp.framework.listener.a bgr = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener bLs = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bbl = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(int i, int i2, cl clVar) {
        if (i == 2 && clVar != null) {
            if (clVar.pn == -1) {
                clVar.pn = 1;
                this.bLn = true;
            } else {
                this.bLn = false;
            }
            if (this.bwm) {
                this.bLq.forumId = clVar.forumId;
                this.bLq.pn = clVar.pn;
                iu(clVar.forumId);
            } else if (clVar.pn == this.bLo && !this.bLn) {
                aaE();
            } else {
                b(com.baidu.adp.lib.h.b.c(clVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(ce ceVar) {
        this.bLp = ceVar;
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
        registerListener();
        DQ();
    }

    @Override // com.baidu.tieba.frs.cd
    public void VI() {
        unRegisterListener();
    }

    private void iu(String str) {
        FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = new FrsHotThreadRequestCacheMessage(str);
        if (this.bbl != null) {
            frsHotThreadRequestCacheMessage.setTag(this.bbl);
        }
        MessageManager.getInstance().sendMessage(frsHotThreadRequestCacheMessage);
    }

    private void aaE() {
        if (this.bLp != null) {
            if (this.bLr == null || this.bLr.size() == 0) {
                this.bLq.bBT = false;
            } else {
                this.bLq.bBT = true;
            }
            this.bLp.a(2, 0, this.bLq, this.bLr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        if (!this.bLm) {
            RequestFrsHotThreadMessage requestFrsHotThreadMessage = new RequestFrsHotThreadMessage(j, this.bLq.pn);
            if (this.bbl != null) {
                requestFrsHotThreadMessage.setTag(this.bbl);
            }
            MessageManager.getInstance().sendMessage(requestFrsHotThreadMessage);
            this.bLm = true;
        }
    }

    private void registerListener() {
        if (this.bbl != null) {
            this.bLs.setTag(this.bbl);
            this.bgr.setTag(this.bbl);
            if (this.bgr.ch() != null) {
                this.bgr.ch().setSelfListener(true);
            }
            if (this.bgr.ci() != null) {
                this.bgr.ci().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.bgr);
        MessageManager.getInstance().registerListener(this.bLs);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bgr);
        MessageManager.getInstance().unRegisterListener(this.bLs);
    }

    private void DQ() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
