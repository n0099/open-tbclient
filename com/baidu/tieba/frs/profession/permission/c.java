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
    private TbPageContext<?> eGu;
    private int jfc;
    private FrsProfessionPermissionModel jfg;
    private com.baidu.tieba.frs.profession.permission.a jfh = new com.baidu.tieba.frs.profession.permission.a();
    private a jfi;

    /* loaded from: classes.dex */
    public interface a {
        void C(boolean z, int i);

        void pL(boolean z);

        void pM(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.eGu = tbPageContext;
        this.jfg = new FrsProfessionPermissionModel(tbPageContext, this.jfh);
        this.jfg.a(this);
    }

    public void a(a aVar) {
        this.jfi = aVar;
    }

    public void AA(int i) {
        this.jfc = i;
        this.jfh.jfc = i;
    }

    public void Kw(String str) {
        this.jfh.jfb = 1;
        this.jfh.forum_id = str;
        loadData();
    }

    public void aQ(String str, int i) {
        this.jfh.jfa = i;
        this.jfh.forum_id = str;
        this.jfh.jfb = 2;
        loadData();
    }

    public void G(String str, long j) {
        this.jfh.forum_id = str;
        this.jfh.thread_id = j;
        this.jfh.jfb = 3;
        loadData();
    }

    private void loadData() {
        if (!this.jfg.isLoading()) {
            this.jfg.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.jfc == this.jfc) {
                switch (aVar.jfb) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jfa);
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
            if (aVar.jfc == this.jfc) {
                switch (aVar.jfb) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jfa);
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
                    this.eGu.showToast(R.string.neterror);
                    return;
                } else {
                    this.eGu.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.jfd) {
                if (bVar.jfe == 1) {
                    eW(bVar.jff, str);
                } else if (bVar.jfe == 3) {
                    Kx(bVar.jff);
                }
            }
            if (this.jfi != null) {
                this.jfi.pM(bVar.jfd);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.eGu.showToast(R.string.neterror);
                } else {
                    this.eGu.showToast(bVar.errorString);
                }
            } else if (this.jfi != null) {
                this.jfi.C(bVar.jfd, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.jfd && bVar.jfe == 2) {
                Kx(bVar.jff);
            }
            if (this.jfi != null) {
                this.jfi.pL(bVar.jfd);
            }
        }
    }

    private void eW(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
        aVar.iX(false);
        aVar.iW(false);
        aVar.AJ(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.eGu.getPageActivity());
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
        aVar.b(this.eGu);
        aVar.bog();
    }

    public void Kx(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
        aVar.iX(false);
        aVar.iW(false);
        aVar.AJ(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.eGu);
        aVar.bog();
    }
}
