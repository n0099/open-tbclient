package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.fq;
import com.baidu.tieba.frs.fr;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements fo {
    private fp bsU;
    private boolean bhD = true;
    private boolean bsS = false;
    private int bsT = 0;
    private fr bsV = new fr();
    private final ArrayList<u> bsW = new ArrayList<>();
    private com.baidu.adp.framework.listener.a aXA = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener bsX = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    @Override // com.baidu.tieba.frs.fo
    public void a(int i, int i2, fq fqVar) {
        if (i == 2 && fqVar != null) {
            if (fqVar.pn == -1) {
                fqVar.pn = 1;
                this.bsS = true;
            } else {
                this.bsS = false;
            }
            if (this.bhD) {
                this.bsV.forumId = fqVar.forumId;
                this.bsV.pn = fqVar.pn;
                hE(fqVar.forumId);
            } else if (fqVar.pn == this.bsT && !this.bsS) {
                SX();
            } else {
                c(com.baidu.adp.lib.h.b.c(fqVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.fo
    public void a(fp fpVar) {
        this.bsU = fpVar;
    }

    @Override // com.baidu.tieba.frs.fo
    public void init() {
        registerListener();
        EH();
    }

    @Override // com.baidu.tieba.frs.fo
    public void Qe() {
        unRegisterListener();
    }

    private void hE(String str) {
        MessageManager.getInstance().sendMessage(new FrsHotThreadRequestCacheMessage(str));
    }

    private void SX() {
        if (this.bsU != null) {
            if (this.bsW == null || this.bsW.size() == 0) {
                this.bsV.bru = false;
            } else {
                this.bsV.bru = true;
            }
            this.bsU.a(2, 0, this.bsV, this.bsW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, boolean z) {
        MessageManager.getInstance().sendMessage(new RequestFrsHotThreadMessage(j, this.bsV.pn));
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aXA);
        MessageManager.getInstance().registerListener(this.bsX);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aXA);
        MessageManager.getInstance().unRegisterListener(this.bsX);
    }

    private void EH() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
