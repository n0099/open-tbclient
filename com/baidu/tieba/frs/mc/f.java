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
    private String dRR;
    private final CustomMessageListener dRZ;
    private bb dUf;
    private boolean dUg;
    private PraiseModel dUh;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.dRZ = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    f.this.dRR = bbVar.getId();
                    if (!TextUtils.isEmpty(f.this.dRR) && bbVar.yp() != null) {
                        f.this.mF(bbVar.yp().getIsLike());
                    }
                }
            }
        };
        this.dTm.registerListener(this.dRZ);
        this.dUh = aEM();
    }

    public final PraiseModel aEM() {
        if (this.dUh == null) {
            this.dUh = new PraiseModel(this.dTm.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void jK(String str) {
                    int i = 1;
                    if (f.this.dUg) {
                        if (f.this.dUf != null && f.this.dUf.yp().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.mF(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void M(int i, String str) {
                    if (f.this.dTm != null && f.this.dTm.getPageContext() != null && f.this.dUg && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.ai(i, str)) {
                            AntiHelper.aG(f.this.dTm.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dTm.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dUh;
    }

    public void mF(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l azp = this.dTm.azp();
        if (azp != null && this.dBE != null && (threadList = azp.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar == this.dUf) {
                        a(bbVar, i);
                        this.dUf = null;
                        break;
                    } else if (bbVar.getId() != null && bbVar.getId().equals(this.dRR)) {
                        a(bbVar, i);
                        this.dRR = null;
                        break;
                    }
                }
            }
            this.dBE.aAf().b(threadList, azp);
            this.dBE.aAf().notifyDataSetChanged();
        }
    }

    public void a(bb bbVar, int i) {
        if (bbVar != null) {
            if (i == 1) {
                PraiseData yp = bbVar.yp();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (yp == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bbVar.a(praiseData);
                        return;
                    }
                    bbVar.yp().getUser().add(0, metaData);
                    bbVar.yp().setNum(bbVar.yp().getNum() + 1);
                    bbVar.yp().setIsLike(i);
                }
            } else if (bbVar.yp() != null) {
                bbVar.yp().setIsLike(i);
                bbVar.yp().setNum(bbVar.yp().getNum() - 1);
                ArrayList<MetaData> user = bbVar.yp().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bbVar.yp().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void hk(boolean z) {
        this.dUg = z;
    }
}
