package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.frs.eg;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements ec {
    private ed baR;
    private boolean aRs = true;
    private boolean baP = false;
    private int baQ = 0;
    private eg baS = new eg();
    private final ArrayList<u> baT = new ArrayList<>();
    private com.baidu.adp.framework.listener.a aRd = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener baU = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    @Override // com.baidu.tieba.frs.ec
    public void a(int i, int i2, ee eeVar) {
        if (i == 2 && eeVar != null) {
            if (eeVar.pn == -1) {
                eeVar.pn = 1;
                this.baP = true;
            } else {
                this.baP = false;
            }
            if (this.aRs) {
                this.baS.forumId = eeVar.forumId;
                this.baS.pn = eeVar.pn;
                gM(eeVar.forumId);
            } else if (eeVar.pn == this.baQ && !this.baP) {
                Nm();
            } else {
                a(com.baidu.adp.lib.g.b.c(eeVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(ed edVar) {
        this.baR = edVar;
    }

    @Override // com.baidu.tieba.frs.ec
    public void init() {
        registerListener();
        BP();
    }

    @Override // com.baidu.tieba.frs.ec
    public void KG() {
        unRegisterListener();
    }

    private void gM(String str) {
        MessageManager.getInstance().sendMessage(new FrsHotThreadRequestCacheMessage(str));
    }

    private void Nm() {
        if (this.baR != null) {
            if (this.baT == null || this.baT.size() == 0) {
                this.baS.aZn = false;
            } else {
                this.baS.aZn = true;
            }
            this.baR.a(2, 0, this.baS, this.baT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        MessageManager.getInstance().sendMessage(new RequestFrsHotThreadMessage(j, this.baS.pn));
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aRd);
        MessageManager.getInstance().registerListener(this.baU);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aRd);
        MessageManager.getInstance().unRegisterListener(this.baU);
    }

    private void BP() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
