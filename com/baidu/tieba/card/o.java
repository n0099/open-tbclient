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
    private com.baidu.tbadk.core.dialog.i gpX;
    private com.baidu.tbadk.core.dialog.k gpY;
    private com.baidu.tbadk.core.dialog.a gpZ;
    private a gqa;
    private CardPersonDynamicThreadData gqb;
    private List<com.baidu.tbadk.core.dialog.g> gqc;
    private com.baidu.tbadk.core.dialog.g gqd;
    private com.baidu.tbadk.core.dialog.g gqe;
    private SetPrivacyModel gqf;
    private ForumManageModel gqg;
    private boolean gqh = false;
    private SetPrivacyModel.a gqi = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.o.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (o.this.gqb.isPrivacy) {
                o.this.gqb.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.thread_has_open);
                if (o.this.gqd != null) {
                    o.this.gqd.setText(o.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (o.this.gqa != null) {
                    o.this.gqa.setPrivacy(false);
                    return;
                }
                return;
            }
            o.this.gqb.isPrivacy = true;
            if (o.this.gqd != null) {
                o.this.gqd.setText(o.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (o.this.gqa != null) {
                o.this.gqa.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, o.this.gqb.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(o.this.mContext, str);
        }
    };
    private k.b gqj = new k.b() { // from class: com.baidu.tieba.card.o.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.gqb.isPrivacy) {
                if (o.this.gqb.from == 1) {
                    TiebaStatic.log(new an("c12599").af("obj_type", 2));
                }
            } else if (o.this.gqb.from != 1) {
                if (o.this.gqb.from == 3) {
                    TiebaStatic.log(new an("c12600").af("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").af("obj_type", 1));
            }
            if (o.this.gqf == null) {
                o.this.gqf = new SetPrivacyModel(o.this.mPageContext, o.this.gqb);
            }
            if (!o.this.gqf.isRunning()) {
                o.this.gqf.a(o.this.gqi);
                o.this.gqf.LoadData();
            }
            o.this.bES();
        }
    };
    private k.b gqk = new k.b() { // from class: com.baidu.tieba.card.o.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.gqb != null && o.this.gqg != null) {
                o.this.bET();
                o.this.gpZ.aMS();
            }
            o.this.bES();
        }
    };
    private com.baidu.adp.base.d gql = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.o.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_success);
                    if (o.this.gqb != null) {
                        if (aq.isEmpty(o.this.gqb.gtB)) {
                            if (!aq.isEmpty(o.this.gqb.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, o.this.gqb.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, o.this.gqb.gtB));
                    }
                } else if (!aq.isEmpty(bVar.kVg)) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, bVar.kVg);
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
            this.gqc = new ArrayList();
            this.gpY = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.gqg = new ForumManageModel(this.mPageContext);
            this.gqg.setLoadDataCallBack(this.gql);
        }
    }

    public void onChangeSkinType() {
        if (this.gpY != null) {
            this.gpY.onChangeSkinType();
        }
        if (this.gpZ != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.gpZ.getRealView());
        }
    }

    public void create() {
        if (this.gpX == null) {
            this.gqd = new com.baidu.tbadk.core.dialog.g(this.gpY);
            this.gqd.a(this.gqj);
            if (!this.gqh) {
                this.gqc.add(this.gqd);
            }
            this.gqe = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.gpY);
            this.gqe.a(this.gqk);
            this.gqc.add(this.gqe);
            this.gpY.a(new k.a() { // from class: com.baidu.tieba.card.o.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    o.this.bES();
                }
            });
            this.gpY.aI(this.gqc);
            this.gpX = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.gpY);
        }
    }

    public void a(a aVar) {
        this.gqa = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.gqb = cardPersonDynamicThreadData;
        if (this.gqb != null && this.gqd != null) {
            if (this.gqb.isPrivacy) {
                this.gqd.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.gqd.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.gpX != null) {
            this.gpX.showDialog();
        }
    }

    public void bES() {
        if (this.gpX != null && this.gpX.isShowing()) {
            this.gpX.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bET() {
        if (this.gpZ == null) {
            this.gpZ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.gqh) {
                this.gpZ.kd(R.string.del_dynamic_confirm);
            } else {
                this.gpZ.kd(R.string.del_thread_confirm);
            }
            this.gpZ.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.o.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (o.this.gqb.from != 1) {
                        if (o.this.gqb.from == 3) {
                            TiebaStatic.log(new an("c12600").af("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").af("obj_type", 3));
                    }
                    if (o.this.gqh) {
                        o.this.gqg.aY(o.this.gqb.dqE);
                    }
                    o.this.gqg.a(o.this.gqb.forumId, o.this.gqb.forumName, o.this.gqb.threadId, o.this.gqb.postId, 0, 0, true, o.this.gqb.dqE.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.gpZ.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.o.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gpZ.gE(true);
            this.gpZ.b(this.mPageContext);
        }
    }

    public void lu(boolean z) {
        this.gqh = z;
    }
}
