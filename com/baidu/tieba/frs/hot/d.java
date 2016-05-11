package com.baidu.tieba.frs.hot;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.fg;
import com.baidu.tieba.frs.fi;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fq;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements fg {
    private BdUniqueId aOT;
    private fi brI;
    private boolean bdy = true;
    private boolean brG = false;
    private int brH = 0;
    private fq brJ = new fq();
    private final ArrayList<v> brK = new ArrayList<>();
    private com.baidu.adp.framework.listener.a aTu = new e(this, CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
    private CustomMessageListener brL = new f(this, CmdConfigCustom.CMD_FRS_HOT_CACHE);

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aOT = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.fg
    public void a(int i, int i2, fo foVar) {
        if (i == 2 && foVar != null) {
            if (foVar.pn == -1) {
                foVar.pn = 1;
                this.brG = true;
            } else {
                this.brG = false;
            }
            if (this.bdy) {
                this.brJ.forumId = foVar.forumId;
                this.brJ.pn = foVar.pn;
                hE(foVar.forumId);
            } else if (foVar.pn == this.brH && !this.brG) {
                Tj();
            } else {
                b(com.baidu.adp.lib.h.b.c(foVar.forumId, 0L), true);
            }
        }
    }

    @Override // com.baidu.tieba.frs.fg
    public void a(fi fiVar) {
        this.brI = fiVar;
    }

    @Override // com.baidu.tieba.frs.fg
    public void init() {
        registerListener();
        CA();
    }

    @Override // com.baidu.tieba.frs.fg
    public void OY() {
        unRegisterListener();
    }

    private void hE(String str) {
        FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = new FrsHotThreadRequestCacheMessage(str);
        if (this.aOT != null) {
            frsHotThreadRequestCacheMessage.setTag(this.aOT);
        }
        MessageManager.getInstance().sendMessage(frsHotThreadRequestCacheMessage);
    }

    private void Tj() {
        if (this.brI != null) {
            if (this.brK == null || this.brK.size() == 0) {
                this.brJ.bmV = false;
            } else {
                this.brJ.bmV = true;
            }
            this.brI.a(2, 0, this.brJ, this.brK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        RequestFrsHotThreadMessage requestFrsHotThreadMessage = new RequestFrsHotThreadMessage(j, this.brJ.pn);
        if (this.aOT != null) {
            requestFrsHotThreadMessage.setTag(this.aOT);
        }
        MessageManager.getInstance().sendMessage(requestFrsHotThreadMessage);
    }

    private void registerListener() {
        if (this.aOT != null) {
            this.brL.setTag(this.aOT);
            this.aTu.setTag(this.aOT);
            if (this.aTu.bm() != null) {
                this.aTu.bm().setSelfListener(true);
            }
            if (this.aTu.bn() != null) {
                this.aTu.bn().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.aTu);
        MessageManager.getInstance().registerListener(this.brL);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aTu);
        MessageManager.getInstance().unRegisterListener(this.brL);
    }

    private void CA() {
        com.baidu.tieba.tbadkCore.a.a.a(301003, ResponsedFrsHotSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301003, CmdConfigHttp.FRS_HOT_TAB_CMD, TbConfig.GET_FRS_HOT, ResponsedFrsHotHttpMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_HOT_CACHE, b.class);
    }
}
