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
    private com.baidu.tbadk.core.dialog.i fLk;
    private com.baidu.tbadk.core.dialog.k fLl;
    private com.baidu.tbadk.core.dialog.a fLm;
    private a fLn;
    private CardPersonDynamicThreadData fLo;
    private List<com.baidu.tbadk.core.dialog.g> fLp;
    private com.baidu.tbadk.core.dialog.g fLq;
    private com.baidu.tbadk.core.dialog.g fLr;
    private SetPrivacyModel fLs;
    private ForumManageModel fLt;
    private boolean fLu = false;
    private SetPrivacyModel.a fLv = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.o.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (o.this.fLo.isPrivacy) {
                o.this.fLo.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.thread_has_open);
                if (o.this.fLq != null) {
                    o.this.fLq.setText(o.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (o.this.fLn != null) {
                    o.this.fLn.setPrivacy(false);
                    return;
                }
                return;
            }
            o.this.fLo.isPrivacy = true;
            if (o.this.fLq != null) {
                o.this.fLq.setText(o.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (o.this.fLn != null) {
                o.this.fLn.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, o.this.fLo.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(o.this.mContext, str);
        }
    };
    private k.b fLw = new k.b() { // from class: com.baidu.tieba.card.o.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fLo.isPrivacy) {
                if (o.this.fLo.from == 1) {
                    TiebaStatic.log(new an("c12599").X("obj_type", 2));
                }
            } else if (o.this.fLo.from != 1) {
                if (o.this.fLo.from == 3) {
                    TiebaStatic.log(new an("c12600").X("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").X("obj_type", 1));
            }
            if (o.this.fLs == null) {
                o.this.fLs = new SetPrivacyModel(o.this.mPageContext, o.this.fLo);
            }
            if (!o.this.fLs.isRunning()) {
                o.this.fLs.a(o.this.fLv);
                o.this.fLs.LoadData();
            }
            o.this.bvh();
        }
    };
    private k.b fLx = new k.b() { // from class: com.baidu.tieba.card.o.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                return;
            }
            if (o.this.fLo != null && o.this.fLt != null) {
                o.this.bvi();
                o.this.fLm.aEG();
            }
            o.this.bvh();
        }
    };
    private com.baidu.adp.base.d fLy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.o.7
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.delete_success);
                    if (o.this.fLo != null) {
                        if (aq.isEmpty(o.this.fLo.fOO)) {
                            if (!aq.isEmpty(o.this.fLo.threadId)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, o.this.fLo.threadId));
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, o.this.fLo.fOO));
                    }
                } else if (!aq.isEmpty(bVar.kkW)) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, bVar.kkW);
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
            this.fLp = new ArrayList();
            this.fLl = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.fLt = new ForumManageModel(this.mPageContext);
            this.fLt.setLoadDataCallBack(this.fLy);
        }
    }

    public void onChangeSkinType() {
        if (this.fLl != null) {
            this.fLl.onChangeSkinType();
        }
        if (this.fLm != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fLm.getRealView());
        }
    }

    public void create() {
        if (this.fLk == null) {
            this.fLq = new com.baidu.tbadk.core.dialog.g(this.fLl);
            this.fLq.a(this.fLw);
            if (!this.fLu) {
                this.fLp.add(this.fLq);
            }
            this.fLr = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fLl);
            this.fLr.a(this.fLx);
            this.fLp.add(this.fLr);
            this.fLl.a(new k.a() { // from class: com.baidu.tieba.card.o.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    o.this.bvh();
                }
            });
            this.fLl.az(this.fLp);
            this.fLk = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fLl);
        }
    }

    public void a(a aVar) {
        this.fLn = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.fLo = cardPersonDynamicThreadData;
        if (this.fLo != null && this.fLq != null) {
            if (this.fLo.isPrivacy) {
                this.fLq.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.fLq.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.fLk != null) {
            this.fLk.showDialog();
        }
    }

    public void bvh() {
        if (this.fLk != null && this.fLk.isShowing()) {
            this.fLk.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvi() {
        if (this.fLm == null) {
            this.fLm = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            if (this.fLu) {
                this.fLm.jW(R.string.del_dynamic_confirm);
            } else {
                this.fLm.jW(R.string.del_thread_confirm);
            }
            this.fLm.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.o.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(o.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (o.this.fLo.from != 1) {
                        if (o.this.fLo.from == 3) {
                            TiebaStatic.log(new an("c12600").X("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").X("obj_type", 3));
                    }
                    if (o.this.fLu) {
                        o.this.fLt.aX(o.this.fLo.cRt);
                    }
                    o.this.fLt.a(o.this.fLo.forumId, o.this.fLo.forumName, o.this.fLo.threadId, o.this.fLo.postId, 0, 0, true, o.this.fLo.cRt.getBaijiahaoData());
                    aVar.dismiss();
                }
            });
            this.fLm.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.o.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fLm.fH(true);
            this.fLm.b(this.mPageContext);
        }
    }

    public void kr(boolean z) {
        this.fLu = z;
    }
}
