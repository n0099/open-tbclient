package com.baidu.tieba.ala.guardclub;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class l {
    private a eGp;
    private BdAlertDialog eGq;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.eGp = aVar;
    }

    public void release() {
        sN();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.eGp != null) {
            if (this.eGq == null) {
                this.eGq = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.eGq.setMessageId(a.i.guard_club_exit_desc_msg);
                this.eGq.setCancelable(true);
                this.eGq.setCanceledOnTouchOutside(true);
                this.eGq.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.eGp != null) {
                            l.this.eGp.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.eGq.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.eGq.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.eGq.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.eGq.setPositiveButtonTextColor(-57754);
                    this.eGq.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.eGq.isShowing()) {
                this.eGq.create(this.mPageContext).show();
            }
        }
    }

    private void sN() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.eGq != null) {
            this.eGq.dismiss();
            this.eGq = null;
        }
    }
}
