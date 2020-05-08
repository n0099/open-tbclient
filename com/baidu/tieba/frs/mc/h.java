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
    private String hpO;
    private final CustomMessageListener hpW;
    private bj hsx;
    private boolean hsy;
    private PraiseModel hsz;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.hpW = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    h.this.hpO = bjVar.getId();
                    if (!TextUtils.isEmpty(h.this.hpO) && bjVar.aKn() != null) {
                        h.this.ul(bjVar.aKn().getIsLike());
                    }
                }
            }
        };
        this.hro.registerListener(this.hpW);
        this.hsz = bUi();
    }

    public final PraiseModel bUi() {
        if (this.hsz == null) {
            this.hsz = new PraiseModel(this.hro.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void yH(String str) {
                    int i = 1;
                    if (h.this.hsy) {
                        if (h.this.hsx != null && h.this.hsx.aKn().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.ul(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.hro != null && h.this.hro.getPageContext() != null && h.this.hsy && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bq(i, str)) {
                            AntiHelper.aW(h.this.hro.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.hro.showToast(str);
                        }
                    }
                }
            });
        }
        return this.hsz;
    }

    public void ul(int i) {
        ArrayList<com.baidu.adp.widget.ListView.m> threadList;
        FrsViewData bOW = this.hro.bOW();
        if (bOW != null && this.gYw != null && (threadList = bOW.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).dqE;
                    if (bjVar == this.hsx) {
                        c(bjVar, i);
                        this.hsx = null;
                        break;
                    } else if (bjVar.getId() != null && bjVar.getId().equals(this.hpO)) {
                        c(bjVar, i);
                        this.hpO = null;
                        break;
                    }
                }
            }
            this.gYw.bPP().b(threadList, bOW);
            this.gYw.bPP().notifyDataSetChanged();
        }
    }

    public void c(bj bjVar, int i) {
        if (bjVar != null) {
            if (i == 1) {
                PraiseData aKn = bjVar.aKn();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aKn == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bjVar.a(praiseData);
                        return;
                    }
                    bjVar.aKn().getUser().add(0, metaData);
                    bjVar.aKn().setNum(bjVar.aKn().getNum() + 1);
                    bjVar.aKn().setIsLike(i);
                }
            } else if (bjVar.aKn() != null) {
                bjVar.aKn().setIsLike(i);
                bjVar.aKn().setNum(bjVar.aKn().getNum() - 1);
                ArrayList<MetaData> user = bjVar.aKn().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bjVar.aKn().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void nj(boolean z) {
        this.hsy = z;
    }
}
