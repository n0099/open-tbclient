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
    private TbPageContext<?> eUY;
    private int jGa;
    private FrsProfessionPermissionModel jGe;
    private com.baidu.tieba.frs.profession.permission.a jGf = new com.baidu.tieba.frs.profession.permission.a();
    private a jGg;

    /* loaded from: classes.dex */
    public interface a {
        void B(boolean z, int i);

        void qM(boolean z);

        void qN(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.eUY = tbPageContext;
        this.jGe = new FrsProfessionPermissionModel(tbPageContext, this.jGf);
        this.jGe.a(this);
    }

    public void a(a aVar) {
        this.jGg = aVar;
    }

    public void Ae(int i) {
        this.jGa = i;
        this.jGf.jGa = i;
    }

    public void Ld(String str) {
        this.jGf.jFZ = 1;
        this.jGf.forum_id = str;
        loadData();
    }

    public void aZ(String str, int i) {
        this.jGf.jFY = i;
        this.jGf.forum_id = str;
        this.jGf.jFZ = 2;
        loadData();
    }

    public void G(String str, long j) {
        this.jGf.forum_id = str;
        this.jGf.thread_id = j;
        this.jGf.jFZ = 3;
        loadData();
    }

    private void loadData() {
        if (!this.jGe.isLoading()) {
            this.jGe.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.jGa == this.jGa) {
                switch (aVar.jFZ) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jFY);
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
            if (aVar.jGa == this.jGa) {
                switch (aVar.jFZ) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jFY);
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
                    this.eUY.showToast(R.string.neterror);
                    return;
                } else {
                    this.eUY.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.jGb) {
                if (bVar.jGc == 1) {
                    fc(bVar.jGd, str);
                } else if (bVar.jGc == 3) {
                    Le(bVar.jGd);
                }
            }
            if (this.jGg != null) {
                this.jGg.qN(bVar.jGb);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.eUY.showToast(R.string.neterror);
                } else {
                    this.eUY.showToast(bVar.errorString);
                }
            } else if (this.jGg != null) {
                this.jGg.B(bVar.jGb, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.jGb && bVar.jGc == 2) {
                Le(bVar.jGd);
            }
            if (this.jGg != null) {
                this.jGg.qM(bVar.jGb);
            }
        }
    }

    private void fc(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
        aVar.jG(false);
        aVar.jF(false);
        aVar.Au(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.eUY.getPageActivity());
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
        aVar.b(this.eUY);
        aVar.bqx();
    }

    public void Le(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
        aVar.jG(false);
        aVar.jF(false);
        aVar.Au(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.eUY);
        aVar.bqx();
    }
}
