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
    private com.baidu.tbadk.core.dialog.g eiA;
    private com.baidu.tbadk.core.dialog.i eiB;
    private com.baidu.tbadk.core.dialog.a eiC;
    private a eiD;
    private CardPersonDynamicThreadData eiE;
    private List<com.baidu.tbadk.core.dialog.f> eiF;
    private com.baidu.tbadk.core.dialog.f eiG;
    private com.baidu.tbadk.core.dialog.f eiH;
    private SetPrivacyModel eiI;
    private ForumManageModel eiJ;
    private SetPrivacyModel.a eiK = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.eiE.isPrivacy) {
                q.this.eiE.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.thread_has_open);
                if (q.this.eiG != null) {
                    q.this.eiG.setText(q.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (q.this.eiD != null) {
                    q.this.eiD.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.eiE.isPrivacy = true;
            if (q.this.eiG != null) {
                q.this.eiG.setText(q.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (q.this.eiD != null) {
                q.this.eiD.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.eiE.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private i.b eiL = new i.b() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kM()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.neterror);
                return;
            }
            if (q.this.eiE.isPrivacy) {
                if (q.this.eiE.from == 1) {
                    TiebaStatic.log(new am("c12599").T("obj_type", 2));
                }
            } else if (q.this.eiE.from != 1) {
                if (q.this.eiE.from == 3) {
                    TiebaStatic.log(new am("c12600").T("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").T("obj_type", 1));
            }
            if (q.this.eiI == null) {
                q.this.eiI = new SetPrivacyModel(q.this.mPageContext, q.this.eiE);
            }
            if (!q.this.eiI.isRunning()) {
                q.this.eiI.a(q.this.eiK);
                q.this.eiI.LoadData();
            }
            q.this.aQy();
        }
    };
    private i.b eiM = new i.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.i.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kM()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.neterror);
                return;
            }
            if (q.this.eiE != null && q.this.eiJ != null) {
                q.this.aQz();
                q.this.eiC.aaW();
            }
            q.this.aQy();
        }
    };
    private com.baidu.adp.base.d eiN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.delete_success);
                    if (q.this.eiE != null && !ap.isEmpty(q.this.eiE.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.eiE.threadId));
                    }
                } else if (!ap.isEmpty(bVar.iIo)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.iIo);
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
            this.eiF = new ArrayList();
            this.eiB = new com.baidu.tbadk.core.dialog.i(this.mContext);
            this.eiJ = new ForumManageModel(this.mPageContext);
            this.eiJ.setLoadDataCallBack(this.eiN);
        }
    }

    public void onChangeSkinType() {
        if (this.eiB != null) {
            this.eiB.onChangeSkinType();
        }
        if (this.eiC != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.eiC.aaX());
        }
    }

    public void create() {
        if (this.eiA == null) {
            this.eiG = new com.baidu.tbadk.core.dialog.f(this.eiB);
            this.eiG.a(this.eiL);
            this.eiF.add(this.eiG);
            this.eiH = new com.baidu.tbadk.core.dialog.f(this.mContext.getString(d.j.delete), this.eiB);
            this.eiH.a(this.eiM);
            this.eiF.add(this.eiH);
            this.eiB.a(new i.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.i.a
                public void onClick() {
                    q.this.aQy();
                }
            });
            this.eiB.P(this.eiF);
            this.eiA = new com.baidu.tbadk.core.dialog.g(this.mPageContext, this.eiB.abh());
        }
    }

    public void a(a aVar) {
        this.eiD = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.eiE = cardPersonDynamicThreadData;
        if (this.eiE != null && this.eiG != null) {
            if (this.eiE.isPrivacy) {
                this.eiG.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.eiG.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.eiA != null) {
            this.eiA.showDialog();
        }
    }

    public void aQy() {
        if (this.eiA != null && this.eiA.isShowing()) {
            this.eiA.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQz() {
        if (this.eiC == null) {
            this.eiC = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.eiC.gC(d.j.del_thread_confirm);
            this.eiC.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.kM()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, d.j.neterror);
                        return;
                    }
                    if (q.this.eiE.from != 1) {
                        if (q.this.eiE.from == 3) {
                            TiebaStatic.log(new am("c12600").T("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").T("obj_type", 3));
                    }
                    q.this.eiJ.a(q.this.eiE.forumId, q.this.eiE.forumName, q.this.eiE.threadId, q.this.eiE.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.eiC.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eiC.dq(true);
            this.eiC.b(this.mPageContext);
        }
    }
}
