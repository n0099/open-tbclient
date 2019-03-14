package com.baidu.tieba.frs.profession.permission;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements NetModel.b {
    private int fsh;
    private FrsProfessionPermissionModel fsl;
    private com.baidu.tieba.frs.profession.permission.a fsm = new com.baidu.tieba.frs.profession.permission.a();
    private a fsn;
    private TbPageContext<?> mContext;

    /* loaded from: classes.dex */
    public interface a {
        void jl(boolean z);

        void jm(boolean z);

        void n(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.fsl = new FrsProfessionPermissionModel(tbPageContext, this.fsm);
        this.fsl.a(this);
    }

    public void a(a aVar) {
        this.fsn = aVar;
    }

    public void re(int i) {
        this.fsh = i;
        this.fsm.fsh = i;
    }

    public void vB(String str) {
        this.fsm.fsg = 1;
        this.fsm.forum_id = str;
        loadData();
    }

    public void az(String str, int i) {
        this.fsm.fsf = i;
        this.fsm.forum_id = str;
        this.fsm.fsg = 2;
        loadData();
    }

    public void q(String str, long j) {
        this.fsm.forum_id = str;
        this.fsm.thread_id = j;
        this.fsm.fsg = 3;
        loadData();
    }

    private void loadData() {
        if (!this.fsl.qz()) {
            this.fsl.aou();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.fsh == this.fsh) {
                switch (aVar.fsg) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.fsf);
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
            if (aVar.fsh == this.fsh) {
                switch (aVar.fsg) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.fsf);
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
                    this.mContext.showToast(d.j.neterror);
                    return;
                } else {
                    this.mContext.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.fsi) {
                if (bVar.fsj == 1) {
                    cM(bVar.fsk, str);
                } else if (bVar.fsj == 3) {
                    vC(bVar.fsk);
                }
            }
            if (this.fsn != null) {
                this.fsn.jm(bVar.fsi);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.mContext.showToast(d.j.neterror);
                } else {
                    this.mContext.showToast(bVar.errorString);
                }
            } else if (this.fsn != null) {
                this.fsn.n(bVar.fsi, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.fsi && bVar.fsj == 2) {
                vC(bVar.fsk);
            }
            if (this.fsn != null) {
                this.fsn.jl(bVar.fsi);
            }
        }
    }

    private void cM(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.dr(false);
        aVar.dq(false);
        aVar.ly(str);
        aVar.a(d.j.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.mContext.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + str2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                aVar.dismiss();
            }
        });
        aVar.b(d.j.comfirm_cancel, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.mContext);
        aVar.aaZ();
    }

    public void vC(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.dr(false);
        aVar.dq(false);
        aVar.ly(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.mContext);
        aVar.aaZ();
    }
}
