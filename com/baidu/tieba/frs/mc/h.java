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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class h extends j {
    private final CustomMessageListener jDE;
    private String jDw;
    private cb jFZ;
    private boolean jGa;
    private PraiseModel jGb;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.jDE = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof cb)) {
                    cb cbVar = (cb) customResponsedMessage.getData();
                    h.this.jDw = cbVar.getId();
                    if (!TextUtils.isEmpty(h.this.jDw) && cbVar.bnB() != null) {
                        h.this.zV(cbVar.bnB().getIsLike());
                    }
                }
            }
        };
        this.jEV.registerListener(this.jDE);
        this.jGb = cKb();
    }

    public final PraiseModel cKb() {
        if (this.jGb == null) {
            this.jGb = new PraiseModel(this.jEV.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void Fb(String str) {
                    int i = 1;
                    if (h.this.jGa) {
                        if (h.this.jFZ != null && h.this.jFZ.bnB().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.zV(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.jEV != null && h.this.jEV.getPageContext() != null && h.this.jGa && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bX(i, str)) {
                            AntiHelper.bq(h.this.jEV.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.jEV.showToast(str);
                        }
                    }
                }
            });
        }
        return this.jGb;
    }

    public void zV(int i) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList;
        FrsViewData cDg = this.jEV.cDg();
        if (cDg != null && this.jgv != null && (threadList = cDg.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof ca) {
                    cb cbVar = ((ca) next).eJQ;
                    if (cbVar == this.jFZ) {
                        c(cbVar, i);
                        this.jFZ = null;
                        break;
                    } else if (cbVar.getId() != null && cbVar.getId().equals(this.jDw)) {
                        c(cbVar, i);
                        this.jDw = null;
                        break;
                    }
                }
            }
            this.jgv.cEb().b(threadList, cDg);
            this.jgv.cEb().notifyDataSetChanged();
        }
    }

    public void c(cb cbVar, int i) {
        if (cbVar != null) {
            if (i == 1) {
                PraiseData bnB = cbVar.bnB();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bnB == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cbVar.a(praiseData);
                        return;
                    }
                    cbVar.bnB().getUser().add(0, metaData);
                    cbVar.bnB().setNum(cbVar.bnB().getNum() + 1);
                    cbVar.bnB().setIsLike(i);
                }
            } else if (cbVar.bnB() != null) {
                cbVar.bnB().setIsLike(i);
                cbVar.bnB().setNum(cbVar.bnB().getNum() - 1);
                ArrayList<MetaData> user = cbVar.bnB().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cbVar.bnB().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void rv(boolean z) {
        this.jGa = z;
    }
}
