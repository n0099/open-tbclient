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
    private TbPageContext<?> eSJ;
    private FrsProfessionPermissionModel jAA;
    private com.baidu.tieba.frs.profession.permission.a jAB = new com.baidu.tieba.frs.profession.permission.a();
    private a jAC;
    private int jAw;

    /* loaded from: classes.dex */
    public interface a {
        void B(boolean z, int i);

        void qC(boolean z);

        void qD(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.eSJ = tbPageContext;
        this.jAA = new FrsProfessionPermissionModel(tbPageContext, this.jAB);
        this.jAA.a(this);
    }

    public void a(a aVar) {
        this.jAC = aVar;
    }

    public void zU(int i) {
        this.jAw = i;
        this.jAB.jAw = i;
    }

    public void Ks(String str) {
        this.jAB.jAv = 1;
        this.jAB.forum_id = str;
        loadData();
    }

    public void aZ(String str, int i) {
        this.jAB.jAu = i;
        this.jAB.forum_id = str;
        this.jAB.jAv = 2;
        loadData();
    }

    public void H(String str, long j) {
        this.jAB.forum_id = str;
        this.jAB.thread_id = j;
        this.jAB.jAv = 3;
        loadData();
    }

    private void loadData() {
        if (!this.jAA.isLoading()) {
            this.jAA.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.jAw == this.jAw) {
                switch (aVar.jAv) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jAu);
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
            if (aVar.jAw == this.jAw) {
                switch (aVar.jAv) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jAu);
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
                    this.eSJ.showToast(R.string.neterror);
                    return;
                } else {
                    this.eSJ.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.jAx) {
                if (bVar.jAy == 1) {
                    fc(bVar.jAz, str);
                } else if (bVar.jAy == 3) {
                    Kt(bVar.jAz);
                }
            }
            if (this.jAC != null) {
                this.jAC.qD(bVar.jAx);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.eSJ.showToast(R.string.neterror);
                } else {
                    this.eSJ.showToast(bVar.errorString);
                }
            } else if (this.jAC != null) {
                this.jAC.B(bVar.jAx, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.jAx && bVar.jAy == 2) {
                Kt(bVar.jAz);
            }
            if (this.jAC != null) {
                this.jAC.qC(bVar.jAx);
            }
        }
    }

    private void fc(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
        aVar.jE(false);
        aVar.jD(false);
        aVar.Ad(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.eSJ.getPageActivity());
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
        aVar.b(this.eSJ);
        aVar.bqe();
    }

    public void Kt(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
        aVar.jE(false);
        aVar.jD(false);
        aVar.Ad(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.eSJ);
        aVar.bqe();
    }
}
