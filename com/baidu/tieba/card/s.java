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
    private com.baidu.tieba.person.e anH;
    private com.baidu.tieba.view.a cZc;
    private com.baidu.tbadk.core.dialog.a cZd;
    private a cZe;
    private CardPersonDynamicThreadData cZf;
    private List<a.C0333a> cZg;
    private a.C0333a cZh;
    private a.C0333a cZi;
    private SetPrivacyModel cZj;
    private ForumManageModel cZk;
    private SetPrivacyModel.a cZl = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.cZf.isPrivacy) {
                s.this.cZf.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.thread_has_open);
                if (s.this.cZh != null) {
                    s.this.cZh.setText(s.this.mContext.getString(e.j.set_thread_privacy));
                }
                if (s.this.cZe != null) {
                    s.this.cZe.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.cZf.isPrivacy = true;
            if (s.this.cZh != null) {
                s.this.cZh.setText(s.this.mContext.getString(e.j.set_thread_public_open));
            }
            if (s.this.cZe != null) {
                s.this.cZe.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.cZf.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c cZm = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kK()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cZf.isPrivacy) {
                if (s.this.cZf.from == 1) {
                    TiebaStatic.log(new am("c12599").y("obj_type", 2));
                }
            } else if (s.this.cZf.from != 1) {
                if (s.this.cZf.from == 3) {
                    TiebaStatic.log(new am("c12600").y("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").y("obj_type", 1));
            }
            if (s.this.cZj == null) {
                s.this.cZj = new SetPrivacyModel(s.this.mPageContext, s.this.cZf);
            }
            if (!s.this.cZj.isRunning()) {
                s.this.cZj.a(s.this.cZl);
                s.this.cZj.LoadData();
            }
            s.this.aqK();
        }
    };
    private a.c cZn = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kK()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cZf != null && s.this.cZk != null) {
                s.this.aqL();
                s.this.cZd.BS();
            }
            s.this.aqK();
        }
    };
    private com.baidu.adp.base.d cZo = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.delete_success);
                    if (s.this.cZf != null && !ao.isEmpty(s.this.cZf.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.cZf.threadId));
                    }
                } else if (!ao.isEmpty(bVar.hsd)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.hsd);
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
            this.cZg = new ArrayList();
            this.cZc = new com.baidu.tieba.view.a(this.mContext);
            this.cZk = new ForumManageModel(this.mPageContext);
            this.cZk.setLoadDataCallBack(this.cZo);
        }
    }

    public void onChangeSkinType() {
        if (this.cZc != null) {
            this.cZc.onChangeSkinType();
        }
        if (this.cZd != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cZd.BT());
        }
    }

    public void create() {
        if (this.anH == null) {
            this.cZh = new a.C0333a(this.cZc);
            this.cZh.a(this.cZm);
            this.cZg.add(this.cZh);
            this.cZi = new a.C0333a(this.mContext.getString(e.j.delete), this.cZc);
            this.cZi.a(this.cZn);
            this.cZg.add(this.cZi);
            this.cZc.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.aqK();
                }
            });
            this.cZc.ef(this.cZg);
            this.anH = new com.baidu.tieba.person.e(this.mContext, this.cZc.bNw());
        }
    }

    public void a(a aVar) {
        this.cZe = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cZf = cardPersonDynamicThreadData;
        if (this.cZf != null && this.cZh != null) {
            if (this.cZf.isPrivacy) {
                this.cZh.setText(this.mContext.getString(e.j.set_thread_public_open));
            } else {
                this.cZh.setText(this.mContext.getString(e.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.anH != null) {
            this.anH.show();
        }
    }

    public void aqK() {
        if (this.anH != null && this.anH.isShowing()) {
            this.anH.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqL() {
        if (this.cZd == null) {
            this.cZd = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cZd.db(e.j.del_thread_confirm);
            this.cZd.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                        return;
                    }
                    if (s.this.cZf.from != 1) {
                        if (s.this.cZf.from == 3) {
                            TiebaStatic.log(new am("c12600").y("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").y("obj_type", 3));
                    }
                    s.this.cZk.a(s.this.cZf.forumId, s.this.cZf.forumName, s.this.cZf.threadId, s.this.cZf.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cZd.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cZd.bg(true);
            this.cZd.b(this.mPageContext);
        }
    }
}
