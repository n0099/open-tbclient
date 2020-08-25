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
    private TextView cjk;
    private com.baidu.tbadk.core.dialog.a hWF;
    private TextView hWG;
    private ImageView hgZ;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.hWF == null || !this.hWF.isShowing()) {
            this.hWF = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.hWF.nw(1);
            this.hWF.nv(R.color.cp_cont_b);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cjk = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones ckX = c.ckW().ckX();
            if (ckX != null) {
                this.cjk.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), ckX.bazhu_level, ckX.total_recommend_num, Integer.valueOf(ckX.total_recommend_num.intValue() - ckX.used_recommend_num.intValue())));
            } else {
                this.cjk.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.hgZ = (ImageView) inflate.findViewById(R.id.checkbox);
            this.hWG = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.x.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    x.this.mIsChecked = !x.this.mIsChecked;
                    x.this.bhd();
                }
            });
            onChangeSkinType();
            this.hWF.aX(inflate);
            this.hWF.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.x.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_frs_recommend_tip", !x.this.mIsChecked);
                    c.ckW().eB(str, str2);
                    x.this.hWF.dismiss();
                    x.this.hWF = null;
                }
            });
            this.hWF.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.x.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    x.this.mIsChecked = false;
                    x.this.hWF.dismiss();
                    x.this.hWF = null;
                }
            });
            this.hWF.b(tbPageContext).bhg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhd() {
        Drawable a;
        if (this.hgZ != null) {
            ImageView imageView = this.hgZ;
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
        if (this.cjk != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.cjk, R.color.cp_cont_j);
        }
        bhd();
        if (this.hWG != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.hWG, R.color.cp_cont_j);
        }
    }

    public void onDestory() {
        this.hWF = null;
        this.mTitleView = null;
        this.cjk = null;
        this.hgZ = null;
        this.hWG = null;
    }
}
