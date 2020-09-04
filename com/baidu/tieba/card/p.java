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
    private com.baidu.tieba.callfans.a hkB;
    private com.baidu.tbadk.core.dialog.i hkp;
    private com.baidu.tbadk.core.dialog.k hkq;
    private com.baidu.tbadk.core.dialog.a hkr;
    private a hks;
    private CardPersonDynamicThreadData hkt;
    private List<com.baidu.tbadk.core.dialog.g> hku;
    private com.baidu.tbadk.core.dialog.g hkv;
    private com.baidu.tbadk.core.dialog.g hkw;
    private com.baidu.tbadk.core.dialog.g hkx;
    private SetPrivacyModel hky;
    private ForumManageModel hkz;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean hkA = false;
    private k.b hkC = new k.b() { // from class: com.baidu.tieba.card.p.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (p.this.hkt != null) {
                p.this.cbT();
                if (p.this.hkt.from == 1) {
                    i = 2;
                } else {
                    i = p.this.hkt.from == 3 ? 1 : 1;
                }
                if (p.this.hkt == null || !p.this.hkt.isPrivacy) {
                    if (p.this.hkt.bce() != null) {
                        p.this.hkB.setThreadId(p.this.hkt.bce().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && p.this.hkt.bce() != null && TbSingleton.getInstance().mCallFansTid.equals(p.this.hkt.bce().getTid())) {
                        i2 = 2;
                    }
                    p.this.hkB.cbu();
                    if (p.this.hkt.bce() != null) {
                        p.this.hkB.i(i, i2, p.this.hkt.bce().getTid());
                        return;
                    }
                    return;
                }
                p.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (p.this.hkt.bce() != null) {
                    p.this.hkB.i(i, 3, p.this.hkt.bce().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a hkD = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.hkt.isPrivacy) {
                p.this.hkt.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.thread_has_open);
                if (p.this.hkv != null) {
                    p.this.hkv.setText(p.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (p.this.hks != null) {
                    p.this.hks.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.hkt.isPrivacy = true;
            if (p.this.hkv != null) {
                p.this.hkv.setText(p.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (p.this.hks != null) {
                p.this.hks.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.hkt.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private k.b hkE = new k.b() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                return;
            }
            if (p.this.hkt.isPrivacy) {
                if (p.this.hkt.from == 1) {
                    TiebaStatic.log(new aq("c12599").ai("obj_type", 2));
                }
            } else if (p.this.hkt.from != 1) {
                if (p.this.hkt.from == 3) {
                    TiebaStatic.log(new aq("c12600").ai("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new aq("c12599").ai("obj_type", 1));
            }
            if (p.this.hky == null) {
                p.this.hky = new SetPrivacyModel(p.this.mPageContext, p.this.hkt);
            }
            if (!p.this.hky.isRunning()) {
                p.this.hky.a(p.this.hkD);
                p.this.hky.LoadData();
            }
            p.this.cbT();
        }
    };
    private k.b hkF = new k.b() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                return;
            }
            if (p.this.hkt != null && p.this.hkz != null) {
                p.this.cbU();
                p.this.hkr.bhg();
            }
            p.this.cbT();
        }
    };
    private com.baidu.adp.base.d hkG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.delete_success);
                    if (p.this.hkt != null) {
                        if (at.isEmpty(p.this.hkt.hnW)) {
                            if (!at.isEmpty(p.this.hkt.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.hkt.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, p.this.hkt.hnW));
                    }
                } else if (!at.isEmpty(bVar.mhO)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.mhO);
                } else {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.delete_fail);
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
            this.hku = new ArrayList();
            this.hkq = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.hkz = new ForumManageModel(this.mPageContext);
            this.hkz.setLoadDataCallBack(this.hkG);
            this.hkB = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.hkq != null) {
            this.hkq.onChangeSkinType();
        }
        if (this.hkr != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hkr.getRealView());
        }
    }

    public void create() {
        if (this.hkp == null) {
            this.hkv = new com.baidu.tbadk.core.dialog.g(this.hkq);
            this.hkv.a(this.hkE);
            if (!this.hkA) {
                this.hku.add(this.hkv);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.hkA) {
                this.hkw = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.hkq);
                this.hkw.a(this.hkC);
                this.hku.add(this.hkw);
            }
            this.hkx = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.hkq);
            this.hkx.a(this.hkF);
            this.hku.add(this.hkx);
            this.hkq.a(new k.a() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    p.this.cbT();
                }
            });
            this.hkq.aT(this.hku);
            this.hkp = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.hkq);
        }
    }

    public void a(a aVar) {
        this.hks = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.hkt = cardPersonDynamicThreadData;
        if (this.hkt != null && this.hkv != null) {
            if (this.hkt.isPrivacy) {
                this.hkv.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.hkv.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.hkw != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.hkw.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.hkt.bce() != null && TbSingleton.getInstance().mCallFansTid.equals(this.hkt.bce().getTid())) {
                    this.hkw.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.hkw.setText(this.mContext.getString(R.string.call_fans));
                }
                this.hkw.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.hkp != null) {
            this.hkp.Nv();
        }
    }

    public void cbT() {
        if (this.hkp != null && this.hkp.isShowing()) {
            this.hkp.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbU() {
        if (this.hkr == null) {
            this.hkr = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.hkA) {
                this.hkr.nt(R.string.del_dynamic_confirm);
            } else {
                this.hkr.nt(R.string.del_thread_confirm);
            }
            this.hkr.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (p.this.hkt.from != 1) {
                        if (p.this.hkt.from == 3) {
                            TiebaStatic.log(new aq("c12600").ai("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new aq("c12599").ai("obj_type", 3));
                    }
                    if (p.this.hkA) {
                        p.this.hkz.aW(p.this.hkt.dUW);
                    }
                    p.this.hkz.a(p.this.hkt.forumId, p.this.hkt.forumName, p.this.hkt.threadId, p.this.hkt.postId, 0, 0, true, p.this.hkt.dUW.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.hkr.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hkr.ig(true);
            this.hkr.b(this.mPageContext);
        }
    }

    public void nj(boolean z) {
        this.hkA = z;
    }
}
