package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
/* loaded from: classes9.dex */
public class h extends j {
    private String hpI;
    private final CustomMessageListener hpQ;
    private bj hsr;
    private boolean hss;
    private PraiseModel hst;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.hpQ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    h.this.hpI = bjVar.getId();
                    if (!TextUtils.isEmpty(h.this.hpI) && bjVar.aKp() != null) {
                        h.this.ul(bjVar.aKp().getIsLike());
                    }
                }
            }
        };
        this.hri.registerListener(this.hpQ);
        this.hst = bUk();
    }

    public final PraiseModel bUk() {
        if (this.hst == null) {
            this.hst = new PraiseModel(this.hri.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void yE(String str) {
                    int i = 1;
                    if (h.this.hss) {
                        if (h.this.hsr != null && h.this.hsr.aKp().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.ul(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.hri != null && h.this.hri.getPageContext() != null && h.this.hss && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bq(i, str)) {
                            AntiHelper.bi(h.this.hri.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.hri.showToast(str);
                        }
                    }
                }
            });
        }
        return this.hst;
    }

    public void ul(int i) {
        ArrayList<com.baidu.adp.widget.ListView.m> threadList;
        FrsViewData bOY = this.hri.bOY();
        if (bOY != null && this.gYq != null && (threadList = bOY.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).dqA;
                    if (bjVar == this.hsr) {
                        c(bjVar, i);
                        this.hsr = null;
                        break;
                    } else if (bjVar.getId() != null && bjVar.getId().equals(this.hpI)) {
                        c(bjVar, i);
                        this.hpI = null;
                        break;
                    }
                }
            }
            this.gYq.bPR().b(threadList, bOY);
            this.gYq.bPR().notifyDataSetChanged();
        }
    }

    public void c(bj bjVar, int i) {
        if (bjVar != null) {
            if (i == 1) {
                PraiseData aKp = bjVar.aKp();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aKp == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bjVar.a(praiseData);
                        return;
                    }
                    bjVar.aKp().getUser().add(0, metaData);
                    bjVar.aKp().setNum(bjVar.aKp().getNum() + 1);
                    bjVar.aKp().setIsLike(i);
                }
            } else if (bjVar.aKp() != null) {
                bjVar.aKp().setIsLike(i);
                bjVar.aKp().setNum(bjVar.aKp().getNum() - 1);
                ArrayList<MetaData> user = bjVar.aKp().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bjVar.aKp().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void nj(boolean z) {
        this.hss = z;
    }
}
