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
    private TbPageContext<?> cVi;
    private int gIl;
    private FrsProfessionPermissionModel gIp;
    private com.baidu.tieba.frs.profession.permission.a gIq = new com.baidu.tieba.frs.profession.permission.a();
    private a gIr;

    /* loaded from: classes.dex */
    public interface a {
        void lw(boolean z);

        void lx(boolean z);

        void t(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.cVi = tbPageContext;
        this.gIp = new FrsProfessionPermissionModel(tbPageContext, this.gIq);
        this.gIp.a(this);
    }

    public void a(a aVar) {
        this.gIr = aVar;
    }

    public void tP(int i) {
        this.gIl = i;
        this.gIq.gIl = i;
    }

    public void BI(String str) {
        this.gIq.gIk = 1;
        this.gIq.forum_id = str;
        loadData();
    }

    public void aB(String str, int i) {
        this.gIq.gIj = i;
        this.gIq.forum_id = str;
        this.gIq.gIk = 2;
        loadData();
    }

    public void C(String str, long j) {
        this.gIq.forum_id = str;
        this.gIq.thread_id = j;
        this.gIq.gIk = 3;
        loadData();
    }

    private void loadData() {
        if (!this.gIp.isLoading()) {
            this.gIp.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.gIl == this.gIl) {
                switch (aVar.gIk) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.gIj);
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
            if (aVar.gIl == this.gIl) {
                switch (aVar.gIk) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.gIj);
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
                    this.cVi.showToast((int) R.string.neterror);
                    return;
                } else {
                    this.cVi.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.gIm) {
                if (bVar.gIn == 1) {
                    ds(bVar.gIo, str);
                } else if (bVar.gIn == 3) {
                    BJ(bVar.gIo);
                }
            }
            if (this.gIr != null) {
                this.gIr.lx(bVar.gIm);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.cVi.showToast((int) R.string.neterror);
                } else {
                    this.cVi.showToast(bVar.errorString);
                }
            } else if (this.gIr != null) {
                this.gIr.t(bVar.gIm, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.gIm && bVar.gIn == 2) {
                BJ(bVar.gIo);
            }
            if (this.gIr != null) {
                this.gIr.lw(bVar.gIm);
            }
        }
    }

    private void ds(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
        aVar.fH(false);
        aVar.fG(false);
        aVar.sS(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.cVi.getPageActivity());
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
        aVar.b(this.cVi);
        aVar.aEC();
    }

    public void BJ(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
        aVar.fH(false);
        aVar.fG(false);
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.cVi);
        aVar.aEC();
    }
}
