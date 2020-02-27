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
    private TbPageContext<?> cVg;
    private int gHX;
    private FrsProfessionPermissionModel gIb;
    private com.baidu.tieba.frs.profession.permission.a gIc = new com.baidu.tieba.frs.profession.permission.a();
    private a gId;

    /* loaded from: classes.dex */
    public interface a {
        void lw(boolean z);

        void lx(boolean z);

        void t(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.cVg = tbPageContext;
        this.gIb = new FrsProfessionPermissionModel(tbPageContext, this.gIc);
        this.gIb.a(this);
    }

    public void a(a aVar) {
        this.gId = aVar;
    }

    public void tP(int i) {
        this.gHX = i;
        this.gIc.gHX = i;
    }

    public void BH(String str) {
        this.gIc.gHW = 1;
        this.gIc.forum_id = str;
        loadData();
    }

    public void aB(String str, int i) {
        this.gIc.gHV = i;
        this.gIc.forum_id = str;
        this.gIc.gHW = 2;
        loadData();
    }

    public void C(String str, long j) {
        this.gIc.forum_id = str;
        this.gIc.thread_id = j;
        this.gIc.gHW = 3;
        loadData();
    }

    private void loadData() {
        if (!this.gIb.isLoading()) {
            this.gIb.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.gHX == this.gHX) {
                switch (aVar.gHW) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.gHV);
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
            if (aVar.gHX == this.gHX) {
                switch (aVar.gHW) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.gHV);
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
                    this.cVg.showToast((int) R.string.neterror);
                    return;
                } else {
                    this.cVg.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.gHY) {
                if (bVar.gHZ == 1) {
                    ds(bVar.gIa, str);
                } else if (bVar.gHZ == 3) {
                    BI(bVar.gIa);
                }
            }
            if (this.gId != null) {
                this.gId.lx(bVar.gHY);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.cVg.showToast((int) R.string.neterror);
                } else {
                    this.cVg.showToast(bVar.errorString);
                }
            } else if (this.gId != null) {
                this.gId.t(bVar.gHY, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.gHY && bVar.gHZ == 2) {
                BI(bVar.gIa);
            }
            if (this.gId != null) {
                this.gId.lw(bVar.gHY);
            }
        }
    }

    private void ds(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
        aVar.fH(false);
        aVar.fG(false);
        aVar.sS(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.cVg.getPageActivity());
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
        aVar.b(this.cVg);
        aVar.aEA();
    }

    public void BI(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
        aVar.fH(false);
        aVar.fG(false);
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.cVg);
        aVar.aEA();
    }
}
