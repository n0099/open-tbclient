package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes10.dex */
public class m {
    private a gXb;
    private BdAlertDialog gXc;
    private TbPageContext mPageContext;

    /* loaded from: classes10.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public m(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.gXb = aVar;
    }

    public void release() {
        Ek();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.gXb != null) {
            if (this.gXc == null) {
                this.gXc = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.gXc.setMessageId(a.h.guard_club_exit_desc_msg);
                this.gXc.setCancelable(true);
                this.gXc.setCanceledOnTouchOutside(true);
                this.gXc.setPositiveButton(a.h.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (m.this.gXb != null) {
                            m.this.gXb.c(dVar, i);
                        }
                        m.this.release();
                    }
                });
                this.gXc.setNegativeButton(a.h.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        m.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gXc.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                    this.gXc.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.gXc.setPositiveButtonTextColor(-57754);
                    this.gXc.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.gXc.isShowing()) {
                this.gXc.create(this.mPageContext).show();
            }
        }
    }

    private void Ek() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.gXc != null) {
            this.gXc.dismiss();
            this.gXc = null;
        }
    }
}
