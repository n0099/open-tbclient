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
/* loaded from: classes2.dex */
public class c implements NetModel.b {
    private TbPageContext<?> efn;
    private int ipH;
    private FrsProfessionPermissionModel ipL;
    private com.baidu.tieba.frs.profession.permission.a ipM = new com.baidu.tieba.frs.profession.permission.a();
    private a ipN;

    /* loaded from: classes2.dex */
    public interface a {
        void ou(boolean z);

        void ov(boolean z);

        void z(boolean z, int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.efn = tbPageContext;
        this.ipL = new FrsProfessionPermissionModel(tbPageContext, this.ipM);
        this.ipL.a(this);
    }

    public void a(a aVar) {
        this.ipN = aVar;
    }

    public void yr(int i) {
        this.ipH = i;
        this.ipM.ipH = i;
    }

    public void IT(String str) {
        this.ipM.ipG = 1;
        this.ipM.forum_id = str;
        loadData();
    }

    public void aN(String str, int i) {
        this.ipM.ipF = i;
        this.ipM.forum_id = str;
        this.ipM.ipG = 2;
        loadData();
    }

    public void C(String str, long j) {
        this.ipM.forum_id = str;
        this.ipM.thread_id = j;
        this.ipM.ipG = 3;
        loadData();
    }

    private void loadData() {
        if (!this.ipL.isLoading()) {
            this.ipL.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.ipH == this.ipH) {
                switch (aVar.ipG) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.ipF);
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
            if (aVar.ipH == this.ipH) {
                switch (aVar.ipG) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.ipF);
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
                    this.efn.showToast(R.string.neterror);
                    return;
                } else {
                    this.efn.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.ipI) {
                if (bVar.ipJ == 1) {
                    eF(bVar.ipK, str);
                } else if (bVar.ipJ == 3) {
                    IU(bVar.ipK);
                }
            }
            if (this.ipN != null) {
                this.ipN.ov(bVar.ipI);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.efn.showToast(R.string.neterror);
                } else {
                    this.efn.showToast(bVar.errorString);
                }
            } else if (this.ipN != null) {
                this.ipN.z(bVar.ipI, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.ipI && bVar.ipJ == 2) {
                IU(bVar.ipK);
            }
            if (this.ipN != null) {
                this.ipN.ou(bVar.ipI);
            }
        }
    }

    private void eF(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efn.getPageActivity());
        aVar.ig(false);
        aVar.m39if(false);
        aVar.zz(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.efn.getPageActivity());
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
        aVar.b(this.efn);
        aVar.bhg();
    }

    public void IU(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efn.getPageActivity());
        aVar.ig(false);
        aVar.m39if(false);
        aVar.zz(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.efn);
        aVar.bhg();
    }
}
