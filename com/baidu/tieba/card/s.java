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
import com.baidu.tieba.f;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class s {
    private com.baidu.tieba.person.e abp;
    private com.baidu.tieba.view.a czB;
    private com.baidu.tbadk.core.dialog.a czC;
    private a czD;
    private CardPersonDynamicThreadData czE;
    private List<a.C0251a> czF;
    private a.C0251a czG;
    private a.C0251a czH;
    private SetPrivacyModel czI;
    private ForumManageModel czJ;
    private SetPrivacyModel.a czK = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.czE.isPrivacy) {
                s.this.czE.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, f.j.thread_has_open);
                if (s.this.czG != null) {
                    s.this.czG.setText(s.this.mContext.getString(f.j.set_thread_privacy));
                }
                if (s.this.czD != null) {
                    s.this.czD.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.czE.isPrivacy = true;
            if (s.this.czG != null) {
                s.this.czG.setText(s.this.mContext.getString(f.j.set_thread_public_open));
            }
            if (s.this.czD != null) {
                s.this.czD.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.czE.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c czL = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.js()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, f.j.neterror);
                return;
            }
            if (s.this.czE.isPrivacy) {
                if (s.this.czE.from == 1) {
                    TiebaStatic.log(new an("c12599").r("obj_type", 2));
                }
            } else if (s.this.czE.from != 1) {
                if (s.this.czE.from == 3) {
                    TiebaStatic.log(new an("c12600").r("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").r("obj_type", 1));
            }
            if (s.this.czI == null) {
                s.this.czI = new SetPrivacyModel(s.this.mPageContext, s.this.czE);
            }
            if (!s.this.czI.isRunning()) {
                s.this.czI.a(s.this.czK);
                s.this.czI.LoadData();
            }
            s.this.aiW();
        }
    };
    private a.c czM = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.js()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, f.j.neterror);
                return;
            }
            if (s.this.czE != null && s.this.czJ != null) {
                s.this.aiX();
                s.this.czC.xe();
            }
            s.this.aiW();
        }
    };
    private com.baidu.adp.base.d czN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, f.j.delete_success);
                    if (s.this.czE != null && !ap.isEmpty(s.this.czE.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.czE.threadId));
                    }
                } else if (!ap.isEmpty(bVar.gQs)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.gQs);
                } else {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, f.j.delete_fail);
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
            this.czF = new ArrayList();
            this.czB = new com.baidu.tieba.view.a(this.mContext);
            this.czJ = new ForumManageModel(this.mPageContext);
            this.czJ.setLoadDataCallBack(this.czN);
        }
    }

    public void onChangeSkinType() {
        if (this.czB != null) {
            this.czB.onChangeSkinType();
        }
        if (this.czC != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.czC.xf());
        }
    }

    public void create() {
        if (this.abp == null) {
            this.czG = new a.C0251a(this.czB);
            this.czG.a(this.czL);
            this.czF.add(this.czG);
            this.czH = new a.C0251a(this.mContext.getString(f.j.delete), this.czB);
            this.czH.a(this.czM);
            this.czF.add(this.czH);
            this.czB.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.aiW();
                }
            });
            this.czB.dM(this.czF);
            this.abp = new com.baidu.tieba.person.e(this.mContext, this.czB.bEs());
        }
    }

    public void a(a aVar) {
        this.czD = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.czE = cardPersonDynamicThreadData;
        if (this.czE != null && this.czG != null) {
            if (this.czE.isPrivacy) {
                this.czG.setText(this.mContext.getString(f.j.set_thread_public_open));
            } else {
                this.czG.setText(this.mContext.getString(f.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.abp != null) {
            this.abp.show();
        }
    }

    public void aiW() {
        if (this.abp != null && this.abp.isShowing()) {
            this.abp.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiX() {
        if (this.czC == null) {
            this.czC = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.czC.cf(f.j.del_thread_confirm);
            this.czC.a(f.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.js()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, f.j.neterror);
                        return;
                    }
                    if (s.this.czE.from != 1) {
                        if (s.this.czE.from == 3) {
                            TiebaStatic.log(new an("c12600").r("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").r("obj_type", 3));
                    }
                    s.this.czJ.a(s.this.czE.forumId, s.this.czE.forumName, s.this.czE.threadId, s.this.czE.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.czC.b(f.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.czC.av(true);
            this.czC.b(this.mPageContext);
        }
    }
}
