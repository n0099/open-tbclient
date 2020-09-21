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
/* loaded from: classes23.dex */
public class p {
    private com.baidu.tbadk.core.dialog.g hrA;
    private SetPrivacyModel hrB;
    private ForumManageModel hrC;
    private com.baidu.tieba.callfans.a hrE;
    private com.baidu.tbadk.core.dialog.i hrs;
    private com.baidu.tbadk.core.dialog.k hrt;
    private com.baidu.tbadk.core.dialog.a hru;
    private a hrv;
    private CardPersonDynamicThreadData hrw;
    private List<com.baidu.tbadk.core.dialog.g> hrx;
    private com.baidu.tbadk.core.dialog.g hry;
    private com.baidu.tbadk.core.dialog.g hrz;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean hrD = false;
    private k.b hrF = new k.b() { // from class: com.baidu.tieba.card.p.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (p.this.hrw != null) {
                p.this.cfi();
                if (p.this.hrw.from == 1) {
                    i = 2;
                } else {
                    i = p.this.hrw.from == 3 ? 1 : 1;
                }
                if (p.this.hrw == null || !p.this.hrw.isPrivacy) {
                    if (p.this.hrw.bcY() != null) {
                        p.this.hrE.setThreadId(p.this.hrw.bcY().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && p.this.hrw.bcY() != null && TbSingleton.getInstance().mCallFansTid.equals(p.this.hrw.bcY().getTid())) {
                        i2 = 2;
                    }
                    p.this.hrE.ceJ();
                    if (p.this.hrw.bcY() != null) {
                        p.this.hrE.j(i, i2, p.this.hrw.bcY().getTid());
                        return;
                    }
                    return;
                }
                p.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (p.this.hrw.bcY() != null) {
                    p.this.hrE.j(i, 3, p.this.hrw.bcY().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a hrG = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.hrw.isPrivacy) {
                p.this.hrw.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.thread_has_open);
                if (p.this.hry != null) {
                    p.this.hry.setText(p.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (p.this.hrv != null) {
                    p.this.hrv.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.hrw.isPrivacy = true;
            if (p.this.hry != null) {
                p.this.hry.setText(p.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (p.this.hrv != null) {
                p.this.hrv.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.hrw.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private k.b hrH = new k.b() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                return;
            }
            if (p.this.hrw.isPrivacy) {
                if (p.this.hrw.from == 1) {
                    TiebaStatic.log(new aq("c12599").ai("obj_type", 2));
                }
            } else if (p.this.hrw.from != 1) {
                if (p.this.hrw.from == 3) {
                    TiebaStatic.log(new aq("c12600").ai("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new aq("c12599").ai("obj_type", 1));
            }
            if (p.this.hrB == null) {
                p.this.hrB = new SetPrivacyModel(p.this.mPageContext, p.this.hrw);
            }
            if (!p.this.hrB.isRunning()) {
                p.this.hrB.a(p.this.hrG);
                p.this.hrB.LoadData();
            }
            p.this.cfi();
        }
    };
    private k.b hrI = new k.b() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                return;
            }
            if (p.this.hrw != null && p.this.hrC != null) {
                p.this.cfj();
                p.this.hru.bia();
            }
            p.this.cfi();
        }
    };
    private com.baidu.adp.base.d hrJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.delete_success);
                    if (p.this.hrw != null) {
                        if (at.isEmpty(p.this.hrw.hva)) {
                            if (!at.isEmpty(p.this.hrw.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.hrw.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, p.this.hrw.hva));
                    }
                } else if (!at.isEmpty(bVar.mro)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.mro);
                } else {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes23.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public p(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.hrx = new ArrayList();
            this.hrt = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.hrC = new ForumManageModel(this.mPageContext);
            this.hrC.setLoadDataCallBack(this.hrJ);
            this.hrE = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.hrt != null) {
            this.hrt.onChangeSkinType();
        }
        if (this.hru != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hru.getRealView());
        }
    }

    public void create() {
        if (this.hrs == null) {
            this.hry = new com.baidu.tbadk.core.dialog.g(this.hrt);
            this.hry.a(this.hrH);
            if (!this.hrD) {
                this.hrx.add(this.hry);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.hrD) {
                this.hrz = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.hrt);
                this.hrz.a(this.hrF);
                this.hrx.add(this.hrz);
            }
            this.hrA = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.hrt);
            this.hrA.a(this.hrI);
            this.hrx.add(this.hrA);
            this.hrt.a(new k.a() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    p.this.cfi();
                }
            });
            this.hrt.aX(this.hrx);
            this.hrs = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.hrt);
        }
    }

    public void a(a aVar) {
        this.hrv = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.hrw = cardPersonDynamicThreadData;
        if (this.hrw != null && this.hry != null) {
            if (this.hrw.isPrivacy) {
                this.hry.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.hry.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.hrz != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.hrz.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.hrw.bcY() != null && TbSingleton.getInstance().mCallFansTid.equals(this.hrw.bcY().getTid())) {
                    this.hrz.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.hrz.setText(this.mContext.getString(R.string.call_fans));
                }
                this.hrz.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.hrs != null) {
            this.hrs.NY();
        }
    }

    public void cfi() {
        if (this.hrs != null && this.hrs.isShowing()) {
            this.hrs.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfj() {
        if (this.hru == null) {
            this.hru = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.hrD) {
                this.hru.nE(R.string.del_dynamic_confirm);
            } else {
                this.hru.nE(R.string.del_thread_confirm);
            }
            this.hru.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (p.this.hrw.from != 1) {
                        if (p.this.hrw.from == 3) {
                            TiebaStatic.log(new aq("c12600").ai("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new aq("c12599").ai("obj_type", 3));
                    }
                    if (p.this.hrD) {
                        p.this.hrC.aX(p.this.hrw.dXg);
                    }
                    p.this.hrC.a(p.this.hrw.forumId, p.this.hrw.forumName, p.this.hrw.threadId, p.this.hrw.postId, 0, 0, true, p.this.hrw.dXg.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.hru.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hru.id(true);
            this.hru.b(this.mPageContext);
        }
    }

    public void np(boolean z) {
        this.hrD = z;
    }
}
