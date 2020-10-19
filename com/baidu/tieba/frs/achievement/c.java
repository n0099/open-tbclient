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
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.iuS.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.yD(2);
            } else if (view.getId() == c.this.iuT.getId()) {
                if (c.this.ius != null) {
                    c.this.ius.onClick(view);
                }
                c.this.yD(1);
            }
        }
    };
    private TBSpecificationBtn iuS;
    private TBSpecificationBtn iuT;
    private View iuU;
    private View.OnClickListener ius;
    private TextView iuu;
    private TextView iuv;
    private TextView iuw;
    private b iux;
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.iuu = (TextView) view.findViewById(R.id.to_user_name);
        this.iuv = (TextView) view.findViewById(R.id.content);
        this.iuw = (TextView) view.findViewById(R.id.sender);
        this.iuS = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pN(R.color.cp_border_c_alpha50);
        this.iuS.setConfig(cVar);
        this.iuS.setTextSize(R.dimen.tbds42);
        this.iuS.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.iuS.setOnClickListener(this.eTU);
        this.iuT = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.ba(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.iuT.setConfig(bVar);
        this.iuT.setTextSize(R.dimen.tbds42);
        this.iuT.setText(tbPageContext.getString(R.string.go_to_share));
        this.iuT.setOnClickListener(this.eTU);
        this.iuU = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.iuU.setBackground(gradientDrawable);
        this.iux = new b(tbPageContext);
        this.iux.cvc();
        cvb();
        TiebaStatic.log(new aq("c13893").aj("obj_source", (this.iux.iuK == null || !this.iux.iuK.equals("bazhu")) ? 2 : 1).dK("fid", this.iux.fid).dK("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cvb() {
        this.iuu.setText(this.iux.nickName + ":");
        this.iuv.setText(this.iux.cvd());
        this.iuw.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD(int i) {
        TiebaStatic.log(new aq("c13892").aj("obj_type", i).aj("obj_source", (this.iux.iuK == null || !this.iux.iuK.equals("bazhu")) ? 2 : 1).dK("fid", this.iux.fid).dK("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void z(View.OnClickListener onClickListener) {
        this.ius = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.iuu, R.color.cp_cont_a);
        ap.setViewTextColor(this.iuv, R.color.cp_cont_a);
        ap.setViewTextColor(this.iuw, R.color.cp_cont_d);
    }
}
