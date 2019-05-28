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
    private String fFC;
    private final CustomMessageListener fFL;
    private bg fIg;
    private boolean fIh;
    private PraiseModel fIi;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fFL = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    h.this.fFC = bgVar.getId();
                    if (!TextUtils.isEmpty(h.this.fFC) && bgVar.adh() != null) {
                        h.this.sb(bgVar.adh().getIsLike());
                    }
                }
            }
        };
        this.fHa.registerListener(this.fFL);
        this.fIi = bps();
    }

    public final PraiseModel bps() {
        if (this.fIi == null) {
            this.fIi = new PraiseModel(this.fHa.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void sm(String str) {
                    int i = 1;
                    if (h.this.fIh) {
                        if (h.this.fIg != null && h.this.fIg.adh().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.sb(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.fHa != null && h.this.fHa.getPageContext() != null && h.this.fIh && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.aG(i, str)) {
                            AntiHelper.aI(h.this.fHa.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.fHa.showToast(str);
                        }
                    }
                }
            });
        }
        return this.fIi;
    }

    public void sb(int i) {
        ArrayList<m> threadList;
        FrsViewData bkm = this.fHa.bkm();
        if (bkm != null && this.foQ != null && (threadList = bkm.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bf) {
                    bg bgVar = ((bf) next).threadData;
                    if (bgVar == this.fIg) {
                        c(bgVar, i);
                        this.fIg = null;
                        break;
                    } else if (bgVar.getId() != null && bgVar.getId().equals(this.fFC)) {
                        c(bgVar, i);
                        this.fFC = null;
                        break;
                    }
                }
            }
            this.foQ.blc().b(threadList, bkm);
            this.foQ.blc().notifyDataSetChanged();
        }
    }

    public void c(bg bgVar, int i) {
        if (bgVar != null) {
            if (i == 1) {
                PraiseData adh = bgVar.adh();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (adh == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bgVar.a(praiseData);
                        return;
                    }
                    bgVar.adh().getUser().add(0, metaData);
                    bgVar.adh().setNum(bgVar.adh().getNum() + 1);
                    bgVar.adh().setIsLike(i);
                }
            } else if (bgVar.adh() != null) {
                bgVar.adh().setIsLike(i);
                bgVar.adh().setNum(bgVar.adh().getNum() - 1);
                ArrayList<MetaData> user = bgVar.adh().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bgVar.adh().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void kz(boolean z) {
        this.fIh = z;
    }
}
