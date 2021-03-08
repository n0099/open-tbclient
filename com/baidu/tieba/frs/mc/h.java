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
    private String jFf;
    private final CustomMessageListener jFn;
    private cb jHI;
    private boolean jHJ;
    private PraiseModel jHK;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.jFn = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof cb)) {
                    cb cbVar = (cb) customResponsedMessage.getData();
                    h.this.jFf = cbVar.getId();
                    if (!TextUtils.isEmpty(h.this.jFf) && cbVar.bnD() != null) {
                        h.this.zW(cbVar.bnD().getIsLike());
                    }
                }
            }
        };
        this.jGE.registerListener(this.jFn);
        this.jHK = cKh();
    }

    public final PraiseModel cKh() {
        if (this.jHK == null) {
            this.jHK = new PraiseModel(this.jGE.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void Fi(String str) {
                    int i = 1;
                    if (h.this.jHJ) {
                        if (h.this.jHI != null && h.this.jHI.bnD().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.zW(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.jGE != null && h.this.jGE.getPageContext() != null && h.this.jHJ && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bX(i, str)) {
                            AntiHelper.bq(h.this.jGE.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.jGE.showToast(str);
                        }
                    }
                }
            });
        }
        return this.jHK;
    }

    public void zW(int i) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList;
        FrsViewData cDm = this.jGE.cDm();
        if (cDm != null && this.jif != null && (threadList = cDm.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof ca) {
                    cb cbVar = ((ca) next).eLr;
                    if (cbVar == this.jHI) {
                        c(cbVar, i);
                        this.jHI = null;
                        break;
                    } else if (cbVar.getId() != null && cbVar.getId().equals(this.jFf)) {
                        c(cbVar, i);
                        this.jFf = null;
                        break;
                    }
                }
            }
            this.jif.cEh().b(threadList, cDm);
            this.jif.cEh().notifyDataSetChanged();
        }
    }

    public void c(cb cbVar, int i) {
        if (cbVar != null) {
            if (i == 1) {
                PraiseData bnD = cbVar.bnD();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bnD == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cbVar.a(praiseData);
                        return;
                    }
                    cbVar.bnD().getUser().add(0, metaData);
                    cbVar.bnD().setNum(cbVar.bnD().getNum() + 1);
                    cbVar.bnD().setIsLike(i);
                }
            } else if (cbVar.bnD() != null) {
                cbVar.bnD().setIsLike(i);
                cbVar.bnD().setNum(cbVar.bnD().getNum() - 1);
                ArrayList<MetaData> user = cbVar.bnD().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cbVar.bnD().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void rv(boolean z) {
        this.jHJ = z;
    }
}
