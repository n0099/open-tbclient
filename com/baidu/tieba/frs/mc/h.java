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
    private String gGq;
    private final CustomMessageListener gGy;
    private bj gJb;
    private boolean gJc;
    private PraiseModel gJd;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.gGy = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    h.this.gGq = bjVar.getId();
                    if (!TextUtils.isEmpty(h.this.gGq) && bjVar.aCc() != null) {
                        h.this.tN(bjVar.aCc().getIsLike());
                    }
                }
            }
        };
        this.gHP.registerListener(this.gGy);
        this.gJd = bJN();
    }

    public final PraiseModel bJN() {
        if (this.gJd == null) {
            this.gJd = new PraiseModel(this.gHP.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void xr(String str) {
                    int i = 1;
                    if (h.this.gJc) {
                        if (h.this.gJb != null && h.this.gJb.aCc().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.tN(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.gHP != null && h.this.gHP.getPageContext() != null && h.this.gJc && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bb(i, str)) {
                            AntiHelper.bn(h.this.gHP.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.gHP.showToast(str);
                        }
                    }
                }
            });
        }
        return this.gJd;
    }

    public void tN(int i) {
        ArrayList<com.baidu.adp.widget.ListView.m> threadList;
        FrsViewData bEz = this.gHP.bEz();
        if (bEz != null && this.gpj != null && (threadList = bEz.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cRt;
                    if (bjVar == this.gJb) {
                        c(bjVar, i);
                        this.gJb = null;
                        break;
                    } else if (bjVar.getId() != null && bjVar.getId().equals(this.gGq)) {
                        c(bjVar, i);
                        this.gGq = null;
                        break;
                    }
                }
            }
            this.gpj.bFq().b(threadList, bEz);
            this.gpj.bFq().notifyDataSetChanged();
        }
    }

    public void c(bj bjVar, int i) {
        if (bjVar != null) {
            if (i == 1) {
                PraiseData aCc = bjVar.aCc();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aCc == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bjVar.a(praiseData);
                        return;
                    }
                    bjVar.aCc().getUser().add(0, metaData);
                    bjVar.aCc().setNum(bjVar.aCc().getNum() + 1);
                    bjVar.aCc().setIsLike(i);
                }
            } else if (bjVar.aCc() != null) {
                bjVar.aCc().setIsLike(i);
                bjVar.aCc().setNum(bjVar.aCc().getNum() - 1);
                ArrayList<MetaData> user = bjVar.aCc().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bjVar.aCc().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void mf(boolean z) {
        this.gJc = z;
    }
}
