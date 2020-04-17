package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class o {
    private com.baidu.tbadk.core.dialog.i gpR;
    private com.baidu.tbadk.core.dialog.k gpS;
    private com.baidu.tbadk.core.dialog.a gpT;
    private a gpU;
    private CardPersonDynamicThreadData gpV;
    private List<com.baidu.tbadk.core.dialog.g> gpW;
    private com.baidu.tbadk.core.dialog.g gpX;
    private com.baidu.tbadk.core.dialog.g gpY;
    private SetPrivacyModel gpZ;
    private ForumManageModel gqa;
    private boolean gqb = false;
    private SetPrivacyModel.a gqc = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.o.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (o.this.gpV.isPrivacy) {
                o.this.gpV.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.thread_has_open);
                if (o.this.gpX != null) {
                    o.this.gpX.setText(o.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (o.this.gpU != null) {
                    o.this.gpU.setPrivacy(false);
                    return;
                }
                return;
            }
            o.this.gpV.isPrivacy = true;
            if (o.this.gpX != null) {
                o.this.gpX.setText(o.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (o.this.gpU != null) {
                o.this.gpU.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, o.this.gpV.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(o.this.mContext, str);
        }
    };
    private k.b gqd = new k.b() { // from class: com.baidu.tieba.card.o.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.gpV.isPrivacy) {
                if (o.this.gpV.from == 1) {
                    TiebaStatic.log(new an("c12599").af("obj_type", 2));
                }
            } else if (o.this.gpV.from != 1) {
                if (o.this.gpV.from == 3) {
                    TiebaStatic.log(new an("c12600").af("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").af("obj_type", 1));
            }
            if (o.this.gpZ == null) {
                o.this.gpZ = new SetPrivacyModel(o.this.mPageContext, o.this.gpV);
            }
            if (!o.this.gpZ.isRunning()) {
                o.this.gpZ.a(o.this.gqc);
                o.this.gpZ.LoadData();
            }
            o.this.bET();
        }
    };
    private k.b gqe = new k.b() { // from class: com.baidu.tieba.card.o.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.gpV != null && o.this.gqa != null) {
                o.this.bEU();
                o.this.gpT.aMU();
            }
            o.this.bET();
        }
    };
    private com.baidu.adp.base.d gqf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.o.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_success);
                    if (o.this.gpV != null) {
                        if (aq.isEmpty(o.this.gpV.gtv)) {
                            if (!aq.isEmpty(o.this.gpV.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, o.this.gpV.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, o.this.gpV.gtv));
                    }
                } else if (!aq.isEmpty(bVar.kVc)) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, bVar.kVc);
                } else {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_fail);
                }
            }
        }
    };
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public o(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.gpW = new ArrayList();
            this.gpS = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.gqa = new ForumManageModel(this.mPageContext);
            this.gqa.setLoadDataCallBack(this.gqf);
        }
    }

    public void onChangeSkinType() {
        if (this.gpS != null) {
            this.gpS.onChangeSkinType();
        }
        if (this.gpT != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.gpT.getRealView());
        }
    }

    public void create() {
        if (this.gpR == null) {
            this.gpX = new com.baidu.tbadk.core.dialog.g(this.gpS);
            this.gpX.a(this.gqd);
            if (!this.gqb) {
                this.gpW.add(this.gpX);
            }
            this.gpY = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.gpS);
            this.gpY.a(this.gqe);
            this.gpW.add(this.gpY);
            this.gpS.a(new k.a() { // from class: com.baidu.tieba.card.o.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    o.this.bET();
                }
            });
            this.gpS.aI(this.gpW);
            this.gpR = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.gpS);
        }
    }

    public void a(a aVar) {
        this.gpU = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.gpV = cardPersonDynamicThreadData;
        if (this.gpV != null && this.gpX != null) {
            if (this.gpV.isPrivacy) {
                this.gpX.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.gpX.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.gpR != null) {
            this.gpR.showDialog();
        }
    }

    public void bET() {
        if (this.gpR != null && this.gpR.isShowing()) {
            this.gpR.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEU() {
        if (this.gpT == null) {
            this.gpT = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.gqb) {
                this.gpT.kd(R.string.del_dynamic_confirm);
            } else {
                this.gpT.kd(R.string.del_thread_confirm);
            }
            this.gpT.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.o.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (o.this.gpV.from != 1) {
                        if (o.this.gpV.from == 3) {
                            TiebaStatic.log(new an("c12600").af("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").af("obj_type", 3));
                    }
                    if (o.this.gqb) {
                        o.this.gqa.aY(o.this.gpV.dqA);
                    }
                    o.this.gqa.a(o.this.gpV.forumId, o.this.gpV.forumName, o.this.gpV.threadId, o.this.gpV.postId, 0, 0, true, o.this.gpV.dqA.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.gpT.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.o.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gpT.gE(true);
            this.gpT.b(this.mPageContext);
        }
    }

    public void lu(boolean z) {
        this.gqb = z;
    }
}
