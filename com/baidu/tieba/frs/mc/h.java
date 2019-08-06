package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class h extends j {
    private String fLo;
    private final CustomMessageListener fLx;
    private bh fNU;
    private boolean fNV;
    private PraiseModel fNW;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fLx = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    h.this.fLo = bhVar.getId();
                    if (!TextUtils.isEmpty(h.this.fLo) && bhVar.aek() != null) {
                        h.this.sv(bhVar.aek().getIsLike());
                    }
                }
            }
        };
        this.fMP.registerListener(this.fLx);
        this.fNW = brI();
    }

    public final PraiseModel brI() {
        if (this.fNW == null) {
            this.fNW = new PraiseModel(this.fMP.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void sE(String str) {
                    int i = 1;
                    if (h.this.fNV) {
                        if (h.this.fNU != null && h.this.fNU.aek().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.sv(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.fMP != null && h.this.fMP.getPageContext() != null && h.this.fNV && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.aG(i, str)) {
                            AntiHelper.aJ(h.this.fMP.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.fMP.showToast(str);
                        }
                    }
                }
            });
        }
        return this.fNW;
    }

    public void sv(int i) {
        ArrayList<m> threadList;
        FrsViewData bmy = this.fMP.bmy();
        if (bmy != null && this.fuo != null && (threadList = bmy.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bg) {
                    bh bhVar = ((bg) next).threadData;
                    if (bhVar == this.fNU) {
                        c(bhVar, i);
                        this.fNU = null;
                        break;
                    } else if (bhVar.getId() != null && bhVar.getId().equals(this.fLo)) {
                        c(bhVar, i);
                        this.fLo = null;
                        break;
                    }
                }
            }
            this.fuo.bno().b(threadList, bmy);
            this.fuo.bno().notifyDataSetChanged();
        }
    }

    public void c(bh bhVar, int i) {
        if (bhVar != null) {
            if (i == 1) {
                PraiseData aek = bhVar.aek();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aek == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bhVar.a(praiseData);
                        return;
                    }
                    bhVar.aek().getUser().add(0, metaData);
                    bhVar.aek().setNum(bhVar.aek().getNum() + 1);
                    bhVar.aek().setIsLike(i);
                }
            } else if (bhVar.aek() != null) {
                bhVar.aek().setIsLike(i);
                bhVar.aek().setNum(bhVar.aek().getNum() - 1);
                ArrayList<MetaData> user = bhVar.aek().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bhVar.aek().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void kK(boolean z) {
        this.fNV = z;
    }
}
