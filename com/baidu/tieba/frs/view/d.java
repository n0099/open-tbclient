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
    private TextView cxH;
    private ImageView hDb;
    private com.baidu.tbadk.core.dialog.a isM;
    private TextView isN;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void a(TbPageContext tbPageContext, final FrsTabInfo frsTabInfo, final FrsTabInfo frsTabInfo2) {
        if (frsTabInfo != null && frsTabInfo2 != null) {
            if (this.isM == null || !this.isM.isShowing()) {
                this.isM = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                this.isM.oe(1);
                this.isM.od(R.color.cp_cont_b);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                this.mTitleView = (TextView) inflate.findViewById(R.id.title);
                this.mTitleView.setText(R.string.frs_move_area_popup_title);
                this.cxH = (TextView) inflate.findViewById(R.id.call_fans_intro);
                if (frsTabInfo.is_general_tab.intValue() == 0) {
                    this.cxH.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content_other), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name, frsTabInfo2.tab_name));
                } else {
                    this.cxH.setText(String.format(tbPageContext.getString(R.string.frs_move_area_popup_content), frsTabInfo.tab_name, frsTabInfo2.tab_name, frsTabInfo.tab_name));
                }
                this.hDb = (ImageView) inflate.findViewById(R.id.checkbox);
                this.isN = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.mIsChecked = !d.this.mIsChecked;
                        d.this.bkG();
                    }
                });
                onChangeSkinType();
                this.isM.ba(inflate);
                this.isM.a(tbPageContext.getString(R.string.frs_move_area_popup_confirm), new a.b() { // from class: com.baidu.tieba.frs.view.d.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_frs_move_area_tip", !d.this.mIsChecked);
                        com.baidu.tieba.frs.a.crx().cg(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                        d.this.isM.dismiss();
                        d.this.isM = null;
                    }
                });
                this.isM.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.view.d.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        d.this.isM.dismiss();
                        d.this.isM = null;
                    }
                });
                this.isM.b(tbPageContext).bkJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkG() {
        Drawable a2;
        if (this.hDb != null) {
            ImageView imageView = this.hDb;
            if (this.mIsChecked) {
                a2 = SvgManager.bmU().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bmU().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.cxH != null) {
            ap.setViewTextColor(this.cxH, R.color.cp_cont_j);
        }
        bkG();
        if (this.isN != null) {
            ap.setViewTextColor(this.isN, R.color.cp_cont_j);
        }
    }
}
