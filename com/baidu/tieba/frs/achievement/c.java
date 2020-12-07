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
/* loaded from: classes22.dex */
public class c {
    private TbPageContext context;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.iYP.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.Am(2);
            } else if (view.getId() == c.this.iYQ.getId()) {
                if (c.this.iYp != null) {
                    c.this.iYp.onClick(view);
                }
                c.this.Am(1);
            }
        }
    };
    private TBSpecificationBtn iYP;
    private TBSpecificationBtn iYQ;
    private View iYR;
    private View.OnClickListener iYp;
    private TextView iYr;
    private TextView iYs;
    private TextView iYt;
    private b iYu;
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.iYr = (TextView) view.findViewById(R.id.to_user_name);
        this.iYs = (TextView) view.findViewById(R.id.content);
        this.iYt = (TextView) view.findViewById(R.id.sender);
        this.iYP = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.rh(R.color.CAM_X0618);
        this.iYP.setConfig(cVar);
        this.iYP.setTextSize(R.dimen.tbds42);
        this.iYP.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.iYP.setOnClickListener(this.foP);
        this.iYQ = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bd(R.color.CAM_X0302, R.color.CAM_X0101);
        this.iYQ.setConfig(bVar);
        this.iYQ.setTextSize(R.dimen.tbds42);
        this.iYQ.setText(tbPageContext.getString(R.string.go_to_share));
        this.iYQ.setOnClickListener(this.foP);
        this.iYR = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.iYR.setBackground(gradientDrawable);
        this.iYu = new b(tbPageContext);
        this.iYu.cED();
        cEC();
        TiebaStatic.log(new ar("c13893").al("obj_source", (this.iYu.iYH == null || !this.iYu.iYH.equals("bazhu")) ? 2 : 1).dY("fid", this.iYu.fid).dY("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cEC() {
        this.iYr.setText(this.iYu.nickName + ":");
        this.iYs.setText(this.iYu.cEE());
        this.iYt.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Am(int i) {
        TiebaStatic.log(new ar("c13892").al("obj_type", i).al("obj_source", (this.iYu.iYH == null || !this.iYu.iYH.equals("bazhu")) ? 2 : 1).dY("fid", this.iYu.fid).dY("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void A(View.OnClickListener onClickListener) {
        this.iYp = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.iYr, R.color.CAM_X0101);
        ap.setViewTextColor(this.iYs, R.color.CAM_X0101);
        ap.setViewTextColor(this.iYt, R.color.CAM_X0109);
    }
}
