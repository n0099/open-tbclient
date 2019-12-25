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
/* loaded from: classes6.dex */
public class h extends j {
    private final CustomMessageListener gAd;
    private bj gCA;
    private boolean gCB;
    private PraiseModel gCC;
    private String gzU;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.gAd = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    h.this.gzU = bjVar.getId();
                    if (!TextUtils.isEmpty(h.this.gzU) && bjVar.azp() != null) {
                        h.this.tx(bjVar.azp().getIsLike());
                    }
                }
            }
        };
        this.gBu.registerListener(this.gAd);
        this.gCC = bGT();
    }

    public final PraiseModel bGT() {
        if (this.gCC == null) {
            this.gCC = new PraiseModel(this.gBu.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void wS(String str) {
                    int i = 1;
                    if (h.this.gCB) {
                        if (h.this.gCA != null && h.this.gCA.azp().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.tx(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.gBu != null && h.this.gBu.getPageContext() != null && h.this.gCB && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.aW(i, str)) {
                            AntiHelper.bj(h.this.gBu.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.gBu.showToast(str);
                        }
                    }
                }
            });
        }
        return this.gCC;
    }

    public void tx(int i) {
        ArrayList<m> threadList;
        FrsViewData bBI = this.gBu.bBI();
        if (bBI != null && this.gja != null && (threadList = bBI.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cMR;
                    if (bjVar == this.gCA) {
                        c(bjVar, i);
                        this.gCA = null;
                        break;
                    } else if (bjVar.getId() != null && bjVar.getId().equals(this.gzU)) {
                        c(bjVar, i);
                        this.gzU = null;
                        break;
                    }
                }
            }
            this.gja.bCy().b(threadList, bBI);
            this.gja.bCy().notifyDataSetChanged();
        }
    }

    public void c(bj bjVar, int i) {
        if (bjVar != null) {
            if (i == 1) {
                PraiseData azp = bjVar.azp();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (azp == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bjVar.a(praiseData);
                        return;
                    }
                    bjVar.azp().getUser().add(0, metaData);
                    bjVar.azp().setNum(bjVar.azp().getNum() + 1);
                    bjVar.azp().setIsLike(i);
                }
            } else if (bjVar.azp() != null) {
                bjVar.azp().setIsLike(i);
                bjVar.azp().setNum(bjVar.azp().getNum() - 1);
                ArrayList<MetaData> user = bjVar.azp().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bjVar.azp().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void lM(boolean z) {
        this.gCB = z;
    }
}
