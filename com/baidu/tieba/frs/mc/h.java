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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes21.dex */
public class h extends j {
    private String jcg;
    private final CustomMessageListener jco;
    private bx jeN;
    private boolean jeO;
    private PraiseModel jeP;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.jco = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bx)) {
                    bx bxVar = (bx) customResponsedMessage.getData();
                    h.this.jcg = bxVar.getId();
                    if (!TextUtils.isEmpty(h.this.jcg) && bxVar.bln() != null) {
                        h.this.Ar(bxVar.bln().getIsLike());
                    }
                }
            }
        };
        this.jdH.registerListener(this.jco);
        this.jeP = cEk();
    }

    public final PraiseModel cEk() {
        if (this.jeP == null) {
            this.jeP = new PraiseModel(this.jdH.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void Fc(String str) {
                    int i = 1;
                    if (h.this.jeO) {
                        if (h.this.jeN != null && h.this.jeN.bln().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.Ar(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.jdH != null && h.this.jdH.getPageContext() != null && h.this.jeO && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bP(i, str)) {
                            AntiHelper.bj(h.this.jdH.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.jdH.showToast(str);
                        }
                    }
                }
            });
        }
        return this.jeP;
    }

    public void Ar(int i) {
        ArrayList<q> threadList;
        FrsViewData cys = this.jdH.cys();
        if (cys != null && this.iId != null && (threadList = cys.getThreadList()) != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bw) {
                    bx bxVar = ((bw) next).evQ;
                    if (bxVar == this.jeN) {
                        c(bxVar, i);
                        this.jeN = null;
                        break;
                    } else if (bxVar.getId() != null && bxVar.getId().equals(this.jcg)) {
                        c(bxVar, i);
                        this.jcg = null;
                        break;
                    }
                }
            }
            this.iId.czn().b(threadList, cys);
            this.iId.czn().notifyDataSetChanged();
        }
    }

    public void c(bx bxVar, int i) {
        if (bxVar != null) {
            if (i == 1) {
                PraiseData bln = bxVar.bln();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bln == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bxVar.a(praiseData);
                        return;
                    }
                    bxVar.bln().getUser().add(0, metaData);
                    bxVar.bln().setNum(bxVar.bln().getNum() + 1);
                    bxVar.bln().setIsLike(i);
                }
            } else if (bxVar.bln() != null) {
                bxVar.bln().setIsLike(i);
                bxVar.bln().setNum(bxVar.bln().getNum() - 1);
                ArrayList<MetaData> user = bxVar.bln().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bxVar.bln().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void qq(boolean z) {
        this.jeO = z;
    }
}
