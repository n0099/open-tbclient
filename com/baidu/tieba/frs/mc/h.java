package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class h extends j {
    private String jpL;
    private final CustomMessageListener jpT;
    private by jss;
    private boolean jst;
    private PraiseModel jsu;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.jpT = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof by)) {
                    by byVar = (by) customResponsedMessage.getData();
                    h.this.jpL = byVar.getId();
                    if (!TextUtils.isEmpty(h.this.jpL) && byVar.boA() != null) {
                        h.this.Bf(byVar.boA().getIsLike());
                    }
                }
            }
        };
        this.jrm.registerListener(this.jpT);
        this.jsu = cJy();
    }

    public final PraiseModel cJy() {
        if (this.jsu == null) {
            this.jsu = new PraiseModel(this.jrm.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void FQ(String str) {
                    int i = 1;
                    if (h.this.jst) {
                        if (h.this.jss != null && h.this.jss.boA().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.Bf(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.jrm != null && h.this.jrm.getPageContext() != null && h.this.jst && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bP(i, str)) {
                            AntiHelper.bn(h.this.jrm.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.jrm.showToast(str);
                        }
                    }
                }
            });
        }
        return this.jsu;
    }

    public void Bf(int i) {
        ArrayList<q> threadList;
        FrsViewData cCK = this.jrm.cCK();
        if (cCK != null && this.iSX != null && (threadList = cCK.getThreadList()) != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bx) {
                    by byVar = ((bx) next).eCR;
                    if (byVar == this.jss) {
                        c(byVar, i);
                        this.jss = null;
                        break;
                    } else if (byVar.getId() != null && byVar.getId().equals(this.jpL)) {
                        c(byVar, i);
                        this.jpL = null;
                        break;
                    }
                }
            }
            this.iSX.cDF().b(threadList, cCK);
            this.iSX.cDF().notifyDataSetChanged();
        }
    }

    public void c(by byVar, int i) {
        if (byVar != null) {
            if (i == 1) {
                PraiseData boA = byVar.boA();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (boA == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        byVar.a(praiseData);
                        return;
                    }
                    byVar.boA().getUser().add(0, metaData);
                    byVar.boA().setNum(byVar.boA().getNum() + 1);
                    byVar.boA().setIsLike(i);
                }
            } else if (byVar.boA() != null) {
                byVar.boA().setIsLike(i);
                byVar.boA().setNum(byVar.boA().getNum() - 1);
                ArrayList<MetaData> user = byVar.boA().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            byVar.boA().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void qR(boolean z) {
        this.jst = z;
    }
}
