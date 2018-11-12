package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.e;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class s {
    private com.baidu.tieba.person.e ajC;
    private com.baidu.tieba.view.a cOT;
    private com.baidu.tbadk.core.dialog.a cOU;
    private a cOV;
    private CardPersonDynamicThreadData cOW;
    private List<a.C0320a> cOX;
    private a.C0320a cOY;
    private a.C0320a cOZ;
    private SetPrivacyModel cPa;
    private ForumManageModel cPb;
    private SetPrivacyModel.a cPc = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.cOW.isPrivacy) {
                s.this.cOW.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.thread_has_open);
                if (s.this.cOY != null) {
                    s.this.cOY.setText(s.this.mContext.getString(e.j.set_thread_privacy));
                }
                if (s.this.cOV != null) {
                    s.this.cOV.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.cOW.isPrivacy = true;
            if (s.this.cOY != null) {
                s.this.cOY.setText(s.this.mContext.getString(e.j.set_thread_public_open));
            }
            if (s.this.cOV != null) {
                s.this.cOV.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.cOW.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c cPd = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kK()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cOW.isPrivacy) {
                if (s.this.cOW.from == 1) {
                    TiebaStatic.log(new am("c12599").x("obj_type", 2));
                }
            } else if (s.this.cOW.from != 1) {
                if (s.this.cOW.from == 3) {
                    TiebaStatic.log(new am("c12600").x("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").x("obj_type", 1));
            }
            if (s.this.cPa == null) {
                s.this.cPa = new SetPrivacyModel(s.this.mPageContext, s.this.cOW);
            }
            if (!s.this.cPa.isRunning()) {
                s.this.cPa.a(s.this.cPc);
                s.this.cPa.LoadData();
            }
            s.this.anL();
        }
    };
    private a.c cPe = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kK()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cOW != null && s.this.cPb != null) {
                s.this.anM();
                s.this.cOU.AB();
            }
            s.this.anL();
        }
    };
    private com.baidu.adp.base.d cPf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.delete_success);
                    if (s.this.cOW != null && !ao.isEmpty(s.this.cOW.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.cOW.threadId));
                    }
                } else if (!ao.isEmpty(bVar.hgO)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.hgO);
                } else {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.delete_fail);
                }
            }
        }
    };
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public s(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.cOX = new ArrayList();
            this.cOT = new com.baidu.tieba.view.a(this.mContext);
            this.cPb = new ForumManageModel(this.mPageContext);
            this.cPb.setLoadDataCallBack(this.cPf);
        }
    }

    public void onChangeSkinType() {
        if (this.cOT != null) {
            this.cOT.onChangeSkinType();
        }
        if (this.cOU != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cOU.AC());
        }
    }

    public void create() {
        if (this.ajC == null) {
            this.cOY = new a.C0320a(this.cOT);
            this.cOY.a(this.cPd);
            this.cOX.add(this.cOY);
            this.cOZ = new a.C0320a(this.mContext.getString(e.j.delete), this.cOT);
            this.cOZ.a(this.cPe);
            this.cOX.add(this.cOZ);
            this.cOT.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.anL();
                }
            });
            this.cOT.dZ(this.cOX);
            this.ajC = new com.baidu.tieba.person.e(this.mContext, this.cOT.bJU());
        }
    }

    public void a(a aVar) {
        this.cOV = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cOW = cardPersonDynamicThreadData;
        if (this.cOW != null && this.cOY != null) {
            if (this.cOW.isPrivacy) {
                this.cOY.setText(this.mContext.getString(e.j.set_thread_public_open));
            } else {
                this.cOY.setText(this.mContext.getString(e.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.ajC != null) {
            this.ajC.show();
        }
    }

    public void anL() {
        if (this.ajC != null && this.ajC.isShowing()) {
            this.ajC.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anM() {
        if (this.cOU == null) {
            this.cOU = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cOU.cN(e.j.del_thread_confirm);
            this.cOU.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                        return;
                    }
                    if (s.this.cOW.from != 1) {
                        if (s.this.cOW.from == 3) {
                            TiebaStatic.log(new am("c12600").x("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").x("obj_type", 3));
                    }
                    s.this.cPb.a(s.this.cOW.forumId, s.this.cOW.forumName, s.this.cOW.threadId, s.this.cOW.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cOU.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cOU.be(true);
            this.cOU.b(this.mPageContext);
        }
    }
}
