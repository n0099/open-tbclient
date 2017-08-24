package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g extends i {
    private final CustomMessageListener aoQ;
    private boolean crN;
    private String crO;
    private bl cxm;
    private PraiseModel cxn;

    public g(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.aoQ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl)) {
                    bl blVar = (bl) customResponsedMessage.getData();
                    g.this.crO = blVar.getId();
                    if (!TextUtils.isEmpty(g.this.crO) && blVar.rw() != null) {
                        g.this.ja(blVar.rw().getIsLike());
                    }
                }
            }
        };
        this.coV.registerListener(this.aoQ);
        this.cxn = ajl();
    }

    public final PraiseModel ajl() {
        if (this.cxn == null) {
            this.cxn = new PraiseModel(this.coV.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.g.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hS(String str) {
                    int i = 1;
                    if (g.this.crN) {
                        if (g.this.cxm != null && g.this.cxm.rw().getIsLike() == 1) {
                            i = 0;
                        }
                        g.this.ja(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void A(int i, String str) {
                    if (g.this.coV != null && g.this.coV.getPageContext() != null && g.this.crN && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.tx(i)) {
                            AntiHelper.ar(g.this.coV.getPageContext().getPageActivity(), str);
                        } else {
                            g.this.coV.showToast(str);
                        }
                    }
                }
            });
        }
        return this.cxn;
    }

    public void ja(int i) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        com.baidu.tieba.tbadkCore.i afH = this.coV.afH();
        if (afH != null && this.cjL != null && (threadList = afH.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof bl) {
                    bl blVar = (bl) next;
                    if (blVar == this.cxm) {
                        c(blVar, i);
                        this.cxm = null;
                        break;
                    } else if (blVar.getId() != null && blVar.getId().equals(this.crO)) {
                        c(blVar, i);
                        this.crO = null;
                        break;
                    }
                }
            }
            this.cjL.agi().b(threadList, afH);
            this.cjL.agi().notifyDataSetChanged();
        }
    }

    public void c(bl blVar, int i) {
        if (blVar != null) {
            if (i == 1) {
                PraiseData rw = blVar.rw();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rw == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        blVar.a(praiseData);
                        return;
                    }
                    blVar.rw().getUser().add(0, metaData);
                    blVar.rw().setNum(blVar.rw().getNum() + 1);
                    blVar.rw().setIsLike(i);
                }
            } else if (blVar.rw() != null) {
                blVar.rw().setIsLike(i);
                blVar.rw().setNum(blVar.rw().getNum() - 1);
                ArrayList<MetaData> user = blVar.rw().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            blVar.rw().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fb(boolean z) {
        this.crN = z;
    }
}
