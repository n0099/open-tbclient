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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class h extends j {
    private bz jAh;
    private boolean jAi;
    private PraiseModel jAj;
    private String jxC;
    private final CustomMessageListener jxK;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.jxK = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bz)) {
                    bz bzVar = (bz) customResponsedMessage.getData();
                    h.this.jxC = bzVar.getId();
                    if (!TextUtils.isEmpty(h.this.jxC) && bzVar.bni() != null) {
                        h.this.zL(bzVar.bni().getIsLike());
                    }
                }
            }
        };
        this.jzc.registerListener(this.jxK);
        this.jAj = cIH();
    }

    public final PraiseModel cIH() {
        if (this.jAj == null) {
            this.jAj = new PraiseModel(this.jzc.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void EC(String str) {
                    int i = 1;
                    if (h.this.jAi) {
                        if (h.this.jAh != null && h.this.jAh.bni().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.zL(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.jzc != null && h.this.jzc.getPageContext() != null && h.this.jAi && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bQ(i, str)) {
                            AntiHelper.bs(h.this.jzc.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.jzc.showToast(str);
                        }
                    }
                }
            });
        }
        return this.jAj;
    }

    public void zL(int i) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList;
        FrsViewData cBN = this.jzc.cBN();
        if (cBN != null && this.jaB != null && (threadList = cBN.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof by) {
                    bz bzVar = ((by) next).eHK;
                    if (bzVar == this.jAh) {
                        c(bzVar, i);
                        this.jAh = null;
                        break;
                    } else if (bzVar.getId() != null && bzVar.getId().equals(this.jxC)) {
                        c(bzVar, i);
                        this.jxC = null;
                        break;
                    }
                }
            }
            this.jaB.cCI().b(threadList, cBN);
            this.jaB.cCI().notifyDataSetChanged();
        }
    }

    public void c(bz bzVar, int i) {
        if (bzVar != null) {
            if (i == 1) {
                PraiseData bni = bzVar.bni();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bni == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bzVar.a(praiseData);
                        return;
                    }
                    bzVar.bni().getUser().add(0, metaData);
                    bzVar.bni().setNum(bzVar.bni().getNum() + 1);
                    bzVar.bni().setIsLike(i);
                }
            } else if (bzVar.bni() != null) {
                bzVar.bni().setIsLike(i);
                bzVar.bni().setNum(bzVar.bni().getNum() - 1);
                ArrayList<MetaData> user = bzVar.bni().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bzVar.bni().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void rl(boolean z) {
        this.jAi = z;
    }
}
