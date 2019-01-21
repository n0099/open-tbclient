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
    private String ebR;
    private final CustomMessageListener ebZ;
    private bb eeg;
    private boolean eeh;
    private PraiseModel eei;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.ebZ = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    f.this.ebR = bbVar.getId();
                    if (!TextUtils.isEmpty(f.this.ebR) && bbVar.zG() != null) {
                        f.this.nj(bbVar.zG().getIsLike());
                    }
                }
            }
        };
        this.edn.registerListener(this.ebZ);
        this.eei = aHK();
    }

    public final PraiseModel aHK() {
        if (this.eei == null) {
            this.eei = new PraiseModel(this.edn.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void kt(String str) {
                    int i = 1;
                    if (f.this.eeh) {
                        if (f.this.eeg != null && f.this.eeg.zG().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.nj(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void P(int i, String str) {
                    if (f.this.edn != null && f.this.edn.getPageContext() != null && f.this.eeh && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.al(i, str)) {
                            AntiHelper.aH(f.this.edn.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.edn.showToast(str);
                        }
                    }
                }
            });
        }
        return this.eei;
    }

    public void nj(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l aCl = this.edn.aCl();
        if (aCl != null && this.dLB != null && (threadList = aCl.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar == this.eeg) {
                        b(bbVar, i);
                        this.eeg = null;
                        break;
                    } else if (bbVar.getId() != null && bbVar.getId().equals(this.ebR)) {
                        b(bbVar, i);
                        this.ebR = null;
                        break;
                    }
                }
            }
            this.dLB.aDb().b(threadList, aCl);
            this.dLB.aDb().notifyDataSetChanged();
        }
    }

    public void b(bb bbVar, int i) {
        if (bbVar != null) {
            if (i == 1) {
                PraiseData zG = bbVar.zG();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (zG == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bbVar.a(praiseData);
                        return;
                    }
                    bbVar.zG().getUser().add(0, metaData);
                    bbVar.zG().setNum(bbVar.zG().getNum() + 1);
                    bbVar.zG().setIsLike(i);
                }
            } else if (bbVar.zG() != null) {
                bbVar.zG().setIsLike(i);
                bbVar.zG().setNum(bbVar.zG().getNum() - 1);
                ArrayList<MetaData> user = bbVar.zG().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bbVar.zG().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void hs(boolean z) {
        this.eeh = z;
    }
}
