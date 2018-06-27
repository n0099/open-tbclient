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
    private com.baidu.tieba.person.e abL;
    private com.baidu.tieba.view.a cxb;
    private com.baidu.tbadk.core.dialog.a cxc;
    private a cxd;
    private CardPersonDynamicThreadData cxe;
    private List<a.C0251a> cxf;
    private a.C0251a cxg;
    private a.C0251a cxh;
    private SetPrivacyModel cxi;
    private ForumManageModel cxj;
    private SetPrivacyModel.a cxk = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.s.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (s.this.cxe.isPrivacy) {
                s.this.cxe.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.thread_has_open);
                if (s.this.cxg != null) {
                    s.this.cxg.setText(s.this.mContext.getString(d.k.set_thread_privacy));
                }
                if (s.this.cxd != null) {
                    s.this.cxd.setPrivacy(false);
                    return;
                }
                return;
            }
            s.this.cxe.isPrivacy = true;
            if (s.this.cxg != null) {
                s.this.cxg.setText(s.this.mContext.getString(d.k.set_thread_public_open));
            }
            if (s.this.cxd != null) {
                s.this.cxd.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, s.this.cxe.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(s.this.mContext, str);
        }
    };
    private a.c cxl = new a.c() { // from class: com.baidu.tieba.card.s.5
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jr()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                return;
            }
            if (s.this.cxe.isPrivacy) {
                if (s.this.cxe.from == 1) {
                    TiebaStatic.log(new an("c12599").r("obj_type", 2));
                }
            } else if (s.this.cxe.from != 1) {
                if (s.this.cxe.from == 3) {
                    TiebaStatic.log(new an("c12600").r("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new an("c12599").r("obj_type", 1));
            }
            if (s.this.cxi == null) {
                s.this.cxi = new SetPrivacyModel(s.this.mPageContext, s.this.cxe);
            }
            if (!s.this.cxi.isRunning()) {
                s.this.cxi.a(s.this.cxk);
                s.this.cxi.LoadData();
            }
            s.this.aiu();
        }
    };
    private a.c cxm = new a.c() { // from class: com.baidu.tieba.card.s.6
        @Override // com.baidu.tieba.view.a.c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.jr()) {
                com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                return;
            }
            if (s.this.cxe != null && s.this.cxj != null) {
                s.this.aiv();
                s.this.cxc.xn();
            }
            s.this.aiu();
        }
    };
    private com.baidu.adp.base.d cxn = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.s.7
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.delete_success);
                    if (s.this.cxe != null && !ap.isEmpty(s.this.cxe.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, s.this.cxe.threadId));
                    }
                } else if (!ap.isEmpty(bVar.gPt)) {
                    com.baidu.adp.lib.util.l.showToast(s.this.mContext, bVar.gPt);
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
            this.cxf = new ArrayList();
            this.cxb = new com.baidu.tieba.view.a(this.mContext);
            this.cxj = new ForumManageModel(this.mPageContext);
            this.cxj.setLoadDataCallBack(this.cxn);
        }
    }

    public void onChangeSkinType() {
        if (this.cxb != null) {
            this.cxb.onChangeSkinType();
        }
        if (this.cxc != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cxc.xo());
        }
    }

    public void create() {
        if (this.abL == null) {
            this.cxg = new a.C0251a(this.cxb);
            this.cxg.a(this.cxl);
            this.cxf.add(this.cxg);
            this.cxh = new a.C0251a(this.mContext.getString(d.k.delete), this.cxb);
            this.cxh.a(this.cxm);
            this.cxf.add(this.cxh);
            this.cxb.a(new a.b() { // from class: com.baidu.tieba.card.s.1
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    s.this.aiu();
                }
            });
            this.cxb.dQ(this.cxf);
            this.abL = new com.baidu.tieba.person.e(this.mContext, this.cxb.bFF());
        }
    }

    public void a(a aVar) {
        this.cxd = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cxe = cardPersonDynamicThreadData;
        if (this.cxe != null && this.cxg != null) {
            if (this.cxe.isPrivacy) {
                this.cxg.setText(this.mContext.getString(d.k.set_thread_public_open));
            } else {
                this.cxg.setText(this.mContext.getString(d.k.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.abL != null) {
            this.abL.show();
        }
    }

    public void aiu() {
        if (this.abL != null && this.abL.isShowing()) {
            this.abL.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiv() {
        if (this.cxc == null) {
            this.cxc = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cxc.cd(d.k.del_thread_confirm);
            this.cxc.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.s.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.jr()) {
                        com.baidu.adp.lib.util.l.showToast(s.this.mContext, d.k.neterror);
                        return;
                    }
                    if (s.this.cxe.from != 1) {
                        if (s.this.cxe.from == 3) {
                            TiebaStatic.log(new an("c12600").r("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new an("c12599").r("obj_type", 3));
                    }
                    s.this.cxj.a(s.this.cxe.forumId, s.this.cxe.forumName, s.this.cxe.threadId, s.this.cxe.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cxc.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.s.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cxc.aw(true);
            this.cxc.b(this.mPageContext);
        }
    }
}
