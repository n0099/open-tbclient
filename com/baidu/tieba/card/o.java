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
    private com.baidu.tbadk.core.dialog.i fKp;
    private com.baidu.tbadk.core.dialog.k fKq;
    private com.baidu.tbadk.core.dialog.a fKr;
    private a fKs;
    private CardPersonDynamicThreadData fKt;
    private List<com.baidu.tbadk.core.dialog.g> fKu;
    private com.baidu.tbadk.core.dialog.g fKv;
    private com.baidu.tbadk.core.dialog.g fKw;
    private SetPrivacyModel fKx;
    private ForumManageModel fKy;
    private Context mContext;
    private TbPageContext mPageContext;
    private boolean fKz = false;
    private SetPrivacyModel.a fKA = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.o.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (o.this.fKt.isPrivacy) {
                o.this.fKt.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.thread_has_open);
                if (o.this.fKv != null) {
                    o.this.fKv.setText(o.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (o.this.fKs != null) {
                    o.this.fKs.setPrivacy(false);
                    return;
                }
                return;
            }
            o.this.fKt.isPrivacy = true;
            if (o.this.fKv != null) {
                o.this.fKv.setText(o.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (o.this.fKs != null) {
                o.this.fKs.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, o.this.fKt.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(o.this.mContext, str);
        }
    };
    private k.b fKB = new k.b() { // from class: com.baidu.tieba.card.o.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fKt.isPrivacy) {
                if (o.this.fKt.from == 1) {
                    TiebaStatic.log(new an("c12599").X("obj_type", 2));
                }
            } else if (o.this.fKt.from != 1) {
                if (o.this.fKt.from == 3) {
                    TiebaStatic.log(new an("c12600").X("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").X("obj_type", 1));
            }
            if (o.this.fKx == null) {
                o.this.fKx = new SetPrivacyModel(o.this.mPageContext, o.this.fKt);
            }
            if (!o.this.fKx.isRunning()) {
                o.this.fKx.a(o.this.fKA);
                o.this.fKx.LoadData();
            }
            o.this.bvb();
        }
    };
    private k.b fKC = new k.b() { // from class: com.baidu.tieba.card.o.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fKt != null && o.this.fKy != null) {
                o.this.bvc();
                o.this.fKr.aEC();
            }
            o.this.bvb();
        }
    };
    private com.baidu.adp.base.d fKD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.o.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_success);
                    if (o.this.fKt != null) {
                        if (aq.isEmpty(o.this.fKt.fNT)) {
                            if (!aq.isEmpty(o.this.fKt.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, o.this.fKt.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, o.this.fKt.fNT));
                    }
                } else if (!aq.isEmpty(bVar.kji)) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, bVar.kji);
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
            this.fKu = new ArrayList();
            this.fKq = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.fKy = new ForumManageModel(this.mPageContext);
            this.fKy.setLoadDataCallBack(this.fKD);
        }
    }

    public void onChangeSkinType() {
        if (this.fKq != null) {
            this.fKq.onChangeSkinType();
        }
        if (this.fKr != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fKr.getRealView());
        }
    }

    public void create() {
        if (this.fKp == null) {
            this.fKv = new com.baidu.tbadk.core.dialog.g(this.fKq);
            this.fKv.a(this.fKB);
            if (!this.fKz) {
                this.fKu.add(this.fKv);
            }
            this.fKw = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fKq);
            this.fKw.a(this.fKC);
            this.fKu.add(this.fKw);
            this.fKq.a(new k.a() { // from class: com.baidu.tieba.card.o.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    o.this.bvb();
                }
            });
            this.fKq.az(this.fKu);
            this.fKp = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fKq);
        }
    }

    public void a(a aVar) {
        this.fKs = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.fKt = cardPersonDynamicThreadData;
        if (this.fKt != null && this.fKv != null) {
            if (this.fKt.isPrivacy) {
                this.fKv.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.fKv.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.fKp != null) {
            this.fKp.showDialog();
        }
    }

    public void bvb() {
        if (this.fKp != null && this.fKp.isShowing()) {
            this.fKp.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvc() {
        if (this.fKr == null) {
            this.fKr = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.fKz) {
                this.fKr.jW(R.string.del_dynamic_confirm);
            } else {
                this.fKr.jW(R.string.del_thread_confirm);
            }
            this.fKr.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.o.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (o.this.fKt.from != 1) {
                        if (o.this.fKt.from == 3) {
                            TiebaStatic.log(new an("c12600").X("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").X("obj_type", 3));
                    }
                    if (o.this.fKz) {
                        o.this.fKy.aW(o.this.fKt.cRf);
                    }
                    o.this.fKy.a(o.this.fKt.forumId, o.this.fKt.forumName, o.this.fKt.threadId, o.this.fKt.postId, 0, 0, true, o.this.fKt.cRf.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.fKr.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.o.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fKr.fG(true);
            this.fKr.b(this.mPageContext);
        }
    }

    public void km(boolean z) {
        this.fKz = z;
    }
}
