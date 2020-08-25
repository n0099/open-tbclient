package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes7.dex */
public class l {
    private a gbG;
    private BdAlertDialog gbH;
    private TbPageContext mPageContext;

    /* loaded from: classes7.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.gbG = aVar;
    }

    public void release() {
        Fd();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.gbG != null) {
            if (this.gbH == null) {
                this.gbH = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.gbH.setMessageId(a.i.guard_club_exit_desc_msg);
                this.gbH.setCancelable(true);
                this.gbH.setCanceledOnTouchOutside(true);
                this.gbH.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.gbG != null) {
                            l.this.gbG.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.gbH.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gbH.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.gbH.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.gbH.setPositiveButtonTextColor(-57754);
                    this.gbH.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.gbH.isShowing()) {
                this.gbH.create(this.mPageContext).show();
            }
        }
    }

    private void Fd() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.gbH != null) {
            this.gbH.dismiss();
            this.gbH = null;
        }
    }
}
