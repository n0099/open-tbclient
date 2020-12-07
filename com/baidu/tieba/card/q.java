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
    private ForumManageModel fXb;
    private com.baidu.tbadk.core.dialog.i ikd;
    private com.baidu.tbadk.core.dialog.k ike;
    private com.baidu.tbadk.core.dialog.a ikf;
    private a ikg;
    private CardPersonDynamicThreadData ikh;
    private List<com.baidu.tbadk.core.dialog.g> iki;
    private com.baidu.tbadk.core.dialog.g ikj;
    private com.baidu.tbadk.core.dialog.g ikk;
    private com.baidu.tbadk.core.dialog.g ikl;
    private SetPrivacyModel ikm;
    private com.baidu.tieba.callfans.a iko;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean ikn = false;
    private k.b ikp = new k.b() { // from class: com.baidu.tieba.card.q.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (q.this.ikh != null) {
                q.this.csb();
                if (q.this.ikh.from == 1) {
                    i = 2;
                } else {
                    i = q.this.ikh.from == 3 ? 1 : 1;
                }
                if (q.this.ikh == null || !q.this.ikh.isPrivacy) {
                    if (q.this.ikh.bmn() != null) {
                        q.this.iko.setThreadId(q.this.ikh.bmn().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && q.this.ikh.bmn() != null && TbSingleton.getInstance().mCallFansTid.equals(q.this.ikh.bmn().getTid())) {
                        i2 = 2;
                    }
                    q.this.iko.crC();
                    if (q.this.ikh.bmn() != null) {
                        q.this.iko.l(i, i2, q.this.ikh.bmn().getTid());
                        return;
                    }
                    return;
                }
                q.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (q.this.ikh.bmn() != null) {
                    q.this.iko.l(i, 3, q.this.ikh.bmn().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a ikq = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.ikh.isPrivacy) {
                q.this.ikh.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.thread_has_open);
                if (q.this.ikj != null) {
                    q.this.ikj.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.ikg != null) {
                    q.this.ikg.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.ikh.isPrivacy = true;
            if (q.this.ikj != null) {
                q.this.ikj.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.ikg != null) {
                q.this.ikg.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, q.this.ikh.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b ikr = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.ikh.isPrivacy) {
                if (q.this.ikh.from == 1) {
                    TiebaStatic.log(new ar("c12599").al("obj_type", 2));
                }
            } else if (q.this.ikh.from != 1) {
                if (q.this.ikh.from == 3) {
                    TiebaStatic.log(new ar("c12600").al("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ar("c12599").al("obj_type", 1));
            }
            if (q.this.ikm == null) {
                q.this.ikm = new SetPrivacyModel(q.this.mPageContext, q.this.ikh);
            }
            if (!q.this.ikm.isRunning()) {
                q.this.ikm.a(q.this.ikq);
                q.this.ikm.LoadData();
            }
            q.this.csb();
        }
    };
    private k.b iks = new k.b() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.ikh != null && q.this.fXb != null) {
                q.this.csc();
                q.this.ikf.brv();
            }
            q.this.csb();
        }
    };
    private com.baidu.adp.base.d ikt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_success);
                    if (q.this.ikh != null) {
                        if (au.isEmpty(q.this.ikh.ioc)) {
                            if (!au.isEmpty(q.this.ikh.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, q.this.ikh.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.ikh.ioc));
                    }
                } else if (!au.isEmpty(bVar.noI)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.noI);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_fail);
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
            this.iki = new ArrayList();
            this.ike = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.fXb = new ForumManageModel(this.mPageContext);
            this.fXb.setLoadDataCallBack(this.ikt);
            this.iko = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.ike != null) {
            this.ike.onChangeSkinType();
        }
        if (this.ikf != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.ikf.getRealView());
        }
    }

    public void create() {
        if (this.ikd == null) {
            this.ikj = new com.baidu.tbadk.core.dialog.g(this.ike);
            this.ikj.a(this.ikr);
            if (!this.ikn) {
                this.iki.add(this.ikj);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.ikn) {
                this.ikk = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.ike);
                this.ikk.a(this.ikp);
                this.iki.add(this.ikk);
            }
            this.ikl = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.ike);
            this.ikl.a(this.iks);
            this.iki.add(this.ikl);
            this.ike.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.csb();
                }
            });
            this.ike.bu(this.iki);
            this.ikd = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.ike);
        }
    }

    public void a(a aVar) {
        this.ikg = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.ikh = cardPersonDynamicThreadData;
        if (this.ikh != null && this.ikj != null) {
            if (this.ikh.isPrivacy) {
                this.ikj.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.ikj.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.ikk != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.ikk.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.ikh.bmn() != null && TbSingleton.getInstance().mCallFansTid.equals(this.ikh.bmn().getTid())) {
                    this.ikk.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.ikk.setText(this.mContext.getString(R.string.call_fans));
                }
                this.ikk.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.ikd != null) {
            this.ikd.RU();
        }
    }

    public void csb() {
        if (this.ikd != null && this.ikd.isShowing()) {
            this.ikd.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csc() {
        if (this.ikf == null) {
            this.ikf = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.ikn) {
                this.ikf.oQ(R.string.del_dynamic_confirm);
            } else {
                this.ikf.oQ(R.string.del_thread_confirm);
            }
            this.ikf.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                        return;
                    }
                    if (q.this.ikh.from != 1) {
                        if (q.this.ikh.from == 3) {
                            TiebaStatic.log(new ar("c12600").al("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ar("c12599").al("obj_type", 3));
                    }
                    if (q.this.ikn) {
                        q.this.fXb.aZ(q.this.ikh.eCR);
                    }
                    q.this.fXb.a(q.this.ikh.forumId, q.this.ikh.forumName, q.this.ikh.threadId, q.this.ikh.postId, 0, 0, true, q.this.ikh.eCR.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.ikf.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ikf.jl(true);
            this.ikf.b(this.mPageContext);
        }
    }

    public void oU(boolean z) {
        this.ikn = z;
    }
}
