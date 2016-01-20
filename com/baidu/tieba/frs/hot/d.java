package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ex;
import com.baidu.tieba.frs.ey;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements eu {
    private ev bla;
    private boolean baH = true;
    private boolean bkY = false;
    private int bkZ = 0;
    private ey blb = new ey();
    private final ArrayList<u> blc = new ArrayList<>();
    private com.baidu.adp.framework.listener.a bah = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener bld = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    @Override // com.baidu.tieba.frs.eu
    public void a(int i, int i2, ex exVar) {
        if (i == 2 && exVar != null) {
            if (exVar.pn == -1) {
                exVar.pn = 1;
                this.bkY = true;
            } else {
                this.bkY = false;
            }
            if (this.baH) {
                this.blb.forumId = exVar.forumId;
                this.blb.pn = exVar.pn;
                ho(exVar.forumId);
            } else if (exVar.pn == this.bkZ && !this.bkY) {
                Pg();
            } else {
                c(com.baidu.adp.lib.h.b.c(exVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(ev evVar) {
        this.bla = evVar;
    }

    @Override // com.baidu.tieba.frs.eu
    public void init() {
        registerListener();
        CF();
    }

    @Override // com.baidu.tieba.frs.eu
    public void My() {
        unRegisterListener();
    }

    private void ho(String str) {
        MessageManager.getInstance().sendMessage(new FrsHotThreadRequestCacheMessage(str));
    }

    private void Pg() {
        if (this.bla != null) {
            if (this.blc == null || this.blc.size() == 0) {
                this.blb.bjk = false;
            } else {
                this.blb.bjk = true;
            }
            this.bla.a(2, 0, this.blb, this.blc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, boolean z) {
        MessageManager.getInstance().sendMessage(new RequestFrsHotThreadMessage(j, this.blb.pn));
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bah);
        MessageManager.getInstance().registerListener(this.bld);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bah);
        MessageManager.getInstance().unRegisterListener(this.bld);
    }

    private void CF() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
