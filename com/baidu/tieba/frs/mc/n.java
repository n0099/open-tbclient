package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.PraiseModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class n extends r {
    private final CustomMessageListener agw;
    private boolean bOj;
    private String bOk;
    private bh bSE;
    private PraiseModel bSF;

    public n(FrsActivity frsActivity) {
        super(frsActivity);
        this.agw = new o(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.bLZ.registerListener(this.agw);
        this.bSF = ach();
    }

    public final PraiseModel ach() {
        if (this.bSF == null) {
            this.bSF = new PraiseModel(this.bLZ.getPageContext(), new p(this));
        }
        return this.bSF;
    }

    public void ij(int i) {
        ArrayList<v> threadList;
        com.baidu.tieba.tbadkCore.n XW = this.bLZ.XW();
        if (XW != null && this.bFF != null && (threadList = XW.getThreadList()) != null) {
            Iterator<v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                v next = it.next();
                if (next instanceof bh) {
                    bh bhVar = (bh) next;
                    if (bhVar == this.bSE) {
                        c(bhVar, i);
                        this.bSE = null;
                        break;
                    } else if (bhVar.getId() != null && bhVar.getId().equals(this.bOk)) {
                        c(bhVar, i);
                        this.bOk = null;
                        break;
                    }
                }
            }
            this.bFF.YH().b(threadList, XW);
            this.bFF.YH().notifyDataSetChanged();
        }
    }

    public void c(bh bhVar, int i) {
        if (bhVar != null) {
            if (i == 1) {
                PraiseData rn = bhVar.rn();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rn == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bhVar.a(praiseData);
                        return;
                    }
                    bhVar.rn().getUser().add(0, metaData);
                    bhVar.rn().setNum(bhVar.rn().getNum() + 1);
                    bhVar.rn().setIsLike(i);
                }
            } else if (bhVar.rn() != null) {
                bhVar.rn().setIsLike(i);
                bhVar.rn().setNum(bhVar.rn().getNum() - 1);
                ArrayList<MetaData> user = bhVar.rn().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bhVar.rn().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void eh(boolean z) {
        this.bOj = z;
    }
}
