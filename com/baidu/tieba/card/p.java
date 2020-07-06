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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class p {
    private com.baidu.tbadk.core.dialog.i gRN;
    private com.baidu.tbadk.core.dialog.k gRO;
    private com.baidu.tbadk.core.dialog.a gRP;
    private a gRQ;
    private CardPersonDynamicThreadData gRR;
    private List<com.baidu.tbadk.core.dialog.g> gRS;
    private com.baidu.tbadk.core.dialog.g gRT;
    private com.baidu.tbadk.core.dialog.g gRU;
    private com.baidu.tbadk.core.dialog.g gRV;
    private SetPrivacyModel gRW;
    private ForumManageModel gRX;
    private com.baidu.tieba.callfans.a gRZ;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean gRY = false;
    private k.b gSa = new k.b() { // from class: com.baidu.tieba.card.p.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            p.this.bOw();
            if (p.this.gRR == null || !p.this.gRR.isPrivacy) {
                if (p.this.gRR != null && p.this.gRR.aPS() != null) {
                    p.this.gRZ.setThreadId(p.this.gRR.aPS().getTid());
                }
                p.this.gRZ.bNW();
                return;
            }
            p.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
        }
    };
    private SetPrivacyModel.a gSb = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.gRR.isPrivacy) {
                p.this.gRR.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.thread_has_open);
                if (p.this.gRT != null) {
                    p.this.gRT.setText(p.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (p.this.gRQ != null) {
                    p.this.gRQ.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.gRR.isPrivacy = true;
            if (p.this.gRT != null) {
                p.this.gRT.setText(p.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (p.this.gRQ != null) {
                p.this.gRQ.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.gRR.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private k.b gSc = new k.b() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                return;
            }
            if (p.this.gRR.isPrivacy) {
                if (p.this.gRR.from == 1) {
                    TiebaStatic.log(new ao("c12599").ag("obj_type", 2));
                }
            } else if (p.this.gRR.from != 1) {
                if (p.this.gRR.from == 3) {
                    TiebaStatic.log(new ao("c12600").ag("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ao("c12599").ag("obj_type", 1));
            }
            if (p.this.gRW == null) {
                p.this.gRW = new SetPrivacyModel(p.this.mPageContext, p.this.gRR);
            }
            if (!p.this.gRW.isRunning()) {
                p.this.gRW.a(p.this.gSb);
                p.this.gRW.LoadData();
            }
            p.this.bOw();
        }
    };
    private k.b gSd = new k.b() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                return;
            }
            if (p.this.gRR != null && p.this.gRX != null) {
                p.this.bOx();
                p.this.gRP.aUN();
            }
            p.this.bOw();
        }
    };
    private com.baidu.adp.base.d gSe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.delete_success);
                    if (p.this.gRR != null) {
                        if (ar.isEmpty(p.this.gRR.gVx)) {
                            if (!ar.isEmpty(p.this.gRR.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.gRR.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, p.this.gRR.gVx));
                    }
                } else if (!ar.isEmpty(bVar.lIA)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.lIA);
                } else {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public p(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.gRS = new ArrayList();
            this.gRO = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.gRX = new ForumManageModel(this.mPageContext);
            this.gRX.setLoadDataCallBack(this.gSe);
            this.gRZ = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.gRO != null) {
            this.gRO.onChangeSkinType();
        }
        if (this.gRP != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.gRP.getRealView());
        }
    }

    public void create() {
        if (this.gRN == null) {
            this.gRT = new com.baidu.tbadk.core.dialog.g(this.gRO);
            this.gRT.a(this.gSc);
            if (!this.gRY) {
                this.gRS.add(this.gRT);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.gRY) {
                this.gRU = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.gRO);
                this.gRU.a(this.gSa);
                this.gRS.add(this.gRU);
            }
            this.gRV = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.gRO);
            this.gRV.a(this.gSd);
            this.gRS.add(this.gRV);
            this.gRO.a(new k.a() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    p.this.bOw();
                }
            });
            this.gRO.aL(this.gRS);
            this.gRN = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.gRO);
        }
    }

    public void a(a aVar) {
        this.gRQ = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.gRR = cardPersonDynamicThreadData;
        if (this.gRR != null && this.gRT != null) {
            if (this.gRR.isPrivacy) {
                this.gRT.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.gRT.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.gRU != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.gRU.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.gRR.aPS() != null && TbSingleton.getInstance().mCallFansTid.equals(this.gRR.aPS().getTid())) {
                    this.gRU.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.gRU.setText(this.mContext.getString(R.string.call_fans));
                }
                this.gRU.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.gRN != null) {
            this.gRN.showDialog();
        }
    }

    public void bOw() {
        if (this.gRN != null && this.gRN.isShowing()) {
            this.gRN.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOx() {
        if (this.gRP == null) {
            this.gRP = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.gRY) {
                this.gRP.kT(R.string.del_dynamic_confirm);
            } else {
                this.gRP.kT(R.string.del_thread_confirm);
            }
            this.gRP.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (p.this.gRR.from != 1) {
                        if (p.this.gRR.from == 3) {
                            TiebaStatic.log(new ao("c12600").ag("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ao("c12599").ag("obj_type", 3));
                    }
                    if (p.this.gRY) {
                        p.this.gRX.aY(p.this.gRR.dLi);
                    }
                    p.this.gRX.a(p.this.gRR.forumId, p.this.gRR.forumName, p.this.gRR.threadId, p.this.gRR.postId, 0, 0, true, p.this.gRR.dLi.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.gRP.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gRP.hf(true);
            this.gRP.b(this.mPageContext);
        }
    }

    public void lZ(boolean z) {
        this.gRY = z;
    }
}
