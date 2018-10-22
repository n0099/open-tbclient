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
    private com.baidu.tieba.person.e aiP;
    private com.baidu.tieba.view.a cNN;
    private com.baidu.tbadk.core.dialog.a cNO;
    private a cNP;
    private CardPersonDynamicThreadData cNQ;
    private List<a.C0292a> cNR;
    private a.C0292a cNS;
    private a.C0292a cNT;
    private SetPrivacyModel cNU;
    private ForumManageModel cNV;
    private SetPrivacyModel.a cNW = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.cNQ.isPrivacy) {
                s.this.cNQ.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.thread_has_open);
                if (s.this.cNS != null) {
                    s.this.cNS.setText(s.this.mContext.getString(e.j.set_thread_privacy));
                }
                if (s.this.cNP != null) {
                    s.this.cNP.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.cNQ.isPrivacy = true;
            if (s.this.cNS != null) {
                s.this.cNS.setText(s.this.mContext.getString(e.j.set_thread_public_open));
            }
            if (s.this.cNP != null) {
                s.this.cNP.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.cNQ.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c cNX = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kM()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cNQ.isPrivacy) {
                if (s.this.cNQ.from == 1) {
                    TiebaStatic.log(new am("c12599").x("obj_type", 2));
                }
            } else if (s.this.cNQ.from != 1) {
                if (s.this.cNQ.from == 3) {
                    TiebaStatic.log(new am("c12600").x("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").x("obj_type", 1));
            }
            if (s.this.cNU == null) {
                s.this.cNU = new SetPrivacyModel(s.this.mPageContext, s.this.cNQ);
            }
            if (!s.this.cNU.isRunning()) {
                s.this.cNU.a(s.this.cNW);
                s.this.cNU.LoadData();
            }
            s.this.aok();
        }
    };
    private a.c cNY = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kM()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cNQ != null && s.this.cNV != null) {
                s.this.aol();
                s.this.cNO.Au();
            }
            s.this.aok();
        }
    };
    private com.baidu.adp.base.d cNZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.delete_success);
                    if (s.this.cNQ != null && !ao.isEmpty(s.this.cNQ.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.cNQ.threadId));
                    }
                } else if (!ao.isEmpty(bVar.hfr)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.hfr);
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
            this.cNR = new ArrayList();
            this.cNN = new com.baidu.tieba.view.a(this.mContext);
            this.cNV = new ForumManageModel(this.mPageContext);
            this.cNV.setLoadDataCallBack(this.cNZ);
        }
    }

    public void onChangeSkinType() {
        if (this.cNN != null) {
            this.cNN.onChangeSkinType();
        }
        if (this.cNO != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cNO.Av());
        }
    }

    public void create() {
        if (this.aiP == null) {
            this.cNS = new a.C0292a(this.cNN);
            this.cNS.a(this.cNX);
            this.cNR.add(this.cNS);
            this.cNT = new a.C0292a(this.mContext.getString(e.j.delete), this.cNN);
            this.cNT.a(this.cNY);
            this.cNR.add(this.cNT);
            this.cNN.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.aok();
                }
            });
            this.cNN.eb(this.cNR);
            this.aiP = new com.baidu.tieba.person.e(this.mContext, this.cNN.bKv());
        }
    }

    public void a(a aVar) {
        this.cNP = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cNQ = cardPersonDynamicThreadData;
        if (this.cNQ != null && this.cNS != null) {
            if (this.cNQ.isPrivacy) {
                this.cNS.setText(this.mContext.getString(e.j.set_thread_public_open));
            } else {
                this.cNS.setText(this.mContext.getString(e.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.aiP != null) {
            this.aiP.show();
        }
    }

    public void aok() {
        if (this.aiP != null && this.aiP.isShowing()) {
            this.aiP.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aol() {
        if (this.cNO == null) {
            this.cNO = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cNO.cz(e.j.del_thread_confirm);
            this.cNO.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.kM()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                        return;
                    }
                    if (s.this.cNQ.from != 1) {
                        if (s.this.cNQ.from == 3) {
                            TiebaStatic.log(new am("c12600").x("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").x("obj_type", 3));
                    }
                    s.this.cNV.a(s.this.cNQ.forumId, s.this.cNQ.forumName, s.this.cNQ.threadId, s.this.cNQ.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cNO.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cNO.aO(true);
            this.cNO.b(this.mPageContext);
        }
    }
}
