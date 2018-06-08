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
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class s {
    private com.baidu.tieba.person.e czh;
    private com.baidu.tieba.view.a czi;
    private com.baidu.tbadk.core.dialog.a czj;
    private a czk;
    private CardPersonDynamicThreadData czl;
    private List<a.C0249a> czm;
    private a.C0249a czn;
    private a.C0249a czo;
    private SetPrivacyModel czp;
    private ForumManageModel czq;
    private SetPrivacyModel.a czr = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.czl.isPrivacy) {
                s.this.czl.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.thread_has_open);
                if (s.this.czn != null) {
                    s.this.czn.setText(s.this.mContext.getString(d.k.set_thread_privacy));
                }
                if (s.this.czk != null) {
                    s.this.czk.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.czl.isPrivacy = true;
            if (s.this.czn != null) {
                s.this.czn.setText(s.this.mContext.getString(d.k.set_thread_public_open));
            }
            if (s.this.czk != null) {
                s.this.czk.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.czl.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c czs = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jr()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                return;
            }
            if (s.this.czl.isPrivacy) {
                if (s.this.czl.from == 1) {
                    TiebaStatic.log(new am("c12599").r("obj_type", 2));
                }
            } else if (s.this.czl.from != 1) {
                if (s.this.czl.from == 3) {
                    TiebaStatic.log(new am("c12600").r("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").r("obj_type", 1));
            }
            if (s.this.czp == null) {
                s.this.czp = new SetPrivacyModel(s.this.mPageContext, s.this.czl);
            }
            if (!s.this.czp.isRunning()) {
                s.this.czp.a(s.this.czr);
                s.this.czp.LoadData();
            }
            s.this.ajc();
        }
    };
    private a.c czt = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jr()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                return;
            }
            if (s.this.czl != null && s.this.czq != null) {
                s.this.ajd();
                s.this.czj.xa();
            }
            s.this.ajc();
        }
    };
    private com.baidu.adp.base.d czu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.delete_success);
                    if (s.this.czl != null && !ao.isEmpty(s.this.czl.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.czl.threadId));
                    }
                } else if (!ao.isEmpty(bVar.gLr)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.gLr);
                } else {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.delete_fail);
                }
            }
        }
    };
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
            this.czm = new ArrayList();
            this.czi = new com.baidu.tieba.view.a(this.mContext);
            this.czq = new ForumManageModel(this.mPageContext);
            this.czq.setLoadDataCallBack(this.czu);
        }
    }

    public void onChangeSkinType() {
        if (this.czi != null) {
            this.czi.onChangeSkinType();
        }
        if (this.czj != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.czj.xb());
        }
    }

    public void create() {
        if (this.czh == null) {
            this.czn = new a.C0249a(this.czi);
            this.czn.a(this.czs);
            this.czm.add(this.czn);
            this.czo = new a.C0249a(this.mContext.getString(d.k.delete), this.czi);
            this.czo.a(this.czt);
            this.czm.add(this.czo);
            this.czi.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.ajc();
                }
            });
            this.czi.dN(this.czm);
            this.czh = new com.baidu.tieba.person.e(this.mContext, this.czi.bFf());
        }
    }

    public void a(a aVar) {
        this.czk = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.czl = cardPersonDynamicThreadData;
        if (this.czl != null && this.czn != null) {
            if (this.czl.isPrivacy) {
                this.czn.setText(this.mContext.getString(d.k.set_thread_public_open));
            } else {
                this.czn.setText(this.mContext.getString(d.k.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.czh != null) {
            this.czh.show();
        }
    }

    public void ajc() {
        if (this.czh != null && this.czh.isShowing()) {
            this.czh.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajd() {
        if (this.czj == null) {
            this.czj = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.czj.cc(d.k.del_thread_confirm);
            this.czj.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.jr()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                        return;
                    }
                    if (s.this.czl.from != 1) {
                        if (s.this.czl.from == 3) {
                            TiebaStatic.log(new am("c12600").r("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").r("obj_type", 3));
                    }
                    s.this.czq.a(s.this.czl.forumId, s.this.czl.forumName, s.this.czl.threadId, s.this.czl.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.czj.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.czj.au(true);
            this.czj.b(this.mPageContext);
        }
    }
}
