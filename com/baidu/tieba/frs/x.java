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
    private TextView cKm;
    private ImageView hVU;
    private com.baidu.tbadk.core.dialog.a iLS;
    private TextView iLT;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.iLS == null || !this.iLS.isShowing()) {
            this.iLS = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.iLS.ov(1);
            this.iLS.ou(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cKm = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones cwT = c.cwS().cwT();
            if (cwT != null) {
                this.cKm.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), cwT.bazhu_level, cwT.total_recommend_num, Integer.valueOf(cwT.total_recommend_num.intValue() - cwT.used_recommend_num.intValue())));
            } else {
                this.cKm.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.hVU = (ImageView) inflate.findViewById(R.id.checkbox);
            this.iLT = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.x.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    x.this.mIsChecked = !x.this.mIsChecked;
                    x.this.bod();
                }
            });
            onChangeSkinType();
            this.iLS.bg(inflate);
            this.iLS.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.x.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("key_frs_recommend_tip", !x.this.mIsChecked);
                    c.cwS().eS(str, str2);
                    x.this.iLS.dismiss();
                    x.this.iLS = null;
                }
            });
            this.iLS.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.x.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    x.this.mIsChecked = false;
                    x.this.iLS.dismiss();
                    x.this.iLS = null;
                }
            });
            this.iLS.b(tbPageContext).bog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bod() {
        Drawable a2;
        if (this.hVU != null) {
            ImageView imageView = this.hVU;
            if (this.mIsChecked) {
                a2 = SvgManager.bqB().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bqB().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        }
        if (this.cKm != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.cKm, R.color.CAM_X0107);
        }
        bod();
        if (this.iLT != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iLT, R.color.CAM_X0107);
        }
    }

    public void onDestory() {
        this.iLS = null;
        this.mTitleView = null;
        this.cKm = null;
        this.hVU = null;
        this.iLT = null;
    }
}
