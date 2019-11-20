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
    private com.baidu.tbadk.core.dialog.i eMS;
    private com.baidu.tbadk.core.dialog.k eMT;
    private com.baidu.tbadk.core.dialog.a eMU;
    private a eMV;
    private CardPersonDynamicThreadData eMW;
    private List<com.baidu.tbadk.core.dialog.g> eMX;
    private com.baidu.tbadk.core.dialog.g eMY;
    private com.baidu.tbadk.core.dialog.g eMZ;
    private SetPrivacyModel eNa;
    private ForumManageModel eNb;
    private SetPrivacyModel.a eNc = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.eMW.isPrivacy) {
                q.this.eMW.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.thread_has_open);
                if (q.this.eMY != null) {
                    q.this.eMY.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.eMV != null) {
                    q.this.eMV.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.eMW.isPrivacy = true;
            if (q.this.eMY != null) {
                q.this.eMY.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.eMV != null) {
                q.this.eMV.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, q.this.eMW.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b eNd = new k.b() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eMW.isPrivacy) {
                if (q.this.eMW.from == 1) {
                    TiebaStatic.log(new an("c12599").O("obj_type", 2));
                }
            } else if (q.this.eMW.from != 1) {
                if (q.this.eMW.from == 3) {
                    TiebaStatic.log(new an("c12600").O("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").O("obj_type", 1));
            }
            if (q.this.eNa == null) {
                q.this.eNa = new SetPrivacyModel(q.this.mPageContext, q.this.eMW);
            }
            if (!q.this.eNa.isRunning()) {
                q.this.eNa.a(q.this.eNc);
                q.this.eNa.LoadData();
            }
            q.this.bap();
        }
    };
    private k.b eNe = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eMW != null && q.this.eNb != null) {
                q.this.baq();
                q.this.eMU.akM();
            }
            q.this.bap();
        }
    };
    private com.baidu.adp.base.d eNf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_success);
                    if (q.this.eMW != null && !aq.isEmpty(q.this.eMW.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, q.this.eMW.threadId));
                    }
                } else if (!aq.isEmpty(bVar.jkg)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.jkg);
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
            this.eMX = new ArrayList();
            this.eMT = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.eNb = new ForumManageModel(this.mPageContext);
            this.eNb.setLoadDataCallBack(this.eNf);
        }
    }

    public void onChangeSkinType() {
        if (this.eMT != null) {
            this.eMT.onChangeSkinType();
        }
        if (this.eMU != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eMU.getRealView());
        }
    }

    public void create() {
        if (this.eMS == null) {
            this.eMY = new com.baidu.tbadk.core.dialog.g(this.eMT);
            this.eMY.a(this.eNd);
            this.eMX.add(this.eMY);
            this.eMZ = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.eMT);
            this.eMZ.a(this.eNe);
            this.eMX.add(this.eMZ);
            this.eMT.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.bap();
                }
            });
            this.eMT.at(this.eMX);
            this.eMS = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.eMT);
        }
    }

    public void a(a aVar) {
        this.eMV = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.eMW = cardPersonDynamicThreadData;
        if (this.eMW != null && this.eMY != null) {
            if (this.eMW.isPrivacy) {
                this.eMY.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.eMY.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.eMS != null) {
            this.eMS.showDialog();
        }
    }

    public void bap() {
        if (this.eMS != null && this.eMS.isShowing()) {
            this.eMS.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baq() {
        if (this.eMU == null) {
            this.eMU = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.eMU.hT(R.string.del_thread_confirm);
            this.eMU.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (q.this.eMW.from != 1) {
                        if (q.this.eMW.from == 3) {
                            TiebaStatic.log(new an("c12600").O("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").O("obj_type", 3));
                    }
                    q.this.eNb.a(q.this.eMW.forumId, q.this.eMW.forumName, q.this.eMW.threadId, q.this.eMW.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.eMU.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eMU.eg(true);
            this.eMU.b(this.mPageContext);
        }
    }
}
