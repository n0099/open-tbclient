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
    private com.baidu.tbadk.core.dialog.i hSJ;
    private com.baidu.tbadk.core.dialog.k hSK;
    private com.baidu.tbadk.core.dialog.a hSL;
    private a hSM;
    private CardPersonDynamicThreadData hSN;
    private List<com.baidu.tbadk.core.dialog.g> hSO;
    private com.baidu.tbadk.core.dialog.g hSP;
    private com.baidu.tbadk.core.dialog.g hSQ;
    private com.baidu.tbadk.core.dialog.g hSR;
    private SetPrivacyModel hSS;
    private ForumManageModel hST;
    private com.baidu.tieba.callfans.a hSV;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean hSU = false;
    private k.b hSW = new k.b() { // from class: com.baidu.tieba.card.q.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (q.this.hSN != null) {
                q.this.clL();
                if (q.this.hSN.from == 1) {
                    i = 2;
                } else {
                    i = q.this.hSN.from == 3 ? 1 : 1;
                }
                if (q.this.hSN == null || !q.this.hSN.isPrivacy) {
                    if (q.this.hSN.bhz() != null) {
                        q.this.hSV.setThreadId(q.this.hSN.bhz().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && q.this.hSN.bhz() != null && TbSingleton.getInstance().mCallFansTid.equals(q.this.hSN.bhz().getTid())) {
                        i2 = 2;
                    }
                    q.this.hSV.clm();
                    if (q.this.hSN.bhz() != null) {
                        q.this.hSV.l(i, i2, q.this.hSN.bhz().getTid());
                        return;
                    }
                    return;
                }
                q.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (q.this.hSN.bhz() != null) {
                    q.this.hSV.l(i, 3, q.this.hSN.bhz().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a hSX = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.hSN.isPrivacy) {
                q.this.hSN.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.thread_has_open);
                if (q.this.hSP != null) {
                    q.this.hSP.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.hSM != null) {
                    q.this.hSM.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.hSN.isPrivacy = true;
            if (q.this.hSP != null) {
                q.this.hSP.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.hSM != null) {
                q.this.hSM.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, q.this.hSN.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b hSY = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.hSN.isPrivacy) {
                if (q.this.hSN.from == 1) {
                    TiebaStatic.log(new aq("c12599").aj("obj_type", 2));
                }
            } else if (q.this.hSN.from != 1) {
                if (q.this.hSN.from == 3) {
                    TiebaStatic.log(new aq("c12600").aj("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new aq("c12599").aj("obj_type", 1));
            }
            if (q.this.hSS == null) {
                q.this.hSS = new SetPrivacyModel(q.this.mPageContext, q.this.hSN);
            }
            if (!q.this.hSS.isRunning()) {
                q.this.hSS.a(q.this.hSX);
                q.this.hSS.LoadData();
            }
            q.this.clL();
        }
    };
    private k.b hSZ = new k.b() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.hSN != null && q.this.hST != null) {
                q.this.clM();
                q.this.hSL.bmC();
            }
            q.this.clL();
        }
    };
    private com.baidu.adp.base.d hTa = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_success);
                    if (q.this.hSN != null) {
                        if (at.isEmpty(q.this.hSN.hWs)) {
                            if (!at.isEmpty(q.this.hSN.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, q.this.hSN.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.hSN.hWs));
                    }
                } else if (!at.isEmpty(bVar.mTG)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.mTG);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_fail);
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
            this.hSO = new ArrayList();
            this.hSK = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.hST = new ForumManageModel(this.mPageContext);
            this.hST.setLoadDataCallBack(this.hTa);
            this.hSV = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.hSK != null) {
            this.hSK.onChangeSkinType();
        }
        if (this.hSL != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hSL.getRealView());
        }
    }

    public void create() {
        if (this.hSJ == null) {
            this.hSP = new com.baidu.tbadk.core.dialog.g(this.hSK);
            this.hSP.a(this.hSY);
            if (!this.hSU) {
                this.hSO.add(this.hSP);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.hSU) {
                this.hSQ = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.hSK);
                this.hSQ.a(this.hSW);
                this.hSO.add(this.hSQ);
            }
            this.hSR = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.hSK);
            this.hSR.a(this.hSZ);
            this.hSO.add(this.hSR);
            this.hSK.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.clL();
                }
            });
            this.hSK.bk(this.hSO);
            this.hSJ = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.hSK);
        }
    }

    public void a(a aVar) {
        this.hSM = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.hSN = cardPersonDynamicThreadData;
        if (this.hSN != null && this.hSP != null) {
            if (this.hSN.isPrivacy) {
                this.hSP.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.hSP.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.hSQ != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.hSQ.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.hSN.bhz() != null && TbSingleton.getInstance().mCallFansTid.equals(this.hSN.bhz().getTid())) {
                    this.hSQ.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.hSQ.setText(this.mContext.getString(R.string.call_fans));
                }
                this.hSQ.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.hSJ != null) {
            this.hSJ.PJ();
        }
    }

    public void clL() {
        if (this.hSJ != null && this.hSJ.isShowing()) {
            this.hSJ.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clM() {
        if (this.hSL == null) {
            this.hSL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.hSU) {
                this.hSL.om(R.string.del_dynamic_confirm);
            } else {
                this.hSL.om(R.string.del_thread_confirm);
            }
            this.hSL.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                        return;
                    }
                    if (q.this.hSN.from != 1) {
                        if (q.this.hSN.from == 3) {
                            TiebaStatic.log(new aq("c12600").aj("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new aq("c12599").aj("obj_type", 3));
                    }
                    if (q.this.hSU) {
                        q.this.hST.aX(q.this.hSN.erH);
                    }
                    q.this.hST.a(q.this.hSN.forumId, q.this.hSN.forumName, q.this.hSN.threadId, q.this.hSN.postId, 0, 0, true, q.this.hSN.erH.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.hSL.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hSL.iM(true);
            this.hSL.b(this.mPageContext);
        }
    }

    public void om(boolean z) {
        this.hSU = z;
    }
}
