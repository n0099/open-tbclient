package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class c {
    private TextView cRq;
    private ImageView ioH;
    private com.baidu.tbadk.core.dialog.a jeq;
    private TextView jer;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.jeq == null || !this.jeq.isShowing()) {
                this.jeq = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.jeq.nx(1);
                this.jeq.nw(R.color.CAM_X0105);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.cRq = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.cRq.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.cRq.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.ioH = (ImageView) inflate.findViewById(R.id.checkbox);
                this.jer = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.mIsChecked = !c.this.mIsChecked;
                        c.this.bqb();
                    }
                });
                onChangeSkinType();
                this.jeq.br(inflate);
                this.jeq.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_frs_move_area_tip", !c.this.mIsChecked);
                        com.baidu.tieba.frs.a.czZ().cn(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        c.this.jeq.dismiss();
                        c.this.jeq = null;
                    }
                });
                this.jeq.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        c.this.jeq.dismiss();
                        c.this.jeq = null;
                    }
                });
                this.jeq.b(tbPageContext).bqe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqb() {
        Drawable a2;
        if (this.ioH != null) {
            ImageView imageView = this.ioH;
            if (this.mIsChecked) {
                a2 = SvgManager.bsx().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bsx().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        }
        if (this.cRq != null) {
            ao.setViewTextColor(this.cRq, R.color.CAM_X0107);
        }
        bqb();
        if (this.jer != null) {
            ao.setViewTextColor(this.jer, R.color.CAM_X0107);
        }
    }
}
