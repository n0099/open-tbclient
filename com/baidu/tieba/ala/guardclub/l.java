package com.baidu.tieba.ala.guardclub;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class l {
    private a flg;
    private BdAlertDialog flh;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.flg = aVar;
    }

    public void release() {
        xl();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.flg != null) {
            if (this.flh == null) {
                this.flh = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.flh.setMessageId(a.i.guard_club_exit_desc_msg);
                this.flh.setCancelable(true);
                this.flh.setCanceledOnTouchOutside(true);
                this.flh.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.flg != null) {
                            l.this.flg.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.flh.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.flh.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.flh.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.flh.setPositiveButtonTextColor(-57754);
                    this.flh.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.flh.isShowing()) {
                this.flh.create(this.mPageContext).show();
            }
        }
    }

    private void xl() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.flh != null) {
            this.flh.dismiss();
            this.flh = null;
        }
    }
}
