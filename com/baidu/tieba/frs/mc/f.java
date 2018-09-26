package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class f extends h {
    private bb dLc;
    private boolean dLd;
    private PraiseModel dLe;
    private String dzp;
    private final CustomMessageListener dzq;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.dzq = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    f.this.dzp = bbVar.getId();
                    if (!TextUtils.isEmpty(f.this.dzp) && bbVar.vZ() != null) {
                        f.this.lq(bbVar.vZ().getIsLike());
                    }
                }
            }
        };
        this.dKj.registerListener(this.dzq);
        this.dLe = aBX();
    }

    public final PraiseModel aBX() {
        if (this.dLe == null) {
            this.dLe = new PraiseModel(this.dKj.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void jv(String str) {
                    int i = 1;
                    if (f.this.dLd) {
                        if (f.this.dLc != null && f.this.dLc.vZ().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.lq(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void Q(int i, String str) {
                    if (f.this.dKj != null && f.this.dKj.getPageContext() != null && f.this.dLd && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.am(i, str)) {
                            AntiHelper.aG(f.this.dKj.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dKj.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dLe;
    }

    public void lq(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l awv = this.dKj.awv();
        if (awv != null && this.dsl != null && (threadList = awv.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar == this.dLc) {
                        a(bbVar, i);
                        this.dLc = null;
                        break;
                    } else if (bbVar.getId() != null && bbVar.getId().equals(this.dzp)) {
                        a(bbVar, i);
                        this.dzp = null;
                        break;
                    }
                }
            }
            this.dsl.axm().b(threadList, awv);
            this.dsl.axm().notifyDataSetChanged();
        }
    }

    public void a(bb bbVar, int i) {
        if (bbVar != null) {
            if (i == 1) {
                PraiseData vZ = bbVar.vZ();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (vZ == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bbVar.a(praiseData);
                        return;
                    }
                    bbVar.vZ().getUser().add(0, metaData);
                    bbVar.vZ().setNum(bbVar.vZ().getNum() + 1);
                    bbVar.vZ().setIsLike(i);
                }
            } else if (bbVar.vZ() != null) {
                bbVar.vZ().setIsLike(i);
                bbVar.vZ().setNum(bbVar.vZ().getNum() - 1);
                ArrayList<MetaData> user = bbVar.vZ().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bbVar.vZ().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void gI(boolean z) {
        this.dLd = z;
    }
}
