package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class f extends h {
    private final CustomMessageListener bbX;
    private String dJG;
    private be dLD;
    private boolean dLE;
    private PraiseModel dLF;

    public f(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.bbX = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be)) {
                    be beVar = (be) customResponsedMessage.getData();
                    f.this.dJG = beVar.getId();
                    if (!TextUtils.isEmpty(f.this.dJG) && beVar.yM() != null) {
                        f.this.nz(beVar.yM().getIsLike());
                    }
                }
            }
        };
        this.dKN.registerListener(this.bbX);
        this.dLF = axt();
    }

    public final PraiseModel axt() {
        if (this.dLF == null) {
            this.dLF = new PraiseModel(this.dKN.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hY(String str) {
                    int i = 1;
                    if (f.this.dLE) {
                        if (f.this.dLD != null && f.this.dLD.yM().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.nz(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void E(int i, String str) {
                    if (f.this.dKN != null && f.this.dKN.getPageContext() != null && f.this.dLE && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.xo(i)) {
                            AntiHelper.ap(f.this.dKN.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dKN.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dLF;
    }

    public void nz(int i) {
        ArrayList<com.baidu.adp.widget.ListView.i> threadList;
        l atn = this.dKN.atn();
        if (atn != null && this.dwH != null && (threadList = atn.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next instanceof be) {
                    be beVar = (be) next;
                    if (beVar == this.dLD) {
                        c(beVar, i);
                        this.dLD = null;
                        break;
                    } else if (beVar.getId() != null && beVar.getId().equals(this.dJG)) {
                        c(beVar, i);
                        this.dJG = null;
                        break;
                    }
                }
            }
            this.dwH.atM().b(threadList, atn);
            this.dwH.atM().notifyDataSetChanged();
        }
    }

    public void c(be beVar, int i) {
        if (beVar != null) {
            if (i == 1) {
                PraiseData yM = beVar.yM();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (yM == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        beVar.a(praiseData);
                        return;
                    }
                    beVar.yM().getUser().add(0, metaData);
                    beVar.yM().setNum(beVar.yM().getNum() + 1);
                    beVar.yM().setIsLike(i);
                }
            } else if (beVar.yM() != null) {
                beVar.yM().setIsLike(i);
                beVar.yM().setNum(beVar.yM().getNum() - 1);
                ArrayList<MetaData> user = beVar.yM().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            beVar.yM().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fZ(boolean z) {
        this.dLE = z;
    }
}
