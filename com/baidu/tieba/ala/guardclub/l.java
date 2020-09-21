package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes4.dex */
public class l {
    private a geX;
    private BdAlertDialog geY;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.geX = aVar;
    }

    public void release() {
        FD();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.geX != null) {
            if (this.geY == null) {
                this.geY = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.geY.setMessageId(a.i.guard_club_exit_desc_msg);
                this.geY.setCancelable(true);
                this.geY.setCanceledOnTouchOutside(true);
                this.geY.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.geX != null) {
                            l.this.geX.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.geY.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.geY.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.geY.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.geY.setPositiveButtonTextColor(-57754);
                    this.geY.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.geY.isShowing()) {
                this.geY.create(this.mPageContext).show();
            }
        }
    }

    private void FD() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.geY != null) {
            this.geY.dismiss();
            this.geY = null;
        }
    }
}
