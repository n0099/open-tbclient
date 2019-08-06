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
    private com.baidu.tbadk.core.dialog.g eDA;
    private SetPrivacyModel eDB;
    private ForumManageModel eDC;
    private SetPrivacyModel.a eDD = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.eDx.isPrivacy) {
                q.this.eDx.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.thread_has_open);
                if (q.this.eDz != null) {
                    q.this.eDz.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.eDw != null) {
                    q.this.eDw.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.eDx.isPrivacy = true;
            if (q.this.eDz != null) {
                q.this.eDz.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.eDw != null) {
                q.this.eDw.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.eDx.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b eDE = new k.b() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jQ()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eDx.isPrivacy) {
                if (q.this.eDx.from == 1) {
                    TiebaStatic.log(new an("c12599").P("obj_type", 2));
                }
            } else if (q.this.eDx.from != 1) {
                if (q.this.eDx.from == 3) {
                    TiebaStatic.log(new an("c12600").P("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").P("obj_type", 1));
            }
            if (q.this.eDB == null) {
                q.this.eDB = new SetPrivacyModel(q.this.mPageContext, q.this.eDx);
            }
            if (!q.this.eDB.isRunning()) {
                q.this.eDB.a(q.this.eDD);
                q.this.eDB.LoadData();
            }
            q.this.aZK();
        }
    };
    private k.b eDF = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jQ()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eDx != null && q.this.eDC != null) {
                q.this.aZL();
                q.this.eDv.agK();
            }
            q.this.aZK();
        }
    };
    private com.baidu.adp.base.d eDG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_success);
                    if (q.this.eDx != null && !aq.isEmpty(q.this.eDx.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.eDx.threadId));
                    }
                } else if (!aq.isEmpty(bVar.jiM)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.jiM);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_fail);
                }
            }
        }
    };
    private com.baidu.tbadk.core.dialog.i eDt;
    private com.baidu.tbadk.core.dialog.k eDu;
    private com.baidu.tbadk.core.dialog.a eDv;
    private a eDw;
    private CardPersonDynamicThreadData eDx;
    private List<com.baidu.tbadk.core.dialog.g> eDy;
    private com.baidu.tbadk.core.dialog.g eDz;
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
            this.eDy = new ArrayList();
            this.eDu = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.eDC = new ForumManageModel(this.mPageContext);
            this.eDC.setLoadDataCallBack(this.eDG);
        }
    }

    public void onChangeSkinType() {
        if (this.eDu != null) {
            this.eDu.onChangeSkinType();
        }
        if (this.eDv != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eDv.agL());
        }
    }

    public void create() {
        if (this.eDt == null) {
            this.eDz = new com.baidu.tbadk.core.dialog.g(this.eDu);
            this.eDz.a(this.eDE);
            this.eDy.add(this.eDz);
            this.eDA = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.eDu);
            this.eDA.a(this.eDF);
            this.eDy.add(this.eDA);
            this.eDu.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.aZK();
                }
            });
            this.eDu.W(this.eDy);
            this.eDt = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.eDu.ahd());
        }
    }

    public void a(a aVar) {
        this.eDw = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.eDx = cardPersonDynamicThreadData;
        if (this.eDx != null && this.eDz != null) {
            if (this.eDx.isPrivacy) {
                this.eDz.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.eDz.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.eDt != null) {
            this.eDt.showDialog();
        }
    }

    public void aZK() {
        if (this.eDt != null && this.eDt.isShowing()) {
            this.eDt.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZL() {
        if (this.eDv == null) {
            this.eDv = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.eDv.hu(R.string.del_thread_confirm);
            this.eDv.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.jQ()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (q.this.eDx.from != 1) {
                        if (q.this.eDx.from == 3) {
                            TiebaStatic.log(new an("c12600").P("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").P("obj_type", 3));
                    }
                    q.this.eDC.a(q.this.eDx.forumId, q.this.eDx.forumName, q.this.eDx.threadId, q.this.eDx.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.eDv.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eDv.dQ(true);
            this.eDv.b(this.mPageContext);
        }
    }
}
