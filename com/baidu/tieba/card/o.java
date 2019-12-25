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
/* loaded from: classes8.dex */
public class o {
    private com.baidu.tbadk.core.dialog.i fEG;
    private com.baidu.tbadk.core.dialog.k fEH;
    private com.baidu.tbadk.core.dialog.a fEI;
    private a fEJ;
    private CardPersonDynamicThreadData fEK;
    private List<com.baidu.tbadk.core.dialog.g> fEL;
    private com.baidu.tbadk.core.dialog.g fEM;
    private com.baidu.tbadk.core.dialog.g fEN;
    private SetPrivacyModel fEO;
    private ForumManageModel fEP;
    private boolean fEQ = false;
    private SetPrivacyModel.a fER = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.o.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (o.this.fEK.isPrivacy) {
                o.this.fEK.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.thread_has_open);
                if (o.this.fEM != null) {
                    o.this.fEM.setText(o.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (o.this.fEJ != null) {
                    o.this.fEJ.setPrivacy(false);
                    return;
                }
                return;
            }
            o.this.fEK.isPrivacy = true;
            if (o.this.fEM != null) {
                o.this.fEM.setText(o.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (o.this.fEJ != null) {
                o.this.fEJ.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, o.this.fEK.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(o.this.mContext, str);
        }
    };
    private k.b fES = new k.b() { // from class: com.baidu.tieba.card.o.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fEK.isPrivacy) {
                if (o.this.fEK.from == 1) {
                    TiebaStatic.log(new an("c12599").Z("obj_type", 2));
                }
            } else if (o.this.fEK.from != 1) {
                if (o.this.fEK.from == 3) {
                    TiebaStatic.log(new an("c12600").Z("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").Z("obj_type", 1));
            }
            if (o.this.fEO == null) {
                o.this.fEO = new SetPrivacyModel(o.this.mPageContext, o.this.fEK);
            }
            if (!o.this.fEO.isRunning()) {
                o.this.fEO.a(o.this.fER);
                o.this.fEO.LoadData();
            }
            o.this.bst();
        }
    };
    private k.b fET = new k.b() { // from class: com.baidu.tieba.card.o.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fEK != null && o.this.fEP != null) {
                o.this.bsu();
                o.this.fEI.aBW();
            }
            o.this.bst();
        }
    };
    private com.baidu.adp.base.d fEU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.o.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_success);
                    if (o.this.fEK != null) {
                        if (aq.isEmpty(o.this.fEK.fIl)) {
                            if (!aq.isEmpty(o.this.fEK.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, o.this.fEK.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, o.this.fEK.fIl));
                    }
                } else if (!aq.isEmpty(bVar.kew)) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, bVar.kew);
                } else {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_fail);
                }
            }
        }
    };
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes8.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public o(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.fEL = new ArrayList();
            this.fEH = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.fEP = new ForumManageModel(this.mPageContext);
            this.fEP.setLoadDataCallBack(this.fEU);
        }
    }

    public void onChangeSkinType() {
        if (this.fEH != null) {
            this.fEH.onChangeSkinType();
        }
        if (this.fEI != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fEI.getRealView());
        }
    }

    public void create() {
        if (this.fEG == null) {
            this.fEM = new com.baidu.tbadk.core.dialog.g(this.fEH);
            this.fEM.a(this.fES);
            if (!this.fEQ) {
                this.fEL.add(this.fEM);
            }
            this.fEN = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fEH);
            this.fEN.a(this.fET);
            this.fEL.add(this.fEN);
            this.fEH.a(new k.a() { // from class: com.baidu.tieba.card.o.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    o.this.bst();
                }
            });
            this.fEH.aA(this.fEL);
            this.fEG = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fEH);
        }
    }

    public void a(a aVar) {
        this.fEJ = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.fEK = cardPersonDynamicThreadData;
        if (this.fEK != null && this.fEM != null) {
            if (this.fEK.isPrivacy) {
                this.fEM.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.fEM.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.fEG != null) {
            this.fEG.showDialog();
        }
    }

    public void bst() {
        if (this.fEG != null && this.fEG.isShowing()) {
            this.fEG.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsu() {
        if (this.fEI == null) {
            this.fEI = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.fEQ) {
                this.fEI.jF(R.string.del_dynamic_confirm);
            } else {
                this.fEI.jF(R.string.del_thread_confirm);
            }
            this.fEI.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.o.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (o.this.fEK.from != 1) {
                        if (o.this.fEK.from == 3) {
                            TiebaStatic.log(new an("c12600").Z("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").Z("obj_type", 3));
                    }
                    if (o.this.fEQ) {
                        o.this.fEP.aS(o.this.fEK.cMR);
                    }
                    o.this.fEP.a(o.this.fEK.forumId, o.this.fEK.forumName, o.this.fEK.threadId, o.this.fEK.postId, 0, 0, true, o.this.fEK.cMR.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.fEI.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.o.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fEI.fu(true);
            this.fEI.b(this.mPageContext);
        }
    }

    public void jZ(boolean z) {
        this.fEQ = z;
    }
}
