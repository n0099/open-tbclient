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
    private final CustomMessageListener iVF;
    private String iVx;
    private bw iYd;
    private boolean iYe;
    private PraiseModel iYf;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.iVF = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    h.this.iVx = bwVar.getId();
                    if (!TextUtils.isEmpty(h.this.iVx) && bwVar.bjL() != null) {
                        h.this.zG(bwVar.bjL().getIsLike());
                    }
                }
            }
        };
        this.iWX.registerListener(this.iVF);
        this.iYf = cCf();
    }

    public final PraiseModel cCf() {
        if (this.iYf == null) {
            this.iYf = new PraiseModel(this.iWX.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void Fn(String str) {
                    int i = 1;
                    if (h.this.iYe) {
                        if (h.this.iYd != null && h.this.iYd.bjL().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.zG(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.iWX != null && h.this.iWX.getPageContext() != null && h.this.iYe && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bN(i, str)) {
                            AntiHelper.bm(h.this.iWX.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.iWX.showToast(str);
                        }
                    }
                }
            });
        }
        return this.iYf;
    }

    public void zG(int i) {
        ArrayList<q> threadList;
        FrsViewData cwo = this.iWX.cwo();
        if (cwo != null && this.iBs != null && (threadList = cwo.getThreadList()) != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).erH;
                    if (bwVar == this.iYd) {
                        c(bwVar, i);
                        this.iYd = null;
                        break;
                    } else if (bwVar.getId() != null && bwVar.getId().equals(this.iVx)) {
                        c(bwVar, i);
                        this.iVx = null;
                        break;
                    }
                }
            }
            this.iBs.cxj().b(threadList, cwo);
            this.iBs.cxj().notifyDataSetChanged();
        }
    }

    public void c(bw bwVar, int i) {
        if (bwVar != null) {
            if (i == 1) {
                PraiseData bjL = bwVar.bjL();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bjL == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bwVar.a(praiseData);
                        return;
                    }
                    bwVar.bjL().getUser().add(0, metaData);
                    bwVar.bjL().setNum(bwVar.bjL().getNum() + 1);
                    bwVar.bjL().setIsLike(i);
                }
            } else if (bwVar.bjL() != null) {
                bwVar.bjL().setIsLike(i);
                bwVar.bjL().setNum(bwVar.bjL().getNum() - 1);
                ArrayList<MetaData> user = bwVar.bjL().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bwVar.bjL().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void qe(boolean z) {
        this.iYe = z;
    }
}
