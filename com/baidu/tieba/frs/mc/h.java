package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class h extends j {
    private String gDe;
    private final CustomMessageListener gDn;
    private bj gFP;
    private boolean gFQ;
    private PraiseModel gFR;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.gDn = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    h.this.gDe = bjVar.getId();
                    if (!TextUtils.isEmpty(h.this.gDe) && bjVar.azI() != null) {
                        h.this.tC(bjVar.azI().getIsLike());
                    }
                }
            }
        };
        this.gEE.registerListener(this.gDn);
        this.gFR = bHV();
    }

    public final PraiseModel bHV() {
        if (this.gFR == null) {
            this.gFR = new PraiseModel(this.gEE.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void wW(String str) {
                    int i = 1;
                    if (h.this.gFQ) {
                        if (h.this.gFP != null && h.this.gFP.azI().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.tC(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.gEE != null && h.this.gEE.getPageContext() != null && h.this.gFQ && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bc(i, str)) {
                            AntiHelper.bn(h.this.gEE.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.gEE.showToast(str);
                        }
                    }
                }
            });
        }
        return this.gFR;
    }

    public void tC(int i) {
        ArrayList<m> threadList;
        FrsViewData bCK = this.gEE.bCK();
        if (bCK != null && this.gmj != null && (threadList = bCK.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cNb;
                    if (bjVar == this.gFP) {
                        c(bjVar, i);
                        this.gFP = null;
                        break;
                    } else if (bjVar.getId() != null && bjVar.getId().equals(this.gDe)) {
                        c(bjVar, i);
                        this.gDe = null;
                        break;
                    }
                }
            }
            this.gmj.bDA().b(threadList, bCK);
            this.gmj.bDA().notifyDataSetChanged();
        }
    }

    public void c(bj bjVar, int i) {
        if (bjVar != null) {
            if (i == 1) {
                PraiseData azI = bjVar.azI();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (azI == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bjVar.a(praiseData);
                        return;
                    }
                    bjVar.azI().getUser().add(0, metaData);
                    bjVar.azI().setNum(bjVar.azI().getNum() + 1);
                    bjVar.azI().setIsLike(i);
                }
            } else if (bjVar.azI() != null) {
                bjVar.azI().setIsLike(i);
                bjVar.azI().setNum(bjVar.azI().getNum() - 1);
                ArrayList<MetaData> user = bjVar.azI().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bjVar.azI().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void lX(boolean z) {
        this.gFQ = z;
    }
}
