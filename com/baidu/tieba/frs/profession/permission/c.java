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
    private TbPageContext<?> cQU;
    private int gCJ;
    private FrsProfessionPermissionModel gCN;
    private com.baidu.tieba.frs.profession.permission.a gCO = new com.baidu.tieba.frs.profession.permission.a();
    private a gCP;

    /* loaded from: classes.dex */
    public interface a {
        void li(boolean z);

        void lj(boolean z);

        void r(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.cQU = tbPageContext;
        this.gCN = new FrsProfessionPermissionModel(tbPageContext, this.gCO);
        this.gCN.a(this);
    }

    public void a(a aVar) {
        this.gCP = aVar;
    }

    public void tE(int i) {
        this.gCJ = i;
        this.gCO.gCJ = i;
    }

    public void Bh(String str) {
        this.gCO.gCI = 1;
        this.gCO.forum_id = str;
        loadData();
    }

    public void aC(String str, int i) {
        this.gCO.gCH = i;
        this.gCO.forum_id = str;
        this.gCO.gCI = 2;
        loadData();
    }

    public void B(String str, long j) {
        this.gCO.forum_id = str;
        this.gCO.thread_id = j;
        this.gCO.gCI = 3;
        loadData();
    }

    private void loadData() {
        if (!this.gCN.isLoading()) {
            this.gCN.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.gCJ == this.gCJ) {
                switch (aVar.gCI) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.gCH);
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
            if (aVar.gCJ == this.gCJ) {
                switch (aVar.gCI) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.gCH);
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
                    this.cQU.showToast((int) R.string.neterror);
                    return;
                } else {
                    this.cQU.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.gCK) {
                if (bVar.gCL == 1) {
                    dh(bVar.gCM, str);
                } else if (bVar.gCL == 3) {
                    Bi(bVar.gCM);
                }
            }
            if (this.gCP != null) {
                this.gCP.lj(bVar.gCK);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.cQU.showToast((int) R.string.neterror);
                } else {
                    this.cQU.showToast(bVar.errorString);
                }
            } else if (this.gCP != null) {
                this.gCP.r(bVar.gCK, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.gCK && bVar.gCL == 2) {
                Bi(bVar.gCM);
            }
            if (this.gCP != null) {
                this.gCP.li(bVar.gCK);
            }
        }
    }

    private void dh(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
        aVar.fv(false);
        aVar.fu(false);
        aVar.sz(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.cQU.getPageActivity());
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
        aVar.b(this.cQU);
        aVar.aBW();
    }

    public void Bi(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
        aVar.fv(false);
        aVar.fu(false);
        aVar.sz(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.cQU);
        aVar.aBW();
    }
}
