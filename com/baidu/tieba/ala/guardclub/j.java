package com.baidu.tieba.ala.guardclub;

import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes2.dex */
public class j {
    private a eBN;
    private BdAlertDialog eBO;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.g gVar, int i);
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.eBN = aVar;
    }

    public void release() {
        xe();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.g gVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.eBN != null) {
            if (this.eBO == null) {
                this.eBO = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.eBO.setMessageId(a.i.guard_club_exit_desc_msg);
                this.eBO.setCancelable(true);
                this.eBO.setCanceledOnTouchOutside(true);
                this.eBO.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (j.this.eBN != null) {
                            j.this.eBN.c(gVar, i);
                        }
                        j.this.release();
                    }
                });
                this.eBO.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        j.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.eBO.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.eBO.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.eBO.setPositiveButtonTextColor(-57754);
                    this.eBO.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.eBO.isShowing()) {
                this.eBO.create(this.mPageContext).show();
            }
        }
    }

    private void xe() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.eBO != null) {
            this.eBO.dismiss();
            this.eBO = null;
        }
    }
}
