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
/* loaded from: classes24.dex */
public class q {
    private ForumManageModel fXd;
    private com.baidu.tbadk.core.dialog.i ikf;
    private com.baidu.tbadk.core.dialog.k ikg;
    private com.baidu.tbadk.core.dialog.a ikh;
    private a iki;
    private CardPersonDynamicThreadData ikj;
    private List<com.baidu.tbadk.core.dialog.g> ikk;
    private com.baidu.tbadk.core.dialog.g ikl;
    private com.baidu.tbadk.core.dialog.g ikm;
    private com.baidu.tbadk.core.dialog.g ikn;
    private SetPrivacyModel iko;
    private com.baidu.tieba.callfans.a ikq;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean ikp = false;
    private k.b ikr = new k.b() { // from class: com.baidu.tieba.card.q.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (q.this.ikj != null) {
                q.this.csc();
                if (q.this.ikj.from == 1) {
                    i = 2;
                } else {
                    i = q.this.ikj.from == 3 ? 1 : 1;
                }
                if (q.this.ikj == null || !q.this.ikj.isPrivacy) {
                    if (q.this.ikj.bmn() != null) {
                        q.this.ikq.setThreadId(q.this.ikj.bmn().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && q.this.ikj.bmn() != null && TbSingleton.getInstance().mCallFansTid.equals(q.this.ikj.bmn().getTid())) {
                        i2 = 2;
                    }
                    q.this.ikq.crD();
                    if (q.this.ikj.bmn() != null) {
                        q.this.ikq.l(i, i2, q.this.ikj.bmn().getTid());
                        return;
                    }
                    return;
                }
                q.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (q.this.ikj.bmn() != null) {
                    q.this.ikq.l(i, 3, q.this.ikj.bmn().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a iks = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.ikj.isPrivacy) {
                q.this.ikj.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.thread_has_open);
                if (q.this.ikl != null) {
                    q.this.ikl.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.iki != null) {
                    q.this.iki.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.ikj.isPrivacy = true;
            if (q.this.ikl != null) {
                q.this.ikl.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.iki != null) {
                q.this.iki.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, q.this.ikj.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b ikt = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.ikj.isPrivacy) {
                if (q.this.ikj.from == 1) {
                    TiebaStatic.log(new ar("c12599").al("obj_type", 2));
                }
            } else if (q.this.ikj.from != 1) {
                if (q.this.ikj.from == 3) {
                    TiebaStatic.log(new ar("c12600").al("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ar("c12599").al("obj_type", 1));
            }
            if (q.this.iko == null) {
                q.this.iko = new SetPrivacyModel(q.this.mPageContext, q.this.ikj);
            }
            if (!q.this.iko.isRunning()) {
                q.this.iko.a(q.this.iks);
                q.this.iko.LoadData();
            }
            q.this.csc();
        }
    };
    private k.b iku = new k.b() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.ikj != null && q.this.fXd != null) {
                q.this.csd();
                q.this.ikh.brv();
            }
            q.this.csc();
        }
    };
    private com.baidu.adp.base.d ikv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_success);
                    if (q.this.ikj != null) {
                        if (au.isEmpty(q.this.ikj.ioe)) {
                            if (!au.isEmpty(q.this.ikj.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, q.this.ikj.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.ikj.ioe));
                    }
                } else if (!au.isEmpty(bVar.noK)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.noK);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_fail);
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
            this.ikk = new ArrayList();
            this.ikg = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.fXd = new ForumManageModel(this.mPageContext);
            this.fXd.setLoadDataCallBack(this.ikv);
            this.ikq = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.ikg != null) {
            this.ikg.onChangeSkinType();
        }
        if (this.ikh != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.ikh.getRealView());
        }
    }

    public void create() {
        if (this.ikf == null) {
            this.ikl = new com.baidu.tbadk.core.dialog.g(this.ikg);
            this.ikl.a(this.ikt);
            if (!this.ikp) {
                this.ikk.add(this.ikl);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.ikp) {
                this.ikm = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.ikg);
                this.ikm.a(this.ikr);
                this.ikk.add(this.ikm);
            }
            this.ikn = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.ikg);
            this.ikn.a(this.iku);
            this.ikk.add(this.ikn);
            this.ikg.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.csc();
                }
            });
            this.ikg.bu(this.ikk);
            this.ikf = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.ikg);
        }
    }

    public void a(a aVar) {
        this.iki = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.ikj = cardPersonDynamicThreadData;
        if (this.ikj != null && this.ikl != null) {
            if (this.ikj.isPrivacy) {
                this.ikl.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.ikl.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.ikm != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.ikm.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.ikj.bmn() != null && TbSingleton.getInstance().mCallFansTid.equals(this.ikj.bmn().getTid())) {
                    this.ikm.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.ikm.setText(this.mContext.getString(R.string.call_fans));
                }
                this.ikm.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.ikf != null) {
            this.ikf.RU();
        }
    }

    public void csc() {
        if (this.ikf != null && this.ikf.isShowing()) {
            this.ikf.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csd() {
        if (this.ikh == null) {
            this.ikh = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.ikp) {
                this.ikh.oQ(R.string.del_dynamic_confirm);
            } else {
                this.ikh.oQ(R.string.del_thread_confirm);
            }
            this.ikh.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (q.this.ikj.from != 1) {
                        if (q.this.ikj.from == 3) {
                            TiebaStatic.log(new ar("c12600").al("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ar("c12599").al("obj_type", 3));
                    }
                    if (q.this.ikp) {
                        q.this.fXd.aZ(q.this.ikj.eCR);
                    }
                    q.this.fXd.a(q.this.ikj.forumId, q.this.ikj.forumName, q.this.ikj.threadId, q.this.ikj.postId, 0, 0, true, q.this.ikj.eCR.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.ikh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ikh.jl(true);
            this.ikh.b(this.mPageContext);
        }
    }

    public void oU(boolean z) {
        this.ikp = z;
    }
}
