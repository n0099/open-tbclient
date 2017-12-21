package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private com.baidu.tieba.person.e cbB;
    private com.baidu.tieba.view.b cbC;
    private com.baidu.tbadk.core.dialog.a cbD;
    private a cbE;
    private CardPersonDynamicThreadData cbF;
    private List<b.a> cbG;
    private b.a cbH;
    private b.a cbI;
    private b.a cbJ;
    private SetPrivacyModel cbK;
    private ForumManageModel cbL;
    private SetPrivacyModel.a cbM = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.3
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.cbF.isPrivacy) {
                p.this.cbF.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.thread_has_open);
                if (p.this.cbH != null) {
                    p.this.cbH.setText(p.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (p.this.cbE != null) {
                    p.this.cbE.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.cbF.isPrivacy = true;
            if (p.this.cbH != null) {
                p.this.cbH.setText(p.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (p.this.cbE != null) {
                p.this.cbE.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.cbF.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private b.InterfaceC0155b cbN = new b.InterfaceC0155b() { // from class: com.baidu.tieba.card.p.4
        @Override // com.baidu.tieba.view.b.InterfaceC0155b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gV()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cbF.isPrivacy) {
                if (p.this.cbF.from == 1) {
                    TiebaStatic.log(new ak("c12599").r("obj_type", 2));
                }
            } else if (p.this.cbF.from != 1) {
                if (p.this.cbF.from == 3) {
                    TiebaStatic.log(new ak("c12600").r("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ak("c12599").r("obj_type", 1));
            }
            if (p.this.cbK == null) {
                p.this.cbK = new SetPrivacyModel(p.this.mPageContext, p.this.cbF);
            }
            if (!p.this.cbK.isRunning()) {
                p.this.cbK.a(p.this.cbM);
                p.this.cbK.LoadData();
            }
            p.this.abR();
        }
    };
    private b.InterfaceC0155b cbO = new b.InterfaceC0155b() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.view.b.InterfaceC0155b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gV()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cbF != null && p.this.cbL != null) {
                p.this.abS();
                p.this.cbD.th();
            }
            p.this.abR();
        }
    };
    private com.baidu.adp.base.d cbP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (obj != null) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.delete_success);
            }
        }
    };
    private b.InterfaceC0155b cbQ = new b.InterfaceC0155b() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.tieba.view.b.InterfaceC0155b
        public void onClick() {
            p.this.abR();
        }
    };
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public p(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.cbG = new ArrayList();
            this.cbC = new com.baidu.tieba.view.b(this.mContext);
            this.cbL = new ForumManageModel(this.mPageContext);
            this.cbL.setLoadDataCallBack(this.cbP);
        }
    }

    public void onChangeSkinType() {
        if (this.cbC != null) {
            this.cbC.onChangeSkinType();
        }
        if (this.cbD != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cbD.ti());
        }
    }

    public void create() {
        if (this.cbB == null) {
            this.cbH = new b.a(this.cbC);
            this.cbH.a(this.cbN);
            this.cbG.add(this.cbH);
            this.cbI = new b.a(this.mContext.getString(d.j.delete), this.cbC);
            this.cbI.a(this.cbO);
            this.cbG.add(this.cbI);
            this.cbJ = new b.a(this.mContext.getString(d.j.cancel), this.cbC);
            this.cbJ.a(this.cbQ);
            this.cbG.add(this.cbJ);
            this.cbC.dT(this.cbG);
            this.cbB = new com.baidu.tieba.person.e(this.mContext, this.cbC.bEJ());
        }
    }

    public void a(a aVar) {
        this.cbE = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cbF = cardPersonDynamicThreadData;
        if (this.cbF != null && this.cbH != null) {
            if (this.cbF.isPrivacy) {
                this.cbH.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.cbH.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cbB != null) {
            this.cbB.show();
        }
    }

    public void abR() {
        if (this.cbB != null && this.cbB.isShowing()) {
            this.cbB.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abS() {
        if (this.cbD == null) {
            this.cbD = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cbD.cd(d.j.del_thread_confirm);
            this.cbD.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.gV()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                        return;
                    }
                    if (p.this.cbF.from != 1) {
                        if (p.this.cbF.from == 3) {
                            TiebaStatic.log(new ak("c12600").r("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ak("c12599").r("obj_type", 3));
                    }
                    p.this.cbL.a(p.this.cbF.forumId, p.this.cbF.forumName, p.this.cbF.threadId, p.this.cbF.postId, 0, 0, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.cbF.threadId));
                    aVar.dismiss();
                }
            });
            this.cbD.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cbD.ao(true);
            this.cbD.b(this.mPageContext);
        }
    }
}
