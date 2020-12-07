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
/* loaded from: classes22.dex */
public class d {
    private TextView cRf;
    private com.baidu.tbadk.core.dialog.a iWJ;
    private TextView iWK;
    private ImageView igR;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.iWJ == null || !this.iWJ.isShowing()) {
                this.iWJ = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.iWJ.oT(1);
                this.iWJ.oS(R.color.CAM_X0105);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.cRf = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.cRf.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.cRf.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.igR = (ImageView) inflate.findViewById(R.id.checkbox);
                this.iWK = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.mIsChecked = !d.this.mIsChecked;
                        d.this.brs();
                    }
                });
                onChangeSkinType();
                this.iWJ.bi(inflate);
                this.iWJ.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.d.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_frs_move_area_tip", !d.this.mIsChecked);
                        com.baidu.tieba.frs.a.cAW().co(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        d.this.iWJ.dismiss();
                        d.this.iWJ = null;
                    }
                });
                this.iWJ.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.d.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        d.this.iWJ.dismiss();
                        d.this.iWJ = null;
                    }
                });
                this.iWJ.b(tbPageContext).brv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brs() {
        Drawable a2;
        if (this.igR != null) {
            ImageView imageView = this.igR;
            if (this.mIsChecked) {
                a2 = SvgManager.btW().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.btW().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        }
        if (this.cRf != null) {
            ap.setViewTextColor(this.cRf, R.color.CAM_X0107);
        }
        brs();
        if (this.iWK != null) {
            ap.setViewTextColor(this.iWK, R.color.CAM_X0107);
        }
    }
}
