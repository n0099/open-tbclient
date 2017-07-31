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
    private final CustomMessageListener aoP;
    private boolean crf;
    private String crg;
    private bl cvj;
    private PraiseModel cvk;

    public g(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.aoP = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl)) {
                    bl blVar = (bl) customResponsedMessage.getData();
                    g.this.crg = blVar.getId();
                    if (!TextUtils.isEmpty(g.this.crg) && blVar.rv() != null) {
                        g.this.iY(blVar.rv().getIsLike());
                    }
                }
            }
        };
        this.f5com.registerListener(this.aoP);
        this.cvk = aiK();
    }

    public final PraiseModel aiK() {
        if (this.cvk == null) {
            this.cvk = new PraiseModel(this.f5com.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.g.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hO(String str) {
                    int i = 1;
                    if (g.this.crf) {
                        if (g.this.cvj != null && g.this.cvj.rv().getIsLike() == 1) {
                            i = 0;
                        }
                        g.this.iY(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void A(int i, String str) {
                    if (g.this.crf && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.tn(i)) {
                            AntiHelper.ar(g.this.f5com.getPageContext().getPageActivity(), str);
                        } else {
                            g.this.f5com.showToast(str);
                        }
                    }
                }
            });
        }
        return this.cvk;
    }

    public void iY(int i) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        com.baidu.tieba.tbadkCore.i afr = this.f5com.afr();
        if (afr != null && this.ciX != null && (threadList = afr.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof bl) {
                    bl blVar = (bl) next;
                    if (blVar == this.cvj) {
                        c(blVar, i);
                        this.cvj = null;
                        break;
                    } else if (blVar.getId() != null && blVar.getId().equals(this.crg)) {
                        c(blVar, i);
                        this.crg = null;
                        break;
                    }
                }
            }
            this.ciX.afR().b(threadList, afr);
            this.ciX.afR().notifyDataSetChanged();
        }
    }

    public void c(bl blVar, int i) {
        if (blVar != null) {
            if (i == 1) {
                PraiseData rv = blVar.rv();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rv == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        blVar.a(praiseData);
                        return;
                    }
                    blVar.rv().getUser().add(0, metaData);
                    blVar.rv().setNum(blVar.rv().getNum() + 1);
                    blVar.rv().setIsLike(i);
                }
            } else if (blVar.rv() != null) {
                blVar.rv().setIsLike(i);
                blVar.rv().setNum(blVar.rv().getNum() - 1);
                ArrayList<MetaData> user = blVar.rv().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            blVar.rv().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void eY(boolean z) {
        this.crf = z;
    }
}
