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
    private FrsProfessionPermissionModel ibC;
    private com.baidu.tieba.frs.profession.permission.a ibD = new com.baidu.tieba.frs.profession.permission.a();
    private a ibE;
    private int iby;

    /* loaded from: classes.dex */
    public interface a {
        void nQ(boolean z);

        void nR(boolean z);

        void z(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.dVN = tbPageContext;
        this.ibC = new FrsProfessionPermissionModel(tbPageContext, this.ibD);
        this.ibC.a(this);
    }

    public void a(a aVar) {
        this.ibE = aVar;
    }

    public void vY(int i) {
        this.iby = i;
        this.ibD.iby = i;
    }

    public void Gr(String str) {
        this.ibD.ibx = 1;
        this.ibD.forum_id = str;
        loadData();
    }

    public void aK(String str, int i) {
        this.ibD.ibw = i;
        this.ibD.forum_id = str;
        this.ibD.ibx = 2;
        loadData();
    }

    public void B(String str, long j) {
        this.ibD.forum_id = str;
        this.ibD.thread_id = j;
        this.ibD.ibx = 3;
        loadData();
    }

    private void loadData() {
        if (!this.ibC.isLoading()) {
            this.ibC.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.iby == this.iby) {
                switch (aVar.ibx) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.ibw);
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
            if (aVar.iby == this.iby) {
                switch (aVar.ibx) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.ibw);
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
            if (!bVar.ibz) {
                if (bVar.ibA == 1) {
                    eo(bVar.ibB, str);
                } else if (bVar.ibA == 3) {
                    Gs(bVar.ibB);
                }
            }
            if (this.ibE != null) {
                this.ibE.nR(bVar.ibz);
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
            } else if (this.ibE != null) {
                this.ibE.z(bVar.ibz, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.ibz && bVar.ibA == 2) {
                Gs(bVar.ibB);
            }
            if (this.ibE != null) {
                this.ibE.nQ(bVar.ibz);
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
