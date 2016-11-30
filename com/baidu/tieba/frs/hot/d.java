package com.baidu.tieba.frs.hot;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.cp;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements ce {
    private BdUniqueId bcf;
    private cf cfG;
    private boolean cfD = false;
    private boolean bQi = true;
    private boolean cfE = false;
    private int cfF = 0;
    private cp cfH = new cp();
    private final ArrayList<v> cfI = new ArrayList<>();
    private com.baidu.adp.framework.listener.a bgZ = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener cfJ = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bcf = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, cm cmVar) {
        if (i == 2 && cmVar != null) {
            if (cmVar.pn == -1) {
                cmVar.pn = 1;
                this.cfE = true;
            } else {
                this.cfE = false;
            }
            if (this.bQi) {
                this.cfH.forumId = cmVar.forumId;
                this.cfH.pn = cmVar.pn;
                jP(cmVar.forumId);
            } else if (cmVar.pn == this.cfF && !this.cfE) {
                agi();
            } else {
                b(com.baidu.adp.lib.h.b.c(cmVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(cf cfVar) {
        this.cfG = cfVar;
    }

    @Override // com.baidu.tieba.frs.ce
    public void init() {
        registerListener();
        Ei();
    }

    @Override // com.baidu.tieba.frs.ce
    public void abv() {
        unRegisterListener();
    }

    private void jP(String str) {
        FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = new FrsHotThreadRequestCacheMessage(str);
        if (this.bcf != null) {
            frsHotThreadRequestCacheMessage.setTag(this.bcf);
        }
        MessageManager.getInstance().sendMessage(frsHotThreadRequestCacheMessage);
    }

    private void agi() {
        if (this.cfG != null) {
            if (this.cfI == null || this.cfI.size() == 0) {
                this.cfH.bVL = false;
            } else {
                this.cfH.bVL = true;
            }
            this.cfG.a(2, 0, this.cfH, this.cfI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        if (!this.cfD) {
            RequestFrsHotThreadMessage requestFrsHotThreadMessage = new RequestFrsHotThreadMessage(j, this.cfH.pn);
            if (this.bcf != null) {
                requestFrsHotThreadMessage.setTag(this.bcf);
            }
            MessageManager.getInstance().sendMessage(requestFrsHotThreadMessage);
            this.cfD = true;
        }
    }

    private void registerListener() {
        if (this.bcf != null) {
            this.cfJ.setTag(this.bcf);
            this.bgZ.setTag(this.bcf);
            if (this.bgZ.ch() != null) {
                this.bgZ.ch().setSelfListener(true);
            }
            if (this.bgZ.ci() != null) {
                this.bgZ.ci().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.bgZ);
        MessageManager.getInstance().registerListener(this.cfJ);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bgZ);
        MessageManager.getInstance().unRegisterListener(this.cfJ);
    }

    private void Ei() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
