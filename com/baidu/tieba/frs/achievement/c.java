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
/* loaded from: classes22.dex */
public class c {
    private TbPageContext context;
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.iHo.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.yW(2);
            } else if (view.getId() == c.this.iHp.getId()) {
                if (c.this.iGO != null) {
                    c.this.iGO.onClick(view);
                }
                c.this.yW(1);
            }
        }
    };
    private View.OnClickListener iGO;
    private TextView iGQ;
    private TextView iGR;
    private TextView iGS;
    private b iGT;
    private TBSpecificationBtn iHo;
    private TBSpecificationBtn iHp;
    private View iHq;
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.iGQ = (TextView) view.findViewById(R.id.to_user_name);
        this.iGR = (TextView) view.findViewById(R.id.content);
        this.iGS = (TextView) view.findViewById(R.id.sender);
        this.iHo = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pY(R.color.cp_border_c_alpha50);
        this.iHo.setConfig(cVar);
        this.iHo.setTextSize(R.dimen.tbds42);
        this.iHo.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.iHo.setOnClickListener(this.fcr);
        this.iHp = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.iHp.setConfig(bVar);
        this.iHp.setTextSize(R.dimen.tbds42);
        this.iHp.setText(tbPageContext.getString(R.string.go_to_share));
        this.iHp.setOnClickListener(this.fcr);
        this.iHq = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.iHq.setBackground(gradientDrawable);
        this.iGT = new b(tbPageContext);
        this.iGT.cyj();
        cyi();
        TiebaStatic.log(new aq("c13893").aj("obj_source", (this.iGT.iHg == null || !this.iGT.iHg.equals("bazhu")) ? 2 : 1).dR("fid", this.iGT.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cyi() {
        this.iGQ.setText(this.iGT.nickName + ":");
        this.iGR.setText(this.iGT.cyk());
        this.iGS.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yW(int i) {
        TiebaStatic.log(new aq("c13892").aj("obj_type", i).aj("obj_source", (this.iGT.iHg == null || !this.iGT.iHg.equals("bazhu")) ? 2 : 1).dR("fid", this.iGT.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void z(View.OnClickListener onClickListener) {
        this.iGO = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.iGQ, R.color.cp_cont_a);
        ap.setViewTextColor(this.iGR, R.color.cp_cont_a);
        ap.setViewTextColor(this.iGS, R.color.cp_cont_d);
    }
}
