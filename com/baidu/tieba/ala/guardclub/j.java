package com.baidu.tieba.ala.guardclub;

import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes2.dex */
public class j {
    private a eAC;
    private BdAlertDialog eAD;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.g gVar, int i);
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.eAC = aVar;
    }

    public void release() {
        wN();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.g gVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.eAC != null) {
            if (this.eAD == null) {
                this.eAD = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.eAD.setMessageId(a.i.guard_club_exit_desc_msg);
                this.eAD.setCancelable(true);
                this.eAD.setCanceledOnTouchOutside(true);
                this.eAD.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (j.this.eAC != null) {
                            j.this.eAC.c(gVar, i);
                        }
                        j.this.release();
                    }
                });
                this.eAD.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.j.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        j.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.eAD.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.eAD.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.eAD.setPositiveButtonTextColor(-57754);
                    this.eAD.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.eAD.isShowing()) {
                this.eAD.create(this.mPageContext).show();
            }
        }
    }

    private void wN() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.eAD != null) {
            this.eAD.dismiss();
            this.eAD = null;
        }
    }
}
