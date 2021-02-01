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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class q {
    private ForumManageModel geq;
    private com.baidu.tbadk.core.dialog.i ixB;
    private com.baidu.tbadk.core.dialog.k ixC;
    private com.baidu.tbadk.core.dialog.a ixD;
    private a ixE;
    private CardPersonDynamicThreadData ixF;
    private List<com.baidu.tbadk.core.dialog.g> ixG;
    private com.baidu.tbadk.core.dialog.g ixH;
    private com.baidu.tbadk.core.dialog.g ixI;
    private com.baidu.tbadk.core.dialog.g ixJ;
    private SetPrivacyModel ixK;
    private com.baidu.tieba.callfans.a ixM;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean ixL = false;
    private k.b ixN = new k.b() { // from class: com.baidu.tieba.card.q.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (q.this.ixF != null) {
                q.this.csp();
                if (q.this.ixF.from == 1) {
                    i = 2;
                } else {
                    i = q.this.ixF.from == 3 ? 1 : 1;
                }
                if (q.this.ixF == null || !q.this.ixF.isPrivacy) {
                    if (q.this.ixF.bln() != null) {
                        q.this.ixM.setThreadId(q.this.ixF.bln().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && q.this.ixF.bln() != null && TbSingleton.getInstance().mCallFansTid.equals(q.this.ixF.bln().getTid())) {
                        i2 = 2;
                    }
                    q.this.ixM.crP();
                    if (q.this.ixF.bln() != null) {
                        q.this.ixM.k(i, i2, q.this.ixF.bln().getTid());
                        return;
                    }
                    return;
                }
                q.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (q.this.ixF.bln() != null) {
                    q.this.ixM.k(i, 3, q.this.ixF.bln().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a ixO = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.ixF.isPrivacy) {
                q.this.ixF.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.thread_has_open);
                if (q.this.ixH != null) {
                    q.this.ixH.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.ixE != null) {
                    q.this.ixE.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.ixF.isPrivacy = true;
            if (q.this.ixH != null) {
                q.this.ixH.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.ixE != null) {
                q.this.ixE.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, q.this.ixF.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b ixP = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.ixF.isPrivacy) {
                if (q.this.ixF.from == 1) {
                    TiebaStatic.log(new ar("c12599").ap("obj_type", 2));
                }
            } else if (q.this.ixF.from != 1) {
                if (q.this.ixF.from == 3) {
                    TiebaStatic.log(new ar("c12600").ap("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ar("c12599").ap("obj_type", 1));
            }
            if (q.this.ixK == null) {
                q.this.ixK = new SetPrivacyModel(q.this.mPageContext, q.this.ixF);
            }
            if (!q.this.ixK.isRunning()) {
                q.this.ixK.a(q.this.ixO);
                q.this.ixK.LoadData();
            }
            q.this.csp();
        }
    };
    private k.b ixQ = new k.b() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.ixF != null && q.this.geq != null) {
                q.this.csq();
                q.this.ixD.bqx();
            }
            q.this.csp();
        }
    };
    private com.baidu.adp.base.e ixR = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.q.8
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_success);
                    if (q.this.ixF != null) {
                        if (au.isEmpty(q.this.ixF.iBB)) {
                            if (!au.isEmpty(q.this.ixF.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, q.this.ixF.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.ixF.iBB));
                    }
                } else if (!au.isEmpty(bVar.nzx)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.nzx);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public q(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.ixG = new ArrayList();
            this.ixC = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.geq = new ForumManageModel(this.mPageContext);
            this.geq.setLoadDataCallBack(this.ixR);
            this.ixM = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.ixC != null) {
            this.ixC.onChangeSkinType();
        }
        if (this.ixD != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.ixD.getRealView());
        }
    }

    public void create() {
        if (this.ixB == null) {
            this.ixH = new com.baidu.tbadk.core.dialog.g(this.ixC);
            this.ixH.a(this.ixP);
            if (!this.ixL) {
                this.ixG.add(this.ixH);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.ixL) {
                this.ixI = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.ixC);
                this.ixI.a(this.ixN);
                this.ixG.add(this.ixI);
            }
            this.ixJ = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.ixC);
            this.ixJ.a(this.ixQ);
            this.ixG.add(this.ixJ);
            this.ixC.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.csp();
                }
            });
            this.ixC.bw(this.ixG);
            this.ixB = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.ixC);
        }
    }

    public void a(a aVar) {
        this.ixE = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        this.ixF = cardPersonDynamicThreadData;
        if (this.ixF != null && this.ixH != null) {
            if (this.ixF.isPrivacy) {
                this.ixH.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.ixH.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            this.ixH.jJ(z);
            if (this.ixI != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.ixI.setText(this.mContext.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.ixF.bln() != null && TbSingleton.getInstance().mCallFansTid.equals(this.ixF.bln().getTid())) {
                        this.ixI.setText(this.mContext.getString(R.string.have_called_fans));
                    } else {
                        this.ixI.setText(this.mContext.getString(R.string.call_fans));
                    }
                    this.ixI.setTextColor(R.color.cp_cont_b_alpha33);
                }
                this.ixI.jJ(z);
            }
        }
    }

    public void show() {
        if (this.ixB != null) {
            this.ixB.QE();
        }
    }

    public void csp() {
        if (this.ixB != null && this.ixB.isShowing()) {
            this.ixB.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csq() {
        if (this.ixD == null) {
            this.ixD = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.ixL) {
                this.ixD.nx(R.string.del_dynamic_confirm);
            } else {
                this.ixD.nx(R.string.del_thread_confirm);
            }
            this.ixD.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                        return;
                    }
                    if (q.this.ixF.from != 1) {
                        if (q.this.ixF.from == 3) {
                            TiebaStatic.log(new ar("c12600").ap("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ar("c12599").ap("obj_type", 3));
                    }
                    if (q.this.ixL) {
                        q.this.geq.bb(q.this.ixF.eJQ);
                    }
                    q.this.geq.a(q.this.ixF.forumId, q.this.ixF.forumName, q.this.ixF.threadId, q.this.ixF.postId, 0, 0, true, q.this.ixF.eJQ.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.ixD.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ixD.jF(true);
            this.ixD.b(this.mPageContext);
        }
    }

    public void py(boolean z) {
        this.ixL = z;
    }
}
