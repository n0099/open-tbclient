package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.frs.dl;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements dh {
    private di bau;
    private boolean aSd = true;
    private boolean bas = false;
    private int bat = 0;
    private dl bav = new dl();
    private final ArrayList<u> baw = new ArrayList<>();
    private com.baidu.adp.framework.listener.a aRO = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener bax = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    @Override // com.baidu.tieba.frs.dh
    public void a(int i, int i2, dj djVar) {
        if (i == 2 && djVar != null) {
            if (djVar.pn == -1) {
                djVar.pn = 1;
                this.bas = true;
            } else {
                this.bas = false;
            }
            if (this.aSd) {
                this.bav.forumId = djVar.forumId;
                this.bav.pn = djVar.pn;
                gH(djVar.forumId);
            } else if (djVar.pn == this.bat && !this.bas) {
                MZ();
            } else {
                a(com.baidu.adp.lib.g.b.c(djVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(di diVar) {
        this.bau = diVar;
    }

    @Override // com.baidu.tieba.frs.dh
    public void init() {
        registerListener();
        Cm();
    }

    @Override // com.baidu.tieba.frs.dh
    public void Kz() {
        unRegisterListener();
    }

    private void gH(String str) {
        MessageManager.getInstance().sendMessage(new FrsHotThreadRequestCacheMessage(str));
    }

    private void MZ() {
        if (this.bau != null) {
            if (this.baw == null || this.baw.size() == 0) {
                this.bav.aZb = false;
            } else {
                this.bav.aZb = true;
            }
            this.bau.a(2, 0, this.bav, this.baw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        MessageManager.getInstance().sendMessage(new RequestFrsHotThreadMessage(j, this.bav.pn));
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aRO);
        MessageManager.getInstance().registerListener(this.bax);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aRO);
        MessageManager.getInstance().unRegisterListener(this.bax);
    }

    private void Cm() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
