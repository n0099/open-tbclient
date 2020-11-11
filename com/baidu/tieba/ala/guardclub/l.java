package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes4.dex */
public class l {
    private a gHe;
    private BdAlertDialog gHf;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.gHe = aVar;
    }

    public void release() {
        Hv();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.gHe != null) {
            if (this.gHf == null) {
                this.gHf = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.gHf.setMessageId(a.h.guard_club_exit_desc_msg);
                this.gHf.setCancelable(true);
                this.gHf.setCanceledOnTouchOutside(true);
                this.gHf.setPositiveButton(a.h.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.gHe != null) {
                            l.this.gHe.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.gHf.setNegativeButton(a.h.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gHf.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                    this.gHf.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.gHf.setPositiveButtonTextColor(-57754);
                    this.gHf.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.gHf.isShowing()) {
                this.gHf.create(this.mPageContext).show();
            }
        }
    }

    private void Hv() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.gHf != null) {
            this.gHf.dismiss();
            this.gHf = null;
        }
    }
}
