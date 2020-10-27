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
public class x {
    private TextView cGd;
    private ImageView hPx;
    private com.baidu.tbadk.core.dialog.a iFi;
    private TextView iFj;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.iFi == null || !this.iFi.isShowing()) {
            this.iFi = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.iFi.op(1);
            this.iFi.oo(R.color.cp_cont_b);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cGd = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones cuQ = c.cuP().cuQ();
            if (cuQ != null) {
                this.cGd.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), cuQ.bazhu_level, cuQ.total_recommend_num, Integer.valueOf(cuQ.total_recommend_num.intValue() - cuQ.used_recommend_num.intValue())));
            } else {
                this.cGd.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.hPx = (ImageView) inflate.findViewById(R.id.checkbox);
            this.iFj = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.x.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    x.this.mIsChecked = !x.this.mIsChecked;
                    x.this.bmz();
                }
            });
            onChangeSkinType();
            this.iFi.bb(inflate);
            this.iFi.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.x.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_frs_recommend_tip", !x.this.mIsChecked);
                    c.cuP().eS(str, str2);
                    x.this.iFi.dismiss();
                    x.this.iFi = null;
                }
            });
            this.iFi.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.x.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    x.this.mIsChecked = false;
                    x.this.iFi.dismiss();
                    x.this.iFi = null;
                }
            });
            this.iFi.b(tbPageContext).bmC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmz() {
        Drawable a2;
        if (this.hPx != null) {
            ImageView imageView = this.hPx;
            if (this.mIsChecked) {
                a2 = SvgManager.boN().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.boN().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.cGd != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.cGd, R.color.cp_cont_j);
        }
        bmz();
        if (this.iFj != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iFj, R.color.cp_cont_j);
        }
    }

    public void onDestory() {
        this.iFi = null;
        this.mTitleView = null;
        this.cGd = null;
        this.hPx = null;
        this.iFj = null;
    }
}
