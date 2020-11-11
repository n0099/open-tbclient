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
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.iNl.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.zj(2);
            } else if (view.getId() == c.this.iNm.getId()) {
                if (c.this.iML != null) {
                    c.this.iML.onClick(view);
                }
                c.this.zj(1);
            }
        }
    };
    private View.OnClickListener iML;
    private TextView iMN;
    private TextView iMO;
    private TextView iMP;
    private b iMQ;
    private TBSpecificationBtn iNl;
    private TBSpecificationBtn iNm;
    private View iNn;
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.iMN = (TextView) view.findViewById(R.id.to_user_name);
        this.iMO = (TextView) view.findViewById(R.id.content);
        this.iMP = (TextView) view.findViewById(R.id.sender);
        this.iNl = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.qi(R.color.cp_border_c_alpha50);
        this.iNl.setConfig(cVar);
        this.iNl.setTextSize(R.dimen.tbds42);
        this.iNl.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.iNl.setOnClickListener(this.fii);
        this.iNm = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.iNm.setConfig(bVar);
        this.iNm.setTextSize(R.dimen.tbds42);
        this.iNm.setText(tbPageContext.getString(R.string.go_to_share));
        this.iNm.setOnClickListener(this.fii);
        this.iNn = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.iNn.setBackground(gradientDrawable);
        this.iMQ = new b(tbPageContext);
        this.iMQ.cAK();
        cAJ();
        TiebaStatic.log(new aq("c13893").al("obj_source", (this.iMQ.iNd == null || !this.iMQ.iNd.equals("bazhu")) ? 2 : 1).dR("fid", this.iMQ.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cAJ() {
        this.iMN.setText(this.iMQ.nickName + ":");
        this.iMO.setText(this.iMQ.cAL());
        this.iMP.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(int i) {
        TiebaStatic.log(new aq("c13892").al("obj_type", i).al("obj_source", (this.iMQ.iNd == null || !this.iMQ.iNd.equals("bazhu")) ? 2 : 1).dR("fid", this.iMQ.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void A(View.OnClickListener onClickListener) {
        this.iML = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.iMN, R.color.cp_cont_a);
        ap.setViewTextColor(this.iMO, R.color.cp_cont_a);
        ap.setViewTextColor(this.iMP, R.color.cp_cont_d);
    }
}
