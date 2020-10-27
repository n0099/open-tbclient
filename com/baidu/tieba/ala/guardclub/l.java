package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes4.dex */
public class l {
    private a gBq;
    private BdAlertDialog gBr;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.gBq = aVar;
    }

    public void release() {
        GU();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.gBq != null) {
            if (this.gBr == null) {
                this.gBr = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.gBr.setMessageId(a.i.guard_club_exit_desc_msg);
                this.gBr.setCancelable(true);
                this.gBr.setCanceledOnTouchOutside(true);
                this.gBr.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.gBq != null) {
                            l.this.gBq.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.gBr.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gBr.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.gBr.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.gBr.setPositiveButtonTextColor(-57754);
                    this.gBr.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.gBr.isShowing()) {
                this.gBr.create(this.mPageContext).show();
            }
        }
    }

    private void GU() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.gBr != null) {
            this.gBr.dismiss();
            this.gBr = null;
        }
    }
}
