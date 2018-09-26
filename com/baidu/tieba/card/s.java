package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.e;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class s {
    private com.baidu.tieba.person.e adS;
    private SetPrivacyModel cFA;
    private ForumManageModel cFB;
    private SetPrivacyModel.a cFC = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.cFw.isPrivacy) {
                s.this.cFw.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.thread_has_open);
                if (s.this.cFy != null) {
                    s.this.cFy.setText(s.this.mContext.getString(e.j.set_thread_privacy));
                }
                if (s.this.cFv != null) {
                    s.this.cFv.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.cFw.isPrivacy = true;
            if (s.this.cFy != null) {
                s.this.cFy.setText(s.this.mContext.getString(e.j.set_thread_public_open));
            }
            if (s.this.cFv != null) {
                s.this.cFv.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.cFw.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c cFD = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ky()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cFw.isPrivacy) {
                if (s.this.cFw.from == 1) {
                    TiebaStatic.log(new am("c12599").w("obj_type", 2));
                }
            } else if (s.this.cFw.from != 1) {
                if (s.this.cFw.from == 3) {
                    TiebaStatic.log(new am("c12600").w("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").w("obj_type", 1));
            }
            if (s.this.cFA == null) {
                s.this.cFA = new SetPrivacyModel(s.this.mPageContext, s.this.cFw);
            }
            if (!s.this.cFA.isRunning()) {
                s.this.cFA.a(s.this.cFC);
                s.this.cFA.LoadData();
            }
            s.this.akH();
        }
    };
    private a.c cFE = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ky()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cFw != null && s.this.cFB != null) {
                s.this.akI();
                s.this.cFu.yl();
            }
            s.this.akH();
        }
    };
    private com.baidu.adp.base.d cFF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void j(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.delete_success);
                    if (s.this.cFw != null && !ao.isEmpty(s.this.cFw.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.cFw.threadId));
                    }
                } else if (!ao.isEmpty(bVar.gXX)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.gXX);
                } else {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.delete_fail);
                }
            }
        }
    };
    private com.baidu.tieba.view.a cFt;
    private com.baidu.tbadk.core.dialog.a cFu;
    private a cFv;
    private CardPersonDynamicThreadData cFw;
    private List<a.C0257a> cFx;
    private a.C0257a cFy;
    private a.C0257a cFz;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public s(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.cFx = new ArrayList();
            this.cFt = new com.baidu.tieba.view.a(this.mContext);
            this.cFB = new ForumManageModel(this.mPageContext);
            this.cFB.setLoadDataCallBack(this.cFF);
        }
    }

    public void onChangeSkinType() {
        if (this.cFt != null) {
            this.cFt.onChangeSkinType();
        }
        if (this.cFu != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cFu.ym());
        }
    }

    public void create() {
        if (this.adS == null) {
            this.cFy = new a.C0257a(this.cFt);
            this.cFy.a(this.cFD);
            this.cFx.add(this.cFy);
            this.cFz = new a.C0257a(this.mContext.getString(e.j.delete), this.cFt);
            this.cFz.a(this.cFE);
            this.cFx.add(this.cFz);
            this.cFt.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.akH();
                }
            });
            this.cFt.dN(this.cFx);
            this.adS = new com.baidu.tieba.person.e(this.mContext, this.cFt.bHj());
        }
    }

    public void a(a aVar) {
        this.cFv = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cFw = cardPersonDynamicThreadData;
        if (this.cFw != null && this.cFy != null) {
            if (this.cFw.isPrivacy) {
                this.cFy.setText(this.mContext.getString(e.j.set_thread_public_open));
            } else {
                this.cFy.setText(this.mContext.getString(e.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.adS != null) {
            this.adS.show();
        }
    }

    public void akH() {
        if (this.adS != null && this.adS.isShowing()) {
            this.adS.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akI() {
        if (this.cFu == null) {
            this.cFu = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cFu.cp(e.j.del_thread_confirm);
            this.cFu.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.ky()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                        return;
                    }
                    if (s.this.cFw.from != 1) {
                        if (s.this.cFw.from == 3) {
                            TiebaStatic.log(new am("c12600").w("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").w("obj_type", 3));
                    }
                    s.this.cFB.a(s.this.cFw.forumId, s.this.cFw.forumName, s.this.cFw.threadId, s.this.cFw.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cFu.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cFu.aE(true);
            this.cFu.b(this.mPageContext);
        }
    }
}
