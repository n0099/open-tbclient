package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class f extends h {
    private final CustomMessageListener apd;
    private String dcw;
    private bd dnS;
    private boolean dnT;
    private PraiseModel dnU;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.apd = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    f.this.dcw = bdVar.getId();
                    if (!TextUtils.isEmpty(f.this.dcw) && bdVar.rF() != null) {
                        f.this.ks(bdVar.rF().getIsLike());
                    }
                }
            }
        };
        this.dmZ.registerListener(this.apd);
        this.dnU = aut();
    }

    public final PraiseModel aut() {
        if (this.dnU == null) {
            this.dnU = new PraiseModel(this.dmZ.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void in(String str) {
                    int i = 1;
                    if (f.this.dnT) {
                        if (f.this.dnS != null && f.this.dnS.rF().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.ks(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void R(int i, String str) {
                    if (f.this.dmZ != null && f.this.dmZ.getPageContext() != null && f.this.dnT && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.tt(i)) {
                            AntiHelper.am(f.this.dmZ.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dmZ.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dnU;
    }

    public void ks(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l apE = this.dmZ.apE();
        if (apE != null && this.cXk != null && (threadList = apE.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar == this.dnS) {
                        a(bdVar, i);
                        this.dnS = null;
                        break;
                    } else if (bdVar.getId() != null && bdVar.getId().equals(this.dcw)) {
                        a(bdVar, i);
                        this.dcw = null;
                        break;
                    }
                }
            }
            this.cXk.aqt().b(threadList, apE);
            this.cXk.aqt().notifyDataSetChanged();
        }
    }

    public void a(bd bdVar, int i) {
        if (bdVar != null) {
            if (i == 1) {
                PraiseData rF = bdVar.rF();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rF == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bdVar.a(praiseData);
                        return;
                    }
                    bdVar.rF().getUser().add(0, metaData);
                    bdVar.rF().setNum(bdVar.rF().getNum() + 1);
                    bdVar.rF().setIsLike(i);
                }
            } else if (bdVar.rF() != null) {
                bdVar.rF().setIsLike(i);
                bdVar.rF().setNum(bdVar.rF().getNum() - 1);
                ArrayList<MetaData> user = bdVar.rF().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bdVar.rF().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fT(boolean z) {
        this.dnT = z;
    }
}
