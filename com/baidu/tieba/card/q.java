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
    private com.baidu.tbadk.core.dialog.i eiA;
    private com.baidu.tbadk.core.dialog.a eiB;
    private a eiC;
    private CardPersonDynamicThreadData eiD;
    private List<com.baidu.tbadk.core.dialog.f> eiE;
    private com.baidu.tbadk.core.dialog.f eiF;
    private com.baidu.tbadk.core.dialog.f eiG;
    private SetPrivacyModel eiH;
    private ForumManageModel eiI;
    private SetPrivacyModel.a eiJ = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.eiD.isPrivacy) {
                q.this.eiD.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.thread_has_open);
                if (q.this.eiF != null) {
                    q.this.eiF.setText(q.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (q.this.eiC != null) {
                    q.this.eiC.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.eiD.isPrivacy = true;
            if (q.this.eiF != null) {
                q.this.eiF.setText(q.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (q.this.eiC != null) {
                q.this.eiC.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.eiD.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private i.b eiK = new i.b() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kM()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.neterror);
                return;
            }
            if (q.this.eiD.isPrivacy) {
                if (q.this.eiD.from == 1) {
                    TiebaStatic.log(new am("c12599").T("obj_type", 2));
                }
            } else if (q.this.eiD.from != 1) {
                if (q.this.eiD.from == 3) {
                    TiebaStatic.log(new am("c12600").T("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").T("obj_type", 1));
            }
            if (q.this.eiH == null) {
                q.this.eiH = new SetPrivacyModel(q.this.mPageContext, q.this.eiD);
            }
            if (!q.this.eiH.isRunning()) {
                q.this.eiH.a(q.this.eiJ);
                q.this.eiH.LoadData();
            }
            q.this.aQy();
        }
    };
    private i.b eiL = new i.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kM()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.neterror);
                return;
            }
            if (q.this.eiD != null && q.this.eiI != null) {
                q.this.aQz();
                q.this.eiB.aaW();
            }
            q.this.aQy();
        }
    };
    private com.baidu.adp.base.d eiM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.delete_success);
                    if (q.this.eiD != null && !ap.isEmpty(q.this.eiD.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.eiD.threadId));
                    }
                } else if (!ap.isEmpty(bVar.iIn)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.iIn);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.delete_fail);
                }
            }
        }
    };
    private com.baidu.tbadk.core.dialog.g eiz;
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
            this.eiE = new ArrayList();
            this.eiA = new com.baidu.tbadk.core.dialog.i(this.mContext);
            this.eiI = new ForumManageModel(this.mPageContext);
            this.eiI.setLoadDataCallBack(this.eiM);
        }
    }

    public void onChangeSkinType() {
        if (this.eiA != null) {
            this.eiA.onChangeSkinType();
        }
        if (this.eiB != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.eiB.aaX());
        }
    }

    public void create() {
        if (this.eiz == null) {
            this.eiF = new com.baidu.tbadk.core.dialog.f(this.eiA);
            this.eiF.a(this.eiK);
            this.eiE.add(this.eiF);
            this.eiG = new com.baidu.tbadk.core.dialog.f(this.mContext.getString(d.j.delete), this.eiA);
            this.eiG.a(this.eiL);
            this.eiE.add(this.eiG);
            this.eiA.a(new i.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.i.a
                public void onClick() {
                    q.this.aQy();
                }
            });
            this.eiA.P(this.eiE);
            this.eiz = new com.baidu.tbadk.core.dialog.g(this.mPageContext, this.eiA.abh());
        }
    }

    public void a(a aVar) {
        this.eiC = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.eiD = cardPersonDynamicThreadData;
        if (this.eiD != null && this.eiF != null) {
            if (this.eiD.isPrivacy) {
                this.eiF.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.eiF.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.eiz != null) {
            this.eiz.showDialog();
        }
    }

    public void aQy() {
        if (this.eiz != null && this.eiz.isShowing()) {
            this.eiz.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQz() {
        if (this.eiB == null) {
            this.eiB = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.eiB.gC(d.j.del_thread_confirm);
            this.eiB.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.kM()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.neterror);
                        return;
                    }
                    if (q.this.eiD.from != 1) {
                        if (q.this.eiD.from == 3) {
                            TiebaStatic.log(new am("c12600").T("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").T("obj_type", 3));
                    }
                    q.this.eiI.a(q.this.eiD.forumId, q.this.eiD.forumName, q.this.eiD.threadId, q.this.eiD.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.eiB.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eiB.dq(true);
            this.eiB.b(this.mPageContext);
        }
    }
}
