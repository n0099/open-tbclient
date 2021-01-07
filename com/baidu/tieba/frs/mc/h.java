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
    private String jCi;
    private final CustomMessageListener jCq;
    private bz jEN;
    private boolean jEO;
    private PraiseModel jEP;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.jCq = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bz)) {
                    bz bzVar = (bz) customResponsedMessage.getData();
                    h.this.jCi = bzVar.getId();
                    if (!TextUtils.isEmpty(h.this.jCi) && bzVar.brc() != null) {
                        h.this.Br(bzVar.brc().getIsLike());
                    }
                }
            }
        };
        this.jDI.registerListener(this.jCq);
        this.jEP = cMz();
    }

    public final PraiseModel cMz() {
        if (this.jEP == null) {
            this.jEP = new PraiseModel(this.jDI.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void FN(String str) {
                    int i = 1;
                    if (h.this.jEO) {
                        if (h.this.jEN != null && h.this.jEN.brc().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.Br(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.jDI != null && h.this.jDI.getPageContext() != null && h.this.jEO && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bP(i, str)) {
                            AntiHelper.bs(h.this.jDI.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.jDI.showToast(str);
                        }
                    }
                }
            });
        }
        return this.jEP;
    }

    public void Br(int i) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList;
        FrsViewData cFF = this.jDI.cFF();
        if (cFF != null && this.jfi != null && (threadList = cFF.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof by) {
                    bz bzVar = ((by) next).eMv;
                    if (bzVar == this.jEN) {
                        c(bzVar, i);
                        this.jEN = null;
                        break;
                    } else if (bzVar.getId() != null && bzVar.getId().equals(this.jCi)) {
                        c(bzVar, i);
                        this.jCi = null;
                        break;
                    }
                }
            }
            this.jfi.cGA().b(threadList, cFF);
            this.jfi.cGA().notifyDataSetChanged();
        }
    }

    public void c(bz bzVar, int i) {
        if (bzVar != null) {
            if (i == 1) {
                PraiseData brc = bzVar.brc();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (brc == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bzVar.a(praiseData);
                        return;
                    }
                    bzVar.brc().getUser().add(0, metaData);
                    bzVar.brc().setNum(bzVar.brc().getNum() + 1);
                    bzVar.brc().setIsLike(i);
                }
            } else if (bzVar.brc() != null) {
                bzVar.brc().setIsLike(i);
                bzVar.brc().setNum(bzVar.brc().getNum() - 1);
                ArrayList<MetaData> user = bzVar.brc().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bzVar.brc().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void rp(boolean z) {
        this.jEO = z;
    }
}
