package com.baidu.tieba.ala.guardclub;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class l {
    private a eGb;
    private BdAlertDialog eGc;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.eGb = aVar;
    }

    public void release() {
        sN();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.eGb != null) {
            if (this.eGc == null) {
                this.eGc = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.eGc.setMessageId(a.i.guard_club_exit_desc_msg);
                this.eGc.setCancelable(true);
                this.eGc.setCanceledOnTouchOutside(true);
                this.eGc.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.eGb != null) {
                            l.this.eGb.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.eGc.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.eGc.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.eGc.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.eGc.setPositiveButtonTextColor(-57754);
                    this.eGc.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.eGc.isShowing()) {
                this.eGc.create(this.mPageContext).show();
            }
        }
    }

    private void sN() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.eGc != null) {
            this.eGc.dismiss();
            this.eGc = null;
        }
    }
}
