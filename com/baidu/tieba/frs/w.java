package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import tbclient.BawuThrones;
/* loaded from: classes21.dex */
public class w {
    private TextView cRf;
    private com.baidu.tbadk.core.dialog.a iWL;
    private TextView iWM;
    private ImageView igT;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.iWL == null || !this.iWL.isShowing()) {
            this.iWL = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.iWL.oT(1);
            this.iWL.oS(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cRf = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones cBj = c.cBi().cBj();
            if (cBj != null) {
                this.cRf.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), cBj.bazhu_level, cBj.total_recommend_num, Integer.valueOf(cBj.total_recommend_num.intValue() - cBj.used_recommend_num.intValue())));
            } else {
                this.cRf.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.igT = (ImageView) inflate.findViewById(R.id.checkbox);
            this.iWM = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.w.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    w.this.mIsChecked = !w.this.mIsChecked;
                    w.this.brs();
                }
            });
            onChangeSkinType();
            this.iWL.bi(inflate);
            this.iWL.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.w.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_frs_recommend_tip", !w.this.mIsChecked);
                    c.cBi().eX(str, str2);
                    w.this.iWL.dismiss();
                    w.this.iWL = null;
                }
            });
            this.iWL.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.w.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    w.this.mIsChecked = false;
                    w.this.iWL.dismiss();
                    w.this.iWL = null;
                }
            });
            this.iWL.b(tbPageContext).brv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brs() {
        Drawable a2;
        if (this.igT != null) {
            ImageView imageView = this.igT;
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
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        }
        if (this.cRf != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.cRf, R.color.CAM_X0107);
        }
        brs();
        if (this.iWM != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iWM, R.color.CAM_X0107);
        }
    }

    public void onDestory() {
        this.iWL = null;
        this.mTitleView = null;
        this.cRf = null;
        this.igT = null;
        this.iWM = null;
    }
}
