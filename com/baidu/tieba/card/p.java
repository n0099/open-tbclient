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
/* loaded from: classes24.dex */
public class p {
    private com.baidu.tbadk.core.dialog.i hGm;
    private com.baidu.tbadk.core.dialog.k hGn;
    private com.baidu.tbadk.core.dialog.a hGo;
    private a hGp;
    private CardPersonDynamicThreadData hGq;
    private List<com.baidu.tbadk.core.dialog.g> hGr;
    private com.baidu.tbadk.core.dialog.g hGs;
    private com.baidu.tbadk.core.dialog.g hGt;
    private com.baidu.tbadk.core.dialog.g hGu;
    private SetPrivacyModel hGv;
    private ForumManageModel hGw;
    private com.baidu.tieba.callfans.a hGy;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean hGx = false;
    private k.b hGz = new k.b() { // from class: com.baidu.tieba.card.p.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (p.this.hGq != null) {
                p.this.ciE();
                if (p.this.hGq.from == 1) {
                    i = 2;
                } else {
                    i = p.this.hGq.from == 3 ? 1 : 1;
                }
                if (p.this.hGq == null || !p.this.hGq.isPrivacy) {
                    if (p.this.hGq.bfG() != null) {
                        p.this.hGy.setThreadId(p.this.hGq.bfG().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && p.this.hGq.bfG() != null && TbSingleton.getInstance().mCallFansTid.equals(p.this.hGq.bfG().getTid())) {
                        i2 = 2;
                    }
                    p.this.hGy.cif();
                    if (p.this.hGq.bfG() != null) {
                        p.this.hGy.k(i, i2, p.this.hGq.bfG().getTid());
                        return;
                    }
                    return;
                }
                p.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (p.this.hGq.bfG() != null) {
                    p.this.hGy.k(i, 3, p.this.hGq.bfG().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a hGA = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.hGq.isPrivacy) {
                p.this.hGq.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.thread_has_open);
                if (p.this.hGs != null) {
                    p.this.hGs.setText(p.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (p.this.hGp != null) {
                    p.this.hGp.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.hGq.isPrivacy = true;
            if (p.this.hGs != null) {
                p.this.hGs.setText(p.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (p.this.hGp != null) {
                p.this.hGp.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.hGq.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private k.b hGB = new k.b() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                return;
            }
            if (p.this.hGq.isPrivacy) {
                if (p.this.hGq.from == 1) {
                    TiebaStatic.log(new aq("c12599").aj("obj_type", 2));
                }
            } else if (p.this.hGq.from != 1) {
                if (p.this.hGq.from == 3) {
                    TiebaStatic.log(new aq("c12600").aj("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new aq("c12599").aj("obj_type", 1));
            }
            if (p.this.hGv == null) {
                p.this.hGv = new SetPrivacyModel(p.this.mPageContext, p.this.hGq);
            }
            if (!p.this.hGv.isRunning()) {
                p.this.hGv.a(p.this.hGA);
                p.this.hGv.LoadData();
            }
            p.this.ciE();
        }
    };
    private k.b hGC = new k.b() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                return;
            }
            if (p.this.hGq != null && p.this.hGw != null) {
                p.this.ciF();
                p.this.hGo.bkJ();
            }
            p.this.ciE();
        }
    };
    private com.baidu.adp.base.d hGD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.delete_success);
                    if (p.this.hGq != null) {
                        if (at.isEmpty(p.this.hGq.hJV)) {
                            if (!at.isEmpty(p.this.hGq.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.hGq.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, p.this.hGq.hJV));
                    }
                } else if (!at.isEmpty(bVar.mGW)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.mGW);
                } else {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes24.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public p(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.hGr = new ArrayList();
            this.hGn = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.hGw = new ForumManageModel(this.mPageContext);
            this.hGw.setLoadDataCallBack(this.hGD);
            this.hGy = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.hGn != null) {
            this.hGn.onChangeSkinType();
        }
        if (this.hGo != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hGo.getRealView());
        }
    }

    public void create() {
        if (this.hGm == null) {
            this.hGs = new com.baidu.tbadk.core.dialog.g(this.hGn);
            this.hGs.a(this.hGB);
            if (!this.hGx) {
                this.hGr.add(this.hGs);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.hGx) {
                this.hGt = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.hGn);
                this.hGt.a(this.hGz);
                this.hGr.add(this.hGt);
            }
            this.hGu = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.hGn);
            this.hGu.a(this.hGC);
            this.hGr.add(this.hGu);
            this.hGn.a(new k.a() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    p.this.ciE();
                }
            });
            this.hGn.ba(this.hGr);
            this.hGm = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.hGn);
        }
    }

    public void a(a aVar) {
        this.hGp = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.hGq = cardPersonDynamicThreadData;
        if (this.hGq != null && this.hGs != null) {
            if (this.hGq.isPrivacy) {
                this.hGs.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.hGs.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.hGt != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.hGt.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.hGq.bfG() != null && TbSingleton.getInstance().mCallFansTid.equals(this.hGq.bfG().getTid())) {
                    this.hGt.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.hGt.setText(this.mContext.getString(R.string.call_fans));
                }
                this.hGt.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.hGm != null) {
            this.hGm.Pd();
        }
    }

    public void ciE() {
        if (this.hGm != null && this.hGm.isShowing()) {
            this.hGm.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciF() {
        if (this.hGo == null) {
            this.hGo = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.hGx) {
                this.hGo.ob(R.string.del_dynamic_confirm);
            } else {
                this.hGo.ob(R.string.del_thread_confirm);
            }
            this.hGo.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                        return;
                    }
                    if (p.this.hGq.from != 1) {
                        if (p.this.hGq.from == 3) {
                            TiebaStatic.log(new aq("c12600").aj("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new aq("c12599").aj("obj_type", 3));
                    }
                    if (p.this.hGx) {
                        p.this.hGw.aX(p.this.hGq.eji);
                    }
                    p.this.hGw.a(p.this.hGq.forumId, p.this.hGq.forumName, p.this.hGq.threadId, p.this.hGq.postId, 0, 0, true, p.this.hGq.eji.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.hGo.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hGo.iz(true);
            this.hGo.b(this.mPageContext);
        }
    }

    public void nU(boolean z) {
        this.hGx = z;
    }
}
