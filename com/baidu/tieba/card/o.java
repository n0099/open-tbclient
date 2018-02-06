package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
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
public class o {
    private com.baidu.tieba.person.e cXP;
    private com.baidu.tieba.view.c cXQ;
    private com.baidu.tbadk.core.dialog.a cXR;
    private a cXS;
    private CardPersonDynamicThreadData cXT;
    private List<c.a> cXU;
    private c.a cXV;
    private c.a cXW;
    private SetPrivacyModel cXX;
    private ForumManageModel cXY;
    private SetPrivacyModel.a cXZ = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.o.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (o.this.cXT.isPrivacy) {
                o.this.cXT.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.thread_has_open);
                if (o.this.cXV != null) {
                    o.this.cXV.setText(o.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (o.this.cXS != null) {
                    o.this.cXS.setPrivacy(false);
                    return;
                }
                return;
            }
            o.this.cXT.isPrivacy = true;
            if (o.this.cXV != null) {
                o.this.cXV.setText(o.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (o.this.cXS != null) {
                o.this.cXS.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, o.this.cXT.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(o.this.mContext, str);
        }
    };
    private c.InterfaceC0250c cYa = new c.InterfaceC0250c() { // from class: com.baidu.tieba.card.o.5
        @Override // com.baidu.tieba.view.c.InterfaceC0250c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ox()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.neterror);
                return;
            }
            if (o.this.cXT.isPrivacy) {
                if (o.this.cXT.from == 1) {
                    TiebaStatic.log(new ak("c12599").s("obj_type", 2));
                }
            } else if (o.this.cXT.from != 1) {
                if (o.this.cXT.from == 3) {
                    TiebaStatic.log(new ak("c12600").s("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ak("c12599").s("obj_type", 1));
            }
            if (o.this.cXX == null) {
                o.this.cXX = new SetPrivacyModel(o.this.mPageContext, o.this.cXT);
            }
            if (!o.this.cXX.isRunning()) {
                o.this.cXX.a(o.this.cXZ);
                o.this.cXX.LoadData();
            }
            o.this.alo();
        }
    };
    private c.InterfaceC0250c cYb = new c.InterfaceC0250c() { // from class: com.baidu.tieba.card.o.6
        @Override // com.baidu.tieba.view.c.InterfaceC0250c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ox()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.neterror);
                return;
            }
            if (o.this.cXT != null && o.this.cXY != null) {
                o.this.alp();
                o.this.cXR.AU();
            }
            o.this.alo();
        }
    };
    private com.baidu.adp.base.d cYc = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.o.7
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.delete_success);
                    if (o.this.cXT != null && !am.isEmpty(o.this.cXT.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, o.this.cXT.threadId));
                    }
                } else if (!am.isEmpty(bVar.hdk)) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, bVar.hdk);
                } else {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.delete_fail);
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

    public o(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.cXU = new ArrayList();
            this.cXQ = new com.baidu.tieba.view.c(this.mContext);
            this.cXY = new ForumManageModel(this.mPageContext);
            this.cXY.setLoadDataCallBack(this.cYc);
        }
    }

    public void onChangeSkinType() {
        if (this.cXQ != null) {
            this.cXQ.onChangeSkinType();
        }
        if (this.cXR != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cXR.AV());
        }
    }

    public void create() {
        if (this.cXP == null) {
            this.cXV = new c.a(this.cXQ);
            this.cXV.a(this.cYa);
            this.cXU.add(this.cXV);
            this.cXW = new c.a(this.mContext.getString(d.j.delete), this.cXQ);
            this.cXW.a(this.cYb);
            this.cXU.add(this.cXW);
            this.cXQ.a(new c.b() { // from class: com.baidu.tieba.card.o.1
                @Override // com.baidu.tieba.view.c.b
                public void onClick() {
                    o.this.alo();
                }
            });
            this.cXQ.dO(this.cXU);
            this.cXP = new com.baidu.tieba.person.e(this.mContext, this.cXQ.bEL());
        }
    }

    public void a(a aVar) {
        this.cXS = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cXT = cardPersonDynamicThreadData;
        if (this.cXT != null && this.cXV != null) {
            if (this.cXT.isPrivacy) {
                this.cXV.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.cXV.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cXP != null) {
            this.cXP.show();
        }
    }

    public void alo() {
        if (this.cXP != null && this.cXP.isShowing()) {
            this.cXP.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alp() {
        if (this.cXR == null) {
            this.cXR = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cXR.fb(d.j.del_thread_confirm);
            this.cXR.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.o.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.ox()) {
                        com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.neterror);
                        return;
                    }
                    if (o.this.cXT.from != 1) {
                        if (o.this.cXT.from == 3) {
                            TiebaStatic.log(new ak("c12600").s("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ak("c12599").s("obj_type", 3));
                    }
                    o.this.cXY.a(o.this.cXT.forumId, o.this.cXT.forumName, o.this.cXT.threadId, o.this.cXT.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cXR.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.o.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cXR.aZ(true);
            this.cXR.b(this.mPageContext);
        }
    }
}
