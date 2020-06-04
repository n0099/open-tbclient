package com.baidu.tieba.ala.guardclub;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class l {
    private a fzc;
    private BdAlertDialog fzd;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.fzc = aVar;
    }

    public void release() {
        yy();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.fzc != null) {
            if (this.fzd == null) {
                this.fzd = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.fzd.setMessageId(a.i.guard_club_exit_desc_msg);
                this.fzd.setCancelable(true);
                this.fzd.setCanceledOnTouchOutside(true);
                this.fzd.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.fzc != null) {
                            l.this.fzc.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.fzd.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.fzd.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.fzd.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.fzd.setPositiveButtonTextColor(-57754);
                    this.fzd.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.fzd.isShowing()) {
                this.fzd.create(this.mPageContext).show();
            }
        }
    }

    private void yy() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.fzd != null) {
            this.fzd.dismiss();
            this.fzd = null;
        }
    }
}
