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
/* loaded from: classes2.dex */
public class f extends h {
    private final CustomMessageListener axI;
    private bb dEp;
    private boolean dEq;
    private PraiseModel dEr;
    private String dsN;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.axI = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    f.this.dsN = bbVar.getId();
                    if (!TextUtils.isEmpty(f.this.dsN) && bbVar.uX() != null) {
                        f.this.kO(bbVar.uX().getIsLike());
                    }
                }
            }
        };
        this.dDw.registerListener(this.axI);
        this.dEr = azR();
    }

    public final PraiseModel azR() {
        if (this.dEr == null) {
            this.dEr = new PraiseModel(this.dDw.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void iS(String str) {
                    int i = 1;
                    if (f.this.dEq) {
                        if (f.this.dEp != null && f.this.dEp.uX().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.kO(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void Q(int i, String str) {
                    if (f.this.dDw != null && f.this.dDw.getPageContext() != null && f.this.dEq && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.al(i, str)) {
                            AntiHelper.aq(f.this.dDw.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dDw.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dEr;
    }

    public void kO(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l auD = this.dDw.auD();
        if (auD != null && this.dmq != null && (threadList = auD.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar == this.dEp) {
                        a(bbVar, i);
                        this.dEp = null;
                        break;
                    } else if (bbVar.getId() != null && bbVar.getId().equals(this.dsN)) {
                        a(bbVar, i);
                        this.dsN = null;
                        break;
                    }
                }
            }
            this.dmq.avu().b(threadList, auD);
            this.dmq.avu().notifyDataSetChanged();
        }
    }

    public void a(bb bbVar, int i) {
        if (bbVar != null) {
            if (i == 1) {
                PraiseData uX = bbVar.uX();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (uX == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bbVar.a(praiseData);
                        return;
                    }
                    bbVar.uX().getUser().add(0, metaData);
                    bbVar.uX().setNum(bbVar.uX().getNum() + 1);
                    bbVar.uX().setIsLike(i);
                }
            } else if (bbVar.uX() != null) {
                bbVar.uX().setIsLike(i);
                bbVar.uX().setNum(bbVar.uX().getNum() - 1);
                ArrayList<MetaData> user = bbVar.uX().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bbVar.uX().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void gm(boolean z) {
        this.dEq = z;
    }
}
