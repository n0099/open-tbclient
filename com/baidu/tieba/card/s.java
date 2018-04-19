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
    private com.baidu.tbadk.core.dialog.a cpA;
    private a cpB;
    private CardPersonDynamicThreadData cpC;
    private List<a.C0232a> cpD;
    private a.C0232a cpE;
    private a.C0232a cpF;
    private SetPrivacyModel cpG;
    private ForumManageModel cpH;
    private SetPrivacyModel.a cpI = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.cpC.isPrivacy) {
                s.this.cpC.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.thread_has_open);
                if (s.this.cpE != null) {
                    s.this.cpE.setText(s.this.mContext.getString(d.k.set_thread_privacy));
                }
                if (s.this.cpB != null) {
                    s.this.cpB.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.cpC.isPrivacy = true;
            if (s.this.cpE != null) {
                s.this.cpE.setText(s.this.mContext.getString(d.k.set_thread_public_open));
            }
            if (s.this.cpB != null) {
                s.this.cpB.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.cpC.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c cpJ = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gD()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                return;
            }
            if (s.this.cpC.isPrivacy) {
                if (s.this.cpC.from == 1) {
                    TiebaStatic.log(new al("c12599").r("obj_type", 2));
                }
            } else if (s.this.cpC.from != 1) {
                if (s.this.cpC.from == 3) {
                    TiebaStatic.log(new al("c12600").r("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new al("c12599").r("obj_type", 1));
            }
            if (s.this.cpG == null) {
                s.this.cpG = new SetPrivacyModel(s.this.mPageContext, s.this.cpC);
            }
            if (!s.this.cpG.isRunning()) {
                s.this.cpG.a(s.this.cpI);
                s.this.cpG.LoadData();
            }
            s.this.aft();
        }
    };
    private a.c cpK = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gD()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                return;
            }
            if (s.this.cpC != null && s.this.cpH != null) {
                s.this.afu();
                s.this.cpA.tD();
            }
            s.this.aft();
        }
    };
    private com.baidu.adp.base.d cpL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.delete_success);
                    if (s.this.cpC != null && !an.isEmpty(s.this.cpC.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.cpC.threadId));
                    }
                } else if (!an.isEmpty(bVar.gyO)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.gyO);
                } else {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.delete_fail);
                }
            }
        }
    };
    private com.baidu.tieba.person.e cpy;
    private com.baidu.tieba.view.a cpz;
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
            this.cpD = new ArrayList();
            this.cpz = new com.baidu.tieba.view.a(this.mContext);
            this.cpH = new ForumManageModel(this.mPageContext);
            this.cpH.setLoadDataCallBack(this.cpL);
        }
    }

    public void onChangeSkinType() {
        if (this.cpz != null) {
            this.cpz.onChangeSkinType();
        }
        if (this.cpA != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cpA.tE());
        }
    }

    public void create() {
        if (this.cpy == null) {
            this.cpE = new a.C0232a(this.cpz);
            this.cpE.a(this.cpJ);
            this.cpD.add(this.cpE);
            this.cpF = new a.C0232a(this.mContext.getString(d.k.delete), this.cpz);
            this.cpF.a(this.cpK);
            this.cpD.add(this.cpF);
            this.cpz.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.aft();
                }
            });
            this.cpz.dF(this.cpD);
            this.cpy = new com.baidu.tieba.person.e(this.mContext, this.cpz.bAc());
        }
    }

    public void a(a aVar) {
        this.cpB = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cpC = cardPersonDynamicThreadData;
        if (this.cpC != null && this.cpE != null) {
            if (this.cpC.isPrivacy) {
                this.cpE.setText(this.mContext.getString(d.k.set_thread_public_open));
            } else {
                this.cpE.setText(this.mContext.getString(d.k.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cpy != null) {
            this.cpy.show();
        }
    }

    public void aft() {
        if (this.cpy != null && this.cpy.isShowing()) {
            this.cpy.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afu() {
        if (this.cpA == null) {
            this.cpA = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cpA.bZ(d.k.del_thread_confirm);
            this.cpA.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.gD()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                        return;
                    }
                    if (s.this.cpC.from != 1) {
                        if (s.this.cpC.from == 3) {
                            TiebaStatic.log(new al("c12600").r("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new al("c12599").r("obj_type", 3));
                    }
                    s.this.cpH.a(s.this.cpC.forumId, s.this.cpC.forumName, s.this.cpC.threadId, s.this.cpC.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cpA.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cpA.ar(true);
            this.cpA.b(this.mPageContext);
        }
    }
}
