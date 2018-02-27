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
    private com.baidu.tieba.person.e cXD;
    private com.baidu.tieba.view.c cXE;
    private com.baidu.tbadk.core.dialog.a cXF;
    private a cXG;
    private CardPersonDynamicThreadData cXH;
    private List<c.a> cXI;
    private c.a cXJ;
    private c.a cXK;
    private SetPrivacyModel cXL;
    private ForumManageModel cXM;
    private SetPrivacyModel.a cXN = new SetPrivacyModel.a() { // from class: com.baidu.tieba.card.o.4
        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (o.this.cXH.isPrivacy) {
                o.this.cXH.isPrivacy = false;
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.thread_has_open);
                if (o.this.cXJ != null) {
                    o.this.cXJ.setText(o.this.mContext.getString(d.j.set_thread_privacy));
                }
                if (o.this.cXG != null) {
                    o.this.cXG.setPrivacy(false);
                    return;
                }
                return;
            }
            o.this.cXH.isPrivacy = true;
            if (o.this.cXJ != null) {
                o.this.cXJ.setText(o.this.mContext.getString(d.j.set_thread_public_open));
            }
            if (o.this.cXG != null) {
                o.this.cXG.setPrivacy(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, o.this.cXH.threadId));
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            com.baidu.adp.lib.util.l.showToast(o.this.mContext, str);
        }
    };
    private c.InterfaceC0251c cXO = new c.InterfaceC0251c() { // from class: com.baidu.tieba.card.o.5
        @Override // com.baidu.tieba.view.c.InterfaceC0251c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ox()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.neterror);
                return;
            }
            if (o.this.cXH.isPrivacy) {
                if (o.this.cXH.from == 1) {
                    TiebaStatic.log(new ak("c12599").s("obj_type", 2));
                }
            } else if (o.this.cXH.from != 1) {
                if (o.this.cXH.from == 3) {
                    TiebaStatic.log(new ak("c12600").s("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new ak("c12599").s("obj_type", 1));
            }
            if (o.this.cXL == null) {
                o.this.cXL = new SetPrivacyModel(o.this.mPageContext, o.this.cXH);
            }
            if (!o.this.cXL.isRunning()) {
                o.this.cXL.a(o.this.cXN);
                o.this.cXL.LoadData();
            }
            o.this.aln();
        }
    };
    private c.InterfaceC0251c cXP = new c.InterfaceC0251c() { // from class: com.baidu.tieba.card.o.6
        @Override // com.baidu.tieba.view.c.InterfaceC0251c
        public void onClick() {
            if (!com.baidu.adp.lib.util.j.ox()) {
                com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.neterror);
                return;
            }
            if (o.this.cXH != null && o.this.cXM != null) {
                o.this.alo();
                o.this.cXF.AU();
            }
            o.this.aln();
        }
    };
    private com.baidu.adp.base.d cXQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.o.7
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.mErrCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.delete_success);
                    if (o.this.cXH != null && !am.isEmpty(o.this.cXH.threadId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, o.this.cXH.threadId));
                    }
                } else if (!am.isEmpty(bVar.hcV)) {
                    com.baidu.adp.lib.util.l.showToast(o.this.mContext, bVar.hcV);
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
            this.cXI = new ArrayList();
            this.cXE = new com.baidu.tieba.view.c(this.mContext);
            this.cXM = new ForumManageModel(this.mPageContext);
            this.cXM.setLoadDataCallBack(this.cXQ);
        }
    }

    public void onChangeSkinType() {
        if (this.cXE != null) {
            this.cXE.onChangeSkinType();
        }
        if (this.cXF != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cXF.AV());
        }
    }

    public void create() {
        if (this.cXD == null) {
            this.cXJ = new c.a(this.cXE);
            this.cXJ.a(this.cXO);
            this.cXI.add(this.cXJ);
            this.cXK = new c.a(this.mContext.getString(d.j.delete), this.cXE);
            this.cXK.a(this.cXP);
            this.cXI.add(this.cXK);
            this.cXE.a(new c.b() { // from class: com.baidu.tieba.card.o.1
                @Override // com.baidu.tieba.view.c.b
                public void onClick() {
                    o.this.aln();
                }
            });
            this.cXE.dO(this.cXI);
            this.cXD = new com.baidu.tieba.person.e(this.mContext, this.cXE.bEK());
        }
    }

    public void a(a aVar) {
        this.cXG = aVar;
    }

    public void a(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        this.cXH = cardPersonDynamicThreadData;
        if (this.cXH != null && this.cXJ != null) {
            if (this.cXH.isPrivacy) {
                this.cXJ.setText(this.mContext.getString(d.j.set_thread_public_open));
            } else {
                this.cXJ.setText(this.mContext.getString(d.j.set_thread_privacy));
            }
        }
    }

    public void show() {
        if (this.cXD != null) {
            this.cXD.show();
        }
    }

    public void aln() {
        if (this.cXD != null && this.cXD.isShowing()) {
            this.cXD.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alo() {
        if (this.cXF == null) {
            this.cXF = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.cXF.fb(d.j.del_thread_confirm);
            this.cXF.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.o.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (!com.baidu.adp.lib.util.j.ox()) {
                        com.baidu.adp.lib.util.l.showToast(o.this.mContext, d.j.neterror);
                        return;
                    }
                    if (o.this.cXH.from != 1) {
                        if (o.this.cXH.from == 3) {
                            TiebaStatic.log(new ak("c12600").s("obj_type", 1));
                        }
                    } else {
                        TiebaStatic.log(new ak("c12599").s("obj_type", 3));
                    }
                    o.this.cXM.a(o.this.cXH.forumId, o.this.cXH.forumName, o.this.cXH.threadId, o.this.cXH.postId, 0, 0, true);
                    aVar.dismiss();
                }
            });
            this.cXF.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.o.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.cXF.aZ(true);
            this.cXF.b(this.mPageContext);
        }
    }
}
