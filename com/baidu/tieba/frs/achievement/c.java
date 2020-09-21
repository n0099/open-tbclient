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
/* loaded from: classes21.dex */
public class c {
    private TbPageContext context;
    private View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.ifV.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.xX(2);
            } else if (view.getId() == c.this.ifW.getId()) {
                if (c.this.ifv != null) {
                    c.this.ifv.onClick(view);
                }
                c.this.xX(1);
            }
        }
    };
    private b ifA;
    private TBSpecificationBtn ifV;
    private TBSpecificationBtn ifW;
    private View ifX;
    private View.OnClickListener ifv;
    private TextView ifx;
    private TextView ify;
    private TextView ifz;
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.ifx = (TextView) view.findViewById(R.id.to_user_name);
        this.ify = (TextView) view.findViewById(R.id.content);
        this.ifz = (TextView) view.findViewById(R.id.sender);
        this.ifV = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pp(R.color.cp_border_c_alpha50);
        this.ifV.setConfig(cVar);
        this.ifV.setTextSize(R.dimen.tbds42);
        this.ifV.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.ifV.setOnClickListener(this.eHN);
        this.ifW = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.ifW.setConfig(bVar);
        this.ifW.setTextSize(R.dimen.tbds42);
        this.ifW.setText(tbPageContext.getString(R.string.go_to_share));
        this.ifW.setOnClickListener(this.eHN);
        this.ifX = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.ifX.setBackground(gradientDrawable);
        this.ifA = new b(tbPageContext);
        this.ifA.crE();
        crD();
        TiebaStatic.log(new aq("c13893").ai("obj_source", (this.ifA.ifN == null || !this.ifA.ifN.equals("bazhu")) ? 2 : 1).dF("fid", this.ifA.fid).dF("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void crD() {
        this.ifx.setText(this.ifA.nickName + ":");
        this.ify.setText(this.ifA.crF());
        this.ifz.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xX(int i) {
        TiebaStatic.log(new aq("c13892").ai("obj_type", i).ai("obj_source", (this.ifA.ifN == null || !this.ifA.ifN.equals("bazhu")) ? 2 : 1).dF("fid", this.ifA.fid).dF("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void z(View.OnClickListener onClickListener) {
        this.ifv = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.ifx, R.color.cp_cont_a);
        ap.setViewTextColor(this.ify, R.color.cp_cont_a);
        ap.setViewTextColor(this.ifz, R.color.cp_cont_d);
    }
}
