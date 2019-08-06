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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c implements NetModel.b {
    private int fOd;
    private FrsProfessionPermissionModel fOh;
    private com.baidu.tieba.frs.profession.permission.a fOi = new com.baidu.tieba.frs.profession.permission.a();
    private a fOj;
    private TbPageContext<?> mContext;

    /* loaded from: classes.dex */
    public interface a {
        void kf(boolean z);

        void kg(boolean z);

        void n(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.fOh = new FrsProfessionPermissionModel(tbPageContext, this.fOi);
        this.fOh.a(this);
    }

    public void a(a aVar) {
        this.fOj = aVar;
    }

    public void sC(int i) {
        this.fOd = i;
        this.fOi.fOd = i;
    }

    public void xB(String str) {
        this.fOi.fOc = 1;
        this.fOi.forum_id = str;
        loadData();
    }

    public void aw(String str, int i) {
        this.fOi.fOb = i;
        this.fOi.forum_id = str;
        this.fOi.fOc = 2;
        loadData();
    }

    public void t(String str, long j) {
        this.fOi.forum_id = str;
        this.fOi.thread_id = j;
        this.fOi.fOc = 3;
        loadData();
    }

    private void loadData() {
        if (!this.fOh.pP()) {
            this.fOh.auF();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.fOd == this.fOd) {
                switch (aVar.fOc) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.fOb);
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
            if (aVar.fOd == this.fOd) {
                switch (aVar.fOc) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.fOb);
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
                    this.mContext.showToast((int) R.string.neterror);
                    return;
                } else {
                    this.mContext.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.fOe) {
                if (bVar.fOf == 1) {
                    db(bVar.fOg, str);
                } else if (bVar.fOf == 3) {
                    xC(bVar.fOg);
                }
            }
            if (this.fOj != null) {
                this.fOj.kg(bVar.fOe);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.mContext.showToast((int) R.string.neterror);
                } else {
                    this.mContext.showToast(bVar.errorString);
                }
            } else if (this.fOj != null) {
                this.fOj.n(bVar.fOe, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.fOe && bVar.fOf == 2) {
                xC(bVar.fOg);
            }
            if (this.fOj != null) {
                this.fOj.kf(bVar.fOe);
            }
        }
    }

    private void db(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.dR(false);
        aVar.dQ(false);
        aVar.mO(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.mContext.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + str2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                aVar.dismiss();
            }
        });
        aVar.b(R.string.comfirm_cancel, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.mContext);
        aVar.agK();
    }

    public void xC(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.dR(false);
        aVar.dQ(false);
        aVar.mO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.mContext);
        aVar.agK();
    }
}
