package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private com.baidu.tieba.person.e cUJ;
    private com.baidu.tieba.view.c cUK;
    private com.baidu.tbadk.core.dialog.a cUL;
    private a cUM;
    private CardPersonDynamicThreadData cUN;
    private List<c.a> cUO;
    private c.a cUP;
    private c.a cUQ;
    private SetPrivacyModel cUR;
    private ForumManageModel cUS;
    private SetPrivacyModel.a cUT = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.cUN.isPrivacy) {
                p.this.cUN.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.thread_has_open);
                if (p.this.cUP != null) {
                    p.this.cUP.setText(p.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (p.this.cUM != null) {
                    p.this.cUM.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.cUN.isPrivacy = true;
            if (p.this.cUP != null) {
                p.this.cUP.setText(p.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (p.this.cUM != null) {
                p.this.cUM.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.cUN.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private c.InterfaceC0167c cUU = new c.InterfaceC0167c() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.view.c.InterfaceC0167c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ow()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cUN.isPrivacy) {
                if (p.this.cUN.from == 1) {
                    TiebaStatic.log(new ak("c12599").s("obj_type", 2));
                }
            } else if (p.this.cUN.from != 1) {
                if (p.this.cUN.from == 3) {
                    TiebaStatic.log(new ak("c12600").s("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ak("c12599").s("obj_type", 1));
            }
            if (p.this.cUR == null) {
                p.this.cUR = new SetPrivacyModel(p.this.mPageContext, p.this.cUN);
            }
            if (!p.this.cUR.isRunning()) {
                p.this.cUR.a(p.this.cUT);
                p.this.cUR.LoadData();
            }
            p.this.akA();
        }
    };
    private c.InterfaceC0167c cUV = new c.InterfaceC0167c() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tieba.view.c.InterfaceC0167c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ow()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cUN != null && p.this.cUS != null) {
                p.this.akB();
                p.this.cUL.AA();
            }
            p.this.akA();
        }
    };
    private com.baidu.adp.base.d cUW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.delete_success);
                    if (p.this.cUN != null && !am.isEmpty(p.this.cUN.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.cUN.threadId));
                    }
                } else if (!am.isEmpty(bVar.haC)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.haC);
                } else {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.delete_fail);
                }
            }
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
            this.cUO = new ArrayList();
            this.cUK = new com.baidu.tieba.view.c(this.mContext);
            this.cUS = new ForumManageModel(this.mPageContext);
            this.cUS.setLoadDataCallBack(this.cUW);
        }
    }

    public void onChangeSkinType() {
        if (this.cUK != null) {
            this.cUK.onChangeSkinType();
        }
        if (this.cUL != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cUL.AB());
        }
    }

    public void create() {
        if (this.cUJ == null) {
            this.cUP = new c.a(this.cUK);
            this.cUP.a(this.cUU);
            this.cUO.add(this.cUP);
            this.cUQ = new c.a(this.mContext.getString(d.j.delete), this.cUK);
            this.cUQ.a(this.cUV);
            this.cUO.add(this.cUQ);
            this.cUK.a(new c.b() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tieba.view.c.b
                public void onClick() {
                    p.this.akA();
                }
            });
            this.cUK.dI(this.cUO);
            this.cUJ = new com.baidu.tieba.person.e(this.mContext, this.cUK.bDT());
        }
    }

    public void a(a aVar) {
        this.cUM = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cUN = cardPersonDynamicThreadData;
        if (this.cUN != null && this.cUP != null) {
            if (this.cUN.isPrivacy) {
                this.cUP.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.cUP.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cUJ != null) {
            this.cUJ.show();
        }
    }

    public void akA() {
        if (this.cUJ != null && this.cUJ.isShowing()) {
            this.cUJ.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akB() {
        if (this.cUL == null) {
            this.cUL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cUL.fb(d.j.del_thread_confirm);
            this.cUL.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.ow()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                        return;
                    }
                    if (p.this.cUN.from != 1) {
                        if (p.this.cUN.from == 3) {
                            TiebaStatic.log(new ak("c12600").s("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ak("c12599").s("obj_type", 3));
                    }
                    p.this.cUS.a(p.this.cUN.forumId, p.this.cUN.forumName, p.this.cUN.threadId, p.this.cUN.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cUL.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cUL.aV(true);
            this.cUL.b(this.mPageContext);
        }
    }
}
