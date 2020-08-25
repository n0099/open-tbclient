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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class p {
    private com.baidu.tbadk.core.dialog.i hkl;
    private com.baidu.tbadk.core.dialog.k hkm;
    private com.baidu.tbadk.core.dialog.a hkn;
    private a hko;
    private CardPersonDynamicThreadData hkp;
    private List<com.baidu.tbadk.core.dialog.g> hkq;
    private com.baidu.tbadk.core.dialog.g hkr;
    private com.baidu.tbadk.core.dialog.g hks;
    private com.baidu.tbadk.core.dialog.g hkt;
    private SetPrivacyModel hku;
    private ForumManageModel hkv;
    private com.baidu.tieba.callfans.a hkx;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean hkw = false;
    private k.b hky = new k.b() { // from class: com.baidu.tieba.card.p.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (p.this.hkp != null) {
                p.this.cbS();
                if (p.this.hkp.from == 1) {
                    i = 2;
                } else {
                    i = p.this.hkp.from == 3 ? 1 : 1;
                }
                if (p.this.hkp == null || !p.this.hkp.isPrivacy) {
                    if (p.this.hkp.bce() != null) {
                        p.this.hkx.setThreadId(p.this.hkp.bce().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && p.this.hkp.bce() != null && TbSingleton.getInstance().mCallFansTid.equals(p.this.hkp.bce().getTid())) {
                        i2 = 2;
                    }
                    p.this.hkx.cbt();
                    if (p.this.hkp.bce() != null) {
                        p.this.hkx.i(i, i2, p.this.hkp.bce().getTid());
                        return;
                    }
                    return;
                }
                p.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (p.this.hkp.bce() != null) {
                    p.this.hkx.i(i, 3, p.this.hkp.bce().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a hkz = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.hkp.isPrivacy) {
                p.this.hkp.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.thread_has_open);
                if (p.this.hkr != null) {
                    p.this.hkr.setText(p.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (p.this.hko != null) {
                    p.this.hko.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.hkp.isPrivacy = true;
            if (p.this.hkr != null) {
                p.this.hkr.setText(p.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (p.this.hko != null) {
                p.this.hko.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.hkp.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private k.b hkA = new k.b() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                return;
            }
            if (p.this.hkp.isPrivacy) {
                if (p.this.hkp.from == 1) {
                    TiebaStatic.log(new aq("c12599").ai("obj_type", 2));
                }
            } else if (p.this.hkp.from != 1) {
                if (p.this.hkp.from == 3) {
                    TiebaStatic.log(new aq("c12600").ai("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new aq("c12599").ai("obj_type", 1));
            }
            if (p.this.hku == null) {
                p.this.hku = new SetPrivacyModel(p.this.mPageContext, p.this.hkp);
            }
            if (!p.this.hku.isRunning()) {
                p.this.hku.a(p.this.hkz);
                p.this.hku.LoadData();
            }
            p.this.cbS();
        }
    };
    private k.b hkB = new k.b() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                return;
            }
            if (p.this.hkp != null && p.this.hkv != null) {
                p.this.cbT();
                p.this.hkn.bhg();
            }
            p.this.cbS();
        }
    };
    private com.baidu.adp.base.d hkC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.delete_success);
                    if (p.this.hkp != null) {
                        if (at.isEmpty(p.this.hkp.hnS)) {
                            if (!at.isEmpty(p.this.hkp.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.hkp.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, p.this.hkp.hnS));
                    }
                } else if (!at.isEmpty(bVar.mhz)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.mhz);
                } else {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes18.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public p(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.hkq = new ArrayList();
            this.hkm = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.hkv = new ForumManageModel(this.mPageContext);
            this.hkv.setLoadDataCallBack(this.hkC);
            this.hkx = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.hkm != null) {
            this.hkm.onChangeSkinType();
        }
        if (this.hkn != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hkn.getRealView());
        }
    }

    public void create() {
        if (this.hkl == null) {
            this.hkr = new com.baidu.tbadk.core.dialog.g(this.hkm);
            this.hkr.a(this.hkA);
            if (!this.hkw) {
                this.hkq.add(this.hkr);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.hkw) {
                this.hks = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.hkm);
                this.hks.a(this.hky);
                this.hkq.add(this.hks);
            }
            this.hkt = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.hkm);
            this.hkt.a(this.hkB);
            this.hkq.add(this.hkt);
            this.hkm.a(new k.a() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    p.this.cbS();
                }
            });
            this.hkm.aT(this.hkq);
            this.hkl = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.hkm);
        }
    }

    public void a(a aVar) {
        this.hko = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.hkp = cardPersonDynamicThreadData;
        if (this.hkp != null && this.hkr != null) {
            if (this.hkp.isPrivacy) {
                this.hkr.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.hkr.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.hks != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.hks.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.hkp.bce() != null && TbSingleton.getInstance().mCallFansTid.equals(this.hkp.bce().getTid())) {
                    this.hks.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.hks.setText(this.mContext.getString(R.string.call_fans));
                }
                this.hks.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.hkl != null) {
            this.hkl.Nv();
        }
    }

    public void cbS() {
        if (this.hkl != null && this.hkl.isShowing()) {
            this.hkl.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbT() {
        if (this.hkn == null) {
            this.hkn = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.hkw) {
                this.hkn.nt(R.string.del_dynamic_confirm);
            } else {
                this.hkn.nt(R.string.del_thread_confirm);
            }
            this.hkn.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                        return;
                    }
                    if (p.this.hkp.from != 1) {
                        if (p.this.hkp.from == 3) {
                            TiebaStatic.log(new aq("c12600").ai("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new aq("c12599").ai("obj_type", 3));
                    }
                    if (p.this.hkw) {
                        p.this.hkv.aW(p.this.hkp.dUS);
                    }
                    p.this.hkv.a(p.this.hkp.forumId, p.this.hkp.forumName, p.this.hkp.threadId, p.this.hkp.postId, 0, 0, true, p.this.hkp.dUS.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.hkn.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hkn.m39if(true);
            this.hkn.b(this.mPageContext);
        }
    }

    public void nh(boolean z) {
        this.hkw = z;
    }
}
