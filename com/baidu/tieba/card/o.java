package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tieba.person.e cXG;
    private com.baidu.tieba.view.c cXH;
    private com.baidu.tbadk.core.dialog.a cXI;
    private a cXJ;
    private CardPersonDynamicThreadData cXK;
    private List<c.a> cXL;
    private c.a cXM;
    private c.a cXN;
    private SetPrivacyModel cXO;
    private ForumManageModel cXP;
    private SetPrivacyModel.a cXQ = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.o.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (o.this.cXK.isPrivacy) {
                o.this.cXK.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.thread_has_open);
                if (o.this.cXM != null) {
                    o.this.cXM.setText(o.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (o.this.cXJ != null) {
                    o.this.cXJ.setPrivacy(false);
                    return;
                }
                return;
            }
            o.this.cXK.isPrivacy = true;
            if (o.this.cXM != null) {
                o.this.cXM.setText(o.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (o.this.cXJ != null) {
                o.this.cXJ.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, o.this.cXK.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(o.this.mContext, str);
        }
    };
    private c.InterfaceC0251c cXR = new c.InterfaceC0251c() { // from class: com.baidu.tieba.card.o.5
        @Override // com.baidu.tieba.view.c.InterfaceC0251c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ox()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.neterror);
                return;
            }
            if (o.this.cXK.isPrivacy) {
                if (o.this.cXK.from == 1) {
                    TiebaStatic.log(new ak("c12599").s("obj_type", 2));
                }
            } else if (o.this.cXK.from != 1) {
                if (o.this.cXK.from == 3) {
                    TiebaStatic.log(new ak("c12600").s("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ak("c12599").s("obj_type", 1));
            }
            if (o.this.cXO == null) {
                o.this.cXO = new SetPrivacyModel(o.this.mPageContext, o.this.cXK);
            }
            if (!o.this.cXO.isRunning()) {
                o.this.cXO.a(o.this.cXQ);
                o.this.cXO.LoadData();
            }
            o.this.alo();
        }
    };
    private c.InterfaceC0251c cXS = new c.InterfaceC0251c() { // from class: com.baidu.tieba.card.o.6
        @Override // com.baidu.tieba.view.c.InterfaceC0251c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ox()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.neterror);
                return;
            }
            if (o.this.cXK != null && o.this.cXP != null) {
                o.this.alp();
                o.this.cXI.AV();
            }
            o.this.alo();
        }
    };
    private com.baidu.adp.base.d cXT = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.o.7
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.delete_success);
                    if (o.this.cXK != null && !am.isEmpty(o.this.cXK.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, o.this.cXK.threadId));
                    }
                } else if (!am.isEmpty(bVar.hdt)) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, bVar.hdt);
                } else {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.delete_fail);
                }
            }
        }
    };
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public interface a {
        void setPrivacy(boolean z);
    }

    public o(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.cXL = new ArrayList();
            this.cXH = new com.baidu.tieba.view.c(this.mContext);
            this.cXP = new ForumManageModel(this.mPageContext);
            this.cXP.setLoadDataCallBack(this.cXT);
        }
    }

    public void onChangeSkinType() {
        if (this.cXH != null) {
            this.cXH.onChangeSkinType();
        }
        if (this.cXI != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cXI.AW());
        }
    }

    public void create() {
        if (this.cXG == null) {
            this.cXM = new c.a(this.cXH);
            this.cXM.a(this.cXR);
            this.cXL.add(this.cXM);
            this.cXN = new c.a(this.mContext.getString(d.j.delete), this.cXH);
            this.cXN.a(this.cXS);
            this.cXL.add(this.cXN);
            this.cXH.a(new c.b() { // from class: com.baidu.tieba.card.o.1
                @Override // com.baidu.tieba.view.c.b
                public void onClick() {
                    o.this.alo();
                }
            });
            this.cXH.dO(this.cXL);
            this.cXG = new com.baidu.tieba.person.e(this.mContext, this.cXH.bEP());
        }
    }

    public void a(a aVar) {
        this.cXJ = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cXK = cardPersonDynamicThreadData;
        if (this.cXK != null && this.cXM != null) {
            if (this.cXK.isPrivacy) {
                this.cXM.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.cXM.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cXG != null) {
            this.cXG.show();
        }
    }

    public void alo() {
        if (this.cXG != null && this.cXG.isShowing()) {
            this.cXG.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alp() {
        if (this.cXI == null) {
            this.cXI = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cXI.fb(d.j.del_thread_confirm);
            this.cXI.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.o.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.ox()) {
                        com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.neterror);
                        return;
                    }
                    if (o.this.cXK.from != 1) {
                        if (o.this.cXK.from == 3) {
                            TiebaStatic.log(new ak("c12600").s("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ak("c12599").s("obj_type", 3));
                    }
                    o.this.cXP.a(o.this.cXK.forumId, o.this.cXK.forumName, o.this.cXK.threadId, o.this.cXK.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cXI.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.o.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cXI.aZ(true);
            this.cXI.b(this.mPageContext);
        }
    }
}
