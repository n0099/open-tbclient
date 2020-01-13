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
    private TbPageContext<?> cRe;
    private int gFY;
    private FrsProfessionPermissionModel gGc;
    private com.baidu.tieba.frs.profession.permission.a gGd = new com.baidu.tieba.frs.profession.permission.a();
    private a gGe;

    /* loaded from: classes.dex */
    public interface a {
        void lt(boolean z);

        void lu(boolean z);

        void s(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.cRe = tbPageContext;
        this.gGc = new FrsProfessionPermissionModel(tbPageContext, this.gGd);
        this.gGc.a(this);
    }

    public void a(a aVar) {
        this.gGe = aVar;
    }

    public void tJ(int i) {
        this.gFY = i;
        this.gGd.gFY = i;
    }

    public void Br(String str) {
        this.gGd.gFX = 1;
        this.gGd.forum_id = str;
        loadData();
    }

    public void aD(String str, int i) {
        this.gGd.gFW = i;
        this.gGd.forum_id = str;
        this.gGd.gFX = 2;
        loadData();
    }

    public void C(String str, long j) {
        this.gGd.forum_id = str;
        this.gGd.thread_id = j;
        this.gGd.gFX = 3;
        loadData();
    }

    private void loadData() {
        if (!this.gGc.isLoading()) {
            this.gGc.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.gFY == this.gFY) {
                switch (aVar.gFX) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.gFW);
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
            if (aVar.gFY == this.gFY) {
                switch (aVar.gFX) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.gFW);
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
                    this.cRe.showToast((int) R.string.neterror);
                    return;
                } else {
                    this.cRe.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.gFZ) {
                if (bVar.gGa == 1) {
                    dj(bVar.gGb, str);
                } else if (bVar.gGa == 3) {
                    Bs(bVar.gGb);
                }
            }
            if (this.gGe != null) {
                this.gGe.lu(bVar.gFZ);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.cRe.showToast((int) R.string.neterror);
                } else {
                    this.cRe.showToast(bVar.errorString);
                }
            } else if (this.gGe != null) {
                this.gGe.s(bVar.gFZ, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.gFZ && bVar.gGa == 2) {
                Bs(bVar.gGb);
            }
            if (this.gGe != null) {
                this.gGe.lt(bVar.gFZ);
            }
        }
    }

    private void dj(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
        aVar.fA(false);
        aVar.fz(false);
        aVar.sC(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.cRe.getPageActivity());
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
        aVar.b(this.cRe);
        aVar.aCp();
    }

    public void Bs(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
        aVar.fA(false);
        aVar.fz(false);
        aVar.sC(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.cRe);
        aVar.aCp();
    }
}
