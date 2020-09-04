package com.baidu.tieba.frs.achievement;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes16.dex */
public class c {
    private TbPageContext context;
    private View.OnClickListener eFG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.hYR.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.xy(2);
            } else if (view.getId() == c.this.hYS.getId()) {
                if (c.this.hYr != null) {
                    c.this.hYr.onClick(view);
                }
                c.this.xy(1);
            }
        }
    };
    private TBSpecificationBtn hYR;
    private TBSpecificationBtn hYS;
    private View hYT;
    private View.OnClickListener hYr;
    private TextView hYt;
    private TextView hYu;
    private TextView hYv;
    private b hYw;
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.hYt = (TextView) view.findViewById(R.id.to_user_name);
        this.hYu = (TextView) view.findViewById(R.id.content);
        this.hYv = (TextView) view.findViewById(R.id.sender);
        this.hYR = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pb(R.color.cp_border_c_alpha50);
        this.hYR.setConfig(cVar);
        this.hYR.setTextSize(R.dimen.tbds42);
        this.hYR.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.hYR.setOnClickListener(this.eFG);
        this.hYS = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.hYS.setConfig(bVar);
        this.hYS.setTextSize(R.dimen.tbds42);
        this.hYS.setText(tbPageContext.getString(R.string.go_to_share));
        this.hYS.setOnClickListener(this.eFG);
        this.hYT = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.hYT.setBackground(gradientDrawable);
        this.hYw = new b(tbPageContext);
        this.hYw.cor();
        coq();
        TiebaStatic.log(new aq("c13893").ai("obj_source", (this.hYw.hYJ == null || !this.hYw.hYJ.equals("bazhu")) ? 2 : 1).dD("fid", this.hYw.fid).dD("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void coq() {
        this.hYt.setText(this.hYw.nickName + ":");
        this.hYu.setText(this.hYw.cos());
        this.hYv.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy(int i) {
        TiebaStatic.log(new aq("c13892").ai("obj_type", i).ai("obj_source", (this.hYw.hYJ == null || !this.hYw.hYJ.equals("bazhu")) ? 2 : 1).dD("fid", this.hYw.fid).dD("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void z(View.OnClickListener onClickListener) {
        this.hYr = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.hYt, R.color.cp_cont_a);
        ap.setViewTextColor(this.hYu, R.color.cp_cont_a);
        ap.setViewTextColor(this.hYv, R.color.cp_cont_d);
    }
}
