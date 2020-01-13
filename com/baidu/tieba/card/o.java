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
/* loaded from: classes9.dex */
public class o {
    private com.baidu.tbadk.core.dialog.i fHQ;
    private com.baidu.tbadk.core.dialog.k fHR;
    private com.baidu.tbadk.core.dialog.a fHS;
    private a fHT;
    private CardPersonDynamicThreadData fHU;
    private List<com.baidu.tbadk.core.dialog.g> fHV;
    private com.baidu.tbadk.core.dialog.g fHW;
    private com.baidu.tbadk.core.dialog.g fHX;
    private SetPrivacyModel fHY;
    private ForumManageModel fHZ;
    private boolean fIa = false;
    private SetPrivacyModel.a fIb = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.o.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (o.this.fHU.isPrivacy) {
                o.this.fHU.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.thread_has_open);
                if (o.this.fHW != null) {
                    o.this.fHW.setText(o.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (o.this.fHT != null) {
                    o.this.fHT.setPrivacy(false);
                    return;
                }
                return;
            }
            o.this.fHU.isPrivacy = true;
            if (o.this.fHW != null) {
                o.this.fHW.setText(o.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (o.this.fHT != null) {
                o.this.fHT.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, o.this.fHU.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(o.this.mContext, str);
        }
    };
    private k.b fIc = new k.b() { // from class: com.baidu.tieba.card.o.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fHU.isPrivacy) {
                if (o.this.fHU.from == 1) {
                    TiebaStatic.log(new an("c12599").Z("obj_type", 2));
                }
            } else if (o.this.fHU.from != 1) {
                if (o.this.fHU.from == 3) {
                    TiebaStatic.log(new an("c12600").Z("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").Z("obj_type", 1));
            }
            if (o.this.fHY == null) {
                o.this.fHY = new SetPrivacyModel(o.this.mPageContext, o.this.fHU);
            }
            if (!o.this.fHY.isRunning()) {
                o.this.fHY.a(o.this.fIb);
                o.this.fHY.LoadData();
            }
            o.this.btv();
        }
    };
    private k.b fId = new k.b() { // from class: com.baidu.tieba.card.o.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fHU != null && o.this.fHZ != null) {
                o.this.btw();
                o.this.fHS.aCp();
            }
            o.this.btv();
        }
    };
    private com.baidu.adp.base.d fIe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.o.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_success);
                    if (o.this.fHU != null) {
                        if (aq.isEmpty(o.this.fHU.fLv)) {
                            if (!aq.isEmpty(o.this.fHU.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, o.this.fHU.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, o.this.fHU.fLv));
                    }
                } else if (!aq.isEmpty(bVar.khZ)) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, bVar.khZ);
                } else {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_fail);
                }
            }
        }
    };
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public o(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.fHV = new ArrayList();
            this.fHR = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.fHZ = new ForumManageModel(this.mPageContext);
            this.fHZ.setLoadDataCallBack(this.fIe);
        }
    }

    public void onChangeSkinType() {
        if (this.fHR != null) {
            this.fHR.onChangeSkinType();
        }
        if (this.fHS != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fHS.getRealView());
        }
    }

    public void create() {
        if (this.fHQ == null) {
            this.fHW = new com.baidu.tbadk.core.dialog.g(this.fHR);
            this.fHW.a(this.fIc);
            if (!this.fIa) {
                this.fHV.add(this.fHW);
            }
            this.fHX = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fHR);
            this.fHX.a(this.fId);
            this.fHV.add(this.fHX);
            this.fHR.a(new k.a() { // from class: com.baidu.tieba.card.o.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    o.this.btv();
                }
            });
            this.fHR.az(this.fHV);
            this.fHQ = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fHR);
        }
    }

    public void a(a aVar) {
        this.fHT = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.fHU = cardPersonDynamicThreadData;
        if (this.fHU != null && this.fHW != null) {
            if (this.fHU.isPrivacy) {
                this.fHW.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.fHW.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.fHQ != null) {
            this.fHQ.showDialog();
        }
    }

    public void btv() {
        if (this.fHQ != null && this.fHQ.isShowing()) {
            this.fHQ.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btw() {
        if (this.fHS == null) {
            this.fHS = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.fIa) {
                this.fHS.jF(R.string.del_dynamic_confirm);
            } else {
                this.fHS.jF(R.string.del_thread_confirm);
            }
            this.fHS.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.o.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (o.this.fHU.from != 1) {
                        if (o.this.fHU.from == 3) {
                            TiebaStatic.log(new an("c12600").Z("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").Z("obj_type", 3));
                    }
                    if (o.this.fIa) {
                        o.this.fHZ.aT(o.this.fHU.cNb);
                    }
                    o.this.fHZ.a(o.this.fHU.forumId, o.this.fHU.forumName, o.this.fHU.threadId, o.this.fHU.postId, 0, 0, true, o.this.fHU.cNb.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.fHS.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.o.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fHS.fz(true);
            this.fHS.b(this.mPageContext);
        }
    }

    public void kk(boolean z) {
        this.fIa = z;
    }
}
