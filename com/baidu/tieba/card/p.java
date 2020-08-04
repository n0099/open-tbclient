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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class p {
    private com.baidu.tbadk.core.dialog.g gXA;
    private SetPrivacyModel gXB;
    private ForumManageModel gXC;
    private com.baidu.tieba.callfans.a gXE;
    private com.baidu.tbadk.core.dialog.i gXs;
    private com.baidu.tbadk.core.dialog.k gXt;
    private com.baidu.tbadk.core.dialog.a gXu;
    private a gXv;
    private CardPersonDynamicThreadData gXw;
    private List<com.baidu.tbadk.core.dialog.g> gXx;
    private com.baidu.tbadk.core.dialog.g gXy;
    private com.baidu.tbadk.core.dialog.g gXz;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean gXD = false;
    private k.b gXF = new k.b() { // from class: com.baidu.tieba.card.p.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (p.this.gXw != null) {
                p.this.bRG();
                if (p.this.gXw.from == 1) {
                    i = 2;
                } else {
                    i = p.this.gXw.from == 3 ? 1 : 1;
                }
                if (p.this.gXw == null || !p.this.gXw.isPrivacy) {
                    if (p.this.gXw.aTN() != null) {
                        p.this.gXE.setThreadId(p.this.gXw.aTN().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && p.this.gXw.aTN() != null && TbSingleton.getInstance().mCallFansTid.equals(p.this.gXw.aTN().getTid())) {
                        i2 = 2;
                    }
                    p.this.gXE.bRh();
                    if (p.this.gXw.aTN() != null) {
                        p.this.gXE.j(i, i2, p.this.gXw.aTN().getTid());
                        return;
                    }
                    return;
                }
                p.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (p.this.gXw.aTN() != null) {
                    p.this.gXE.j(i, 3, p.this.gXw.aTN().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a gXG = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.gXw.isPrivacy) {
                p.this.gXw.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.thread_has_open);
                if (p.this.gXy != null) {
                    p.this.gXy.setText(p.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (p.this.gXv != null) {
                    p.this.gXv.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.gXw.isPrivacy = true;
            if (p.this.gXy != null) {
                p.this.gXy.setText(p.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (p.this.gXv != null) {
                p.this.gXv.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.gXw.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private k.b gXH = new k.b() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                return;
            }
            if (p.this.gXw.isPrivacy) {
                if (p.this.gXw.from == 1) {
                    TiebaStatic.log(new ap("c12599").ah("obj_type", 2));
                }
            } else if (p.this.gXw.from != 1) {
                if (p.this.gXw.from == 3) {
                    TiebaStatic.log(new ap("c12600").ah("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ap("c12599").ah("obj_type", 1));
            }
            if (p.this.gXB == null) {
                p.this.gXB = new SetPrivacyModel(p.this.mPageContext, p.this.gXw);
            }
            if (!p.this.gXB.isRunning()) {
                p.this.gXB.a(p.this.gXG);
                p.this.gXB.LoadData();
            }
            p.this.bRG();
        }
    };
    private k.b gXI = new k.b() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                return;
            }
            if (p.this.gXw != null && p.this.gXC != null) {
                p.this.bRH();
                p.this.gXu.aYL();
            }
            p.this.bRG();
        }
    };
    private com.baidu.adp.base.d gXJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.delete_success);
                    if (p.this.gXw != null) {
                        if (as.isEmpty(p.this.gXw.hbb)) {
                            if (!as.isEmpty(p.this.gXw.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.gXw.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, p.this.gXw.hbb));
                    }
                } else if (!as.isEmpty(bVar.lPQ)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.lPQ);
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
            this.gXx = new ArrayList();
            this.gXt = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.gXC = new ForumManageModel(this.mPageContext);
            this.gXC.setLoadDataCallBack(this.gXJ);
            this.gXE = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.gXt != null) {
            this.gXt.onChangeSkinType();
        }
        if (this.gXu != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.gXu.getRealView());
        }
    }

    public void create() {
        if (this.gXs == null) {
            this.gXy = new com.baidu.tbadk.core.dialog.g(this.gXt);
            this.gXy.a(this.gXH);
            if (!this.gXD) {
                this.gXx.add(this.gXy);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.gXD) {
                this.gXz = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.gXt);
                this.gXz.a(this.gXF);
                this.gXx.add(this.gXz);
            }
            this.gXA = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.gXt);
            this.gXA.a(this.gXI);
            this.gXx.add(this.gXA);
            this.gXt.a(new k.a() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    p.this.bRG();
                }
            });
            this.gXt.aS(this.gXx);
            this.gXs = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.gXt);
        }
    }

    public void a(a aVar) {
        this.gXv = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.gXw = cardPersonDynamicThreadData;
        if (this.gXw != null && this.gXy != null) {
            if (this.gXw.isPrivacy) {
                this.gXy.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.gXy.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            if (this.gXz != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.gXz.setText(this.mContext.getString(R.string.call_fans));
                    return;
                }
                if (TbSingleton.getInstance().mCallFansTid != null && this.gXw.aTN() != null && TbSingleton.getInstance().mCallFansTid.equals(this.gXw.aTN().getTid())) {
                    this.gXz.setText(this.mContext.getString(R.string.have_called_fans));
                } else {
                    this.gXz.setText(this.mContext.getString(R.string.call_fans));
                }
                this.gXz.setTextColor(R.color.cp_cont_b_alpha33);
            }
        }
    }

    public void show() {
        if (this.gXs != null) {
            this.gXs.showDialog();
        }
    }

    public void bRG() {
        if (this.gXs != null && this.gXs.isShowing()) {
            this.gXs.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRH() {
        if (this.gXu == null) {
            this.gXu = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.gXD) {
                this.gXu.ln(R.string.del_dynamic_confirm);
            } else {
                this.gXu.ln(R.string.del_thread_confirm);
            }
            this.gXu.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, R.string.neterror);
                        return;
                    }
                    if (p.this.gXw.from != 1) {
                        if (p.this.gXw.from == 3) {
                            TiebaStatic.log(new ap("c12600").ah("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ap("c12599").ah("obj_type", 3));
                    }
                    if (p.this.gXD) {
                        p.this.gXC.aV(p.this.gXw.dLK);
                    }
                    p.this.gXC.a(p.this.gXw.forumId, p.this.gXw.forumName, p.this.gXw.threadId, p.this.gXw.postId, 0, 0, true, p.this.gXw.dLK.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.gXu.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gXu.hJ(true);
            this.gXu.b(this.mPageContext);
        }
    }

    public void mE(boolean z) {
        this.gXD = z;
    }
}
