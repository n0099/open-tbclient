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
    private TextView cRq;
    private ImageView ioH;
    private com.baidu.tbadk.core.dialog.a jeq;
    private TextView jer;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.jeq == null || !this.jeq.isShowing()) {
            this.jeq = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.jeq.nx(1);
            this.jeq.nw(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cRq = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones cAl = c.cAk().cAl();
            if (cAl != null) {
                this.cRq.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), cAl.bazhu_level, cAl.total_recommend_num, Integer.valueOf(cAl.total_recommend_num.intValue() - cAl.used_recommend_num.intValue())));
            } else {
                this.cRq.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.ioH = (ImageView) inflate.findViewById(R.id.checkbox);
            this.jer = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.v.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    v.this.mIsChecked = !v.this.mIsChecked;
                    v.this.bqb();
                }
            });
            onChangeSkinType();
            this.jeq.br(inflate);
            this.jeq.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.v.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_frs_recommend_tip", !v.this.mIsChecked);
                    c.cAk().eX(str, str2);
                    v.this.jeq.dismiss();
                    v.this.jeq = null;
                }
            });
            this.jeq.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.v.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    v.this.mIsChecked = false;
                    v.this.jeq.dismiss();
                    v.this.jeq = null;
                }
            });
            this.jeq.b(tbPageContext).bqe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqb() {
        Drawable a2;
        if (this.ioH != null) {
            ImageView imageView = this.ioH;
            if (this.mIsChecked) {
                a2 = SvgManager.bsx().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bsx().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        }
        if (this.cRq != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.cRq, R.color.CAM_X0107);
        }
        bqb();
        if (this.jer != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.jer, R.color.CAM_X0107);
        }
    }

    public void onDestory() {
        this.jeq = null;
        this.mTitleView = null;
        this.cRq = null;
        this.ioH = null;
        this.jer = null;
    }
}
