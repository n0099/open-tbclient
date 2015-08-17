package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.frs.df;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements db {
    private dc aZZ;
    private boolean aRP = true;
    private boolean aZX = false;
    private int aZY = 0;
    private df baa = new df();
    private final ArrayList<u> bab = new ArrayList<>();
    private com.baidu.adp.framework.listener.a aRA = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener bac = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    @Override // com.baidu.tieba.frs.db
    public void a(int i, int i2, de deVar) {
        if (i == 2 && deVar != null) {
            if (deVar.pn == -1) {
                deVar.pn = 1;
                this.aZX = true;
            } else {
                this.aZX = false;
            }
            if (this.aRP) {
                this.baa.forumId = deVar.forumId;
                this.baa.pn = deVar.pn;
                gA(deVar.forumId);
            } else if (deVar.pn == this.aZY && !this.aZX) {
                MY();
            } else {
                a(com.baidu.adp.lib.g.b.c(deVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.db
    public void a(dc dcVar) {
        this.aZZ = dcVar;
    }

    @Override // com.baidu.tieba.frs.db
    public void init() {
        registerListener();
        BY();
    }

    @Override // com.baidu.tieba.frs.db
    public void KL() {
        unRegisterListener();
    }

    private void gA(String str) {
        MessageManager.getInstance().sendMessage(new FrsHotThreadRequestCacheMessage(str));
    }

    private void MY() {
        if (this.aZZ != null) {
            if (this.bab == null || this.bab.size() == 0) {
                this.baa.aYJ = false;
            } else {
                this.baa.aYJ = true;
            }
            this.aZZ.a(2, 0, this.baa, this.bab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        MessageManager.getInstance().sendMessage(new RequestFrsHotThreadMessage(j, this.baa.pn));
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aRA);
        MessageManager.getInstance().registerListener(this.bac);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aRA);
        MessageManager.getInstance().unRegisterListener(this.bac);
    }

    private void BY() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
