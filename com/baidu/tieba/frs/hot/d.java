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
    private eb bam;
    private boolean aQZ = true;
    private boolean bak = false;
    private int bal = 0;
    private ee ban = new ee();
    private final ArrayList<u> bao = new ArrayList<>();
    private com.baidu.adp.framework.listener.a aQK = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener bap = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    @Override // com.baidu.tieba.frs.ea
    public void a(int i, int i2, ec ecVar) {
        if (i == 2 && ecVar != null) {
            if (ecVar.pn == -1) {
                ecVar.pn = 1;
                this.bak = true;
            } else {
                this.bak = false;
            }
            if (this.aQZ) {
                this.ban.forumId = ecVar.forumId;
                this.ban.pn = ecVar.pn;
                gK(ecVar.forumId);
            } else if (ecVar.pn == this.bal && !this.bak) {
                MY();
            } else {
                c(com.baidu.adp.lib.g.b.c(ecVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(eb ebVar) {
        this.bam = ebVar;
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
        registerListener();
        BZ();
    }

    @Override // com.baidu.tieba.frs.ea
    public void Ku() {
        unRegisterListener();
    }

    private void gK(String str) {
        MessageManager.getInstance().sendMessage(new FrsHotThreadRequestCacheMessage(str));
    }

    private void MY() {
        if (this.bam != null) {
            if (this.bao == null || this.bao.size() == 0) {
                this.ban.aYQ = false;
            } else {
                this.ban.aYQ = true;
            }
            this.bam.a(2, 0, this.ban, this.bao);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, boolean z) {
        MessageManager.getInstance().sendMessage(new RequestFrsHotThreadMessage(j, this.ban.pn));
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aQK);
        MessageManager.getInstance().registerListener(this.bap);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aQK);
        MessageManager.getInstance().unRegisterListener(this.bap);
    }

    private void BZ() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
