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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class d {
    private TextView cbI;
    private ImageView gOA;
    private com.baidu.tbadk.core.dialog.a hDn;
    private TextView hDo;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.hDn == null || !this.hDn.isShowing()) {
                this.hDn = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.hDn.kW(1);
                this.hDn.kV(R.color.cp_cont_b);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.cbI = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.cbI.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.cbI.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.gOA = (ImageView) inflate.findViewById(R.id.checkbox);
                this.hDo = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.mIsChecked = !d.this.mIsChecked;
                        d.this.bNW();
                    }
                });
                onChangeSkinType();
                this.hDn.aP(inflate);
                this.hDn.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.d.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_frs_move_area_tip", !d.this.mIsChecked);
                        com.baidu.tieba.frs.a.bWV().bS(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        d.this.hDn.dismiss();
                        d.this.hDn = null;
                    }
                });
                this.hDn.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.d.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        d.this.hDn.dismiss();
                        d.this.hDn = null;
                    }
                });
                this.hDn.b(tbPageContext).aUN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNW() {
        Drawable a;
        if (this.gOA != null) {
            ImageView imageView = this.gOA;
            if (this.mIsChecked) {
                a = SvgManager.aWQ().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.aWQ().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            an.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        }
        if (this.cbI != null) {
            an.setViewTextColor(this.cbI, (int) R.color.cp_cont_j);
        }
        bNW();
        if (this.hDo != null) {
            an.setViewTextColor(this.hDo, (int) R.color.cp_cont_j);
        }
    }
}
