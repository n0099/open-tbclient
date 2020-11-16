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
/* loaded from: classes23.dex */
public class q {
    private com.baidu.tbadk.core.dialog.i hZg;
    private com.baidu.tbadk.core.dialog.k hZh;
    private com.baidu.tbadk.core.dialog.a hZi;
    private a hZj;
    private CardPersonDynamicThreadData hZk;
    private List<com.baidu.tbadk.core.dialog.g> hZl;
    private com.baidu.tbadk.core.dialog.g hZm;
    private com.baidu.tbadk.core.dialog.g hZn;
    private com.baidu.tbadk.core.dialog.g hZo;
    private SetPrivacyModel hZp;
    private ForumManageModel hZq;
    private com.baidu.tieba.callfans.a hZs;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean hZr = false;
    private k.b hZt = new k.b() { // from class: com.baidu.tieba.card.q.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (q.this.hZk != null) {
                q.this.cnO();
                if (q.this.hZk.from == 1) {
                    i = 2;
                } else {
                    i = q.this.hZk.from == 3 ? 1 : 1;
                }
                if (q.this.hZk == null || !q.this.hZk.isPrivacy) {
                    if (q.this.hZk.bjd() != null) {
                        q.this.hZs.setThreadId(q.this.hZk.bjd().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && q.this.hZk.bjd() != null && TbSingleton.getInstance().mCallFansTid.equals(q.this.hZk.bjd().getTid())) {
                        i2 = 2;
                    }
                    q.this.hZs.cnp();
                    if (q.this.hZk.bjd() != null) {
                        q.this.hZs.k(i, i2, q.this.hZk.bjd().getTid());
                        return;
                    }
                    return;
                }
                q.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (q.this.hZk.bjd() != null) {
                    q.this.hZs.k(i, 3, q.this.hZk.bjd().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a hZu = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.hZk.isPrivacy) {
                q.this.hZk.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.thread_has_open);
                if (q.this.hZm != null) {
                    q.this.hZm.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.hZj != null) {
                    q.this.hZj.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.hZk.isPrivacy = true;
            if (q.this.hZm != null) {
                q.this.hZm.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.hZj != null) {
                q.this.hZj.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, q.this.hZk.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b hZv = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.hZk.isPrivacy) {
                if (q.this.hZk.from == 1) {
                    TiebaStatic.log(new ar("c12599").ak("obj_type", 2));
                }
            } else if (q.this.hZk.from != 1) {
                if (q.this.hZk.from == 3) {
                    TiebaStatic.log(new ar("c12600").ak("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ar("c12599").ak("obj_type", 1));
            }
            if (q.this.hZp == null) {
                q.this.hZp = new SetPrivacyModel(q.this.mPageContext, q.this.hZk);
            }
            if (!q.this.hZp.isRunning()) {
                q.this.hZp.a(q.this.hZu);
                q.this.hZp.LoadData();
            }
            q.this.cnO();
        }
    };
    private k.b hZw = new k.b() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.hZk != null && q.this.hZq != null) {
                q.this.cnP();
                q.this.hZi.bog();
            }
            q.this.cnO();
        }
    };
    private com.baidu.adp.base.d hZx = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_success);
                    if (q.this.hZk != null) {
                        if (au.isEmpty(q.this.hZk.ide)) {
                            if (!au.isEmpty(q.this.hZk.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, q.this.hZk.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.hZk.ide));
                    }
                } else if (!au.isEmpty(bVar.naF)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.naF);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes23.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public q(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.hZl = new ArrayList();
            this.hZh = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.hZq = new ForumManageModel(this.mPageContext);
            this.hZq.setLoadDataCallBack(this.hZx);
            this.hZs = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.hZh != null) {
            this.hZh.onChangeSkinType();
        }
        if (this.hZi != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hZi.getRealView());
        }
    }

    public void create() {
        if (this.hZg == null) {
            this.hZm = new com.baidu.tbadk.core.dialog.g(this.hZh);
            this.hZm.a(this.hZv);
            if (!this.hZr) {
                this.hZl.add(this.hZm);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.hZr) {
                this.hZn = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.hZh);
                this.hZn.a(this.hZt);
                this.hZl.add(this.hZn);
            }
            this.hZo = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.hZh);
            this.hZo.a(this.hZw);
            this.hZl.add(this.hZo);
            this.hZh.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.cnO();
                }
            });
            this.hZh.br(this.hZl);
            this.hZg = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.hZh);
        }
    }

    public void a(a aVar) {
        this.hZj = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.hZk = cardPersonDynamicThreadData;
        if (this.hZk != null && this.hZm != null) {
            if (this.hZk.isPrivacy) {
                this.hZm.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.hZm.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.hZn != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.hZn.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.hZk.bjd() != null && TbSingleton.getInstance().mCallFansTid.equals(this.hZk.bjd().getTid())) {
                    this.hZn.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.hZn.setText(this.mContext.getString(R.string.call_fans));
                }
                this.hZn.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.hZg != null) {
            this.hZg.PA();
        }
    }

    public void cnO() {
        if (this.hZg != null && this.hZg.isShowing()) {
            this.hZg.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnP() {
        if (this.hZi == null) {
            this.hZi = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.hZr) {
                this.hZi.os(R.string.del_dynamic_confirm);
            } else {
                this.hZi.os(R.string.del_thread_confirm);
            }
            this.hZi.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                        return;
                    }
                    if (q.this.hZk.from != 1) {
                        if (q.this.hZk.from == 3) {
                            TiebaStatic.log(new ar("c12600").ak("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ar("c12599").ak("obj_type", 3));
                    }
                    if (q.this.hZr) {
                        q.this.hZq.aZ(q.this.hZk.evQ);
                    }
                    q.this.hZq.a(q.this.hZk.forumId, q.this.hZk.forumName, q.this.hZk.threadId, q.this.hZk.postId, 0, 0, true, q.this.hZk.evQ.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.hZi.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hZi.iW(true);
            this.hZi.b(this.mPageContext);
        }
    }

    public void oy(boolean z) {
        this.hZr = z;
    }
}
