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
/* loaded from: classes11.dex */
public class p {
    private com.baidu.tbadk.core.dialog.i gEM;
    private com.baidu.tbadk.core.dialog.k gEN;
    private com.baidu.tbadk.core.dialog.a gEO;
    private a gEP;
    private CardPersonDynamicThreadData gEQ;
    private List<com.baidu.tbadk.core.dialog.g> gER;
    private com.baidu.tbadk.core.dialog.g gES;
    private com.baidu.tbadk.core.dialog.g gET;
    private SetPrivacyModel gEU;
    private ForumManageModel gEV;
    private boolean gEW = false;
    private SetPrivacyModel.a gEX = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.gEQ.isPrivacy) {
                p.this.gEQ.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.thread_has_open);
                if (p.this.gES != null) {
                    p.this.gES.setText(p.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (p.this.gEP != null) {
                    p.this.gEP.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.gEQ.isPrivacy = true;
            if (p.this.gES != null) {
                p.this.gES.setText(p.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (p.this.gEP != null) {
                p.this.gEP.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.gEQ.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private k.b gEY = new k.b() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                return;
            }
            if (p.this.gEQ.isPrivacy) {
                if (p.this.gEQ.from == 1) {
                    TiebaStatic.log(new an("c12599").ag("obj_type", 2));
                }
            } else if (p.this.gEQ.from != 1) {
                if (p.this.gEQ.from == 3) {
                    TiebaStatic.log(new an("c12600").ag("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").ag("obj_type", 1));
            }
            if (p.this.gEU == null) {
                p.this.gEU = new SetPrivacyModel(p.this.mPageContext, p.this.gEQ);
            }
            if (!p.this.gEU.isRunning()) {
                p.this.gEU.a(p.this.gEX);
                p.this.gEU.LoadData();
            }
            p.this.bLl();
        }
    };
    private k.b gEZ = new k.b() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                return;
            }
            if (p.this.gEQ != null && p.this.gEV != null) {
                p.this.bLm();
                p.this.gEO.aST();
            }
            p.this.bLl();
        }
    };
    private com.baidu.adp.base.d gFa = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.delete_success);
                    if (p.this.gEQ != null) {
                        if (aq.isEmpty(p.this.gEQ.gIm)) {
                            if (!aq.isEmpty(p.this.gEQ.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.gEQ.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, p.this.gEQ.gIm));
                    }
                } else if (!aq.isEmpty(bVar.lnC)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.lnC);
                } else {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.delete_fail);
                }
            }
        }
    };
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public p(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.gER = new ArrayList();
            this.gEN = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.gEV = new ForumManageModel(this.mPageContext);
            this.gEV.setLoadDataCallBack(this.gFa);
        }
    }

    public void onChangeSkinType() {
        if (this.gEN != null) {
            this.gEN.onChangeSkinType();
        }
        if (this.gEO != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.gEO.getRealView());
        }
    }

    public void create() {
        if (this.gEM == null) {
            this.gES = new com.baidu.tbadk.core.dialog.g(this.gEN);
            this.gES.a(this.gEY);
            if (!this.gEW) {
                this.gER.add(this.gES);
            }
            this.gET = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.gEN);
            this.gET.a(this.gEZ);
            this.gER.add(this.gET);
            this.gEN.a(new k.a() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    p.this.bLl();
                }
            });
            this.gEN.aD(this.gER);
            this.gEM = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.gEN);
        }
    }

    public void a(a aVar) {
        this.gEP = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.gEQ = cardPersonDynamicThreadData;
        if (this.gEQ != null && this.gES != null) {
            if (this.gEQ.isPrivacy) {
                this.gES.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.gES.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.gEM != null) {
            this.gEM.showDialog();
        }
    }

    public void bLl() {
        if (this.gEM != null && this.gEM.isShowing()) {
            this.gEM.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLm() {
        if (this.gEO == null) {
            this.gEO = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.gEW) {
                this.gEO.kD(R.string.del_dynamic_confirm);
            } else {
                this.gEO.kD(R.string.del_thread_confirm);
            }
            this.gEO.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (p.this.gEQ.from != 1) {
                        if (p.this.gEQ.from == 3) {
                            TiebaStatic.log(new an("c12600").ag("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").ag("obj_type", 3));
                    }
                    if (p.this.gEW) {
                        p.this.gEV.aX(p.this.gEQ.dEA);
                    }
                    p.this.gEV.a(p.this.gEQ.forumId, p.this.gEQ.forumName, p.this.gEQ.threadId, p.this.gEQ.postId, 0, 0, true, p.this.gEQ.dEA.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.gEO.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gEO.gW(true);
            this.gEO.b(this.mPageContext);
        }
    }

    public void lQ(boolean z) {
        this.gEW = z;
    }
}
