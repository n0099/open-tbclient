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
    private final CustomMessageListener ann;
    private bh cFn;
    private PraiseModel cFo;
    private boolean czO;
    private String czP;

    public f(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.ann = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    f.this.czP = bhVar.getId();
                    if (!TextUtils.isEmpty(f.this.czP) && bhVar.re() != null) {
                        f.this.jy(bhVar.re().getIsLike());
                    }
                }
            }
        };
        this.cwW.registerListener(this.ann);
        this.cFo = ale();
    }

    public final PraiseModel ale() {
        if (this.cFo == null) {
            this.cFo = new PraiseModel(this.cwW.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hK(String str) {
                    int i = 1;
                    if (f.this.czO) {
                        if (f.this.cFn != null && f.this.cFn.re().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.jy(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void A(int i, String str) {
                    if (f.this.cwW != null && f.this.cwW.getPageContext() != null && f.this.czO && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.tF(i)) {
                            AntiHelper.ao(f.this.cwW.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.cwW.showToast(str);
                        }
                    }
                }
            });
        }
        return this.cFo;
    }

    public void jy(int i) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        com.baidu.tieba.tbadkCore.i ahf = this.cwW.ahf();
        if (ahf != null && this.cqh != null && (threadList = ahf.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof bh) {
                    bh bhVar = (bh) next;
                    if (bhVar == this.cFn) {
                        c(bhVar, i);
                        this.cFn = null;
                        break;
                    } else if (bhVar.getId() != null && bhVar.getId().equals(this.czP)) {
                        c(bhVar, i);
                        this.czP = null;
                        break;
                    }
                }
            }
            this.cqh.ahF().b(threadList, ahf);
            this.cqh.ahF().notifyDataSetChanged();
        }
    }

    public void c(bh bhVar, int i) {
        if (bhVar != null) {
            if (i == 1) {
                PraiseData re = bhVar.re();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (re == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bhVar.a(praiseData);
                        return;
                    }
                    bhVar.re().getUser().add(0, metaData);
                    bhVar.re().setNum(bhVar.re().getNum() + 1);
                    bhVar.re().setIsLike(i);
                }
            } else if (bhVar.re() != null) {
                bhVar.re().setIsLike(i);
                bhVar.re().setNum(bhVar.re().getNum() - 1);
                ArrayList<MetaData> user = bhVar.re().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bhVar.re().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fd(boolean z) {
        this.czO = z;
    }
}
