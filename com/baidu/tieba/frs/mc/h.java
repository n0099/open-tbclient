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
    private final CustomMessageListener fpC;
    private String fpt;
    private bg frY;
    private boolean frZ;
    private PraiseModel fsa;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fpC = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    h.this.fpt = bgVar.getId();
                    if (!TextUtils.isEmpty(h.this.fpt) && bgVar.YD() != null) {
                        h.this.qX(bgVar.YD().getIsLike());
                    }
                }
            }
        };
        this.fqS.registerListener(this.fpC);
        this.fsa = bhY();
    }

    public final PraiseModel bhY() {
        if (this.fsa == null) {
            this.fsa = new PraiseModel(this.fqS.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void rc(String str) {
                    int i = 1;
                    if (h.this.frZ) {
                        if (h.this.frY != null && h.this.frY.YD().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.qX(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void af(int i, String str) {
                    if (h.this.fqS != null && h.this.fqS.getPageContext() != null && h.this.frZ && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.aB(i, str)) {
                            AntiHelper.aU(h.this.fqS.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.fqS.showToast(str);
                        }
                    }
                }
            });
        }
        return this.fsa;
    }

    public void qX(int i) {
        ArrayList<m> threadList;
        FrsViewData bcR = this.fqS.bcR();
        if (bcR != null && this.eYS != null && (threadList = bcR.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bf) {
                    bg bgVar = ((bf) next).threadData;
                    if (bgVar == this.frY) {
                        c(bgVar, i);
                        this.frY = null;
                        break;
                    } else if (bgVar.getId() != null && bgVar.getId().equals(this.fpt)) {
                        c(bgVar, i);
                        this.fpt = null;
                        break;
                    }
                }
            }
            this.eYS.bdK().b(threadList, bcR);
            this.eYS.bdK().notifyDataSetChanged();
        }
    }

    public void c(bg bgVar, int i) {
        if (bgVar != null) {
            if (i == 1) {
                PraiseData YD = bgVar.YD();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (YD == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bgVar.a(praiseData);
                        return;
                    }
                    bgVar.YD().getUser().add(0, metaData);
                    bgVar.YD().setNum(bgVar.YD().getNum() + 1);
                    bgVar.YD().setIsLike(i);
                }
            } else if (bgVar.YD() != null) {
                bgVar.YD().setIsLike(i);
                bgVar.YD().setNum(bgVar.YD().getNum() - 1);
                ArrayList<MetaData> user = bgVar.YD().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bgVar.YD().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jN(boolean z) {
        this.frZ = z;
    }
}
