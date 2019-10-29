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
    private TbPageContext<?> cfl;
    private int fPn;
    private FrsProfessionPermissionModel fPr;
    private com.baidu.tieba.frs.profession.permission.a fPs = new com.baidu.tieba.frs.profession.permission.a();
    private a fPt;

    /* loaded from: classes.dex */
    public interface a {
        void jW(boolean z);

        void jX(boolean z);

        void o(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.cfl = tbPageContext;
        this.fPr = new FrsProfessionPermissionModel(tbPageContext, this.fPs);
        this.fPr.a(this);
    }

    public void a(a aVar) {
        this.fPt = aVar;
    }

    public void rz(int i) {
        this.fPn = i;
        this.fPs.fPn = i;
    }

    public void ws(String str) {
        this.fPs.fPm = 1;
        this.fPs.forum_id = str;
        loadData();
    }

    public void at(String str, int i) {
        this.fPs.fPl = i;
        this.fPs.forum_id = str;
        this.fPs.fPm = 2;
        loadData();
    }

    public void z(String str, long j) {
        this.fPs.forum_id = str;
        this.fPs.thread_id = j;
        this.fPs.fPm = 3;
        loadData();
    }

    private void loadData() {
        if (!this.fPr.isLoading()) {
            this.fPr.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.fPn == this.fPn) {
                switch (aVar.fPm) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.fPl);
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
            if (aVar.fPn == this.fPn) {
                switch (aVar.fPm) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.fPl);
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
                    this.cfl.showToast((int) R.string.neterror);
                    return;
                } else {
                    this.cfl.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.fPo) {
                if (bVar.fPp == 1) {
                    cN(bVar.fPq, str);
                } else if (bVar.fPp == 3) {
                    wt(bVar.fPq);
                }
            }
            if (this.fPt != null) {
                this.fPt.jX(bVar.fPo);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.cfl.showToast((int) R.string.neterror);
                } else {
                    this.cfl.showToast(bVar.errorString);
                }
            } else if (this.fPt != null) {
                this.fPt.o(bVar.fPo, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.fPo && bVar.fPp == 2) {
                wt(bVar.fPq);
            }
            if (this.fPt != null) {
                this.fPt.jW(bVar.fPo);
            }
        }
    }

    private void cN(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
        aVar.eh(false);
        aVar.eg(false);
        aVar.nn(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.cfl.getPageActivity());
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
        aVar.b(this.cfl);
        aVar.akO();
    }

    public void wt(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
        aVar.eh(false);
        aVar.eg(false);
        aVar.nn(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.cfl);
        aVar.akO();
    }
}
