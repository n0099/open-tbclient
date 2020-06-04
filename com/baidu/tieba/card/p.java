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
    private com.baidu.tbadk.core.dialog.i gEX;
    private com.baidu.tbadk.core.dialog.k gEY;
    private com.baidu.tbadk.core.dialog.a gEZ;
    private a gFa;
    private CardPersonDynamicThreadData gFb;
    private List<com.baidu.tbadk.core.dialog.g> gFc;
    private com.baidu.tbadk.core.dialog.g gFd;
    private com.baidu.tbadk.core.dialog.g gFe;
    private SetPrivacyModel gFf;
    private ForumManageModel gFg;
    private boolean gFh = false;
    private SetPrivacyModel.a gFi = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.gFb.isPrivacy) {
                p.this.gFb.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.thread_has_open);
                if (p.this.gFd != null) {
                    p.this.gFd.setText(p.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (p.this.gFa != null) {
                    p.this.gFa.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.gFb.isPrivacy = true;
            if (p.this.gFd != null) {
                p.this.gFd.setText(p.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (p.this.gFa != null) {
                p.this.gFa.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.gFb.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private k.b gFj = new k.b() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                return;
            }
            if (p.this.gFb.isPrivacy) {
                if (p.this.gFb.from == 1) {
                    TiebaStatic.log(new an("c12599").ag("obj_type", 2));
                }
            } else if (p.this.gFb.from != 1) {
                if (p.this.gFb.from == 3) {
                    TiebaStatic.log(new an("c12600").ag("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").ag("obj_type", 1));
            }
            if (p.this.gFf == null) {
                p.this.gFf = new SetPrivacyModel(p.this.mPageContext, p.this.gFb);
            }
            if (!p.this.gFf.isRunning()) {
                p.this.gFf.a(p.this.gFi);
                p.this.gFf.LoadData();
            }
            p.this.bLn();
        }
    };
    private k.b gFk = new k.b() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                return;
            }
            if (p.this.gFb != null && p.this.gFg != null) {
                p.this.bLo();
                p.this.gEZ.aST();
            }
            p.this.bLn();
        }
    };
    private com.baidu.adp.base.d gFl = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.delete_success);
                    if (p.this.gFb != null) {
                        if (aq.isEmpty(p.this.gFb.gIx)) {
                            if (!aq.isEmpty(p.this.gFb.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.gFb.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, p.this.gFb.gIx));
                    }
                } else if (!aq.isEmpty(bVar.loP)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.loP);
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
            this.gFc = new ArrayList();
            this.gEY = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.gFg = new ForumManageModel(this.mPageContext);
            this.gFg.setLoadDataCallBack(this.gFl);
        }
    }

    public void onChangeSkinType() {
        if (this.gEY != null) {
            this.gEY.onChangeSkinType();
        }
        if (this.gEZ != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.gEZ.getRealView());
        }
    }

    public void create() {
        if (this.gEX == null) {
            this.gFd = new com.baidu.tbadk.core.dialog.g(this.gEY);
            this.gFd.a(this.gFj);
            if (!this.gFh) {
                this.gFc.add(this.gFd);
            }
            this.gFe = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.gEY);
            this.gFe.a(this.gFk);
            this.gFc.add(this.gFe);
            this.gEY.a(new k.a() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    p.this.bLn();
                }
            });
            this.gEY.aD(this.gFc);
            this.gEX = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.gEY);
        }
    }

    public void a(a aVar) {
        this.gFa = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.gFb = cardPersonDynamicThreadData;
        if (this.gFb != null && this.gFd != null) {
            if (this.gFb.isPrivacy) {
                this.gFd.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.gFd.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.gEX != null) {
            this.gEX.showDialog();
        }
    }

    public void bLn() {
        if (this.gEX != null && this.gEX.isShowing()) {
            this.gEX.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLo() {
        if (this.gEZ == null) {
            this.gEZ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.gFh) {
                this.gEZ.kF(R.string.del_dynamic_confirm);
            } else {
                this.gEZ.kF(R.string.del_thread_confirm);
            }
            this.gEZ.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (p.this.gFb.from != 1) {
                        if (p.this.gFb.from == 3) {
                            TiebaStatic.log(new an("c12600").ag("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").ag("obj_type", 3));
                    }
                    if (p.this.gFh) {
                        p.this.gFg.aX(p.this.gFb.dEA);
                    }
                    p.this.gFg.a(p.this.gFb.forumId, p.this.gFb.forumName, p.this.gFb.threadId, p.this.gFb.postId, 0, 0, true, p.this.gFb.dEA.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.gEZ.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gEZ.gW(true);
            this.gEZ.b(this.mPageContext);
        }
    }

    public void lQ(boolean z) {
        this.gFh = z;
    }
}
