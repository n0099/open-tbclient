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
    private BdUniqueId aYu;
    private dh cch;
    private boolean bNs = true;
    private boolean ccf = false;
    private int ccg = 0;
    private dq cci = new dq();
    private final ArrayList<v> ccj = new ArrayList<>();
    private com.baidu.adp.framework.listener.a bdG = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener cck = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aYu = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(int i, int i2, dn dnVar) {
        if (i == 2 && dnVar != null) {
            if (dnVar.pn == -1) {
                dnVar.pn = 1;
                this.ccf = true;
            } else {
                this.ccf = false;
            }
            if (this.bNs) {
                this.cci.forumId = dnVar.forumId;
                this.cci.pn = dnVar.pn;
                jE(dnVar.forumId);
            } else if (dnVar.pn == this.ccg && !this.ccf) {
                aeC();
            } else {
                b(com.baidu.adp.lib.h.b.c(dnVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(dh dhVar) {
        this.cch = dhVar;
    }

    @Override // com.baidu.tieba.frs.dg
    public void init() {
        registerListener();
        Ed();
    }

    @Override // com.baidu.tieba.frs.dg
    public void aaf() {
        unRegisterListener();
    }

    private void jE(String str) {
        FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = new FrsHotThreadRequestCacheMessage(str);
        if (this.aYu != null) {
            frsHotThreadRequestCacheMessage.setTag(this.aYu);
        }
        MessageManager.getInstance().sendMessage(frsHotThreadRequestCacheMessage);
    }

    private void aeC() {
        if (this.cch != null) {
            if (this.ccj == null || this.ccj.size() == 0) {
                this.cci.bTI = false;
            } else {
                this.cci.bTI = true;
            }
            this.cch.a(2, 0, this.cci, this.ccj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        RequestFrsHotThreadMessage requestFrsHotThreadMessage = new RequestFrsHotThreadMessage(j, this.cci.pn);
        if (this.aYu != null) {
            requestFrsHotThreadMessage.setTag(this.aYu);
        }
        MessageManager.getInstance().sendMessage(requestFrsHotThreadMessage);
    }

    private void registerListener() {
        if (this.aYu != null) {
            this.cck.setTag(this.aYu);
            this.bdG.setTag(this.aYu);
            if (this.bdG.ch() != null) {
                this.bdG.ch().setSelfListener(true);
            }
            if (this.bdG.ci() != null) {
                this.bdG.ci().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.bdG);
        MessageManager.getInstance().registerListener(this.cck);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bdG);
        MessageManager.getInstance().unRegisterListener(this.cck);
    }

    private void Ed() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
