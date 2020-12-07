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
    private int jsF;
    private FrsProfessionPermissionModel jsJ;
    private com.baidu.tieba.frs.profession.permission.a jsK = new com.baidu.tieba.frs.profession.permission.a();
    private a jsL;

    /* loaded from: classes.dex */
    public interface a {
        void C(boolean z, int i);

        void qi(boolean z);

        void qj(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.eNx = tbPageContext;
        this.jsJ = new FrsProfessionPermissionModel(tbPageContext, this.jsK);
        this.jsJ.a(this);
    }

    public void a(a aVar) {
        this.jsL = aVar;
    }

    public void Bo(int i) {
        this.jsF = i;
        this.jsK.jsF = i;
    }

    public void LD(String str) {
        this.jsK.jsE = 1;
        this.jsK.forum_id = str;
        loadData();
    }

    public void aR(String str, int i) {
        this.jsK.jsD = i;
        this.jsK.forum_id = str;
        this.jsK.jsE = 2;
        loadData();
    }

    public void G(String str, long j) {
        this.jsK.forum_id = str;
        this.jsK.thread_id = j;
        this.jsK.jsE = 3;
        loadData();
    }

    private void loadData() {
        if (!this.jsJ.isLoading()) {
            this.jsJ.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.jsF == this.jsF) {
                switch (aVar.jsE) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jsD);
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
            if (aVar.jsF == this.jsF) {
                switch (aVar.jsE) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jsD);
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
            if (!bVar.jsG) {
                if (bVar.jsH == 1) {
                    fc(bVar.jsI, str);
                } else if (bVar.jsH == 3) {
                    LE(bVar.jsI);
                }
            }
            if (this.jsL != null) {
                this.jsL.qj(bVar.jsG);
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
            } else if (this.jsL != null) {
                this.jsL.C(bVar.jsG, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.jsG && bVar.jsH == 2) {
                LE(bVar.jsI);
            }
            if (this.jsL != null) {
                this.jsL.qi(bVar.jsG);
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
