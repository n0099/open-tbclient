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
    private TextView cVd;
    private ImageView iwi;
    private com.baidu.tbadk.core.dialog.a jlU;
    private TextView jlV;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.jlU == null || !this.jlU.isShowing()) {
            this.jlU = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.jlU.nB(1);
            this.jlU.nA(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cVd = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones cBJ = c.cBI().cBJ();
            if (cBJ != null) {
                this.cVd.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), cBJ.bazhu_level, cBJ.total_recommend_num, Integer.valueOf(cBJ.total_recommend_num.intValue() - cBJ.used_recommend_num.intValue())));
            } else {
                this.cVd.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.iwi = (ImageView) inflate.findViewById(R.id.checkbox);
            this.jlV = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.v.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    v.this.mIsChecked = !v.this.mIsChecked;
                    v.this.bqw();
                }
            });
            onChangeSkinType();
            this.jlU.bn(inflate);
            this.jlU.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.v.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_frs_recommend_tip", !v.this.mIsChecked);
                    c.cBI().eX(str, str2);
                    v.this.jlU.dismiss();
                    v.this.jlU = null;
                }
            });
            this.jlU.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.v.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    v.this.mIsChecked = false;
                    v.this.jlU.dismiss();
                    v.this.jlU = null;
                }
            });
            this.jlU.b(tbPageContext).bqz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqw() {
        Drawable a2;
        if (this.iwi != null) {
            ImageView imageView = this.iwi;
            if (this.mIsChecked) {
                a2 = SvgManager.bsU().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bsU().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        }
        if (this.cVd != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.cVd, R.color.CAM_X0107);
        }
        bqw();
        if (this.jlV != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jlV, R.color.CAM_X0107);
        }
    }

    public void onDestory() {
        this.jlU = null;
        this.mTitleView = null;
        this.cVd = null;
        this.iwi = null;
        this.jlV = null;
    }
}
