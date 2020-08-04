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
    private TbPageContext<?> dVN;
    private int ibA;
    private FrsProfessionPermissionModel ibE;
    private com.baidu.tieba.frs.profession.permission.a ibF = new com.baidu.tieba.frs.profession.permission.a();
    private a ibG;

    /* loaded from: classes.dex */
    public interface a {
        void nQ(boolean z);

        void nR(boolean z);

        void z(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.dVN = tbPageContext;
        this.ibE = new FrsProfessionPermissionModel(tbPageContext, this.ibF);
        this.ibE.a(this);
    }

    public void a(a aVar) {
        this.ibG = aVar;
    }

    public void vY(int i) {
        this.ibA = i;
        this.ibF.ibA = i;
    }

    public void Gr(String str) {
        this.ibF.ibz = 1;
        this.ibF.forum_id = str;
        loadData();
    }

    public void aK(String str, int i) {
        this.ibF.iby = i;
        this.ibF.forum_id = str;
        this.ibF.ibz = 2;
        loadData();
    }

    public void B(String str, long j) {
        this.ibF.forum_id = str;
        this.ibF.thread_id = j;
        this.ibF.ibz = 3;
        loadData();
    }

    private void loadData() {
        if (!this.ibE.isLoading()) {
            this.ibE.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.ibA == this.ibA) {
                switch (aVar.ibz) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.iby);
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
            if (aVar.ibA == this.ibA) {
                switch (aVar.ibz) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.iby);
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
                    this.dVN.showToast(R.string.neterror);
                    return;
                } else {
                    this.dVN.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.ibB) {
                if (bVar.ibC == 1) {
                    eo(bVar.ibD, str);
                } else if (bVar.ibC == 3) {
                    Gs(bVar.ibD);
                }
            }
            if (this.ibG != null) {
                this.ibG.nR(bVar.ibB);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.dVN.showToast(R.string.neterror);
                } else {
                    this.dVN.showToast(bVar.errorString);
                }
            } else if (this.ibG != null) {
                this.ibG.z(bVar.ibB, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.ibB && bVar.ibC == 2) {
                Gs(bVar.ibD);
            }
            if (this.ibG != null) {
                this.ibG.nQ(bVar.ibB);
            }
        }
    }

    private void eo(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
        aVar.hK(false);
        aVar.hJ(false);
        aVar.xl(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.dVN.getPageActivity());
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
        aVar.b(this.dVN);
        aVar.aYL();
    }

    public void Gs(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
        aVar.hK(false);
        aVar.hJ(false);
        aVar.xl(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.dVN);
        aVar.aYL();
    }
}
