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
    private TbPageContext<?> eXu;
    private int jFc;
    private FrsProfessionPermissionModel jFg;
    private com.baidu.tieba.frs.profession.permission.a jFh = new com.baidu.tieba.frs.profession.permission.a();
    private a jFi;

    /* loaded from: classes.dex */
    public interface a {
        void B(boolean z, int i);

        void qG(boolean z);

        void qH(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.eXu = tbPageContext;
        this.jFg = new FrsProfessionPermissionModel(tbPageContext, this.jFh);
        this.jFg.a(this);
    }

    public void a(a aVar) {
        this.jFi = aVar;
    }

    public void BA(int i) {
        this.jFc = i;
        this.jFh.jFc = i;
    }

    public void LD(String str) {
        this.jFh.jFb = 1;
        this.jFh.forum_id = str;
        loadData();
    }

    public void aZ(String str, int i) {
        this.jFh.jFa = i;
        this.jFh.forum_id = str;
        this.jFh.jFb = 2;
        loadData();
    }

    public void H(String str, long j) {
        this.jFh.forum_id = str;
        this.jFh.thread_id = j;
        this.jFh.jFb = 3;
        loadData();
    }

    private void loadData() {
        if (!this.jFg.isLoading()) {
            this.jFg.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.jFc == this.jFc) {
                switch (aVar.jFb) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jFa);
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
            if (aVar.jFc == this.jFc) {
                switch (aVar.jFb) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jFa);
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
                    this.eXu.showToast(R.string.neterror);
                    return;
                } else {
                    this.eXu.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.jFd) {
                if (bVar.jFe == 1) {
                    fd(bVar.jFf, str);
                } else if (bVar.jFe == 3) {
                    LE(bVar.jFf);
                }
            }
            if (this.jFi != null) {
                this.jFi.qH(bVar.jFd);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.eXu.showToast(R.string.neterror);
                } else {
                    this.eXu.showToast(bVar.errorString);
                }
            } else if (this.jFi != null) {
                this.jFi.B(bVar.jFd, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.jFd && bVar.jFe == 2) {
                LE(bVar.jFf);
            }
            if (this.jFi != null) {
                this.jFi.qG(bVar.jFd);
            }
        }
    }

    private void fd(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
        aVar.jI(false);
        aVar.jH(false);
        aVar.Bp(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.eXu.getPageActivity());
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
        aVar.b(this.eXu);
        aVar.btX();
    }

    public void LE(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
        aVar.jI(false);
        aVar.jH(false);
        aVar.Bp(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.eXu);
        aVar.btX();
    }
}
