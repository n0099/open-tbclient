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
    private com.baidu.tieba.person.e ane;
    private com.baidu.tieba.view.a cVA;
    private com.baidu.tbadk.core.dialog.a cVB;
    private a cVC;
    private CardPersonDynamicThreadData cVD;
    private List<a.C0334a> cVE;
    private a.C0334a cVF;
    private a.C0334a cVG;
    private SetPrivacyModel cVH;
    private ForumManageModel cVI;
    private SetPrivacyModel.a cVJ = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.cVD.isPrivacy) {
                s.this.cVD.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.thread_has_open);
                if (s.this.cVF != null) {
                    s.this.cVF.setText(s.this.mContext.getString(e.j.set_thread_privacy));
                }
                if (s.this.cVC != null) {
                    s.this.cVC.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.cVD.isPrivacy = true;
            if (s.this.cVF != null) {
                s.this.cVF.setText(s.this.mContext.getString(e.j.set_thread_public_open));
            }
            if (s.this.cVC != null) {
                s.this.cVC.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.cVD.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c cVK = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kK()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cVD.isPrivacy) {
                if (s.this.cVD.from == 1) {
                    TiebaStatic.log(new am("c12599").x("obj_type", 2));
                }
            } else if (s.this.cVD.from != 1) {
                if (s.this.cVD.from == 3) {
                    TiebaStatic.log(new am("c12600").x("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").x("obj_type", 1));
            }
            if (s.this.cVH == null) {
                s.this.cVH = new SetPrivacyModel(s.this.mPageContext, s.this.cVD);
            }
            if (!s.this.cVH.isRunning()) {
                s.this.cVH.a(s.this.cVJ);
                s.this.cVH.LoadData();
            }
            s.this.apy();
        }
    };
    private a.c cVL = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.kK()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                return;
            }
            if (s.this.cVD != null && s.this.cVI != null) {
                s.this.apz();
                s.this.cVB.BF();
            }
            s.this.apy();
        }
    };
    private com.baidu.adp.base.d cVM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.delete_success);
                    if (s.this.cVD != null && !ao.isEmpty(s.this.cVD.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.cVD.threadId));
                    }
                } else if (!ao.isEmpty(bVar.hnI)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.hnI);
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
            this.cVE = new ArrayList();
            this.cVA = new com.baidu.tieba.view.a(this.mContext);
            this.cVI = new ForumManageModel(this.mPageContext);
            this.cVI.setLoadDataCallBack(this.cVM);
        }
    }

    public void onChangeSkinType() {
        if (this.cVA != null) {
            this.cVA.onChangeSkinType();
        }
        if (this.cVB != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cVB.BG());
        }
    }

    public void create() {
        if (this.ane == null) {
            this.cVF = new a.C0334a(this.cVA);
            this.cVF.a(this.cVK);
            this.cVE.add(this.cVF);
            this.cVG = new a.C0334a(this.mContext.getString(e.j.delete), this.cVA);
            this.cVG.a(this.cVL);
            this.cVE.add(this.cVG);
            this.cVA.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.apy();
                }
            });
            this.cVA.ed(this.cVE);
            this.ane = new com.baidu.tieba.person.e(this.mContext, this.cVA.bLZ());
        }
    }

    public void a(a aVar) {
        this.cVC = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cVD = cardPersonDynamicThreadData;
        if (this.cVD != null && this.cVF != null) {
            if (this.cVD.isPrivacy) {
                this.cVF.setText(this.mContext.getString(e.j.set_thread_public_open));
            } else {
                this.cVF.setText(this.mContext.getString(e.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.ane != null) {
            this.ane.show();
        }
    }

    public void apy() {
        if (this.ane != null && this.ane.isShowing()) {
            this.ane.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apz() {
        if (this.cVB == null) {
            this.cVB = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cVB.db(e.j.del_thread_confirm);
            this.cVB.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, e.j.neterror);
                        return;
                    }
                    if (s.this.cVD.from != 1) {
                        if (s.this.cVD.from == 3) {
                            TiebaStatic.log(new am("c12600").x("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").x("obj_type", 3));
                    }
                    s.this.cVI.a(s.this.cVD.forumId, s.this.cVD.forumName, s.this.cVD.threadId, s.this.cVD.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cVB.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cVB.bf(true);
            this.cVB.b(this.mPageContext);
        }
    }
}
