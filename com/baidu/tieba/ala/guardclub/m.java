package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes11.dex */
public class m {
    private a gZL;
    private BdAlertDialog gZM;
    private TbPageContext mPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public m(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.gZL = aVar;
    }

    public void release() {
        FA();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.gZL != null) {
            if (this.gZM == null) {
                this.gZM = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.gZM.setMessageId(a.h.guard_club_exit_desc_msg);
                this.gZM.setCancelable(true);
                this.gZM.setCanceledOnTouchOutside(true);
                this.gZM.setPositiveButton(a.h.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (m.this.gZL != null) {
                            m.this.gZL.c(dVar, i);
                        }
                        m.this.release();
                    }
                });
                this.gZM.setNegativeButton(a.h.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        m.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gZM.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                    this.gZM.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.gZM.setPositiveButtonTextColor(-57754);
                    this.gZM.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.gZM.isShowing()) {
                this.gZM.create(this.mPageContext).show();
            }
        }
    }

    private void FA() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.gZM != null) {
            this.gZM.dismiss();
            this.gZM = null;
        }
    }
}
