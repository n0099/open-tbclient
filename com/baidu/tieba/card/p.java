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
/* loaded from: classes7.dex */
public class p {
    private ForumManageModel gca;
    private com.baidu.tbadk.core.dialog.i irT;
    private com.baidu.tbadk.core.dialog.k irU;
    private com.baidu.tbadk.core.dialog.a irV;
    private a irW;
    private CardPersonDynamicThreadData irX;
    private List<com.baidu.tbadk.core.dialog.g> irY;
    private com.baidu.tbadk.core.dialog.g irZ;
    private com.baidu.tbadk.core.dialog.g isa;
    private com.baidu.tbadk.core.dialog.g isb;
    private SetPrivacyModel isc;
    private com.baidu.tieba.callfans.a ise;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean isd = false;
    private k.b isf = new k.b() { // from class: com.baidu.tieba.card.p.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (p.this.irX != null) {
                p.this.cre();
                if (p.this.irX.from == 1) {
                    i = 2;
                } else {
                    i = p.this.irX.from == 3 ? 1 : 1;
                }
                if (p.this.irX == null || !p.this.irX.isPrivacy) {
                    if (p.this.irX.bkV() != null) {
                        p.this.ise.setThreadId(p.this.irX.bkV().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && p.this.irX.bkV() != null && TbSingleton.getInstance().mCallFansTid.equals(p.this.irX.bkV().getTid())) {
                        i2 = 2;
                    }
                    p.this.ise.cqF();
                    if (p.this.irX.bkV() != null) {
                        p.this.ise.l(i, i2, p.this.irX.bkV().getTid());
                        return;
                    }
                    return;
                }
                p.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (p.this.irX.bkV() != null) {
                    p.this.ise.l(i, 3, p.this.irX.bkV().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a isg = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.irX.isPrivacy) {
                p.this.irX.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.thread_has_open);
                if (p.this.irZ != null) {
                    p.this.irZ.setText(p.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (p.this.irW != null) {
                    p.this.irW.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.irX.isPrivacy = true;
            if (p.this.irZ != null) {
                p.this.irZ.setText(p.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (p.this.irW != null) {
                p.this.irW.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.irX.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private k.b ish = new k.b() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                return;
            }
            if (p.this.irX.isPrivacy) {
                if (p.this.irX.from == 1) {
                    TiebaStatic.log(new aq("c12599").an("obj_type", 2));
                }
            } else if (p.this.irX.from != 1) {
                if (p.this.irX.from == 3) {
                    TiebaStatic.log(new aq("c12600").an("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new aq("c12599").an("obj_type", 1));
            }
            if (p.this.isc == null) {
                p.this.isc = new SetPrivacyModel(p.this.mPageContext, p.this.irX);
            }
            if (!p.this.isc.isRunning()) {
                p.this.isc.a(p.this.isg);
                p.this.isc.LoadData();
            }
            p.this.cre();
        }
    };
    private k.b isi = new k.b() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                return;
            }
            if (p.this.irX != null && p.this.gca != null) {
                p.this.crf();
                p.this.irV.bqe();
            }
            p.this.cre();
        }
    };
    private com.baidu.adp.base.e isj = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.p.8
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.delete_success);
                    if (p.this.irX != null) {
                        if (at.isEmpty(p.this.irX.ivR)) {
                            if (!at.isEmpty(p.this.irX.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.irX.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, p.this.irX.ivR));
                    }
                } else if (!at.isEmpty(bVar.npO)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.npO);
                } else {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public p(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.irY = new ArrayList();
            this.irU = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.gca = new ForumManageModel(this.mPageContext);
            this.gca.setLoadDataCallBack(this.isj);
            this.ise = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.irU != null) {
            this.irU.onChangeSkinType();
        }
        if (this.irV != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.irV.getRealView());
        }
    }

    public void create() {
        if (this.irT == null) {
            this.irZ = new com.baidu.tbadk.core.dialog.g(this.irU);
            this.irZ.a(this.ish);
            if (!this.isd) {
                this.irY.add(this.irZ);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.isd) {
                this.isa = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.irU);
                this.isa.a(this.isf);
                this.irY.add(this.isa);
            }
            this.isb = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.irU);
            this.isb.a(this.isi);
            this.irY.add(this.isb);
            this.irU.a(new k.a() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    p.this.cre();
                }
            });
            this.irU.bB(this.irY);
            this.irT = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.irU);
        }
    }

    public void a(a aVar) {
        this.irW = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.irX = cardPersonDynamicThreadData;
        if (this.irX != null && this.irZ != null) {
            if (this.irX.isPrivacy) {
                this.irZ.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.irZ.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.isa != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.isa.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.irX.bkV() != null && TbSingleton.getInstance().mCallFansTid.equals(this.irX.bkV().getTid())) {
                    this.isa.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.isa.setText(this.mContext.getString(R.string.call_fans));
                }
                this.isa.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.irT != null) {
            this.irT.Pd();
        }
    }

    public void cre() {
        if (this.irT != null && this.irT.isShowing()) {
            this.irT.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crf() {
        if (this.irV == null) {
            this.irV = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.isd) {
                this.irV.nu(R.string.del_dynamic_confirm);
            } else {
                this.irV.nu(R.string.del_thread_confirm);
            }
            this.irV.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                        return;
                    }
                    if (p.this.irX.from != 1) {
                        if (p.this.irX.from == 3) {
                            TiebaStatic.log(new aq("c12600").an("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new aq("c12599").an("obj_type", 3));
                    }
                    if (p.this.isd) {
                        p.this.gca.ba(p.this.irX.eHK);
                    }
                    p.this.gca.a(p.this.irX.forumId, p.this.irX.forumName, p.this.irX.threadId, p.this.irX.postId, 0, 0, true, p.this.irX.eHK.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.irV.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.irV.jD(true);
            this.irV.b(this.mPageContext);
        }
    }

    public void po(boolean z) {
        this.isd = z;
    }
}
