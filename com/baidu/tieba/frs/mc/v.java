package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class v extends z {
    private final CustomMessageListener amL;
    private boolean cjG;
    private String cjH;
    private bm cnb;
    private PraiseModel cnc;

    public v(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.amL = new w(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.cbE.registerListener(this.amL);
        this.cnc = aha();
    }

    public final PraiseModel aha() {
        if (this.cnc == null) {
            this.cnc = new PraiseModel(this.cbE.getPageContext(), new x(this));
        }
        return this.cnc;
    }

    public void iO(int i) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        com.baidu.tieba.tbadkCore.n aek = this.cbE.aek();
        if (aek != null && this.ccj != null && (threadList = aek.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof bm) {
                    bm bmVar = (bm) next;
                    if (bmVar == this.cnb) {
                        c(bmVar, i);
                        this.cnb = null;
                        break;
                    } else if (bmVar.getId() != null && bmVar.getId().equals(this.cjH)) {
                        c(bmVar, i);
                        this.cjH = null;
                        break;
                    }
                }
            }
            this.ccj.aeI().b(threadList, aek);
            this.ccj.aeI().notifyDataSetChanged();
        }
    }

    public void c(bm bmVar, int i) {
        if (bmVar != null) {
            if (i == 1) {
                PraiseData rh = bmVar.rh();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rh == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bmVar.a(praiseData);
                        return;
                    }
                    bmVar.rh().getUser().add(0, metaData);
                    bmVar.rh().setNum(bmVar.rh().getNum() + 1);
                    bmVar.rh().setIsLike(i);
                }
            } else if (bmVar.rh() != null) {
                bmVar.rh().setIsLike(i);
                bmVar.rh().setNum(bmVar.rh().getNum() - 1);
                ArrayList<MetaData> user = bmVar.rh().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bmVar.rh().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void eN(boolean z) {
        this.cjG = z;
    }
}
