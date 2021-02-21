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
/* loaded from: classes8.dex */
public class q {
    private ForumManageModel gev;
    private com.baidu.tbadk.core.dialog.i ixP;
    private com.baidu.tbadk.core.dialog.k ixQ;
    private com.baidu.tbadk.core.dialog.a ixR;
    private a ixS;
    private CardPersonDynamicThreadData ixT;
    private List<com.baidu.tbadk.core.dialog.g> ixU;
    private com.baidu.tbadk.core.dialog.g ixV;
    private com.baidu.tbadk.core.dialog.g ixW;
    private com.baidu.tbadk.core.dialog.g ixX;
    private SetPrivacyModel ixY;
    private com.baidu.tieba.callfans.a iya;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean ixZ = false;
    private k.b iyb = new k.b() { // from class: com.baidu.tieba.card.q.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            int i;
            int i2 = 1;
            if (q.this.ixT != null) {
                q.this.csw();
                if (q.this.ixT.from == 1) {
                    i = 2;
                } else {
                    i = q.this.ixT.from == 3 ? 1 : 1;
                }
                if (q.this.ixT == null || !q.this.ixT.isPrivacy) {
                    if (q.this.ixT.bln() != null) {
                        q.this.iya.setThreadId(q.this.ixT.bln().getTid());
                    }
                    if (TbSingleton.getInstance().mCallFansTid != null && q.this.ixT.bln() != null && TbSingleton.getInstance().mCallFansTid.equals(q.this.ixT.bln().getTid())) {
                        i2 = 2;
                    }
                    q.this.iya.crW();
                    if (q.this.ixT.bln() != null) {
                        q.this.iya.k(i, i2, q.this.ixT.bln().getTid());
                        return;
                    }
                    return;
                }
                q.this.mPageContext.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (q.this.ixT.bln() != null) {
                    q.this.iya.k(i, 3, q.this.ixT.bln().getTid());
                }
            }
        }
    };
    private SetPrivacyModel.a iyc = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.ixT.isPrivacy) {
                q.this.ixT.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.thread_has_open);
                if (q.this.ixV != null) {
                    q.this.ixV.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.ixS != null) {
                    q.this.ixS.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.ixT.isPrivacy = true;
            if (q.this.ixV != null) {
                q.this.ixV.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.ixS != null) {
                q.this.ixS.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, q.this.ixT.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b iyd = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.ixT.isPrivacy) {
                if (q.this.ixT.from == 1) {
                    TiebaStatic.log(new ar("c12599").ap("obj_type", 2));
                }
            } else if (q.this.ixT.from != 1) {
                if (q.this.ixT.from == 3) {
                    TiebaStatic.log(new ar("c12600").ap("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ar("c12599").ap("obj_type", 1));
            }
            if (q.this.ixY == null) {
                q.this.ixY = new SetPrivacyModel(q.this.mPageContext, q.this.ixT);
            }
            if (!q.this.ixY.isRunning()) {
                q.this.ixY.a(q.this.iyc);
                q.this.ixY.LoadData();
            }
            q.this.csw();
        }
    };
    private k.b iye = new k.b() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                return;
            }
            if (q.this.ixT != null && q.this.gev != null) {
                q.this.csx();
                q.this.ixR.bqx();
            }
            q.this.csw();
        }
    };
    private com.baidu.adp.base.e iyf = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.q.8
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_success);
                    if (q.this.ixT != null) {
                        if (au.isEmpty(q.this.ixT.iBP)) {
                            if (!au.isEmpty(q.this.ixT.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, q.this.ixT.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.ixT.iBP));
                    }
                } else if (!au.isEmpty(bVar.nzX)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.nzX);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public q(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.ixU = new ArrayList();
            this.ixQ = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.gev = new ForumManageModel(this.mPageContext);
            this.gev.setLoadDataCallBack(this.iyf);
            this.iya = new com.baidu.tieba.callfans.a(tbPageContext);
        }
    }

    public void onChangeSkinType() {
        if (this.ixQ != null) {
            this.ixQ.onChangeSkinType();
        }
        if (this.ixR != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.ixR.getRealView());
        }
    }

    public void create() {
        if (this.ixP == null) {
            this.ixV = new com.baidu.tbadk.core.dialog.g(this.ixQ);
            this.ixV.a(this.iyd);
            if (!this.ixZ) {
                this.ixU.add(this.ixV);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.ixZ) {
                this.ixW = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.call_fans), this.ixQ);
                this.ixW.a(this.iyb);
                this.ixU.add(this.ixW);
            }
            this.ixX = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.ixQ);
            this.ixX.a(this.iye);
            this.ixU.add(this.ixX);
            this.ixQ.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.csw();
                }
            });
            this.ixQ.bw(this.ixU);
            this.ixP = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.ixQ);
        }
    }

    public void a(a aVar) {
        this.ixS = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        this.ixT = cardPersonDynamicThreadData;
        if (this.ixT != null && this.ixV != null) {
            if (this.ixT.isPrivacy) {
                this.ixV.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.ixV.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
            this.ixV.jJ(z);
            if (this.ixW != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.ixW.setText(this.mContext.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.ixT.bln() != null && TbSingleton.getInstance().mCallFansTid.equals(this.ixT.bln().getTid())) {
                        this.ixW.setText(this.mContext.getString(R.string.have_called_fans));
                    } else {
                        this.ixW.setText(this.mContext.getString(R.string.call_fans));
                    }
                    this.ixW.setTextColor(R.color.cp_cont_b_alpha33);
                }
                this.ixW.jJ(z);
            }
        }
    }

    public void show() {
        if (this.ixP != null) {
            this.ixP.QE();
        }
    }

    public void csw() {
        if (this.ixP != null && this.ixP.isShowing()) {
            this.ixP.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csx() {
        if (this.ixR == null) {
            this.ixR = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.ixZ) {
                this.ixR.nx(R.string.del_dynamic_confirm);
            } else {
                this.ixR.nx(R.string.del_thread_confirm);
            }
            this.ixR.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, R.string.neterror);
                        return;
                    }
                    if (q.this.ixT.from != 1) {
                        if (q.this.ixT.from == 3) {
                            TiebaStatic.log(new ar("c12600").ap("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ar("c12599").ap("obj_type", 3));
                    }
                    if (q.this.ixZ) {
                        q.this.gev.bb(q.this.ixT.eJQ);
                    }
                    q.this.gev.a(q.this.ixT.forumId, q.this.ixT.forumName, q.this.ixT.threadId, q.this.ixT.postId, 0, 0, true, q.this.ixT.eJQ.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.ixR.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ixR.jF(true);
            this.ixR.b(this.mPageContext);
        }
    }

    public void py(boolean z) {
        this.ixZ = z;
    }
}
