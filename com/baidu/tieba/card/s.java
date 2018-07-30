package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class s {
    private com.baidu.tieba.person.e abo;
    private com.baidu.tieba.view.a czE;
    private com.baidu.tbadk.core.dialog.a czF;
    private a czG;
    private CardPersonDynamicThreadData czH;
    private List<a.C0251a> czI;
    private a.C0251a czJ;
    private a.C0251a czK;
    private SetPrivacyModel czL;
    private ForumManageModel czM;
    private SetPrivacyModel.a czN = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.czH.isPrivacy) {
                s.this.czH.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.j.thread_has_open);
                if (s.this.czJ != null) {
                    s.this.czJ.setText(s.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (s.this.czG != null) {
                    s.this.czG.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.czH.isPrivacy = true;
            if (s.this.czJ != null) {
                s.this.czJ.setText(s.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (s.this.czG != null) {
                s.this.czG.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.czH.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c czO = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.js()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.j.neterror);
                return;
            }
            if (s.this.czH.isPrivacy) {
                if (s.this.czH.from == 1) {
                    TiebaStatic.log(new an("c12599").r("obj_type", 2));
                }
            } else if (s.this.czH.from != 1) {
                if (s.this.czH.from == 3) {
                    TiebaStatic.log(new an("c12600").r("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").r("obj_type", 1));
            }
            if (s.this.czL == null) {
                s.this.czL = new SetPrivacyModel(s.this.mPageContext, s.this.czH);
            }
            if (!s.this.czL.isRunning()) {
                s.this.czL.a(s.this.czN);
                s.this.czL.LoadData();
            }
            s.this.aiT();
        }
    };
    private a.c czP = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.js()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.j.neterror);
                return;
            }
            if (s.this.czH != null && s.this.czM != null) {
                s.this.aiU();
                s.this.czF.xf();
            }
            s.this.aiT();
        }
    };
    private com.baidu.adp.base.d czQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.j.delete_success);
                    if (s.this.czH != null && !ap.isEmpty(s.this.czH.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.czH.threadId));
                    }
                } else if (!ap.isEmpty(bVar.gQr)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.gQr);
                } else {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.j.delete_fail);
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
            this.czI = new ArrayList();
            this.czE = new com.baidu.tieba.view.a(this.mContext);
            this.czM = new ForumManageModel(this.mPageContext);
            this.czM.setLoadDataCallBack(this.czQ);
        }
    }

    public void onChangeSkinType() {
        if (this.czE != null) {
            this.czE.onChangeSkinType();
        }
        if (this.czF != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.czF.xg());
        }
    }

    public void create() {
        if (this.abo == null) {
            this.czJ = new a.C0251a(this.czE);
            this.czJ.a(this.czO);
            this.czI.add(this.czJ);
            this.czK = new a.C0251a(this.mContext.getString(d.j.delete), this.czE);
            this.czK.a(this.czP);
            this.czI.add(this.czK);
            this.czE.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.aiT();
                }
            });
            this.czE.dM(this.czI);
            this.abo = new com.baidu.tieba.person.e(this.mContext, this.czE.bEq());
        }
    }

    public void a(a aVar) {
        this.czG = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.czH = cardPersonDynamicThreadData;
        if (this.czH != null && this.czJ != null) {
            if (this.czH.isPrivacy) {
                this.czJ.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.czJ.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.abo != null) {
            this.abo.show();
        }
    }

    public void aiT() {
        if (this.abo != null && this.abo.isShowing()) {
            this.abo.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiU() {
        if (this.czF == null) {
            this.czF = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.czF.cf(d.j.del_thread_confirm);
            this.czF.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.js()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.j.neterror);
                        return;
                    }
                    if (s.this.czH.from != 1) {
                        if (s.this.czH.from == 3) {
                            TiebaStatic.log(new an("c12600").r("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").r("obj_type", 3));
                    }
                    s.this.czM.a(s.this.czH.forumId, s.this.czH.forumName, s.this.czH.threadId, s.this.czH.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.czF.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.czF.au(true);
            this.czF.b(this.mPageContext);
        }
    }
}
