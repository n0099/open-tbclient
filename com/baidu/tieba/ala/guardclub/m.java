package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes11.dex */
public class m {
    private a hbH;
    private BdAlertDialog hbI;
    private TbPageContext mPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public m(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.hbH = aVar;
    }

    public void release() {
        If();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.hbH != null) {
            if (this.hbI == null) {
                this.hbI = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.hbI.setMessageId(a.h.guard_club_exit_desc_msg);
                this.hbI.setCancelable(true);
                this.hbI.setCanceledOnTouchOutside(true);
                this.hbI.setPositiveButton(a.h.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (m.this.hbH != null) {
                            m.this.hbH.c(dVar, i);
                        }
                        m.this.release();
                    }
                });
                this.hbI.setNegativeButton(a.h.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        m.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.hbI.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                    this.hbI.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.hbI.setPositiveButtonTextColor(-57754);
                    this.hbI.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.hbI.isShowing()) {
                this.hbI.create(this.mPageContext).show();
            }
        }
    }

    private void If() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.hbI != null) {
            this.hbI.dismiss();
            this.hbI = null;
        }
    }
}
