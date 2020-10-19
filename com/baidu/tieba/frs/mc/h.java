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
/* loaded from: classes22.dex */
public class h extends j {
    private String iJb;
    private final CustomMessageListener iJj;
    private bw iLH;
    private boolean iLI;
    private PraiseModel iLJ;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.iJj = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    h.this.iJb = bwVar.getId();
                    if (!TextUtils.isEmpty(h.this.iJb) && bwVar.bhS() != null) {
                        h.this.zn(bwVar.bhS().getIsLike());
                    }
                }
            }
        };
        this.iKB.registerListener(this.iJj);
        this.iLJ = cyY();
    }

    public final PraiseModel cyY() {
        if (this.iLJ == null) {
            this.iLJ = new PraiseModel(this.iKB.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void EU(String str) {
                    int i = 1;
                    if (h.this.iLI) {
                        if (h.this.iLH != null && h.this.iLH.bhS().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.zn(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.iKB != null && h.this.iKB.getPageContext() != null && h.this.iLI && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bM(i, str)) {
                            AntiHelper.bk(h.this.iKB.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.iKB.showToast(str);
                        }
                    }
                }
            });
        }
        return this.iLJ;
    }

    public void zn(int i) {
        ArrayList<q> threadList;
        FrsViewData cth = this.iKB.cth();
        if (cth != null && this.ioW != null && (threadList = cth.getThreadList()) != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).eji;
                    if (bwVar == this.iLH) {
                        c(bwVar, i);
                        this.iLH = null;
                        break;
                    } else if (bwVar.getId() != null && bwVar.getId().equals(this.iJb)) {
                        c(bwVar, i);
                        this.iJb = null;
                        break;
                    }
                }
            }
            this.ioW.cuc().b(threadList, cth);
            this.ioW.cuc().notifyDataSetChanged();
        }
    }

    public void c(bw bwVar, int i) {
        if (bwVar != null) {
            if (i == 1) {
                PraiseData bhS = bwVar.bhS();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bhS == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bwVar.a(praiseData);
                        return;
                    }
                    bwVar.bhS().getUser().add(0, metaData);
                    bwVar.bhS().setNum(bwVar.bhS().getNum() + 1);
                    bwVar.bhS().setIsLike(i);
                }
            } else if (bwVar.bhS() != null) {
                bwVar.bhS().setIsLike(i);
                bwVar.bhS().setNum(bwVar.bhS().getNum() - 1);
                ArrayList<MetaData> user = bwVar.bhS().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bwVar.bhS().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void pM(boolean z) {
        this.iLI = z;
    }
}
