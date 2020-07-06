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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class h extends j {
    private String hSC;
    private final CustomMessageListener hSK;
    private bu hVk;
    private boolean hVl;
    private PraiseModel hVm;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.hSK = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bu)) {
                    bu buVar = (bu) customResponsedMessage.getData();
                    h.this.hSC = buVar.getId();
                    if (!TextUtils.isEmpty(h.this.hSC) && buVar.aSa() != null) {
                        h.this.vx(buVar.aSa().getIsLike());
                    }
                }
            }
        };
        this.hUd.registerListener(this.hSK);
        this.hVm = cei();
    }

    public final PraiseModel cei() {
        if (this.hVm == null) {
            this.hVm = new PraiseModel(this.hUd.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void AG(String str) {
                    int i = 1;
                    if (h.this.hVl) {
                        if (h.this.hVk != null && h.this.hVk.aSa().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.vx(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.hUd != null && h.this.hUd.getPageContext() != null && h.this.hVl && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.bA(i, str)) {
                            AntiHelper.aX(h.this.hUd.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.hUd.showToast(str);
                        }
                    }
                }
            });
        }
        return this.hVm;
    }

    public void vx(int i) {
        ArrayList<q> threadList;
        FrsViewData bYC = this.hUd.bYC();
        if (bYC != null && this.hzK != null && (threadList = bYC.getThreadList()) != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bt) {
                    bu buVar = ((bt) next).dLi;
                    if (buVar == this.hVk) {
                        c(buVar, i);
                        this.hVk = null;
                        break;
                    } else if (buVar.getId() != null && buVar.getId().equals(this.hSC)) {
                        c(buVar, i);
                        this.hSC = null;
                        break;
                    }
                }
            }
            this.hzK.bZx().b(threadList, bYC);
            this.hzK.bZx().notifyDataSetChanged();
        }
    }

    public void c(bu buVar, int i) {
        if (buVar != null) {
            if (i == 1) {
                PraiseData aSa = buVar.aSa();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aSa == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        buVar.a(praiseData);
                        return;
                    }
                    buVar.aSa().getUser().add(0, metaData);
                    buVar.aSa().setNum(buVar.aSa().getNum() + 1);
                    buVar.aSa().setIsLike(i);
                }
            } else if (buVar.aSa() != null) {
                buVar.aSa().setIsLike(i);
                buVar.aSa().setNum(buVar.aSa().getNum() - 1);
                ArrayList<MetaData> user = buVar.aSa().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            buVar.aSa().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void nQ(boolean z) {
        this.hVl = z;
    }
}
