package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes11.dex */
public class m {
    private a gZZ;
    private BdAlertDialog haa;
    private TbPageContext mPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public m(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.gZZ = aVar;
    }

    public void release() {
        FA();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.gZZ != null) {
            if (this.haa == null) {
                this.haa = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.haa.setMessageId(a.h.guard_club_exit_desc_msg);
                this.haa.setCancelable(true);
                this.haa.setCanceledOnTouchOutside(true);
                this.haa.setPositiveButton(a.h.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (m.this.gZZ != null) {
                            m.this.gZZ.c(dVar, i);
                        }
                        m.this.release();
                    }
                });
                this.haa.setNegativeButton(a.h.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        m.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.haa.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                    this.haa.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.haa.setPositiveButtonTextColor(-57754);
                    this.haa.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.haa.isShowing()) {
                this.haa.create(this.mPageContext).show();
            }
        }
    }

    private void FA() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.haa != null) {
            this.haa.dismiss();
            this.haa = null;
        }
    }
}
