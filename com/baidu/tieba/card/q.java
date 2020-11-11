package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class q {
    private com.baidu.tbadk.core.dialog.i hYG;
    private com.baidu.tbadk.core.dialog.k hYH;
    private com.baidu.tbadk.core.dialog.a hYI;
    private a hYJ;
    private CardPersonDynamicThreadData hYK;
    private List<com.baidu.tbadk.core.dialog.g> hYL;
    private com.baidu.tbadk.core.dialog.g hYM;
    private com.baidu.tbadk.core.dialog.g hYN;
    private com.baidu.tbadk.core.dialog.g hYO;
    private SetPrivacyModel hYP;
    private ForumManageModel hYQ;
    private com.baidu.tieba.callfans.a hYS;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean hYR = false;
    private k.b hYT = new k.b() { // from class: com.baidu.tieba.card.q.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (q.this.hYK != null) {
                q.this.com();
                if (q.this.hYK.from == 1) {
                    i = 2;
                } else {
                    i = q.this.hYK.from == 3 ? 1 : 1;
                }
                if (q.this.hYK == null || !q.this.hYK.isPrivacy) {
                    if (q.this.hYK.bjZ() != null) {
                        q.this.hYS.setThreadId(q.this.hYK.bjZ().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && q.this.hYK.bjZ() != null && TbSingleton.getInstance().mCallFansTid.equals(q.this.hYK.bjZ().getTid())) {
                        i2 = 2;
                    }
                    q.this.hYS.cnN();
                    if (q.this.hYK.bjZ() != null) {
                        q.this.hYS.l(i, i2, q.this.hYK.bjZ().getTid());
                        return;
                    }
                    return;
                }
                q.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (q.this.hYK.bjZ() != null) {
                    q.this.hYS.l(i, 3, q.this.hYK.bjZ().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a hYU = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.hYK.isPrivacy) {
                q.this.hYK.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.thread_has_open);
                if (q.this.hYM != null) {
                    q.this.hYM.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.hYJ != null) {
                    q.this.hYJ.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.hYK.isPrivacy = true;
            if (q.this.hYM != null) {
                q.this.hYM.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.hYJ != null) {
                q.this.hYJ.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, q.this.hYK.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b hYV = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.hYK.isPrivacy) {
                if (q.this.hYK.from == 1) {
                    TiebaStatic.log(new aq("c12599").al("obj_type", 2));
                }
            } else if (q.this.hYK.from != 1) {
                if (q.this.hYK.from == 3) {
                    TiebaStatic.log(new aq("c12600").al("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new aq("c12599").al("obj_type", 1));
            }
            if (q.this.hYP == null) {
                q.this.hYP = new SetPrivacyModel(q.this.mPageContext, q.this.hYK);
            }
            if (!q.this.hYP.isRunning()) {
                q.this.hYP.a(q.this.hYU);
                q.this.hYP.LoadData();
            }
            q.this.com();
        }
    };
    private k.b hYW = new k.b() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.hYK != null && q.this.hYQ != null) {
                q.this.con();
                q.this.hYI.bpc();
            }
            q.this.com();
        }
    };
    private com.baidu.adp.base.d hYX = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_success);
                    if (q.this.hYK != null) {
                        if (at.isEmpty(q.this.hYK.icp)) {
                            if (!at.isEmpty(q.this.hYK.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, q.this.hYK.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.hYK.icp));
                    }
                } else if (!at.isEmpty(bVar.mZE)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.mZE);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes24.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public q(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.hYL = new ArrayList();
            this.hYH = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.hYQ = new ForumManageModel(this.mPageContext);
            this.hYQ.setLoadDataCallBack(this.hYX);
            this.hYS = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.hYH != null) {
            this.hYH.onChangeSkinType();
        }
        if (this.hYI != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hYI.getRealView());
        }
    }

    public void create() {
        if (this.hYG == null) {
            this.hYM = new com.baidu.tbadk.core.dialog.g(this.hYH);
            this.hYM.a(this.hYV);
            if (!this.hYR) {
                this.hYL.add(this.hYM);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.hYR) {
                this.hYN = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.hYH);
                this.hYN.a(this.hYT);
                this.hYL.add(this.hYN);
            }
            this.hYO = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.hYH);
            this.hYO.a(this.hYW);
            this.hYL.add(this.hYO);
            this.hYH.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.com();
                }
            });
            this.hYH.br(this.hYL);
            this.hYG = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.hYH);
        }
    }

    public void a(a aVar) {
        this.hYJ = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.hYK = cardPersonDynamicThreadData;
        if (this.hYK != null && this.hYM != null) {
            if (this.hYK.isPrivacy) {
                this.hYM.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.hYM.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.hYN != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.hYN.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.hYK.bjZ() != null && TbSingleton.getInstance().mCallFansTid.equals(this.hYK.bjZ().getTid())) {
                    this.hYN.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.hYN.setText(this.mContext.getString(R.string.call_fans));
                }
                this.hYN.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.hYG != null) {
            this.hYG.Qj();
        }
    }

    public void com() {
        if (this.hYG != null && this.hYG.isShowing()) {
            this.hYG.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void con() {
        if (this.hYI == null) {
            this.hYI = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.hYR) {
                this.hYI.ow(R.string.del_dynamic_confirm);
            } else {
                this.hYI.ow(R.string.del_thread_confirm);
            }
            this.hYI.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (q.this.hYK.from != 1) {
                        if (q.this.hYK.from == 3) {
                            TiebaStatic.log(new aq("c12600").al("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new aq("c12599").al("obj_type", 3));
                    }
                    if (q.this.hYR) {
                        q.this.hYQ.aX(q.this.hYK.exA);
                    }
                    q.this.hYQ.a(q.this.hYK.forumId, q.this.hYK.forumName, q.this.hYK.threadId, q.this.hYK.postId, 0, 0, true, q.this.hYK.exA.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.hYI.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hYI.iV(true);
            this.hYI.b(this.mPageContext);
        }
    }

    public void ov(boolean z) {
        this.hYR = z;
    }
}
