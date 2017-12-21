package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends h {
    private final CustomMessageListener anZ;
    private boolean cRw;
    private String cRx;
    private PraiseModel cYA;
    private bd cYz;

    public f(com.baidu.tieba.frs.g gVar) {
        super(gVar);
        this.anZ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    f.this.cRx = bdVar.getId();
                    if (!TextUtils.isEmpty(f.this.cRx) && bdVar.rk() != null) {
                        f.this.kp(bdVar.rk().getIsLike());
                    }
                }
            }
        };
        this.cOB.registerListener(this.anZ);
        this.cYA = aqh();
    }

    public final PraiseModel aqh() {
        if (this.cYA == null) {
            this.cYA = new PraiseModel(this.cOB.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hW(String str) {
                    int i = 1;
                    if (f.this.cRw) {
                        if (f.this.cYz != null && f.this.cYz.rk().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.kp(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void F(int i, String str) {
                    if (f.this.cOB != null && f.this.cOB.getPageContext() != null && f.this.cRw && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.uB(i)) {
                            AntiHelper.am(f.this.cOB.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.cOB.showToast(str);
                        }
                    }
                }
            });
        }
        return this.cYA;
    }

    public void kp(int i) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        k alE = this.cOB.alE();
        if (alE != null && this.cHm != null && (threadList = alE.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar == this.cYz) {
                        c(bdVar, i);
                        this.cYz = null;
                        break;
                    } else if (bdVar.getId() != null && bdVar.getId().equals(this.cRx)) {
                        c(bdVar, i);
                        this.cRx = null;
                        break;
                    }
                }
            }
            this.cHm.ame().b(threadList, alE);
            this.cHm.ame().notifyDataSetChanged();
        }
    }

    public void c(bd bdVar, int i) {
        if (bdVar != null) {
            if (i == 1) {
                PraiseData rk = bdVar.rk();
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
                        bdVar.a(praiseData);
                        return;
                    }
                    bdVar.rk().getUser().add(0, metaData);
                    bdVar.rk().setNum(bdVar.rk().getNum() + 1);
                    bdVar.rk().setIsLike(i);
                }
            } else if (bdVar.rk() != null) {
                bdVar.rk().setIsLike(i);
                bdVar.rk().setNum(bdVar.rk().getNum() - 1);
                ArrayList<MetaData> user = bdVar.rk().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bdVar.rk().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fz(boolean z) {
        this.cRw = z;
    }
}
