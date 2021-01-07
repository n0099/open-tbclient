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
/* loaded from: classes.dex */
public class v {
    private TextView cWc;
    private ImageView ito;
    private com.baidu.tbadk.core.dialog.a jiY;
    private TextView jiZ;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.jiY == null || !this.jiY.isShowing()) {
            this.jiY = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.jiY.pd(1);
            this.jiY.pc(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cWc = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones cEd = c.cEc().cEd();
            if (cEd != null) {
                this.cWc.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), cEd.bazhu_level, cEd.total_recommend_num, Integer.valueOf(cEd.total_recommend_num.intValue() - cEd.used_recommend_num.intValue())));
            } else {
                this.cWc.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.ito = (ImageView) inflate.findViewById(R.id.checkbox);
            this.jiZ = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.v.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    v.this.mIsChecked = !v.this.mIsChecked;
                    v.this.btV();
                }
            });
            onChangeSkinType();
            this.jiY.br(inflate);
            this.jiY.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.v.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("key_frs_recommend_tip", !v.this.mIsChecked);
                    c.cEc().eY(str, str2);
                    v.this.jiY.dismiss();
                    v.this.jiY = null;
                }
            });
            this.jiY.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.v.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    v.this.mIsChecked = false;
                    v.this.jiY.dismiss();
                    v.this.jiY = null;
                }
            });
            this.jiY.b(tbPageContext).btY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btV() {
        Drawable a2;
        if (this.ito != null) {
            ImageView imageView = this.ito;
            if (this.mIsChecked) {
                a2 = SvgManager.bwr().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bwr().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        }
        if (this.cWc != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.cWc, R.color.CAM_X0107);
        }
        btV();
        if (this.jiZ != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.jiZ, R.color.CAM_X0107);
        }
    }

    public void onDestory() {
        this.jiY = null;
        this.mTitleView = null;
        this.cWc = null;
        this.ito = null;
        this.jiZ = null;
    }
}
