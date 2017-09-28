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
    private final CustomMessageListener anz;
    private boolean cAa;
    private String cAb;
    private PraiseModel cFA;
    private bh cFz;

    public f(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.anz = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    f.this.cAb = bhVar.getId();
                    if (!TextUtils.isEmpty(f.this.cAb) && bhVar.rl() != null) {
                        f.this.jz(bhVar.rl().getIsLike());
                    }
                }
            }
        };
        this.cxi.registerListener(this.anz);
        this.cFA = alj();
    }

    public final PraiseModel alj() {
        if (this.cFA == null) {
            this.cFA = new PraiseModel(this.cxi.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void hL(String str) {
                    int i = 1;
                    if (f.this.cAa) {
                        if (f.this.cFz != null && f.this.cFz.rl().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.jz(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void A(int i, String str) {
                    if (f.this.cxi != null && f.this.cxi.getPageContext() != null && f.this.cAa && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.tG(i)) {
                            AntiHelper.at(f.this.cxi.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.cxi.showToast(str);
                        }
                    }
                }
            });
        }
        return this.cFA;
    }

    public void jz(int i) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        com.baidu.tieba.tbadkCore.i ahk = this.cxi.ahk();
        if (ahk != null && this.cqt != null && (threadList = ahk.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof bh) {
                    bh bhVar = (bh) next;
                    if (bhVar == this.cFz) {
                        c(bhVar, i);
                        this.cFz = null;
                        break;
                    } else if (bhVar.getId() != null && bhVar.getId().equals(this.cAb)) {
                        c(bhVar, i);
                        this.cAb = null;
                        break;
                    }
                }
            }
            this.cqt.ahK().b(threadList, ahk);
            this.cqt.ahK().notifyDataSetChanged();
        }
    }

    public void c(bh bhVar, int i) {
        if (bhVar != null) {
            if (i == 1) {
                PraiseData rl = bhVar.rl();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rl == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bhVar.a(praiseData);
                        return;
                    }
                    bhVar.rl().getUser().add(0, metaData);
                    bhVar.rl().setNum(bhVar.rl().getNum() + 1);
                    bhVar.rl().setIsLike(i);
                }
            } else if (bhVar.rl() != null) {
                bhVar.rl().setIsLike(i);
                bhVar.rl().setNum(bhVar.rl().getNum() - 1);
                ArrayList<MetaData> user = bhVar.rl().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bhVar.rl().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void fe(boolean z) {
        this.cAa = z;
    }
}
