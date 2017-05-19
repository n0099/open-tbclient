package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class s extends w {
    private final CustomMessageListener amd;
    private boolean bVu;
    private String bVv;
    private bk bYA;
    private PraiseModel bYB;

    public s(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.amd = new t(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.bNK.registerListener(this.amd);
        this.bYB = acd();
    }

    public final PraiseModel acd() {
        if (this.bYB == null) {
            this.bYB = new PraiseModel(this.bNK.getPageContext(), new u(this));
        }
        return this.bYB;
    }

    public void ie(int i) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        com.baidu.tieba.tbadkCore.n Zq = this.bNK.Zq();
        if (Zq != null && this.bOn != null && (threadList = Zq.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof bk) {
                    bk bkVar = (bk) next;
                    if (bkVar == this.bYA) {
                        c(bkVar, i);
                        this.bYA = null;
                        break;
                    } else if (bkVar.getId() != null && bkVar.getId().equals(this.bVv)) {
                        c(bkVar, i);
                        this.bVv = null;
                        break;
                    }
                }
            }
            this.bOn.ZO().b(threadList, Zq);
            this.bOn.ZO().notifyDataSetChanged();
        }
    }

    public void c(bk bkVar, int i) {
        if (bkVar != null) {
            if (i == 1) {
                PraiseData ro = bkVar.ro();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (ro == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bkVar.a(praiseData);
                        return;
                    }
                    bkVar.ro().getUser().add(0, metaData);
                    bkVar.ro().setNum(bkVar.ro().getNum() + 1);
                    bkVar.ro().setIsLike(i);
                }
            } else if (bkVar.ro() != null) {
                bkVar.ro().setIsLike(i);
                bkVar.ro().setNum(bkVar.ro().getNum() - 1);
                ArrayList<MetaData> user = bkVar.ro().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bkVar.ro().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void ef(boolean z) {
        this.bVu = z;
    }
}
