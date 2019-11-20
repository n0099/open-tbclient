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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class h extends j {
    private String fLF;
    private final CustomMessageListener fLO;
    private bh fOn;
    private boolean fOo;
    private PraiseModel fOp;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fLO = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    h.this.fLF = bhVar.getId();
                    if (!TextUtils.isEmpty(h.this.fLF) && bhVar.aiq() != null) {
                        h.this.rr(bhVar.aiq().getIsLike());
                    }
                }
            }
        };
        this.fNh.registerListener(this.fLO);
        this.fOp = bpx();
    }

    public final PraiseModel bpx() {
        if (this.fOp == null) {
            this.fOp = new PraiseModel(this.fNh.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void rM(String str) {
                    int i = 1;
                    if (h.this.fOo) {
                        if (h.this.fOn != null && h.this.fOn.aiq().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.rr(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.fNh != null && h.this.fNh.getPageContext() != null && h.this.fOo && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.aG(i, str)) {
                            AntiHelper.aS(h.this.fNh.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.fNh.showToast(str);
                        }
                    }
                }
            });
        }
        return this.fOp;
    }

    public void rr(int i) {
        ArrayList<m> threadList;
        FrsViewData bkn = this.fNh.bkn();
        if (bkn != null && this.fux != null && (threadList = bkn.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bg) {
                    bh bhVar = ((bg) next).caz;
                    if (bhVar == this.fOn) {
                        c(bhVar, i);
                        this.fOn = null;
                        break;
                    } else if (bhVar.getId() != null && bhVar.getId().equals(this.fLF)) {
                        c(bhVar, i);
                        this.fLF = null;
                        break;
                    }
                }
            }
            this.fux.blc().b(threadList, bkn);
            this.fux.blc().notifyDataSetChanged();
        }
    }

    public void c(bh bhVar, int i) {
        if (bhVar != null) {
            if (i == 1) {
                PraiseData aiq = bhVar.aiq();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aiq == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bhVar.a(praiseData);
                        return;
                    }
                    bhVar.aiq().getUser().add(0, metaData);
                    bhVar.aiq().setNum(bhVar.aiq().getNum() + 1);
                    bhVar.aiq().setIsLike(i);
                }
            } else if (bhVar.aiq() != null) {
                bhVar.aiq().setIsLike(i);
                bhVar.aiq().setNum(bhVar.aiq().getNum() - 1);
                ArrayList<MetaData> user = bhVar.aiq().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bhVar.aiq().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void kA(boolean z) {
        this.fOo = z;
    }
}
