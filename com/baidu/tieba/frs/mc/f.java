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
    private String dHp;
    private final CustomMessageListener dHq;
    private bb dSZ;
    private boolean dTa;
    private PraiseModel dTb;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.dHq = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    f.this.dHp = bbVar.getId();
                    if (!TextUtils.isEmpty(f.this.dHp) && bbVar.yi() != null) {
                        f.this.lO(bbVar.yi().getIsLike());
                    }
                }
            }
        };
        this.dSg.registerListener(this.dHq);
        this.dTb = aFq();
    }

    public final PraiseModel aFq() {
        if (this.dTb == null) {
            this.dTb = new PraiseModel(this.dSg.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void jI(String str) {
                    int i = 1;
                    if (f.this.dTa) {
                        if (f.this.dSZ != null && f.this.dSZ.yi().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.lO(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void Q(int i, String str) {
                    if (f.this.dSg != null && f.this.dSg.getPageContext() != null && f.this.dTa && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.am(i, str)) {
                            AntiHelper.aI(f.this.dSg.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dSg.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dTb;
    }

    public void lO(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l azS = this.dSg.azS();
        if (azS != null && this.dAn != null && (threadList = azS.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar == this.dSZ) {
                        a(bbVar, i);
                        this.dSZ = null;
                        break;
                    } else if (bbVar.getId() != null && bbVar.getId().equals(this.dHp)) {
                        a(bbVar, i);
                        this.dHp = null;
                        break;
                    }
                }
            }
            this.dAn.aAI().b(threadList, azS);
            this.dAn.aAI().notifyDataSetChanged();
        }
    }

    public void a(bb bbVar, int i) {
        if (bbVar != null) {
            if (i == 1) {
                PraiseData yi = bbVar.yi();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (yi == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bbVar.a(praiseData);
                        return;
                    }
                    bbVar.yi().getUser().add(0, metaData);
                    bbVar.yi().setNum(bbVar.yi().getNum() + 1);
                    bbVar.yi().setIsLike(i);
                }
            } else if (bbVar.yi() != null) {
                bbVar.yi().setIsLike(i);
                bbVar.yi().setNum(bbVar.yi().getNum() - 1);
                ArrayList<MetaData> user = bbVar.yi().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bbVar.yi().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void ha(boolean z) {
        this.dTa = z;
    }
}
