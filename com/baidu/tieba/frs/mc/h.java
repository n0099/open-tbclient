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
    private final CustomMessageListener fMF;
    private String fMw;
    private bh fPe;
    private boolean fPf;
    private PraiseModel fPg;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fMF = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    h.this.fMw = bhVar.getId();
                    if (!TextUtils.isEmpty(h.this.fMw) && bhVar.ais() != null) {
                        h.this.rs(bhVar.ais().getIsLike());
                    }
                }
            }
        };
        this.fNY.registerListener(this.fMF);
        this.fPg = bpz();
    }

    public final PraiseModel bpz() {
        if (this.fPg == null) {
            this.fPg = new PraiseModel(this.fNY.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void rM(String str) {
                    int i = 1;
                    if (h.this.fPf) {
                        if (h.this.fPe != null && h.this.fPe.ais().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.rs(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.fNY != null && h.this.fNY.getPageContext() != null && h.this.fPf && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.aH(i, str)) {
                            AntiHelper.aS(h.this.fNY.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.fNY.showToast(str);
                        }
                    }
                }
            });
        }
        return this.fPg;
    }

    public void rs(int i) {
        ArrayList<m> threadList;
        FrsViewData bkp = this.fNY.bkp();
        if (bkp != null && this.fvo != null && (threadList = bkp.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bg) {
                    bh bhVar = ((bg) next).cbq;
                    if (bhVar == this.fPe) {
                        c(bhVar, i);
                        this.fPe = null;
                        break;
                    } else if (bhVar.getId() != null && bhVar.getId().equals(this.fMw)) {
                        c(bhVar, i);
                        this.fMw = null;
                        break;
                    }
                }
            }
            this.fvo.ble().b(threadList, bkp);
            this.fvo.ble().notifyDataSetChanged();
        }
    }

    public void c(bh bhVar, int i) {
        if (bhVar != null) {
            if (i == 1) {
                PraiseData ais = bhVar.ais();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (ais == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bhVar.a(praiseData);
                        return;
                    }
                    bhVar.ais().getUser().add(0, metaData);
                    bhVar.ais().setNum(bhVar.ais().getNum() + 1);
                    bhVar.ais().setIsLike(i);
                }
            } else if (bhVar.ais() != null) {
                bhVar.ais().setIsLike(i);
                bhVar.ais().setNum(bhVar.ais().getNum() - 1);
                ArrayList<MetaData> user = bhVar.ais().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bhVar.ais().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void kA(boolean z) {
        this.fPf = z;
    }
}
