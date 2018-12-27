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
/* loaded from: classes6.dex */
public class f extends h {
    private String ebk;
    private final CustomMessageListener ebs;
    private boolean edA;
    private PraiseModel edB;
    private bb edz;

    public f(FrsFragment frsFragment) {
        super(frsFragment);
        this.ebs = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    f.this.ebk = bbVar.getId();
                    if (!TextUtils.isEmpty(f.this.ebk) && bbVar.zt() != null) {
                        f.this.ni(bbVar.zt().getIsLike());
                    }
                }
            }
        };
        this.ecG.registerListener(this.ebs);
        this.edB = aHn();
    }

    public final PraiseModel aHn() {
        if (this.edB == null) {
            this.edB = new PraiseModel(this.ecG.getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.frs.mc.f.1
                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void kd(String str) {
                    int i = 1;
                    if (f.this.edA) {
                        if (f.this.edz != null && f.this.edz.zt().getIsLike() == 1) {
                            i = 0;
                        }
                        f.this.ni(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
                }

                @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
                public void N(int i, String str) {
                    if (f.this.ecG != null && f.this.ecG.getPageContext() != null && f.this.edA && !TextUtils.isEmpty(str)) {
                        if (AntiHelper.aj(i, str)) {
                            AntiHelper.aJ(f.this.ecG.getPageContext().getPageActivity(), str);
                        } else {
                            f.this.ecG.showToast(str);
                        }
                    }
                }
            });
        }
        return this.edB;
    }

    public void ni(int i) {
        ArrayList<com.baidu.adp.widget.ListView.h> threadList;
        l aBO = this.ecG.aBO();
        if (aBO != null && this.dKR != null && (threadList = aBO.getThreadList()) != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar == this.edz) {
                        a(bbVar, i);
                        this.edz = null;
                        break;
                    } else if (bbVar.getId() != null && bbVar.getId().equals(this.ebk)) {
                        a(bbVar, i);
                        this.ebk = null;
                        break;
                    }
                }
            }
            this.dKR.aCE().b(threadList, aBO);
            this.dKR.aCE().notifyDataSetChanged();
        }
    }

    public void a(bb bbVar, int i) {
        if (bbVar != null) {
            if (i == 1) {
                PraiseData zt = bbVar.zt();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (zt == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bbVar.a(praiseData);
                        return;
                    }
                    bbVar.zt().getUser().add(0, metaData);
                    bbVar.zt().setNum(bbVar.zt().getNum() + 1);
                    bbVar.zt().setIsLike(i);
                }
            } else if (bbVar.zt() != null) {
                bbVar.zt().setIsLike(i);
                bbVar.zt().setNum(bbVar.zt().getNum() - 1);
                ArrayList<MetaData> user = bbVar.zt().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bbVar.zt().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void hp(boolean z) {
        this.edA = z;
    }
}
