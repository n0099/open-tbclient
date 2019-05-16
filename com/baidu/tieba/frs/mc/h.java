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
    private String fFB;
    private final CustomMessageListener fFK;
    private bg fIf;
    private boolean fIg;
    private PraiseModel fIh;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fFK = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    h.this.fFB = bgVar.getId();
                    if (!TextUtils.isEmpty(h.this.fFB) && bgVar.adh() != null) {
                        h.this.sb(bgVar.adh().getIsLike());
                    }
                }
            }
        };
        this.fGZ.registerListener(this.fFK);
        this.fIh = bpp();
    }

    public final PraiseModel bpp() {
        if (this.fIh == null) {
            this.fIh = new PraiseModel(this.fGZ.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void sm(String str) {
                    int i = 1;
                    if (h.this.fIg) {
                        if (h.this.fIf != null && h.this.fIf.adh().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.sb(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void onLoadFailed(int i, String str) {
                    if (h.this.fGZ != null && h.this.fGZ.getPageContext() != null && h.this.fIg && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.aG(i, str)) {
                            AntiHelper.aI(h.this.fGZ.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.fGZ.showToast(str);
                        }
                    }
                }
            });
        }
        return this.fIh;
    }

    public void sb(int i) {
        ArrayList<m> threadList;
        FrsViewData bkj = this.fGZ.bkj();
        if (bkj != null && this.foP != null && (threadList = bkj.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bf) {
                    bg bgVar = ((bf) next).threadData;
                    if (bgVar == this.fIf) {
                        c(bgVar, i);
                        this.fIf = null;
                        break;
                    } else if (bgVar.getId() != null && bgVar.getId().equals(this.fFB)) {
                        c(bgVar, i);
                        this.fFB = null;
                        break;
                    }
                }
            }
            this.foP.bkZ().b(threadList, bkj);
            this.foP.bkZ().notifyDataSetChanged();
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
        this.fIg = z;
    }
}
