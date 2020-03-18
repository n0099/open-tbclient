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
    private TbPageContext<?> cVv;
    private int gJq;
    private FrsProfessionPermissionModel gJu;
    private com.baidu.tieba.frs.profession.permission.a gJv = new com.baidu.tieba.frs.profession.permission.a();
    private a gJw;

    /* loaded from: classes.dex */
    public interface a {
        void lC(boolean z);

        void lD(boolean z);

        void t(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.cVv = tbPageContext;
        this.gJu = new FrsProfessionPermissionModel(tbPageContext, this.gJv);
        this.gJu.a(this);
    }

    public void a(a aVar) {
        this.gJw = aVar;
    }

    public void tV(int i) {
        this.gJq = i;
        this.gJv.gJq = i;
    }

    public void BH(String str) {
        this.gJv.gJp = 1;
        this.gJv.forum_id = str;
        loadData();
    }

    public void aB(String str, int i) {
        this.gJv.gJo = i;
        this.gJv.forum_id = str;
        this.gJv.gJp = 2;
        loadData();
    }

    public void C(String str, long j) {
        this.gJv.forum_id = str;
        this.gJv.thread_id = j;
        this.gJv.gJp = 3;
        loadData();
    }

    private void loadData() {
        if (!this.gJu.isLoading()) {
            this.gJu.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.gJq == this.gJq) {
                switch (aVar.gJp) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.gJo);
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
            if (aVar.gJq == this.gJq) {
                switch (aVar.gJp) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.gJo);
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
                    this.cVv.showToast((int) R.string.neterror);
                    return;
                } else {
                    this.cVv.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.gJr) {
                if (bVar.gJs == 1) {
                    dq(bVar.gJt, str);
                } else if (bVar.gJs == 3) {
                    BI(bVar.gJt);
                }
            }
            if (this.gJw != null) {
                this.gJw.lD(bVar.gJr);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.cVv.showToast((int) R.string.neterror);
                } else {
                    this.cVv.showToast(bVar.errorString);
                }
            } else if (this.gJw != null) {
                this.gJw.t(bVar.gJr, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.gJr && bVar.gJs == 2) {
                BI(bVar.gJt);
            }
            if (this.gJw != null) {
                this.gJw.lC(bVar.gJr);
            }
        }
    }

    private void dq(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
        aVar.fI(false);
        aVar.fH(false);
        aVar.sR(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.cVv.getPageActivity());
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
        aVar.b(this.cVv);
        aVar.aEG();
    }

    public void BI(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
        aVar.fI(false);
        aVar.fH(false);
        aVar.sR(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.cVv);
        aVar.aEG();
    }
}
