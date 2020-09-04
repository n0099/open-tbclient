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
/* loaded from: classes15.dex */
public class x {
    private TextView cjo;
    private com.baidu.tbadk.core.dialog.a hWL;
    private TextView hWM;
    private ImageView hhd;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.hWL == null || !this.hWL.isShowing()) {
            this.hWL = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.hWL.nw(1);
            this.hWL.nv(R.color.cp_cont_b);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cjo = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones ckY = c.ckX().ckY();
            if (ckY != null) {
                this.cjo.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), ckY.bazhu_level, ckY.total_recommend_num, Integer.valueOf(ckY.total_recommend_num.intValue() - ckY.used_recommend_num.intValue())));
            } else {
                this.cjo.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.hhd = (ImageView) inflate.findViewById(R.id.checkbox);
            this.hWM = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.x.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    x.this.mIsChecked = !x.this.mIsChecked;
                    x.this.bhd();
                }
            });
            onChangeSkinType();
            this.hWL.aX(inflate);
            this.hWL.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.x.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_frs_recommend_tip", !x.this.mIsChecked);
                    c.ckX().eC(str, str2);
                    x.this.hWL.dismiss();
                    x.this.hWL = null;
                }
            });
            this.hWL.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.x.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    x.this.mIsChecked = false;
                    x.this.hWL.dismiss();
                    x.this.hWL = null;
                }
            });
            this.hWL.b(tbPageContext).bhg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhd() {
        Drawable a;
        if (this.hhd != null) {
            ImageView imageView = this.hhd;
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
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.cjo != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.cjo, R.color.cp_cont_j);
        }
        bhd();
        if (this.hWM != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.hWM, R.color.cp_cont_j);
        }
    }

    public void onDestory() {
        this.hWL = null;
        this.mTitleView = null;
        this.cjo = null;
        this.hhd = null;
        this.hWM = null;
    }
}
