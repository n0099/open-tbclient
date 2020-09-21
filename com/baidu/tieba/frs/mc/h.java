package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes21.dex */
public class h extends j {
    private String iui;
    private final CustomMessageListener iuq;
    private bw iwO;
    private boolean iwP;
    private PraiseModel iwQ;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.iuq = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    h.this.iui = bwVar.getId();
                    if (!TextUtils.isEmpty(h.this.iui) && bwVar.bfj() != null) {
                        h.this.yH(bwVar.bfj().getIsLike());
                    }
                }
            }
        };
        this.ivI.registerListener(this.iuq);
        this.iwQ = cvB();
    }

    public final PraiseModel cvB() {
        if (this.iwQ == null) {
            this.iwQ = new PraiseModel(this.ivI.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void Ej(String str) {
                    int i = 1;
                    if (h.this.iwP) {
                        if (h.this.iwO != null && h.this.iwO.bfj().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.yH(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.ivI != null && h.this.ivI.getPageContext() != null && h.this.iwP && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bC(i, str)) {
                            AntiHelper.bh(h.this.ivI.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.ivI.showToast(str);
                        }
                    }
                }
            });
        }
        return this.iwQ;
    }

    public void yH(int i) {
        ArrayList<q> threadList;
        FrsViewData cpJ = this.ivI.cpJ();
        if (cpJ != null && this.hZV != null && (threadList = cpJ.getThreadList()) != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).dXg;
                    if (bwVar == this.iwO) {
                        c(bwVar, i);
                        this.iwO = null;
                        break;
                    } else if (bwVar.getId() != null && bwVar.getId().equals(this.iui)) {
                        c(bwVar, i);
                        this.iui = null;
                        break;
                    }
                }
            }
            this.hZV.cqE().b(threadList, cpJ);
            this.hZV.cqE().notifyDataSetChanged();
        }
    }

    public void c(bw bwVar, int i) {
        if (bwVar != null) {
            if (i == 1) {
                PraiseData bfj = bwVar.bfj();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bfj == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bwVar.a(praiseData);
                        return;
                    }
                    bwVar.bfj().getUser().add(0, metaData);
                    bwVar.bfj().setNum(bwVar.bfj().getNum() + 1);
                    bwVar.bfj().setIsLike(i);
                }
            } else if (bwVar.bfj() != null) {
                bwVar.bfj().setIsLike(i);
                bwVar.bfj().setNum(bwVar.bfj().getNum() - 1);
                ArrayList<MetaData> user = bwVar.bfj().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bwVar.bfj().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void ph(boolean z) {
        this.iwP = z;
    }
}
