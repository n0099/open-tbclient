package com.baidu.tieba.ala.guardclub;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class l {
    private a eGL;
    private BdAlertDialog eGM;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.eGL = aVar;
    }

    public void release() {
        sS();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.eGL != null) {
            if (this.eGM == null) {
                this.eGM = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.eGM.setMessageId(a.i.guard_club_exit_desc_msg);
                this.eGM.setCancelable(true);
                this.eGM.setCanceledOnTouchOutside(true);
                this.eGM.setPositiveButton(a.i.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.eGL != null) {
                            l.this.eGL.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.eGM.setNegativeButton(a.i.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.eGM.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    this.eGM.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.eGM.setPositiveButtonTextColor(-57754);
                    this.eGM.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.eGM.isShowing()) {
                this.eGM.create(this.mPageContext).show();
            }
        }
    }

    private void sS() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.eGM != null) {
            this.eGM.dismiss();
            this.eGM = null;
        }
    }
}
