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
    private TbPageContext<?> etO;
    private int iLW;
    private FrsProfessionPermissionModel iMa;
    private com.baidu.tieba.frs.profession.permission.a iMb = new com.baidu.tieba.frs.profession.permission.a();
    private a iMc;

    /* loaded from: classes.dex */
    public interface a {
        void C(boolean z, int i);

        void ph(boolean z);

        void pi(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.etO = tbPageContext;
        this.iMa = new FrsProfessionPermissionModel(tbPageContext, this.iMb);
        this.iMa.a(this);
    }

    public void a(a aVar) {
        this.iMc = aVar;
    }

    public void zw(int i) {
        this.iLW = i;
        this.iMb.iLW = i;
    }

    public void Kf(String str) {
        this.iMb.iLV = 1;
        this.iMb.forum_id = str;
        loadData();
    }

    public void aO(String str, int i) {
        this.iMb.iLU = i;
        this.iMb.forum_id = str;
        this.iMb.iLV = 2;
        loadData();
    }

    public void D(String str, long j) {
        this.iMb.forum_id = str;
        this.iMb.thread_id = j;
        this.iMb.iLV = 3;
        loadData();
    }

    private void loadData() {
        if (!this.iMa.isLoading()) {
            this.iMa.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.iLW == this.iLW) {
                switch (aVar.iLV) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.iLU);
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
            if (aVar.iLW == this.iLW) {
                switch (aVar.iLV) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.iLU);
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
                    this.etO.showToast(R.string.neterror);
                    return;
                } else {
                    this.etO.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.iLX) {
                if (bVar.iLY == 1) {
                    eR(bVar.iLZ, str);
                } else if (bVar.iLY == 3) {
                    Kg(bVar.iLZ);
                }
            }
            if (this.iMc != null) {
                this.iMc.pi(bVar.iLX);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.etO.showToast(R.string.neterror);
                } else {
                    this.etO.showToast(bVar.errorString);
                }
            } else if (this.iMc != null) {
                this.iMc.C(bVar.iLX, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.iLX && bVar.iLY == 2) {
                Kg(bVar.iLZ);
            }
            if (this.iMc != null) {
                this.iMc.ph(bVar.iLX);
            }
        }
    }

    private void eR(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
        aVar.iA(false);
        aVar.iz(false);
        aVar.AH(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.etO.getPageActivity());
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
        aVar.b(this.etO);
        aVar.bkJ();
    }

    public void Kg(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
        aVar.iA(false);
        aVar.iz(false);
        aVar.AH(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.etO);
        aVar.bkJ();
    }
}
