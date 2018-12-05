package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class f extends h {
    private final CustomMessageListener dYB;
    private String dYt;
    private bb eaI;
    private boolean eaJ;
    private PraiseModel eaK;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.dYB = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    f.this.dYt = bbVar.getId();
                    if (!TextUtils.isEmpty(f.this.dYt) && bbVar.zt() != null) {
                        f.this.mV(bbVar.zt().getIsLike());
                    }
                }
            }
        };
        this.dZP.registerListener(this.dYB);
        this.eaK = aGy();
    }

    public final PraiseModel aGy() {
        if (this.eaK == null) {
            this.eaK = new PraiseModel(this.dZP.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void kc(String str) {
                    int i = 1;
                    if (f.this.eaJ) {
                        if (f.this.eaI != null && f.this.eaI.zt().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.mV(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void M(int i, String str) {
                    if (f.this.dZP != null && f.this.dZP.getPageContext() != null && f.this.eaJ && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.ai(i, str)) {
                            AntiHelper.aJ(f.this.dZP.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dZP.showToast(str);
                        }
                    }
                }
            });
        }
        return this.eaK;
    }

    public void mV(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l aAZ = this.dZP.aAZ();
        if (aAZ != null && this.dId != null && (threadList = aAZ.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar == this.eaI) {
                        a(bbVar, i);
                        this.eaI = null;
                        break;
                    } else if (bbVar.getId() != null && bbVar.getId().equals(this.dYt)) {
                        a(bbVar, i);
                        this.dYt = null;
                        break;
                    }
                }
            }
            this.dId.aBP().b(threadList, aAZ);
            this.dId.aBP().notifyDataSetChanged();
        }
    }

    public void a(bb bbVar, int i) {
        if (bbVar != null) {
            if (i == 1) {
                PraiseData zt = bbVar.zt();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (zt == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bbVar.a(praiseData);
                        return;
                    }
                    bbVar.zt().getUser().add(0, metaData);
                    bbVar.zt().setNum(bbVar.zt().getNum() + 1);
                    bbVar.zt().setIsLike(i);
                }
            } else if (bbVar.zt() != null) {
                bbVar.zt().setIsLike(i);
                bbVar.zt().setNum(bbVar.zt().getNum() - 1);
                ArrayList<MetaData> user = bbVar.zt().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bbVar.zt().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void hm(boolean z) {
        this.eaJ = z;
    }
}
