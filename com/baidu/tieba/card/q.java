package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class q {
    private com.baidu.tbadk.core.dialog.i eFc;
    private com.baidu.tbadk.core.dialog.k eFd;
    private com.baidu.tbadk.core.dialog.a eFe;
    private a eFf;
    private CardPersonDynamicThreadData eFg;
    private List<com.baidu.tbadk.core.dialog.g> eFh;
    private com.baidu.tbadk.core.dialog.g eFi;
    private com.baidu.tbadk.core.dialog.g eFj;
    private SetPrivacyModel eFk;
    private ForumManageModel eFl;
    private SetPrivacyModel.a eFm = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.eFg.isPrivacy) {
                q.this.eFg.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.thread_has_open);
                if (q.this.eFi != null) {
                    q.this.eFi.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.eFf != null) {
                    q.this.eFf.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.eFg.isPrivacy = true;
            if (q.this.eFi != null) {
                q.this.eFi.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.eFf != null) {
                q.this.eFf.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.eFg.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b eFn = new k.b() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jQ()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eFg.isPrivacy) {
                if (q.this.eFg.from == 1) {
                    TiebaStatic.log(new an("c12599").P("obj_type", 2));
                }
            } else if (q.this.eFg.from != 1) {
                if (q.this.eFg.from == 3) {
                    TiebaStatic.log(new an("c12600").P("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").P("obj_type", 1));
            }
            if (q.this.eFk == null) {
                q.this.eFk = new SetPrivacyModel(q.this.mPageContext, q.this.eFg);
            }
            if (!q.this.eFk.isRunning()) {
                q.this.eFk.a(q.this.eFm);
                q.this.eFk.LoadData();
            }
            q.this.bao();
        }
    };
    private k.b eFo = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jQ()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eFg != null && q.this.eFl != null) {
                q.this.bap();
                q.this.eFe.agO();
            }
            q.this.bao();
        }
    };
    private com.baidu.adp.base.d eFp = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_success);
                    if (q.this.eFg != null && !aq.isEmpty(q.this.eFg.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.eFg.threadId));
                    }
                } else if (!aq.isEmpty(bVar.jlh)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.jlh);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_fail);
                }
            }
        }
    };
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public q(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.eFh = new ArrayList();
            this.eFd = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.eFl = new ForumManageModel(this.mPageContext);
            this.eFl.setLoadDataCallBack(this.eFp);
        }
    }

    public void onChangeSkinType() {
        if (this.eFd != null) {
            this.eFd.onChangeSkinType();
        }
        if (this.eFe != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eFe.agP());
        }
    }

    public void create() {
        if (this.eFc == null) {
            this.eFi = new com.baidu.tbadk.core.dialog.g(this.eFd);
            this.eFi.a(this.eFn);
            this.eFh.add(this.eFi);
            this.eFj = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.eFd);
            this.eFj.a(this.eFo);
            this.eFh.add(this.eFj);
            this.eFd.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.bao();
                }
            });
            this.eFd.W(this.eFh);
            this.eFc = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.eFd);
        }
    }

    public void a(a aVar) {
        this.eFf = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.eFg = cardPersonDynamicThreadData;
        if (this.eFg != null && this.eFi != null) {
            if (this.eFg.isPrivacy) {
                this.eFi.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.eFi.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.eFc != null) {
            this.eFc.showDialog();
        }
    }

    public void bao() {
        if (this.eFc != null && this.eFc.isShowing()) {
            this.eFc.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bap() {
        if (this.eFe == null) {
            this.eFe = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.eFe.hv(R.string.del_thread_confirm);
            this.eFe.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.jQ()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (q.this.eFg.from != 1) {
                        if (q.this.eFg.from == 3) {
                            TiebaStatic.log(new an("c12600").P("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").P("obj_type", 3));
                    }
                    q.this.eFl.a(q.this.eFg.forumId, q.this.eFg.forumName, q.this.eFg.threadId, q.this.eFg.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.eFe.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eFe.dQ(true);
            this.eFe.b(this.mPageContext);
        }
    }
}
