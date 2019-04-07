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
    private String fpe;
    private final CustomMessageListener fpn;
    private bg frK;
    private boolean frL;
    private PraiseModel frM;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fpn = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    h.this.fpe = bgVar.getId();
                    if (!TextUtils.isEmpty(h.this.fpe) && bgVar.YA() != null) {
                        h.this.qT(bgVar.YA().getIsLike());
                    }
                }
            }
        };
        this.fqE.registerListener(this.fpn);
        this.frM = bhW();
    }

    public final PraiseModel bhW() {
        if (this.frM == null) {
            this.frM = new PraiseModel(this.fqE.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.h.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void rd(String str) {
                    int i = 1;
                    if (h.this.frL) {
                        if (h.this.frK != null && h.this.frK.YA().getIsLike() == 1) {
                            i = 0;
                        }
                        h.this.qT(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void ah(int i, String str) {
                    if (h.this.fqE != null && h.this.fqE.getPageContext() != null && h.this.frL && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.aD(i, str)) {
                            AntiHelper.aU(h.this.fqE.getPageContext().getPageActivity(), str);
                        } else {
                            h.this.fqE.showToast(str);
                        }
                    }
                }
            });
        }
        return this.frM;
    }

    public void qT(int i) {
        ArrayList<m> threadList;
        FrsViewData bcP = this.fqE.bcP();
        if (bcP != null && this.eYE != null && (threadList = bcP.getThreadList()) != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bf) {
                    bg bgVar = ((bf) next).threadData;
                    if (bgVar == this.frK) {
                        c(bgVar, i);
                        this.frK = null;
                        break;
                    } else if (bgVar.getId() != null && bgVar.getId().equals(this.fpe)) {
                        c(bgVar, i);
                        this.fpe = null;
                        break;
                    }
                }
            }
            this.eYE.bdI().b(threadList, bcP);
            this.eYE.bdI().notifyDataSetChanged();
        }
    }

    public void c(bg bgVar, int i) {
        if (bgVar != null) {
            if (i == 1) {
                PraiseData YA = bgVar.YA();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (YA == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bgVar.a(praiseData);
                        return;
                    }
                    bgVar.YA().getUser().add(0, metaData);
                    bgVar.YA().setNum(bgVar.YA().getNum() + 1);
                    bgVar.YA().setIsLike(i);
                }
            } else if (bgVar.YA() != null) {
                bgVar.YA().setIsLike(i);
                bgVar.YA().setNum(bgVar.YA().getNum() - 1);
                ArrayList<MetaData> user = bgVar.YA().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bgVar.YA().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jN(boolean z) {
        this.frL = z;
    }
}
