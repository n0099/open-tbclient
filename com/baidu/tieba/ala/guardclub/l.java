package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes3.dex */
public class l {
    private a fKm;
    private BdAlertDialog fKn;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.fKm = aVar;
    }

    public void release() {
        yY();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.fKm != null) {
            if (this.fKn == null) {
                this.fKn = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.fKn.setMessageId(a.i.guard_club_exit_desc_msg);
                this.fKn.setCancelable(true);
                this.fKn.setCanceledOnTouchOutside(true);
                this.fKn.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.fKm != null) {
                            l.this.fKm.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.fKn.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.fKn.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.fKn.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.fKn.setPositiveButtonTextColor(-57754);
                    this.fKn.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.fKn.isShowing()) {
                this.fKn.create(this.mPageContext).show();
            }
        }
    }

    private void yY() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.fKn != null) {
            this.fKn.dismiss();
            this.fKn = null;
        }
    }
}
