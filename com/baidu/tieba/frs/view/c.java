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
/* loaded from: classes2.dex */
public class c {
    private TextView cTD;
    private ImageView iuz;
    private com.baidu.tbadk.core.dialog.a jkl;
    private TextView jkm;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.jkl == null || !this.jkl.isShowing()) {
                this.jkl = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.jkl.nA(1);
                this.jkl.nz(R.color.CAM_X0105);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.cTD = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.cTD.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.cTD.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.iuz = (ImageView) inflate.findViewById(R.id.checkbox);
                this.jkm = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.mIsChecked = !c.this.mIsChecked;
                        c.this.bqu();
                    }
                });
                onChangeSkinType();
                this.jkl.bn(inflate);
                this.jkl.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_frs_move_area_tip", !c.this.mIsChecked);
                        com.baidu.tieba.frs.a.cBr().cl(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        c.this.jkl.dismiss();
                        c.this.jkl = null;
                    }
                });
                this.jkl.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        c.this.jkl.dismiss();
                        c.this.jkl = null;
                    }
                });
                this.jkl.b(tbPageContext).bqx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqu() {
        Drawable a2;
        if (this.iuz != null) {
            ImageView imageView = this.iuz;
            if (this.mIsChecked) {
                a2 = SvgManager.bsR().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bsR().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        }
        if (this.cTD != null) {
            ap.setViewTextColor(this.cTD, R.color.CAM_X0107);
        }
        bqu();
        if (this.jkm != null) {
            ap.setViewTextColor(this.jkm, R.color.CAM_X0107);
        }
    }
}
