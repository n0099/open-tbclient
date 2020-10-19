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
    private TextView cxH;
    private ImageView hDb;
    private com.baidu.tbadk.core.dialog.a isM;
    private TextView isN;
    private boolean mIsChecked;
    private TextView mTitleView;

    public void b(TbPageContext tbPageContext, final String str, final String str2) {
        if (this.isM == null || !this.isM.isShowing()) {
            this.isM = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            this.isM.oe(1);
            this.isM.od(R.color.cp_cont_b);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitleView = (TextView) inflate.findViewById(R.id.title);
            this.mTitleView.setText(R.string.frs_recommend_thread_sure_title);
            this.cxH = (TextView) inflate.findViewById(R.id.call_fans_intro);
            BawuThrones crJ = c.crI().crJ();
            if (crJ != null) {
                this.cxH.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), crJ.bazhu_level, crJ.total_recommend_num, Integer.valueOf(crJ.total_recommend_num.intValue() - crJ.used_recommend_num.intValue())));
            } else {
                this.cxH.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
            }
            this.hDb = (ImageView) inflate.findViewById(R.id.checkbox);
            this.isN = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.x.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    x.this.mIsChecked = !x.this.mIsChecked;
                    x.this.bkG();
                }
            });
            onChangeSkinType();
            this.isM.ba(inflate);
            this.isM.a(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new a.b() { // from class: com.baidu.tieba.frs.x.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_frs_recommend_tip", !x.this.mIsChecked);
                    c.crI().eN(str, str2);
                    x.this.isM.dismiss();
                    x.this.isM = null;
                }
            });
            this.isM.b(tbPageContext.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.x.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    x.this.mIsChecked = false;
                    x.this.isM.dismiss();
                    x.this.isM = null;
                }
            });
            this.isM.b(tbPageContext).bkJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkG() {
        Drawable a2;
        if (this.hDb != null) {
            ImageView imageView = this.hDb;
            if (this.mIsChecked) {
                a2 = SvgManager.bmU().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bmU().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    private void onChangeSkinType() {
        if (this.mTitleView != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        }
        if (this.cxH != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.cxH, R.color.cp_cont_j);
        }
        bkG();
        if (this.isN != null) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.isN, R.color.cp_cont_j);
        }
    }

    public void onDestory() {
        this.isM = null;
        this.mTitleView = null;
        this.cxH = null;
        this.hDb = null;
        this.isN = null;
    }
}
