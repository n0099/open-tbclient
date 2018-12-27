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
    private com.baidu.tieba.person.e ane;
    private com.baidu.tieba.view.a cYq;
    private com.baidu.tbadk.core.dialog.a cYr;
    private a cYs;
    private CardPersonDynamicThreadData cYt;
    private List<a.C0334a> cYu;
    private a.C0334a cYv;
    private a.C0334a cYw;
    private SetPrivacyModel cYx;
    private ForumManageModel cYy;
    private Context mContext;
    private TbPageContext mPageContext;
    private SetPrivacyModel.a cYz = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.cYt.isPrivacy) {
                s.this.cYt.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.thread_has_open);
                if (s.this.cYv != null) {
                    s.this.cYv.setText(s.this.mContext.getString(e.j.set_thread_privacy));
                }
                if (s.this.cYs != null) {
                    s.this.cYs.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.cYt.isPrivacy = true;
            if (s.this.cYv != null) {
                s.this.cYv.setText(s.this.mContext.getString(e.j.set_thread_public_open));
            }
            if (s.this.cYs != null) {
                s.this.cYs.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.cYt.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c cYA = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kK()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cYt.isPrivacy) {
                if (s.this.cYt.from == 1) {
                    TiebaStatic.log(new am("c12599").x("obj_type", 2));
                }
            } else if (s.this.cYt.from != 1) {
                if (s.this.cYt.from == 3) {
                    TiebaStatic.log(new am("c12600").x("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").x("obj_type", 1));
            }
            if (s.this.cYx == null) {
                s.this.cYx = new SetPrivacyModel(s.this.mPageContext, s.this.cYt);
            }
            if (!s.this.cYx.isRunning()) {
                s.this.cYx.a(s.this.cYz);
                s.this.cYx.LoadData();
            }
            s.this.aqn();
        }
    };
    private a.c cYB = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kK()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cYt != null && s.this.cYy != null) {
                s.this.aqo();
                s.this.cYr.BF();
            }
            s.this.aqn();
        }
    };
    private com.baidu.adp.base.d cYC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.delete_success);
                    if (s.this.cYt != null && !ao.isEmpty(s.this.cYt.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.cYt.threadId));
                    }
                } else if (!ao.isEmpty(bVar.hqU)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.hqU);
                } else {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public s(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.cYu = new ArrayList();
            this.cYq = new com.baidu.tieba.view.a(this.mContext);
            this.cYy = new ForumManageModel(this.mPageContext);
            this.cYy.setLoadDataCallBack(this.cYC);
        }
    }

    public void onChangeSkinType() {
        if (this.cYq != null) {
            this.cYq.onChangeSkinType();
        }
        if (this.cYr != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cYr.BG());
        }
    }

    public void create() {
        if (this.ane == null) {
            this.cYv = new a.C0334a(this.cYq);
            this.cYv.a(this.cYA);
            this.cYu.add(this.cYv);
            this.cYw = new a.C0334a(this.mContext.getString(e.j.delete), this.cYq);
            this.cYw.a(this.cYB);
            this.cYu.add(this.cYw);
            this.cYq.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.aqn();
                }
            });
            this.cYq.ee(this.cYu);
            this.ane = new com.baidu.tieba.person.e(this.mContext, this.cYq.bMO());
        }
    }

    public void a(a aVar) {
        this.cYs = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cYt = cardPersonDynamicThreadData;
        if (this.cYt != null && this.cYv != null) {
            if (this.cYt.isPrivacy) {
                this.cYv.setText(this.mContext.getString(e.j.set_thread_public_open));
            } else {
                this.cYv.setText(this.mContext.getString(e.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.ane != null) {
            this.ane.show();
        }
    }

    public void aqn() {
        if (this.ane != null && this.ane.isShowing()) {
            this.ane.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqo() {
        if (this.cYr == null) {
            this.cYr = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cYr.db(e.j.del_thread_confirm);
            this.cYr.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                        return;
                    }
                    if (s.this.cYt.from != 1) {
                        if (s.this.cYt.from == 3) {
                            TiebaStatic.log(new am("c12600").x("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").x("obj_type", 3));
                    }
                    s.this.cYy.a(s.this.cYt.forumId, s.this.cYt.forumName, s.this.cYt.threadId, s.this.cYt.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cYr.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cYr.bf(true);
            this.cYr.b(this.mPageContext);
        }
    }
}
