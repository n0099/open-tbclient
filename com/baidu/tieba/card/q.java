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
    private com.baidu.tbadk.core.dialog.i eDm;
    private com.baidu.tbadk.core.dialog.k eDn;
    private com.baidu.tbadk.core.dialog.a eDo;
    private a eDp;
    private CardPersonDynamicThreadData eDq;
    private List<com.baidu.tbadk.core.dialog.g> eDr;
    private com.baidu.tbadk.core.dialog.g eDs;
    private com.baidu.tbadk.core.dialog.g eDt;
    private SetPrivacyModel eDu;
    private ForumManageModel eDv;
    private SetPrivacyModel.a eDw = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.eDq.isPrivacy) {
                q.this.eDq.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.thread_has_open);
                if (q.this.eDs != null) {
                    q.this.eDs.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.eDp != null) {
                    q.this.eDp.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.eDq.isPrivacy = true;
            if (q.this.eDs != null) {
                q.this.eDs.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.eDp != null) {
                q.this.eDp.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.eDq.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b eDx = new k.b() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jQ()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eDq.isPrivacy) {
                if (q.this.eDq.from == 1) {
                    TiebaStatic.log(new an("c12599").P("obj_type", 2));
                }
            } else if (q.this.eDq.from != 1) {
                if (q.this.eDq.from == 3) {
                    TiebaStatic.log(new an("c12600").P("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").P("obj_type", 1));
            }
            if (q.this.eDu == null) {
                q.this.eDu = new SetPrivacyModel(q.this.mPageContext, q.this.eDq);
            }
            if (!q.this.eDu.isRunning()) {
                q.this.eDu.a(q.this.eDw);
                q.this.eDu.LoadData();
            }
            q.this.aZI();
        }
    };
    private k.b eDy = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jQ()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eDq != null && q.this.eDv != null) {
                q.this.aZJ();
                q.this.eDo.agI();
            }
            q.this.aZI();
        }
    };
    private com.baidu.adp.base.d eDz = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_success);
                    if (q.this.eDq != null && !aq.isEmpty(q.this.eDq.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.eDq.threadId));
                    }
                } else if (!aq.isEmpty(bVar.jhE)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.jhE);
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
            this.eDr = new ArrayList();
            this.eDn = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.eDv = new ForumManageModel(this.mPageContext);
            this.eDv.setLoadDataCallBack(this.eDz);
        }
    }

    public void onChangeSkinType() {
        if (this.eDn != null) {
            this.eDn.onChangeSkinType();
        }
        if (this.eDo != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eDo.agJ());
        }
    }

    public void create() {
        if (this.eDm == null) {
            this.eDs = new com.baidu.tbadk.core.dialog.g(this.eDn);
            this.eDs.a(this.eDx);
            this.eDr.add(this.eDs);
            this.eDt = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.eDn);
            this.eDt.a(this.eDy);
            this.eDr.add(this.eDt);
            this.eDn.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.aZI();
                }
            });
            this.eDn.W(this.eDr);
            this.eDm = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.eDn.ahb());
        }
    }

    public void a(a aVar) {
        this.eDp = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.eDq = cardPersonDynamicThreadData;
        if (this.eDq != null && this.eDs != null) {
            if (this.eDq.isPrivacy) {
                this.eDs.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.eDs.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.eDm != null) {
            this.eDm.showDialog();
        }
    }

    public void aZI() {
        if (this.eDm != null && this.eDm.isShowing()) {
            this.eDm.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZJ() {
        if (this.eDo == null) {
            this.eDo = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.eDo.hu(R.string.del_thread_confirm);
            this.eDo.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.jQ()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (q.this.eDq.from != 1) {
                        if (q.this.eDq.from == 3) {
                            TiebaStatic.log(new an("c12600").P("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").P("obj_type", 3));
                    }
                    q.this.eDv.a(q.this.eDq.forumId, q.this.eDq.forumName, q.this.eDq.threadId, q.this.eDq.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.eDo.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eDo.dQ(true);
            this.eDo.b(this.mPageContext);
        }
    }
}
