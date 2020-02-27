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
    private com.baidu.tbadk.core.dialog.i fKn;
    private com.baidu.tbadk.core.dialog.k fKo;
    private com.baidu.tbadk.core.dialog.a fKp;
    private a fKq;
    private CardPersonDynamicThreadData fKr;
    private List<com.baidu.tbadk.core.dialog.g> fKs;
    private com.baidu.tbadk.core.dialog.g fKt;
    private com.baidu.tbadk.core.dialog.g fKu;
    private SetPrivacyModel fKv;
    private ForumManageModel fKw;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean fKx = false;
    private SetPrivacyModel.a fKy = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.o.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (o.this.fKr.isPrivacy) {
                o.this.fKr.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.thread_has_open);
                if (o.this.fKt != null) {
                    o.this.fKt.setText(o.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (o.this.fKq != null) {
                    o.this.fKq.setPrivacy(false);
                    return;
                }
                return;
            }
            o.this.fKr.isPrivacy = true;
            if (o.this.fKt != null) {
                o.this.fKt.setText(o.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (o.this.fKq != null) {
                o.this.fKq.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, o.this.fKr.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(o.this.mContext, str);
        }
    };
    private k.b fKz = new k.b() { // from class: com.baidu.tieba.card.o.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fKr.isPrivacy) {
                if (o.this.fKr.from == 1) {
                    TiebaStatic.log(new an("c12599").X("obj_type", 2));
                }
            } else if (o.this.fKr.from != 1) {
                if (o.this.fKr.from == 3) {
                    TiebaStatic.log(new an("c12600").X("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").X("obj_type", 1));
            }
            if (o.this.fKv == null) {
                o.this.fKv = new SetPrivacyModel(o.this.mPageContext, o.this.fKr);
            }
            if (!o.this.fKv.isRunning()) {
                o.this.fKv.a(o.this.fKy);
                o.this.fKv.LoadData();
            }
            o.this.buZ();
        }
    };
    private k.b fKA = new k.b() { // from class: com.baidu.tieba.card.o.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fKr != null && o.this.fKw != null) {
                o.this.bva();
                o.this.fKp.aEA();
            }
            o.this.buZ();
        }
    };
    private com.baidu.adp.base.d fKB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.o.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_success);
                    if (o.this.fKr != null) {
                        if (aq.isEmpty(o.this.fKr.fNR)) {
                            if (!aq.isEmpty(o.this.fKr.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, o.this.fKr.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, o.this.fKr.fNR));
                    }
                } else if (!aq.isEmpty(bVar.kjg)) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, bVar.kjg);
                } else {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public o(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.fKs = new ArrayList();
            this.fKo = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.fKw = new ForumManageModel(this.mPageContext);
            this.fKw.setLoadDataCallBack(this.fKB);
        }
    }

    public void onChangeSkinType() {
        if (this.fKo != null) {
            this.fKo.onChangeSkinType();
        }
        if (this.fKp != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fKp.getRealView());
        }
    }

    public void create() {
        if (this.fKn == null) {
            this.fKt = new com.baidu.tbadk.core.dialog.g(this.fKo);
            this.fKt.a(this.fKz);
            if (!this.fKx) {
                this.fKs.add(this.fKt);
            }
            this.fKu = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fKo);
            this.fKu.a(this.fKA);
            this.fKs.add(this.fKu);
            this.fKo.a(new k.a() { // from class: com.baidu.tieba.card.o.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    o.this.buZ();
                }
            });
            this.fKo.az(this.fKs);
            this.fKn = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fKo);
        }
    }

    public void a(a aVar) {
        this.fKq = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.fKr = cardPersonDynamicThreadData;
        if (this.fKr != null && this.fKt != null) {
            if (this.fKr.isPrivacy) {
                this.fKt.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.fKt.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.fKn != null) {
            this.fKn.showDialog();
        }
    }

    public void buZ() {
        if (this.fKn != null && this.fKn.isShowing()) {
            this.fKn.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bva() {
        if (this.fKp == null) {
            this.fKp = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.fKx) {
                this.fKp.jW(R.string.del_dynamic_confirm);
            } else {
                this.fKp.jW(R.string.del_thread_confirm);
            }
            this.fKp.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.o.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (o.this.fKr.from != 1) {
                        if (o.this.fKr.from == 3) {
                            TiebaStatic.log(new an("c12600").X("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").X("obj_type", 3));
                    }
                    if (o.this.fKx) {
                        o.this.fKw.aW(o.this.fKr.cRe);
                    }
                    o.this.fKw.a(o.this.fKr.forumId, o.this.fKr.forumName, o.this.fKr.threadId, o.this.fKr.postId, 0, 0, true, o.this.fKr.cRe.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.fKp.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.o.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fKp.fG(true);
            this.fKp.b(this.mPageContext);
        }
    }

    public void km(boolean z) {
        this.fKx = z;
    }
}
