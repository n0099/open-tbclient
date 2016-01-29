package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.fe;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.fh;
import com.baidu.tieba.frs.fi;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements fe {
    private ff bnX;
    private boolean bcS = true;
    private boolean bnV = false;
    private int bnW = 0;
    private fi bnY = new fi();
    private final ArrayList<u> bnZ = new ArrayList<>();
    private com.baidu.adp.framework.listener.a aTO = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener boa = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    @Override // com.baidu.tieba.frs.fe
    public void a(int i, int i2, fh fhVar) {
        if (i == 2 && fhVar != null) {
            if (fhVar.pn == -1) {
                fhVar.pn = 1;
                this.bnV = true;
            } else {
                this.bnV = false;
            }
            if (this.bcS) {
                this.bnY.forumId = fhVar.forumId;
                this.bnY.pn = fhVar.pn;
                ho(fhVar.forumId);
            } else if (fhVar.pn == this.bnW && !this.bnV) {
                Rk();
            } else {
                c(com.baidu.adp.lib.h.b.c(fhVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(ff ffVar) {
        this.bnX = ffVar;
    }

    @Override // com.baidu.tieba.frs.fe
    public void init() {
        registerListener();
        DW();
    }

    @Override // com.baidu.tieba.frs.fe
    public void Op() {
        unRegisterListener();
    }

    private void ho(String str) {
        MessageManager.getInstance().sendMessage(new FrsHotThreadRequestCacheMessage(str));
    }

    private void Rk() {
        if (this.bnX != null) {
            if (this.bnZ == null || this.bnZ.size() == 0) {
                this.bnY.bmf = false;
            } else {
                this.bnY.bmf = true;
            }
            this.bnX.a(2, 0, this.bnY, this.bnZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, boolean z) {
        MessageManager.getInstance().sendMessage(new RequestFrsHotThreadMessage(j, this.bnY.pn));
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aTO);
        MessageManager.getInstance().registerListener(this.boa);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aTO);
        MessageManager.getInstance().unRegisterListener(this.boa);
    }

    private void DW() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
