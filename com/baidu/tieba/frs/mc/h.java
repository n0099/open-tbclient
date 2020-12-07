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
    private String jpJ;
    private final CustomMessageListener jpR;
    private by jsq;
    private boolean jsr;
    private PraiseModel jss;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.jpR = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof by)) {
                    by byVar = (by) customResponsedMessage.getData();
                    h.this.jpJ = byVar.getId();
                    if (!TextUtils.isEmpty(h.this.jpJ) && byVar.boA() != null) {
                        h.this.Bf(byVar.boA().getIsLike());
                    }
                }
            }
        };
        this.jrk.registerListener(this.jpR);
        this.jss = cJx();
    }

    public final PraiseModel cJx() {
        if (this.jss == null) {
            this.jss = new PraiseModel(this.jrk.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void FQ(String str) {
                    int i = 1;
                    if (h.this.jsr) {
                        if (h.this.jsq != null && h.this.jsq.boA().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.Bf(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.jrk != null && h.this.jrk.getPageContext() != null && h.this.jsr && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bP(i, str)) {
                            AntiHelper.bn(h.this.jrk.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.jrk.showToast(str);
                        }
                    }
                }
            });
        }
        return this.jss;
    }

    public void Bf(int i) {
        ArrayList<q> threadList;
        FrsViewData cCJ = this.jrk.cCJ();
        if (cCJ != null && this.iSV != null && (threadList = cCJ.getThreadList()) != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bx) {
                    by byVar = ((bx) next).eCR;
                    if (byVar == this.jsq) {
                        c(byVar, i);
                        this.jsq = null;
                        break;
                    } else if (byVar.getId() != null && byVar.getId().equals(this.jpJ)) {
                        c(byVar, i);
                        this.jpJ = null;
                        break;
                    }
                }
            }
            this.iSV.cDE().b(threadList, cCJ);
            this.iSV.cDE().notifyDataSetChanged();
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
        this.jsr = z;
    }
}
