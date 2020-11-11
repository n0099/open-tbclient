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
    private final CustomMessageListener jbC;
    private String jbu;
    private bw jea;
    private boolean jeb;
    private PraiseModel jec;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.jbC = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    h.this.jbu = bwVar.getId();
                    if (!TextUtils.isEmpty(h.this.jbu) && bwVar.bml() != null) {
                        h.this.zT(bwVar.bml().getIsLike());
                    }
                }
            }
        };
        this.jcU.registerListener(this.jbC);
        this.jec = cEG();
    }

    public final PraiseModel cEG() {
        if (this.jec == null) {
            this.jec = new PraiseModel(this.jcU.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void FB(String str) {
                    int i = 1;
                    if (h.this.jeb) {
                        if (h.this.jea != null && h.this.jea.bml().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.zT(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.jcU != null && h.this.jcU.getPageContext() != null && h.this.jeb && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bR(i, str)) {
                            AntiHelper.bm(h.this.jcU.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.jcU.showToast(str);
                        }
                    }
                }
            });
        }
        return this.jec;
    }

    public void zT(int i) {
        ArrayList<q> threadList;
        FrsViewData cyP = this.jcU.cyP();
        if (cyP != null && this.iHp != null && (threadList = cyP.getThreadList()) != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).exA;
                    if (bwVar == this.jea) {
                        c(bwVar, i);
                        this.jea = null;
                        break;
                    } else if (bwVar.getId() != null && bwVar.getId().equals(this.jbu)) {
                        c(bwVar, i);
                        this.jbu = null;
                        break;
                    }
                }
            }
            this.iHp.czK().b(threadList, cyP);
            this.iHp.czK().notifyDataSetChanged();
        }
    }

    public void c(bw bwVar, int i) {
        if (bwVar != null) {
            if (i == 1) {
                PraiseData bml = bwVar.bml();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bml == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bwVar.a(praiseData);
                        return;
                    }
                    bwVar.bml().getUser().add(0, metaData);
                    bwVar.bml().setNum(bwVar.bml().getNum() + 1);
                    bwVar.bml().setIsLike(i);
                }
            } else if (bwVar.bml() != null) {
                bwVar.bml().setIsLike(i);
                bwVar.bml().setNum(bwVar.bml().getNum() - 1);
                ArrayList<MetaData> user = bwVar.bml().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bwVar.bml().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void qn(boolean z) {
        this.jeb = z;
    }
}
