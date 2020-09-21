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
    private TbPageContext<?> ehG;
    private int ixd;
    private FrsProfessionPermissionModel ixh;
    private com.baidu.tieba.frs.profession.permission.a ixi = new com.baidu.tieba.frs.profession.permission.a();
    private a ixj;

    /* loaded from: classes.dex */
    public interface a {
        void oC(boolean z);

        void oD(boolean z);

        void z(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.ehG = tbPageContext;
        this.ixh = new FrsProfessionPermissionModel(tbPageContext, this.ixi);
        this.ixh.a(this);
    }

    public void a(a aVar) {
        this.ixj = aVar;
    }

    public void yQ(int i) {
        this.ixd = i;
        this.ixi.ixd = i;
    }

    public void Js(String str) {
        this.ixi.ixc = 1;
        this.ixi.forum_id = str;
        loadData();
    }

    public void aN(String str, int i) {
        this.ixi.ixb = i;
        this.ixi.forum_id = str;
        this.ixi.ixc = 2;
        loadData();
    }

    public void D(String str, long j) {
        this.ixi.forum_id = str;
        this.ixi.thread_id = j;
        this.ixi.ixc = 3;
        loadData();
    }

    private void loadData() {
        if (!this.ixh.isLoading()) {
            this.ixh.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.ixd == this.ixd) {
                switch (aVar.ixc) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.ixb);
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
            if (aVar.ixd == this.ixd) {
                switch (aVar.ixc) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.ixb);
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
                    this.ehG.showToast(R.string.neterror);
                    return;
                } else {
                    this.ehG.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.ixe) {
                if (bVar.ixf == 1) {
                    eK(bVar.ixg, str);
                } else if (bVar.ixf == 3) {
                    Jt(bVar.ixg);
                }
            }
            if (this.ixj != null) {
                this.ixj.oD(bVar.ixe);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.ehG.showToast(R.string.neterror);
                } else {
                    this.ehG.showToast(bVar.errorString);
                }
            } else if (this.ixj != null) {
                this.ixj.z(bVar.ixe, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.ixe && bVar.ixf == 2) {
                Jt(bVar.ixg);
            }
            if (this.ixj != null) {
                this.ixj.oC(bVar.ixe);
            }
        }
    }

    private void eK(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
        aVar.ie(false);
        aVar.id(false);
        aVar.zV(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.ehG.getPageActivity());
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
        aVar.b(this.ehG);
        aVar.bia();
    }

    public void Jt(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
        aVar.ie(false);
        aVar.id(false);
        aVar.zV(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.ehG);
        aVar.bia();
    }
}
