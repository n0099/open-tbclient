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
    private TextView cWc;
    private ImageView ito;
    private com.baidu.tbadk.core.dialog.a jiY;
    private TextView jiZ;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.jiY == null || !this.jiY.isShowing()) {
                this.jiY = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.jiY.pd(1);
                this.jiY.pc(R.color.CAM_X0105);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.cWc = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.cWc.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.cWc.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.ito = (ImageView) inflate.findViewById(R.id.checkbox);
                this.jiZ = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.mIsChecked = !c.this.mIsChecked;
                        c.this.btU();
                    }
                });
                onChangeSkinType();
                this.jiY.br(inflate);
                this.jiY.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("key_frs_move_area_tip", !c.this.mIsChecked);
                        com.baidu.tieba.frs.a.cDQ().cn(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        c.this.jiY.dismiss();
                        c.this.jiY = null;
                    }
                });
                this.jiY.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        c.this.jiY.dismiss();
                        c.this.jiY = null;
                    }
                });
                this.jiY.b(tbPageContext).btX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btU() {
        Drawable a2;
        if (this.ito != null) {
            ImageView imageView = this.ito;
            if (this.mIsChecked) {
                a2 = SvgManager.bwq().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bwq().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        }
        if (this.cWc != null) {
            ao.setViewTextColor(this.cWc, R.color.CAM_X0107);
        }
        btU();
        if (this.jiZ != null) {
            ao.setViewTextColor(this.jiZ, R.color.CAM_X0107);
        }
    }
}
