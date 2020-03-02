package com.baidu.tieba.ala.guardclub;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class l {
    private a eGc;
    private BdAlertDialog eGd;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.eGc = aVar;
    }

    public void release() {
        sN();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.eGc != null) {
            if (this.eGd == null) {
                this.eGd = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.eGd.setMessageId(a.i.guard_club_exit_desc_msg);
                this.eGd.setCancelable(true);
                this.eGd.setCanceledOnTouchOutside(true);
                this.eGd.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.eGc != null) {
                            l.this.eGc.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.eGd.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.eGd.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.eGd.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.eGd.setPositiveButtonTextColor(-57754);
                    this.eGd.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.eGd.isShowing()) {
                this.eGd.create(this.mPageContext).show();
            }
        }
    }

    private void sN() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.eGd != null) {
            this.eGd.dismiss();
            this.eGd = null;
        }
    }
}
