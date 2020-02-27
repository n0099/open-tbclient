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
/* loaded from: classes9.dex */
public class h extends j {
    private String gFe;
    private final CustomMessageListener gFm;
    private bj gHO;
    private boolean gHP;
    private PraiseModel gHQ;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.gFm = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    h.this.gFe = bjVar.getId();
                    if (!TextUtils.isEmpty(h.this.gFe) && bjVar.aBX() != null) {
                        h.this.tI(bjVar.aBX().getIsLike());
                    }
                }
            }
        };
        this.gGD.registerListener(this.gFm);
        this.gHQ = bJx();
    }

    public final PraiseModel bJx() {
        if (this.gHQ == null) {
            this.gHQ = new PraiseModel(this.gGD.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void xq(String str) {
                    int i = 1;
                    if (h.this.gHP) {
                        if (h.this.gHO != null && h.this.gHO.aBX().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.tI(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.gGD != null && h.this.gGD.getPageContext() != null && h.this.gHP && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bb(i, str)) {
                            AntiHelper.bn(h.this.gGD.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.gGD.showToast(str);
                        }
                    }
                }
            });
        }
        return this.gHQ;
    }

    public void tI(int i) {
        ArrayList<m> threadList;
        FrsViewData bEn = this.gGD.bEn();
        if (bEn != null && this.gok != null && (threadList = bEn.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cRe;
                    if (bjVar == this.gHO) {
                        c(bjVar, i);
                        this.gHO = null;
                        break;
                    } else if (bjVar.getId() != null && bjVar.getId().equals(this.gFe)) {
                        c(bjVar, i);
                        this.gFe = null;
                        break;
                    }
                }
            }
            this.gok.bFd().b(threadList, bEn);
            this.gok.bFd().notifyDataSetChanged();
        }
    }

    public void c(bj bjVar, int i) {
        if (bjVar != null) {
            if (i == 1) {
                PraiseData aBX = bjVar.aBX();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aBX == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bjVar.a(praiseData);
                        return;
                    }
                    bjVar.aBX().getUser().add(0, metaData);
                    bjVar.aBX().setNum(bjVar.aBX().getNum() + 1);
                    bjVar.aBX().setIsLike(i);
                }
            } else if (bjVar.aBX() != null) {
                bjVar.aBX().setIsLike(i);
                bjVar.aBX().setNum(bjVar.aBX().getNum() - 1);
                ArrayList<MetaData> user = bjVar.aBX().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bjVar.aBX().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void lZ(boolean z) {
        this.gHP = z;
    }
}
