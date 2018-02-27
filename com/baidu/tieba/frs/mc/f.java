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
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class f extends h {
    private final CustomMessageListener bdJ;
    private String dRv;
    private boolean dTA;
    private PraiseModel dTB;
    private bd dTz;

    public f(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.bdJ = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    f.this.dRv = bdVar.getId();
                    if (!TextUtils.isEmpty(f.this.dRv) && bdVar.zc() != null) {
                        f.this.nB(bdVar.zc().getIsLike());
                    }
                }
            }
        };
        this.dSJ.registerListener(this.bdJ);
        this.dTB = azC();
    }

    public final PraiseModel azC() {
        if (this.dTB == null) {
            this.dTB = new PraiseModel(this.dSJ.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void ir(String str) {
                    int i = 1;
                    if (f.this.dTA) {
                        if (f.this.dTz != null && f.this.dTz.zc().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.nB(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void I(int i, String str) {
                    if (f.this.dSJ != null && f.this.dSJ.getPageContext() != null && f.this.dTA && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.vR(i)) {
                            AntiHelper.ar(f.this.dSJ.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dSJ.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dTB;
    }

    public void nB(int i) {
        ArrayList<com.baidu.adp.widget.ListView.i> threadList;
        l avk = this.dSJ.avk();
        if (avk != null && this.dEl != null && (threadList = avk.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar == this.dTz) {
                        c(bdVar, i);
                        this.dTz = null;
                        break;
                    } else if (bdVar.getId() != null && bdVar.getId().equals(this.dRv)) {
                        c(bdVar, i);
                        this.dRv = null;
                        break;
                    }
                }
            }
            this.dEl.avV().b(threadList, avk);
            this.dEl.avV().notifyDataSetChanged();
        }
    }

    public void c(bd bdVar, int i) {
        if (bdVar != null) {
            if (i == 1) {
                PraiseData zc = bdVar.zc();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (zc == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bdVar.a(praiseData);
                        return;
                    }
                    bdVar.zc().getUser().add(0, metaData);
                    bdVar.zc().setNum(bdVar.zc().getNum() + 1);
                    bdVar.zc().setIsLike(i);
                }
            } else if (bdVar.zc() != null) {
                bdVar.zc().setIsLike(i);
                bdVar.zc().setNum(bdVar.zc().getNum() - 1);
                ArrayList<MetaData> user = bdVar.zc().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bdVar.zc().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void gp(boolean z) {
        this.dTA = z;
    }
}
