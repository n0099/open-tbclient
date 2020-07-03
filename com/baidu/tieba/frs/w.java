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
/* loaded from: classes8.dex */
public class w {
    private TextView cbI;
    private ImageView gOA;
    private com.baidu.tbadk.core.dialog.a hDn;
    private TextView hDo;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.hDn == null || !this.hDn.isShowing()) {
            this.hDn = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.hDn.kW(1);
            this.hDn.kV(R.color.cp_cont_b);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cbI = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones bXh = c.bXg().bXh();
            if (bXh != null) {
                this.cbI.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), bXh.bazhu_level, bXh.total_recommend_num, Integer.valueOf(bXh.total_recommend_num.intValue() - bXh.used_recommend_num.intValue())));
            } else {
                this.cbI.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.gOA = (ImageView) inflate.findViewById(R.id.checkbox);
            this.hDo = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.w.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    w.this.mIsChecked = !w.this.mIsChecked;
                    w.this.bNW();
                }
            });
            onChangeSkinType();
            this.hDn.aP(inflate);
            this.hDn.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.w.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_frs_recommend_tip", !w.this.mIsChecked);
                    c.bXg().ei(str, str2);
                    w.this.hDn.dismiss();
                    w.this.hDn = null;
                }
            });
            this.hDn.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.w.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    w.this.mIsChecked = false;
                    w.this.hDn.dismiss();
                    w.this.hDn = null;
                }
            });
            this.hDn.b(tbPageContext).aUN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNW() {
        Drawable a;
        if (this.gOA != null) {
            ImageView imageView = this.gOA;
            if (this.mIsChecked) {
                a = SvgManager.aWQ().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.aWQ().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            com.baidu.tbadk.core.util.an.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        }
        if (this.cbI != null) {
            com.baidu.tbadk.core.util.an.setViewTextColor(this.cbI, (int) R.color.cp_cont_j);
        }
        bNW();
        if (this.hDo != null) {
            com.baidu.tbadk.core.util.an.setViewTextColor(this.hDo, (int) R.color.cp_cont_j);
        }
    }

    public void onDestory() {
        this.hDn = null;
        this.mTitleView = null;
        this.cbI = null;
        this.gOA = null;
        this.hDo = null;
    }
}
