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
    private TbPageContext<?> eWx;
    private int jHX;
    private FrsProfessionPermissionModel jIb;
    private com.baidu.tieba.frs.profession.permission.a jIc = new com.baidu.tieba.frs.profession.permission.a();
    private a jId;

    /* loaded from: classes.dex */
    public interface a {
        void B(boolean z, int i);

        void qM(boolean z);

        void qN(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.eWx = tbPageContext;
        this.jIb = new FrsProfessionPermissionModel(tbPageContext, this.jIc);
        this.jIb.a(this);
    }

    public void a(a aVar) {
        this.jId = aVar;
    }

    public void Af(int i) {
        this.jHX = i;
        this.jIc.jHX = i;
    }

    public void Ln(String str) {
        this.jIc.jHW = 1;
        this.jIc.forum_id = str;
        loadData();
    }

    public void ba(String str, int i) {
        this.jIc.jHV = i;
        this.jIc.forum_id = str;
        this.jIc.jHW = 2;
        loadData();
    }

    public void G(String str, long j) {
        this.jIc.forum_id = str;
        this.jIc.thread_id = j;
        this.jIc.jHW = 3;
        loadData();
    }

    private void loadData() {
        if (!this.jIb.isLoading()) {
            this.jIb.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.jHX == this.jHX) {
                switch (aVar.jHW) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jHV);
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
            if (aVar.jHX == this.jHX) {
                switch (aVar.jHW) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jHV);
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
                    this.eWx.showToast(R.string.neterror);
                    return;
                } else {
                    this.eWx.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.jHY) {
                if (bVar.jHZ == 1) {
                    fc(bVar.jIa, str);
                } else if (bVar.jHZ == 3) {
                    Lo(bVar.jIa);
                }
            }
            if (this.jId != null) {
                this.jId.qN(bVar.jHY);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.eWx.showToast(R.string.neterror);
                } else {
                    this.eWx.showToast(bVar.errorString);
                }
            } else if (this.jId != null) {
                this.jId.B(bVar.jHY, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.jHY && bVar.jHZ == 2) {
                Lo(bVar.jIa);
            }
            if (this.jId != null) {
                this.jId.qM(bVar.jHY);
            }
        }
    }

    private void fc(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
        aVar.jG(false);
        aVar.jF(false);
        aVar.AB(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.eWx.getPageActivity());
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
        aVar.b(this.eWx);
        aVar.bqz();
    }

    public void Lo(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
        aVar.jG(false);
        aVar.jF(false);
        aVar.AB(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.eWx);
        aVar.bqz();
    }
}
