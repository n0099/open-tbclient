package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ee;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements ea {
    private eb bay;
    private boolean aRk = true;
    private boolean baw = false;
    private int bax = 0;
    private ee baz = new ee();
    private final ArrayList<u> baA = new ArrayList<>();
    private com.baidu.adp.framework.listener.a aQV = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener baB = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    @Override // com.baidu.tieba.frs.ea
    public void a(int i, int i2, ec ecVar) {
        if (i == 2 && ecVar != null) {
            if (ecVar.pn == -1) {
                ecVar.pn = 1;
                this.baw = true;
            } else {
                this.baw = false;
            }
            if (this.aRk) {
                this.baz.forumId = ecVar.forumId;
                this.baz.pn = ecVar.pn;
                gK(ecVar.forumId);
            } else if (ecVar.pn == this.bax && !this.baw) {
                MU();
            } else {
                a(com.baidu.adp.lib.g.b.c(ecVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(eb ebVar) {
        this.bay = ebVar;
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
        registerListener();
        BW();
    }

    @Override // com.baidu.tieba.frs.ea
    public void Kq() {
        unRegisterListener();
    }

    private void gK(String str) {
        MessageManager.getInstance().sendMessage(new FrsHotThreadRequestCacheMessage(str));
    }

    private void MU() {
        if (this.bay != null) {
            if (this.baA == null || this.baA.size() == 0) {
                this.baz.aZb = false;
            } else {
                this.baz.aZb = true;
            }
            this.bay.a(2, 0, this.baz, this.baA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        MessageManager.getInstance().sendMessage(new RequestFrsHotThreadMessage(j, this.baz.pn));
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aQV);
        MessageManager.getInstance().registerListener(this.baB);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aQV);
        MessageManager.getInstance().unRegisterListener(this.baB);
    }

    private void BW() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
