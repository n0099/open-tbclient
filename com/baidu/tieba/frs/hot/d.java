package com.baidu.tieba.frs.hot;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.dl;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.ds;
import com.baidu.tieba.frs.dv;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements dl {
    private BdUniqueId aSq;
    private dm bPl;
    private boolean bzB = true;
    private boolean bPj = false;
    private int bPk = 0;
    private dv bPm = new dv();
    private final ArrayList<v> bPn = new ArrayList<>();
    private com.baidu.adp.framework.listener.a aWP = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener bPo = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aSq = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(int i, int i2, ds dsVar) {
        if (i == 2 && dsVar != null) {
            if (dsVar.pn == -1) {
                dsVar.pn = 1;
                this.bPj = true;
            } else {
                this.bPj = false;
            }
            if (this.bzB) {
                this.bPm.forumId = dsVar.forumId;
                this.bPm.pn = dsVar.pn;
                iP(dsVar.forumId);
            } else if (dsVar.pn == this.bPk && !this.bPj) {
                Zw();
            } else {
                b(com.baidu.adp.lib.h.b.c(dsVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(dm dmVar) {
        this.bPl = dmVar;
    }

    @Override // com.baidu.tieba.frs.dl
    public void init() {
        registerListener();
        CJ();
    }

    @Override // com.baidu.tieba.frs.dl
    public void UC() {
        unRegisterListener();
    }

    private void iP(String str) {
        FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = new FrsHotThreadRequestCacheMessage(str);
        if (this.aSq != null) {
            frsHotThreadRequestCacheMessage.setTag(this.aSq);
        }
        MessageManager.getInstance().sendMessage(frsHotThreadRequestCacheMessage);
    }

    private void Zw() {
        if (this.bPl != null) {
            if (this.bPn == null || this.bPn.size() == 0) {
                this.bPm.bHk = false;
            } else {
                this.bPm.bHk = true;
            }
            this.bPl.a(2, 0, this.bPm, this.bPn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        RequestFrsHotThreadMessage requestFrsHotThreadMessage = new RequestFrsHotThreadMessage(j, this.bPm.pn);
        if (this.aSq != null) {
            requestFrsHotThreadMessage.setTag(this.aSq);
        }
        MessageManager.getInstance().sendMessage(requestFrsHotThreadMessage);
    }

    private void registerListener() {
        if (this.aSq != null) {
            this.bPo.setTag(this.aSq);
            this.aWP.setTag(this.aSq);
            if (this.aWP.bn() != null) {
                this.aWP.bn().setSelfListener(true);
            }
            if (this.aWP.bo() != null) {
                this.aWP.bo().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.aWP);
        MessageManager.getInstance().registerListener(this.bPo);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aWP);
        MessageManager.getInstance().unRegisterListener(this.bPo);
    }

    private void CJ() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
