package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private com.baidu.tieba.person.e cVe;
    private com.baidu.tieba.view.c cVf;
    private com.baidu.tbadk.core.dialog.a cVg;
    private a cVh;
    private CardPersonDynamicThreadData cVi;
    private List<c.a> cVj;
    private c.a cVk;
    private c.a cVl;
    private SetPrivacyModel cVm;
    private ForumManageModel cVn;
    private SetPrivacyModel.a cVo = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.cVi.isPrivacy) {
                p.this.cVi.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.thread_has_open);
                if (p.this.cVk != null) {
                    p.this.cVk.setText(p.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (p.this.cVh != null) {
                    p.this.cVh.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.cVi.isPrivacy = true;
            if (p.this.cVk != null) {
                p.this.cVk.setText(p.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (p.this.cVh != null) {
                p.this.cVh.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.cVi.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private c.InterfaceC0168c cVp = new c.InterfaceC0168c() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.view.c.InterfaceC0168c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ox()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cVi.isPrivacy) {
                if (p.this.cVi.from == 1) {
                    TiebaStatic.log(new ak("c12599").s("obj_type", 2));
                }
            } else if (p.this.cVi.from != 1) {
                if (p.this.cVi.from == 3) {
                    TiebaStatic.log(new ak("c12600").s("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ak("c12599").s("obj_type", 1));
            }
            if (p.this.cVm == null) {
                p.this.cVm = new SetPrivacyModel(p.this.mPageContext, p.this.cVi);
            }
            if (!p.this.cVm.isRunning()) {
                p.this.cVm.a(p.this.cVo);
                p.this.cVm.LoadData();
            }
            p.this.akF();
        }
    };
    private c.InterfaceC0168c cVq = new c.InterfaceC0168c() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tieba.view.c.InterfaceC0168c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ox()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cVi != null && p.this.cVn != null) {
                p.this.akG();
                p.this.cVg.AB();
            }
            p.this.akF();
        }
    };
    private com.baidu.adp.base.d cVr = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.delete_success);
                    if (p.this.cVi != null && !am.isEmpty(p.this.cVi.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.cVi.threadId));
                    }
                } else if (!am.isEmpty(bVar.haW)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.haW);
                } else {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.delete_fail);
                }
            }
        }
    };
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public p(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.cVj = new ArrayList();
            this.cVf = new com.baidu.tieba.view.c(this.mContext);
            this.cVn = new ForumManageModel(this.mPageContext);
            this.cVn.setLoadDataCallBack(this.cVr);
        }
    }

    public void onChangeSkinType() {
        if (this.cVf != null) {
            this.cVf.onChangeSkinType();
        }
        if (this.cVg != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cVg.AC());
        }
    }

    public void create() {
        if (this.cVe == null) {
            this.cVk = new c.a(this.cVf);
            this.cVk.a(this.cVp);
            this.cVj.add(this.cVk);
            this.cVl = new c.a(this.mContext.getString(d.j.delete), this.cVf);
            this.cVl.a(this.cVq);
            this.cVj.add(this.cVl);
            this.cVf.a(new c.b() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tieba.view.c.b
                public void onClick() {
                    p.this.akF();
                }
            });
            this.cVf.dI(this.cVj);
            this.cVe = new com.baidu.tieba.person.e(this.mContext, this.cVf.bDV());
        }
    }

    public void a(a aVar) {
        this.cVh = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cVi = cardPersonDynamicThreadData;
        if (this.cVi != null && this.cVk != null) {
            if (this.cVi.isPrivacy) {
                this.cVk.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.cVk.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cVe != null) {
            this.cVe.show();
        }
    }

    public void akF() {
        if (this.cVe != null && this.cVe.isShowing()) {
            this.cVe.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akG() {
        if (this.cVg == null) {
            this.cVg = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cVg.fb(d.j.del_thread_confirm);
            this.cVg.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.ox()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                        return;
                    }
                    if (p.this.cVi.from != 1) {
                        if (p.this.cVi.from == 3) {
                            TiebaStatic.log(new ak("c12600").s("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ak("c12599").s("obj_type", 3));
                    }
                    p.this.cVn.a(p.this.cVi.forumId, p.this.cVi.forumName, p.this.cVi.threadId, p.this.cVi.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cVg.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cVg.aW(true);
            this.cVg.b(this.mPageContext);
        }
    }
}
