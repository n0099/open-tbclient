package com.baidu.tieba.ala.guardclub;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class l {
    private a fyR;
    private BdAlertDialog fyS;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.fyR = aVar;
    }

    public void release() {
        yy();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.fyR != null) {
            if (this.fyS == null) {
                this.fyS = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.fyS.setMessageId(a.i.guard_club_exit_desc_msg);
                this.fyS.setCancelable(true);
                this.fyS.setCanceledOnTouchOutside(true);
                this.fyS.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.fyR != null) {
                            l.this.fyR.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.fyS.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.fyS.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.fyS.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.fyS.setPositiveButtonTextColor(-57754);
                    this.fyS.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.fyS.isShowing()) {
                this.fyS.create(this.mPageContext).show();
            }
        }
    }

    private void yy() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.fyS != null) {
            this.fyS.dismiss();
            this.fyS = null;
        }
    }
}
