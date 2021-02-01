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
    private View.OnClickListener jlE;
    private TextView jlG;
    private TextView jlH;
    private TextView jlI;
    private b jlJ;
    private TBSpecificationBtn jme;
    private TBSpecificationBtn jmf;
    private View jmg;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.jme.getId()) {
                if (c.this.context.getPageActivity() != null) {
                    c.this.context.getPageActivity().finish();
                }
                c.this.zc(2);
            } else if (view.getId() == c.this.jmf.getId()) {
                if (c.this.jlE != null) {
                    c.this.jlE.onClick(view);
                }
                c.this.zc(1);
            }
        }
    };
    private View rootView;

    public c(TbPageContext tbPageContext, View view) {
        this.context = tbPageContext;
        this.rootView = view;
        this.jlG = (TextView) view.findViewById(R.id.to_user_name);
        this.jlH = (TextView) view.findViewById(R.id.content);
        this.jlI = (TextView) view.findViewById(R.id.sender);
        this.jme = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pR(R.color.CAM_X0618);
        this.jme.setConfig(cVar);
        this.jme.setTextSize(R.dimen.tbds42);
        this.jme.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.jme.setOnClickListener(this.onClickListener);
        this.jmf = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.aY(R.color.CAM_X0302, R.color.CAM_X0101);
        this.jmf.setConfig(bVar);
        this.jmf.setTextSize(R.dimen.tbds42);
        this.jmf.setText(tbPageContext.getString(R.string.go_to_share));
        this.jmf.setOnClickListener(this.onClickListener);
        this.jmg = view.findViewById(R.id.bottom_layout);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.jmg.setBackground(gradientDrawable);
        this.jlJ = new b(tbPageContext);
        this.jlJ.cEU();
        cET();
        TiebaStatic.log(new ar("c13893").ap("obj_source", (this.jlJ.jlW == null || !this.jlJ.jlW.equals("bazhu")) ? 2 : 1).dR("fid", this.jlJ.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void setDisplay(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    private void cET() {
        this.jlG.setText(this.jlJ.nickName + ":");
        this.jlH.setText(this.jlJ.cEV());
        this.jlI.setText("百度贴吧\n" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zc(int i) {
        TiebaStatic.log(new ar("c13892").ap("obj_type", i).ap("obj_source", (this.jlJ.jlW == null || !this.jlJ.jlW.equals("bazhu")) ? 2 : 1).dR("fid", this.jlJ.fid).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void B(View.OnClickListener onClickListener) {
        this.jlE = onClickListener;
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.jlG, R.color.CAM_X0101);
        ap.setViewTextColor(this.jlH, R.color.CAM_X0101);
        ap.setViewTextColor(this.jlI, R.color.CAM_X0109);
    }
}
