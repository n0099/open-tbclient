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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class h extends j {
    private String hYD;
    private final CustomMessageListener hYL;
    private bv ibl;
    private boolean ibm;
    private PraiseModel ibn;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.hYL = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bv)) {
                    bv bvVar = (bv) customResponsedMessage.getData();
                    h.this.hYD = bvVar.getId();
                    if (!TextUtils.isEmpty(h.this.hYD) && bvVar.aVW() != null) {
                        h.this.vP(bvVar.aVW().getIsLike());
                    }
                }
            }
        };
        this.iae.registerListener(this.hYL);
        this.ibn = chH();
    }

    public final PraiseModel chH() {
        if (this.ibn == null) {
            this.ibn = new PraiseModel(this.iae.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void Br(String str) {
                    int i = 1;
                    if (h.this.ibm) {
                        if (h.this.ibl != null && h.this.ibl.aVW().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.vP(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.iae != null && h.this.iae.getPageContext() != null && h.this.ibm && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bB(i, str)) {
                            AntiHelper.aW(h.this.iae.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.iae.showToast(str);
                        }
                    }
                }
            });
        }
        return this.ibn;
    }

    public void vP(int i) {
        ArrayList<q> threadList;
        FrsViewData cbZ = this.iae.cbZ();
        if (cbZ != null && this.hFz != null && (threadList = cbZ.getThreadList()) != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bu) {
                    bv bvVar = ((bu) next).dLK;
                    if (bvVar == this.ibl) {
                        c(bvVar, i);
                        this.ibl = null;
                        break;
                    } else if (bvVar.getId() != null && bvVar.getId().equals(this.hYD)) {
                        c(bvVar, i);
                        this.hYD = null;
                        break;
                    }
                }
            }
            this.hFz.ccU().b(threadList, cbZ);
            this.hFz.ccU().notifyDataSetChanged();
        }
    }

    public void c(bv bvVar, int i) {
        if (bvVar != null) {
            if (i == 1) {
                PraiseData aVW = bvVar.aVW();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aVW == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bvVar.a(praiseData);
                        return;
                    }
                    bvVar.aVW().getUser().add(0, metaData);
                    bvVar.aVW().setNum(bvVar.aVW().getNum() + 1);
                    bvVar.aVW().setIsLike(i);
                }
            } else if (bvVar.aVW() != null) {
                bvVar.aVW().setIsLike(i);
                bvVar.aVW().setNum(bvVar.aVW().getNum() - 1);
                ArrayList<MetaData> user = bvVar.aVW().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bvVar.aVW().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void ov(boolean z) {
        this.ibm = z;
    }
}
