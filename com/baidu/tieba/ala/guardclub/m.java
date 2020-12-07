package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes4.dex */
public class m {
    private a gPS;
    private BdAlertDialog gPT;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public m(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.gPS = aVar;
    }

    public void release() {
        ID();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.gPS != null) {
            if (this.gPT == null) {
                this.gPT = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.gPT.setMessageId(a.h.guard_club_exit_desc_msg);
                this.gPT.setCancelable(true);
                this.gPT.setCanceledOnTouchOutside(true);
                this.gPT.setPositiveButton(a.h.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (m.this.gPS != null) {
                            m.this.gPS.c(dVar, i);
                        }
                        m.this.release();
                    }
                });
                this.gPT.setNegativeButton(a.h.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        m.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gPT.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                    this.gPT.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.gPT.setPositiveButtonTextColor(-57754);
                    this.gPT.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.gPT.isShowing()) {
                this.gPT.create(this.mPageContext).show();
            }
        }
    }

    private void ID() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.gPT != null) {
            this.gPT.dismiss();
            this.gPT = null;
        }
    }
}
