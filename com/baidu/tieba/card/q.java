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
/* loaded from: classes7.dex */
public class q {
    private ForumManageModel gfY;
    private com.baidu.tbadk.core.dialog.a izA;
    private a izB;
    private CardPersonDynamicThreadData izC;
    private List<com.baidu.tbadk.core.dialog.g> izD;
    private com.baidu.tbadk.core.dialog.g izE;
    private com.baidu.tbadk.core.dialog.g izF;
    private com.baidu.tbadk.core.dialog.g izG;
    private SetPrivacyModel izH;
    private com.baidu.tieba.callfans.a izJ;
    private com.baidu.tbadk.core.dialog.i izy;
    private com.baidu.tbadk.core.dialog.k izz;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean izI = false;
    private k.b izK = new k.b() { // from class: com.baidu.tieba.card.q.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (q.this.izC != null) {
                q.this.csC();
                if (q.this.izC.from == 1) {
                    i = 2;
                } else {
                    i = q.this.izC.from == 3 ? 1 : 1;
                }
                if (q.this.izC == null || !q.this.izC.isPrivacy) {
                    if (q.this.izC.blp() != null) {
                        q.this.izJ.setThreadId(q.this.izC.blp().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && q.this.izC.blp() != null && TbSingleton.getInstance().mCallFansTid.equals(q.this.izC.blp().getTid())) {
                        i2 = 2;
                    }
                    q.this.izJ.csc();
                    if (q.this.izC.blp() != null) {
                        q.this.izJ.k(i, i2, q.this.izC.blp().getTid());
                        return;
                    }
                    return;
                }
                q.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (q.this.izC.blp() != null) {
                    q.this.izJ.k(i, 3, q.this.izC.blp().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a izL = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.izC.isPrivacy) {
                q.this.izC.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.thread_has_open);
                if (q.this.izE != null) {
                    q.this.izE.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.izB != null) {
                    q.this.izB.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.izC.isPrivacy = true;
            if (q.this.izE != null) {
                q.this.izE.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.izB != null) {
                q.this.izB.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, q.this.izC.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b izM = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.izC.isPrivacy) {
                if (q.this.izC.from == 1) {
                    TiebaStatic.log(new ar("c12599").aq("obj_type", 2));
                }
            } else if (q.this.izC.from != 1) {
                if (q.this.izC.from == 3) {
                    TiebaStatic.log(new ar("c12600").aq("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ar("c12599").aq("obj_type", 1));
            }
            if (q.this.izH == null) {
                q.this.izH = new SetPrivacyModel(q.this.mPageContext, q.this.izC);
            }
            if (!q.this.izH.isRunning()) {
                q.this.izH.a(q.this.izL);
                q.this.izH.LoadData();
            }
            q.this.csC();
        }
    };
    private k.b izN = new k.b() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.izC != null && q.this.gfY != null) {
                q.this.csD();
                q.this.izA.bqz();
            }
            q.this.csC();
        }
    };
    private com.baidu.adp.base.e izO = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.q.8
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_success);
                    if (q.this.izC != null) {
                        if (au.isEmpty(q.this.izC.iDy)) {
                            if (!au.isEmpty(q.this.izC.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, q.this.izC.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.izC.iDy));
                    }
                } else if (!au.isEmpty(bVar.nCc)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.nCc);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public q(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.izD = new ArrayList();
            this.izz = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.gfY = new ForumManageModel(this.mPageContext);
            this.gfY.setLoadDataCallBack(this.izO);
            this.izJ = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.izz != null) {
            this.izz.onChangeSkinType();
        }
        if (this.izA != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.izA.getRealView());
        }
    }

    public void create() {
        if (this.izy == null) {
            this.izE = new com.baidu.tbadk.core.dialog.g(this.izz);
            this.izE.a(this.izM);
            if (!this.izI) {
                this.izD.add(this.izE);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.izI) {
                this.izF = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.izz);
                this.izF.a(this.izK);
                this.izD.add(this.izF);
            }
            this.izG = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.izz);
            this.izG.a(this.izN);
            this.izD.add(this.izG);
            this.izz.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.csC();
                }
            });
            this.izz.bw(this.izD);
            this.izy = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.izz);
        }
    }

    public void a(a aVar) {
        this.izB = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        this.izC = cardPersonDynamicThreadData;
        if (this.izC != null && this.izE != null) {
            if (this.izC.isPrivacy) {
                this.izE.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.izE.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            this.izE.jJ(z);
            if (this.izF != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.izF.setText(this.mContext.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.izC.blp() != null && TbSingleton.getInstance().mCallFansTid.equals(this.izC.blp().getTid())) {
                        this.izF.setText(this.mContext.getString(R.string.have_called_fans));
                    } else {
                        this.izF.setText(this.mContext.getString(R.string.call_fans));
                    }
                    this.izF.setTextColor(R.color.cp_cont_b_alpha33);
                }
                this.izF.jJ(z);
            }
        }
    }

    public void show() {
        if (this.izy != null) {
            this.izy.QH();
        }
    }

    public void csC() {
        if (this.izy != null && this.izy.isShowing()) {
            this.izy.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csD() {
        if (this.izA == null) {
            this.izA = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.izI) {
                this.izA.ny(R.string.del_dynamic_confirm);
            } else {
                this.izA.ny(R.string.del_thread_confirm);
            }
            this.izA.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                        return;
                    }
                    if (q.this.izC.from != 1) {
                        if (q.this.izC.from == 3) {
                            TiebaStatic.log(new ar("c12600").aq("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ar("c12599").aq("obj_type", 3));
                    }
                    if (q.this.izI) {
                        q.this.gfY.bb(q.this.izC.eLr);
                    }
                    q.this.gfY.a(q.this.izC.forumId, q.this.izC.forumName, q.this.izC.threadId, q.this.izC.postId, 0, 0, true, q.this.izC.eLr.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.izA.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.izA.jF(true);
            this.izA.b(this.mPageContext);
        }
    }

    public void py(boolean z) {
        this.izI = z;
    }
}
