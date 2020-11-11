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
    private TextView cLW;
    private ImageView hVu;
    private com.baidu.tbadk.core.dialog.a iLf;
    private TextView iLg;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.iLf == null || !this.iLf.isShowing()) {
                this.iLf = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.iLf.oz(1);
                this.iLf.oy(R.color.cp_cont_b);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.cLW = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.cLW.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.cLW.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.hVu = (ImageView) inflate.findViewById(R.id.checkbox);
                this.iLg = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.mIsChecked = !d.this.mIsChecked;
                        d.this.boZ();
                    }
                });
                onChangeSkinType();
                this.iLf.bf(inflate);
                this.iLf.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.d.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_frs_move_area_tip", !d.this.mIsChecked);
                        com.baidu.tieba.frs.a.cxf().ck(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        d.this.iLf.dismiss();
                        d.this.iLf = null;
                    }
                });
                this.iLf.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.d.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        d.this.iLf.dismiss();
                        d.this.iLf = null;
                    }
                });
                this.iLf.b(tbPageContext).bpc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boZ() {
        Drawable a2;
        if (this.hVu != null) {
            ImageView imageView = this.hVu;
            if (this.mIsChecked) {
                a2 = SvgManager.brn().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.brn().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.cLW != null) {
            ap.setViewTextColor(this.cLW, R.color.cp_cont_j);
        }
        boZ();
        if (this.iLg != null) {
            ap.setViewTextColor(this.iLg, R.color.cp_cont_j);
        }
    }
}
