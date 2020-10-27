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
    private TextView cGd;
    private ImageView hPx;
    private com.baidu.tbadk.core.dialog.a iFi;
    private TextView iFj;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.iFi == null || !this.iFi.isShowing()) {
                this.iFi = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.iFi.op(1);
                this.iFi.oo(R.color.cp_cont_b);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.cGd = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.cGd.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.cGd.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.hPx = (ImageView) inflate.findViewById(R.id.checkbox);
                this.iFj = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.mIsChecked = !d.this.mIsChecked;
                        d.this.bmz();
                    }
                });
                onChangeSkinType();
                this.iFi.bb(inflate);
                this.iFi.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.d.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_frs_move_area_tip", !d.this.mIsChecked);
                        com.baidu.tieba.frs.a.cuE().ci(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        d.this.iFi.dismiss();
                        d.this.iFi = null;
                    }
                });
                this.iFi.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.d.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        d.this.iFi.dismiss();
                        d.this.iFi = null;
                    }
                });
                this.iFi.b(tbPageContext).bmC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmz() {
        Drawable a2;
        if (this.hPx != null) {
            ImageView imageView = this.hPx;
            if (this.mIsChecked) {
                a2 = SvgManager.boN().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.boN().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.cGd != null) {
            ap.setViewTextColor(this.cGd, R.color.cp_cont_j);
        }
        bmz();
        if (this.iFj != null) {
            ap.setViewTextColor(this.iFj, R.color.cp_cont_j);
        }
    }
}
