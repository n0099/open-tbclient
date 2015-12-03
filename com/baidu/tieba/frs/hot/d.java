package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ew;
import com.baidu.tieba.frs.ey;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements et {
    private eu bhj;
    private boolean aWG = true;
    private boolean bhh = false;
    private int bhi = 0;
    private ey bhk = new ey();
    private final ArrayList<u> bhl = new ArrayList<>();
    private com.baidu.adp.framework.listener.a aWh = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener bhm = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    @Override // com.baidu.tieba.frs.et
    public void a(int i, int i2, ew ewVar) {
        if (i == 2 && ewVar != null) {
            if (ewVar.pn == -1) {
                ewVar.pn = 1;
                this.bhh = true;
            } else {
                this.bhh = false;
            }
            if (this.aWG) {
                this.bhk.forumId = ewVar.forumId;
                this.bhk.pn = ewVar.pn;
                hd(ewVar.forumId);
            } else if (ewVar.pn == this.bhi && !this.bhh) {
                OO();
            } else {
                c(com.baidu.adp.lib.h.b.c(ewVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.et
    public void a(eu euVar) {
        this.bhj = euVar;
    }

    @Override // com.baidu.tieba.frs.et
    public void init() {
        registerListener();
        CQ();
    }

    @Override // com.baidu.tieba.frs.et
    public void Mf() {
        unRegisterListener();
    }

    private void hd(String str) {
        MessageManager.getInstance().sendMessage(new FrsHotThreadRequestCacheMessage(str));
    }

    private void OO() {
        if (this.bhj != null) {
            if (this.bhl == null || this.bhl.size() == 0) {
                this.bhk.bfs = false;
            } else {
                this.bhk.bfs = true;
            }
            this.bhj.a(2, 0, this.bhk, this.bhl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, boolean z) {
        MessageManager.getInstance().sendMessage(new RequestFrsHotThreadMessage(j, this.bhk.pn));
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aWh);
        MessageManager.getInstance().registerListener(this.bhm);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aWh);
        MessageManager.getInstance().unRegisterListener(this.bhm);
    }

    private void CQ() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
