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
    private TbPageContext<?> eCn;
    private int iYs;
    private FrsProfessionPermissionModel iYw;
    private com.baidu.tieba.frs.profession.permission.a iYx = new com.baidu.tieba.frs.profession.permission.a();
    private a iYy;

    /* loaded from: classes.dex */
    public interface a {
        void C(boolean z, int i);

        void pA(boolean z);

        void pz(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.eCn = tbPageContext;
        this.iYw = new FrsProfessionPermissionModel(tbPageContext, this.iYx);
        this.iYw.a(this);
    }

    public void a(a aVar) {
        this.iYy = aVar;
    }

    public void zP(int i) {
        this.iYs = i;
        this.iYx.iYs = i;
    }

    public void KE(String str) {
        this.iYx.iYr = 1;
        this.iYx.forum_id = str;
        loadData();
    }

    public void aP(String str, int i) {
        this.iYx.iYq = i;
        this.iYx.forum_id = str;
        this.iYx.iYr = 2;
        loadData();
    }

    public void G(String str, long j) {
        this.iYx.forum_id = str;
        this.iYx.thread_id = j;
        this.iYx.iYr = 3;
        loadData();
    }

    private void loadData() {
        if (!this.iYw.isLoading()) {
            this.iYw.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.iYs == this.iYs) {
                switch (aVar.iYr) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.iYq);
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
            if (aVar.iYs == this.iYs) {
                switch (aVar.iYr) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.iYq);
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
                    this.eCn.showToast(R.string.neterror);
                    return;
                } else {
                    this.eCn.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.iYt) {
                if (bVar.iYu == 1) {
                    eW(bVar.iYv, str);
                } else if (bVar.iYu == 3) {
                    KF(bVar.iYv);
                }
            }
            if (this.iYy != null) {
                this.iYy.pA(bVar.iYt);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.eCn.showToast(R.string.neterror);
                } else {
                    this.eCn.showToast(bVar.errorString);
                }
            } else if (this.iYy != null) {
                this.iYy.C(bVar.iYt, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.iYt && bVar.iYu == 2) {
                KF(bVar.iYv);
            }
            if (this.iYy != null) {
                this.iYy.pz(bVar.iYt);
            }
        }
    }

    private void eW(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
        aVar.iN(false);
        aVar.iM(false);
        aVar.Ba(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.eCn.getPageActivity());
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
        aVar.b(this.eCn);
        aVar.bmC();
    }

    public void KF(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
        aVar.iN(false);
        aVar.iM(false);
        aVar.Ba(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.eCn);
        aVar.bmC();
    }
}
