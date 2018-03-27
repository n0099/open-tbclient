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
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class f extends h {
    private final CustomMessageListener bdM;
    private String dRA;
    private bd dTE;
    private boolean dTF;
    private PraiseModel dTG;

    public f(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.bdM = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    f.this.dRA = bdVar.getId();
                    if (!TextUtils.isEmpty(f.this.dRA) && bdVar.zc() != null) {
                        f.this.nB(bdVar.zc().getIsLike());
                    }
                }
            }
        };
        this.dSO.registerListener(this.bdM);
        this.dTG = azE();
    }

    public final PraiseModel azE() {
        if (this.dTG == null) {
            this.dTG = new PraiseModel(this.dSO.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void ir(String str) {
                    int i = 1;
                    if (f.this.dTF) {
                        if (f.this.dTE != null && f.this.dTE.zc().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.nB(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void I(int i, String str) {
                    if (f.this.dSO != null && f.this.dSO.getPageContext() != null && f.this.dTF && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.vR(i)) {
                            AntiHelper.ar(f.this.dSO.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dSO.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dTG;
    }

    public void nB(int i) {
        ArrayList<com.baidu.adp.widget.ListView.i> threadList;
        m avl = this.dSO.avl();
        if (avl != null && this.dEo != null && (threadList = avl.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar == this.dTE) {
                        c(bdVar, i);
                        this.dTE = null;
                        break;
                    } else if (bdVar.getId() != null && bdVar.getId().equals(this.dRA)) {
                        c(bdVar, i);
                        this.dRA = null;
                        break;
                    }
                }
            }
            this.dEo.avX().b(threadList, avl);
            this.dEo.avX().notifyDataSetChanged();
        }
    }

    public void c(bd bdVar, int i) {
        if (bdVar != null) {
            if (i == 1) {
                PraiseData zc = bdVar.zc();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (zc == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bdVar.a(praiseData);
                        return;
                    }
                    bdVar.zc().getUser().add(0, metaData);
                    bdVar.zc().setNum(bdVar.zc().getNum() + 1);
                    bdVar.zc().setIsLike(i);
                }
            } else if (bdVar.zc() != null) {
                bdVar.zc().setIsLike(i);
                bdVar.zc().setNum(bdVar.zc().getNum() - 1);
                ArrayList<MetaData> user = bdVar.zc().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bdVar.zc().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void gr(boolean z) {
        this.dTF = z;
    }
}
