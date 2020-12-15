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
    private TbPageContext<?> eNx;
    private int jsH;
    private FrsProfessionPermissionModel jsL;
    private com.baidu.tieba.frs.profession.permission.a jsM = new com.baidu.tieba.frs.profession.permission.a();
    private a jsN;

    /* loaded from: classes.dex */
    public interface a {
        void C(boolean z, int i);

        void qi(boolean z);

        void qj(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.eNx = tbPageContext;
        this.jsL = new FrsProfessionPermissionModel(tbPageContext, this.jsM);
        this.jsL.a(this);
    }

    public void a(a aVar) {
        this.jsN = aVar;
    }

    public void Bo(int i) {
        this.jsH = i;
        this.jsM.jsH = i;
    }

    public void LD(String str) {
        this.jsM.jsG = 1;
        this.jsM.forum_id = str;
        loadData();
    }

    public void aR(String str, int i) {
        this.jsM.jsF = i;
        this.jsM.forum_id = str;
        this.jsM.jsG = 2;
        loadData();
    }

    public void G(String str, long j) {
        this.jsM.forum_id = str;
        this.jsM.thread_id = j;
        this.jsM.jsG = 3;
        loadData();
    }

    private void loadData() {
        if (!this.jsL.isLoading()) {
            this.jsL.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.jsH == this.jsH) {
                switch (aVar.jsG) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jsF);
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
            if (aVar.jsH == this.jsH) {
                switch (aVar.jsG) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jsF);
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
                    this.eNx.showToast(R.string.neterror);
                    return;
                } else {
                    this.eNx.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.jsI) {
                if (bVar.jsJ == 1) {
                    fc(bVar.jsK, str);
                } else if (bVar.jsJ == 3) {
                    LE(bVar.jsK);
                }
            }
            if (this.jsN != null) {
                this.jsN.qj(bVar.jsI);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.eNx.showToast(R.string.neterror);
                } else {
                    this.eNx.showToast(bVar.errorString);
                }
            } else if (this.jsN != null) {
                this.jsN.C(bVar.jsI, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.jsI && bVar.jsJ == 2) {
                LE(bVar.jsK);
            }
            if (this.jsN != null) {
                this.jsN.qi(bVar.jsI);
            }
        }
    }

    private void fc(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
        aVar.jm(false);
        aVar.jl(false);
        aVar.Bq(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.eNx.getPageActivity());
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
        aVar.b(this.eNx);
        aVar.brv();
    }

    public void LE(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
        aVar.jm(false);
        aVar.jl(false);
        aVar.Bq(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.eNx);
        aVar.brv();
    }
}
