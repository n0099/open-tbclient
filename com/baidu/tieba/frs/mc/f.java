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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class f extends h {
    private final CustomMessageListener bbX;
    private String dOi;
    private bd dQf;
    private boolean dQg;
    private PraiseModel dQh;

    public f(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.bbX = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    f.this.dOi = bdVar.getId();
                    if (!TextUtils.isEmpty(f.this.dOi) && bdVar.yH() != null) {
                        f.this.nC(bdVar.yH().getIsLike());
                    }
                }
            }
        };
        this.dPp.registerListener(this.bbX);
        this.dQh = ayw();
    }

    public final PraiseModel ayw() {
        if (this.dQh == null) {
            this.dQh = new PraiseModel(this.dPp.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hZ(String str) {
                    int i = 1;
                    if (f.this.dQg) {
                        if (f.this.dQf != null && f.this.dQf.yH().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.nC(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void F(int i, String str) {
                    if (f.this.dPp != null && f.this.dPp.getPageContext() != null && f.this.dQg && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.vQ(i)) {
                            AntiHelper.ao(f.this.dPp.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dPp.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dQh;
    }

    public void nC(int i) {
        ArrayList<com.baidu.adp.widget.ListView.i> threadList;
        l auq = this.dPp.auq();
        if (auq != null && this.dBi != null && (threadList = auq.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar == this.dQf) {
                        c(bdVar, i);
                        this.dQf = null;
                        break;
                    } else if (bdVar.getId() != null && bdVar.getId().equals(this.dOi)) {
                        c(bdVar, i);
                        this.dOi = null;
                        break;
                    }
                }
            }
            this.dBi.auP().b(threadList, auq);
            this.dBi.auP().notifyDataSetChanged();
        }
    }

    public void c(bd bdVar, int i) {
        if (bdVar != null) {
            if (i == 1) {
                PraiseData yH = bdVar.yH();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (yH == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bdVar.a(praiseData);
                        return;
                    }
                    bdVar.yH().getUser().add(0, metaData);
                    bdVar.yH().setNum(bdVar.yH().getNum() + 1);
                    bdVar.yH().setIsLike(i);
                }
            } else if (bdVar.yH() != null) {
                bdVar.yH().setIsLike(i);
                bdVar.yH().setNum(bdVar.yH().getNum() - 1);
                ArrayList<MetaData> user = bdVar.yH().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bdVar.yH().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void gd(boolean z) {
        this.dQg = z;
    }
}
