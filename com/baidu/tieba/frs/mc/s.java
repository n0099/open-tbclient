package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.PraiseModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class s extends w {
    private final CustomMessageListener amd;
    private boolean bXw;
    private String bXx;
    private bi caI;
    private PraiseModel caJ;

    public s(FrsActivity frsActivity) {
        super(frsActivity);
        this.amd = new t(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.bVk.registerListener(this.amd);
        this.caJ = adZ();
    }

    public final PraiseModel adZ() {
        if (this.caJ == null) {
            this.caJ = new PraiseModel(this.bVk.getPageContext(), new u(this));
        }
        return this.caJ;
    }

    public void io(int i) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        com.baidu.tieba.tbadkCore.n aas = this.bVk.aas();
        if (aas != null && this.bOU != null && (threadList = aas.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof bi) {
                    bi biVar = (bi) next;
                    if (biVar == this.caI) {
                        c(biVar, i);
                        this.caI = null;
                        break;
                    } else if (biVar.getId() != null && biVar.getId().equals(this.bXx)) {
                        c(biVar, i);
                        this.bXx = null;
                        break;
                    }
                }
            }
            this.bOU.abf().b(threadList, aas);
            this.bOU.abf().notifyDataSetChanged();
        }
    }

    public void c(bi biVar, int i) {
        if (biVar != null) {
            if (i == 1) {
                PraiseData se = biVar.se();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (se == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        biVar.a(praiseData);
                        return;
                    }
                    biVar.se().getUser().add(0, metaData);
                    biVar.se().setNum(biVar.se().getNum() + 1);
                    biVar.se().setIsLike(i);
                }
            } else if (biVar.se() != null) {
                biVar.se().setIsLike(i);
                biVar.se().setNum(biVar.se().getNum() - 1);
                ArrayList<MetaData> user = biVar.se().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            biVar.se().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void er(boolean z) {
        this.bXw = z;
    }
}
