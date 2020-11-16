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
/* loaded from: classes21.dex */
public class c {
    private TbPageContext context;
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.iNY.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.zH(2);
            } else if (view.getId() == c.this.iNZ.getId()) {
                if (c.this.iNy != null) {
                    c.this.iNy.onClick(view);
                }
                c.this.zH(1);
            }
        }
    };
    private TextView iNA;
    private TextView iNB;
    private TextView iNC;
    private b iND;
    private TBSpecificationBtn iNY;
    private TBSpecificationBtn iNZ;
    private View.OnClickListener iNy;
    private View iOa;
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.iNA = (TextView) view.findViewById(R.id.to_user_name);
        this.iNB = (TextView) view.findViewById(R.id.content);
        this.iNC = (TextView) view.findViewById(R.id.sender);
        this.iNY = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.qG(R.color.CAM_X0618);
        this.iNY.setConfig(cVar);
        this.iNY.setTextSize(R.dimen.tbds42);
        this.iNY.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.iNY.setOnClickListener(this.fhp);
        this.iNZ = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0302, R.color.CAM_X0101);
        this.iNZ.setConfig(bVar);
        this.iNZ.setTextSize(R.dimen.tbds42);
        this.iNZ.setText(tbPageContext.getString(R.string.go_to_share));
        this.iNZ.setOnClickListener(this.fhp);
        this.iOa = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.iOa.setBackground(gradientDrawable);
        this.iND = new b(tbPageContext);
        this.iND.cAn();
        cAm();
        TiebaStatic.log(new ar("c13893").ak("obj_source", (this.iND.iNQ == null || !this.iND.iNQ.equals("bazhu")) ? 2 : 1).dR("fid", this.iND.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cAm() {
        this.iNA.setText(this.iND.nickName + ":");
        this.iNB.setText(this.iND.cAo());
        this.iNC.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zH(int i) {
        TiebaStatic.log(new ar("c13892").ak("obj_type", i).ak("obj_source", (this.iND.iNQ == null || !this.iND.iNQ.equals("bazhu")) ? 2 : 1).dR("fid", this.iND.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void A(View.OnClickListener onClickListener) {
        this.iNy = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.iNA, R.color.CAM_X0101);
        ap.setViewTextColor(this.iNB, R.color.CAM_X0101);
        ap.setViewTextColor(this.iNC, R.color.CAM_X0109);
    }
}
