package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes4.dex */
public class m {
    private a gPU;
    private BdAlertDialog gPV;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public m(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.gPU = aVar;
    }

    public void release() {
        ID();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.gPU != null) {
            if (this.gPV == null) {
                this.gPV = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.gPV.setMessageId(a.h.guard_club_exit_desc_msg);
                this.gPV.setCancelable(true);
                this.gPV.setCanceledOnTouchOutside(true);
                this.gPV.setPositiveButton(a.h.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (m.this.gPU != null) {
                            m.this.gPU.c(dVar, i);
                        }
                        m.this.release();
                    }
                });
                this.gPV.setNegativeButton(a.h.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        m.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gPV.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                    this.gPV.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.gPV.setPositiveButtonTextColor(-57754);
                    this.gPV.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.gPV.isShowing()) {
                this.gPV.create(this.mPageContext).show();
            }
        }
    }

    private void ID() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.gPV != null) {
            this.gPV.dismiss();
            this.gPV = null;
        }
    }
}
