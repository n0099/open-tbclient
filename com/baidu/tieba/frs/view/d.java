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
/* loaded from: classes16.dex */
public class d {
    private TextView cdm;
    private ImageView gUg;
    private com.baidu.tbadk.core.dialog.a hJl;
    private TextView hJm;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.hJl == null || !this.hJl.isShowing()) {
                this.hJl = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.hJl.lq(1);
                this.hJl.lp(R.color.cp_cont_b);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.cdm = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.cdm.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.cdm.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.gUg = (ImageView) inflate.findViewById(R.id.checkbox);
                this.hJm = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.mIsChecked = !d.this.mIsChecked;
                        d.this.aYI();
                    }
                });
                onChangeSkinType();
                this.hJl.aV(inflate);
                this.hJl.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.d.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_frs_move_area_tip", !d.this.mIsChecked);
                        com.baidu.tieba.frs.a.cap().bV(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        d.this.hJl.dismiss();
                        d.this.hJl = null;
                    }
                });
                this.hJl.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.d.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        d.this.hJl.dismiss();
                        d.this.hJl = null;
                    }
                });
                this.hJl.b(tbPageContext).aYL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYI() {
        Drawable a;
        if (this.gUg != null) {
            ImageView imageView = this.gUg;
            if (this.mIsChecked) {
                a = SvgManager.baR().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.baR().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.cdm != null) {
            ao.setViewTextColor(this.cdm, R.color.cp_cont_j);
        }
        aYI();
        if (this.hJm != null) {
            ao.setViewTextColor(this.hJm, R.color.cp_cont_j);
        }
    }
}
