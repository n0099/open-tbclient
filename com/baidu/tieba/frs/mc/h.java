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
    private final CustomMessageListener gFA;
    private String gFs;
    private bj gIc;
    private boolean gId;
    private PraiseModel gIe;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.gFA = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    h.this.gFs = bjVar.getId();
                    if (!TextUtils.isEmpty(h.this.gFs) && bjVar.aBZ() != null) {
                        h.this.tI(bjVar.aBZ().getIsLike());
                    }
                }
            }
        };
        this.gGR.registerListener(this.gFA);
        this.gIe = bJA();
    }

    public final PraiseModel bJA() {
        if (this.gIe == null) {
            this.gIe = new PraiseModel(this.gGR.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void xr(String str) {
                    int i = 1;
                    if (h.this.gId) {
                        if (h.this.gIc != null && h.this.gIc.aBZ().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.tI(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.gGR != null && h.this.gGR.getPageContext() != null && h.this.gId && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bb(i, str)) {
                            AntiHelper.bn(h.this.gGR.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.gGR.showToast(str);
                        }
                    }
                }
            });
        }
        return this.gIe;
    }

    public void tI(int i) {
        ArrayList<m> threadList;
        FrsViewData bEq = this.gGR.bEq();
        if (bEq != null && this.goz != null && (threadList = bEq.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cRg;
                    if (bjVar == this.gIc) {
                        c(bjVar, i);
                        this.gIc = null;
                        break;
                    } else if (bjVar.getId() != null && bjVar.getId().equals(this.gFs)) {
                        c(bjVar, i);
                        this.gFs = null;
                        break;
                    }
                }
            }
            this.goz.bFg().b(threadList, bEq);
            this.goz.bFg().notifyDataSetChanged();
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
        this.gId = z;
    }
}
