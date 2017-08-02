package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g extends i {
    private final CustomMessageListener anw;
    private boolean cpT;
    private String cpU;
    private bl ctR;
    private PraiseModel ctS;

    public g(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.anw = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl)) {
                    bl blVar = (bl) customResponsedMessage.getData();
                    g.this.cpU = blVar.getId();
                    if (!TextUtils.isEmpty(g.this.cpU) && blVar.rl() != null) {
                        g.this.iY(blVar.rl().getIsLike());
                    }
                }
            }
        };
        this.cna.registerListener(this.anw);
        this.ctS = aiy();
    }

    public final PraiseModel aiy() {
        if (this.ctS == null) {
            this.ctS = new PraiseModel(this.cna.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.g.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hJ(String str) {
                    int i = 1;
                    if (g.this.cpT) {
                        if (g.this.ctR != null && g.this.ctR.rl().getIsLike() == 1) {
                            i = 0;
                        }
                        g.this.iY(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void A(int i, String str) {
                    if (g.this.cpT && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.to(i)) {
                            AntiHelper.ar(g.this.cna.getPageContext().getPageActivity(), str);
                        } else {
                            g.this.cna.showToast(str);
                        }
                    }
                }
            });
        }
        return this.ctS;
    }

    public void iY(int i) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        com.baidu.tieba.tbadkCore.i afm = this.cna.afm();
        if (afm != null && this.chQ != null && (threadList = afm.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof bl) {
                    bl blVar = (bl) next;
                    if (blVar == this.ctR) {
                        c(blVar, i);
                        this.ctR = null;
                        break;
                    } else if (blVar.getId() != null && blVar.getId().equals(this.cpU)) {
                        c(blVar, i);
                        this.cpU = null;
                        break;
                    }
                }
            }
            this.chQ.afM().b(threadList, afm);
            this.chQ.afM().notifyDataSetChanged();
        }
    }

    public void c(bl blVar, int i) {
        if (blVar != null) {
            if (i == 1) {
                PraiseData rl = blVar.rl();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rl == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        blVar.a(praiseData);
                        return;
                    }
                    blVar.rl().getUser().add(0, metaData);
                    blVar.rl().setNum(blVar.rl().getNum() + 1);
                    blVar.rl().setIsLike(i);
                }
            } else if (blVar.rl() != null) {
                blVar.rl().setIsLike(i);
                blVar.rl().setNum(blVar.rl().getNum() - 1);
                ArrayList<MetaData> user = blVar.rl().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            blVar.rl().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void eY(boolean z) {
        this.cpT = z;
    }
}
