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
    private TextView cTD;
    private ImageView iul;
    private com.baidu.tbadk.core.dialog.a jjX;
    private TextView jjY;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.jjX == null || !this.jjX.isShowing()) {
            this.jjX = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.jjX.nA(1);
            this.jjX.nz(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cTD = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones cBw = c.cBv().cBw();
            if (cBw != null) {
                this.cTD.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), cBw.bazhu_level, cBw.total_recommend_num, Integer.valueOf(cBw.total_recommend_num.intValue() - cBw.used_recommend_num.intValue())));
            } else {
                this.cTD.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.iul = (ImageView) inflate.findViewById(R.id.checkbox);
            this.jjY = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.v.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    v.this.mIsChecked = !v.this.mIsChecked;
                    v.this.bqu();
                }
            });
            onChangeSkinType();
            this.jjX.bn(inflate);
            this.jjX.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.v.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_frs_recommend_tip", !v.this.mIsChecked);
                    c.cBv().eX(str, str2);
                    v.this.jjX.dismiss();
                    v.this.jjX = null;
                }
            });
            this.jjX.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.v.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    v.this.mIsChecked = false;
                    v.this.jjX.dismiss();
                    v.this.jjX = null;
                }
            });
            this.jjX.b(tbPageContext).bqx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqu() {
        Drawable a2;
        if (this.iul != null) {
            ImageView imageView = this.iul;
            if (this.mIsChecked) {
                a2 = SvgManager.bsR().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bsR().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        }
        if (this.cTD != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.cTD, R.color.CAM_X0107);
        }
        bqu();
        if (this.jjY != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jjY, R.color.CAM_X0107);
        }
    }

    public void onDestory() {
        this.jjX = null;
        this.mTitleView = null;
        this.cTD = null;
        this.iul = null;
        this.jjY = null;
    }
}
