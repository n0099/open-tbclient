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
    private String gFg;
    private final CustomMessageListener gFo;
    private bj gHQ;
    private boolean gHR;
    private PraiseModel gHS;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.gFo = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    h.this.gFg = bjVar.getId();
                    if (!TextUtils.isEmpty(h.this.gFg) && bjVar.aBZ() != null) {
                        h.this.tI(bjVar.aBZ().getIsLike());
                    }
                }
            }
        };
        this.gGF.registerListener(this.gFo);
        this.gHS = bJz();
    }

    public final PraiseModel bJz() {
        if (this.gHS == null) {
            this.gHS = new PraiseModel(this.gGF.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void xq(String str) {
                    int i = 1;
                    if (h.this.gHR) {
                        if (h.this.gHQ != null && h.this.gHQ.aBZ().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.tI(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.gGF != null && h.this.gGF.getPageContext() != null && h.this.gHR && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bb(i, str)) {
                            AntiHelper.bn(h.this.gGF.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.gGF.showToast(str);
                        }
                    }
                }
            });
        }
        return this.gHS;
    }

    public void tI(int i) {
        ArrayList<m> threadList;
        FrsViewData bEp = this.gGF.bEp();
        if (bEp != null && this.gom != null && (threadList = bEp.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cRf;
                    if (bjVar == this.gHQ) {
                        c(bjVar, i);
                        this.gHQ = null;
                        break;
                    } else if (bjVar.getId() != null && bjVar.getId().equals(this.gFg)) {
                        c(bjVar, i);
                        this.gFg = null;
                        break;
                    }
                }
            }
            this.gom.bFf().b(threadList, bEp);
            this.gom.bFf().notifyDataSetChanged();
        }
    }

    public void c(bj bjVar, int i) {
        if (bjVar != null) {
            if (i == 1) {
                PraiseData aBZ = bjVar.aBZ();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aBZ == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bjVar.a(praiseData);
                        return;
                    }
                    bjVar.aBZ().getUser().add(0, metaData);
                    bjVar.aBZ().setNum(bjVar.aBZ().getNum() + 1);
                    bjVar.aBZ().setIsLike(i);
                }
            } else if (bjVar.aBZ() != null) {
                bjVar.aBZ().setIsLike(i);
                bjVar.aBZ().setNum(bjVar.aBZ().getNum() - 1);
                ArrayList<MetaData> user = bjVar.aBZ().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bjVar.aBZ().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void lZ(boolean z) {
        this.gHR = z;
    }
}
