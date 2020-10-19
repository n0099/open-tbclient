package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes4.dex */
public class l {
    private a grm;
    private BdAlertDialog grn;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.grm = aVar;
    }

    public void release() {
        Gz();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.grm != null) {
            if (this.grn == null) {
                this.grn = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.grn.setMessageId(a.i.guard_club_exit_desc_msg);
                this.grn.setCancelable(true);
                this.grn.setCanceledOnTouchOutside(true);
                this.grn.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.grm != null) {
                            l.this.grm.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.grn.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.grn.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.grn.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.grn.setPositiveButtonTextColor(-57754);
                    this.grn.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.grn.isShowing()) {
                this.grn.create(this.mPageContext).show();
            }
        }
    }

    private void Gz() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.grn != null) {
            this.grn.dismiss();
            this.grn = null;
        }
    }
}
