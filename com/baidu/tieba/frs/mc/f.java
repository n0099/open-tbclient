package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class f extends h {
    private final CustomMessageListener ayc;
    private bc dBD;
    private boolean dBE;
    private PraiseModel dBF;
    private String dqa;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.ayc = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bc)) {
                    bc bcVar = (bc) customResponsedMessage.getData();
                    f.this.dqa = bcVar.getId();
                    if (!TextUtils.isEmpty(f.this.dqa) && bcVar.vj() != null) {
                        f.this.kD(bcVar.vj().getIsLike());
                    }
                }
            }
        };
        this.dAK.registerListener(this.ayc);
        this.dBF = azl();
    }

    public final PraiseModel azl() {
        if (this.dBF == null) {
            this.dBF = new PraiseModel(this.dAK.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void iV(String str) {
                    int i = 1;
                    if (f.this.dBE) {
                        if (f.this.dBD != null && f.this.dBD.vj().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.kD(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void O(int i, String str) {
                    if (f.this.dAK != null && f.this.dAK.getPageContext() != null && f.this.dBE && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.tQ(i)) {
                            AntiHelper.ao(f.this.dAK.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dAK.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dBF;
    }

    public void kD(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l atZ = this.dAK.atZ();
        if (atZ != null && this.djA != null && (threadList = atZ.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bc) {
                    bc bcVar = (bc) next;
                    if (bcVar == this.dBD) {
                        a(bcVar, i);
                        this.dBD = null;
                        break;
                    } else if (bcVar.getId() != null && bcVar.getId().equals(this.dqa)) {
                        a(bcVar, i);
                        this.dqa = null;
                        break;
                    }
                }
            }
            this.djA.auQ().b(threadList, atZ);
            this.djA.auQ().notifyDataSetChanged();
        }
    }

    public void a(bc bcVar, int i) {
        if (bcVar != null) {
            if (i == 1) {
                PraiseData vj = bcVar.vj();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (vj == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bcVar.a(praiseData);
                        return;
                    }
                    bcVar.vj().getUser().add(0, metaData);
                    bcVar.vj().setNum(bcVar.vj().getNum() + 1);
                    bcVar.vj().setIsLike(i);
                }
            } else if (bcVar.vj() != null) {
                bcVar.vj().setIsLike(i);
                bcVar.vj().setNum(bcVar.vj().getNum() - 1);
                ArrayList<MetaData> user = bcVar.vj().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bcVar.vj().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void gk(boolean z) {
        this.dBE = z;
    }
}
