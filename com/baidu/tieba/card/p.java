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
    private b.a cbA;
    private b.a cbB;
    private SetPrivacyModel cbC;
    private ForumManageModel cbD;
    private SetPrivacyModel.a cbE = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.3
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.cbx.isPrivacy) {
                p.this.cbx.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.thread_has_open);
                if (p.this.cbz != null) {
                    p.this.cbz.setText(p.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (p.this.cbw != null) {
                    p.this.cbw.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.cbx.isPrivacy = true;
            if (p.this.cbz != null) {
                p.this.cbz.setText(p.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (p.this.cbw != null) {
                p.this.cbw.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.cbx.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private b.InterfaceC0139b cbF = new b.InterfaceC0139b() { // from class: com.baidu.tieba.card.p.4
        @Override // com.baidu.tieba.view.b.InterfaceC0139b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gV()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cbx.isPrivacy) {
                if (p.this.cbx.from == 1) {
                    TiebaStatic.log(new ak("c12599").r("obj_type", 2));
                }
            } else if (p.this.cbx.from != 1) {
                if (p.this.cbx.from == 3) {
                    TiebaStatic.log(new ak("c12600").r("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ak("c12599").r("obj_type", 1));
            }
            if (p.this.cbC == null) {
                p.this.cbC = new SetPrivacyModel(p.this.mPageContext, p.this.cbx);
            }
            if (!p.this.cbC.isRunning()) {
                p.this.cbC.a(p.this.cbE);
                p.this.cbC.LoadData();
            }
            p.this.abP();
        }
    };
    private b.InterfaceC0139b cbG = new b.InterfaceC0139b() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.view.b.InterfaceC0139b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gV()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cbx != null && p.this.cbD != null) {
                p.this.abQ();
                p.this.cbv.tk();
            }
            p.this.abP();
        }
    };
    private com.baidu.adp.base.d cbH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (obj != null) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.delete_success);
            }
        }
    };
    private b.InterfaceC0139b cbI = new b.InterfaceC0139b() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.tieba.view.b.InterfaceC0139b
        public void onClick() {
            p.this.abP();
        }
    };
    private com.baidu.tieba.person.e cbt;
    private com.baidu.tieba.view.b cbu;
    private com.baidu.tbadk.core.dialog.a cbv;
    private a cbw;
    private CardPersonDynamicThreadData cbx;
    private List<b.a> cby;
    private b.a cbz;
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
            this.cby = new ArrayList();
            this.cbu = new com.baidu.tieba.view.b(this.mContext);
            this.cbD = new ForumManageModel(this.mPageContext);
            this.cbD.setLoadDataCallBack(this.cbH);
        }
    }

    public void onChangeSkinType() {
        if (this.cbu != null) {
            this.cbu.onChangeSkinType();
        }
        if (this.cbv != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cbv.tl());
        }
    }

    public void create() {
        if (this.cbt == null) {
            this.cbz = new b.a(this.cbu);
            this.cbz.a(this.cbF);
            this.cby.add(this.cbz);
            this.cbA = new b.a(this.mContext.getString(d.j.delete), this.cbu);
            this.cbA.a(this.cbG);
            this.cby.add(this.cbA);
            this.cbB = new b.a(this.mContext.getString(d.j.cancel), this.cbu);
            this.cbB.a(this.cbI);
            this.cby.add(this.cbB);
            this.cbu.dU(this.cby);
            this.cbt = new com.baidu.tieba.person.e(this.mContext, this.cbu.bDZ());
        }
    }

    public void a(a aVar) {
        this.cbw = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cbx = cardPersonDynamicThreadData;
        if (this.cbx != null && this.cbz != null) {
            if (this.cbx.isPrivacy) {
                this.cbz.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.cbz.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cbt != null) {
            this.cbt.show();
        }
    }

    public void abP() {
        if (this.cbt != null && this.cbt.isShowing()) {
            this.cbt.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abQ() {
        if (this.cbv == null) {
            this.cbv = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cbv.cd(d.j.del_thread_confirm);
            this.cbv.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.gV()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                        return;
                    }
                    if (p.this.cbx.from != 1) {
                        if (p.this.cbx.from == 3) {
                            TiebaStatic.log(new ak("c12600").r("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ak("c12599").r("obj_type", 3));
                    }
                    p.this.cbD.a(p.this.cbx.forumId, p.this.cbx.forumName, p.this.cbx.threadId, p.this.cbx.postId, 0, 0, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.cbx.threadId));
                    aVar.dismiss();
                }
            });
            this.cbv.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cbv.ao(true);
            this.cbv.b(this.mPageContext);
        }
    }
}
