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
    private BdUniqueId aTm;
    private dm bQY;
    private boolean bBP = true;
    private boolean bQW = false;
    private int bQX = 0;
    private dv bQZ = new dv();
    private final ArrayList<v> bRa = new ArrayList<>();
    private com.baidu.adp.framework.listener.a aXN = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener bRb = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aTm = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(int i, int i2, ds dsVar) {
        if (i == 2 && dsVar != null) {
            if (dsVar.pn == -1) {
                dsVar.pn = 1;
                this.bQW = true;
            } else {
                this.bQW = false;
            }
            if (this.bBP) {
                this.bQZ.forumId = dsVar.forumId;
                this.bQZ.pn = dsVar.pn;
                iV(dsVar.forumId);
            } else if (dsVar.pn == this.bQX && !this.bQW) {
                ZS();
            } else {
                b(com.baidu.adp.lib.h.b.c(dsVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(dm dmVar) {
        this.bQY = dmVar;
    }

    @Override // com.baidu.tieba.frs.dl
    public void init() {
        registerListener();
        CI();
    }

    @Override // com.baidu.tieba.frs.dl
    public void Vk() {
        unRegisterListener();
    }

    private void iV(String str) {
        FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = new FrsHotThreadRequestCacheMessage(str);
        if (this.aTm != null) {
            frsHotThreadRequestCacheMessage.setTag(this.aTm);
        }
        MessageManager.getInstance().sendMessage(frsHotThreadRequestCacheMessage);
    }

    private void ZS() {
        if (this.bQY != null) {
            if (this.bRa == null || this.bRa.size() == 0) {
                this.bQZ.bIG = false;
            } else {
                this.bQZ.bIG = true;
            }
            this.bQY.a(2, 0, this.bQZ, this.bRa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        RequestFrsHotThreadMessage requestFrsHotThreadMessage = new RequestFrsHotThreadMessage(j, this.bQZ.pn);
        if (this.aTm != null) {
            requestFrsHotThreadMessage.setTag(this.aTm);
        }
        MessageManager.getInstance().sendMessage(requestFrsHotThreadMessage);
    }

    private void registerListener() {
        if (this.aTm != null) {
            this.bRb.setTag(this.aTm);
            this.aXN.setTag(this.aTm);
            if (this.aXN.bm() != null) {
                this.aXN.bm().setSelfListener(true);
            }
            if (this.aXN.bn() != null) {
                this.aXN.bn().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.aXN);
        MessageManager.getInstance().registerListener(this.bRb);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aXN);
        MessageManager.getInstance().unRegisterListener(this.bRb);
    }

    private void CI() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
