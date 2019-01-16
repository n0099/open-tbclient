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
    private com.baidu.tieba.person.e anG;
    private com.baidu.tieba.view.a cZb;
    private com.baidu.tbadk.core.dialog.a cZc;
    private a cZd;
    private CardPersonDynamicThreadData cZe;
    private List<a.C0333a> cZf;
    private a.C0333a cZg;
    private a.C0333a cZh;
    private SetPrivacyModel cZi;
    private ForumManageModel cZj;
    private SetPrivacyModel.a cZk = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.cZe.isPrivacy) {
                s.this.cZe.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.thread_has_open);
                if (s.this.cZg != null) {
                    s.this.cZg.setText(s.this.mContext.getString(e.j.set_thread_privacy));
                }
                if (s.this.cZd != null) {
                    s.this.cZd.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.cZe.isPrivacy = true;
            if (s.this.cZg != null) {
                s.this.cZg.setText(s.this.mContext.getString(e.j.set_thread_public_open));
            }
            if (s.this.cZd != null) {
                s.this.cZd.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.cZe.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c cZl = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kK()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cZe.isPrivacy) {
                if (s.this.cZe.from == 1) {
                    TiebaStatic.log(new am("c12599").y("obj_type", 2));
                }
            } else if (s.this.cZe.from != 1) {
                if (s.this.cZe.from == 3) {
                    TiebaStatic.log(new am("c12600").y("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").y("obj_type", 1));
            }
            if (s.this.cZi == null) {
                s.this.cZi = new SetPrivacyModel(s.this.mPageContext, s.this.cZe);
            }
            if (!s.this.cZi.isRunning()) {
                s.this.cZi.a(s.this.cZk);
                s.this.cZi.LoadData();
            }
            s.this.aqK();
        }
    };
    private a.c cZm = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kK()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cZe != null && s.this.cZj != null) {
                s.this.aqL();
                s.this.cZc.BS();
            }
            s.this.aqK();
        }
    };
    private com.baidu.adp.base.d cZn = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.delete_success);
                    if (s.this.cZe != null && !ao.isEmpty(s.this.cZe.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.cZe.threadId));
                    }
                } else if (!ao.isEmpty(bVar.hsc)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.hsc);
                } else {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.delete_fail);
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
            this.cZf = new ArrayList();
            this.cZb = new com.baidu.tieba.view.a(this.mContext);
            this.cZj = new ForumManageModel(this.mPageContext);
            this.cZj.setLoadDataCallBack(this.cZn);
        }
    }

    public void onChangeSkinType() {
        if (this.cZb != null) {
            this.cZb.onChangeSkinType();
        }
        if (this.cZc != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cZc.BT());
        }
    }

    public void create() {
        if (this.anG == null) {
            this.cZg = new a.C0333a(this.cZb);
            this.cZg.a(this.cZl);
            this.cZf.add(this.cZg);
            this.cZh = new a.C0333a(this.mContext.getString(e.j.delete), this.cZb);
            this.cZh.a(this.cZm);
            this.cZf.add(this.cZh);
            this.cZb.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.aqK();
                }
            });
            this.cZb.ef(this.cZf);
            this.anG = new com.baidu.tieba.person.e(this.mContext, this.cZb.bNw());
        }
    }

    public void a(a aVar) {
        this.cZd = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cZe = cardPersonDynamicThreadData;
        if (this.cZe != null && this.cZg != null) {
            if (this.cZe.isPrivacy) {
                this.cZg.setText(this.mContext.getString(e.j.set_thread_public_open));
            } else {
                this.cZg.setText(this.mContext.getString(e.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.anG != null) {
            this.anG.show();
        }
    }

    public void aqK() {
        if (this.anG != null && this.anG.isShowing()) {
            this.anG.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqL() {
        if (this.cZc == null) {
            this.cZc = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cZc.db(e.j.del_thread_confirm);
            this.cZc.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                        return;
                    }
                    if (s.this.cZe.from != 1) {
                        if (s.this.cZe.from == 3) {
                            TiebaStatic.log(new am("c12600").y("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").y("obj_type", 3));
                    }
                    s.this.cZj.a(s.this.cZe.forumId, s.this.cZe.forumName, s.this.cZe.threadId, s.this.cZe.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cZc.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cZc.bg(true);
            this.cZc.b(this.mPageContext);
        }
    }
}
