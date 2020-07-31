package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes4.dex */
public class l {
    private a fPH;
    private BdAlertDialog fPI;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.fPH = aVar;
    }

    public void release() {
        zA();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.fPH != null) {
            if (this.fPI == null) {
                this.fPI = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.fPI.setMessageId(a.i.guard_club_exit_desc_msg);
                this.fPI.setCancelable(true);
                this.fPI.setCanceledOnTouchOutside(true);
                this.fPI.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.fPH != null) {
                            l.this.fPH.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.fPI.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.fPI.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.fPI.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.fPI.setPositiveButtonTextColor(-57754);
                    this.fPI.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.fPI.isShowing()) {
                this.fPI.create(this.mPageContext).show();
            }
        }
    }

    private void zA() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.fPI != null) {
            this.fPI.dismiss();
            this.fPI = null;
        }
    }
}
