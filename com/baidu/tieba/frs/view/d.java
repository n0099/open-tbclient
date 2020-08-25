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
/* loaded from: classes16.dex */
public class d {
    private TextView cjk;
    private com.baidu.tbadk.core.dialog.a hWF;
    private TextView hWG;
    private ImageView hgZ;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.hWF == null || !this.hWF.isShowing()) {
                this.hWF = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.hWF.nw(1);
                this.hWF.nv(R.color.cp_cont_b);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.cjk = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.cjk.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.cjk.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.hgZ = (ImageView) inflate.findViewById(R.id.checkbox);
                this.hWG = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.mIsChecked = !d.this.mIsChecked;
                        d.this.bhd();
                    }
                });
                onChangeSkinType();
                this.hWF.aX(inflate);
                this.hWF.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.d.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_frs_move_area_tip", !d.this.mIsChecked);
                        com.baidu.tieba.frs.a.ckL().cd(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        d.this.hWF.dismiss();
                        d.this.hWF = null;
                    }
                });
                this.hWF.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.d.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        d.this.hWF.dismiss();
                        d.this.hWF = null;
                    }
                });
                this.hWF.b(tbPageContext).bhg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhd() {
        Drawable a;
        if (this.hgZ != null) {
            ImageView imageView = this.hgZ;
            if (this.mIsChecked) {
                a = SvgManager.bjq().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.bjq().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.cjk != null) {
            ap.setViewTextColor(this.cjk, R.color.cp_cont_j);
        }
        bhd();
        if (this.hWG != null) {
            ap.setViewTextColor(this.hWG, R.color.cp_cont_j);
        }
    }
}
