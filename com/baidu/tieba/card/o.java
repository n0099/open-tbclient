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
public class o {
    private com.baidu.tbadk.core.dialog.i fKC;
    private com.baidu.tbadk.core.dialog.k fKD;
    private com.baidu.tbadk.core.dialog.a fKE;
    private a fKF;
    private CardPersonDynamicThreadData fKG;
    private List<com.baidu.tbadk.core.dialog.g> fKH;
    private com.baidu.tbadk.core.dialog.g fKI;
    private com.baidu.tbadk.core.dialog.g fKJ;
    private SetPrivacyModel fKK;
    private ForumManageModel fKL;
    private boolean fKM = false;
    private SetPrivacyModel.a fKN = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.o.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (o.this.fKG.isPrivacy) {
                o.this.fKG.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.thread_has_open);
                if (o.this.fKI != null) {
                    o.this.fKI.setText(o.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (o.this.fKF != null) {
                    o.this.fKF.setPrivacy(false);
                    return;
                }
                return;
            }
            o.this.fKG.isPrivacy = true;
            if (o.this.fKI != null) {
                o.this.fKI.setText(o.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (o.this.fKF != null) {
                o.this.fKF.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, o.this.fKG.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(o.this.mContext, str);
        }
    };
    private k.b fKO = new k.b() { // from class: com.baidu.tieba.card.o.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fKG.isPrivacy) {
                if (o.this.fKG.from == 1) {
                    TiebaStatic.log(new an("c12599").X("obj_type", 2));
                }
            } else if (o.this.fKG.from != 1) {
                if (o.this.fKG.from == 3) {
                    TiebaStatic.log(new an("c12600").X("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").X("obj_type", 1));
            }
            if (o.this.fKK == null) {
                o.this.fKK = new SetPrivacyModel(o.this.mPageContext, o.this.fKG);
            }
            if (!o.this.fKK.isRunning()) {
                o.this.fKK.a(o.this.fKN);
                o.this.fKK.LoadData();
            }
            o.this.bvc();
        }
    };
    private k.b fKP = new k.b() { // from class: com.baidu.tieba.card.o.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fKG != null && o.this.fKL != null) {
                o.this.bvd();
                o.this.fKE.aEC();
            }
            o.this.bvc();
        }
    };
    private com.baidu.adp.base.d fKQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.o.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_success);
                    if (o.this.fKG != null) {
                        if (aq.isEmpty(o.this.fKG.fOg)) {
                            if (!aq.isEmpty(o.this.fKG.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, o.this.fKG.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, o.this.fKG.fOg));
                    }
                } else if (!aq.isEmpty(bVar.kju)) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, bVar.kju);
                } else {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_fail);
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

    public o(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.fKH = new ArrayList();
            this.fKD = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.fKL = new ForumManageModel(this.mPageContext);
            this.fKL.setLoadDataCallBack(this.fKQ);
        }
    }

    public void onChangeSkinType() {
        if (this.fKD != null) {
            this.fKD.onChangeSkinType();
        }
        if (this.fKE != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fKE.getRealView());
        }
    }

    public void create() {
        if (this.fKC == null) {
            this.fKI = new com.baidu.tbadk.core.dialog.g(this.fKD);
            this.fKI.a(this.fKO);
            if (!this.fKM) {
                this.fKH.add(this.fKI);
            }
            this.fKJ = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fKD);
            this.fKJ.a(this.fKP);
            this.fKH.add(this.fKJ);
            this.fKD.a(new k.a() { // from class: com.baidu.tieba.card.o.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    o.this.bvc();
                }
            });
            this.fKD.az(this.fKH);
            this.fKC = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fKD);
        }
    }

    public void a(a aVar) {
        this.fKF = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.fKG = cardPersonDynamicThreadData;
        if (this.fKG != null && this.fKI != null) {
            if (this.fKG.isPrivacy) {
                this.fKI.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.fKI.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.fKC != null) {
            this.fKC.showDialog();
        }
    }

    public void bvc() {
        if (this.fKC != null && this.fKC.isShowing()) {
            this.fKC.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvd() {
        if (this.fKE == null) {
            this.fKE = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.fKM) {
                this.fKE.jW(R.string.del_dynamic_confirm);
            } else {
                this.fKE.jW(R.string.del_thread_confirm);
            }
            this.fKE.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.o.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (o.this.fKG.from != 1) {
                        if (o.this.fKG.from == 3) {
                            TiebaStatic.log(new an("c12600").X("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").X("obj_type", 3));
                    }
                    if (o.this.fKM) {
                        o.this.fKL.aW(o.this.fKG.cRg);
                    }
                    o.this.fKL.a(o.this.fKG.forumId, o.this.fKG.forumName, o.this.fKG.threadId, o.this.fKG.postId, 0, 0, true, o.this.fKG.cRg.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.fKE.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.o.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fKE.fG(true);
            this.fKE.b(this.mPageContext);
        }
    }

    public void km(boolean z) {
        this.fKM = z;
    }
}
