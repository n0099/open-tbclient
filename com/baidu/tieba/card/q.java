package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private com.baidu.tbadk.core.dialog.i eNJ;
    private com.baidu.tbadk.core.dialog.k eNK;
    private com.baidu.tbadk.core.dialog.a eNL;
    private a eNM;
    private CardPersonDynamicThreadData eNN;
    private List<com.baidu.tbadk.core.dialog.g> eNO;
    private com.baidu.tbadk.core.dialog.g eNP;
    private com.baidu.tbadk.core.dialog.g eNQ;
    private SetPrivacyModel eNR;
    private ForumManageModel eNS;
    private SetPrivacyModel.a eNT = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.eNN.isPrivacy) {
                q.this.eNN.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.thread_has_open);
                if (q.this.eNP != null) {
                    q.this.eNP.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.eNM != null) {
                    q.this.eNM.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.eNN.isPrivacy = true;
            if (q.this.eNP != null) {
                q.this.eNP.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.eNM != null) {
                q.this.eNM.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, q.this.eNN.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b eNU = new k.b() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eNN.isPrivacy) {
                if (q.this.eNN.from == 1) {
                    TiebaStatic.log(new an("c12599").O("obj_type", 2));
                }
            } else if (q.this.eNN.from != 1) {
                if (q.this.eNN.from == 3) {
                    TiebaStatic.log(new an("c12600").O("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").O("obj_type", 1));
            }
            if (q.this.eNR == null) {
                q.this.eNR = new SetPrivacyModel(q.this.mPageContext, q.this.eNN);
            }
            if (!q.this.eNR.isRunning()) {
                q.this.eNR.a(q.this.eNT);
                q.this.eNR.LoadData();
            }
            q.this.bar();
        }
    };
    private k.b eNV = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eNN != null && q.this.eNS != null) {
                q.this.bas();
                q.this.eNL.akO();
            }
            q.this.bar();
        }
    };
    private com.baidu.adp.base.d eNW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_success);
                    if (q.this.eNN != null && !aq.isEmpty(q.this.eNN.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, q.this.eNN.threadId));
                    }
                } else if (!aq.isEmpty(bVar.jkX)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.jkX);
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
            this.eNO = new ArrayList();
            this.eNK = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.eNS = new ForumManageModel(this.mPageContext);
            this.eNS.setLoadDataCallBack(this.eNW);
        }
    }

    public void onChangeSkinType() {
        if (this.eNK != null) {
            this.eNK.onChangeSkinType();
        }
        if (this.eNL != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eNL.getRealView());
        }
    }

    public void create() {
        if (this.eNJ == null) {
            this.eNP = new com.baidu.tbadk.core.dialog.g(this.eNK);
            this.eNP.a(this.eNU);
            this.eNO.add(this.eNP);
            this.eNQ = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.eNK);
            this.eNQ.a(this.eNV);
            this.eNO.add(this.eNQ);
            this.eNK.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.bar();
                }
            });
            this.eNK.at(this.eNO);
            this.eNJ = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.eNK);
        }
    }

    public void a(a aVar) {
        this.eNM = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.eNN = cardPersonDynamicThreadData;
        if (this.eNN != null && this.eNP != null) {
            if (this.eNN.isPrivacy) {
                this.eNP.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.eNP.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.eNJ != null) {
            this.eNJ.showDialog();
        }
    }

    public void bar() {
        if (this.eNJ != null && this.eNJ.isShowing()) {
            this.eNJ.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bas() {
        if (this.eNL == null) {
            this.eNL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.eNL.hU(R.string.del_thread_confirm);
            this.eNL.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (q.this.eNN.from != 1) {
                        if (q.this.eNN.from == 3) {
                            TiebaStatic.log(new an("c12600").O("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").O("obj_type", 3));
                    }
                    q.this.eNS.a(q.this.eNN.forumId, q.this.eNN.forumName, q.this.eNN.threadId, q.this.eNN.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.eNL.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eNL.eg(true);
            this.eNL.b(this.mPageContext);
        }
    }
}
