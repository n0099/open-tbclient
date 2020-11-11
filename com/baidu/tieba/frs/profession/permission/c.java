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
    private TbPageContext<?> eIc;
    private int jep;
    private FrsProfessionPermissionModel jet;
    private com.baidu.tieba.frs.profession.permission.a jeu = new com.baidu.tieba.frs.profession.permission.a();
    private a jev;

    /* loaded from: classes.dex */
    public interface a {
        void C(boolean z, int i);

        void pI(boolean z);

        void pJ(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.eIc = tbPageContext;
        this.jet = new FrsProfessionPermissionModel(tbPageContext, this.jeu);
        this.jet.a(this);
    }

    public void a(a aVar) {
        this.jev = aVar;
    }

    public void Ac(int i) {
        this.jep = i;
        this.jeu.jep = i;
    }

    public void KV(String str) {
        this.jeu.jeo = 1;
        this.jeu.forum_id = str;
        loadData();
    }

    public void aR(String str, int i) {
        this.jeu.jen = i;
        this.jeu.forum_id = str;
        this.jeu.jeo = 2;
        loadData();
    }

    public void G(String str, long j) {
        this.jeu.forum_id = str;
        this.jeu.thread_id = j;
        this.jeu.jeo = 3;
        loadData();
    }

    private void loadData() {
        if (!this.jet.isLoading()) {
            this.jet.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.frs.profession.permission.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b)) {
            com.baidu.tieba.frs.profession.permission.a aVar = (com.baidu.tieba.frs.profession.permission.a) mvcNetMessage.getRequestData();
            b bVar = (b) mvcHttpResponsedMessage.getData();
            if (aVar.jep == this.jep) {
                switch (aVar.jeo) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jen);
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
            if (aVar.jep == this.jep) {
                switch (aVar.jeo) {
                    case 1:
                        a(bVar);
                        return;
                    case 2:
                        a(bVar, aVar.jen);
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
                    this.eIc.showToast(R.string.neterror);
                    return;
                } else {
                    this.eIc.showToast(bVar.errorString);
                    return;
                }
            }
            if (!bVar.jeq) {
                if (bVar.jer == 1) {
                    eW(bVar.jes, str);
                } else if (bVar.jer == 3) {
                    KW(bVar.jes);
                }
            }
            if (this.jev != null) {
                this.jev.pJ(bVar.jeq);
            }
        }
    }

    private void a(b bVar, int i) {
        if (bVar != null) {
            if (bVar.errorCode != 0) {
                if (StringUtils.isNull(bVar.errorString)) {
                    this.eIc.showToast(R.string.neterror);
                } else {
                    this.eIc.showToast(bVar.errorString);
                }
            } else if (this.jev != null) {
                this.jev.C(bVar.jeq, i);
            }
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.errorCode == 0) {
            if (!bVar.jeq && bVar.jer == 2) {
                KW(bVar.jes);
            }
            if (this.jev != null) {
                this.jev.pI(bVar.jeq);
            }
        }
    }

    private void eW(String str, final String str2) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
        aVar.iW(false);
        aVar.iV(false);
        aVar.Bo(str);
        aVar.a(R.string.comfirm_imediate, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.eIc.getPageActivity());
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
        aVar.b(this.eIc);
        aVar.bpc();
    }

    public void KW(String str) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
        aVar.iW(false);
        aVar.iV(false);
        aVar.Bo(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.profession.permission.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.eIc);
        aVar.bpc();
    }
}
