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
    private String ddB;
    private bd doX;
    private boolean doY;
    private PraiseModel doZ;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.apd = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    f.this.ddB = bdVar.getId();
                    if (!TextUtils.isEmpty(f.this.ddB) && bdVar.rE() != null) {
                        f.this.kr(bdVar.rE().getIsLike());
                    }
                }
            }
        };
        this.dof.registerListener(this.apd);
        this.doZ = aus();
    }

    public final PraiseModel aus() {
        if (this.doZ == null) {
            this.doZ = new PraiseModel(this.dof.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void io(String str) {
                    int i = 1;
                    if (f.this.doY) {
                        if (f.this.doX != null && f.this.doX.rE().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.kr(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void R(int i, String str) {
                    if (f.this.dof != null && f.this.dof.getPageContext() != null && f.this.doY && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.ts(i)) {
                            AntiHelper.am(f.this.dof.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dof.showToast(str);
                        }
                    }
                }
            });
        }
        return this.doZ;
    }

    public void kr(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l apD = this.dof.apD();
        if (apD != null && this.cYo != null && (threadList = apD.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar == this.doX) {
                        a(bdVar, i);
                        this.doX = null;
                        break;
                    } else if (bdVar.getId() != null && bdVar.getId().equals(this.ddB)) {
                        a(bdVar, i);
                        this.ddB = null;
                        break;
                    }
                }
            }
            this.cYo.aqs().b(threadList, apD);
            this.cYo.aqs().notifyDataSetChanged();
        }
    }

    public void a(bd bdVar, int i) {
        if (bdVar != null) {
            if (i == 1) {
                PraiseData rE = bdVar.rE();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rE == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bdVar.a(praiseData);
                        return;
                    }
                    bdVar.rE().getUser().add(0, metaData);
                    bdVar.rE().setNum(bdVar.rE().getNum() + 1);
                    bdVar.rE().setIsLike(i);
                }
            } else if (bdVar.rE() != null) {
                bdVar.rE().setIsLike(i);
                bdVar.rE().setNum(bdVar.rE().getNum() - 1);
                ArrayList<MetaData> user = bdVar.rE().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bdVar.rE().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fU(boolean z) {
        this.doY = z;
    }
}
