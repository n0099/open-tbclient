package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class s extends w {
    private final CustomMessageListener alT;
    private boolean cbv;
    private String cbw;
    private bl ceM;
    private PraiseModel ceN;

    public s(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.alT = new t(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.bTw.registerListener(this.alT);
        this.ceN = adh();
    }

    public final PraiseModel adh() {
        if (this.ceN == null) {
            this.ceN = new PraiseModel(this.bTw.getPageContext(), new u(this));
        }
        return this.ceN;
    }

    public void iC(int i) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        com.baidu.tieba.tbadkCore.n aau = this.bTw.aau();
        if (aau != null && this.bUa != null && (threadList = aau.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof bl) {
                    bl blVar = (bl) next;
                    if (blVar == this.ceM) {
                        c(blVar, i);
                        this.ceM = null;
                        break;
                    } else if (blVar.getId() != null && blVar.getId().equals(this.cbw)) {
                        c(blVar, i);
                        this.cbw = null;
                        break;
                    }
                }
            }
            this.bUa.aaR().b(threadList, aau);
            this.bUa.aaR().notifyDataSetChanged();
        }
    }

    public void c(bl blVar, int i) {
        if (blVar != null) {
            if (i == 1) {
                PraiseData rk = blVar.rk();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rk == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        blVar.a(praiseData);
                        return;
                    }
                    blVar.rk().getUser().add(0, metaData);
                    blVar.rk().setNum(blVar.rk().getNum() + 1);
                    blVar.rk().setIsLike(i);
                }
            } else if (blVar.rk() != null) {
                blVar.rk().setIsLike(i);
                blVar.rk().setNum(blVar.rk().getNum() - 1);
                ArrayList<MetaData> user = blVar.rk().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            blVar.rk().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void ev(boolean z) {
        this.cbv = z;
    }
}
