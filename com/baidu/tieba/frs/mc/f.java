package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends h {
    private final CustomMessageListener anW;
    private boolean cRs;
    private String cRt;
    private bd cYv;
    private PraiseModel cYw;

    public f(com.baidu.tieba.frs.g gVar) {
        super(gVar);
        this.anW = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    f.this.cRt = bdVar.getId();
                    if (!TextUtils.isEmpty(f.this.cRt) && bdVar.rk() != null) {
                        f.this.kp(bdVar.rk().getIsLike());
                    }
                }
            }
        };
        this.cOx.registerListener(this.anW);
        this.cYw = aqg();
    }

    public final PraiseModel aqg() {
        if (this.cYw == null) {
            this.cYw = new PraiseModel(this.cOx.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hW(String str) {
                    int i = 1;
                    if (f.this.cRs) {
                        if (f.this.cYv != null && f.this.cYv.rk().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.kp(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void F(int i, String str) {
                    if (f.this.cOx != null && f.this.cOx.getPageContext() != null && f.this.cRs && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.uB(i)) {
                            AntiHelper.am(f.this.cOx.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.cOx.showToast(str);
                        }
                    }
                }
            });
        }
        return this.cYw;
    }

    public void kp(int i) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        k alE = this.cOx.alE();
        if (alE != null && this.cHi != null && (threadList = alE.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar == this.cYv) {
                        c(bdVar, i);
                        this.cYv = null;
                        break;
                    } else if (bdVar.getId() != null && bdVar.getId().equals(this.cRt)) {
                        c(bdVar, i);
                        this.cRt = null;
                        break;
                    }
                }
            }
            this.cHi.amd().b(threadList, alE);
            this.cHi.amd().notifyDataSetChanged();
        }
    }

    public void c(bd bdVar, int i) {
        if (bdVar != null) {
            if (i == 1) {
                PraiseData rk = bdVar.rk();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rk == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bdVar.a(praiseData);
                        return;
                    }
                    bdVar.rk().getUser().add(0, metaData);
                    bdVar.rk().setNum(bdVar.rk().getNum() + 1);
                    bdVar.rk().setIsLike(i);
                }
            } else if (bdVar.rk() != null) {
                bdVar.rk().setIsLike(i);
                bdVar.rk().setNum(bdVar.rk().getNum() - 1);
                ArrayList<MetaData> user = bdVar.rk().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bdVar.rk().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fz(boolean z) {
        this.cRs = z;
    }
}
