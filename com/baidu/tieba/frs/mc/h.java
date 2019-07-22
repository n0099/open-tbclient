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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class h extends j {
    private String fKA;
    private final CustomMessageListener fKJ;
    private bg fNg;
    private boolean fNh;
    private PraiseModel fNi;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fKJ = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    h.this.fKA = bgVar.getId();
                    if (!TextUtils.isEmpty(h.this.fKA) && bgVar.aej() != null) {
                        h.this.st(bgVar.aej().getIsLike());
                    }
                }
            }
        };
        this.fMb.registerListener(this.fKJ);
        this.fNi = brv();
    }

    public final PraiseModel brv() {
        if (this.fNi == null) {
            this.fNi = new PraiseModel(this.fMb.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void sE(String str) {
                    int i = 1;
                    if (h.this.fNh) {
                        if (h.this.fNg != null && h.this.fNg.aej().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.st(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.fMb != null && h.this.fMb.getPageContext() != null && h.this.fNh && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.aG(i, str)) {
                            AntiHelper.aJ(h.this.fMb.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.fMb.showToast(str);
                        }
                    }
                }
            });
        }
        return this.fNi;
    }

    public void st(int i) {
        ArrayList<m> threadList;
        FrsViewData bmo = this.fMb.bmo();
        if (bmo != null && this.ftP != null && (threadList = bmo.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bf) {
                    bg bgVar = ((bf) next).threadData;
                    if (bgVar == this.fNg) {
                        c(bgVar, i);
                        this.fNg = null;
                        break;
                    } else if (bgVar.getId() != null && bgVar.getId().equals(this.fKA)) {
                        c(bgVar, i);
                        this.fKA = null;
                        break;
                    }
                }
            }
            this.ftP.bne().b(threadList, bmo);
            this.ftP.bne().notifyDataSetChanged();
        }
    }

    public void c(bg bgVar, int i) {
        if (bgVar != null) {
            if (i == 1) {
                PraiseData aej = bgVar.aej();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aej == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bgVar.a(praiseData);
                        return;
                    }
                    bgVar.aej().getUser().add(0, metaData);
                    bgVar.aej().setNum(bgVar.aej().getNum() + 1);
                    bgVar.aej().setIsLike(i);
                }
            } else if (bgVar.aej() != null) {
                bgVar.aej().setIsLike(i);
                bgVar.aej().setNum(bgVar.aej().getNum() - 1);
                ArrayList<MetaData> user = bgVar.aej().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bgVar.aej().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void kK(boolean z) {
        this.fNh = z;
    }
}
