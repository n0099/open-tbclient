package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.PraiseModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class q extends u {
    private final CustomMessageListener alP;
    private boolean bVr;
    private String bVs;
    private bj bZQ;
    private PraiseModel bZR;

    public q(FrsActivity frsActivity) {
        super(frsActivity);
        this.alP = new r(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.bTf.registerListener(this.alP);
        this.bZR = ade();
    }

    public final PraiseModel ade() {
        if (this.bZR == null) {
            this.bZR = new PraiseModel(this.bTf.getPageContext(), new s(this));
        }
        return this.bZR;
    }

    /* renamed from: if  reason: not valid java name */
    public void m14if(int i) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        com.baidu.tieba.tbadkCore.n YV = this.bTf.YV();
        if (YV != null && this.bMN != null && (threadList = YV.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof bj) {
                    bj bjVar = (bj) next;
                    if (bjVar == this.bZQ) {
                        c(bjVar, i);
                        this.bZQ = null;
                        break;
                    } else if (bjVar.getId() != null && bjVar.getId().equals(this.bVs)) {
                        c(bjVar, i);
                        this.bVs = null;
                        break;
                    }
                }
            }
            this.bMN.ZG().b(threadList, YV);
            this.bMN.ZG().notifyDataSetChanged();
        }
    }

    public void c(bj bjVar, int i) {
        if (bjVar != null) {
            if (i == 1) {
                PraiseData rG = bjVar.rG();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rG == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bjVar.a(praiseData);
                        return;
                    }
                    bjVar.rG().getUser().add(0, metaData);
                    bjVar.rG().setNum(bjVar.rG().getNum() + 1);
                    bjVar.rG().setIsLike(i);
                }
            } else if (bjVar.rG() != null) {
                bjVar.rG().setIsLike(i);
                bjVar.rG().setNum(bjVar.rG().getNum() - 1);
                ArrayList<MetaData> user = bjVar.rG().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bjVar.rG().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void eh(boolean z) {
        this.bVr = z;
    }
}
