package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends h {
    private final CustomMessageListener anI;
    private boolean cHD;
    private String cHE;
    private bh cOA;
    private PraiseModel cOB;

    public f(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.anI = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    f.this.cHE = bhVar.getId();
                    if (!TextUtils.isEmpty(f.this.cHE) && bhVar.ri() != null) {
                        f.this.jQ(bhVar.ri().getIsLike());
                    }
                }
            }
        };
        this.cEN.registerListener(this.anI);
        this.cOB = anP();
    }

    public final PraiseModel anP() {
        if (this.cOB == null) {
            this.cOB = new PraiseModel(this.cEN.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hS(String str) {
                    int i = 1;
                    if (f.this.cHD) {
                        if (f.this.cOA != null && f.this.cOA.ri().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.jQ(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void C(int i, String str) {
                    if (f.this.cEN != null && f.this.cEN.getPageContext() != null && f.this.cHD && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.tW(i)) {
                            AntiHelper.ao(f.this.cEN.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.cEN.showToast(str);
                        }
                    }
                }
            });
        }
        return this.cOB;
    }

    public void jQ(int i) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        com.baidu.tieba.tbadkCore.j ajn = this.cEN.ajn();
        if (ajn != null && this.cxB != null && (threadList = ajn.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof bh) {
                    bh bhVar = (bh) next;
                    if (bhVar == this.cOA) {
                        c(bhVar, i);
                        this.cOA = null;
                        break;
                    } else if (bhVar.getId() != null && bhVar.getId().equals(this.cHE)) {
                        c(bhVar, i);
                        this.cHE = null;
                        break;
                    }
                }
            }
            this.cxB.ajN().b(threadList, ajn);
            this.cxB.ajN().notifyDataSetChanged();
        }
    }

    public void c(bh bhVar, int i) {
        if (bhVar != null) {
            if (i == 1) {
                PraiseData ri = bhVar.ri();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (ri == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bhVar.a(praiseData);
                        return;
                    }
                    bhVar.ri().getUser().add(0, metaData);
                    bhVar.ri().setNum(bhVar.ri().getNum() + 1);
                    bhVar.ri().setIsLike(i);
                }
            } else if (bhVar.ri() != null) {
                bhVar.ri().setIsLike(i);
                bhVar.ri().setNum(bhVar.ri().getNum() - 1);
                ArrayList<MetaData> user = bhVar.ri().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bhVar.ri().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fc(boolean z) {
        this.cHD = z;
    }
}
