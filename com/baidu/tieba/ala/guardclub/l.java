package com.baidu.tieba.ala.guardclub;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class l {
    private a fll;
    private BdAlertDialog flm;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.fll = aVar;
    }

    public void release() {
        xk();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.fll != null) {
            if (this.flm == null) {
                this.flm = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.flm.setMessageId(a.i.guard_club_exit_desc_msg);
                this.flm.setCancelable(true);
                this.flm.setCanceledOnTouchOutside(true);
                this.flm.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.fll != null) {
                            l.this.fll.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.flm.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.flm.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.flm.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.flm.setPositiveButtonTextColor(-57754);
                    this.flm.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.flm.isShowing()) {
                this.flm.create(this.mPageContext).show();
            }
        }
    }

    private void xk() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.flm != null) {
            this.flm.dismiss();
            this.flm = null;
        }
    }
}
