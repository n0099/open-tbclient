package com.baidu.tieba.frs.e;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends s {
    private final CustomMessageListener ahI;
    private boolean cco;
    private String ccp;
    private bk cgI;

    public p(FrsActivity frsActivity) {
        super(frsActivity);
        this.ahI = new q(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.bZY.registerListener(this.ahI);
    }

    public void im(int i) {
        ArrayList<v> threadList;
        com.baidu.tieba.tbadkCore.p acr = this.bZY.acr();
        if (acr != null && this.bRW != null && (threadList = acr.getThreadList()) != null) {
            Iterator<v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                v next = it.next();
                if (next instanceof bk) {
                    bk bkVar = (bk) next;
                    if (bkVar == this.cgI) {
                        c(bkVar, i);
                        this.cgI = null;
                        break;
                    } else if (bkVar.getId() != null && bkVar.getId().equals(this.ccp)) {
                        c(bkVar, i);
                        this.ccp = null;
                        break;
                    }
                }
            }
            this.bRW.ade().b(threadList, acr);
            this.bRW.ade().notifyDataSetChanged();
        }
    }

    public void c(bk bkVar, int i) {
        if (bkVar != null) {
            if (i == 1) {
                PraiseData rH = bkVar.rH();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rH == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bkVar.a(praiseData);
                        return;
                    }
                    bkVar.rH().getUser().add(0, metaData);
                    bkVar.rH().setNum(bkVar.rH().getNum() + 1);
                    bkVar.rH().setIsLike(i);
                }
            } else if (bkVar.rH() != null) {
                bkVar.rH().setIsLike(i);
                bkVar.rH().setNum(bkVar.rH().getNum() - 1);
                ArrayList<MetaData> user = bkVar.rH().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bkVar.rH().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void es(boolean z) {
        this.cco = z;
    }
}
