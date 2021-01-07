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
    private View.OnClickListener jkE;
    private TextView jkG;
    private TextView jkH;
    private TextView jkI;
    private b jkJ;
    private TBSpecificationBtn jle;
    private TBSpecificationBtn jlf;
    private View jlg;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.jle.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.Ay(2);
            } else if (view.getId() == c.this.jlf.getId()) {
                if (c.this.jkE != null) {
                    c.this.jkE.onClick(view);
                }
                c.this.Ay(1);
            }
        }
    };
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.jkG = (TextView) view.findViewById(R.id.to_user_name);
        this.jkH = (TextView) view.findViewById(R.id.content);
        this.jkI = (TextView) view.findViewById(R.id.sender);
        this.jle = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.rs(R.color.CAM_X0618);
        this.jle.setConfig(cVar);
        this.jle.setTextSize(R.dimen.tbds42);
        this.jle.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.jle.setOnClickListener(this.onClickListener);
        this.jlf = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0302, R.color.CAM_X0101);
        this.jlf.setConfig(bVar);
        this.jlf.setTextSize(R.dimen.tbds42);
        this.jlf.setText(tbPageContext.getString(R.string.go_to_share));
        this.jlf.setOnClickListener(this.onClickListener);
        this.jlg = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.jlg.setBackground(gradientDrawable);
        this.jkJ = new b(tbPageContext);
        this.jkJ.cHA();
        cHz();
        TiebaStatic.log(new aq("c13893").an("obj_source", (this.jkJ.jkW == null || !this.jkJ.jkW.equals("bazhu")) ? 2 : 1).dX("fid", this.jkJ.fid).dX("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cHz() {
        this.jkG.setText(this.jkJ.nickName + ":");
        this.jkH.setText(this.jkJ.cHB());
        this.jkI.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ay(int i) {
        TiebaStatic.log(new aq("c13892").an("obj_type", i).an("obj_source", (this.jkJ.jkW == null || !this.jkJ.jkW.equals("bazhu")) ? 2 : 1).dX("fid", this.jkJ.fid).dX("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void B(View.OnClickListener onClickListener) {
        this.jkE = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.jkG, R.color.CAM_X0101);
        ao.setViewTextColor(this.jkH, R.color.CAM_X0101);
        ao.setViewTextColor(this.jkI, R.color.CAM_X0109);
    }
}
