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
    private com.baidu.tbadk.core.dialog.i eyo;
    private com.baidu.tbadk.core.dialog.k eyp;
    private com.baidu.tbadk.core.dialog.a eyq;
    private a eyr;
    private CardPersonDynamicThreadData eys;
    private List<com.baidu.tbadk.core.dialog.g> eyt;
    private com.baidu.tbadk.core.dialog.g eyu;
    private com.baidu.tbadk.core.dialog.g eyv;
    private SetPrivacyModel eyw;
    private ForumManageModel eyx;
    private Context mContext;
    private TbPageContext mPageContext;
    private SetPrivacyModel.a eyy = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.q.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.eys.isPrivacy) {
                q.this.eys.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.thread_has_open);
                if (q.this.eyu != null) {
                    q.this.eyu.setText(q.this.mContext.getString(R.string.set_thread_privacy));
                }
                if (q.this.eyr != null) {
                    q.this.eyr.setPrivacy(false);
                    return;
                }
                return;
            }
            q.this.eys.isPrivacy = true;
            if (q.this.eyu != null) {
                q.this.eyu.setText(q.this.mContext.getString(R.string.set_thread_public_open));
            }
            if (q.this.eyr != null) {
                q.this.eyr.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.eys.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(q.this.mContext, str);
        }
    };
    private k.b eyz = new k.b() { // from class: com.baidu.tieba.card.q.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jG()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eys.isPrivacy) {
                if (q.this.eys.from == 1) {
                    TiebaStatic.log(new am("c12599").P("obj_type", 2));
                }
            } else if (q.this.eys.from != 1) {
                if (q.this.eys.from == 3) {
                    TiebaStatic.log(new am("c12600").P("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new am("c12599").P("obj_type", 1));
            }
            if (q.this.eyw == null) {
                q.this.eyw = new SetPrivacyModel(q.this.mPageContext, q.this.eys);
            }
            if (!q.this.eyw.isRunning()) {
                q.this.eyw.a(q.this.eyy);
                q.this.eyw.LoadData();
            }
            q.this.aXH();
        }
    };
    private k.b eyA = new k.b() { // from class: com.baidu.tieba.card.q.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jG()) {
                com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                return;
            }
            if (q.this.eys != null && q.this.eyx != null) {
                q.this.aXI();
                q.this.eyq.afG();
            }
            q.this.aXH();
        }
    };
    private com.baidu.adp.base.d eyB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.q.7
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.delete_success);
                    if (q.this.eys != null && !ap.isEmpty(q.this.eys.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.eys.threadId));
                    }
                } else if (!ap.isEmpty(bVar.jbh)) {
                    com.baidu.adp.lib.util.l.showToast(q.this.mContext, bVar.jbh);
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
            this.eyt = new ArrayList();
            this.eyp = new com.baidu.tbadk.core.dialog.k(this.mContext);
            this.eyx = new ForumManageModel(this.mPageContext);
            this.eyx.setLoadDataCallBack(this.eyB);
        }
    }

    public void onChangeSkinType() {
        if (this.eyp != null) {
            this.eyp.onChangeSkinType();
        }
        if (this.eyq != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eyq.afH());
        }
    }

    public void create() {
        if (this.eyo == null) {
            this.eyu = new com.baidu.tbadk.core.dialog.g(this.eyp);
            this.eyu.a(this.eyz);
            this.eyt.add(this.eyu);
            this.eyv = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.eyp);
            this.eyv.a(this.eyA);
            this.eyt.add(this.eyv);
            this.eyp.a(new k.a() { // from class: com.baidu.tieba.card.q.1
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    q.this.aXH();
                }
            });
            this.eyp.W(this.eyt);
            this.eyo = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.eyp.afZ());
        }
    }

    public void a(a aVar) {
        this.eyr = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.eys = cardPersonDynamicThreadData;
        if (this.eys != null && this.eyu != null) {
            if (this.eys.isPrivacy) {
                this.eyu.setText(this.mContext.getString(R.string.set_thread_public_open));
            } else {
                this.eyu.setText(this.mContext.getString(R.string.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.eyo != null) {
            this.eyo.showDialog();
        }
    }

    public void aXH() {
        if (this.eyo != null && this.eyo.isShowing()) {
            this.eyo.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXI() {
        if (this.eyq == null) {
            this.eyq = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.eyq.ho(R.string.del_thread_confirm);
            this.eyq.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.q.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.jG()) {
                        com.baidu.adp.lib.util.l.showToast(q.this.mContext, (int) R.string.neterror);
                        return;
                    }
                    if (q.this.eys.from != 1) {
                        if (q.this.eys.from == 3) {
                            TiebaStatic.log(new am("c12600").P("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new am("c12599").P("obj_type", 3));
                    }
                    q.this.eyx.a(q.this.eys.forumId, q.this.eys.forumName, q.this.eys.threadId, q.this.eys.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.eyq.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.q.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eyq.dM(true);
            this.eyq.b(this.mPageContext);
        }
    }
}
