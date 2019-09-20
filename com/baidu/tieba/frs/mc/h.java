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
    private String fNd;
    private final CustomMessageListener fNm;
    private bh fPK;
    private boolean fPL;
    private PraiseModel fPM;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fNm = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    h.this.fNd = bhVar.getId();
                    if (!TextUtils.isEmpty(h.this.fNd) && bhVar.aeo() != null) {
                        h.this.sz(bhVar.aeo().getIsLike());
                    }
                }
            }
        };
        this.fOE.registerListener(this.fNm);
        this.fPM = bsv();
    }

    public final PraiseModel bsv() {
        if (this.fPM == null) {
            this.fPM = new PraiseModel(this.fOE.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void td(String str) {
                    int i = 1;
                    if (h.this.fPL) {
                        if (h.this.fPK != null && h.this.fPK.aeo().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.sz(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.fOE != null && h.this.fOE.getPageContext() != null && h.this.fPL && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.aG(i, str)) {
                            AntiHelper.aQ(h.this.fOE.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.fOE.showToast(str);
                        }
                    }
                }
            });
        }
        return this.fPM;
    }

    public void sz(int i) {
        ArrayList<m> threadList;
        FrsViewData bnj = this.fOE.bnj();
        if (bnj != null && this.fwb != null && (threadList = bnj.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bg) {
                    bh bhVar = ((bg) next).threadData;
                    if (bhVar == this.fPK) {
                        c(bhVar, i);
                        this.fPK = null;
                        break;
                    } else if (bhVar.getId() != null && bhVar.getId().equals(this.fNd)) {
                        c(bhVar, i);
                        this.fNd = null;
                        break;
                    }
                }
            }
            this.fwb.bnZ().b(threadList, bnj);
            this.fwb.bnZ().notifyDataSetChanged();
        }
    }

    public void c(bh bhVar, int i) {
        if (bhVar != null) {
            if (i == 1) {
                PraiseData aeo = bhVar.aeo();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aeo == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bhVar.a(praiseData);
                        return;
                    }
                    bhVar.aeo().getUser().add(0, metaData);
                    bhVar.aeo().setNum(bhVar.aeo().getNum() + 1);
                    bhVar.aeo().setIsLike(i);
                }
            } else if (bhVar.aeo() != null) {
                bhVar.aeo().setIsLike(i);
                bhVar.aeo().setNum(bhVar.aeo().getNum() - 1);
                ArrayList<MetaData> user = bhVar.aeo().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bhVar.aeo().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void kN(boolean z) {
        this.fPL = z;
    }
}
