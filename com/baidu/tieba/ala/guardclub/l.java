package com.baidu.tieba.ala.guardclub;

import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes4.dex */
public class l {
    private a gGL;
    private BdAlertDialog gGM;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void c(com.baidu.tieba.ala.guardclub.model.d dVar, int i);
    }

    public l(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(a aVar) {
        this.gGL = aVar;
    }

    public void release() {
        GM();
    }

    public void b(final com.baidu.tieba.ala.guardclub.model.d dVar, final int i) {
        if (TbadkCoreApplication.isLogin() && this.gGL != null) {
            if (this.gGM == null) {
                this.gGM = new BdAlertDialog(this.mPageContext.getPageActivity());
                this.gGM.setMessageId(a.h.guard_club_exit_desc_msg);
                this.gGM.setCancelable(true);
                this.gGM.setCanceledOnTouchOutside(true);
                this.gGM.setPositiveButton(a.h.guard_club_exit_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        if (l.this.gGL != null) {
                            l.this.gGL.c(dVar, i);
                        }
                        l.this.release();
                    }
                });
                this.gGM.setNegativeButton(a.h.guard_club_exit_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        l.this.release();
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gGM.setPositiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                    this.gGM.setNagetiveButtonTextColor(this.mPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                } else {
                    this.gGM.setPositiveButtonTextColor(-57754);
                    this.gGM.setNagetiveButtonTextColor(-13421773);
                }
            }
            if (!this.gGM.isShowing()) {
                this.gGM.create(this.mPageContext).show();
            }
        }
    }

    private void GM() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.gGM != null) {
            this.gGM.dismiss();
            this.gGM = null;
        }
    }
}
