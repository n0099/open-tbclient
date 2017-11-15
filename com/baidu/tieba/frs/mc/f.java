package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends h {
    private final CustomMessageListener anH;
    private boolean cHW;
    private String cHX;
    private bh cOU;
    private PraiseModel cOV;

    public f(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.anH = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    f.this.cHX = bhVar.getId();
                    if (!TextUtils.isEmpty(f.this.cHX) && bhVar.ri() != null) {
                        f.this.jP(bhVar.ri().getIsLike());
                    }
                }
            }
        };
        this.cFg.registerListener(this.anH);
        this.cOV = aoe();
    }

    public final PraiseModel aoe() {
        if (this.cOV == null) {
            this.cOV = new PraiseModel(this.cFg.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hT(String str) {
                    int i = 1;
                    if (f.this.cHW) {
                        if (f.this.cOU != null && f.this.cOU.ri().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.jP(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void C(int i, String str) {
                    if (f.this.cFg != null && f.this.cFg.getPageContext() != null && f.this.cHW && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.ua(i)) {
                            AntiHelper.ao(f.this.cFg.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.cFg.showToast(str);
                        }
                    }
                }
            });
        }
        return this.cOV;
    }

    public void jP(int i) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        com.baidu.tieba.tbadkCore.j ajB = this.cFg.ajB();
        if (ajB != null && this.cxU != null && (threadList = ajB.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof bh) {
                    bh bhVar = (bh) next;
                    if (bhVar == this.cOU) {
                        c(bhVar, i);
                        this.cOU = null;
                        break;
                    } else if (bhVar.getId() != null && bhVar.getId().equals(this.cHX)) {
                        c(bhVar, i);
                        this.cHX = null;
                        break;
                    }
                }
            }
            this.cxU.akb().b(threadList, ajB);
            this.cxU.akb().notifyDataSetChanged();
        }
    }

    public void c(bh bhVar, int i) {
        if (bhVar != null) {
            if (i == 1) {
                PraiseData ri = bhVar.ri();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (ri == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bhVar.a(praiseData);
                        return;
                    }
                    bhVar.ri().getUser().add(0, metaData);
                    bhVar.ri().setNum(bhVar.ri().getNum() + 1);
                    bhVar.ri().setIsLike(i);
                }
            } else if (bhVar.ri() != null) {
                bhVar.ri().setIsLike(i);
                bhVar.ri().setNum(bhVar.ri().getNum() - 1);
                ArrayList<MetaData> user = bhVar.ri().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bhVar.ri().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fh(boolean z) {
        this.cHW = z;
    }
}
