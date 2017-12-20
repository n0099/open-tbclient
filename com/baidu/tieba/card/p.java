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
    private a cbA;
    private CardPersonDynamicThreadData cbB;
    private List<b.a> cbC;
    private b.a cbD;
    private b.a cbE;
    private b.a cbF;
    private SetPrivacyModel cbG;
    private ForumManageModel cbH;
    private SetPrivacyModel.a cbI = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.3
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.cbB.isPrivacy) {
                p.this.cbB.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.thread_has_open);
                if (p.this.cbD != null) {
                    p.this.cbD.setText(p.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (p.this.cbA != null) {
                    p.this.cbA.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.cbB.isPrivacy = true;
            if (p.this.cbD != null) {
                p.this.cbD.setText(p.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (p.this.cbA != null) {
                p.this.cbA.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.cbB.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private b.InterfaceC0156b cbJ = new b.InterfaceC0156b() { // from class: com.baidu.tieba.card.p.4
        @Override // com.baidu.tieba.view.b.InterfaceC0156b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gV()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cbB.isPrivacy) {
                if (p.this.cbB.from == 1) {
                    TiebaStatic.log(new ak("c12599").r("obj_type", 2));
                }
            } else if (p.this.cbB.from != 1) {
                if (p.this.cbB.from == 3) {
                    TiebaStatic.log(new ak("c12600").r("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ak("c12599").r("obj_type", 1));
            }
            if (p.this.cbG == null) {
                p.this.cbG = new SetPrivacyModel(p.this.mPageContext, p.this.cbB);
            }
            if (!p.this.cbG.isRunning()) {
                p.this.cbG.a(p.this.cbI);
                p.this.cbG.LoadData();
            }
            p.this.abR();
        }
    };
    private b.InterfaceC0156b cbK = new b.InterfaceC0156b() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.view.b.InterfaceC0156b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gV()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cbB != null && p.this.cbH != null) {
                p.this.abS();
                p.this.cbz.th();
            }
            p.this.abR();
        }
    };
    private com.baidu.adp.base.d cbL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (obj != null) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.delete_success);
            }
        }
    };
    private b.InterfaceC0156b cbM = new b.InterfaceC0156b() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.tieba.view.b.InterfaceC0156b
        public void onClick() {
            p.this.abR();
        }
    };
    private com.baidu.tieba.person.e cbx;
    private com.baidu.tieba.view.b cby;
    private com.baidu.tbadk.core.dialog.a cbz;
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
            this.cbC = new ArrayList();
            this.cby = new com.baidu.tieba.view.b(this.mContext);
            this.cbH = new ForumManageModel(this.mPageContext);
            this.cbH.setLoadDataCallBack(this.cbL);
        }
    }

    public void onChangeSkinType() {
        if (this.cby != null) {
            this.cby.onChangeSkinType();
        }
        if (this.cbz != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cbz.ti());
        }
    }

    public void create() {
        if (this.cbx == null) {
            this.cbD = new b.a(this.cby);
            this.cbD.a(this.cbJ);
            this.cbC.add(this.cbD);
            this.cbE = new b.a(this.mContext.getString(d.j.delete), this.cby);
            this.cbE.a(this.cbK);
            this.cbC.add(this.cbE);
            this.cbF = new b.a(this.mContext.getString(d.j.cancel), this.cby);
            this.cbF.a(this.cbM);
            this.cbC.add(this.cbF);
            this.cby.dT(this.cbC);
            this.cbx = new com.baidu.tieba.person.e(this.mContext, this.cby.bEI());
        }
    }

    public void a(a aVar) {
        this.cbA = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cbB = cardPersonDynamicThreadData;
        if (this.cbB != null && this.cbD != null) {
            if (this.cbB.isPrivacy) {
                this.cbD.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.cbD.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cbx != null) {
            this.cbx.show();
        }
    }

    public void abR() {
        if (this.cbx != null && this.cbx.isShowing()) {
            this.cbx.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abS() {
        if (this.cbz == null) {
            this.cbz = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cbz.cd(d.j.del_thread_confirm);
            this.cbz.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.gV()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                        return;
                    }
                    if (p.this.cbB.from != 1) {
                        if (p.this.cbB.from == 3) {
                            TiebaStatic.log(new ak("c12600").r("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ak("c12599").r("obj_type", 3));
                    }
                    p.this.cbH.a(p.this.cbB.forumId, p.this.cbB.forumName, p.this.cbB.threadId, p.this.cbB.postId, 0, 0, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.cbB.threadId));
                    aVar.dismiss();
                }
            });
            this.cbz.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cbz.ao(true);
            this.cbz.b(this.mPageContext);
        }
    }
}
