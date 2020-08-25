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
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.hYL.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.xy(2);
            } else if (view.getId() == c.this.hYM.getId()) {
                if (c.this.hYl != null) {
                    c.this.hYl.onClick(view);
                }
                c.this.xy(1);
            }
        }
    };
    private TBSpecificationBtn hYL;
    private TBSpecificationBtn hYM;
    private View hYN;
    private View.OnClickListener hYl;
    private TextView hYn;
    private TextView hYo;
    private TextView hYp;
    private b hYq;
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.hYn = (TextView) view.findViewById(R.id.to_user_name);
        this.hYo = (TextView) view.findViewById(R.id.content);
        this.hYp = (TextView) view.findViewById(R.id.sender);
        this.hYL = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pb(R.color.cp_border_c_alpha50);
        this.hYL.setConfig(cVar);
        this.hYL.setTextSize(R.dimen.tbds42);
        this.hYL.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.hYL.setOnClickListener(this.eFC);
        this.hYM = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.hYM.setConfig(bVar);
        this.hYM.setTextSize(R.dimen.tbds42);
        this.hYM.setText(tbPageContext.getString(R.string.go_to_share));
        this.hYM.setOnClickListener(this.eFC);
        this.hYN = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.hYN.setBackground(gradientDrawable);
        this.hYq = new b(tbPageContext);
        this.hYq.coq();
        cop();
        TiebaStatic.log(new aq("c13893").ai("obj_source", (this.hYq.hYD == null || !this.hYq.hYD.equals("bazhu")) ? 2 : 1).dD("fid", this.hYq.fid).dD("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cop() {
        this.hYn.setText(this.hYq.nickName + ":");
        this.hYo.setText(this.hYq.cor());
        this.hYp.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy(int i) {
        TiebaStatic.log(new aq("c13892").ai("obj_type", i).ai("obj_source", (this.hYq.hYD == null || !this.hYq.hYD.equals("bazhu")) ? 2 : 1).dD("fid", this.hYq.fid).dD("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void z(View.OnClickListener onClickListener) {
        this.hYl = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.hYn, R.color.cp_cont_a);
        ap.setViewTextColor(this.hYo, R.color.cp_cont_a);
        ap.setViewTextColor(this.hYp, R.color.cp_cont_d);
    }
}
