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
    private List<a.C0232a> cpA;
    private a.C0232a cpB;
    private a.C0232a cpC;
    private SetPrivacyModel cpD;
    private ForumManageModel cpE;
    private SetPrivacyModel.a cpF = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.cpz.isPrivacy) {
                s.this.cpz.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.thread_has_open);
                if (s.this.cpB != null) {
                    s.this.cpB.setText(s.this.mContext.getString(d.k.set_thread_privacy));
                }
                if (s.this.cpy != null) {
                    s.this.cpy.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.cpz.isPrivacy = true;
            if (s.this.cpB != null) {
                s.this.cpB.setText(s.this.mContext.getString(d.k.set_thread_public_open));
            }
            if (s.this.cpy != null) {
                s.this.cpy.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.cpz.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c cpG = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gD()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                return;
            }
            if (s.this.cpz.isPrivacy) {
                if (s.this.cpz.from == 1) {
                    TiebaStatic.log(new al("c12599").r("obj_type", 2));
                }
            } else if (s.this.cpz.from != 1) {
                if (s.this.cpz.from == 3) {
                    TiebaStatic.log(new al("c12600").r("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new al("c12599").r("obj_type", 1));
            }
            if (s.this.cpD == null) {
                s.this.cpD = new SetPrivacyModel(s.this.mPageContext, s.this.cpz);
            }
            if (!s.this.cpD.isRunning()) {
                s.this.cpD.a(s.this.cpF);
                s.this.cpD.LoadData();
            }
            s.this.aft();
        }
    };
    private a.c cpH = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.gD()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                return;
            }
            if (s.this.cpz != null && s.this.cpE != null) {
                s.this.afu();
                s.this.cpx.tD();
            }
            s.this.aft();
        }
    };
    private com.baidu.adp.base.d cpI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.delete_success);
                    if (s.this.cpz != null && !an.isEmpty(s.this.cpz.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.cpz.threadId));
                    }
                } else if (!an.isEmpty(bVar.gyL)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.gyL);
                } else {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.delete_fail);
                }
            }
        }
    };
    private com.baidu.tieba.person.e cpv;
    private com.baidu.tieba.view.a cpw;
    private com.baidu.tbadk.core.dialog.a cpx;
    private a cpy;
    private CardPersonDynamicThreadData cpz;
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
            this.cpA = new ArrayList();
            this.cpw = new com.baidu.tieba.view.a(this.mContext);
            this.cpE = new ForumManageModel(this.mPageContext);
            this.cpE.setLoadDataCallBack(this.cpI);
        }
    }

    public void onChangeSkinType() {
        if (this.cpw != null) {
            this.cpw.onChangeSkinType();
        }
        if (this.cpx != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cpx.tE());
        }
    }

    public void create() {
        if (this.cpv == null) {
            this.cpB = new a.C0232a(this.cpw);
            this.cpB.a(this.cpG);
            this.cpA.add(this.cpB);
            this.cpC = new a.C0232a(this.mContext.getString(d.k.delete), this.cpw);
            this.cpC.a(this.cpH);
            this.cpA.add(this.cpC);
            this.cpw.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.aft();
                }
            });
            this.cpw.dF(this.cpA);
            this.cpv = new com.baidu.tieba.person.e(this.mContext, this.cpw.bAc());
        }
    }

    public void a(a aVar) {
        this.cpy = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cpz = cardPersonDynamicThreadData;
        if (this.cpz != null && this.cpB != null) {
            if (this.cpz.isPrivacy) {
                this.cpB.setText(this.mContext.getString(d.k.set_thread_public_open));
            } else {
                this.cpB.setText(this.mContext.getString(d.k.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cpv != null) {
            this.cpv.show();
        }
    }

    public void aft() {
        if (this.cpv != null && this.cpv.isShowing()) {
            this.cpv.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afu() {
        if (this.cpx == null) {
            this.cpx = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cpx.bZ(d.k.del_thread_confirm);
            this.cpx.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.gD()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                        return;
                    }
                    if (s.this.cpz.from != 1) {
                        if (s.this.cpz.from == 3) {
                            TiebaStatic.log(new al("c12600").r("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new al("c12599").r("obj_type", 3));
                    }
                    s.this.cpE.a(s.this.cpz.forumId, s.this.cpz.forumName, s.this.cpz.threadId, s.this.cpz.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cpx.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cpx.ar(true);
            this.cpx.b(this.mPageContext);
        }
    }
}
