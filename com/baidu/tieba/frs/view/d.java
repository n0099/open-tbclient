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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import tbclient.FrsTabInfo;
/* loaded from: classes21.dex */
public class d {
    private TextView cKm;
    private ImageView hVU;
    private com.baidu.tbadk.core.dialog.a iLS;
    private TextView iLT;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.iLS == null || !this.iLS.isShowing()) {
                this.iLS = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.iLS.ov(1);
                this.iLS.ou(R.color.CAM_X0105);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.cKm = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.cKm.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.cKm.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.hVU = (ImageView) inflate.findViewById(R.id.checkbox);
                this.iLT = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.mIsChecked = !d.this.mIsChecked;
                        d.this.bod();
                    }
                });
                onChangeSkinType();
                this.iLS.bg(inflate);
                this.iLS.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.d.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("key_frs_move_area_tip", !d.this.mIsChecked);
                        com.baidu.tieba.frs.a.cwH().ck(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        d.this.iLS.dismiss();
                        d.this.iLS = null;
                    }
                });
                this.iLS.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.d.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        d.this.iLS.dismiss();
                        d.this.iLS = null;
                    }
                });
                this.iLS.b(tbPageContext).bog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bod() {
        Drawable a2;
        if (this.hVU != null) {
            ImageView imageView = this.hVU;
            if (this.mIsChecked) {
                a2 = SvgManager.bqB().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bqB().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        }
        if (this.cKm != null) {
            ap.setViewTextColor(this.cKm, R.color.CAM_X0107);
        }
        bod();
        if (this.iLT != null) {
            ap.setViewTextColor(this.iLT, R.color.CAM_X0107);
        }
    }
}
