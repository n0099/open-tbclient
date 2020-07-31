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
public class w {
    private TextView cdm;
    private ImageView gUg;
    private com.baidu.tbadk.core.dialog.a hJl;
    private TextView hJm;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.hJl == null || !this.hJl.isShowing()) {
            this.hJl = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.hJl.lq(1);
            this.hJl.lp(R.color.cp_cont_b);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cdm = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones caB = c.caA().caB();
            if (caB != null) {
                this.cdm.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), caB.bazhu_level, caB.total_recommend_num, Integer.valueOf(caB.total_recommend_num.intValue() - caB.used_recommend_num.intValue())));
            } else {
                this.cdm.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.gUg = (ImageView) inflate.findViewById(R.id.checkbox);
            this.hJm = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.w.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    w.this.mIsChecked = !w.this.mIsChecked;
                    w.this.aYI();
                }
            });
            onChangeSkinType();
            this.hJl.aV(inflate);
            this.hJl.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.w.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_frs_recommend_tip", !w.this.mIsChecked);
                    c.caA().ek(str, str2);
                    w.this.hJl.dismiss();
                    w.this.hJl = null;
                }
            });
            this.hJl.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.w.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    w.this.mIsChecked = false;
                    w.this.hJl.dismiss();
                    w.this.hJl = null;
                }
            });
            this.hJl.b(tbPageContext).aYL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYI() {
        Drawable a;
        if (this.gUg != null) {
            ImageView imageView = this.gUg;
            if (this.mIsChecked) {
                a = SvgManager.baR().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.baR().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.cdm != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.cdm, R.color.cp_cont_j);
        }
        aYI();
        if (this.hJm != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.hJm, R.color.cp_cont_j);
        }
    }

    public void onDestory() {
        this.hJl = null;
        this.mTitleView = null;
        this.cdm = null;
        this.gUg = null;
        this.hJm = null;
    }
}
