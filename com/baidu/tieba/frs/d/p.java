package com.baidu.tieba.frs.d;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends s {
    private final CustomMessageListener ahj;
    private boolean bHU;
    private String bHV;
    private bg bMr;

    public p(FrsActivity frsActivity) {
        super(frsActivity);
        this.ahj = new q(this, CmdConfigCustom.PB_ACTION_PRAISE);
        this.bFI.registerListener(this.ahj);
    }

    public void hw(int i) {
        ArrayList<v> threadList;
        com.baidu.tieba.tbadkCore.o WF = this.bFI.WF();
        if (WF != null && this.byg != null && (threadList = WF.getThreadList()) != null) {
            Iterator<v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                v next = it.next();
                if (next instanceof bg) {
                    bg bgVar = (bg) next;
                    if (bgVar == this.bMr) {
                        c(bgVar, i);
                        this.bMr = null;
                        break;
                    } else if (bgVar.getId() != null && bgVar.getId().equals(this.bHV)) {
                        c(bgVar, i);
                        this.bHV = null;
                        break;
                    }
                }
            }
            this.byg.Xu().b(threadList, WF);
            this.byg.Xu().notifyDataSetChanged();
        }
    }

    public void c(bg bgVar, int i) {
        if (bgVar != null) {
            if (i == 1) {
                PraiseData rv = bgVar.rv();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rv == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bgVar.a(praiseData);
                        return;
                    }
                    bgVar.rv().getUser().add(0, metaData);
                    bgVar.rv().setNum(bgVar.rv().getNum() + 1);
                    bgVar.rv().setIsLike(i);
                }
            } else if (bgVar.rv() != null) {
                bgVar.rv().setIsLike(i);
                bgVar.rv().setNum(bgVar.rv().getNum() - 1);
                ArrayList<MetaData> user = bgVar.rv().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bgVar.rv().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void ec(boolean z) {
        this.bHU = z;
    }
}
