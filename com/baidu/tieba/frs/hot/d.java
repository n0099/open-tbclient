package com.baidu.tieba.frs.hot;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.frs.dq;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements dg {
    private BdUniqueId aYW;
    private dh ccj;
    private boolean bNp = true;
    private boolean cch = false;
    private int cci = 0;
    private dq cck = new dq();
    private final ArrayList<v> ccl = new ArrayList<>();
    private com.baidu.adp.framework.listener.a bdZ = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener ccm = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aYW = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(int i, int i2, dn dnVar) {
        if (i == 2 && dnVar != null) {
            if (dnVar.pn == -1) {
                dnVar.pn = 1;
                this.cch = true;
            } else {
                this.cch = false;
            }
            if (this.bNp) {
                this.cck.forumId = dnVar.forumId;
                this.cck.pn = dnVar.pn;
                jL(dnVar.forumId);
            } else if (dnVar.pn == this.cci && !this.cch) {
                aeQ();
            } else {
                b(com.baidu.adp.lib.h.b.c(dnVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(dh dhVar) {
        this.ccj = dhVar;
    }

    @Override // com.baidu.tieba.frs.dg
    public void init() {
        registerListener();
        Ed();
    }

    @Override // com.baidu.tieba.frs.dg
    public void aat() {
        unRegisterListener();
    }

    private void jL(String str) {
        FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = new FrsHotThreadRequestCacheMessage(str);
        if (this.aYW != null) {
            frsHotThreadRequestCacheMessage.setTag(this.aYW);
        }
        MessageManager.getInstance().sendMessage(frsHotThreadRequestCacheMessage);
    }

    private void aeQ() {
        if (this.ccj != null) {
            if (this.ccl == null || this.ccl.size() == 0) {
                this.cck.bTB = false;
            } else {
                this.cck.bTB = true;
            }
            this.ccj.a(2, 0, this.cck, this.ccl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        RequestFrsHotThreadMessage requestFrsHotThreadMessage = new RequestFrsHotThreadMessage(j, this.cck.pn);
        if (this.aYW != null) {
            requestFrsHotThreadMessage.setTag(this.aYW);
        }
        MessageManager.getInstance().sendMessage(requestFrsHotThreadMessage);
    }

    private void registerListener() {
        if (this.aYW != null) {
            this.ccm.setTag(this.aYW);
            this.bdZ.setTag(this.aYW);
            if (this.bdZ.ch() != null) {
                this.bdZ.ch().setSelfListener(true);
            }
            if (this.bdZ.ci() != null) {
                this.bdZ.ci().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.bdZ);
        MessageManager.getInstance().registerListener(this.ccm);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bdZ);
        MessageManager.getInstance().unRegisterListener(this.ccm);
    }

    private void Ed() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
