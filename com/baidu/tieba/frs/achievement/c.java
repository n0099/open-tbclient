package com.baidu.tieba.frs.achievement;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class c {
    private TbPageContext context;
    private View.OnClickListener jfX;
    private TextView jfZ;
    private TextView jga;
    private TextView jgb;
    private b jgc;
    private TBSpecificationBtn jgx;
    private TBSpecificationBtn jgy;
    private View jgz;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.jgx.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.yS(2);
            } else if (view.getId() == c.this.jgy.getId()) {
                if (c.this.jfX != null) {
                    c.this.jfX.onClick(view);
                }
                c.this.yS(1);
            }
        }
    };
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.jfZ = (TextView) view.findViewById(R.id.to_user_name);
        this.jga = (TextView) view.findViewById(R.id.content);
        this.jgb = (TextView) view.findViewById(R.id.sender);
        this.jgx = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pM(R.color.CAM_X0618);
        this.jgx.setConfig(cVar);
        this.jgx.setTextSize(R.dimen.tbds42);
        this.jgx.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.jgx.setOnClickListener(this.onClickListener);
        this.jgy = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0302, R.color.CAM_X0101);
        this.jgy.setConfig(bVar);
        this.jgy.setTextSize(R.dimen.tbds42);
        this.jgy.setText(tbPageContext.getString(R.string.go_to_share));
        this.jgy.setOnClickListener(this.onClickListener);
        this.jgz = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.jgz.setBackground(gradientDrawable);
        this.jgc = new b(tbPageContext);
        this.jgc.cDI();
        cDH();
        TiebaStatic.log(new aq("c13893").an("obj_source", (this.jgc.jgp == null || !this.jgc.jgp.equals("bazhu")) ? 2 : 1).dW("fid", this.jgc.fid).dW("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cDH() {
        this.jfZ.setText(this.jgc.nickName + ":");
        this.jga.setText(this.jgc.cDJ());
        this.jgb.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yS(int i) {
        TiebaStatic.log(new aq("c13892").an("obj_type", i).an("obj_source", (this.jgc.jgp == null || !this.jgc.jgp.equals("bazhu")) ? 2 : 1).dW("fid", this.jgc.fid).dW("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void B(View.OnClickListener onClickListener) {
        this.jfX = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.jfZ, R.color.CAM_X0101);
        ao.setViewTextColor(this.jga, R.color.CAM_X0101);
        ao.setViewTextColor(this.jgb, R.color.CAM_X0109);
    }
}
