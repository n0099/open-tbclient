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
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class f extends h {
    private final CustomMessageListener bcf;
    private String dOD;
    private bd dQA;
    private boolean dQB;
    private PraiseModel dQC;

    public f(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.bcf = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    f.this.dOD = bdVar.getId();
                    if (!TextUtils.isEmpty(f.this.dOD) && bdVar.yI() != null) {
                        f.this.nC(bdVar.yI().getIsLike());
                    }
                }
            }
        };
        this.dPK.registerListener(this.bcf);
        this.dQC = ayB();
    }

    public final PraiseModel ayB() {
        if (this.dQC == null) {
            this.dQC = new PraiseModel(this.dPK.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void ih(String str) {
                    int i = 1;
                    if (f.this.dQB) {
                        if (f.this.dQA != null && f.this.dQA.yI().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.nC(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void H(int i, String str) {
                    if (f.this.dPK != null && f.this.dPK.getPageContext() != null && f.this.dQB && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.vQ(i)) {
                            AntiHelper.an(f.this.dPK.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dPK.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dQC;
    }

    public void nC(int i) {
        ArrayList<com.baidu.adp.widget.ListView.i> threadList;
        l auv = this.dPK.auv();
        if (auv != null && this.dBD != null && (threadList = auv.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar == this.dQA) {
                        c(bdVar, i);
                        this.dQA = null;
                        break;
                    } else if (bdVar.getId() != null && bdVar.getId().equals(this.dOD)) {
                        c(bdVar, i);
                        this.dOD = null;
                        break;
                    }
                }
            }
            this.dBD.auU().b(threadList, auv);
            this.dBD.auU().notifyDataSetChanged();
        }
    }

    public void c(bd bdVar, int i) {
        if (bdVar != null) {
            if (i == 1) {
                PraiseData yI = bdVar.yI();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (yI == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bdVar.a(praiseData);
                        return;
                    }
                    bdVar.yI().getUser().add(0, metaData);
                    bdVar.yI().setNum(bdVar.yI().getNum() + 1);
                    bdVar.yI().setIsLike(i);
                }
            } else if (bdVar.yI() != null) {
                bdVar.yI().setIsLike(i);
                bdVar.yI().setNum(bdVar.yI().getNum() - 1);
                ArrayList<MetaData> user = bdVar.yI().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bdVar.yI().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void gg(boolean z) {
        this.dQB = z;
    }
}
