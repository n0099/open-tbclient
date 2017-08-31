package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g extends i {
    private final CustomMessageListener aom;
    private bj cDO;
    private PraiseModel cDP;
    private boolean cyq;
    private String cyr;

    public g(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.aom = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    g.this.cyr = bjVar.getId();
                    if (!TextUtils.isEmpty(g.this.cyr) && bjVar.rr() != null) {
                        g.this.jo(bjVar.rr().getIsLike());
                    }
                }
            }
        };
        this.cvA.registerListener(this.aom);
        this.cDP = akU();
    }

    public final PraiseModel akU() {
        if (this.cDP == null) {
            this.cDP = new PraiseModel(this.cvA.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.g.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hO(String str) {
                    int i = 1;
                    if (g.this.cyq) {
                        if (g.this.cDO != null && g.this.cDO.rr().getIsLike() == 1) {
                            i = 0;
                        }
                        g.this.jo(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void B(int i, String str) {
                    if (g.this.cvA != null && g.this.cvA.getPageContext() != null && g.this.cyq && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.tz(i)) {
                            AntiHelper.ar(g.this.cvA.getPageContext().getPageActivity(), str);
                        } else {
                            g.this.cvA.showToast(str);
                        }
                    }
                }
            });
        }
        return this.cDP;
    }

    public void jo(int i) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        com.baidu.tieba.tbadkCore.i ahf = this.cvA.ahf();
        if (ahf != null && this.cpe != null && (threadList = ahf.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof bj) {
                    bj bjVar = (bj) next;
                    if (bjVar == this.cDO) {
                        c(bjVar, i);
                        this.cDO = null;
                        break;
                    } else if (bjVar.getId() != null && bjVar.getId().equals(this.cyr)) {
                        c(bjVar, i);
                        this.cyr = null;
                        break;
                    }
                }
            }
            this.cpe.ahG().b(threadList, ahf);
            this.cpe.ahG().notifyDataSetChanged();
        }
    }

    public void c(bj bjVar, int i) {
        if (bjVar != null) {
            if (i == 1) {
                PraiseData rr = bjVar.rr();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rr == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bjVar.a(praiseData);
                        return;
                    }
                    bjVar.rr().getUser().add(0, metaData);
                    bjVar.rr().setNum(bjVar.rr().getNum() + 1);
                    bjVar.rr().setIsLike(i);
                }
            } else if (bjVar.rr() != null) {
                bjVar.rr().setIsLike(i);
                bjVar.rr().setNum(bjVar.rr().getNum() - 1);
                ArrayList<MetaData> user = bjVar.rr().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bjVar.rr().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fj(boolean z) {
        this.cyq = z;
    }
}
