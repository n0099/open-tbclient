package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class q {
    private com.baidu.tbadk.core.dialog.g eiN;
    private com.baidu.tbadk.core.dialog.i eiO;
    private com.baidu.tbadk.core.dialog.a eiP;
    private a eiQ;
    private CardPersonDynamicThreadData eiR;
    private List<com.baidu.tbadk.core.dialog.f> eiS;
    private com.baidu.tbadk.core.dialog.f eiT;
    private com.baidu.tbadk.core.dialog.f eiU;
    private SetPrivacyModel eiV;
    private ForumManageModel eiW;
    private SetPrivacyModel.a eiX = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.eiR.isPrivacy) {
                q.this.eiR.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.thread_has_open);
                if (q.this.eiT != null) {
                    q.this.eiT.setText(q.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (q.this.eiQ != null) {
                    q.this.eiQ.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.eiR.isPrivacy = true;
            if (q.this.eiT != null) {
                q.this.eiT.setText(q.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (q.this.eiQ != null) {
                q.this.eiQ.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.eiR.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private i.b eiY = new i.b() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kM()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.neterror);
                return;
            }
            if (q.this.eiR.isPrivacy) {
                if (q.this.eiR.from == 1) {
                    TiebaStatic.log(new am("c12599").T("obj_type", 2));
                }
            } else if (q.this.eiR.from != 1) {
                if (q.this.eiR.from == 3) {
                    TiebaStatic.log(new am("c12600").T("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").T("obj_type", 1));
            }
            if (q.this.eiV == null) {
                q.this.eiV = new SetPrivacyModel(q.this.mPageContext, q.this.eiR);
            }
            if (!q.this.eiV.isRunning()) {
                q.this.eiV.a(q.this.eiX);
                q.this.eiV.LoadData();
            }
            q.this.aQA();
        }
    };
    private i.b eiZ = new i.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kM()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.neterror);
                return;
            }
            if (q.this.eiR != null && q.this.eiW != null) {
                q.this.aQB();
                q.this.eiP.aaZ();
            }
            q.this.aQA();
        }
    };
    private com.baidu.adp.base.d eja = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.delete_success);
                    if (q.this.eiR != null && !ap.isEmpty(q.this.eiR.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.eiR.threadId));
                    }
                } else if (!ap.isEmpty(bVar.iIC)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.iIC);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.delete_fail);
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
            this.eiS = new ArrayList();
            this.eiO = new com.baidu.tbadk.core.dialog.i(this.mContext);
            this.eiW = new ForumManageModel(this.mPageContext);
            this.eiW.setLoadDataCallBack(this.eja);
        }
    }

    public void onChangeSkinType() {
        if (this.eiO != null) {
            this.eiO.onChangeSkinType();
        }
        if (this.eiP != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.eiP.aba());
        }
    }

    public void create() {
        if (this.eiN == null) {
            this.eiT = new com.baidu.tbadk.core.dialog.f(this.eiO);
            this.eiT.a(this.eiY);
            this.eiS.add(this.eiT);
            this.eiU = new com.baidu.tbadk.core.dialog.f(this.mContext.getString(d.j.delete), this.eiO);
            this.eiU.a(this.eiZ);
            this.eiS.add(this.eiU);
            this.eiO.a(new i.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.i.a
                public void onClick() {
                    q.this.aQA();
                }
            });
            this.eiO.P(this.eiS);
            this.eiN = new com.baidu.tbadk.core.dialog.g(this.mPageContext, this.eiO.abk());
        }
    }

    public void a(a aVar) {
        this.eiQ = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.eiR = cardPersonDynamicThreadData;
        if (this.eiR != null && this.eiT != null) {
            if (this.eiR.isPrivacy) {
                this.eiT.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.eiT.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.eiN != null) {
            this.eiN.showDialog();
        }
    }

    public void aQA() {
        if (this.eiN != null && this.eiN.isShowing()) {
            this.eiN.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQB() {
        if (this.eiP == null) {
            this.eiP = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.eiP.gD(d.j.del_thread_confirm);
            this.eiP.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.kM()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.neterror);
                        return;
                    }
                    if (q.this.eiR.from != 1) {
                        if (q.this.eiR.from == 3) {
                            TiebaStatic.log(new am("c12600").T("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").T("obj_type", 3));
                    }
                    q.this.eiW.a(q.this.eiR.forumId, q.this.eiR.forumName, q.this.eiR.threadId, q.this.eiR.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.eiP.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eiP.dq(true);
            this.eiP.b(this.mPageContext);
        }
    }
}
