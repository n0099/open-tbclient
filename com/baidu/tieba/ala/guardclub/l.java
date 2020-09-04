package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes7.dex */
public class l {
    private a gbK;
    private BdAlertDialog gbL;
    private TbPageContext mPageContext;

    /* loaded from: classes7.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.gbK = aVar;
    }

    public void release() {
        Fd();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.gbK != null) {
            if (this.gbL == null) {
                this.gbL = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.gbL.setMessageId(a.i.guard_club_exit_desc_msg);
                this.gbL.setCancelable(true);
                this.gbL.setCanceledOnTouchOutside(true);
                this.gbL.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.gbK != null) {
                            l.this.gbK.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.gbL.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gbL.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.gbL.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.gbL.setPositiveButtonTextColor(-57754);
                    this.gbL.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.gbL.isShowing()) {
                this.gbL.create(this.mPageContext).show();
            }
        }
    }

    private void Fd() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.gbL != null) {
            this.gbL.dismiss();
            this.gbL = null;
        }
    }
}
