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
    private TbPageContext<?> ceu;
    private FrsProfessionPermissionModel fOA;
    private com.baidu.tieba.frs.profession.permission.a fOB = new com.baidu.tieba.frs.profession.permission.a();
    private a fOC;
    private int fOw;

    /* loaded from: classes.dex */
    public interface a {
        void jW(boolean z);

        void jX(boolean z);

        void o(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.ceu = tbPageContext;
        this.fOA = new FrsProfessionPermissionModel(tbPageContext, this.fOB);
        this.fOA.a(this);
    }

    public void a(a aVar) {
        this.fOC = aVar;
    }

    public void ry(int i) {
        this.fOw = i;
        this.fOB.fOw = i;
    }

    public void ws(String str) {
        this.fOB.fOv = 1;
        this.fOB.forum_id = str;
        loadData();
    }

    public void at(String str, int i) {
        this.fOB.fOu = i;
        this.fOB.forum_id = str;
        this.fOB.fOv = 2;
        loadData();
    }

    public void z(String str, long j) {
        this.fOB.forum_id = str;
        this.fOB.thread_id = j;
        this.fOB.fOv = 3;
        loadData();
    }

    private void loadData() {
        if (!this.fOA.isLoading()) {
            this.fOA.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.fOw == this.fOw) {
                switch (aVar.fOv) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.fOu);
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
            if (aVar.fOw == this.fOw) {
                switch (aVar.fOv) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.fOu);
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
                    this.ceu.showToast((int) R.string.neterror);
                    return;
                } else {
                    this.ceu.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.fOx) {
                if (bVar.fOy == 1) {
                    cN(bVar.fOz, str);
                } else if (bVar.fOy == 3) {
                    wt(bVar.fOz);
                }
            }
            if (this.fOC != null) {
                this.fOC.jX(bVar.fOx);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.ceu.showToast((int) R.string.neterror);
                } else {
                    this.ceu.showToast(bVar.errorString);
                }
            } else if (this.fOC != null) {
                this.fOC.o(bVar.fOx, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.fOx && bVar.fOy == 2) {
                wt(bVar.fOz);
            }
            if (this.fOC != null) {
                this.fOC.jW(bVar.fOx);
            }
        }
    }

    private void cN(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
        aVar.eh(false);
        aVar.eg(false);
        aVar.nn(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.ceu.getPageActivity());
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
        aVar.b(this.ceu);
        aVar.akM();
    }

    public void wt(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
        aVar.eh(false);
        aVar.eg(false);
        aVar.nn(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.ceu);
        aVar.akM();
    }
}
