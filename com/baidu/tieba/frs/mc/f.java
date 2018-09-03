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
    private final CustomMessageListener axF;
    private bb dEm;
    private boolean dEn;
    private PraiseModel dEo;
    private String dsK;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.axF = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    f.this.dsK = bbVar.getId();
                    if (!TextUtils.isEmpty(f.this.dsK) && bbVar.uW() != null) {
                        f.this.kN(bbVar.uW().getIsLike());
                    }
                }
            }
        };
        this.dDt.registerListener(this.axF);
        this.dEo = azO();
    }

    public final PraiseModel azO() {
        if (this.dEo == null) {
            this.dEo = new PraiseModel(this.dDt.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void iT(String str) {
                    int i = 1;
                    if (f.this.dEn) {
                        if (f.this.dEm != null && f.this.dEm.uW().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.kN(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void Q(int i, String str) {
                    if (f.this.dDt != null && f.this.dDt.getPageContext() != null && f.this.dEn && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.al(i, str)) {
                            AntiHelper.aq(f.this.dDt.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.dDt.showToast(str);
                        }
                    }
                }
            });
        }
        return this.dEo;
    }

    public void kN(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l auC = this.dDt.auC();
        if (auC != null && this.dmo != null && (threadList = auC.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar == this.dEm) {
                        a(bbVar, i);
                        this.dEm = null;
                        break;
                    } else if (bbVar.getId() != null && bbVar.getId().equals(this.dsK)) {
                        a(bbVar, i);
                        this.dsK = null;
                        break;
                    }
                }
            }
            this.dmo.avt().b(threadList, auC);
            this.dmo.avt().notifyDataSetChanged();
        }
    }

    public void a(bb bbVar, int i) {
        if (bbVar != null) {
            if (i == 1) {
                PraiseData uW = bbVar.uW();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (uW == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bbVar.a(praiseData);
                        return;
                    }
                    bbVar.uW().getUser().add(0, metaData);
                    bbVar.uW().setNum(bbVar.uW().getNum() + 1);
                    bbVar.uW().setIsLike(i);
                }
            } else if (bbVar.uW() != null) {
                bbVar.uW().setIsLike(i);
                bbVar.uW().setNum(bbVar.uW().getNum() - 1);
                ArrayList<MetaData> user = bbVar.uW().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bbVar.uW().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void gm(boolean z) {
        this.dEn = z;
    }
}
