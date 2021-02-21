package com.baidu.tieba.frs.achievement;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class c {
    private TbPageContext context;
    private View.OnClickListener jlS;
    private TextView jlU;
    private TextView jlV;
    private TextView jlW;
    private b jlX;
    private TBSpecificationBtn jmt;
    private TBSpecificationBtn jmu;
    private View jmv;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.jmt.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.zc(2);
            } else if (view.getId() == c.this.jmu.getId()) {
                if (c.this.jlS != null) {
                    c.this.jlS.onClick(view);
                }
                c.this.zc(1);
            }
        }
    };
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.jlU = (TextView) view.findViewById(R.id.to_user_name);
        this.jlV = (TextView) view.findViewById(R.id.content);
        this.jlW = (TextView) view.findViewById(R.id.sender);
        this.jmt = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pR(R.color.CAM_X0618);
        this.jmt.setConfig(cVar);
        this.jmt.setTextSize(R.dimen.tbds42);
        this.jmt.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.jmt.setOnClickListener(this.onClickListener);
        this.jmu = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.aY(R.color.CAM_X0302, R.color.CAM_X0101);
        this.jmu.setConfig(bVar);
        this.jmu.setTextSize(R.dimen.tbds42);
        this.jmu.setText(tbPageContext.getString(R.string.go_to_share));
        this.jmu.setOnClickListener(this.onClickListener);
        this.jmv = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.jmv.setBackground(gradientDrawable);
        this.jlX = new b(tbPageContext);
        this.jlX.cFb();
        cFa();
        TiebaStatic.log(new ar("c13893").ap("obj_source", (this.jlX.jmk == null || !this.jlX.jmk.equals("bazhu")) ? 2 : 1).dR("fid", this.jlX.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cFa() {
        this.jlU.setText(this.jlX.nickName + ":");
        this.jlV.setText(this.jlX.cFc());
        this.jlW.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zc(int i) {
        TiebaStatic.log(new ar("c13892").ap("obj_type", i).ap("obj_source", (this.jlX.jmk == null || !this.jlX.jmk.equals("bazhu")) ? 2 : 1).dR("fid", this.jlX.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void B(View.OnClickListener onClickListener) {
        this.jlS = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.jlU, R.color.CAM_X0101);
        ap.setViewTextColor(this.jlV, R.color.CAM_X0101);
        ap.setViewTextColor(this.jlW, R.color.CAM_X0109);
    }
}
