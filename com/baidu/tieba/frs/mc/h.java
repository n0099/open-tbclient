package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class h extends j {
    private String hEC;
    private final CustomMessageListener hEK;
    private bk hHl;
    private boolean hHm;
    private PraiseModel hHn;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.hEK = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk)) {
                    bk bkVar = (bk) customResponsedMessage.getData();
                    h.this.hEC = bkVar.getId();
                    if (!TextUtils.isEmpty(h.this.hEC) && bkVar.aQi() != null) {
                        h.this.uQ(bkVar.aQi().getIsLike());
                    }
                }
            }
        };
        this.hGd.registerListener(this.hEK);
        this.hHn = caG();
    }

    public final PraiseModel caG() {
        if (this.hHn == null) {
            this.hHn = new PraiseModel(this.hGd.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void An(String str) {
                    int i = 1;
                    if (h.this.hHm) {
                        if (h.this.hHl != null && h.this.hHl.aQi().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.uQ(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.hGd != null && h.this.hGd.getPageContext() != null && h.this.hHm && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bv(i, str)) {
                            AntiHelper.aX(h.this.hGd.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.hGd.showToast(str);
                        }
                    }
                }
            });
        }
        return this.hHn;
    }

    public void uQ(int i) {
        ArrayList<o> threadList;
        FrsViewData bVs = this.hGd.bVs();
        if (bVs != null && this.hni != null && (threadList = bVs.getThreadList()) != null) {
            Iterator<o> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next instanceof bj) {
                    bk bkVar = ((bj) next).dEA;
                    if (bkVar == this.hHl) {
                        c(bkVar, i);
                        this.hHl = null;
                        break;
                    } else if (bkVar.getId() != null && bkVar.getId().equals(this.hEC)) {
                        c(bkVar, i);
                        this.hEC = null;
                        break;
                    }
                }
            }
            this.hni.bWm().b(threadList, bVs);
            this.hni.bWm().notifyDataSetChanged();
        }
    }

    public void c(bk bkVar, int i) {
        if (bkVar != null) {
            if (i == 1) {
                PraiseData aQi = bkVar.aQi();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aQi == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bkVar.a(praiseData);
                        return;
                    }
                    bkVar.aQi().getUser().add(0, metaData);
                    bkVar.aQi().setNum(bkVar.aQi().getNum() + 1);
                    bkVar.aQi().setIsLike(i);
                }
            } else if (bkVar.aQi() != null) {
                bkVar.aQi().setIsLike(i);
                bkVar.aQi().setNum(bkVar.aQi().getNum() - 1);
                ArrayList<MetaData> user = bkVar.aQi().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bkVar.aQi().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void nE(boolean z) {
        this.hHm = z;
    }
}
