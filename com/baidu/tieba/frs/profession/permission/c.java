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
    private TbPageContext<?> dIF;
    private int hHA;
    private FrsProfessionPermissionModel hHE;
    private com.baidu.tieba.frs.profession.permission.a hHF = new com.baidu.tieba.frs.profession.permission.a();
    private a hHG;

    /* loaded from: classes.dex */
    public interface a {
        void na(boolean z);

        void nb(boolean z);

        void x(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.dIF = tbPageContext;
        this.hHE = new FrsProfessionPermissionModel(tbPageContext, this.hHF);
        this.hHE.a(this);
    }

    public void a(a aVar) {
        this.hHG = aVar;
    }

    public void uZ(int i) {
        this.hHA = i;
        this.hHF.hHA = i;
    }

    public void Fe(String str) {
        this.hHF.hHz = 1;
        this.hHF.forum_id = str;
        loadData();
    }

    public void aM(String str, int i) {
        this.hHF.hHy = i;
        this.hHF.forum_id = str;
        this.hHF.hHz = 2;
        loadData();
    }

    public void D(String str, long j) {
        this.hHF.forum_id = str;
        this.hHF.thread_id = j;
        this.hHF.hHz = 3;
        loadData();
    }

    private void loadData() {
        if (!this.hHE.isLoading()) {
            this.hHE.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.hHA == this.hHA) {
                switch (aVar.hHz) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.hHy);
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
            if (aVar.hHA == this.hHA) {
                switch (aVar.hHz) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.hHy);
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
                    this.dIF.showToast((int) R.string.neterror);
                    return;
                } else {
                    this.dIF.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.hHB) {
                if (bVar.hHC == 1) {
                    eg(bVar.hHD, str);
                } else if (bVar.hHC == 3) {
                    Ff(bVar.hHD);
                }
            }
            if (this.hHG != null) {
                this.hHG.nb(bVar.hHB);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.dIF.showToast((int) R.string.neterror);
                } else {
                    this.dIF.showToast(bVar.errorString);
                }
            } else if (this.hHG != null) {
                this.hHG.x(bVar.hHB, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.hHB && bVar.hHC == 2) {
                Ff(bVar.hHD);
            }
            if (this.hHG != null) {
                this.hHG.na(bVar.hHB);
            }
        }
    }

    private void eg(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
        aVar.gX(false);
        aVar.gW(false);
        aVar.vO(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.dIF.getPageActivity());
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
        aVar.b(this.dIF);
        aVar.aST();
    }

    public void Ff(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
        aVar.gX(false);
        aVar.gW(false);
        aVar.vO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.dIF);
        aVar.aST();
    }
}
