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
/* loaded from: classes8.dex */
public class p {
    private ForumManageModel ggJ;
    private com.baidu.tbadk.core.dialog.i iwA;
    private com.baidu.tbadk.core.dialog.k iwB;
    private com.baidu.tbadk.core.dialog.a iwC;
    private a iwD;
    private CardPersonDynamicThreadData iwE;
    private List<com.baidu.tbadk.core.dialog.g> iwF;
    private com.baidu.tbadk.core.dialog.g iwG;
    private com.baidu.tbadk.core.dialog.g iwH;
    private com.baidu.tbadk.core.dialog.g iwI;
    private SetPrivacyModel iwJ;
    private com.baidu.tieba.callfans.a iwL;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean iwK = false;
    private k.b iwM = new k.b() { // from class: com.baidu.tieba.card.p.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (p.this.iwE != null) {
                p.this.cuV();
                if (p.this.iwE.from == 1) {
                    i = 2;
                } else {
                    i = p.this.iwE.from == 3 ? 1 : 1;
                }
                if (p.this.iwE == null || !p.this.iwE.isPrivacy) {
                    if (p.this.iwE.boO() != null) {
                        p.this.iwL.setThreadId(p.this.iwE.boO().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && p.this.iwE.boO() != null && TbSingleton.getInstance().mCallFansTid.equals(p.this.iwE.boO().getTid())) {
                        i2 = 2;
                    }
                    p.this.iwL.cuw();
                    if (p.this.iwE.boO() != null) {
                        p.this.iwL.l(i, i2, p.this.iwE.boO().getTid());
                        return;
                    }
                    return;
                }
                p.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (p.this.iwE.boO() != null) {
                    p.this.iwL.l(i, 3, p.this.iwE.boO().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a iwN = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.iwE.isPrivacy) {
                p.this.iwE.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.thread_has_open);
                if (p.this.iwG != null) {
                    p.this.iwG.setText(p.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (p.this.iwD != null) {
                    p.this.iwD.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.iwE.isPrivacy = true;
            if (p.this.iwG != null) {
                p.this.iwG.setText(p.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (p.this.iwD != null) {
                p.this.iwD.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.iwE.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private k.b iwO = new k.b() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                return;
            }
            if (p.this.iwE.isPrivacy) {
                if (p.this.iwE.from == 1) {
                    TiebaStatic.log(new aq("c12599").an("obj_type", 2));
                }
            } else if (p.this.iwE.from != 1) {
                if (p.this.iwE.from == 3) {
                    TiebaStatic.log(new aq("c12600").an("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new aq("c12599").an("obj_type", 1));
            }
            if (p.this.iwJ == null) {
                p.this.iwJ = new SetPrivacyModel(p.this.mPageContext, p.this.iwE);
            }
            if (!p.this.iwJ.isRunning()) {
                p.this.iwJ.a(p.this.iwN);
                p.this.iwJ.LoadData();
            }
            p.this.cuV();
        }
    };
    private k.b iwP = new k.b() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                return;
            }
            if (p.this.iwE != null && p.this.ggJ != null) {
                p.this.cuW();
                p.this.iwC.btX();
            }
            p.this.cuV();
        }
    };
    private com.baidu.adp.base.e iwQ = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.p.8
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.delete_success);
                    if (p.this.iwE != null) {
                        if (at.isEmpty(p.this.iwE.iAy)) {
                            if (!at.isEmpty(p.this.iwE.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.iwE.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, p.this.iwE.iAy));
                    }
                } else if (!at.isEmpty(bVar.nuu)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.nuu);
                } else {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public p(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.iwF = new ArrayList();
            this.iwB = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.ggJ = new ForumManageModel(this.mPageContext);
            this.ggJ.setLoadDataCallBack(this.iwQ);
            this.iwL = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.iwB != null) {
            this.iwB.onChangeSkinType();
        }
        if (this.iwC != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.iwC.getRealView());
        }
    }

    public void create() {
        if (this.iwA == null) {
            this.iwG = new com.baidu.tbadk.core.dialog.g(this.iwB);
            this.iwG.a(this.iwO);
            if (!this.iwK) {
                this.iwF.add(this.iwG);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.iwK) {
                this.iwH = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.iwB);
                this.iwH.a(this.iwM);
                this.iwF.add(this.iwH);
            }
            this.iwI = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.iwB);
            this.iwI.a(this.iwP);
            this.iwF.add(this.iwI);
            this.iwB.a(new k.a() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    p.this.cuV();
                }
            });
            this.iwB.bB(this.iwF);
            this.iwA = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.iwB);
        }
    }

    public void a(a aVar) {
        this.iwD = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.iwE = cardPersonDynamicThreadData;
        if (this.iwE != null && this.iwG != null) {
            if (this.iwE.isPrivacy) {
                this.iwG.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.iwG.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.iwH != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.iwH.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.iwE.boO() != null && TbSingleton.getInstance().mCallFansTid.equals(this.iwE.boO().getTid())) {
                    this.iwH.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.iwH.setText(this.mContext.getString(R.string.call_fans));
                }
                this.iwH.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.iwA != null) {
            this.iwA.SY();
        }
    }

    public void cuV() {
        if (this.iwA != null && this.iwA.isShowing()) {
            this.iwA.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuW() {
        if (this.iwC == null) {
            this.iwC = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.iwK) {
                this.iwC.pa(R.string.del_dynamic_confirm);
            } else {
                this.iwC.pa(R.string.del_thread_confirm);
            }
            this.iwC.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                        return;
                    }
                    if (p.this.iwE.from != 1) {
                        if (p.this.iwE.from == 3) {
                            TiebaStatic.log(new aq("c12600").an("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new aq("c12599").an("obj_type", 3));
                    }
                    if (p.this.iwK) {
                        p.this.ggJ.ba(p.this.iwE.eMv);
                    }
                    p.this.ggJ.a(p.this.iwE.forumId, p.this.iwE.forumName, p.this.iwE.threadId, p.this.iwE.postId, 0, 0, true, p.this.iwE.eMv.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.iwC.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iwC.jH(true);
            this.iwC.b(this.mPageContext);
        }
    }

    public void ps(boolean z) {
        this.iwK = z;
    }
}
