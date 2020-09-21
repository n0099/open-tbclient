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
/* loaded from: classes20.dex */
public class x {
    private TextView clp;
    private ImageView hoh;
    private com.baidu.tbadk.core.dialog.a idP;
    private TextView idQ;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.idP == null || !this.idP.isShowing()) {
            this.idP = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.idP.nH(1);
            this.idP.nG(R.color.cp_cont_b);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.clp = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones col = c.cok().col();
            if (col != null) {
                this.clp.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), col.bazhu_level, col.total_recommend_num, Integer.valueOf(col.total_recommend_num.intValue() - col.used_recommend_num.intValue())));
            } else {
                this.clp.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.hoh = (ImageView) inflate.findViewById(R.id.checkbox);
            this.idQ = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.x.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    x.this.mIsChecked = !x.this.mIsChecked;
                    x.this.bhX();
                }
            });
            onChangeSkinType();
            this.idP.aZ(inflate);
            this.idP.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.x.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_frs_recommend_tip", !x.this.mIsChecked);
                    c.cok().eG(str, str2);
                    x.this.idP.dismiss();
                    x.this.idP = null;
                }
            });
            this.idP.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.x.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    x.this.mIsChecked = false;
                    x.this.idP.dismiss();
                    x.this.idP = null;
                }
            });
            this.idP.b(tbPageContext).bia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhX() {
        Drawable a;
        if (this.hoh != null) {
            ImageView imageView = this.hoh;
            if (this.mIsChecked) {
                a = SvgManager.bkl().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.bkl().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.clp != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.clp, R.color.cp_cont_j);
        }
        bhX();
        if (this.idQ != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.idQ, R.color.cp_cont_j);
        }
    }

    public void onDestory() {
        this.idP = null;
        this.mTitleView = null;
        this.clp = null;
        this.hoh = null;
        this.idQ = null;
    }
}
