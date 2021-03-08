package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes10.dex */
public class m {
    private a hbI;
    private BdAlertDialog hbJ;
    private TbPageContext mPageContext;

    /* loaded from: classes10.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public m(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.hbI = aVar;
    }

    public void release() {
        FD();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.hbI != null) {
            if (this.hbJ == null) {
                this.hbJ = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.hbJ.setMessageId(a.h.guard_club_exit_desc_msg);
                this.hbJ.setCancelable(true);
                this.hbJ.setCanceledOnTouchOutside(true);
                this.hbJ.setPositiveButton(a.h.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (m.this.hbI != null) {
                            m.this.hbI.c(dVar, i);
                        }
                        m.this.release();
                    }
                });
                this.hbJ.setNegativeButton(a.h.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        m.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.hbJ.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                    this.hbJ.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.hbJ.setPositiveButtonTextColor(-57754);
                    this.hbJ.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.hbJ.isShowing()) {
                this.hbJ.create(this.mPageContext).show();
            }
        }
    }

    private void FD() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.hbJ != null) {
            this.hbJ.dismiss();
            this.hbJ = null;
        }
    }
}
