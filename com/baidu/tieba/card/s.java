package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class s {
    private com.baidu.tieba.person.e cqE;
    private com.baidu.tieba.view.a cqF;
    private com.baidu.tbadk.core.dialog.a cqG;
    private a cqH;
    private CardPersonDynamicThreadData cqI;
    private List<a.C0232a> cqJ;
    private a.C0232a cqK;
    private a.C0232a cqL;
    private SetPrivacyModel cqM;
    private ForumManageModel cqN;
    private SetPrivacyModel.a cqO = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.cqI.isPrivacy) {
                s.this.cqI.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.thread_has_open);
                if (s.this.cqK != null) {
                    s.this.cqK.setText(s.this.mContext.getString(d.k.set_thread_privacy));
                }
                if (s.this.cqH != null) {
                    s.this.cqH.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.cqI.isPrivacy = true;
            if (s.this.cqK != null) {
                s.this.cqK.setText(s.this.mContext.getString(d.k.set_thread_public_open));
            }
            if (s.this.cqH != null) {
                s.this.cqH.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.cqI.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c cqP = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gD()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                return;
            }
            if (s.this.cqI.isPrivacy) {
                if (s.this.cqI.from == 1) {
                    TiebaStatic.log(new al("c12599").r("obj_type", 2));
                }
            } else if (s.this.cqI.from != 1) {
                if (s.this.cqI.from == 3) {
                    TiebaStatic.log(new al("c12600").r("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new al("c12599").r("obj_type", 1));
            }
            if (s.this.cqM == null) {
                s.this.cqM = new SetPrivacyModel(s.this.mPageContext, s.this.cqI);
            }
            if (!s.this.cqM.isRunning()) {
                s.this.cqM.a(s.this.cqO);
                s.this.cqM.LoadData();
            }
            s.this.aft();
        }
    };
    private a.c cqQ = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gD()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                return;
            }
            if (s.this.cqI != null && s.this.cqN != null) {
                s.this.afu();
                s.this.cqG.tC();
            }
            s.this.aft();
        }
    };
    private com.baidu.adp.base.d cqR = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.delete_success);
                    if (s.this.cqI != null && !an.isEmpty(s.this.cqI.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.cqI.threadId));
                    }
                } else if (!an.isEmpty(bVar.gzP)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.gzP);
                } else {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.delete_fail);
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
            this.cqJ = new ArrayList();
            this.cqF = new com.baidu.tieba.view.a(this.mContext);
            this.cqN = new ForumManageModel(this.mPageContext);
            this.cqN.setLoadDataCallBack(this.cqR);
        }
    }

    public void onChangeSkinType() {
        if (this.cqF != null) {
            this.cqF.onChangeSkinType();
        }
        if (this.cqG != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cqG.tD());
        }
    }

    public void create() {
        if (this.cqE == null) {
            this.cqK = new a.C0232a(this.cqF);
            this.cqK.a(this.cqP);
            this.cqJ.add(this.cqK);
            this.cqL = new a.C0232a(this.mContext.getString(d.k.delete), this.cqF);
            this.cqL.a(this.cqQ);
            this.cqJ.add(this.cqL);
            this.cqF.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.aft();
                }
            });
            this.cqF.dI(this.cqJ);
            this.cqE = new com.baidu.tieba.person.e(this.mContext, this.cqF.bAa());
        }
    }

    public void a(a aVar) {
        this.cqH = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cqI = cardPersonDynamicThreadData;
        if (this.cqI != null && this.cqK != null) {
            if (this.cqI.isPrivacy) {
                this.cqK.setText(this.mContext.getString(d.k.set_thread_public_open));
            } else {
                this.cqK.setText(this.mContext.getString(d.k.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cqE != null) {
            this.cqE.show();
        }
    }

    public void aft() {
        if (this.cqE != null && this.cqE.isShowing()) {
            this.cqE.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afu() {
        if (this.cqG == null) {
            this.cqG = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cqG.ca(d.k.del_thread_confirm);
            this.cqG.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.gD()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                        return;
                    }
                    if (s.this.cqI.from != 1) {
                        if (s.this.cqI.from == 3) {
                            TiebaStatic.log(new al("c12600").r("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new al("c12599").r("obj_type", 3));
                    }
                    s.this.cqN.a(s.this.cqI.forumId, s.this.cqI.forumName, s.this.cqI.threadId, s.this.cqI.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cqG.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cqG.ar(true);
            this.cqG.b(this.mPageContext);
        }
    }
}
