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
    private int fIp;
    private FrsProfessionPermissionModel fIt;
    private com.baidu.tieba.frs.profession.permission.a fIu = new com.baidu.tieba.frs.profession.permission.a();
    private a fIv;
    private TbPageContext<?> mContext;

    /* loaded from: classes.dex */
    public interface a {
        void jV(boolean z);

        void jW(boolean z);

        void n(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.fIt = new FrsProfessionPermissionModel(tbPageContext, this.fIu);
        this.fIt.a(this);
    }

    public void a(a aVar) {
        this.fIv = aVar;
    }

    public void si(int i) {
        this.fIp = i;
        this.fIu.fIp = i;
    }

    public void wT(String str) {
        this.fIu.fIo = 1;
        this.fIu.forum_id = str;
        loadData();
    }

    public void av(String str, int i) {
        this.fIu.fIn = i;
        this.fIu.forum_id = str;
        this.fIu.fIo = 2;
        loadData();
    }

    public void t(String str, long j) {
        this.fIu.forum_id = str;
        this.fIu.thread_id = j;
        this.fIu.fIo = 3;
        loadData();
    }

    private void loadData() {
        if (!this.fIt.pu()) {
            this.fIt.atv();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.fIp == this.fIp) {
                switch (aVar.fIo) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.fIn);
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
            if (aVar.fIp == this.fIp) {
                switch (aVar.fIo) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.fIn);
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
            if (!bVar.fIq) {
                if (bVar.fIr == 1) {
                    da(bVar.fIs, str);
                } else if (bVar.fIr == 3) {
                    wU(bVar.fIs);
                }
            }
            if (this.fIv != null) {
                this.fIv.jW(bVar.fIq);
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
            } else if (this.fIv != null) {
                this.fIv.n(bVar.fIq, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.fIq && bVar.fIr == 2) {
                wU(bVar.fIs);
            }
            if (this.fIv != null) {
                this.fIv.jV(bVar.fIq);
            }
        }
    }

    private void da(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.dN(false);
        aVar.dM(false);
        aVar.mE(str);
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
        aVar.afG();
    }

    public void wU(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.dN(false);
        aVar.dM(false);
        aVar.mE(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.mContext);
        aVar.afG();
    }
}
