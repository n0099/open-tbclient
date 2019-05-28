package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class q {
    private com.baidu.tbadk.core.dialog.i eyp;
    private com.baidu.tbadk.core.dialog.k eyq;
    private com.baidu.tbadk.core.dialog.a eyr;
    private a eys;
    private CardPersonDynamicThreadData eyt;
    private List<com.baidu.tbadk.core.dialog.g> eyu;
    private com.baidu.tbadk.core.dialog.g eyv;
    private com.baidu.tbadk.core.dialog.g eyw;
    private SetPrivacyModel eyx;
    private ForumManageModel eyy;
    private Context mContext;
    private TbPageContext mPageContext;
    private SetPrivacyModel.a eyz = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.eyt.isPrivacy) {
                q.this.eyt.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.thread_has_open);
                if (q.this.eyv != null) {
                    q.this.eyv.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.eys != null) {
                    q.this.eys.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.eyt.isPrivacy = true;
            if (q.this.eyv != null) {
                q.this.eyv.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.eys != null) {
                q.this.eys.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.eyt.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b eyA = new k.b() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jG()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eyt.isPrivacy) {
                if (q.this.eyt.from == 1) {
                    TiebaStatic.log(new am("c12599").P("obj_type", 2));
                }
            } else if (q.this.eyt.from != 1) {
                if (q.this.eyt.from == 3) {
                    TiebaStatic.log(new am("c12600").P("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").P("obj_type", 1));
            }
            if (q.this.eyx == null) {
                q.this.eyx = new SetPrivacyModel(q.this.mPageContext, q.this.eyt);
            }
            if (!q.this.eyx.isRunning()) {
                q.this.eyx.a(q.this.eyz);
                q.this.eyx.LoadData();
            }
            q.this.aXK();
        }
    };
    private k.b eyB = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jG()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eyt != null && q.this.eyy != null) {
                q.this.aXL();
                q.this.eyr.afG();
            }
            q.this.aXK();
        }
    };
    private com.baidu.adp.base.d eyC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_success);
                    if (q.this.eyt != null && !ap.isEmpty(q.this.eyt.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.eyt.threadId));
                    }
                } else if (!ap.isEmpty(bVar.jbj)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.jbj);
                } else {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_fail);
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public q(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.eyu = new ArrayList();
            this.eyq = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.eyy = new ForumManageModel(this.mPageContext);
            this.eyy.setLoadDataCallBack(this.eyC);
        }
    }

    public void onChangeSkinType() {
        if (this.eyq != null) {
            this.eyq.onChangeSkinType();
        }
        if (this.eyr != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eyr.afH());
        }
    }

    public void create() {
        if (this.eyp == null) {
            this.eyv = new com.baidu.tbadk.core.dialog.g(this.eyq);
            this.eyv.a(this.eyA);
            this.eyu.add(this.eyv);
            this.eyw = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.eyq);
            this.eyw.a(this.eyB);
            this.eyu.add(this.eyw);
            this.eyq.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.aXK();
                }
            });
            this.eyq.W(this.eyu);
            this.eyp = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.eyq.afZ());
        }
    }

    public void a(a aVar) {
        this.eys = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.eyt = cardPersonDynamicThreadData;
        if (this.eyt != null && this.eyv != null) {
            if (this.eyt.isPrivacy) {
                this.eyv.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.eyv.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.eyp != null) {
            this.eyp.showDialog();
        }
    }

    public void aXK() {
        if (this.eyp != null && this.eyp.isShowing()) {
            this.eyp.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXL() {
        if (this.eyr == null) {
            this.eyr = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.eyr.ho(R.string.del_thread_confirm);
            this.eyr.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.jG()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (q.this.eyt.from != 1) {
                        if (q.this.eyt.from == 3) {
                            TiebaStatic.log(new am("c12600").P("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").P("obj_type", 3));
                    }
                    q.this.eyy.a(q.this.eyt.forumId, q.this.eyt.forumName, q.this.eyt.threadId, q.this.eyt.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.eyr.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eyr.dM(true);
            this.eyr.b(this.mPageContext);
        }
    }
}
