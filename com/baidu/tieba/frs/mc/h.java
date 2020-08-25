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
/* loaded from: classes16.dex */
public class h extends j {
    private String imL;
    private final CustomMessageListener imT;
    private bw ips;
    private boolean ipt;
    private PraiseModel ipu;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.imT = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    h.this.imL = bwVar.getId();
                    if (!TextUtils.isEmpty(h.this.imL) && bwVar.bep() != null) {
                        h.this.yi(bwVar.bep().getIsLike());
                    }
                }
            }
        };
        this.iom.registerListener(this.imT);
        this.ipu = csl();
    }

    public final PraiseModel csl() {
        if (this.ipu == null) {
            this.ipu = new PraiseModel(this.iom.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void DL(String str) {
                    int i = 1;
                    if (h.this.ipt) {
                        if (h.this.ips != null && h.this.ips.bep().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.yi(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.iom != null && h.this.iom.getPageContext() != null && h.this.ipt && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bz(i, str)) {
                            AntiHelper.bb(h.this.iom.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.iom.showToast(str);
                        }
                    }
                }
            });
        }
        return this.ipu;
    }

    public void yi(int i) {
        ArrayList<q> threadList;
        FrsViewData cmw = this.iom.cmw();
        if (cmw != null && this.hSP != null && (threadList = cmw.getThreadList()) != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).dUS;
                    if (bwVar == this.ips) {
                        c(bwVar, i);
                        this.ips = null;
                        break;
                    } else if (bwVar.getId() != null && bwVar.getId().equals(this.imL)) {
                        c(bwVar, i);
                        this.imL = null;
                        break;
                    }
                }
            }
            this.hSP.cnr().b(threadList, cmw);
            this.hSP.cnr().notifyDataSetChanged();
        }
    }

    public void c(bw bwVar, int i) {
        if (bwVar != null) {
            if (i == 1) {
                PraiseData bep = bwVar.bep();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bep == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bwVar.a(praiseData);
                        return;
                    }
                    bwVar.bep().getUser().add(0, metaData);
                    bwVar.bep().setNum(bwVar.bep().getNum() + 1);
                    bwVar.bep().setIsLike(i);
                }
            } else if (bwVar.bep() != null) {
                bwVar.bep().setIsLike(i);
                bwVar.bep().setNum(bwVar.bep().getNum() - 1);
                ArrayList<MetaData> user = bwVar.bep().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bwVar.bep().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void oZ(boolean z) {
        this.ipt = z;
    }
}
