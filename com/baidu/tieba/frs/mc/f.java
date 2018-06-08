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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class f extends h {
    private final CustomMessageListener axl;
    private String dmP;
    private bd dyo;
    private boolean dyp;
    private PraiseModel dyq;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.axl = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    f.this.dmP = bdVar.getId();
                    if (!TextUtils.isEmpty(f.this.dmP) && bdVar.va() != null) {
                        f.this.kw(bdVar.va().getIsLike());
                    }
                }
            }
        };
        this.dxw.registerListener(this.axl);
        this.dyq = ayF();
    }

    public final PraiseModel ayF() {
        if (this.dyq == null) {
            this.dyq = new PraiseModel(this.dxw.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void iQ(String str) {
                    int i = 1;
                    if (f.this.dyp) {
                        if (f.this.dyo != null && f.this.dyo.va().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.kw(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void R(int i, String str) {
                    if (f.this.dxw != null && f.this.dxw.getPageContext() != null && f.this.dyp && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.tE(i)) {
                            AntiHelper.ao(f.this.dxw.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dxw.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dyq;
    }

    public void kw(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l atI = this.dxw.atI();
        if (atI != null && this.dhC != null && (threadList = atI.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar == this.dyo) {
                        a(bdVar, i);
                        this.dyo = null;
                        break;
                    } else if (bdVar.getId() != null && bdVar.getId().equals(this.dmP)) {
                        a(bdVar, i);
                        this.dmP = null;
                        break;
                    }
                }
            }
            this.dhC.aux().b(threadList, atI);
            this.dhC.aux().notifyDataSetChanged();
        }
    }

    public void a(bd bdVar, int i) {
        if (bdVar != null) {
            if (i == 1) {
                PraiseData va = bdVar.va();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (va == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bdVar.a(praiseData);
                        return;
                    }
                    bdVar.va().getUser().add(0, metaData);
                    bdVar.va().setNum(bdVar.va().getNum() + 1);
                    bdVar.va().setIsLike(i);
                }
            } else if (bdVar.va() != null) {
                bdVar.va().setIsLike(i);
                bdVar.va().setNum(bdVar.va().getNum() - 1);
                ArrayList<MetaData> user = bdVar.va().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bdVar.va().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void ga(boolean z) {
        this.dyp = z;
    }
}
