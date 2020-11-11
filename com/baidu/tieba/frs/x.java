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
    private TextView cLW;
    private ImageView hVu;
    private com.baidu.tbadk.core.dialog.a iLf;
    private TextView iLg;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.iLf == null || !this.iLf.isShowing()) {
            this.iLf = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.iLf.oz(1);
            this.iLf.oy(R.color.cp_cont_b);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cLW = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones cxr = c.cxq().cxr();
            if (cxr != null) {
                this.cLW.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), cxr.bazhu_level, cxr.total_recommend_num, Integer.valueOf(cxr.total_recommend_num.intValue() - cxr.used_recommend_num.intValue())));
            } else {
                this.cLW.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.hVu = (ImageView) inflate.findViewById(R.id.checkbox);
            this.iLg = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.x.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    x.this.mIsChecked = !x.this.mIsChecked;
                    x.this.boZ();
                }
            });
            onChangeSkinType();
            this.iLf.bf(inflate);
            this.iLf.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.x.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_frs_recommend_tip", !x.this.mIsChecked);
                    c.cxq().eS(str, str2);
                    x.this.iLf.dismiss();
                    x.this.iLf = null;
                }
            });
            this.iLf.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.x.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    x.this.mIsChecked = false;
                    x.this.iLf.dismiss();
                    x.this.iLf = null;
                }
            });
            this.iLf.b(tbPageContext).bpc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boZ() {
        Drawable a2;
        if (this.hVu != null) {
            ImageView imageView = this.hVu;
            if (this.mIsChecked) {
                a2 = SvgManager.brn().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.brn().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.cLW != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.cLW, R.color.cp_cont_j);
        }
        boZ();
        if (this.iLg != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iLg, R.color.cp_cont_j);
        }
    }

    public void onDestory() {
        this.iLf = null;
        this.mTitleView = null;
        this.cLW = null;
        this.hVu = null;
        this.iLg = null;
    }
}
