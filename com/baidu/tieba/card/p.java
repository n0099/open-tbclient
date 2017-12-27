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
    private com.baidu.tieba.person.e cQh;
    private com.baidu.tieba.view.c cQi;
    private com.baidu.tbadk.core.dialog.a cQj;
    private a cQk;
    private CardPersonDynamicThreadData cQl;
    private List<c.a> cQm;
    private c.a cQn;
    private c.a cQo;
    private SetPrivacyModel cQp;
    private ForumManageModel cQq;
    private SetPrivacyModel.a cQr = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.p.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (p.this.cQl.isPrivacy) {
                p.this.cQl.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.thread_has_open);
                if (p.this.cQn != null) {
                    p.this.cQn.setText(p.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (p.this.cQk != null) {
                    p.this.cQk.setPrivacy(false);
                    return;
                }
                return;
            }
            p.this.cQl.isPrivacy = true;
            if (p.this.cQn != null) {
                p.this.cQn.setText(p.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (p.this.cQk != null) {
                p.this.cQk.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE, p.this.cQl.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(p.this.mContext, str);
        }
    };
    private c.InterfaceC0168c cQs = new c.InterfaceC0168c() { // from class: com.baidu.tieba.card.p.5
        @Override // com.baidu.tieba.view.c.InterfaceC0168c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ow()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cQl.isPrivacy) {
                if (p.this.cQl.from == 1) {
                    TiebaStatic.log(new ak("c12599").s("obj_type", 2));
                }
            } else if (p.this.cQl.from != 1) {
                if (p.this.cQl.from == 3) {
                    TiebaStatic.log(new ak("c12600").s("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ak("c12599").s("obj_type", 1));
            }
            if (p.this.cQp == null) {
                p.this.cQp = new SetPrivacyModel(p.this.mPageContext, p.this.cQl);
            }
            if (!p.this.cQp.isRunning()) {
                p.this.cQp.a(p.this.cQr);
                p.this.cQp.LoadData();
            }
            p.this.ajx();
        }
    };
    private c.InterfaceC0168c cQt = new c.InterfaceC0168c() { // from class: com.baidu.tieba.card.p.6
        @Override // com.baidu.tieba.view.c.InterfaceC0168c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ow()) {
                com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                return;
            }
            if (p.this.cQl != null && p.this.cQq != null) {
                p.this.ajy();
                p.this.cQj.AI();
            }
            p.this.ajx();
        }
    };
    private com.baidu.adp.base.d cQu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.p.7
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.delete_success);
                    if (p.this.cQl != null && !am.isEmpty(p.this.cQl.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD, p.this.cQl.threadId));
                    }
                } else if (!am.isEmpty(bVar.hlb)) {
                    com.baidu.adp.lib.util.l.showToast(p.this.mContext, bVar.hlb);
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
            this.cQm = new ArrayList();
            this.cQi = new com.baidu.tieba.view.c(this.mContext);
            this.cQq = new ForumManageModel(this.mPageContext);
            this.cQq.setLoadDataCallBack(this.cQu);
        }
    }

    public void onChangeSkinType() {
        if (this.cQi != null) {
            this.cQi.onChangeSkinType();
        }
        if (this.cQj != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cQj.AJ());
        }
    }

    public void create() {
        if (this.cQh == null) {
            this.cQn = new c.a(this.cQi);
            this.cQn.a(this.cQs);
            this.cQm.add(this.cQn);
            this.cQo = new c.a(this.mContext.getString(d.j.delete), this.cQi);
            this.cQo.a(this.cQt);
            this.cQm.add(this.cQo);
            this.cQi.a(new c.b() { // from class: com.baidu.tieba.card.p.1
                @Override // com.baidu.tieba.view.c.b
                public void onClick() {
                    p.this.ajx();
                }
            });
            this.cQi.dZ(this.cQm);
            this.cQh = new com.baidu.tieba.person.e(this.mContext, this.cQi.bKt());
        }
    }

    public void a(a aVar) {
        this.cQk = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cQl = cardPersonDynamicThreadData;
        if (this.cQl != null && this.cQn != null) {
            if (this.cQl.isPrivacy) {
                this.cQn.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.cQn.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cQh != null) {
            this.cQh.show();
        }
    }

    public void ajx() {
        if (this.cQh != null && this.cQh.isShowing()) {
            this.cQh.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajy() {
        if (this.cQj == null) {
            this.cQj = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cQj.fd(d.j.del_thread_confirm);
            this.cQj.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.p.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.ow()) {
                        com.baidu.adp.lib.util.l.showToast(p.this.mContext, d.j.neterror);
                        return;
                    }
                    if (p.this.cQl.from != 1) {
                        if (p.this.cQl.from == 3) {
                            TiebaStatic.log(new ak("c12600").s("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ak("c12599").s("obj_type", 3));
                    }
                    p.this.cQq.a(p.this.cQl.forumId, p.this.cQl.forumName, p.this.cQl.threadId, p.this.cQl.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cQj.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.p.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cQj.aV(true);
            this.cQj.b(this.mPageContext);
        }
    }
}
