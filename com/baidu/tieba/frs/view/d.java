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
    private TextView clp;
    private ImageView hoh;
    private com.baidu.tbadk.core.dialog.a idP;
    private TextView idQ;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.idP == null || !this.idP.isShowing()) {
                this.idP = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.idP.nH(1);
                this.idP.nG(R.color.cp_cont_b);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.clp = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.clp.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.clp.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.hoh = (ImageView) inflate.findViewById(R.id.checkbox);
                this.idQ = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.mIsChecked = !d.this.mIsChecked;
                        d.this.bhX();
                    }
                });
                onChangeSkinType();
                this.idP.aZ(inflate);
                this.idP.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.d.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_frs_move_area_tip", !d.this.mIsChecked);
                        com.baidu.tieba.frs.a.cnZ().cg(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        d.this.idP.dismiss();
                        d.this.idP = null;
                    }
                });
                this.idP.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.d.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        d.this.idP.dismiss();
                        d.this.idP = null;
                    }
                });
                this.idP.b(tbPageContext).bia();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhX() {
        Drawable a;
        if (this.hoh != null) {
            ImageView imageView = this.hoh;
            if (this.mIsChecked) {
                a = SvgManager.bkl().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.bkl().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.clp != null) {
            ap.setViewTextColor(this.clp, R.color.cp_cont_j);
        }
        bhX();
        if (this.idQ != null) {
            ap.setViewTextColor(this.idQ, R.color.cp_cont_j);
        }
    }
}
