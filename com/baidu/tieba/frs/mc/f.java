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
    private final CustomMessageListener anU;
    private boolean cRh;
    private String cRi;
    private bd cYj;
    private PraiseModel cYk;

    public f(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.anU = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    f.this.cRi = bdVar.getId();
                    if (!TextUtils.isEmpty(f.this.cRi) && bdVar.rm() != null) {
                        f.this.kn(bdVar.rm().getIsLike());
                    }
                }
            }
        };
        this.cOm.registerListener(this.anU);
        this.cYk = apY();
    }

    public final PraiseModel apY() {
        if (this.cYk == null) {
            this.cYk = new PraiseModel(this.cOm.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hY(String str) {
                    int i = 1;
                    if (f.this.cRh) {
                        if (f.this.cYj != null && f.this.cYj.rm().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.kn(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void F(int i, String str) {
                    if (f.this.cOm != null && f.this.cOm.getPageContext() != null && f.this.cRh && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.uq(i)) {
                            AntiHelper.an(f.this.cOm.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.cOm.showToast(str);
                        }
                    }
                }
            });
        }
        return this.cYk;
    }

    public void kn(int i) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        k alv = this.cOm.alv();
        if (alv != null && this.cHa != null && (threadList = alv.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar == this.cYj) {
                        c(bdVar, i);
                        this.cYj = null;
                        break;
                    } else if (bdVar.getId() != null && bdVar.getId().equals(this.cRi)) {
                        c(bdVar, i);
                        this.cRi = null;
                        break;
                    }
                }
            }
            this.cHa.alV().b(threadList, alv);
            this.cHa.alV().notifyDataSetChanged();
        }
    }

    public void c(bd bdVar, int i) {
        if (bdVar != null) {
            if (i == 1) {
                PraiseData rm = bdVar.rm();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rm == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bdVar.a(praiseData);
                        return;
                    }
                    bdVar.rm().getUser().add(0, metaData);
                    bdVar.rm().setNum(bdVar.rm().getNum() + 1);
                    bdVar.rm().setIsLike(i);
                }
            } else if (bdVar.rm() != null) {
                bdVar.rm().setIsLike(i);
                bdVar.rm().setNum(bdVar.rm().getNum() - 1);
                ArrayList<MetaData> user = bdVar.rm().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bdVar.rm().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fy(boolean z) {
        this.cRh = z;
    }
}
