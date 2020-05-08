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
    private TbPageContext<?> duK;
    private int hsM;
    private FrsProfessionPermissionModel hsQ;
    private com.baidu.tieba.frs.profession.permission.a hsR = new com.baidu.tieba.frs.profession.permission.a();
    private a hsS;

    /* loaded from: classes.dex */
    public interface a {
        void mF(boolean z);

        void mG(boolean z);

        void u(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.duK = tbPageContext;
        this.hsQ = new FrsProfessionPermissionModel(tbPageContext, this.hsR);
        this.hsQ.a(this);
    }

    public void a(a aVar) {
        this.hsS = aVar;
    }

    public void ut(int i) {
        this.hsM = i;
        this.hsR.hsM = i;
    }

    public void Dv(String str) {
        this.hsR.hsL = 1;
        this.hsR.forum_id = str;
        loadData();
    }

    public void aL(String str, int i) {
        this.hsR.hsK = i;
        this.hsR.forum_id = str;
        this.hsR.hsL = 2;
        loadData();
    }

    public void E(String str, long j) {
        this.hsR.forum_id = str;
        this.hsR.thread_id = j;
        this.hsR.hsL = 3;
        loadData();
    }

    private void loadData() {
        if (!this.hsQ.isLoading()) {
            this.hsQ.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.hsM == this.hsM) {
                switch (aVar.hsL) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.hsK);
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
            if (aVar.hsM == this.hsM) {
                switch (aVar.hsL) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.hsK);
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
                    this.duK.showToast((int) R.string.neterror);
                    return;
                } else {
                    this.duK.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.hsN) {
                if (bVar.hsO == 1) {
                    dF(bVar.hsP, str);
                } else if (bVar.hsO == 3) {
                    Dw(bVar.hsP);
                }
            }
            if (this.hsS != null) {
                this.hsS.mG(bVar.hsN);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.duK.showToast((int) R.string.neterror);
                } else {
                    this.duK.showToast(bVar.errorString);
                }
            } else if (this.hsS != null) {
                this.hsS.u(bVar.hsN, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.hsN && bVar.hsO == 2) {
                Dw(bVar.hsP);
            }
            if (this.hsS != null) {
                this.hsS.mF(bVar.hsN);
            }
        }
    }

    private void dF(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duK.getPageActivity());
        aVar.gF(false);
        aVar.gE(false);
        aVar.ui(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.duK.getPageActivity());
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
        aVar.b(this.duK);
        aVar.aMS();
    }

    public void Dw(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duK.getPageActivity());
        aVar.gF(false);
        aVar.gE(false);
        aVar.ui(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.duK);
        aVar.aMS();
    }
}
