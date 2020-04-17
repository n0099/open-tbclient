package com.baidu.tieba.frs.profession.permission;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c implements NetModel.b {
    private TbPageContext<?> duG;
    private int hsG;
    private FrsProfessionPermissionModel hsK;
    private com.baidu.tieba.frs.profession.permission.a hsL = new com.baidu.tieba.frs.profession.permission.a();
    private a hsM;

    /* loaded from: classes.dex */
    public interface a {
        void mF(boolean z);

        void mG(boolean z);

        void u(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.duG = tbPageContext;
        this.hsK = new FrsProfessionPermissionModel(tbPageContext, this.hsL);
        this.hsK.a(this);
    }

    public void a(a aVar) {
        this.hsM = aVar;
    }

    public void ut(int i) {
        this.hsG = i;
        this.hsL.hsG = i;
    }

    public void Ds(String str) {
        this.hsL.hsF = 1;
        this.hsL.forum_id = str;
        loadData();
    }

    public void aL(String str, int i) {
        this.hsL.hsE = i;
        this.hsL.forum_id = str;
        this.hsL.hsF = 2;
        loadData();
    }

    public void E(String str, long j) {
        this.hsL.forum_id = str;
        this.hsL.thread_id = j;
        this.hsL.hsF = 3;
        loadData();
    }

    private void loadData() {
        if (!this.hsK.isLoading()) {
            this.hsK.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.hsG == this.hsG) {
                switch (aVar.hsF) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.hsE);
                        return;
                    case 3:
                        a(bVar, aVar.forum_id);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcSocketResponsedMessage.getData();
            if (aVar.hsG == this.hsG) {
                switch (aVar.hsF) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.hsE);
                        return;
                    case 3:
                        a(bVar, aVar.forum_id);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void a(b bVar, String str) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.duG.showToast((int) R.string.neterror);
                    return;
                } else {
                    this.duG.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.hsH) {
                if (bVar.hsI == 1) {
                    dF(bVar.hsJ, str);
                } else if (bVar.hsI == 3) {
                    Dt(bVar.hsJ);
                }
            }
            if (this.hsM != null) {
                this.hsM.mG(bVar.hsH);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.duG.showToast((int) R.string.neterror);
                } else {
                    this.duG.showToast(bVar.errorString);
                }
            } else if (this.hsM != null) {
                this.hsM.u(bVar.hsH, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.hsH && bVar.hsI == 2) {
                Dt(bVar.hsJ);
            }
            if (this.hsM != null) {
                this.hsM.mF(bVar.hsH);
            }
        }
    }

    private void dF(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
        aVar.gF(false);
        aVar.gE(false);
        aVar.uf(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.duG.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + str2);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, membercenterActivityConfig));
                aVar.dismiss();
            }
        });
        aVar.b(R.string.comfirm_cancel, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.duG);
        aVar.aMU();
    }

    public void Dt(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
        aVar.gF(false);
        aVar.gE(false);
        aVar.uf(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.duG);
        aVar.aMU();
    }
}
